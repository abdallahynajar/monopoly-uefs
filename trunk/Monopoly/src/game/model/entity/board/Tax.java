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
 *  Representas as taxas no tabuleiro do monopoly
 * @author jmatos
 */
public class Tax extends Place{
    private long tax;

    public Tax(int position, String name, long tax) {
        super.position = position;
        super.name = name;
        this.tax = tax;
        this.placeGroup = "tax";
    }

    public float getTax() {
        return tax;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }
    /**
     * Faz o usuário pagar a taxa.
     * @param p
     * @throws game.model.exceptions.NotEnoughMoneyException
     */
    @Override
    public void action(Player p) throws NotEnoughMoneyException {
        p.debit(tax);

    }
}
