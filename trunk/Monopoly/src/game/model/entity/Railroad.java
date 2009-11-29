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

    public Railroad(int position, String name, float price, float hipoteca) {
        super.position = position;
        super.name = name;
        super.price = price;
        super.hipoteca = hipoteca;
        this.placeGroup = "railRoad";
        this.owner = new Player("bank", null);
    }

    /**
     * Tenta fazer o jogador comprar essa ferrovia, caso autobuy=true
     * ou, se a proprieade já possuir um dono, faz o jogador pagar o aluguel
     * @param p
     * @throws game.model.exceptions.NotEnoughMoneyException
     * @throws game.model.exceptions.NotInSaleException
     * @throws game.model.exceptions.ItAlreadyHasAnOnwerException
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
