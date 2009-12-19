/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
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
