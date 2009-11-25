/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.entity;

import game.model.exceptions.NotEnoughMoneyException;

/**
 *
 * @author Jneto
 */
public class Utility extends PurchasablePlace {

    public Utility(int position, String name, long price, long hipoteca) {
        super.position = position;
        super.name = name;
        super.price = price;
        super.hipoteca = hipoteca;
        this.placeGroup = "utility";
        this.owner = new Player("bank", null);
    }

    //Implementar debitando dado*4ou10. 4 quando o jogador só tiver 1, 10 quando
    //Tiver 2. Se não tiver ningém, é claro q há a opçao de comprar.
    public void action(Player p) throws NotEnoughMoneyException {
        if (!owner.equals(p)) {
            if (owner == null || owner.getName().equals("bank")) {
                p.buyProperty(this);
            } else {
                p.payRent(owner, price);
            }
        }
    }
}
