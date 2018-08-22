/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;

/**
 *
 * @author dimut
 */
public class PanelUg extends javax.swing.JPanel {

    private static PanelUg panelUg;

    /**
     * Creates new form PanelUg
     */
    private PanelUg() {
        initComponents();
        setSize(2220, 300);
    }

    public static PanelUg getInstance() {
        if (panelUg == null) {
            panelUg = new PanelUg();
        }
        return panelUg;
    }
    
    public void setInitialStage() {
        clearFields();
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaResults = new javax.swing.JTextArea();
        txtIRank = new javax.swing.JTextField();
        txtYearOfAl = new javax.swing.JTextField();
        txtschool = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel15.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel15.setText("SCHOOL");
        add(jLabel15);
        jLabel15.setBounds(20, 40, 160, 40);

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel9.setText("YEAR OF A/L");
        add(jLabel9);
        jLabel9.setBounds(20, 240, 160, 40);

        jLabel16.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel16.setText("Z-SCORE");
        add(jLabel16);
        jLabel16.setBounds(20, 140, 160, 40);

        jLabel14.setFont(new java.awt.Font("Bookman Old Style", 1, 22)); // NOI18N
        jLabel14.setText("A/L RESULTS");
        add(jLabel14);
        jLabel14.setBounds(930, 30, 160, 40);

        txtareaResults.setColumns(20);
        txtareaResults.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        txtareaResults.setRows(5);
        jScrollPane1.setViewportView(txtareaResults);

        add(jScrollPane1);
        jScrollPane1.setBounds(1160, 20, 790, 146);

        txtIRank.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        add(txtIRank);
        txtIRank.setBounds(260, 140, 200, 40);

        txtYearOfAl.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        add(txtYearOfAl);
        txtYearOfAl.setBounds(260, 240, 202, 40);

        txtschool.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        add(txtschool);
        txtschool.setBounds(260, 40, 410, 40);
    }// </editor-fold>//GEN-END:initComponents

    /*Check whether the textfields are empty*/
    public boolean isNotBlank() {
        return (!txtIRank.getText().equals(null) && !txtYearOfAl.getText().equals(null) && !txtareaResults.getText().equals(null) && !txtschool.getText().equals(null));
    }
    
    /*Clear textfields*/
    public void clearFields(){
        txtIRank.setText(null);
        txtYearOfAl.setText(null);
        txtareaResults.setText(null);
        txtschool.setText(null);
    }
    
    /*Set text from student registration panel*/
    public void setAllText(ArrayList<String> text) {
        txtschool.setText(text.get(0));
        txtYearOfAl.setText(text.get(1));
        txtIRank.setText(text.get(2));
        txtareaResults.setText(text.get(3));
    }

    /*Get text to student registration panel*/
    public ArrayList<String> getAllText() {
        ArrayList<String> text = new ArrayList<>();
        text.add(txtschool.getText());
        text.add(txtYearOfAl.getText());
        text.add(txtIRank.getText());
        text.add(txtareaResults.getText());
        return text;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtIRank;
    private javax.swing.JTextField txtYearOfAl;
    private javax.swing.JTextArea txtareaResults;
    private javax.swing.JTextField txtschool;
    // End of variables declaration//GEN-END:variables
}