/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
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
