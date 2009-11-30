/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * É lançada quando é passado um nome de jogador inválido no jogo.
 * @author Lidiany
 */
public class InvalidPlayerNameException extends GamePlayerException{

    public InvalidPlayerNameException(String message) {
        super(message);
    }

}
