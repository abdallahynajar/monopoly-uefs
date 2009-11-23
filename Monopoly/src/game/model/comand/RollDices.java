/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.comand;

import game.controller.GameController;
import game.model.entity.Dice;
import game.model.entity.Place;
import game.model.entity.Player;

/**
 *
 * @author Lidiany
 */
public class RollDices implements PlayerCommand{

    private GameController gameController;

    public RollDices(GameController gameController) {
        this.gameController = gameController;
    }
    
    public void execute(Player player) {
        int firstDice = Dice.roll();
        int secondDice = Dice.roll();

        Place atualPlace = player.walk( firstDice + secondDice, gameController.getGameBoard() );
        atualPlace.action(player, gameController);
        gameController.showPlayerMove(firstDice, secondDice);

    }


  
}
