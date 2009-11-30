/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * É lançada quando é passado algum parâmetro errado no jogo.
 * @author Lidiany
 */
public class InvalidGameParametersException extends GameException{

    public InvalidGameParametersException(String message) {
        super(message);
    }

}
