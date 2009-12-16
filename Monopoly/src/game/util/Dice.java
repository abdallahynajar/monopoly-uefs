/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.util;

import java.util.Random;

/**
 *  Classe com um método estático para rolagem dos dados.
 * @author Lidiany
 */
public  class Dice {

    /**
     * Returno um número inteiro entre 1 e 6
     */
    public static int roll() {
        Random randGen = new Random();
        return randGen.nextInt(6) + 1;
    }
}
