/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

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


    public Railroad(int position, String name, float price, float hipoteca) {
        super.position = position;
        super.name = name;
        super.price = price;
        super.hipoteca = hipoteca;
    }

    //pagar $25 por cada ferrovia. no máximo são 4
    public void action(Player p) {
        if (super.owner == null){

        }else if (super.owner == p){

        }else{

        }
    }

}
