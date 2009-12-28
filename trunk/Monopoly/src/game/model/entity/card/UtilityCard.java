/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */

package game.model.entity.card;
import game.model.entity.board.Board;
import game.model.entity.player.Player;
import game.model.entity.board.Place;
import game.model.exceptions.NonExistentPlaceException;
/**
 *
 * @author shaka
 */
public class UtilityCard extends MovementCard{

    public UtilityCard(int cardNumber, String description, boolean collectBonus, String type) {
        super(cardNumber, description, null, collectBonus,0, type);

    }

    @Override
    public void action(Player p) throws NonExistentPlaceException, Exception{
        //System.out.println("                action de Utility:");
        placeToGo = findNextUtility(p);
        //System.out.println("                action de Utility: place position: " + placeToGo.getPosition() + " card: "+ this.getDescription() );
        p.walk(placeToGo.getPosition(), this.collectBonus);
    }

    private Place findNextUtility(Player p) throws NonExistentPlaceException{
        Board board = Board.getBoard();
        return board.findNextUtility(p.getAtualPlace());
    }

}
