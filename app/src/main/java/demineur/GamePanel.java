/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package demineur;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dimitriseaborn
 */
public class GamePanel extends javax.swing.JPanel {

    private Case[][] grid;
    private int timerSecond;
    private ScheduledExecutorService timerExecutor;

    /**
     * Creates new form gamePannel
     *
     * @param sizeX
     * @param sizeY
     * @param mineNumber
     */
    public GamePanel(int sizeX, int sizeY, int mineNumber) {
        initComponents();
        setupGrid(sizeX, sizeY, mineNumber);
        setupGUI(sizeX, sizeY);
        timerSecond = 0;
        setupTimer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        timeLabel = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        hintButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        gridPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));

        setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(534, 50));
        jPanel1.setLayout(new java.awt.GridLayout(1, 6, 5, 0));

        backButton.setText("Retour");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton);
        jPanel1.add(filler5);
        jPanel1.add(filler2);

        timeLabel.setText("Temps:");
        jPanel1.add(timeLabel);
        jPanel1.add(filler3);

        hintButton.setText("Indice");
        jPanel1.add(hintButton);
        jPanel1.add(filler4);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        gridPanel.setLayout(new java.awt.GridLayout(1, 0));
        add(gridPanel, java.awt.BorderLayout.CENTER);
        add(filler1, java.awt.BorderLayout.PAGE_END);
        add(filler6, java.awt.BorderLayout.LINE_START);
        add(filler7, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        App.displayMainWindow();
    }//GEN-LAST:event_backButtonActionPerformed

    private void setupGrid(int sizeX, int sizeY, int mineNumber) {
        grid = new Case[sizeX][sizeY];
        //Setup grid with all 0
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                grid[x][y] = new Case(x, y, 0, sizeX, sizeY);
            }
        }

        //add mines randomly
        for (int i = 0; i < mineNumber;) {
            int randomX = ThreadLocalRandom.current().nextInt(0, sizeX);
            int randomY = ThreadLocalRandom.current().nextInt(0, sizeY);
            if (grid[randomX][randomY].value != -1) {
                grid[randomX][randomY].value = -1;
                i++;
            }
        }

        //set values of non mines
        Case current;
        final int[] offsetX = {-1, 0, 1};
        final int[] offsetY = {-1, 0, 1};
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                //for each case
                current = grid[x][y];
                int surroundingMines = 0;
                if (!current.isMine()) {
                    for (int xOffset : offsetX) {
                        for (int yOffset : offsetY) {
                            //for each surrounding case
                            if (!(x + xOffset < 0 || x + xOffset >= sizeX || y + yOffset < 0 || y + yOffset >= sizeY)) {
                                if (grid[x + xOffset][y + yOffset].isMine()) {
                                    surroundingMines++;
                                }
                            }
                        }
                    }
                    current.value = surroundingMines;
                    current.updateColor();
                }
            }
        }
        System.out.println(Arrays.deepToString(grid));
    }
    
    private void setupGUI(int sizeX, int sizeY) {
        
        gridPanel.setLayout(new java.awt.GridLayout(sizeX, sizeY, 0, 0));

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                gridPanel.add(grid[x][y].button);
            }
        }
    }
    
    public void reveal(int x, int y) {
        grid[x][y].reveal();
    }

    private void setupTimer() {
        Runnable updateTimer = new Runnable() {
            @Override
            public void run() {
                timeLabel.setText("Temps: "+timerSecond);
                timerSecond++;
            }
        };
        timerExecutor = Executors.newScheduledThreadPool(1);
        timerExecutor.scheduleAtFixedRate(updateTimer, 0, 1, TimeUnit.SECONDS);
    }
    
    public void gameOver() {
        timerExecutor.shutdown();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                grid[x][y].reveal();
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JPanel gridPanel;
    private javax.swing.JButton hintButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables

}