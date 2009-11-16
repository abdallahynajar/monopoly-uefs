/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.comand;

import game.controller.GameController;
import game.model.entity.Player;

/**
 *
 * @author Lidiany
 */
public class Exit implements PlayerCommand{

    private GameController gameController;

    public Exit(GameController gameController) {
        this.gameController = gameController;
    }

    public void execute(Player player) {
        gameController.removePlayerOfTheGame( player );
    }



}
