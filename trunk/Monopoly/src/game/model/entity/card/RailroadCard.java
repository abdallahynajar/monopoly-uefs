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
public class RailroadCard extends MovementCard{
    public RailroadCard(int cardNumber, String description, boolean collectBonus, String type) {
        super(cardNumber, description, null, collectBonus,0, type);

    }

    @Override
    public void action(Player p) throws NonExistentPlaceException, Exception{

        placeToGo = findNextRailroad(p);
        p.walk(placeToGo.getPosition(), this.collectBonus);
         //já que tem q pagar o dobro, vai lá 2 vezes hehe
        p.walk(placeToGo.getPosition(), this.collectBonus);
    }

    private Place findNextRailroad(Player p) throws NonExistentPlaceException{
        Board board = Board.getBoard();
        return board.findNextRailroad(p.getAtualPlace());
    }
}
