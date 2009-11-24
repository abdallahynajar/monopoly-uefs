/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import game.controller.GameController;

/**
 *
 * @author Jneto
 */
public abstract class Place {

    protected String name;
    protected int position;
    protected String placeGroup;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public String getPlaceGroup() {
        return placeGroup;
    }

    public void setPlaceGroup(String placeGroup) {
        this.placeGroup = placeGroup;
    }


    public abstract void action(Player p, GameController gc);
}
