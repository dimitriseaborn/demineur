/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package demineur;

/**
 *
 * @author dimitriseaborn
 */
public class SettingsPanel extends javax.swing.JPanel {

    /**
     * Creates new form SettingsPanel
     */
    public SettingsPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        titlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        gamemodeLabel = new javax.swing.JLabel();
        gamemodeSelector = new javax.swing.JComboBox<>();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        displayLabel = new javax.swing.JLabel();
        displayButton = new javax.swing.JButton();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        dificultyLabel = new javax.swing.JLabel();
        dificultySelector = new javax.swing.JComboBox<>();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        sizeLabel = new javax.swing.JLabel();
        sizeSelectorPanel = new javax.swing.JPanel();
        sizeXLabel = new javax.swing.JLabel();
        sizeXSelector = new javax.swing.JSpinner();
        sizeYLabel = new javax.swing.JLabel();
        sizeYSelector = new javax.swing.JSpinner();
        mineNumberLabel = new javax.swing.JLabel();
        mineNumberSelector = new javax.swing.JSpinner();

        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Démineur");
        titlePanel.add(jLabel1);

        add(titlePanel, java.awt.BorderLayout.PAGE_START);

        buttonsPanel.setMinimumSize(new java.awt.Dimension(500, 400));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(500, 400));
        buttonsPanel.setLayout(new java.awt.GridLayout(6, 4, 25, 25));

        backButton.setText("Retour");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(backButton);
        buttonsPanel.add(filler2);
        buttonsPanel.add(filler3);
        buttonsPanel.add(filler4);
        buttonsPanel.add(filler5);

        gamemodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamemodeLabel.setText("Mode de jeu");
        buttonsPanel.add(gamemodeLabel);

        gamemodeSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Classique", "Premier coup", "Pure logique" }));
        buttonsPanel.add(gamemodeSelector);
        buttonsPanel.add(filler6);
        buttonsPanel.add(filler7);

        displayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayLabel.setText("Affichage");
        buttonsPanel.add(displayLabel);

        displayButton.setText("Fenêtre");
        displayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(displayButton);
        buttonsPanel.add(filler10);
        buttonsPanel.add(filler14);

        dificultyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dificultyLabel.setText("Difficultée");
        buttonsPanel.add(dificultyLabel);

        dificultySelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facile", "Moyen", "Difficile", "Personalisé" }));
        buttonsPanel.add(dificultySelector);
        buttonsPanel.add(filler11);

        sizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sizeLabel.setText("Dimensions");
        buttonsPanel.add(sizeLabel);

        sizeSelectorPanel.setLayout(new java.awt.GridLayout(2, 2));

        sizeXLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sizeXLabel.setText("x");
        sizeSelectorPanel.add(sizeXLabel);
        sizeSelectorPanel.add(sizeXSelector);

        sizeYLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sizeYLabel.setText("y");
        sizeSelectorPanel.add(sizeYLabel);
        sizeSelectorPanel.add(sizeYSelector);

        buttonsPanel.add(sizeSelectorPanel);

        mineNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mineNumberLabel.setText("Nombre de mine");
        buttonsPanel.add(mineNumberLabel);

        mineNumberSelector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonsPanel.add(mineNumberSelector);

        add(buttonsPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void displayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayButtonActionPerformed
        System.out.println("settings");
    }//GEN-LAST:event_displayButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        App.displayMainWindow();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel dificultyLabel;
    private javax.swing.JComboBox<String> dificultySelector;
    private javax.swing.JButton displayButton;
    private javax.swing.JLabel displayLabel;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JLabel gamemodeLabel;
    private javax.swing.JComboBox<String> gamemodeSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mineNumberLabel;
    private javax.swing.JSpinner mineNumberSelector;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JPanel sizeSelectorPanel;
    private javax.swing.JLabel sizeXLabel;
    private javax.swing.JSpinner sizeXSelector;
    private javax.swing.JLabel sizeYLabel;
    private javax.swing.JSpinner sizeYSelector;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}