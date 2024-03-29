/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.card;

import game.model.entity.player.Player;
import game.model.entity.*;
import game.model.exceptions.NotEnoughMoneyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lidiany
 * Carta para recebimento de bônus ou pagamento de multas
 */
public class AssessmentCard extends Card {

    private int cardValue;
    private int feePerHotel;
    private int feePerHouse;
    private int feePerPlayer;

    public AssessmentCard(int cardNumber, String description, int cardValue, int feePerHotel, int feePerHouse, int feePerPlayer, String type) {
        super(cardNumber, description, type);
        this.cardValue = cardValue;
        this.feePerHotel = feePerHotel;
        this.feePerHouse = feePerHouse;
        this.feePerPlayer = feePerPlayer;
    }

    @Override
    public void action(Player p) throws NotEnoughMoneyException  {
        if (cardValue > 0) {
            p.credit(cardValue);
        } else {
            p.debit(-cardValue);
        }
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getFeePerHotel() {
        return feePerHotel;
    }

    public void setFeePerHotel(int feePerHotel) {
        this.feePerHotel = feePerHotel;
    }

    public int getFeePerHouse() {
        return feePerHouse;
    }

    public void setFeePerHouse(int feePerHouse) {
        this.feePerHouse = feePerHouse;
    }

    public int getFeePerPlayer() {
        return feePerPlayer;
    }

    public void setFeePerPlayer(int feePerPlayer) {
        this.feePerPlayer = feePerPlayer;
    }
}
