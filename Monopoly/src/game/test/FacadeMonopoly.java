/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.test;

import game.model.GameModel;
import game.model.entity.Commands;
import game.model.entity.PurchasablePlace;
import game.model.exceptions.InvalidCommandException;
import game.model.exceptions.InvalidDiceResultException;
import game.model.exceptions.InvalidGameParametersException;
import game.model.exceptions.InvalidPlayerNameException;
import game.model.exceptions.InvalidTokenColorException;
import game.model.exceptions.NonExistentPlaceException;
import game.model.exceptions.NonExistentPlayerException;
import game.model.exceptions.NonPurchasablePlaceException;
import game.model.exceptions.PlayerNoLongerInTheGameException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Lidiany
 */
public class FacadeMonopoly {

    GameModel gameModel;

    public void createGame(int numPlayers, String playerNames, String tokenColors) throws InvalidGameParametersException, InvalidPlayerNameException, InvalidTokenColorException {
        gameModel = new GameModel();

        List<String> nPlayers = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(playerNames, ",}{");
        while (st.hasMoreTokens()) {
            nPlayers.add(st.nextToken());
        }
        List<String> tColors = new ArrayList<String>();
        StringTokenizer bst = new StringTokenizer(tokenColors, ",}{");
        while (bst.hasMoreTokens()) {
            tColors.add(bst.nextToken());
        }
        gameModel.createGame(numPlayers, nPlayers, tColors);
    }

    public String getCurrentPlayer() {
        return gameModel.getCurrentPlayer().getName();
    }

    public void quitGame() throws InvalidCommandException {
        executeCommand("quit");
    }

    private void executeCommand(String command) throws InvalidCommandException {
        gameModel.executePlayerCommand(command);
    }

    public int getNumberOfPlayers() {
        return gameModel.getNumberOfPlayers();
    }

    public String getPlayerToken(String playerName) throws NonExistentPlayerException, PlayerNoLongerInTheGameException {
        return gameModel.getPlayerByName(playerName).getColor().toLowerCase();
        //getPlayerToken(playerName);
    }

    public String getCommands() {
        StringBuilder strCommand = new StringBuilder();
        strCommand.append("{");
        List<Commands> commands = gameModel.getCurrentPlayer().getPlayerCommands();
        
        for (int i = 0; i < commands.size(); i++) {
            Commands c = commands.get(i);
            strCommand.append(c.toString().toLowerCase());
            if( (i+ 1) != commands.size() ){
                strCommand.append(",");
            }            
        }
        strCommand.append("}");
        return strCommand.toString();
    }

    public String getPlayerDeeds(String playerName) throws NonExistentPlayerException, PlayerNoLongerInTheGameException {
        StringBuilder str = new StringBuilder();
        str.append("{");
        ArrayList<PurchasablePlace> prPlace = gameModel.getPlayerByName(playerName).getItsPropertys();

          for (int i = 0; i < prPlace.size(); i++) {
            PurchasablePlace purchasablePlace = prPlace.get(i);
            str.append(purchasablePlace.getName());
            if( (i+ 1) != prPlace.size() ){
                str.append(",");
            } 
            
        }
        str.append("}");
        return str.toString();
    }

    public int getPlayerPosition(String playerName) throws NonExistentPlayerException, PlayerNoLongerInTheGameException {
        return gameModel.getPlayerByName(playerName).getAtualPosition();
        //getPlayerPosition(playerName);
    }

    public int getPlayerMoney(String playerName) throws NonExistentPlayerException, PlayerNoLongerInTheGameException {
        return (int) gameModel.getPlayerByName(playerName).getAmountOfMoney();
        //getPlayerMoney(playerName);
    }

    public String getPlaceName(int placeId) throws NonExistentPlaceException {
        return gameModel.getBoard().getPlaceName(placeId);
    }

    public String getPlaceGroup(int placeId) throws NonExistentPlaceException {
        return gameModel.getBoard().getPlaceGroup(placeId);
    }

    public String getPlaceOwner(int placeId) throws NonExistentPlaceException, NonPurchasablePlaceException {
        return gameModel.getBoard().getPlaceOwner(placeId);
    }

    public int getPropertyRent(int placeId) throws NonExistentPlaceException, NonPurchasablePlaceException {
        return gameModel.getBoard().getPropertyRent(placeId);
    }

    public int getPlacePrice(int placeId) throws NonExistentPlaceException, NonPurchasablePlaceException {
        return gameModel.getBoard().getPlacePrice(placeId);
    }

    public void setAutomaticBuying(boolean auto){
        gameModel.getConfiguration().setAutoBuy(auto);
    }

    public void rollDice(int firstDieResult, int secondDieResult) throws InvalidDiceResultException, NonExistentPlaceException, Exception {
        gameModel.rollDices(firstDieResult, secondDieResult);
    }
}
