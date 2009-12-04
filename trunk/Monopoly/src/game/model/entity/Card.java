/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 *
 * @author Lidiany
 */
public abstract class Card {
    private String description;
    private int cardNumber ;

    public Card(int cardNumber, String description) {
        this.description = description;
        this.cardNumber = cardNumber;
    }

    public abstract void action(Player p);

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
