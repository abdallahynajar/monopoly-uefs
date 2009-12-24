/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity.card;

import game.model.entity.player.Player;
import java.util.ArrayList;
import game.model.GameModel;

/**
 *
 * @author shaka
 */
public class CollectPlayersCard extends Card {

    private int amountToPay;

    public CollectPlayersCard(int cardNumber, String description, int amountToPay, String type) {
        super(cardNumber, description, type);
        this.amountToPay = amountToPay;
    }

    @Override
    public void action(Player p) throws Exception {

        ArrayList<Player> players = GameModel.getGameModel().getPlayers();

        for(Player player : players){
            if(player != p && player.isPlaying()){
                player.payRent(p, amountToPay);
            }
        }

    }

}
