/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity.card;

import game.model.entity.Player;
import game.model.entity.board.Place;

/**
 *
 * @author Lidiany
 *
 * Carta para movimentar o jogador pelo tabuleiro
 * 
 */
public class Movement extends Card{

    private Place placeToGo;

    private boolean collectBonus;

    public Movement(int cardNumber, String description, Place placeToGo, boolean collectBonus) {
        super(cardNumber, description);
        this.placeToGo = placeToGo;
        this.collectBonus = collectBonus;
    }

    @Override
    public void action(Player p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
