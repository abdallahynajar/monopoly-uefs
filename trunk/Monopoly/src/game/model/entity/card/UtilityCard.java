/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class UtilityCard extends Movement{

    public UtilityCard(int cardNumber, String description, boolean collectBonus) {
        super(cardNumber, description, null, collectBonus,0);

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
