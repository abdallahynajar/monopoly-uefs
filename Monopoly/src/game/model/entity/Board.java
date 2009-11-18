/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import game.model.state.OwnedState;
import game.model.state.PlaceState;
import game.model.state.UnownedState;
import java.util.ArrayList;

/**
 *
 * @author UEFS\jmatos
 * Representa o tabuleiro
 */
public class Board {

    private ArrayList<Place> places;
    private PlaceState placeState;
    
    public Board() {
        places = new ArrayList<Place>();
        int position = places.size();
        places.add(new Property( position++, "Mediterranean Avenue" , 60, 2, 10, 30, 90, 160, 250, 30, 50, "colour"));
        places.add(new Property( position++, "Community Chest 1"    , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "Baltic Avenue"        , 60, 4, 20, 60, 180, 320, 450, 30, 50, "colour"));
        places.add(new Tax("Income Tax", 200));
        places.add(new Property( position++, "Income Tax"           , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));

        places.add(new Railroad("Reading Railroad", 200, 100));
        places.add(new Property( position++, "Oriental Avenue"      , 100, 6, 30, 90, 270, 400, 550, 50, 50, "Light Blue"));
        places.add(new Property( position++, "Chance 1"             , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "Vermont Avenue"       , 100, 6, 30, 90, 270, 400, 550, 50, 50, "Light Blue"));
        places.add(new Property( position++, "Connecticut Avenue"   , 120, 8, 40, 100, 300, 450, 600, 60, 50, "Light Blue"));
        places.add(new Property( position++, "Jail – Just Visiting" , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "St. Charles Place"    , 140, 10, 50, 150, 450, 625, 750, 70, 100, "colour2"));
        places.add(new Property( position++, "Electric Company"     , 150, 0, 0, 0, 0, 0, 0, 150, 0, ""));
        places.add(new Property( position++, "States Avenue"        , 140, 10, 50, 150, 450, 625, 750, 70, 100, "colour2"));
        places.add(new Property( position++, "Virginia Avenue"      , 160, 12, 60, 180, 500, 700, 900, 80, 100, "colour2"));

        places.add(new Railroad("Pennsylvania Railroad", 200, 100));
        places.add(new Property( position++, "St. James Place"      , 180, 14, 70, 200, 550, 750, 950, 90, 100, "Orange"));
        places.add(new Property( position++, "Community Chest 2"    , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "Tennessee Avenue"     , 180, 14, 70, 200, 550, 750, 950, 90, 100, "Orange"));
        places.add(new Property( position++, "New York Avenue"      , 200, 16, 80, 220, 600, 800, 1000, 100, 100, "Orange"));
        places.add(new Property( position++, "Free Parking"         , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "Kentucky Avenue"      , 220, 18, 90, 250, 700, 875, 1050, 110, 150, "Red"));
        places.add(new Property( position++, "Chance 2"             , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "Indiana Avenue"       , 220, 18, 90, 250, 700, 875, 1050, 110, 150, "Red"));
        places.add(new Property( position++, "Illinois Avenue"      , 240, 20, 100, 300, 750, 925, 1100, 110, 150, "Red"));
        places.add(new Property( position++, "B & O Railroad"       , 200, 0, 0, 0, 0, 0, 0, 100, 0, ""));
        places.add(new Property( position++, "Atlantic Avenue"      , 260, 22, 110, 330, 800, 975, 1150, 130, 150, "Yellow"));
        places.add(new Property( position++, "Ventnor Avenue"       , 260, 22, 110, 330, 800, 975, 1150, 130, 150, "Yellow"));
        places.add(new Property( position++, "Water Works"          , 150, 0, 0, 0, 0, 0, 0, 150, 0, ""));
        places.add(new Property( position++, "Marvin Gardens"       , 280, 24, 120, 360, 850, 1025, 1200, 140, 150, "Yellow"));
        places.add(new Property( position++, "Go to Jail"           , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "Pacific Avenue"       , 300, 26, 130, 390, 900, 1100, 1275, 150, 200, "Green"));
        places.add(new Property( position++, "North Carolina Avenue", 260, 22, 110, 330, 800, 975, 1150, 130, 150, "Green"));
        places.add(new Property( position++, "Community Chest 3"    , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "Pennsylvania Avenue"  , 320, 28, 150, 450, 1000, 1200, 1400, 160, 200, "Green"));
        places.add(new Property( position++, "Short Line Railroad"  , 200, 0, 0, 0, 0, 0, 0, 100, 0, ""));
        places.add(new Property( position++, "Chance 3"             , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "Park Place"           , 350, 35, 175, 500, 500, 1100, 1300, 1500, 175, "Blue"));
        places.add(new Tax("Luxury Tax", 75));
        places.add(new Property( position++, "Luxury Tax"           , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
        places.add(new Property( position++, "Boardwalk"            , 400, 50, 200, 600, 1400, 1700, 2000, 200, 200, "Blue"));
        places.add(new Property( position++, "Go"                   , 0, 0, 0, 0, 0, 0, 0, 0, 0, ""));
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

    public void landsPlayer(int newPosition, Player player){
            //define o lugar onde o jogador vai parar
        int playerCurrentPosition = ((Property)player.getAtualPlace()).getPosition();

        Property p = getNewPlayerPlace(newPosition, playerCurrentPosition);
        if(p.getOwner() != null){
            placeState = new OwnedState();
        }else{
            placeState = new UnownedState();
        }
        placeState.landOnBy(p, player);

    }

    //TODO
    private Property getNewPlayerPlace(int newPosition, int playerCurrentPosition ){
        return null;
    }

}
