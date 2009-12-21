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
public class RailroadCard extends Movement{
    public RailroadCard(int cardNumber, String description, boolean collectBonus) {
        super(cardNumber, description, null, collectBonus,0);

    }

    @Override
    public void action(Player p) throws NonExistentPlaceException, Exception{

        placeToGo = findNextRailroad(p);
        p.walk(placeToGo.getPosition(), this.collectBonus);
    }

    private Place findNextRailroad(Player p) throws NonExistentPlaceException{
        Board board = p.getBoard();
        return board.findNextRailroad(p.getAtualPlace());
    }
}
