/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */

package game.model.entity.card;

import game.model.entity.board.Property;
import game.model.entity.board.PurchasablePlace;
import game.model.entity.player.Player;

/**
 *
 * @author Luis Eduardo
 */
public class RepairCard extends Card{


    private int feePerHouse;
    private int feePerHotel;

    public RepairCard(int cardNumber, String description, String type, int feePerHouse, int feePerHotel) {
        super(cardNumber, description, type);
        this.feePerHouse = feePerHouse;
        this.feePerHotel = feePerHotel;
    }


    @Override
    public void action(Player p) throws Exception {
        for(PurchasablePlace pp: p.getItsPropertys()){
            if(pp instanceof Property){
                Property property = (Property)pp;
                p.debit(getRepairValue(property));
            }
        }
    }

    private int getRepairValue(Property p){

        if(p.getnHouses()> 4)
            return feePerHotel;
        else
            return (int) (p.getNHouses() * feePerHouse);
    }

}
