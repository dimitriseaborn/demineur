/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demineur;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
    private static SettingsPanel settingsPanel;
    private static MainMenuPanel mainMenuPanel;
    static GamePanel gamePanel;
    
    static Preferences settings;

    static JFrame mainWindow = new JFrame("Démineur");

    public static void main(String[] args) {
        
        // Set cross-platform Java L&F (also called "Metal")
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadSettings();
        //TODO: decide if I want to use a custom font
//        loadFont();
        
        mainMenuPanel = new MainMenuPanel();
        settingsPanel = new SettingsPanel();
        
        // schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //innit components
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.setMinimumSize(new Dimension(500, 500));
                //set fullscreen if last saved
                if ("Plein écran".equals(settings.get("displayMode", "Fenêtre"))) {
                    GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].setFullScreenWindow(mainWindow);
                } else {
                    mainWindow.pack();
                }
                mainWindow.setVisible(true);


                displayMainWindow();

            }
        });
    }

    static void displayMainWindow() {

        mainWindow.setContentPane(mainMenuPanel);
        mainWindow.revalidate();
        mainWindow.repaint();

    }
    
    static void displaySettingsWindow() {
        
        mainWindow.setContentPane(settingsPanel);
        mainWindow.revalidate();
        mainWindow.repaint();

    }
    
    static void displayGameWindow(int sizeX, int sizeY, int mineNumber) {
        gamePanel = new GamePanel(sizeX, sizeY, mineNumber);
        mainWindow.setContentPane(gamePanel);
        mainWindow.revalidate();
        mainWindow.repaint();
    }
    
    private static void loadSettings() {
        settings = Preferences.userNodeForPackage(App.class);
        try {
            for (String key : settings.keys()) {
                System.out.println(key + ": " + settings.get(key, null));
            }
        } catch (BackingStoreException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void gameOver() {
        System.out.println("game over");
        gamePanel.gameOver();
    }
    
    private static void loadFont() {
        //TODO: create custom font
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(App.class.getResource("font.tff").toURI())));
        } catch (FontFormatException | IOException | URISyntaxException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
