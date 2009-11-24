/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.test;

import game.model.GameModel;

/**
 *
 * @author Lidiany
 */
public class MonopolyFacade {
    GameModel gameModel;

    public void createGame(int numPlayers, String playerNames, String tokenColors ){
            gameModel = new GameModel();
           // gameModel.createGame(numPlayers, null, null);
    }

    public void rollDices(int firstDice, int secondDice){

    }

    public int getNumberOfPlayers(){
        return 0;
    }

    public int getPlayerToken(){
        return 0;
    }

   public int getPlayerDeeds(){
        return 0;
    }

    public int getPlayerPosition(){
        return 0;
    }

    public int getPlayerMoney(){
        return 0;
    }

    public int getPlaceName(int placeId){
        return 0;
    }

    public int getPlaceGroup(int placeId){
        return 0;
    }

    public int getPlaceOwner(int placeId){
        return 0;
    }


    public int getPropertyRent (int placeId){
        return 0;
    }
     public int getPlacePrice (int placeId){
        return 0;
    }

}
