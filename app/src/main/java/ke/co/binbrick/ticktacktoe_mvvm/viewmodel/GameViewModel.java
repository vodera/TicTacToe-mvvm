package ke.co.binbrick.ticktacktoe_mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayMap;

import ke.co.binbrick.ticktacktoe_mvvm.model.Cell;
import ke.co.binbrick.ticktacktoe_mvvm.model.Game;
import ke.co.binbrick.ticktacktoe_mvvm.model.Player;

import static ke.co.binbrick.ticktacktoe_mvvm.utilities.StringUtility.stringFromNumbers;

/**
 * Created by vodera on 23/07/2018.
 */
public class GameViewModel extends ViewModel {

    public ObservableArrayMap<String, String> cells;
    private Game game;

    public void init (String player1, String player2) {
        game = new Game(player1, player2);
        cells = new ObservableArrayMap<>();
    }

    public void onClickedCellAt(int row, int column){
        if(game.cells[row][column] == null){
            game.cells[row][column] = new Cell(game.currentPlayer);
            cells.put(stringFromNumbers(row, column),
                    game.currentPlayer.value);
            if(game.hasGameEnded()) {
                game.reset();
            }
                else
                    game.switchPlayer();
            }
        }

        public LiveData<Player> getWinner(){
        return game.winner;
    }
}
