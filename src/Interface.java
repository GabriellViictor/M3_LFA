import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class Interface extends javax.swing.JFrame {

    public JTextArea jtaFita = new JTextArea();
    public JTextArea jtaOutput = new JTextArea();
    public String output = "";

    public Interface() {
        initComponents();
    }

    private void initComponents() {
        // Componentes da interface
        jButtonPasso = new javax.swing.JButton();
        jButtonPassoAnterior = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPaneJtaFita = new javax.swing.JScrollPane(jtaFita);
        jSPAutomato = new javax.swing.JScrollPane(jtaOutput);
        jMenuBarTitulo = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Máquina de Turing");

        jButtonPasso.setText("Próximo Passo");
        jButtonPasso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {jButtonPassoActionPerformed(evt);}
        });

        jButtonPassoAnterior.setText("Passo Anterior");
        jButtonPassoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {jButtonPassoAnteriorActionPerformed(evt);}
        });

        jLabel1.setText("Fita da Máquina");

        jtaFita.setEditable(false);
        jtaFita.setDisabledTextColor(new Color(0, 0, 51));
        jtaFita.setText("Insira o programa de transição para iniciar...");
        jScrollPaneJtaFita.setViewportView(jtaFita);

        jtaOutput.setEditable(false);
        jtaOutput.setDisabledTextColor(new Color(0, 0, 0));
        jtaOutput.setText("");
        jSPAutomato.setViewportView(jtaOutput);

        jMenuArquivo.setText("Arquivo");
        jMenuItemAbrir.setText("Programa de transição...");
        jMenuArquivo.add(jMenuItemAbrir);
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemAbrir);


        jMenuBarTitulo.add(jMenuArquivo);
        setJMenuBar(jMenuBarTitulo);

        // Layout da janela principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPaneJtaFita)
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
                                .addComponent(jScrollPaneJtaFita, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButtonPassoActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO
        System.out.println("Proximo Passo");
        output += "Proximo\n";
        jtaOutput.setText(output);
    }

    private void jButtonPassoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO
        System.out.println("Passo Anterior");
    }

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String transicao = readfile(selectedFile);
            Turing turing = new Turing();
            turing.setTransicao(transicao);
            System.out.println(turing.getTransicao());
            jtaFita.setEditable(true);
            jtaFita.setDisabledTextColor(new Color(0, 0, 0));
            jtaFita.setText("");
            //TODO
        }
    }

    private String readfile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int character;
            StringBuilder texto = new StringBuilder();
            while ((character = reader.read()) != -1) {
                char c = (char) character;
                // Processa cada caractere aqui
                System.out.print(c); // Exemplo: imprime cada caractere
                texto.append(c);
            }
            return texto.toString();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao ler o arquivo: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private javax.swing.JButton jButtonPasso;
    private javax.swing.JButton jButtonPassoAnterior;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBarTitulo;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JScrollPane jSPAutomato;
    private javax.swing.JScrollPane jScrollPaneJtaFita;

}