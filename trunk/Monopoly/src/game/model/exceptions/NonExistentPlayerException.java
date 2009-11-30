/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * É lançada quando se tenta acessar um jogador não existente.
 * @author Lidiany
 */
public class NonExistentPlayerException extends GamePlayerException{

    public NonExistentPlayerException(String message) {
        super(message);
    }
    

}
