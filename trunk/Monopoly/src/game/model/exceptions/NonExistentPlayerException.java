/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.exceptions;

/**
 * É lançada quando se tenta acessar um jogador não existente.
 * @author Lidiany
 */
public class NonExistentPlayerException extends GamePlayerException{

    public NonExistentPlayerException(String message) {
        super(message);
    }
    

}
