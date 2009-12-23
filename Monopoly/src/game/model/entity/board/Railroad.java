/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */

package game.model.entity.board;

import game.model.entity.player.Player;
import game.model.entity.*;
import game.model.exceptions.GamePlaceException;
import game.model.exceptions.NotEnoughMoneyException;
import game.model.exceptions.NotInSaleException;

/**
 * Representa uma ferrovia no tabuleiro do monopoly
 * @author Jneto
 */
public class Railroad extends PurchasablePlace {

    private int nRailroad;

    public int getnRailroad() {
        return nRailroad;
    }

    public void setnRailroad(int nRailroad) {
        this.nRailroad = nRailroad;
    }

    public Railroad(int position, String name, float price, float hipoteca) {
        super.position = position;
        super.name = name;
        super.price = price;
        super.hipoteca = hipoteca;
        this.placeGroup = "railRoad";       
    }

    /**
     * Tenta fazer o jogador comprar essa ferrovia, caso autobuy=true
     * ou, se a proprieade já possuir um dono, faz o jogador pagar o aluguel
     * @param p
     * @throws game.model.exceptions.NotEnoughMoneyException
     * @throws game.model.exceptions.NotInSaleException
     * @throws game.model.exceptions.ItAlreadyHasAnOnwerException
     */
    public void action(Player p) throws NotEnoughMoneyException, NotInSaleException, GamePlaceException {
            if ( owner.getName().equals("bank") ) {              
                buyProperty(p);
            } else {
                p.payRent(owner, getRunning());
            }
    }

    public float getRunning() {
        return 25 * nRailroad;
    }

}
