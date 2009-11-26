/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import game.controller.GameController;
import game.model.exceptions.NotEnoughMoneyException;

/**
 *
 * @author jmatos
 */
public class Tax extends Place{
    private long tax;

    public Tax(int position, String name, long tax) {
        super.position = position;
        super.name = name;
        this.tax = tax;
        this.placeGroup = "tax";
    }

    public float getTax() {
        return tax;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }

    @Override
    public void action(Player p) throws NotEnoughMoneyException {
//          System.out.println("-----------------");
//        System.out.println("Pagando taxa" + p.getName() + " : "+ p.getAmountOfMoney() +" valor " +this.tax);
        p.debit(tax);
//        System.out.println(" AMoney "+ p.getAmountOfMoney());
    }
}
