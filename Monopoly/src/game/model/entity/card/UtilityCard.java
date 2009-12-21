/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity.card;
import game.model.entity.board.Board;
import game.model.entity.Player;
import game.model.entity.board.Place;
import game.model.exceptions.NonExistentPlaceException;
/**
 *
 * @author shaka
 */
public class UtilityCard extends Movement{

    public UtilityCard(int cardNumber, String description, boolean collectBonus) {
        super(cardNumber, description, null, collectBonus);

    }

    @Override
    public void action(Player p) throws NonExistentPlaceException, Exception{

        placeToGo = findNextUtility(p);
        p.walk(placeToGo, this.collectBonus);
    }

    private Place findNextUtility(Player p){
        Board board = p.getBoard();
        return board.;

    }

}
