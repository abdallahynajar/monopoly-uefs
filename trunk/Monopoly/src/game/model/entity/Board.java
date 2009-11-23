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
        int position = 1;
        places.add(new Property( position++, "Mediterranean Avenue" , 60, new float[] {2, 10, 30, 90, 160, 250}, 30, 50, "colour"));
        places.add(new FreeParking( position++, "Community Chest 1"));
        places.add(new Property( position++, "Baltic Avenue"        , 60, new float[] {4, 20, 60, 180, 320, 450}, 30, 50, "colour"));
        places.add(new Tax( position++, "Income Tax", 200));
        places.add(new Railroad( position++, "Reading Railroad", 200, 100));
        places.add(new Property( position++, "Oriental Avenue"      , 100, new float[] {6, 30, 90, 270, 400, 550}, 50, 50, "Light Blue"));
        places.add(new FreeParking( position++, "Chance 1"));
        places.add(new Property( position++, "Vermont Avenue"       , 100, new float[] {6, 30, 90, 270, 400, 550}, 50, 50, "Light Blue"));
        places.add(new Property( position++, "Connecticut Avenue"   , 120, new float[] {8, 40, 100, 300, 450, 600}, 60, 50, "Light Blue"));
        places.add(new FreeParking( position++, "Jail – Just Visiting"));
        places.add(new Property( position++, "St. Charles Place"    , 140, new float[] {10, 50, 150, 450, 625, 750}, 70, 100, "colour2"));
        places.add(new Utility( position++, "Electric Company"     , 150, 75));
        places.add(new Property( position++, "States Avenue"        , 140, new float[] {10, 50, 150, 450, 625, 750}, 70, 100, "colour2"));
        places.add(new Property( position++, "Virginia Avenue"      , 160, new float[] {12, 60, 180, 500, 700, 900}, 80, 100, "colour2"));
        places.add(new Railroad( position++,"Pennsylvania Railroad" , 200, 100));
        places.add(new Property( position++, "St. James Place"      , 180, new float[] {14, 70, 200, 550, 750, 950}, 90, 100, "Orange"));
        places.add(new FreeParking( position++, "Community Chest 2"));
        places.add(new Property( position++, "Tennessee Avenue"     , 180, new float[] {14, 70, 200, 550, 750, 950}, 90, 100, "Orange"));
        places.add(new Property( position++, "New York Avenue"      , 200, new float[] {16, 80, 220, 600, 800, 1000}, 100, 100, "Orange"));
        places.add(new FreeParking( position++, "Free Parking"));
        places.add(new Property( position++, "Kentucky Avenue"      , 220, new float[] {18, 90, 250, 700, 875, 1050}, 110, 150, "Red"));
        places.add(new FreeParking( position++, "Chance 2"));
        places.add(new Property( position++, "Indiana Avenue"       , 220, new float[] {18, 90, 250, 700, 875, 1050}, 110, 150, "Red"));
        places.add(new Property( position++, "Illinois Avenue"      , 240, new float[] {20, 100, 300, 750, 925, 1100}, 110, 150, "Red"));
        places.add(new Railroad( position++, "B & O Railroad"       , 200, 100));
        places.add(new Property( position++, "Atlantic Avenue"      , 260, new float[] {22, 110, 330, 800, 975, 1150}, 130, 150, "Yellow"));
        places.add(new Property( position++, "Ventnor Avenue"       , 260, new float[] {22, 110, 330, 800, 975, 1150}, 130, 150, "Yellow"));
        places.add(new Utility( position++, "Water Works"          , 150, 75));
        places.add(new Property( position++, "Marvin Gardens"       , 280, new float[] {24, 120, 360, 850, 1025, 1200}, 140, 150, "Yellow"));
        places.add(new FreeParking( position++, "Go to Jail"));
        places.add(new Property( position++, "Pacific Avenue"       , 300, new float[] {26, 130, 390, 900, 1100, 1275}, 150, 200, "Green"));
        places.add(new Property( position++, "North Carolina Avenue", 300, new float[] {26, 130, 390, 900, 1100, 1275}, 150, 200, "Green"));
        places.add(new FreeParking( position++, "Community Chest 3"));
        places.add(new Property( position++, "Pennsylvania Avenue"  , 320, new float[] {28, 150, 450, 1000, 1200, 1400}, 160, 200, "Green"));
        places.add(new Railroad( position++, "Short Line Railroad"  , 200, 100));
        places.add(new FreeParking( position++, "Chance 3"));
        places.add(new Property( position++, "Park Place"           , 350, new float[] {35, 175, 500, 1100, 1300, 1500}, 175, 200, "Blue"));
        places.add(new Tax( position++, "Luxury Tax", 75));
        places.add(new FreeParking( position++, "Luxury Tax"));
        places.add(new Property( position++, "Boardwalk"            , 400, new float[] {50, 200, 600, 1400, 1700, 2000}, 200, 200, "Blue"));
        places.add(new FreeParking( 0, "Go")); // o go é a posição zero
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
     * @return  a entidade Possession encontrada pela busca
     */
    public Place getPlaceByName(String name){
        for (Place place : places) {
            if(place.getName().equalsIgnoreCase(name)){
                return place;
            }
        }
        return null;
    }

    /**
     * @param position
     * @return
     */

    public Place getPlaceByPosition(int position){

        for (Place place : places) {
            if(place.getPosition() == position){
                return place;
            }
        }
        return null;
    }

}
