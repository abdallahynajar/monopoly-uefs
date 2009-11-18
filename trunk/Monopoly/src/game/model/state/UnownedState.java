/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.state;

import game.model.entity.Property;
import game.model.entity.Player;

/**
 *
 * @author Lidiany
 */
public class UnownedState implements PlaceState{

    public void landOnBy(Property place, Player player) {
        if(player.getAmountOfMoney() >= place.getPrice() && place.isPurchasable() ){
            player.buyProperty(place);
        }
         player.setAtualPlace(place);
    }

}
