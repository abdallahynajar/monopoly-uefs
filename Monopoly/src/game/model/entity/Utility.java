/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 *
 * @author Jneto
 */
public class Utility extends PurchasablePlace{

    public Utility(int position, String name,long price, long hipoteca) {
        super.position = position;
        super.name = name;
        super.price = price;
        super.hipoteca = hipoteca;
    }


    //Implementar debitando dado*4ou10. 4 quando o jogador só tiver 1, 10 quando
    //Tiver 2. Se não tiver ningém, é claro q há a opçao de comprar.
    public void action(Player p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
