/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity.card;

import game.model.entity.*;

/**
 *
 * @author Lidiany
 */
public class FinancialCard extends Card{
    
    private int cardValue;

    public FinancialCard(int cardNumber, String description, int cardValue) {
        super(cardNumber, description);
        this.cardValue = cardValue;
    }

    @Override
    public void action(Player p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

}
