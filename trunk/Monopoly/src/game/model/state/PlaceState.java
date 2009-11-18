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
public interface PlaceState {

    public void landOnBy(Property place, Player player);

}
