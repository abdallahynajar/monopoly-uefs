/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

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
    
    public abstract void action(Player p);

}
