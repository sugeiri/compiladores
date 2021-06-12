package analizadorlexico.ModeloPropio;

import analizadorlexico.ConJFlex.FrmPrincipal;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Analizador extends javax.swing.JFrame {

    static ArrayList<String> PalabrasReservadas = new ArrayList<String>();
    static ArrayList<String> Caracteres = new ArrayList<String>();

    static private DefaultTableModel dtm;
    static FileInputStream keyboard;

    static int charClass;

    static char lexeme[] = new char[100]; //stores char of lexemes

    static char nextChar;

    static int lexLen;// length of lexeme

    static int token;

    static int nextToken;

    static String SToken;

    // Token numbers
    static final int LETTER = 0;

    static final int DIGIT = 1;

    static final int UNKNOWN = 99;

    static final int INT_LIT = 10;

    static final int IDENT = 11;

    static final int ASSIGN_OP = 21;
    static final int OPMAT = 22;
    static final int AGRUPADOR = 23;
    static final int IGUAL = 24;
    static final int PuntoYComa = 25;
    static final int RESERVADA = 26;
    static final int OpLogico = 27;
    static final int CaracterEsp = 28;

    public Analizador() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        dtm = (DefaultTableModel) Tabla.getModel();
        PalabrasReservadas = new ArrayList<String>();
        Caracteres = new ArrayList<String>();

        Carga_Reservadas();
        Carga_Especiales();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BAnalizar = new javax.swing.JButton();
        BLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        BBuscarArchivo = new javax.swing.JButton();
        ruta = new javax.swing.JLabel();
        ruta1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 102));
        jLabel1.setText("CODIGO A ANALIZAR");

        BAnalizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BAnalizar.setText("Analizar");
        BAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAnalizarActionPerformed(evt);
            }
        });

        BLimpiar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BLimpiar.setText("LIMPIAR");
        BLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLimpiarActionPerformed(evt);
            }
        });

        txtEntrada.setColumns(20);
        txtEntrada.setRows(5);
        jScrollPane1.setViewportView(txtEntrada);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema"
            }
        ));
        jScrollPane2.setViewportView(Tabla);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                .addComponent(BLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                .addComponent(BBuscarArchivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                .addComponent(ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ruta1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BAnalizar)
                        .addGap(5, 5, 5)
                        .addComponent(BLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BBuscarArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ruta1)
                        .addGap(1, 1, 1)
                        .addComponent(ruta))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAnalizarActionPerformed
        dtm.getDataVector().removeAllElements();
        dtm.setRowCount(0);

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
            keyboard = new FileInputStream(archivo);

            getChar();

            do {

                lex();

            } while (keyboard.available() > 0);

            charClass = -1; // reset the character class

            lex();

        } catch (Exception e) {

            System.out.println("No Pudo Abrir el Archivo");

        }


    }//GEN-LAST:event_BAnalizarActionPerformed
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

    private void BLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLimpiarActionPerformed
        // TODO add your handling code here:
        txtEntrada.setText("");
        dtm.getDataVector().removeAllElements();
        dtm.setRowCount(0);
        dtm.fireTableDataChanged();
    }//GEN-LAST:event_BLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analizador().setVisible(true);
            }
        });
    }

    public static int lookup(char ch) {

        switch (ch) {

            case '(':
                addChar();

                nextToken = AGRUPADOR;
                SToken = "Parentesis";

                break;
            case ')':
                addChar();

                nextToken = AGRUPADOR;
                SToken = "Parentesis";

                break;
            case '[':
                addChar();

                nextToken = AGRUPADOR;
                SToken = "Corchete";

                break;
            case ']':
                addChar();

                nextToken = AGRUPADOR;
                SToken = "Corchete";

                break;
            case '{':
                addChar();

                nextToken = AGRUPADOR;
                SToken = "Llave";

                break;
            case '}':

                addChar();

                nextToken = AGRUPADOR;
                SToken = "Llave";

                break;

            case '+':
                addChar();

                nextToken = OPMAT;
                SToken = "Suma";

                break;
            case '-':
                addChar();

                nextToken = OPMAT;
                SToken = "Resta";

                break;
            case '*':
                addChar();

                nextToken = OPMAT;
                SToken = "Asterisco/Multiplicador";

                break;
            case '/':
                addChar();

                nextToken = OPMAT;
                SToken = "Slash/Division";

                break;
            case '%':
                addChar();

                nextToken = OPMAT;
                SToken = "Porciento";

                break;
            case '^':
                addChar();
                nextToken = OPMAT;
                SToken = "Caracter Especial";

                break;
            case '=':

                addChar();

                nextToken = IGUAL;
                SToken = "Signo Igual";

                break;
            case ';':
                addChar();

                nextToken = PuntoYComa;
                SToken = "Finalizador";
                break;
            case '>':
                addChar();

                nextToken = OpLogico;
                SToken = "Mayor Que";

                break;
            case '<':
                addChar();

                nextToken = OpLogico;
                SToken = "Menor Que";

                break;
            case '&':
                addChar();

                nextToken = CaracterEsp;
                SToken = "Y/Concatenacion/Caracter Especial";

                break;
            case '#':
                addChar();

                nextToken = CaracterEsp;
                SToken = "Comentario";

                break;

            default:

                addChar();

                nextToken = -1;

                break;

        }

        return nextToken;

    }

    public static void addChar() {

        if (lexLen <= 98) { // a max length of 98

            lexeme[lexLen++] = nextChar; // storing the char in lexeme array

            lexeme[lexLen] = 0;//append lexeme with a zero

        } else {

            System.out.println("Error - lexeme is too long \n");

        }

    }

    public static void getChar() throws IOException {

        if ((nextChar = (char) keyboard.read()) != -1) {

            if (Character.isLetter(nextChar)) {
                charClass = LETTER;
            } else if (Character.isDigit(nextChar)) {
                charClass = DIGIT;
            } else {
                charClass = UNKNOWN;
            }

        } else {
            charClass = -1;
        }

    }

    public static void getNonBlank() throws IOException {

        while (Character.isSpace(nextChar)) { //skip the white spaces

            getChar();

        }

    }

    public static int lex() throws IOException {

        lexLen = 0;

        getNonBlank();

        switch (charClass) {

            case LETTER:

                addChar(); // add the char to lexeme array

                getChar(); // get the next char

                while (charClass == LETTER || charClass == DIGIT) {

                    addChar();

                    getChar();

                }

                nextToken = IDENT; //spit the final token of the stored lexeme array
                SToken = "Identificador";
                break;

            case DIGIT:

                addChar();

                getChar();

                while (charClass == DIGIT) {

                    addChar();

                    getChar();

                }

                nextToken = INT_LIT;//spit the final token of the stored lexeme array
                SToken = "Numero";
                break;

            case UNKNOWN:

                lookup(nextChar); //look up in the lookup table

                getChar();

                break;

            case -1:

                nextToken = -1;

                lexeme[0] = 'E';

                lexeme[1] = 'O';

                lexeme[2] = 'F';

                lexeme[3] = 0;

                break;

        }

        //System.out.printf("Next token is: %d, Next lexeme is ", nextToken);
        String ii_lexema = "";
        for (char n : lexeme) {

            if (n == 0) {

                break;

            }

            System.out.print(n);
            ii_lexema += n;

        }

        if (nextToken == IDENT && Valida_Palabra_Reservada(ii_lexema)){
                Llenar_Tabla("Reservada", ii_lexema);
                return nextToken;
            
        } 
        if (nextToken == IDENT && Valida_NoDefinido(ii_lexema)){ 
            Llenar_Tabla("Caracter Especial", ii_lexema);
            return nextToken;
        }
        if(nextToken ==-1 && Valida_NoDefinido(ii_lexema))
        {
            Llenar_Tabla("Caracter Especial", ii_lexema);
            return nextToken;
        }
        
        Llenar_Tabla(SToken, ii_lexema);
        
        //System.out.println();

        return nextToken;

    }

    static boolean Valida_Palabra_Reservada(String ii_lexema) {
        for (int i = 0; i < PalabrasReservadas.size(); i++) {
            if (ii_lexema.toString().trim().toLowerCase().equalsIgnoreCase(PalabrasReservadas.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    static boolean Valida_NoDefinido(String ii_lexema) {
        for (int i = 0; i < Caracteres.size(); i++) {
            if (ii_lexema.toString().trim().toLowerCase().equalsIgnoreCase(Caracteres.get(i))) {
                return true;
            }
        }
        return false;
    }

    static void Llenar_Tabla(String Token, String Lexema) {

        try {
            dtm.addRow(new Object[]{Token, Lexema});
            dtm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.toString();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAnalizar;
    private javax.swing.JButton BBuscarArchivo;
    private javax.swing.JButton BLimpiar;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel ruta;
    private javax.swing.JLabel ruta1;
    private javax.swing.JTextArea txtEntrada;
    // End of variables declaration//GEN-END:variables
}
