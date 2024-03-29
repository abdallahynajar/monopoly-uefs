/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.card;

import game.model.entity.player.Player;
import game.model.entity.*;

/**
 *
 * @author Lidiany
 */
public abstract class Card {
    private String description;
    private int cardNumber ;
    private String type;

    public Card(int cardNumber, String description, String type) {
        this.description = description;
        this.cardNumber = cardNumber;
        this.type = type;
    }

    public abstract void action(Player p) throws Exception;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
