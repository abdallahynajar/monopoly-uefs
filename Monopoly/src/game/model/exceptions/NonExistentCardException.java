/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.exceptions;

/**
 * É lançada quando se busca uma carta não existente na pilha.
 * @author Lidiany
 */
public class NonExistentCardException extends GameException{

    public NonExistentCardException(String message) {
        super(message);
    }
}
