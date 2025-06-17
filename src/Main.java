import Interface.Interface;

public class Main {
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Interface janela = new Interface();
            janela.setLocationRelativeTo(null); // Centraliza a janela
            janela.setVisible(true); // Torna a janela visível
        });
    }
}


