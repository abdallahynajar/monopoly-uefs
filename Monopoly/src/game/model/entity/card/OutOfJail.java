/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
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
