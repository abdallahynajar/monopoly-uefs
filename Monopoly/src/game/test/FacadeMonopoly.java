/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.test;

import game.model.GameModel;
import game.model.exceptions.InvalidGameParametersException;
import game.model.exceptions.InvalidPlayerNameException;
import game.model.exceptions.InvalidTokenColorException;
import game.model.exceptions.NonExistentPlaceException;
import game.model.exceptions.NonExistentPlayerException;
import game.model.exceptions.NonPurchasablePlaceException;
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
             StringTokenizer bst = new StringTokenizer(tokenColors, ",}{");
            while(bst.hasMoreTokens()){
                tColors.add( bst.nextToken() );
            }
            gameModel.createGame(numPlayers, nPlayers, tColors);
    }

    public void getCurrentPlayer(){
        
    }


    public void rollDices(int firstDice, int secondDice){

    }

    public int getNumberOfPlayers(){
        return gameModel.getNumberOfPlayers();
    }

    public String getPlayerToken(String playerName) throws NonExistentPlayerException{
        return gameModel.getPlayerToken(playerName);
    }

   public String getPlayerDeeds(){
        return "";
    }

    public int getPlayerPosition(String playerName) throws NonExistentPlayerException{
        return gameModel.getPlayerPosition(playerName);
    }

    public int getPlayerMoney(String playerName) throws NonExistentPlayerException{
        return gameModel.getPlayerMoney(playerName);
    }

    public String getPlaceName(int placeId) throws NonExistentPlaceException{
        return gameModel.getBoard().getPlaceName(placeId);
    }

    public String getPlaceGroup(int placeId) throws NonExistentPlaceException{
        return gameModel.getBoard().getPlaceGroup(placeId);
    }

    public String getPlaceOwner(int placeId) throws NonExistentPlaceException, NonPurchasablePlaceException{
        return gameModel.getBoard().getPlaceOwner(placeId);
    }

    public int getPropertyRent (int placeId) throws NonExistentPlaceException, NonPurchasablePlaceException{
        return gameModel.getBoard().getPropertyRent(placeId);
    }
     public int getPlacePrice (int placeId) throws NonExistentPlaceException, NonPurchasablePlaceException{
        return gameModel.getBoard().getPlacePrice(placeId);
    }

}
