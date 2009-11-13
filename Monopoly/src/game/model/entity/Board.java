/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import java.util.ArrayList;

/**
 *
 * @author UEFS\jmatos
 * Representa o tabuleiro
 */
public class Board {

    private ArrayList<Place> places;

    public Board() {
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    /***
     * Busca um lugar no tabuleiro pelo nome
     * @author Lidiany
     * @param name  O nome do lugar a ser pesquisado
     * @return  a entidade Place encontrada pela busca
     */
    public Place getPlaceByName(String name){
        for (Place place : places) {
            if(place.getName().equalsIgnoreCase(name)){
                return place;
            }
        }
        return null;
    }

}
