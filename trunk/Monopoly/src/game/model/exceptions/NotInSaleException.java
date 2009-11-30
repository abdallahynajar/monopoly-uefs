/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * É lançada quando se tenta comprar um lugar que não esta à venda.
 * @author UEFS\jmatos
 */
public class NotInSaleException extends GamePlaceException {
    
    public NotInSaleException(String msg){
        super(msg);
    }
}
