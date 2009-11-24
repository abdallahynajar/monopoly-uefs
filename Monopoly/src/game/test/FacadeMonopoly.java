/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.test;

import game.model.GameModel;
import game.model.exceptions.InvalidGameParametersException;
import game.model.exceptions.InvalidPlayerNameException;
import game.model.exceptions.InvalidTokenColorException;
import game.model.exceptions.NonExistentPlayerException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Lidiany
 */
public class FacadeMonopoly {
    GameModel gameModel;

    public void createGame(int numPlayers, String playerNames, String tokenColors ) throws InvalidGameParametersException, InvalidPlayerNameException, InvalidTokenColorException{
            gameModel = new GameModel();

            List<String> nPlayers = new ArrayList<String>();
            StringTokenizer st = new StringTokenizer(playerNames, ",}{");
            while(st.hasMoreTokens()){
                nPlayers.add( st.nextToken()  );

            }
            List<String> tColors = new ArrayList<String>();
             st = new StringTokenizer(tokenColors, ",}{");
            while(st.hasMoreTokens()){
                tColors.add( st.nextToken() );
            }
            gameModel.createGame(numPlayers, nPlayers, tColors);
    }

    public void rollDices(int firstDice, int secondDice){

    }

    public int getNumberOfPlayers(){
        return gameModel.getNumberOfPlayers();
    }

    public String getPlayerToken(String playerName) throws NonExistentPlayerException{
        return gameModel.getPlayerToken(playerName);
    }

//   public String getPlayerDeeds(){
//        return 0;
//    }

    public int getPlayerPosition(String playerName) throws NonExistentPlayerException{
        return gameModel.getPlayerPosition(playerName);
    }

    public int getPlayerMoney(String playerName) throws NonExistentPlayerException{
        return gameModel.getPlayerMoney(playerName);
    }

    public String getPlaceName(int placeId){
        return "";
    }

    public String getPlaceGroup(int placeId){
        return "";
    }

    public String getPlaceOwner(int placeId){
        return "";
    }


    public int getPropertyRent (int placeId){
        return 0;
    }
     public int getPlacePrice (int placeId){
        return 0;
    }

}
