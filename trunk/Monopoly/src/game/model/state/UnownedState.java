/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.state;

import game.model.entity.Place;
import game.model.entity.Player;

/**
 *
 * @author Lidiany
 */
public class UnownedState implements PlaceState{

    public void landOnBy(Place place, Player player) {
        if(player.getAmountOfMoney() >= place.getPrice() && place.getProperty().isPurchasable() ){
            player.buyProperty(place);
        }
         player.setAtualPlace(place);
    }

}
