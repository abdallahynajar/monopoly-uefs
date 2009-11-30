/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * É lançada quando é passado um comando errado no jogo.
 * @author Lidiany
 */
public class InvalidCommandException extends GameException{

    public InvalidCommandException(String message) {
        super(message);
    }

}
