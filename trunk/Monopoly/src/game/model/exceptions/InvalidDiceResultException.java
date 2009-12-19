/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.exceptions;

/**
 * É lançada quando é passado um valor de dado inválido (valor <1 ou > 6). 
 * @author Lidiany
 */
public class InvalidDiceResultException extends GameException{

    public InvalidDiceResultException(String message) {
        super(message);
    }

}
