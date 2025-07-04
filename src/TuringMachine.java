import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;


public class TuringMachine {
    private static String startSymbol="$",endSymbol="x";
    private List<Character> alphabet = new ArrayList<>();
    private List<Transition> transitions = new ArrayList<>();
    private String initialState = "";
    private ArrayList<String> finalStates = new ArrayList<>();
    private String sentence = "";
    private StringBuilder stepsField = new StringBuilder();
    private String resultLabel = "";

    public TuringMachine(){}

    public void setSentence(String sentence) {
        this.sentence = startSymbol+sentence+endSymbol;
    }


    public Boolean isValidTape(String tape){
        for(int i=0; i<tape.length();i++){
            if(!alphabet.contains(tape.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public String verifyTransitions(String tape){
        String output = "";
        if(isValidTape(tape)){
            setSentence(tape);
            runTuringMachine();
            output = "Passo     | Estado atual |       Simbolo lido       |     Sentido     |  Fita\n"
                    + stepsField.toString()+"\n"+resultLabel;
            stepsField.setLength(0);
            return output;

        }
        return "invalid tape";
    }

    public String loadTransitions(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        transitions.clear();
        alphabet.clear();
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] parts = lines.get(i).trim().split(",\\s*");
            if (parts.length == 5) {
                transitions.add(new Transition(parts[0], parts[1], parts[2], parts[3], parts[4]));
                if(!alphabet.contains(parts[1].charAt(0)) && !parts[1].equals(startSymbol) && !parts[1].equals(endSymbol))
                    alphabet.add(parts[1].charAt(0));
            }
        }
        if (!lines.isEmpty()) {
            String[] lastLine = lines.get(lines.size() - 1).trim().split(",\\s*");
            if (lastLine.length >= 2) {
                initialState = lastLine[0];
                ArrayList<String> estadosFinais = new ArrayList<>(); // placeholder pra sobrescrever os estados finais do outro arquivo
                for(int i = 1; i< lastLine.length; i++) {
                    estadosFinais.add(lastLine[i]);
                }
                finalStates = estadosFinais; // se nao fizer assim, os estados finais vao se somando a cada vez que carregar um arquivo novo
            }
        }

        // Agora monta a string para exibir
        StringBuilder result = new StringBuilder();
        result.append("Simbolo inicial: ").append(startSymbol).append("\n");
        result.append("Simbolo final: ").append(endSymbol).append("\n");
        result.append("Alfabeto: ").append(alphabet).append("\n");
        result.append("Estado inicial: ").append(initialState).append("\n");
        result.append(finalStates.size()<2?"Estado Final: ":"Estados finais: ").append(finalStates).append("\n");
        result.append("Transições:\n");
        for (Transition t : transitions) {
            result.append(t.saida()).append("\n");
        }

        return result.toString();
    }

    public void runTuringMachine() {
        String currentState = initialState;
        ArrayList<Character> tape = new ArrayList<>();

        for (char c : sentence.toCharArray()) {
            tape.add(c);
        }

        int head = 0;
        int step = 1;

        while (true) {
            char currentSymbol = (head < tape.size()) ? tape.get(head) : 'x';
            System.out.println("simbolo atual: "+currentSymbol);
            Transition transitionFound = null;
            for (Transition t : transitions) {
                if (t.currentState.equals(currentState) && t.currentSymbol.charAt(0) == currentSymbol) { // t.currentSymbol.charAt(0) == currentSymbol
                    transitionFound = t;
                    break;
                }
            }
            String firstSpace = "   ";
            if (step>9)
                firstSpace = " ";
            if (step > 99)
                firstSpace = "";

            if (transitionFound == null) {
                resultLabel = "❌ Sentença Rejeitada! ❌";
                break;
            }

            stepsField.append(firstSpace+step + "                    " + currentState +
                    "                         " + currentSymbol + "                   " +transitionFound.direction+
                    "           " + tapeToString(tape) + "\n");

            // Aplica a transição
            tape.set(head, transitionFound.newSymbol.charAt(0));
            currentState = transitionFound.newState;
            step++;

            if (transitionFound.direction.equals("D")) {
                head++;
                if (head >= tape.size()) {
                    tape.add('x');
                }
            } else if (transitionFound.direction.equals("E")) {
                head--;
                if (head < 0) {
                    tape.add(0, 'x');
                    head = 0;
                }
            }

            if (finalStates.contains(currentState)) {
                stepsField.append(firstSpace+step + "                    " + currentState +
                        "                         " + currentSymbol + "                   " +transitionFound.direction+
                        "           " + tapeToString(tape) + "\n");
                resultLabel = "Sentença Aceita! ✅";
                break;
            }
        }
    }


    private String tapeToString(ArrayList<Character> tape) {
        StringBuilder sb = new StringBuilder();
        for (char c : tape) {
            sb.append(c);
        }
        return sb.toString();
    }
}
