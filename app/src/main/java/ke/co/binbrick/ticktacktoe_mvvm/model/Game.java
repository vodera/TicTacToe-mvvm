package ke.co.binbrick.ticktacktoe_mvvm.model;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

/**
 * Created by vodera on 23/07/2018.
 */
public class Game {

    public static final String TAG = Game.class.getSimpleName();
    public static final int BOARD_SIZE = 3;

    public Player player1;
    public Player player2;

    public Player currentPlayer = player1;
    public Cell [][] cells;

    public MutableLiveData<Player> winner = new MutableLiveData<>();

    public Game(String playerOne, String playerTwo) {
        cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        player1 = new Player(playerOne, "x");
        player1 = new Player(playerTwo, "o");

        currentPlayer = player1;
    }

    public void switchPlayer() {
            currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public boolean hasGameEnded (){
        if(hasThreeSameHorizontalCells() || hasThreeSameDiagonalCells() || hasThreeSameVerticalCells()){
            winner.setValue(currentPlayer);
            return true;
        }

        if(isBoardFull()){
            winner.setValue(null);
            return true;
        }

        return false;
    }

    private boolean hasThreeSameHorizontalCells() {
        try {
            for (int i = 0; i<BOARD_SIZE; i++)
                if(areEqual(cells[i][0], cells[i][1], cells[1][2]))
                    return true;

            return false;
        }catch (NullPointerException e){
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    private boolean hasThreeSameDiagonalCells() {
        try {
            return areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                    areEqual(cells[0][2], cells[1][1], cells[2][0]);
        }catch (NullPointerException e){
            Log.e(TAG, e.getMessage());

            return false;
        }

    }

    private boolean hasThreeSameVerticalCells() {
        try {
            for (int i=0; i<BOARD_SIZE; i++)
                if (areEqual(cells[0][i], cells[1][i], cells[2][i]))
                    return true;
            return false;
        }catch (NullPointerException e){
            Log.e(TAG, e.getMessage());

            return false;
        }
    }

    private boolean isBoardFull() {
        for (Cell[] row : cells)
            for (Cell cell : row)
                if(cell ==  null || cell.isEmpty())
                    return false;
        return true;
    }

    /**
     * 2 cells are equal if:
     * - Both are none null
     * - Both have non null values
     * - both have equal values
     *
     * @param cells: Cells to check if are equal
     * @return
     */
    private boolean areEqual(Cell... cells) {
        if (cells == null || cells.length == 0)
            return false;

        for (Cell cell : cells)
            if (cell == null || cell.player.value == null || cell.player.value.length() == 0)
                return false;

        Cell comparisonBase = cells[0];
        for (int i = 1; i < cells.length; i++)
            if (!comparisonBase.player.value.equals(cells[i].player.value))
                return false;

        return true;
    }

    public void reset (){
        player1 = null;
        player2 = null;
        currentPlayer = null;
        cells = null;
    }













}
