import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;


public class Transition {
    private String currentState,currentSymbol,newState,newSymbol;
    private String direction;

    public Transition(String currentState, String currentSymbol, String newState, String newSymbol, String direction ) {
        this.currentState = currentState;
        this.currentSymbol = currentSymbol;
        this.newState = newState;
        this.newSymbol = newSymbol;
        this.direction = direction;
    }

    public String saida() {
        return "(" + currentState + ", " + currentSymbol + ") ➡ (" + newState + ", " + newSymbol + ", " + direction + ")";
    }


    public static String loadTransitions(String filePath) throws IOException {
        List<Transition> transitions = new ArrayList<>();
        String initialState = "";
        String finalState = "";

        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (int i = 0; i < lines.size() - 1; i++) {
            String[] parts = lines.get(i).trim().split(",\\s*");
            if (parts.length == 5) {
                transitions.add(new Transition(parts[0], parts[1], parts[2], parts[3], parts[4]));
            }
        }

        if (!lines.isEmpty()) {
            String[] lastLine = lines.get(lines.size() - 1).trim().split(",\\s*");
            if (lastLine.length == 2) {
                initialState = lastLine[0];
                finalState = lastLine[1];
            }
        }

        // Agora monta a string para exibir
        StringBuilder result = new StringBuilder();
        result.append("Estado inicial: ").append(initialState).append("\n");
        result.append("Estado final: ").append(finalState).append("\n");
        result.append("Transições:\n");
        for (Transition t : transitions) {
            result.append(t.saida()).append("\n");
        }

        return result.toString();
    }
}
