/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 *
 * É lançada quando é se tenta comprar um lugar não comprável.
 * @author Lidiany
 */
public class NonPurchasablePlaceException extends GamePlaceException{

    public NonPurchasablePlaceException(String message) {
        super(message);
    }

}
