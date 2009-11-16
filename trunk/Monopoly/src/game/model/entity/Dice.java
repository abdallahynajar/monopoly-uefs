/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.entity;

import java.util.Random;

/**
 *
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
