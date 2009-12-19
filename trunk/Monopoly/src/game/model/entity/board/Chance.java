/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity.board;

import game.model.entity.*;
import game.model.configuration.GameConfiguration;

/**
 * Representa um lugar do tipo Sorte/Revés no tabuleiro do monopoly.
 * @author Lidiany
 */
public class Chance extends Place{

    @Override
    public void action(Player p) throws Exception {
        //pega a porra da carta
        boolean isChanceActive = GameConfiguration.
                getConfiguration().isActivateChancePlaces();
        if(isChanceActive){
            //get a card
        }
    }

}
