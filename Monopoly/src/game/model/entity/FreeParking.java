/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import game.controller.GameController;

/**
 *
 * @author jmatos
 */
public class FreeParking extends Place {

    public FreeParking(int position, String name, String placeGroup) {
        super.position = position;
        super.name = name;
        this.placeGroup = placeGroup;
    }


    @Override
    public void action(Player p, GameController gc) {
        //não faz nada.
    }

}
