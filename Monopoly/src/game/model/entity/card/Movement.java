/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.card;

import game.model.entity.Player;
import game.model.entity.board.Place;
import game.model.exceptions.NonExistentPlaceException;

/**
 *
 * @author Lidiany
 *
 * Carta para movimentar o jogador pelo tabuleiro
 * 
 */
public class Movement extends Card{

    protected Place placeToGo;

    protected boolean collectBonus;
    protected int walk;

    public Movement(int cardNumber, String description, Place placeToGo, boolean collectBonus, int walk) {
        super(cardNumber, description);
        this.placeToGo = placeToGo;
        this.collectBonus = collectBonus;
        this.walk = walk;
    }

    @Override
    public void action(Player p) throws NonExistentPlaceException, Exception {
        
        if(walk==0){
            //System.out.println("                action de Movment: place position: " + placeToGo.getPosition() + " card: "+ this.getDescription() );
            p.walk(placeToGo.getPosition(), collectBonus);
        }else{

            int goTo = p.getAtualPosition() + walk;
            //System.out.println("                action de Movment: place position: " +goTo+ " card: "+ this.getDescription() );
            p.goTo(goTo, collectBonus);
        }

    }

}
