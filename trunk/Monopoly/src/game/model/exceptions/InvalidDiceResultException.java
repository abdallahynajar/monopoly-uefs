/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * É lançada quando é passado um valor de dado inválido (valor <1 ou > 6). 
 * @author Lidiany
 */
public class InvalidDiceResultException extends GameException{

    public InvalidDiceResultException(String message) {
        super(message);
    }

}
