/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */

package game.model.entity.board;

import game.model.entity.*;

/**
 *  Representa a parada livre no tabuleiro do Monopoly
 * @author jmatos
 */
public class FreeParking extends Place {

    public FreeParking(int position, String name, String placeGroup) {
        super.position = position;
        super.name = name;
        this.placeGroup = placeGroup;
    }

    /**
     *
     * @param p
     */
    @Override
    public void action(Player p) {
        //não faz nada.
    }

}
