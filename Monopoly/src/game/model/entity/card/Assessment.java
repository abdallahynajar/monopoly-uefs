/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity.card;

import game.model.entity.*;

/**
 *
 * @author Lidiany
 * Carta para recebimento de bônus ou pagamento de multas
 */
public class Assessment extends Card{
    
    private int cardValue;
    private int feePerHotel;
    private int feePerHouse;
    private int feePerPlayer;

    public Assessment(int cardNumber, String description, int cardValue, int feePerHotel, int feePerHouse, int feePerPlayer) {
        super(cardNumber, description);
        this.cardValue = cardValue;
        this.feePerHotel = feePerHotel;
        this.feePerHouse = feePerHouse;
        this.feePerPlayer = feePerPlayer;
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
