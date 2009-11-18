/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 *
 * @author jmatos
 */
public class Tax extends Place{
    private long tax;

    public Tax(String name, long tax) {
        super.name = name;
        this.tax = tax;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }

    @Override
    public void action(Player p) {
        p.debit(tax);
    }



}
