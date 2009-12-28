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
 * Representa um lugar do tipo Sorte/Revés no tabuleiro do monopoly.
 * @author Lidiany
 */
public class Chance extends Place{

    public Chance(int position, String name, String placeGroup) {
        super.position = position;
        super.name = name;
        super.placeGroup = placeGroup;
    }

    @Override
    public void action(Player p) throws Exception {
        //pega a porra da carta

        //System.out.println("chegou no action de Chance");
        boolean isChanceActive = GameConfiguration.
                getConfiguration().isActivateChancePlaces();
        if(isChanceActive){
            //System.out.println("    O jogo está configurado pra change funcionar");
            Card card = CardStack.getCardStack().getChanceCard();
            card.action(p);
        }
    }

}
