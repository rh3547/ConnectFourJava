package game;

import ui.MainMenuScreen;
import ui.ScreenManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ryan Hochmuth on 9/29/2017.
 * <p>
 * The driver class for the program, handles context and manages
 * the initialization of components.
 */
public class ConnectFour {

    public static final String GAME_NAME = "Connect Four Xtreme";
    public static final String RESOURCE_PATH = "/resources/";
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    public static int NUM_COLUMNS = 7;
    public static int NUM_ROWS = 6;
    public static final int BOARD_HEADER_HEIGHT = 50;
    public static final int Y_OFFSET = 25;


    // Singleton attributes
    private static ConnectFour instance = null;
    public static ConnectFour getInstance() { return instance; }

    /**
     * Default constructor
     * - Initialize objects/components
     * - Start game
     */
    private ConnectFour() {
        // Build JFrame (primary window)
        JFrame window;
        window = new JFrame(GAME_NAME);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(new File(getClass().getResource(RESOURCE_PATH + "icon.png").getPath()));
        }
        catch (IOException e) {
            System.out.println("\nWindow icon image not found");
        }
        window.setIconImage(icon);
        window.setVisible(true);

        // Setup ScreenManager and show main menu
        ScreenManager.getInstance().setWindow(window);
        ScreenManager.getInstance().setScreenState(new MainMenuScreen());
    }

    /**
     * Main method, launches the program.
     * @param args
     */
    public static void main(String[] args) {
        instance = new ConnectFour();
    }
}
