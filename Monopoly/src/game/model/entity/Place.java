/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 *
 * @author Jneto
 */
public abstract class Place {

    protected String name;

    public String getName(){
        return name;
    }

    public abstract void action(Player p);
}
