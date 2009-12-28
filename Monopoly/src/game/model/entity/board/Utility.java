/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.board;

import game.model.configuration.GameConfiguration;
import game.model.entity.player.Player;
import game.model.entity.*;
import game.model.exceptions.GamePlaceException;
import game.model.exceptions.NotEnoughMoneyException;
import game.model.exceptions.NotInSaleException;
import game.util.Dice;

/**
 *  Representa serviços públicos no tabuleiro do monopoly
 * @author Jneto
 */
public class Utility extends PurchasablePlace {

    private int rentFactor;

    public Utility(int position, String name, long price, long hipoteca) {
        this.position = position;
        this.name = name;
        this.price = price;
        this.hipoteca = hipoteca;
        this.placeGroup = "utility";
        rentFactor = 4;
    }

    /**
     * O jogador compra o serviço ou paga o aluguel ao dono
     * @param p o jogador que passou pelo lugar
     * @throws NotEnoughMoneyException caso o jogador não tenha dinheiro para comprar ou pagar
     * @throws NotInSaleException caso o lugar não esteja a venda
     */
    public void action(Player p) throws NotEnoughMoneyException, NotInSaleException, GamePlaceException {
        boolean isActivateUtilityPlaces = GameConfiguration.getConfiguration().isActivateUtilityPlaces();
        if (isActivateUtilityPlaces) {
            if (owner.getName().equals("bank")) {
                buyProperty(p);
            } else {
                Dice dice = Dice.getDice();
                int dicesResult = dice.getFirstDiceResult() + dice.getSecondDiceResult();
                p.payRent(owner, dicesResult * rentFactor );
            }
        }
    }

    public void setRentFactor(int rentFactor) {
        this.rentFactor = rentFactor;
    }

    
}
