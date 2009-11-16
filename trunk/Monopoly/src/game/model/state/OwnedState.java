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
public class OwnedState implements PlaceState{

    public void landOnBy(Place place, Player player) {
         if (place.getOwner() != player ) {
            player.debit( place.rentValue() );
            place.getOwner().credit( place.rentValue() );
         }

           player.setAtualPlace(place);
    }

}
