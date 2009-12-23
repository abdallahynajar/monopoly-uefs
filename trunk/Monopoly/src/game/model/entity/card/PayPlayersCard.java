/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity.card;

import game.model.entity.player.Player;
import java.util.ArrayList;
import game.model.GameModel;
/**
 * Representa todas as cartas em que um player tem que pagar alguma taxa a todos
 * os outros
 * @author shaka
 */
public class PayPlayersCard extends Card {

    private int amountToPay;

    public PayPlayersCard(int cardNumber, String description, int amountToPay) {
        super(cardNumber, description);
        this.amountToPay = amountToPay;
    }

    @Override
    public void action(Player p) throws Exception {

        ArrayList<Player> players = GameModel.getGameModel().getPlayers();

        for(Player player : players){
            if(player != p && player.isPlaying()){
                p.payRent(player, amountToPay);
            }
        }

    }

}
