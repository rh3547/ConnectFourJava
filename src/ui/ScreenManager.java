package ui;

import javax.swing.*;

/**
 * Created by Ryan Hochmuth on 9/29/2017.
 * <p>
 * Handles what screen is shown, acts as context for screens to change state.
 */
public class ScreenManager {

    // Singleton attributes
    private static ScreenManager instance = new ScreenManager();
    public static ScreenManager getInstance() {
        return instance;
    }

    private JFrame window;
    private ScreenState currentScreen;

    /**
     * Private default constructor prevents additional creation.
     */
    private ScreenManager() {

    }

    /**
     * Get the JFrame used as the window that screens will be managed/shown in.
     * @return window
     */
    public JFrame getWindow() {
        return window;
    }

    /**
     * Set the JFrame to use as the window that screens will be managed/shown in.
     * @param frame
     */
    public void setWindow(JFrame frame) {
        window = frame;
    }

    /**
     * Get the current screen shown.
     * @return currentScreen
     */
    public ScreenState getScreenState() {
        return currentScreen;
    }

    /**
     * Set the current screen shown to the ScreenState given.
     * @param screen
     */
    public void setScreenState(ScreenState screen) {

        if (window != null) {
            // Remove the current screen, set the new one
            if (currentScreen != null) {
                currentScreen.hideScreen();
                currentScreen.destroyScreen();
                window.remove(currentScreen);
            }
            currentScreen = screen;

            currentScreen.setSize(window.getSize().width, window.getSize().height);
            currentScreen.setLocation(0, 0);
            currentScreen.buildUI();
            window.add(currentScreen);
            currentScreen.showScreen();
        }
        else {
            System.out.println("The ScreenManager's window (JFrame) is not set, set it using ScreenManager.setWindow() to use its functionality.");
        }
    }
}
