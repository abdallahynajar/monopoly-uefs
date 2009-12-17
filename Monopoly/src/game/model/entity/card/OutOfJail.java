/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity.card;

import game.model.entity.Player;

/**
 *
 * @author Lidiany
 */
public class OutOfJail extends Card{

    public OutOfJail(int cardNumber, String description) {
        super(cardNumber, description);
    }


    @Override
    public void action(Player p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
