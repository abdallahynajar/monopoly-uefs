/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.configuration;

/**
 *
 * @author UEFS\jmatos
 */
public class Configuration {

    //habilita compra automática de propriedade;
    public boolean autoBuy = false;
    public float initialMoney = 1500;

    public boolean isAutoBuy() {
        return autoBuy;
    }

    public void setAutoBuy(boolean autoBuy) {
        this.autoBuy = autoBuy;
    }

    public float getInitialMoney() {
        return initialMoney;
    }

    public void setInitialMoney(float initialMoney) {
        this.initialMoney = initialMoney;
    }
    

}
