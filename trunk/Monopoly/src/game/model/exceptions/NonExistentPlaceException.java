/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * É lançada quando é se tenta acessar um lugar que não existe.
 * @author Lidiany
 */
public class NonExistentPlaceException extends GamePlaceException{

    public NonExistentPlaceException(String message) {
        super(message);
    }
    


}
