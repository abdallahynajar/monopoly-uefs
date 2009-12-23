/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity.board;

import game.model.entity.Player;
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

        System.out.println("chegou no action de Chest");
        boolean isChestActive = GameConfiguration.
                getConfiguration().isActivateChestPlaces();
        if(isChestActive){
            System.out.println("    O jogo está configurado pra chest funcionar");
            Card card = CardStack.getCardStack().getChestCard();
            System.out.println("        Card da vez: " + card.getDescription() + " numero: " + card.getCardNumber());
            card.action(p);
        }
    }

}
