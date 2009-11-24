/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import game.controller.GameController;

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
    public void action(Player p, GameController gc) {
        p.debit(tax);
    }



}
