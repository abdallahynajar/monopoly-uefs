/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import game.model.configuration.GameConfiguration;
import game.model.exceptions.ItAlreadyHasAnOnwerException;
import game.model.exceptions.NotEnoughMoneyException;
import game.model.exceptions.NotInSaleException;

/**
 *
 * @author UEFS\jmatos
 */
public abstract class PurchasablePlace extends Place{

    protected float price;
    protected float hipoteca;
    protected Player owner;

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public float getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(float hipoteca) {
        this.hipoteca = hipoteca;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Oferece a propriedade para compra. Deve ser usado quando a propriedade não
     * tiver dono
     * @param p
     */
    public void buyProperty(Player player) throws NotEnoughMoneyException, NotInSaleException, ItAlreadyHasAnOnwerException{
        GameConfiguration gc = GameConfiguration.getConfiguration();
        if(gc.isAutoBuy()){
            player.buyProperty();
        }
    }

    public void returnToBank(){
        this.owner = new Player("bank", null);
    }
}
