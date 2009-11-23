/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.entity;

import game.controller.GameController;
import game.model.exceptions.NoEnoughMoneyException;

/**
 *
 * @author UEFS\jmatos
 * Representa um lugar no tabuleiro
 */
public class Property extends PurchasablePlace {

    private long housePrice;
    private String colour;
    private int nHouses;
    private float rent[];

    public Property(int position, String name, long price, float rent[], long hipoteca, long housePrice, String colour) {
        super.name = name;
        this.price = price;
        this.rent = rent;
        this.hipoteca = hipoteca;
        this.housePrice = housePrice;
        this.colour = colour;
        this.position = position;
    }

    public long getnHouses() {
        return nHouses;
    }

    public void setnHouses(int nHouses) {
        this.nHouses = nHouses;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public long getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(long housePrice) {
        this.housePrice = housePrice;
    }

    public long getNHouses() {
        return nHouses;
    }

    public void setNHouses(int nHouses) {
        this.nHouses = nHouses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float rentValue() {
        return rent[nHouses];
    }

    /**
     * IMCOMPLETO. oferece a possibilidade de compra da proprieade ou pagamento
     * de aluguel, caso esta ainda esteja sem dono.
     * Falta a compra das casas.
     * @param p
     * @param gc
     */
    @Override
    public void action(Player p, GameController gc) {
        if (super.owner == null) {
            super.buyProperty(p, gc);
        } else if (super.owner == p) {
        } else {
            try {
                p.payRent(this.getOwner(), rentValue());
            } catch (NoEnoughMoneyException ne) {
                gc.removePlayer();
            }
        }
    }
}
