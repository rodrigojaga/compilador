/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package analizador;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;


/**
 *
 * @author rodri
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
    }
/*
    private void analizarLexico() throws IOException{
        int cont = 1;

        String expr = (String) txtLexDe.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtLexIzq.setText(resultado);
                return;
            }
            switch (token) {
                case Int:
                    resultado += "  <Tipo de dato Int>\t\t" + lexer.lexeme + "\n";
                    break;
                case Float:
                    resultado += "  <Tipo de dato Float>\t\t" + lexer.lexeme + "\n";
                    break;
                case Boolean:
                    resultado += "  <Tipo de dato Boolean>\t" + lexer.lexeme + "\n";
                    break;
                case Char:
                    resultado += "  <Tipo de dato Char>\t\t" + lexer.lexeme + "\n";
                    break;
                case StringType:
                    resultado += "  <Tipo de dato StringType>\t" + lexer.lexeme + "\n";
                    break;
                case Double:
                    resultado += "  <Tipo de dato Double>\t" + lexer.lexeme + "\n";
                    break;
                case ObjectType:
                    resultado += "  <Tipo de dato ObjectType>\t" + lexer.lexeme + "\n";
                    break;
                case Public:
                    resultado += "  <Palabra reservada Public>\t" + lexer.lexeme + "\n";
                    break;
                case Static:
                    resultado += "  <Palabra reservada Static>\t" + lexer.lexeme + "\n";
                    break;
                case Void:
                    resultado += "  <Palabra reservada Void>\t" + lexer.lexeme + "\n";
                    break;
                case Private:
                    resultado += "  <Palabra reservada Private>\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += "  <Palabra reservada If>\t\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += "  <Palabra reservada Else>\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "  <Palabra reservada While>\t" + lexer.lexeme + "\n";
                    break;
                case For:
                    resultado += "  <Palabra reservada For>\t\t" + lexer.lexeme + "\n";
                    break;
                case Protect:
                    resultado += "  <Palabra reservada Protect>\t" + lexer.lexeme + "\n";
                    break;
                case Default:
                    resultado += "  <Palabra reservada Default>\t" + lexer.lexeme + "\n";
                    break;
                case Interface:
                    resultado += "  <Palabra reservada Interface>\t" + lexer.lexeme + "\n";
                    break;
                case Return:
                    resultado += "  <Palabra reservada Return>\t" + lexer.lexeme + "\n";
                    break;

                case Igual:
                    resultado += "  <Operador Igual>\t\t" + lexer.lexeme + "\n";
                    break;
                case ExactamenteIgual:
                    resultado += "  <Operador ExactamenteIgual>\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador Suma>\t\t" + lexer.lexeme + "\n";
                    break;
                case SumaIgual:
                    resultado += "  <Operador SumaIgual>\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador Resta>\t\t" + lexer.lexeme + "\n";
                    break;
                case RestaIgual:
                    resultado += "  <Operador RestaIgual>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador Multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case MultiplicacionIgual:
                    resultado += "  <Operador MultiplicacionIgual>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "  <Operador Division>\t\t" + lexer.lexeme + "\n";
                    break;
                case DivisionIgual:
                    resultado += "  <Operador DivisionIgual>\t" + lexer.lexeme + "\n";
                    break;

                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case Comentario:
                    resultado += "  <Comentario>\t\t" + lexer.lexeme + "\n";
                    break;
                case Cadena:
                    resultado += "  <Cadena>\t\t" + lexer.lexeme + "\n";
                    break;
                case ParentesisCierra:
                    resultado += "  <ParentesisCierra>\t" + lexer.lexeme + "\n";
                    break;
                case ParentesisAbre:
                    resultado += "  <ParentesisAbre>\t\t" + lexer.lexeme + "\n";
                    break;
                case LlaveCierra:
                    resultado += "  <LlaveCierra>\t\t" + lexer.lexeme + "\n";
                    break;
                case LlaveAbre:
                    resultado += "  <LlaveAbre>\t\t" + lexer.lexeme + "\n";
                    break;
                case PuntoComa:
                    resultado += "  <PuntoComa>\t\t" + lexer.lexeme + "\n";
                    break;
                case SaltoLinea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;

                case ERROR:
                    resultado += "  <ERROR>\t\t" + lexer.lexeme + "\n";
                    break;

                default:
                    resultado += "  <Token desconocido>\t" + lexer.lexeme + "\n";
                    break;
            }

        }
    }
    */
    
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtLexDe.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtLexIzq.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case Int:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case Doub:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case For:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    break;
                case Op_logico:
                    resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexer.lexeme + "\n";
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLexDe = new javax.swing.JTextArea();
        btnAbrirArchivo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLexIzq = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalisisSin = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        txtLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("ANALIZADOR LEXICO"));

        txtLexDe.setColumns(20);
        txtLexDe.setRows(5);
        jScrollPane1.setViewportView(txtLexDe);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        btnAbrirArchivo.setText("ABRIR ARCHIVO");
        btnAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArchivoActionPerformed(evt);
            }
        });

        txtLexIzq.setEditable(false);
        txtLexIzq.setColumns(20);
        txtLexIzq.setRows(5);
        jScrollPane2.setViewportView(txtLexIzq);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jButton2.setText("ANALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAbrirArchivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(164, 164, 164)
                        .addComponent(jButton3)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrirArchivo)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("ANALIZADOR SINTACTICO"));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        txtAnalisisSin.setEditable(false);
        txtAnalisisSin.setColumns(20);
        txtAnalisisSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalisisSin);

        jButton1.setText("ANALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtLimpiar.setText("LIMPIAR");
        txtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLimpiar)
                        .addGap(14, 14, 14)))
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try{
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtLexDe.setText(ST);
        }catch (Exception ex){
            ex.getMessage();
        }
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtLexIzq.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ST = txtLexDe.getText();
        Sintax s = new Sintax(new analizador.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtAnalisisSin.setText("Analisis realizado correctamente");
            txtAnalisisSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalisisSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalisisSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimpiarActionPerformed
        txtAnalisisSin.setText(null);
    }//GEN-LAST:event_txtLimpiarActionPerformed

    
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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    private String obtenerTexto(String ruta){
        leerArchivo la = new leerArchivo();
        return la.leerTXT(ruta);        
    }
    
    private String contarPalabras(String ruta){
        leerArchivo la = new leerArchivo();
        return la.analizarTokens(ruta);        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirArchivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalisisSin;
    private javax.swing.JTextArea txtLexDe;
    private javax.swing.JTextArea txtLexIzq;
    private javax.swing.JButton txtLimpiar;
    // End of variables declaration//GEN-END:variables
}
