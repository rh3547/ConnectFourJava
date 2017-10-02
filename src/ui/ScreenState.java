package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Ryan Hochmuth on 9/29/2017.
 * <p>
 * The state that the GUI is in to handle which screen is shown.
 * This represents a screen in full, ScreenState is a JPanel and
 * contains functionality for handling UI actions.
 */
public abstract class ScreenState extends JPanel implements ActionListener {

    /**
     * Show this screen in the window, make it visible.
     */
    public void showScreen() {
        this.setVisible(true);
    }

    /**
     * Hide this screen in the window, set visible to false.
     */
    public void hideScreen() {
        this.setVisible(false);
    }

    /**
     * Remove all components in this screen and destroy it.
     */
    public void destroyScreen() {
        this.removeAll();
        destroyUI();
    }

    /**
     * Build the UI components for this screen.
     * Add components, size/position them, etc.
     */
    public abstract void buildUI();

    /**
     * Wipe all of the UI components for this screen.
     * Set them to null so they are disposed of immediately.
     */
    public abstract void destroyUI();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
