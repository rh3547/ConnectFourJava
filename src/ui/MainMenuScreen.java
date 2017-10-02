package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Ryan Hochmuth on 9/29/2017.
 * <p>
 * The main menu of the game, shown as the first screen upon launching.
 */
public class MainMenuScreen extends ScreenState {

    // GUI Components
    private JLabel titleLbl;
    private JButton newGameBtn;
    private JButton exitBtn;

    @Override
    public void buildUI() {
        // Setup panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Setup title label
        titleLbl = new JLabel("Connect Four Xtreme");
        titleLbl.setFont(new Font("Sans Serif", Font.PLAIN, 32));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.insets = new Insets(10, 10, 200, 10);
        titleLbl.setVisible(true);
        this.add(titleLbl, gbc);

        // Setup new game button
        newGameBtn = new JButton("New Game");
        newGameBtn.addActionListener(this);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.insets = new Insets(0, 10, 20, 10);
        newGameBtn.setVisible(true);
        this.add(newGameBtn, gbc);

        // Setup exit button
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(this);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.insets = new Insets(0, 10, 0, 10);
        exitBtn.setVisible(true);
        this.add(exitBtn, gbc);
    }

    @Override
    public void destroyUI() {
        titleLbl = null;
        newGameBtn = null;
        exitBtn = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // New game button clicked
        if (e.getSource() == newGameBtn) {
            ScreenManager.getInstance().setScreenState(new GameSetupScreen());
        }

        // Exit button clicked
        if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }
}
