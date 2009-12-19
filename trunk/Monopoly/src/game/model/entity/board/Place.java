/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.board;

import game.model.entity.*;

/**
 * Representa uma casa no tabuleiro do monopoly. Possui metodos e atributos
 * comuns a todas as casas, porém, ações mais específicas são implementadas em
 * outras classes, que estendem esta.
 * @author Jneto
 */
public abstract class Place {

    /**
     * Nome do lugar
     */
    protected String name;
    /**
     * Posição do lugar no tabuleiro
     */
    protected int position;
    /**
     * Grupo do qual o lugar faz parte
     */
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
