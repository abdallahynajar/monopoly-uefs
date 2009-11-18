/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 *
 * @author Jneto
 */
public class Railroad extends Place{
    private float price;
    private float hipoteca;
    private int nRailroad;

    public int getnRailroad() {
        return nRailroad;
    }

    public void setnRailroad(int nRailroad) {
        this.nRailroad = nRailroad;
    }


    public Railroad(String name, float price, float hipoteca) {
        super.name = name;
        this.price = price;
        this.hipoteca = hipoteca;
    }

    //pagar $25 por cada ferrovia. no máximo são 4
    public void action(Player p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
