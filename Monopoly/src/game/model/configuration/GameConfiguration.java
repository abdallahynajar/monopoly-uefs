/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.configuration;

/**
 *  Parametros de configuração do jogo.
 * @author UEFS\jmatos
 */
public class GameConfiguration {

    //habilita compra automática de propriedade;
    private boolean autoBuy = false;
    private float initialMoney = 1500;
    private float salaryBonus = 200;

    private static GameConfiguration gc;


    public static GameConfiguration getConfiguration(){
        if(gc == null){
            gc = new GameConfiguration();
        }
        return gc;
    }

    private GameConfiguration() {
    }

    public float getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(float salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

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
