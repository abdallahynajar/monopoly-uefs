/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.exceptions;

/**
 * Signals that an Game exception of some sort has occurred.
 * @author Lidiany
 */
public class GameException extends Exception{

    public GameException(String message) {
        super(message);
    }

}
