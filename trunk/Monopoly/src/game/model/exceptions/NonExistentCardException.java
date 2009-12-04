/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * É lançada quando se busca uma carta não existente na pilha.
 * @author Lidiany
 */
public class NonExistentCardException extends GameException{

    public NonExistentCardException(String message) {
        super(message);
    }
}
