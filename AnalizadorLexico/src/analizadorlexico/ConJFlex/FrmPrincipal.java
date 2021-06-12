package analizadorlexico.ConJFlex;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmPrincipal extends javax.swing.JFrame {

    ArrayList<String> PalabrasReservadas = new ArrayList<String>();
    ArrayList<String> Caracteres = new ArrayList<String>();
    private DefaultTableModel dtm;

    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        dtm = (DefaultTableModel) Tabla.getModel();
        Carga_Reservadas();
        Carga_Especiales();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        btnAnalizar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BBuscarArchivo = new javax.swing.JButton();
        ruta1 = new javax.swing.JLabel();
        ruta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAnalizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema"
            }
        ));
        jScrollPane2.setViewportView(Tabla);

        txtEntrada.setColumns(20);
        txtEntrada.setRows(5);
        jScrollPane1.setViewportView(txtEntrada);

        btnAnalizar1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizar1.setText("LIMPIAR");
        btnAnalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizar1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 102));
        jLabel1.setText("CODIGO A ANALIZAR   -> Con JFlex");

        BBuscarArchivo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BBuscarArchivo.setText("BUSCAR ARCHIVO");
        BBuscarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscarArchivoActionPerformed(evt);
            }
        });

        ruta1.setText("RUTA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAnalizar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BBuscarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(ruta1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269)))
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnalizar)
                        .addGap(5, 5, 5)
                        .addComponent(btnAnalizar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BBuscarArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ruta1)
                        .addGap(1, 1, 1)
                        .addComponent(ruta))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
void Carga_Reservadas() {

        try {
            File myObj = new File("C:/SUGEIRI/utesa/C22021/COMPILADORES/compiladores/AnalizadorLexico/src/analizadorlexico/reservadas.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                PalabrasReservadas.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    void Carga_Especiales() {

        try {
            File myObj = new File("C:/SUGEIRI/utesa/C22021/COMPILADORES/compiladores/AnalizadorLexico/src/analizadorlexico/Caracteres.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Caracteres.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        dtm.getDataVector().removeAllElements();
        dtm.setRowCount(0);

        // TODO add your handling code here:
        File archivo = new File("archivo.txt");
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(txtEntrada.getText());
            escribir.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexer lexer = new Lexer(lector);
            // String resultado = "";
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    return;
                }
                switch (tokens) {
                    case ERROR:
//                        
                        if (Valida_NoDefinido(lexer.lexeme)) {
                            Llenar_Tabla("Caracter Especial", lexer.lexeme);
                        } else {
                            Llenar_Tabla(tokens.name().toString(), "No Definido");

                        }
                        //
                        break;
                    case Numero:
                        Llenar_Tabla(tokens.name().toString(), lexer.lexeme);
                    case Identificador:
                    case Reservadas:
                        if (Valida_Palabra_Reservada(lexer.lexeme)) {
                            Llenar_Tabla("Reservada", lexer.lexeme);
                        } else {
                            Llenar_Tabla("Identificador", lexer.lexeme);
                        }
                        break;
                    default:
                        Llenar_Tabla(tokens.name().toString(), lexer.yytext());
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private boolean Valida_Palabra_Reservada(String ii_lexema) {
        for (int i = 0; i < PalabrasReservadas.size(); i++) {
            if (ii_lexema.toString().trim().toLowerCase().equalsIgnoreCase(PalabrasReservadas.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean Valida_NoDefinido(String ii_lexema) {
        for (int i = 0; i < Caracteres.size(); i++) {
            if (ii_lexema.toString().trim().toLowerCase().equalsIgnoreCase(Caracteres.get(i))) {
                return true;
            }
        }
        return false;
    }
    private void btnAnalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizar1ActionPerformed
        // TODO add your handling code here:
        txtEntrada.setText("");
        dtm.getDataVector().removeAllElements();
        dtm.setRowCount(0);
        dtm.fireTableDataChanged();
        ruta.setText("");
    }//GEN-LAST:event_btnAnalizar1ActionPerformed

    private void BBuscarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int seleccion = fc.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            ruta.setText(fichero.getAbsolutePath());
        }
        try {
            File text = new File(ruta.getText());
            byte[] bytes = Files.readAllBytes(Paths.get(ruta.getText()));
            String texto = new String(bytes, StandardCharsets.UTF_8);
            txtEntrada.setText(texto);
        } catch (Exception ex) {
            ex.toString();
        }


    }//GEN-LAST:event_BBuscarArchivoActionPerformed

    void Llenar_Tabla(String Token, String Lexema) {

        try {
            dtm.addRow(new Object[]{Token, Lexema});
            dtm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.toString();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBuscarArchivo;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAnalizar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel ruta;
    private javax.swing.JLabel ruta1;
    private javax.swing.JTextArea txtEntrada;
    // End of variables declaration//GEN-END:variables
}
