import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.*;

public class Interface extends javax.swing.JFrame {

    private static final int H = 800;
    private static final int W = 1100;
    private static final Font LABEL_FONT = new Font("SansSerif", Font.BOLD, 24);
    private static final Font TEXT_FONT = new Font("SansSerif", Font.PLAIN, 20);
    private static final Font BUTTON_FONT = new Font("SansSerif", Font.PLAIN, 22);
    private static final Font MENU_FONT = new Font("SansSerif", Font.BOLD, 18);
    private static final Color DISABLED_COLOR = new Color(150, 150, 150);
    private static final Color ENABLED_COLOR = new Color(0, 0, 0);


    public JTextArea jtaFita = new JTextArea();
    public JTextArea jtaOutput = new JTextArea();
    public String output = "";

    public Interface() {
        initComponents();
    }

    private void initComponents() {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // fallback se Nimbus não estiver disponível
        }

        jButtonRun = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPaneJtaFita = new javax.swing.JScrollPane(jtaFita);
        jSPAutomato = new javax.swing.JScrollPane(jtaOutput);
        jMenuBarTitulo = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Máquina de Turing");
        setPreferredSize(new Dimension(W, H));
        pack();
        setMinimumSize(new Dimension(W, H));

        jButtonRun.setText("✨ Analisar");
        jButtonRun.setFont(BUTTON_FONT);
        jButtonRun.setEnabled(false);
        jButtonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {jButtonRunActionPerformed(evt);}
        });

        jButtonReset.setText("❌ Limpar");
        jButtonReset.setEnabled(false);
        jButtonReset.setFont(BUTTON_FONT);
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {jButtonResetActionPerformed(evt);}
        });

        jLabel1.setText("Fita da Máquina:");
        jLabel1.setFont(LABEL_FONT);

        jtaFita.setEditable(false);
        jtaFita.setDisabledTextColor(DISABLED_COLOR);
        jtaFita.setText("Insira o programa de transição para iniciar...");
        jtaFita.setFont(TEXT_FONT);
        jScrollPaneJtaFita.setViewportView(jtaFita);

        jtaOutput.setEditable(false);
        jtaOutput.setDisabledTextColor(new Color(0, 0, 0));
        jtaOutput.setText("");
        jtaOutput.setFont(TEXT_FONT);
        jSPAutomato.setViewportView(jtaOutput);

        jMenuArquivo.setText("Arquivo");
        jMenuArquivo.setFont(MENU_FONT);
        jMenuItemAbrir.setText("Abrir Programa...");
        jMenuItemAbrir.setFont(MENU_FONT);
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
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRun)
                                .addComponent(jButtonReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jButtonRun)
                                        .addComponent(jButtonReset))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneJtaFita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSPAutomato, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
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

    private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO
        System.out.println("Proximo Passo");
        output += "Proximo\n";
        jtaOutput.setText(output);
    }
    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("RESET CALL");
        controlUI(false);
        output = "";
        jtaOutput.setText(output);
    }

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO !!!!!!!!!!!!!!!!!!!!!!
        JFileChooser fileChooser = new JFileChooser(new java.io.File("resources"));
        fileChooser.setPreferredSize(new Dimension(800, 600));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Selecione o Programa");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Texto (*.txt)", "txt");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile.getPath().endsWith(".txt")) {
                try {
                    String transicao = Transition.loadTransitions(selectedFile.getPath());
                    output += "------------- FUNÇÃO DE TRANSIÇÃO CARREGADA -------------\n"+transicao;
                    jtaOutput.setText(output);
                    controlUI(true);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                errorDialog("Arquivo deve ser do tipo TXT");
            }

        }
    }

    private void controlUI(boolean enabled) {
        if(enabled) {
            jtaFita.setEditable(true);
            jtaFita.setDisabledTextColor(ENABLED_COLOR);
            jtaFita.setText("");
            jButtonRun.setEnabled(true);
            jButtonReset.setEnabled(true);
        }else{
            jtaFita.setEditable(false);
            jtaFita.setDisabledTextColor(DISABLED_COLOR);
            jtaFita.setText("Insira o programa de transição para iniciar...");
            jButtonReset.setEnabled(false);
            jButtonRun.setEnabled(false);
        }

    }

    private void errorDialog(String msg) {
        JOptionPane.showMessageDialog(
                null,
                msg,
                "Erro",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private String loadTransition(File file) {
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



    private javax.swing.JButton jButtonRun;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBarTitulo;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JScrollPane jSPAutomato;
    private javax.swing.JScrollPane jScrollPaneJtaFita;

}