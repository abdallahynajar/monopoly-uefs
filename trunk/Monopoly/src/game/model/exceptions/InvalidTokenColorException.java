/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * É lançada quando é passada uma cor de peão inválida no jogo.
 * @author Lidiany
 */
public class InvalidTokenColorException extends GameException{

    public InvalidTokenColorException(String message) {
        super(message);
    }


}
