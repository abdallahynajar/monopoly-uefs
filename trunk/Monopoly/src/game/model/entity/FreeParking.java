/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

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
