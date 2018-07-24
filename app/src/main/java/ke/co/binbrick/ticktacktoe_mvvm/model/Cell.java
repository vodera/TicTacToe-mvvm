package ke.co.binbrick.ticktacktoe_mvvm.model;

import ke.co.binbrick.ticktacktoe_mvvm.utilities.StringUtility;

/**
 * Created by vodera on 23/07/2018.
 */
public class Cell {

    public Player player;

    public Cell(Player player) {
        this.player = player;
    }

    public boolean isEmpty() { return player == null || StringUtility.isNullOrEmpty(player.value); }
}
