package Interface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Interface extends javax.swing.JFrame {

    public JPanel view = new JPanel();
    public JTextArea jtaFita = new JTextArea();

    public Interface() {
        initComponents();
    }

    private void initComponents() {
        // Componentes da interface
        jSPAutomato = new javax.swing.JScrollPane(view);
        jButtonPasso = new javax.swing.JButton();
        jButtonPassoAnterior = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane(jtaFita);
        jMenuBarTitulo = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();

        jMenuEntrada = new javax.swing.JMenu();

        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        // Configuração básica da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Máquina de Turing");

        // Painel principal (área de desenho)
        view.setBackground(Color.WHITE);
        view.setLayout(new FlowLayout(FlowLayout.CENTER));
        jSPAutomato.setViewportView(view);

        // Botões de controle
        jButtonPasso.setText("Próximo Passo");
        jButtonPassoAnterior.setText("Passo Anterior");
        jLabel1.setText("Fita da Máquina");

        // Área de texto da fita
        jtaFita.setEditable(false);
        jtaFita.setDisabledTextColor(new Color(0, 0, 51));
        jScrollPane5.setViewportView(jtaFita);

        // Menu Arquivo
        jMenuArquivo.setText("Arquivo");
        jMenuItemAbrir.setText("Abrir");
        jMenuArquivo.add(jMenuItemAbrir);
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemAbrir);


        // Adiciona menus à barra
        jMenuBarTitulo.add(jMenuArquivo);
        jMenuBarTitulo.add(jMenuEntrada);
        jMenuBarTitulo.add(jMenu2);
        jMenuBarTitulo.add(jMenu3);
        setJMenuBar(jMenuBarTitulo);

        // Layout da janela principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5)
                        .addComponent(jSPAutomato)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPasso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPassoAnterior)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jButtonPassoAnterior)
                                        .addComponent(jButtonPasso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSPAutomato, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Interface janela = new Interface();
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        });
    }

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                int character;
                while ((character = reader.read()) != -1) {
                    char c = (char) character;
                    // Processa cada caractere aqui
                    System.out.print(c); // Exemplo: imprime cada caractere
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao ler o arquivo: " + ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private javax.swing.JButton jButtonPasso;
    private javax.swing.JButton jButtonPassoAnterior;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBarTitulo;
    private javax.swing.JMenu jMenuEntrada;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JScrollPane jSPAutomato;
    private javax.swing.JScrollPane jScrollPane5;


}