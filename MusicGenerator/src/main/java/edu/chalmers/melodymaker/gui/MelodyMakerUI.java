/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.gui;

import edu.chalmers.melodymaker.controller.MelodyController;
import edu.chalmers.melodymaker.core.Alphabet;
import edu.chalmers.melodymaker.core.MIDIplayer;
import edu.chalmers.melodymaker.core.MelodyTheory;
import edu.chalmers.melodymaker.io.MelodyExporter;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class MelodyMakerUI extends javax.swing.JFrame {

    static ImageIcon topIcon = new ImageIcon("src/main/resources/music-note.png");

    /**
     * Creates new form MelodyMakerUI
     */
    public MelodyMakerUI() {
        initComponents();
        genreComboBox.removeAllItems();
        for (String g : new MelodyController().getGenres()) {
            genreComboBox.addItem(g);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        generatingPanel = new javax.swing.JPanel();
        majorMinorLabel = new javax.swing.JLabel();
        lengthLabel = new javax.swing.JLabel();
        keyLabel = new javax.swing.JLabel();
        signatureLabel = new javax.swing.JLabel();
        genreLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        genreComboBox = new javax.swing.JComboBox();
        signatureComboBox = new javax.swing.JComboBox();
        keyComboBox = new javax.swing.JComboBox();
        lengthComboBox = new javax.swing.JComboBox();
        minorRadioButton = new javax.swing.JRadioButton();
        majorRadioButton = new javax.swing.JRadioButton();
        generateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rulePre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ruleNext = new javax.swing.JTextField();
        RuleButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ruleArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(153, 153, 255));

        generatingPanel.setBackground(new java.awt.Color(204, 204, 204));

        majorMinorLabel.setBackground(new java.awt.Color(255, 255, 255));
        majorMinorLabel.setForeground(new java.awt.Color(0, 153, 153));
        majorMinorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        majorMinorLabel.setText("Maj/Min");

        lengthLabel.setBackground(new java.awt.Color(255, 255, 255));
        lengthLabel.setForeground(new java.awt.Color(0, 153, 153));
        lengthLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lengthLabel.setText("Length:");

        keyLabel.setBackground(new java.awt.Color(255, 255, 255));
        keyLabel.setForeground(new java.awt.Color(0, 153, 153));
        keyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        keyLabel.setText("Key:");

        signatureLabel.setBackground(new java.awt.Color(255, 255, 255));
        signatureLabel.setForeground(new java.awt.Color(0, 153, 153));
        signatureLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        signatureLabel.setText("Signature:");

        genreLabel.setBackground(new java.awt.Color(255, 255, 255));
        genreLabel.setForeground(new java.awt.Color(0, 153, 153));
        genreLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        genreLabel.setText("Genre:");

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setForeground(new java.awt.Color(0, 153, 153));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titleLabel.setText("Title:");

        titleTextField.setText("Title of your melody");

        genreComboBox.setEditable(true);
        genreComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        genreComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreComboBoxActionPerformed(evt);
            }
        });

        signatureComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "4/4", "2/2", "2/4", "3/4", "3/8", "6/8", "9/8", "12/8" }));

        keyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C", "D", "E", "F", "G", "A", "B", "C#", "Bb", "Eb", "F#", "Ab" }));

        lengthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1/2", "1/4", "1/8", "1/16" }));

        minorRadioButton.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(minorRadioButton);
        minorRadioButton.setSelected(true);
        minorRadioButton.setText("Minor");

        majorRadioButton.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(majorRadioButton);
        majorRadioButton.setText("Major");

        generateButton.setText("Generate");
        generateButton.setToolTipText("Generate a new melody with given attributes");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Never:");
        jLabel1.setToolTipText("");

        jButton1.setText("Play your song");
        jButton1.setToolTipText("Play generated melody with give attributes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save your song?");
        jButton2.setToolTipText("Save your melody");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("MusicGenerator");

        rulePre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulePreActionPerformed(evt);
            }
        });

        jLabel3.setText("Before:");

        ruleNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleNextActionPerformed(evt);
            }
        });

        RuleButton.setText("Add Rule");
        RuleButton.setToolTipText("Add specific rules that are not allowed in your song. I.e. \"C must never be followed by a _C\"");
        RuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RuleButtonActionPerformed(evt);
            }
        });

        ruleArea.setColumns(20);
        ruleArea.setRows(5);
        jScrollPane1.setViewportView(ruleArea);

        jLabel4.setText("Rules");

        javax.swing.GroupLayout generatingPanelLayout = new javax.swing.GroupLayout(generatingPanel);
        generatingPanel.setLayout(generatingPanelLayout);
        generatingPanelLayout.setHorizontalGroup(
            generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generatingPanelLayout.createSequentialGroup()
                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generatingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(generateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(generatingPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signatureLabel)
                            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(genreLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lengthLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(majorMinorLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(generatingPanelLayout.createSequentialGroup()
                                .addComponent(minorRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(majorRadioButton))
                            .addComponent(jLabel2)
                            .addGroup(generatingPanelLayout.createSequentialGroup()
                                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(signatureComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(keyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rulePre))
                                .addGap(18, 18, 18)
                                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ruleNext)))
                            .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addGroup(generatingPanelLayout.createSequentialGroup()
                                    .addComponent(lengthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(RuleButton))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        generatingPanelLayout.setVerticalGroup(
            generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generatingPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreLabel)
                    .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signatureLabel)
                    .addComponent(signatureComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keyLabel)
                    .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(keyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rulePre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ruleNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lengthLabel)
                    .addComponent(lengthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RuleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(majorMinorLabel)
                    .addComponent(minorRadioButton)
                    .addComponent(majorRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addGroup(generatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generatingPanelLayout.createSequentialGroup()
                        .addComponent(generateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generatingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generatingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genreComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreComboBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_genreComboBoxActionPerformed
    /**
     *
     * @author Emma
     */
    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        // TODO add your handling code here:

        String inputGenre = (String) genreComboBox.getSelectedItem();
        String inputSignature = (String) signatureComboBox.getSelectedItem();
        String inputKey = (String) keyComboBox.getSelectedItem();
        String inputLength = (String) lengthComboBox.getSelectedItem();

        new MelodyController().sendGenerator(inputGenre, inputSignature, inputKey, inputLength);
        new MelodyExporter("rocky.abc", "huuuuh.abc");
        MelodyTheory.nextRuleList.clear();
        MelodyTheory.preRuleList.clear();

    }//GEN-LAST:event_generateButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MIDIplayer.MIDIplayer("src/main/resources/Let It Go.mid");
    }//GEN-LAST:event_jButton1ActionPerformed
    private void rulePreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulePreActionPerformed
        // rulePre.getAccessibleContext();
    }//GEN-LAST:event_rulePreActionPerformed

    private void ruleNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruleNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruleNextActionPerformed

    private void RuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RuleButtonActionPerformed

        ruleArea.removeAll();
        if (Alphabet.isLetterInAlphabet(rulePre.getText())) {
            MelodyTheory.preRuleList.add(rulePre.getText());
        }
        if (Alphabet.isLetterInAlphabet(rulePre.getText())) {
            MelodyTheory.nextRuleList.add(ruleNext.getText());
        }

        //System.out.println("Never have a: " + rulePre.getText() + " with the following character: " + rulePre.getText());
        for (int i = 0; i < MelodyTheory.nextRuleList.size(); i++) {
            System.out.println(i + 1 + " statement:" + " You have added pre: [" + MelodyTheory.preRuleList.get(i) + "] and you have added next: [" + MelodyTheory.nextRuleList.get(i) + "]");
        }
        if (Alphabet.isLetterInAlphabet(rulePre.getText()) && Alphabet.isLetterInAlphabet(ruleNext.getText())) {
            ruleArea.append("Can't have: " + rulePre.getText() + " and " + ruleNext.getText() + " together!\n");
            System.out.println("______________________________________________________________________________");
        }
        else{
            ruleArea.append("ERROR, letters are not in alphabet!\n");
        }

    }//GEN-LAST:event_RuleButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MelodyMakerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MelodyMakerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MelodyMakerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MelodyMakerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MelodyMakerUI melodyUI = new MelodyMakerUI();
                melodyUI.setVisible(true);
                melodyUI.setIconImage(topIcon.getImage());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RuleButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton generateButton;
    private javax.swing.JPanel generatingPanel;
    private javax.swing.JComboBox genreComboBox;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox keyComboBox;
    private javax.swing.JLabel keyLabel;
    private javax.swing.JComboBox lengthComboBox;
    private javax.swing.JLabel lengthLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel majorMinorLabel;
    private javax.swing.JRadioButton majorRadioButton;
    private javax.swing.JRadioButton minorRadioButton;
    private javax.swing.JTextArea ruleArea;
    private javax.swing.JTextField ruleNext;
    private javax.swing.JTextField rulePre;
    private javax.swing.JComboBox signatureComboBox;
    private javax.swing.JLabel signatureLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    // End of variables declaration//GEN-END:variables
}
