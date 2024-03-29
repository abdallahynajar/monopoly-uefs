/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */

package game.model.entity.board;

import game.model.entity.player.Player;
import game.model.configuration.GameConfiguration;
import game.model.entity.card.Card;
import game.model.entity.card.CardStack;

/**
 *
 * @author shaka
 */
public class Chest extends Place{

    public Chest(int position, String name, String placeGroup) {
        super.position = position;
        super.name = name;
        super.placeGroup = placeGroup;
    }

    @Override
    public void action(Player p) throws Exception {
        //pega a porra da carta

        //System.out.println("chegou no action de Chest");
        boolean isChestActive = GameConfiguration.
                getConfiguration().isActivateChestPlaces();
        if(isChestActive){
           // System.out.println("    O jogo está configurado pra chest funcionar");
            Card card = CardStack.getCardStack().getChestCard();        
            card.action(p);
        }
    }

}
