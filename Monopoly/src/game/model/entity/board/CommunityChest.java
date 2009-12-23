/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.board;

import game.model.entity.player.Player;
import game.model.configuration.GameConfiguration;
import game.model.entity.*;
import game.model.entity.card.Card;
import game.model.entity.card.CardStack;

/**
 * Representa um lugar do tipo Cofre comunitário no tabuleiro do monopoly.
 * @author Lidiany
 */
public class CommunityChest extends Place{

    @Override
    public void action(Player p) throws Exception {
        boolean isChestActive = GameConfiguration.
                getConfiguration().isActivateChestPlaces();
        if(isChestActive){
            Card card = CardStack.getCardStack().getChestCard();
            card.action(p);
        }
        
    }


}
