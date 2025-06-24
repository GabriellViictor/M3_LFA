public class Transition {
    public String currentState,currentSymbol,newState,newSymbol;
    public String direction;

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

}
