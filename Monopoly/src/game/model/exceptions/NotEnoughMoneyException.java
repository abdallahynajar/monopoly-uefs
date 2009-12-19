/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.exceptions;

/**
 * É lançada quando um jogador não tem dinheiro suficiente para uma determinada ação.
 * @author aluno
 */
public class NotEnoughMoneyException extends GamePlayerException{

    public NotEnoughMoneyException(String message) {
        super(message);
    }


}
