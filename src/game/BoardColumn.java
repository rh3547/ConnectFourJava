package game;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Created by Ryan Hochmuth on 10/2/2017.
 * <p>
 * Represents a column in the board.
 */
public class BoardColumn extends JPanel {

    private int columnNum;
    private BoardSlot[] slots = new BoardSlot[ConnectFour.NUM_ROWS];

    public BoardColumn(int columnNum) {
        this.columnNum = columnNum;

        setSize((ConnectFour.WINDOW_WIDTH / ConnectFour.NUM_COLUMNS), (ConnectFour.WINDOW_HEIGHT - ConnectFour.BOARD_HEADER_HEIGHT - ConnectFour.Y_OFFSET));
        setLocation((ConnectFour.WINDOW_WIDTH / ConnectFour.NUM_COLUMNS) * columnNum, 0);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(30, 78, 199));
        setBorder(new MatteBorder(4, 0, 0, 2, new Color(29, 72, 145)));
        setVisible(true);

        for (int i = ConnectFour.NUM_ROWS - 1; i >= 0; i--) {
            slots[i] = new BoardSlot();
            add(slots[i]);
        }
    }

    /**
     * Set the state of the slot at the given index to the given state.
     * @param slotNum - the index of the slot to change.
     * @param state - the new state to change the slot to.
     */
    public void setSlotState(int slotNum, int state) {
        slots[slotNum].setState(state);
    }

    /**
     * Get the array of slots in the column.
     * @return BoardSlot[] - the array of BoardSlot objects.
     */
    public BoardSlot[] getSlots() {
        return slots;
    }

    /**
     * Get the "index" number of this column.
     * AKA what position on the board this is.
     * @return columnName
     */
    public int getColumnNum() {
        return columnNum;
    }

    /**
     * Set the number of this column.
     * AKA what position on the board this is.
     * @param columnNum - The new column number.
     */
    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }
}
