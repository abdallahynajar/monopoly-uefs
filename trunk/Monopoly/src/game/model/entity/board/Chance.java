/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.board;

import game.model.entity.*;
import game.model.configuration.GameConfiguration;
import game.model.entity.card.Card;
import game.model.entity.card.CardStack;

/**
 * Representa um lugar do tipo Sorte/Revés no tabuleiro do monopoly.
 * @author Lidiany
 */
public class Chance extends Place{

    @Override
    public void action(Player p) throws Exception {
        //pega a porra da carta
        boolean isChanceActive = GameConfiguration.
                getConfiguration().isActivateChancePlaces();
        if(isChanceActive){
            Card card = CardStack.getCardStack().getChanceCard();
            card.action(p);
        }
    }

}
