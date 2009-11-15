/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controller;

import game.model.GameModel;
import game.model.entity.Colors;
import game.view.GameView;
import game.view.LineComandView;

/**
 *
 * @author Lidiany
 * Controla a execução de uma partida de monopólio
 */
public class GameController {
    private GameModel gameModel;
    private GameView gameView;

    public void initializeGame(){
        
        setGameView( new LineComandView() );
        //início do jogo deve obter a quantidade de jogadores
        gameView.showMessage("Informe o número de jogadores [2 - 8]");
        int numberOfPlayers = gameView.getNumberOfPlayers();

        gameModel = new GameModel();
        gameModel.setNumberOfPlayers(numberOfPlayers);
        gameModel.init();

        int currentPlayer = 1;
         //deve cadastrar os jogadores
        while(currentPlayer <= numberOfPlayers){

            gameView.showMessage(" Informe o nome do jogador nº" + currentPlayer);
            String pn = gameView.getPlayerName();
            if(pn == null) {
                break;
            }

            gameView.showMessage(" Informe a cor do peão do jogador " +
                    "nº " + currentPlayer + "entre as seguintes opções: ");
            gameView.showOptionalColors();
           
            String pc = gameView.getPlayerColor();          

            if(pc == null) {
                break;
            }
            try{
             pc = Colors.valueOf( pc.toUpperCase() ).toString();
            }catch(IllegalArgumentException ex){
                gameView.showMessage(" Cor inválida ");                
                ex.printStackTrace();
                break;
            }

            gameModel.addPlayer( pn , pc);

            gameView.showMessage(" Jogador "+
                    gameModel.getPlayer(currentPlayer-1).toString()+
                    " adicionado "); 
            currentPlayer++;
            }       

        gameView.showMessage(" Monopoly iniciado com sucesso!");
    }

    public void startGame(){
        //permitir que comecem as jogadas
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }


}
