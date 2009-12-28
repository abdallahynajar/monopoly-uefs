/**
    Universidade Estadual de Feira de Santana
    Padrões e Frameworks 2009.1
    Lidiany Cerqueira Santos   
    João de Matos
*/
package game.model.entity.card;

import game.model.entity.board.Jail;
import game.model.entity.board.Place;
import game.model.entity.player.Player;
import game.model.exceptions.NonExistentPlaceException;

/**
 *
 * @author Lidiany
 */
public class GoToJailCard extends Movement{

    public GoToJailCard(int cardNumber, String description, Place placeToGo, boolean collectBonus, int walk, String type) {
        super(cardNumber, description, placeToGo, collectBonus, walk, type);
    }

     @Override
    public void action(Player p) throws NonExistentPlaceException, Exception {            
            //System.out.println("                action de Movment: place position: " +goTo+ " card: "+ this.getDescription() );
            ((Jail) (placeToGo)).setJustVisiting( false );
            p.goTo(placeToGo.getPosition(), collectBonus);            

    }
    

}
