/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.comand;

import game.model.entity.Board;
import game.model.entity.Dice;
import game.model.entity.Player;

/**
 *
 * @author Lidiany
 */
public class RollDices implements PlayerCommand{

    private Board board;

    public RollDices(Board board) {
        this.board = board;
    }
    
    public void execute(Player player) {
        int firstDice = Dice.roll();
        int secondDice = Dice.roll();
        player.walk( firstDice + secondDice, board);
    }


  
}
