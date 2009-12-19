/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.exceptions;

/**
 * É lançada quando é passado um comando errado no jogo.
 * @author Lidiany
 */
public class InvalidCommandException extends GameException{

    public InvalidCommandException(String message) {
        super(message);
    }

}
