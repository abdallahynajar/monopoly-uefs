/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import game.model.configuration.GameConfiguration;

/**
 *
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
