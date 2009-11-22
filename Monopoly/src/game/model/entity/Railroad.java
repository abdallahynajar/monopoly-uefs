/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import game.controller.GameController;

/**
 *
 * @author Jneto
 */
public class Railroad extends PurchasablePlace{
    private int nRailroad;

    public int getnRailroad() {
        return nRailroad;
    }

    public void setnRailroad(int nRailroad) {
        this.nRailroad = nRailroad;
    }

    @Override
    public  void setOwner(Player p){
        super.owner = owner;
        nRailroad = 1;

    }
    public Railroad(int position, String name, float price, float hipoteca) {
        super.position = position;
        super.name = name;
        super.price = price;
        super.hipoteca = hipoteca;
    }

    //pagar $25 por cada ferrovia. no máximo são 4
    public void action(Player p, GameController gc) {
        if (super.owner == null){
            super.buyProperty(p, gc);
        }else if (super.owner == p){

        }else{

        }
    }

    public float getRunning(){
        return 25*nRailroad;
    }

}
