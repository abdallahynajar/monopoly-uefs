/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 * Representa uma casa no tabuleiro do monopoly. Possui metodos e atributos
 * comuns a todas as casas, porém, ações mais específicas são implementadas em
 * outras classes, que estendem esta.
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

    public abstract void action(Player p)throws Exception;
}
