package ui;

import game.ConnectFour;
import game.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Ryan Hochmuth on 9/29/2017.
 * <p>
 * The screen where players will setup the game, setting parameters for play.
 */
public class GameSetupScreen extends ScreenState {

    // GUI Components
    private JLabel titleLbl;
    private JButton beginGameBtn;
    private JButton backBtn;

    private JLabel player1TitleLbl;
    private JLabel player2TitleLbl;
    private JSeparator playerSep;
    private JLabel p1NameLbl;
    private JLabel p2NameLbl;
    private JTextField p1NameField;
    private JTextField p2NameField;
    private JLabel p1ColorLbl;
    private JLabel p2ColorLbl;
    private JColorChooser p1ColorChooser;
    private JColorChooser p2ColorChooser;

    @Override
    public void buildUI() {
        // Setup panel
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Setup title label
        titleLbl = new JLabel("Game Setup");
        titleLbl.setFont(new Font("Sans Serif", Font.PLAIN, 32));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 500;
        gbc.insets = new Insets(0, 10, 0, 10);
        titleLbl.setVisible(true);
        this.add(titleLbl, gbc);

        /*
            Player controls setup
         */

        /*
            Player 1
         */
        // Setup player 1 title label
        player1TitleLbl = new JLabel("Player 1");
        player1TitleLbl.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        player1TitleLbl.setVisible(true);
        this.add(player1TitleLbl, gbc);

        // Setup player 1 name label
        p1NameLbl = new JLabel("Name");
        p1NameLbl.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        p1NameLbl.setVisible(true);
        this.add(p1NameLbl, gbc);

        // Setup player 1 name field
        p1NameField = new JTextField();
        p1NameField.setText("Player 1");
        p1NameField.setPreferredSize(new Dimension(200, 20));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        p1NameField.setVisible(true);
        this.add(p1NameField, gbc);

        // Setup player 1 color label
        p1ColorLbl = new JLabel("Color");
        p1ColorLbl.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        p1ColorLbl.setVisible(true);
        this.add(p1ColorLbl, gbc);

        // Setup player 1 color chooser
        p1ColorChooser = new JColorChooser(new Color(183,3,11));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        p1ColorChooser.setVisible(true);
        this.add(p1ColorChooser, gbc);

        /*
            Player 2
         */
        // Setup player 2 title label
        player2TitleLbl = new JLabel("Player 2");
        player2TitleLbl.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        player2TitleLbl.setVisible(true);
        this.add(player2TitleLbl, gbc);

        // Setup player 2 name label
        p2NameLbl = new JLabel("Name");
        p2NameLbl.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        p2NameLbl.setVisible(true);
        this.add(p2NameLbl, gbc);

        // Setup player 2 name field
        p2NameField = new JTextField();
        p2NameField.setText("Player 2");
        p2NameField.setPreferredSize(new Dimension(200, 20));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        p2NameField.setVisible(true);
        this.add(p2NameField, gbc);

        // Setup player 2 color label
        p2ColorLbl = new JLabel("Color");
        p2ColorLbl.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        p2ColorLbl.setVisible(true);
        this.add(p2ColorLbl, gbc);

        // Setup player 2 color chooser
        p2ColorChooser = new JColorChooser(new Color(197, 190, 0));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        p2ColorChooser.setVisible(true);
        this.add(p2ColorChooser, gbc);

        // Setup player separator
        playerSep = new JSeparator(SwingConstants.VERTICAL);
        playerSep.setPreferredSize(new Dimension(3, 50));
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 5;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 10, 0, 10);
        playerSep.setVisible(true);
        this.add(playerSep, gbc);

        // Setup back button
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 10, 0, 20);
        backBtn.setVisible(true);
        this.add(backBtn, gbc);

        // Setup begin game button
        beginGameBtn = new JButton("Begin Game");
        beginGameBtn.addActionListener(this);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 20;
        gbc.ipadx = 0;
        gbc.insets = new Insets(0, 20, 0, 10);
        beginGameBtn.setVisible(true);
        this.add(beginGameBtn, gbc);
    }

    @Override
    public void destroyUI() {
        titleLbl = null;
        beginGameBtn = null;
        backBtn = null;
        player1TitleLbl = null;
        player2TitleLbl = null;
        playerSep = null;
        p1NameLbl = null;
        p2NameLbl = null;
        p1NameField = null;
        p2NameField = null;
        p1ColorLbl = null;
        p2ColorLbl = null;
        p1ColorChooser = null;
        p2ColorChooser = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Begin game button clicked
        if (e.getSource() == beginGameBtn) {
            if (p1ColorChooser.getColor().getRGB() == p2ColorChooser.getColor().getRGB()) {
                JOptionPane.showMessageDialog(null, "Both players have the same color selected, please choose different colors.", "No Matching Colors", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                GameController.getInstance().resetGame();
                GameController.getInstance().createPlayer(p1NameField.getText(), p1ColorChooser.getColor());
                GameController.getInstance().createPlayer(p2NameField.getText(), p2ColorChooser.getColor());
                GameController.getInstance().startGame();

                // Show game screen
                ScreenManager.getInstance().setScreenState(new GameScreen());
            }
        }

        // Back button clicked
        if (e.getSource() == backBtn) {
            ScreenManager.getInstance().setScreenState(new MainMenuScreen());
        }
    }
}
