/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
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
