/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
