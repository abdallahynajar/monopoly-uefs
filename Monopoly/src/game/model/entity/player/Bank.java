/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */

package game.model.entity.player;

import game.model.exceptions.BuildException;

/**
 * Contabiliza o que o banco possui, quanto a casas e hoteis
 * @author João Matos
 */
public class Bank {

    private static Bank bank = null;

    private int nHouses = 32;
    private int nHotels = 12;

    public Bank() {
    }

    public static Bank getBank(){
        if(bank == null){
            bank = new Bank();
        }
        return bank;
    }

    public static void cleanUp(){
        bank = null;
    }

    public void getHouse() throws BuildException{
        if(nHouses > 0){
            nHouses--;
            return;
        }

        throw new BuildException("No more houses available for sale");
    }

    public void getHotels() throws BuildException{
        if(nHotels > 0){
            nHotels--;
            nHouses+=4;
            return;
        }
        throw new BuildException("No more hotels available for sale");
    }


}
