/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.board;

import game.model.entity.*;
import game.model.exceptions.NotEnoughMoneyException;

/**
 *  Representa serviços públicos no tabuleiro do monopoly
 * @author Jneto
 */
public class Utility extends PurchasablePlace {

    public Utility(int position, String name, long price, long hipoteca) {
        this.position = position;
        this.name = name;
        this.price = price;
        this.hipoteca = hipoteca;
        this.placeGroup = "utility";       
    }

    /**
     * Por enquanto não faz nada
     * @param p
     * @throws NotEnoughMoneyException
     */
    public void action(Player p) throws NotEnoughMoneyException {
//         if ( !(owner.getId() == p.getId()) ) {
//            if ( owner.getName().equals("bank") ) {
//                  System.out.println("-----------------");
//               System.out.println("Comprando utility" + p.getName() + " : "+ p.getAmountOfMoney() +" valor " +price);
//                buyProperty(p);
//                System.out.println(" AMoney "+ p.getAmountOfMoney());
//            } else {
//                  System.out.println("-----------------");
//                System.out.println(" Pagando aluguel "+ p.getName() + " : "+ p.getAmountOfMoney() +" valor " + price);
//                p.debit( price );
////                System.out.println(" AMoney "+ p.getAmountOfMoney());
//            }
//        }
    }
}
