/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.card;

import game.model.entity.player.Player;

/**
 *  Carta do tipo que permite ao jogador sair da prisão
 * @author Lidiany
 */
public class OutOfJail extends Card{

    /**
     * Jogador dono da Carta 
     */
    private Player owner;

    public OutOfJail(int cardNumber, String description) {
        super(cardNumber, description);
    }


    @Override
    public void action(Player p) {
        
    }

}
