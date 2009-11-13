/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 *
 * @author Lidiany
 */
public class Bank {

    private long amountOfMoney;

    public Bank() {
       
    }
    public Bank(long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

}
