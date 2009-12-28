/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.card;

import game.model.entity.player.Player;
import game.model.exceptions.GameException;

/**
 *  Carta do tipo que permite ao jogador sair da prisão
 * @author Lidiany
 */
public class OutOfJail extends Card{

    /**
     * Jogador dono da Carta 
     */
    private Player owner;

    public OutOfJail(int cardNumber, String description, String type) {
        super(cardNumber, description, type);
    }

    public boolean hasOwner(){       
        return owner != null;
    }


    @Override
    public void action(Player p) throws GameException {
        if(owner == null){            
            p.addCard(this);
            owner = p;
        }else{
            throw new GameException("This card is already possessed by a player");
        }
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    

}
