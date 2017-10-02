package game;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan Hochmuth on 10/2/2017.
 * <p>
 * Represents a single slot in a column.
 * Each slot has a state, 0 for empty, 1 for player 1 occupied, 2 for player 2 occupied.
 */
public class BoardSlot extends JPanel {

    private final int slotSize = ((ConnectFour.WINDOW_WIDTH / ConnectFour.NUM_COLUMNS) / 6) * 3;

    private int state = 0;

    public BoardSlot() {
        setSize((ConnectFour.WINDOW_WIDTH / ConnectFour.NUM_COLUMNS), ((ConnectFour.WINDOW_HEIGHT - ConnectFour.BOARD_HEADER_HEIGHT - ConnectFour.Y_OFFSET) / ConnectFour.NUM_ROWS));
        setOpaque(false);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        Color circleColor = GameController.getInstance().getEmptyColor();
        if (state > 0) circleColor = GameController.getInstance().getRegisteredColor(state);

        g2d.setColor(circleColor);
        g2d.fillOval((getWidth() / 2) - (slotSize / 2),
                (getHeight() / 2) - (slotSize / 2),
                slotSize, slotSize);

        if (state > 0) {
            int innerSize = (slotSize / 4) * 3;
            g2d.setColor(circleColor.darker());
            g2d.fillOval((getWidth() / 2) - (slotSize / 2) + (slotSize / 2) - (innerSize / 2),
                    (getHeight() / 2) - (slotSize / 2) + (slotSize / 2) - (innerSize / 2),
                    innerSize, innerSize);
        }
    }

    /**
     * Get the state of this slot.
     * @return state
     */
    public int getState() {
        return state;
    }

    /**
     * Set the state of this slot.
     * @param state - The integer state of the slot to set.
     */
    public void setState(int state) {
        this.state = state;
    }
}
