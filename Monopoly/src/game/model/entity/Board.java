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
        places = new ArrayList<Place>();
        places.add(new Place("Mediterranean Avenue" , 60, 2, 10, 30, 90, 160, 250, 30, 50, "colour"));
        places.add(new Place("Community Chest 1"    , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Baltic Avenue"        , 60, 4, 20, 60, 180, 320, 450, 30, 50, "colour"));
        places.add(new Place("Income Tax"           , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Reading Railroad"     , 200, 0, 0, 0, 0, 0, 0, 100, 0, ""));
        places.add(new Place("Oriental Avenue"      , 100, 6, 30, 90, 270, 400, 550, 50, 50, "Light Blue"));
        places.add(new Place("Chance 1"             , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Vermont Avenue"       , 100, 6, 30, 90, 270, 400, 550, 50, 50, "Light Blue"));
        places.add(new Place("Connecticut Avenue"   , 120, 8, 40, 100, 300, 450, 600, 60, 50, "Light Blue"));
        places.add(new Place("Jail – Just Visiting" , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("St. Charles Place"    , 140, 10, 50, 150, 450, 625, 750, 70, 100, "colour2"));
        places.add(new Place("Electric Company"     , 150, 0, 0, 0, 0, 0, 0, 150, 0, ""));
        places.add(new Place("States Avenue"        , 140, 10, 50, 150, 450, 625, 750, 70, 100, "colour2"));
        places.add(new Place("Virginia Avenue"      , 160, 12, 60, 180, 500, 700, 900, 80, 100, "colour2"));
        places.add(new Place("Pennsylvania Railroad", 150, 0, 0, 0, 0, 0, 0, 150, 0, ""));
        places.add(new Place("St. James Place"      , 180, 14, 70, 200, 550, 750, 950, 90, 100, "Orange"));
        places.add(new Place("Community Chest 2"    , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Tennessee Avenue"     , 180, 14, 70, 200, 550, 750, 950, 90, 100, "Orange"));
        places.add(new Place("New York Avenue"      , 200, 16, 80, 220, 600, 800, 1000, 100, 100, "Orange"));
        places.add(new Place("Free Parking"         , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Kentucky Avenue"      , 220, 18, 90, 250, 700, 875, 1050, 110, 150, "Red"));
        places.add(new Place("Chance 2"             , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Indiana Avenue"       , 220, 18, 90, 250, 700, 875, 1050, 110, 150, "Red"));
        places.add(new Place("Illinois Avenue"      , 240, 20, 100, 300, 750, 925, 1100, 110, 150, "Red"));
        places.add(new Place("B & O Railroad"       , 200, 0, 0, 0, 0, 0, 0, 100, 0, ""));
        places.add(new Place("Atlantic Avenue"      , 260, 22, 110, 330, 800, 975, 1150, 130, 150, "Yellow"));
        places.add(new Place("Ventnor Avenue"       , 260, 22, 110, 330, 800, 975, 1150, 130, 150, "Yellow"));
        places.add(new Place("Water Works"          , 150, 0, 0, 0, 0, 0, 0, 150, 0, ""));
        places.add(new Place("Marvin Gardens"       , 280, 24, 120, 360, 850, 1025, 1200, 140, 150, "Yellow"));
        places.add(new Place("Go to Jail"           , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Pacific Avenue"       , 300, 26, 130, 390, 900, 1100, 1275, 150, 200, "Green"));
        places.add(new Place("North Carolina Avenue", 260, 22, 110, 330, 800, 975, 1150, 130, 150, "Green"));
        places.add(new Place("Community Chest 3"    , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Pennsylvania Avenue"  , 320, 28, 150, 450, 1000, 1200, 1400, 160, 200, "Green"));
        places.add(new Place("Short Line Railroad"  , 200, 0, 0, 0, 0, 0, 0, 100, 0, ""));
        places.add(new Place("Chance 3"             , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Park Place"           , 350, 35, 175, 500, 500, 1100, 1300, 1500, 175, "Blue"));
        places.add(new Place("Luxury Tax"           , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Place("Boardwalk"            , 400, 50, 200, 600, 1400, 1700, 2000, 200, 200, "Blue"));
        places.add(new Place("Go"                   , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
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
