package game;

import java.util.List;

/**
 * Created by Ryan Hochmuth on 10/2/2017.
 * <p>
 * This is a helper class with functions useful to check for a win condition.
 */
public class WinChecker {

    private List<BoardColumn> columns;
    private int columnNum;
    private int slotNum;
    private int playerNum;

    /**
     *
     * @param columns - the list of all the columns.
     * @param columnNum - the index of the column a piece was added to.
     * @param slotNum - the index of the slot a piece was added to.
     * @param playerNum - the playerNum of the current player.
     */
    public WinChecker(List<BoardColumn> columns, int columnNum, int slotNum, int playerNum) {
        this.columns = columns;
        this.columnNum = columnNum;
        this.slotNum = slotNum;
        this.playerNum = playerNum;
    }

    /**
     * Check if there is currently a winning arrangement on the board.
     * @return boolean - true if win, false if not.
     */
    public boolean checkWin() {
        int matchCount;

        // Check "forward" diagonals
        matchCount = 1;
        matchCount = checkRecurive(columnNum, slotNum, matchCount, 1, 1);
        matchCount = checkRecurive(columnNum, slotNum, matchCount, -1, -1);
        if (matchCount == 4) return true;

        // Check "backward" diagonals
        matchCount = 1;
        matchCount = checkRecurive(columnNum, slotNum, matchCount, -1, 1);
        matchCount = checkRecurive(columnNum, slotNum, matchCount, 1, -1);
        if (matchCount == 4) return true;

        // Check left and right
        matchCount = 1;
        matchCount = checkRecurive(columnNum, slotNum, matchCount, 1, 0);
        matchCount = checkRecurive(columnNum, slotNum, matchCount, -1, 0);
        if (matchCount == 4) return true;

        // Check down
        matchCount = 1;
        matchCount = checkRecurive(columnNum, slotNum, matchCount, 0, -1);
        if (matchCount == 4) return true;

        return false;
    }

    /**
     * Recursively check for a sequence of matching game pieces starting from the current
     * slot (the newly added to slot) and continuing in a direction based on the
     * col and row shift values.
     * A colShift of 1 will check the next column to the right of the current at each
     * depth of recursion. -1 will check to the left. A rowShift of 1 will check the
     * next row up from the current at each depth of recursion. -1 will check down.
     * @param currentColumn - the current column index to check from.
     * @param currentRow - the current row index to check from.
     * @param matchCount - the number of matches found so far
     * @param colShift - the number of columns to shift at each depth of recursion.
     * @param rowShift - the number of rows to shift at each depth of recursion.
     * @return int - the number of matches found in searching.
     */
    private int checkRecurive(int currentColumn, int currentRow, int matchCount, int colShift, int rowShift) {
        if (currentColumn + colShift < 0 || currentColumn + colShift >= columns.size()) return matchCount;
        if (currentRow + rowShift < 0 || currentRow + rowShift >= columns.get(currentColumn).getSlots().length) return matchCount;

        if (getSlotAtCoords(currentColumn + colShift, currentRow + rowShift).getState() == playerNum)
            return checkRecurive(currentColumn + colShift, currentRow + rowShift, matchCount + 1, colShift, rowShift);

        return matchCount;
    }

    /**
     * Get a single BoardSlot object at the given column/row coordinates.
     * @param columnNum - the index of the column to get from.
     * @param slotNum - the index of the row to get from.
     * @return BoardSlot - the slot at the given coordinates.
     */
    private BoardSlot getSlotAtCoords(int columnNum, int slotNum) {
        return columns.get(columnNum).getSlots()[slotNum];
    }
}
