/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.entity;

import game.model.exceptions.ItAlreadyHasAnOnwerException;
import game.model.exceptions.NotAvailableForSaleException;
import game.model.exceptions.NotEnoughMoneyException;
import game.model.exceptions.NotInSaleException;

/**
 * Representa uma propriedade no tabuleiro.
 * @author jmatos
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
        this.owner = new Player("bank", null); //a principio, todas a propriedades são do banco
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
      * Tenta fazer o jogador comprar essa propriedade, caso autobuy=true
      * ou, se a proprieade já possuir um dono, faz o jogador pagar o aluguel
      * @param p jogador que vai comprar ou pagar o aluguel, ou não vai fazer nada
      * @throws game.model.exceptions.NotEnoughMoneyException 
      * @throws game.model.exceptions.NotAvailableForSaleException
      * @throws game.model.exceptions.NotInSaleException
      * @throws game.model.exceptions.ItAlreadyHasAnOnwerException
      */
    @Override
    public void action(Player p) throws NotEnoughMoneyException, NotAvailableForSaleException, NotInSaleException, ItAlreadyHasAnOnwerException{
             if ( owner.getName().equals("bank") ) {
                buyProperty(p);
            } else {
                p.payRent(owner, getRent());
            }
    }
  
}
