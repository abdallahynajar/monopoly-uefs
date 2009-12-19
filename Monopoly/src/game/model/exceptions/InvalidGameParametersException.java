/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
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
