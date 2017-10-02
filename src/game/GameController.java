package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryan Hochmuth on 9/29/2017.
 * <p>
 * The controller of all game logic. Maintains the state of the game and the
 * information needed for it.
 */
public class GameController {

    // Singleton attributes
    private static GameController instance = new GameController();
    public static GameController getInstance() { return instance; }

    // Game Components
    private List<ConnectFourPlayer> players = new ArrayList<>();
    private int currentPlayer;
    private int numTurns = 0;

    private Map<Integer, Color> colorMap = new HashMap<>();
    private final Color emptyColor = new Color(255, 255, 255);

    /**
     * Private default constructor prevents additional creation.
     */
    private GameController() { }

    /**
     * Create a new ConnectFourPlayer object and add it to the game.
     * @param name - The String name of the player.
     * @param color - The Color representing the player.
     */
    public void createPlayer(String name, Color color) {
        String playerName = name;
        if (playerName.equals("")) playerName = "Player " + (players.size() + 1);
        addPlayer(new ConnectFourPlayer(players.size() + 1, playerName, color));
        registerSlotColor(players.size(), color);
    }

    /**
     * Add a new player to the game.
     * @param player - The ConnectFourPlayer to add.
     */
    private void addPlayer(ConnectFourPlayer player) {
        players.add(player);
    }

    /**
     * Get the player whose turn it currently is.
     * @return ConnectFourPlayer - The player whose turn it is.
     */
    public ConnectFourPlayer getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    /**
     * Get the number of players in the game.
     * @return int - the number of players.
     */
    public int getNumPlayers() {
        return players.size();
    }

    /**
     * Resets various attribute values to setup a fresh game.
     */
    public void resetGame() {
        players.clear();
        numTurns = 0;
        colorMap.clear();
    }

    /**
     * Sets up and starts the game logic.
     */
    public void startGame() {
        currentPlayer = 0;
    }

    /**
     * Ends the current player's turn and starts the next player's turn.
     * Returns the player whose turn it now is.
     * @return currentPlayer - The player whose turn it now is.
     */
    public ConnectFourPlayer nextTurn() {
        numTurns++;

        if (currentPlayer < players.size() - 1) {
            currentPlayer++;
        }
        else {
            currentPlayer = 0;
        }

        return players.get(currentPlayer);
    }

    /**
     * Called when a column is clicked and a player is attempting to add a piece
     * to the column. Check if the piece can be added to the column and update
     * any needed logic, then return the slot index if it was successfully added, or -1
     * if the piece could not be added.
     * @param columns - the list of all the columns.
     * @param columnClicked - the index of the column that was clicked.
     * @return int[] - first index is 0 or 1 for true/false win, second index is slot to fill, -1 if fail.
     */
    public int[] addPieceToBoard(List<BoardColumn> columns, int columnClicked) {
        // First index is true/false to show if the player has won or not
        // Second index is the slot to fill (where a piece was added),
        // This will be -1 if a piece couldn't be added.
        int[] response = {0, -1};
        BoardSlot[] slots = columns.get(columnClicked).getSlots();

        // Check for the next empty slot and set that to be filled
        if (slots[slots.length - 1].getState() == 0) {
            int index = 0;
            for (BoardSlot slot : slots) {
                if (slot.getState() == 0) {
                    response[1] = index;
                    break;
                }

                index++;
            }
        }

        // Check for a win with the current board configuration
        WinChecker winChecker = new WinChecker(columns, columnClicked, response[1], getCurrentPlayer().getPlayerNum());
        if (winChecker.checkWin()) response[0] = 1;
        return response;
    }

    /**
     * Get the number of turns that have passed.
     * @return int - The number of turns that have happened.
     */
    public int getNumTurns() {
        return numTurns;
    }

    /**
     * Register the given integer key and color with the color map.
     * This allows slots to properly change color based on state.
     * The state variable within BoardSlot will correspond to a
     * key in the color map.
     * NOTE: Adding a key of 0 will be ignored, key should correspond
     * to the player number with the given color.
     * @param key - the integer key to map to the given color.
     * @param color - the given color to register.
     */
    private void registerSlotColor(int key, Color color) {
        colorMap.put(key, color);
    }

    /**
     * Get the color in the map of registered colors with the given key.
     * @param key - the key to use to look up a registered color.
     * @return Color - the color with the given key.
     */
    public Color getRegisteredColor(int key) {
        return colorMap.get(key);
    }

    /**
     * Get the color to show for an empty slot.
     * @return - Color - the color of an empty slot.
     */
    public Color getEmptyColor() {
        return emptyColor;
    }
}
