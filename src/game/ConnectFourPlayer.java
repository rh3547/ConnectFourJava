package game;

import java.awt.*;

/**
 * Created by Ryan Hochmuth on 9/29/2017.
 * <p>
 * Represents a player of the game, maintaining attributes about them.
 */
public class ConnectFourPlayer {

    private int playerNum;
    private String name;
    private Color color;

    public ConnectFourPlayer(int playerNum, String name, Color color) {
        this.playerNum = playerNum;
        this.name = name;
        this.color = color;
    }

    /**
     * Get the number of this player (i.e. player 1, player 2, etc).
     * @return int - the player number.
     */
    public int getPlayerNum() {
        return playerNum;
    }

    /**
     * Set the number of this player (i.e. player 1, player 2, etc).
     * @param playerNum - the number to set.
     */
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    /**
     * Get the name of this player.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this player.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the color of this player's pawns.
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set the color of this player's pawns.
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
