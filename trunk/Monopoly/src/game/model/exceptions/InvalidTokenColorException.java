/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.exceptions;

/**
 * É lançada quando é passada uma cor de peão inválida no jogo.
 * @author Lidiany
 */
public class InvalidTokenColorException extends GameException{

    public InvalidTokenColorException(String message) {
        super(message);
    }


}
