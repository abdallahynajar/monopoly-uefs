/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.controller;

import game.model.GameModel;
import game.model.comand.Exit;
import game.model.comand.GetStatus;
import game.model.comand.PlayerCommand;
import game.model.comand.RollDices;
import game.model.configuration.Configuration;
import game.model.entity.Board;
import game.model.entity.Colors;
import game.model.entity.Commands;
import game.model.entity.Player;
import game.model.entity.PurchasablePlace;
import game.view.GameView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Controla toda a execução de uma partida de monopólio, gerencia a GUI <b> GameView </b> e
 * sua interação com a camada de negócios, através do <b> GameModel </b>
 * @see GameModel
 * @see GameView
 * @author Lidiany 
 */
public class GameController {

    /**
     * Gerencia a camada de negócios do jogo
     */
    private GameModel gameModel;
    private GameView gameView;
    private HashMap<Commands, PlayerCommand> commands;
    private Player currentPlayer;
    private int currentPlayerIndex;
 

    /***
     * Inicializa as variáveis necessárias para começar uma partida de monopólio
     * @author Lidiany
     */
    public void initializeGame() {
        int numberOfPlayers = getNumberOfPlayers();
        
        gameModel = new GameModel();
        gameModel.setNumberOfPlayers(numberOfPlayers);       
        currentPlayerIndex = 1;
        //deve cadastrar os jogadores
        while (currentPlayerIndex <= numberOfPlayers) {
            String pn = getPlayerName(currentPlayerIndex);

            gameView.showMessage(" Informe a cor do peão do jogador " +
                    "nº " + currentPlayerIndex + " entre as seguintes opções: ");

            String pc = getPlayerColor();

            gameModel.addPlayer(currentPlayerIndex, pn, pc);

            gameView.showMessage(" Jogador " +
                    gameModel.getPlayer(currentPlayerIndex - 1).toString() +
                    " adicionado ");
            currentPlayerIndex++;
        }
        initCommands();
        gameView.showMessage(" Monopoly iniciado com sucesso ");
    }


    public Configuration getConfiguration() {
        return gameModel.getConfiguration();
    }

    public void setConfiguration(Configuration configuration) {
        gameModel.setConfiguration( configuration );
    }

    /***
     * Inicializa a lista de comandos disponíveis para os jogadores
     * @author Lidiany
     */
    private void initCommands() {
        commands = new HashMap<Commands, PlayerCommand>();
        commands.put(Commands.SAIR, new Exit(this));
        commands.put(Commands.JOGAR, new RollDices(this));
        commands.put(Commands.STATUS, new GetStatus(this));
    }

    public Board getGameBoard(){
        return gameModel.getBoard();
    }

     /***
     * Inicializa a uma partida de monopólio
     * @author Lidiany
     */
    public void startGame() {
        currentPlayerIndex = 0;       
        //permitir que comecem as jogadas'
        while (!isTheGameOver()) {        
            currentPlayer = gameModel.getPlayer( currentPlayerIndex );
            gameView.showMessage(" A jogada de " + currentPlayer.getName() + " começou.");
            this.executePlayerCommand();            
        }
    }

    /***
     *
     * @author Lidiany
     * @param gameView interface gráfica para o jogo
     */
    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    /***
     * Verifica se o jogo já terminou
     * @author Lidiany
     * @return <b>true</b> se o jogo acabou ou <b>false</b> caso ainda não tenha acabado
     */
    public boolean isTheGameOver() {       
        //quando que o jogo termina msm?
        if (gameModel.getNumberOfPlayers() == 0) {
            return true;
        }
        return false;
    }

    /***
     * Executa um comando escolhido pelo jogador da vez
     * @author Lidiany
     */
    private void executePlayerCommand() {
      //  boolean playerTurn = true;

        Commands c = getPlayerCommand();
        commands.get(c).execute(currentPlayer);

        if (c.equals(Commands.JOGAR) || currentPlayer == null) {           
            updatePlayersIndex();
        }else{
            executePlayerCommand();
        }
    }

    /***
     * Pega o comando enviado pelo jogador atual
     * @author Lidiany
     * @return  o comando escolhido pelo jogador atual
     */
    public Commands getPlayerCommand() {
        String strCommand = null;
        Commands command = null;
        while (strCommand == null) {

             gameView.showMessage(" Comandos disponíveis: ");
             gameView.showOptionalCommands();

            strCommand = gameView.getPlayerCommand();
            try {
                command = Commands.valueOf(strCommand.toUpperCase());
            } catch (IllegalArgumentException ex) {
                gameView.showMessage(" Comando inválido ");
                strCommand = null;
            }
        }
        return command;

    }

    /***
     * Remove um jogador da partida
     * @author Lidiany
     * @param player - o jogador a ser removido
     */
    public void removePlayerOfTheGame(Player player) {
        //Quando o penultimo jogador for removido, o jogo acaba, certo?
        // e o que restou ganha. Isso tá previsto?
        gameView.showMessage(" Tem certeza de que deseja sair? ");
        gameView.showMessage(" S/N ");
        String option = gameView.getYesOrNoOption();
        if (option.equalsIgnoreCase("S")) {
            gameModel.removePlayer( player.getId() );
            currentPlayer = null;
            gameModel.setNumberOfPlayers( currentPlayerIndex-- );
            gameView.showMessage(player.getName() + " saiu do jogo. ");
        }
    }

    /***
     * Exibe o status de um jogador
     * @author Lidiany
     * @param player - o jogador cujo status será mostrado
     */
    public void showPlayerStatus(Player player) {
        gameView.showMessage(player.getStatus());
    }

    /***
     * Obtém uma cor escolhida por um jogador
     * @author Lidiany
     * @return a cor escolhida pelo jogador
     */
    private String getPlayerColor() {
        String pc = null;
        while (pc == null) {
            gameView.showOptionalColors(gameModel.getAvailableColors());
            pc = gameView.getPlayerColor();

            try {
                Colors c  = Colors.valueOf(pc.toUpperCase());
                pc = c.toString();
               // availableColors.remove(c);
            } catch (IllegalArgumentException ex) {
                gameView.showMessage(" Cor inválida ");
                pc = null;
            }
        }

        return pc;
    }

     /***
     * Retorna a quantidade de jogadores
     * @author Lidiany
     * @return o número de jogadores
     */
    private int getNumberOfPlayers() {
        //início do jogo deve obter a quantidade de jogadores
        int numberOfPlayers = 0;
        while (numberOfPlayers == 0) {
            try {
                gameView.showMessage("Informe o número de jogadores [2 - 8]");
                numberOfPlayers = gameView.getNumberOfPlayers();
                if (numberOfPlayers < 2 || numberOfPlayers > 8) {
                    numberOfPlayers = 0;
                    gameView.showMessage("Número de jogadores inválido");
                }
            } catch (NumberFormatException ex) {
                numberOfPlayers = 0;
                gameView.showMessage("Número de jogadores inválido");
            }
        }
        return numberOfPlayers;
    }

     /***
     * Obtém o nome de um jogador
     * @author Lidiany
     * @param o número do jogador
     * @return o nome informado pelo jogador
     */
    private String getPlayerName(int currentPlayerIndex) {
        String pn = null;
        while (pn == null || pn.equals("")) {
            gameView.showMessage(" Informe o nome do jogador nº" + currentPlayerIndex);
            pn = gameView.getPlayerName(); 
        }

        return pn;
    }

     /***
     * Atualiza o índice que define o jogador atual
     * @author Lidiany
     * @param o número do jogador
     * @return o nome informado pelo jogador
     */
    private void updatePlayersIndex() {         
        int index = currentPlayerIndex;       
        if (index + 1 >= gameModel.getNumberOfPlayers()) {
            currentPlayerIndex = 0;

        } else {
            currentPlayerIndex++;
        }         
    }

     /**
     * Avisa que o jogo acabou
     * @author Lidiany     
     */
    public void finishGame() {
        gameView.showMessage("O jogo acabou. ");
    }
    /**
     * Interage com o usuário, oferecendo a possibilidade de compra de uma "propriedade comprável"
     * @author João
     * @param place
     * @param player
     */
    public void buyProperty(PurchasablePlace place, Player player){
        gameView.showMessage("A título da propriedade "+place.getName()+" está disponível por $"+place.getPrice()+".");
        gameView.showMessage(player.getName()+", você possui $"+player.getAmountOfMoney()+".");
        gameView.showMessage("Você deseja comprar "+place.getName()+" (Sim/Não)?");

        String option = "S";

        if(!gameModel.getConfiguration().isAutoBuy())
            option = gameView.getYesOrNoOption();

        if (option.equalsIgnoreCase("S")) {
            player.debit(place.getPrice());
            player.add(place);
            place.setOwner(player);
        }
    }

    public void showPlayerMove(int firstDice, int secondDice){
        gameView.showMessage("O jogador " + currentPlayer.getName()
                + " tirou " + firstDice + ", " + secondDice+ " e o peão avançou para " + currentPlayer.getAtualPlace());
    }

    public void removePlayer(){
        String msg = "player no longer in the game";
        currentPlayer = null;       
        gameModel.setNumberOfPlayers( currentPlayerIndex-- );
        gameView.showMessage(currentPlayer.getName() + " saiu do jogo. ");

    }
}
