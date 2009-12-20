/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.card;

import game.model.entity.Player;
import game.model.entity.board.Place;

/**
 *
 * @author Lidiany
 *
 * Carta para movimentar o jogador pelo tabuleiro
 * 
 */
public class Movement extends Card{

    private Place placeToGo;

    private boolean collectBonus;

    public Movement(int cardNumber, String description, Place placeToGo, boolean collectBonus) {
        super(cardNumber, description);
        this.placeToGo = placeToGo;
        this.collectBonus = collectBonus;
    }

    @Override
    public void action(Player p) {
        p.setAtualPlace(placeToGo);
    }



}
