/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.entity;

import game.model.exceptions.ItAlreadyHasAnOnwerException;
import game.model.exceptions.NotEnoughMoneyException;
import game.model.exceptions.NotInSaleException;

/**
 *
 * @author Jneto
 */
public class Railroad extends PurchasablePlace {

    private int nRailroad;

    public int getnRailroad() {
        return nRailroad;
    }

    public void setnRailroad(int nRailroad) {
        this.nRailroad = nRailroad;
    }

    /**
     * Oferece a propriedade para compra. Deve ser usado quando a propriedade não
     * tiver dono
     * @param p
     */
  /*  @Override
    public void buyProperty(Player player) throws NotEnoughMoneyException{    
        player.buyProperty(this);
        this.setOwner(player);
    }*/


//    @Override
//    public void setOwner(Player p) {
//        super.owner = owner;
//        nRailroad = 1;
//    }

    public Railroad(int position, String name, float price, float hipoteca) {
        super.position = position;
        super.name = name;
        super.price = price;
        super.hipoteca = hipoteca;
        this.placeGroup = "railRoad";
        this.owner = new Player("bank", null);
    }

    /**
     * IMCOMPLETO. Esse método não precisa estar completo para atender os requisitos
     * até a user history 4
     * Oferece a propriedade para compra, não esta não tenha dono ou paga um aluguel
     * caso esta tenha.
     * Ainda falta oferecer a possibilidade pra compra de ferrovias
     * @param p
     * @param gc
     */
    public void action(Player p) throws NotEnoughMoneyException, NotInSaleException, ItAlreadyHasAnOnwerException {
            if ( owner.getName().equals("bank") ) {              
                buyProperty(p);
            } else {
                p.payRent(owner, getRunning());
            }
    }

    public float getRunning() {
        return 25 * nRailroad;
    }

    /**
     * Um dia tratara da compra das ferrovias
     * @param p
     * @param gc
     */
    public void buyRailroad(Player p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
