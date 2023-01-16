/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demineur;

import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author dimitriseaborn
 */
public class Case {

    public int value;
    public JButton button;
    public boolean isRevealed;
    private final int gridSizeX;
    private final int gridSizeY;
    private final int coordX;
    private final int coordY;
    private boolean isFlagged;

    public Case(int coordX, int coordY, int value, int gridSizeX, int gridSizeY) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.value = value;
        this.isRevealed = false;
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
        this.isFlagged = false;
        innitButton();
    }

    public boolean isMine() {
        return value == -1;
    }

    private void innitButton() {
        button = new JButton();
        button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMouseClicked(evt);
            }
        });
        button.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        updateColor();
    }

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (!this.isFlagged) {
            if (this.isMine()) {
                App.gameOver();
            } else {
                this.reveal();
            }
        }
    }
    
    private void buttonMouseClicked(java.awt.event.MouseEvent evt) {
        if(evt.getButton() == MouseEvent.BUTTON3) {
            flag(!isFlagged);
        }
    }
    
    public void reveal() {
        if (!isRevealed) {
            if (!isMine()) {
                isRevealed = true;
                flag(false);
                button.setText(String.valueOf(this.value));
                button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
                
                final int[] offsetX = {-1, 0, 1};
                final int[] offsetY = {-1, 0, 1};
                if (value == 0) {
                    for (int xOffset : offsetX) {
                        for (int yOffset : offsetY) {
                            //for each surrounding case
                            if (!(coordX + xOffset < 0 || coordX + xOffset >= gridSizeX || coordY + yOffset < 0 || coordY + yOffset >= gridSizeY)) {
                                App.gamePanel.reveal(coordX + xOffset, coordY + yOffset);
                            }
                        }
                    }
                }
            } else {
                flag(true);
            }
        }
    }

    private static ImageIcon resize(ImageIcon imageIcon, int newWidth, int newHeight) {
        BufferedImage bi = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(imageIcon.getImage(), 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        return new ImageIcon(bi);
    }

    private void flag(boolean set) {
        if (set && !isRevealed) {
            button.setMargin(new Insets(0, 0, 0, 0));
            ImageIcon icon = new ImageIcon(Case.class.getResource("flag.png"));
            if (button.getHeight() < button.getWidth()) {
                icon = resize(icon, button.getHeight(), button.getHeight());
            } else {
                icon = resize(icon, button.getWidth(), button.getWidth());
            }
            button.setIcon(icon);
            isFlagged = true;
        } else {
            button.setIcon(null);
            isFlagged = false;
        }
    }
    
    public void updateColor() {
        switch (value) {
            case 0:
                button.setForeground(new java.awt.Color(78, 80, 82));
                break;
            case 1:
                button.setForeground(new java.awt.Color(0, 153, 255));
                break;
            case 2:
                button.setForeground(new java.awt.Color(51, 204, 0));
                break;
            case 3:
                button.setForeground(new java.awt.Color(255, 0, 0));
                break;
            case 4:
                button.setForeground(new java.awt.Color(153, 0, 153));
                break;
            case 5:
                button.setForeground(new java.awt.Color(102, 0, 0));
                break;
            case 6:
                button.setForeground(new java.awt.Color(0, 153, 153));
                break;
            case 7:
                button.setForeground(new java.awt.Color(0, 0, 0));
                break;
            case 8:
                button.setForeground(new java.awt.Color(153, 153, 153));
                break;
            case 9:
                button.setForeground(new java.awt.Color(255, 255, 255));
                break;
        }
    }
}
