package ui;

import game.BoardColumn;
import game.ConnectFour;
import game.ConnectFourPlayer;
import game.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Hochmuth on 9/29/2017.
 * <p>
 * The main game screen where players actual play the game.
 * Shows the board and handles interaction of players.
 */
public class GameScreen extends ScreenState {

    // GUI Components
    private JLabel playerLbl;
    private String playerString = "Player: ";

    private JLabel turnLbl;
    private String turnString = "Turn: ";

    private JPanel boardPanel;
    private List<BoardColumn> columns = new ArrayList<>();
    private GameMouseAdapter mouseAdapter = new GameMouseAdapter();

    // Game Logic
    private ConnectFourPlayer currentPlayer = null;

    @Override
    public void buildUI() {
        // Setup the panel
        this.setLayout(null);

        // Setup player label
        playerLbl = new JLabel(playerString);
        playerLbl.setFont(new Font("Sans Serif", Font.PLAIN, 28));
        playerLbl.setLocation(10, 10);
        playerLbl.setSize(200, 30);
        playerLbl.setVisible(true);
        this.add(playerLbl);

        // Setup turn label
        turnLbl = new JLabel(turnString);
        turnLbl.setFont(new Font("Sans Serif", Font.PLAIN, 28));
        turnLbl.setLocation(ConnectFour.WINDOW_WIDTH - 210, 10);
        turnLbl.setSize(200, 30);
        turnLbl.setVisible(true);
        this.add(turnLbl);

        // Setup board panel
        boardPanel = new JPanel();
        boardPanel.setSize(ConnectFour.WINDOW_WIDTH, ConnectFour.WINDOW_HEIGHT - ConnectFour.BOARD_HEADER_HEIGHT - ConnectFour.Y_OFFSET);
        boardPanel.setLocation(0, ConnectFour.BOARD_HEADER_HEIGHT);
        boardPanel.setLayout(null);
        boardPanel.setVisible(true);
        this.add(boardPanel);

        /*
            Setup and add columns
        */
        for (int i = 0; i < ConnectFour.NUM_COLUMNS; i++) {
            columns.add(new BoardColumn(i));
            columns.get(i).addMouseListener(mouseAdapter);
            boardPanel.add(columns.get(i));
        }

        nextTurn();
    }

    @Override
    public void destroyUI() {
        playerLbl = null;
        turnLbl = null;
        boardPanel = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Set the state of the slot in the given column and row.
     * @param columnNum - the column in which to change the slot state.
     * @param slotNum - the slot in which to change the slot state.
     * @param state - the new state to set.
     */
    private void setSlotState(int columnNum, int slotNum, int state) {
        if (columnNum < 0 || columnNum >= columns.size()) {
            return;
        }

        if (slotNum < 0 || slotNum >= ConnectFour.NUM_ROWS) {
            return;
        }

        if (state < 0 || state > GameController.getInstance().getNumPlayers()) {
            return;
        }

        columns.get(columnNum).setSlotState(slotNum, state);
    }

    /**
     * Call when a column is clicked. Used when a player chooses
     * to place a piece in a column. Calls logic functions
     * in GameController and based on its response, changes the
     * view.
     * @param columnNum - the index of the column that was clicked.
     */
    private void columnClicked(int columnNum) {
        int[] response = GameController.getInstance().addPieceToBoard(columns, columnNum);

        if (response[1] > -1) {
            setSlotState(columnNum, response[1], currentPlayer.getPlayerNum());
            repaint();
        }

        if (response[0] == 1) {
            JOptionPane.showMessageDialog(null, "Player: " + currentPlayer.getName() + " has won the game!", "Winner", JOptionPane.INFORMATION_MESSAGE);
            ScreenManager.getInstance().setScreenState(new MainMenuScreen());
        }

        if (response[0] == 0 && response[1] > -1) {
            nextTurn();
        }
    }

    /**
     * Start a new turn
     */
    private void nextTurn() {
        // Get game info
        if (currentPlayer == null) {
            currentPlayer = GameController.getInstance().getCurrentPlayer();
        }
        else {
            currentPlayer = GameController.getInstance().nextTurn();
        }

        // Update UI
        playerLbl.setText(playerString + currentPlayer.getName());
        playerLbl.setForeground(currentPlayer.getColor());
        turnLbl.setText(turnString + GameController.getInstance().getNumTurns());
    }

    class GameMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);

            columnClicked(((BoardColumn) e.getSource()).getColumnNum());
        }
    }
}
