/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.entity;

import game.model.exceptions.NotAvailableForSaleException;
import game.model.exceptions.NotEnoughMoneyException;

/**
 *
 * @author UEFS\jmatos
 * Representa um lugar no tabuleiro
 */
public class Property extends PurchasablePlace {

    private long housePrice;
    
    private int nHouses;
    private float rent[];

    public Property(int position, String name, long price, float rent[], long hipoteca, long housePrice, String placeGroup) {
        super.name = name;
        this.price = price;
        this.rent = rent;
        this.hipoteca = hipoteca;
        this.housePrice = housePrice;
        this.placeGroup = placeGroup;
        this.position = position;
        this.owner = new Player("bank", null);
    }

    public long getnHouses() {
        return nHouses;
    }

    public void setnHouses(int nHouses) {
        this.nHouses = nHouses;
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

    public float getRent() {
        return rent[nHouses];
    }


     /**
    *
     */
    @Override
    public void action(Player p) throws NotEnoughMoneyException, NotAvailableForSaleException{
        if(!owner.equals(p)){
            if ( (owner == null || owner.getName().equals("bank"))) {
               p.buyProperty(this);
            } else {
               p.payRent( this.getOwner(), this.getRent() );
            }
        }
    }
  
}
