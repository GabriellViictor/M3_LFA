public class Turing {
    private String alfabeto;
    private String[] estados;
    private String transicao;
    private String q0 = "q0";
    private String[] estadosFinais;
    private String alfabetoAuxiliar = "";
    private char branco = 'B';
    private char inicio = 'δ';
    private char sentidoCabeca;

    public String saida(){
        //TODO
        return null;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String[] getEstados() {
        return estados;
    }

    public void setEstados(String[] estados) {
        this.estados = estados;
    }

    public String getTransicao() {
        return transicao;
    }

    public void setTransicao(String transicao) {
        this.transicao = transicao;
    }

    public String getQ0() {
        return q0;
    }

    public void setQ0(String q0) {
        this.q0 = q0;
    }

    public String[] getEstadosFinais() {
        return estadosFinais;
    }

    public void setEstadosFinais(String[] estadosFinais) {
        this.estadosFinais = estadosFinais;
    }

    public String getAlfabetoAuxiliar() {
        return alfabetoAuxiliar;
    }

    public void setAlfabetoAuxiliar(String alfabetoAuxiliar) {
        this.alfabetoAuxiliar = alfabetoAuxiliar;
    }

    public char getBranco() {
        return branco;
    }

    public void setBranco(char branco) {
        this.branco = branco;
    }

    public char getInicio() {
        return inicio;
    }

    public void setInicio(char inicio) {
        this.inicio = inicio;
    }

    public char getSentidoCabeca() {
        return sentidoCabeca;
    }

    public void setSentidoCabeca(char sentidoCabeca) {
        this.sentidoCabeca = sentidoCabeca;
    }
}
