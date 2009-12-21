/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.test;

import game.model.GameModel;
import game.util.Commands;
import game.model.entity.board.PurchasablePlace;
import game.model.exceptions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Fachada para que os testes acessem os metodos do jogo
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
        return gameModel.getCurrentPlayerFacade().getName();
    }

    public void quitGame() throws InvalidCommandException {
        executeCommand("quit");
    }

    private void executeCommand(String command) throws InvalidCommandException {
        gameModel.executePlayerCommand(command);
    }

    public int getNumberOfPlayers() {
        return gameModel.getNumberOfRealPlayers();
    }

    public String getPlayerToken(String playerName) throws NonExistentPlayerException, GamePlayerException {
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
            if ((i + 1) != commands.size()) {
                strCommand.append(",");
            }
        }
        strCommand.append("}");
        return strCommand.toString();
    }

    public String getPlayerDeeds(String playerName) throws NonExistentPlayerException, GamePlayerException {
        StringBuilder str = new StringBuilder();
        str.append("{");
        ArrayList<PurchasablePlace> prPlace = gameModel.getPlayerByName(playerName).getItsPropertys();

        for (int i = 0; i < prPlace.size(); i++) {
            PurchasablePlace purchasablePlace = prPlace.get(i);
            str.append(purchasablePlace.getName());
            if ((i + 1) != prPlace.size()) {
                str.append(",");
            }

        }
        str.append("}");
        return str.toString();
    }

    public int getPlayerPosition(String playerName) throws NonExistentPlayerException, GamePlayerException {
        return gameModel.getPlayerByName(playerName).getAtualPosition();
        //getPlayerPosition(playerName);
    }

    public int getPlayerMoney(String playerName) throws NonExistentPlayerException, GamePlayerException {
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

    public void setAutomaticBuying(boolean auto) {
        gameModel.getConfiguration().setAutoBuy(auto);
    }

    public void rollDice(int firstDieResult, int secondDieResult) throws InvalidDiceResultException, NonExistentPlaceException, Exception {
        gameModel.rollDices(firstDieResult, secondDieResult);
    }

    public boolean gameIsOver() {
        return gameModel.isGameOver();
    }

    public void buy() throws NotEnoughMoneyException, NotInSaleException, GamePlaceException, Exception {
        gameModel.buy();
    }

/*********************************************
 user story 5
 *********************************************/
    public int getCurrentChanceCardNumber() throws NonExistentCardException {
        return gameModel.getCardStack().getCurrentChanceCard().getCardNumber() +1;
    }

    public int getCurrentChestCardNumber() throws NonExistentCardException {
        return gameModel.getCardStack().getCurrentChestCard().getCardNumber() +1;
    }

    public String getCurrentChanceCardDescription() throws NonExistentCardException {
        return gameModel.getCardStack().getCurrentChanceCard().getDescription();
    }

    public String getCurrentChestCardDescription() throws NonExistentCardException {
        return gameModel.getCardStack().getCurrentChestCard().getDescription();
    }

    public void activateChestPlaces(boolean cardShuffle) {
        gameModel.getConfiguration().setActivateChestPlaces(true);
        gameModel.getCardStack().loadChestCards();
    }

    public void activateChancePlaces(boolean cardShuffle) {
        gameModel.getConfiguration().setActivateChancePlaces(true);
        gameModel.getCardStack().loadChanceCards();
    }

    public void forceNextChanceCard(int cardId) throws NonExistentCardException {
        gameModel.getCardStack().forceNextChanceCard(cardId);
    }

    public void forceNextChestCard(int cardId) throws NonExistentCardException {
        gameModel.getCardStack().forceNextChestCard(cardId);
    }
}
