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
import game.model.entity.Colors;
import game.model.entity.Commands;
import game.model.entity.Player;
import game.view.GameView;
import java.util.HashMap;

/**
 *
 * @author Lidiany
 * Controla a execução de uma partida de monopólio
 */
public class GameController {

    private GameModel gameModel;
    private GameView gameView;
    private HashMap<Commands, PlayerCommand> commands;
    private Player currentPlayer;
    private int currentPlayerIndex;

    public void initializeGame() {
        int numberOfPlayers = getNumberOfPlayers();

        gameModel = new GameModel();
        gameModel.setNumberOfPlayers(numberOfPlayers);
        gameModel.init();

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

    private void initCommands() {
        commands = new HashMap<Commands, PlayerCommand>();
        commands.put(Commands.SAIR, new Exit(this));
        commands.put(Commands.JOGAR, new RollDices());
        commands.put(Commands.STATUS, new GetStatus(this));
    }

    public void startGame() {
        currentPlayerIndex = 0;

        //permitir que comecem as jogadas'
        while (!endGame()) {
            currentPlayer = gameModel.getPlayer(currentPlayerIndex);
            gameView.showMessage(" A jogada de " + currentPlayer.getName() + " começou.");
            this.executePlayerCommand();            
        }
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public boolean endGame() {
        //quando que o jogo termina msm?
        if (gameModel.getNumberOfPlayers() == 0) {
            return true;
        }
        return false;
    }

    private void executePlayerCommand() {
        boolean playerTurn = true;

        Commands c = getPlayerCommand();
        commands.get(c).execute(currentPlayer);

        if (c.equals(Commands.JOGAR) || currentPlayer == null) {
            playerTurn = false;
            updatePlayersIndex();
        }else{
            executePlayerCommand();
        }
    }

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

    public void removePlayerOfTheGame(Player player) {
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

    public void showPlayerStatus(Player player) {
        gameView.showMessage(player.getStatus());
    }

    private String getPlayerColor() {
        String pc = null;
        while (pc == null) {
            gameView.showOptionalColors();
            pc = gameView.getPlayerColor();

            try {
                pc = Colors.valueOf(pc.toUpperCase()).toString();
            } catch (IllegalArgumentException ex) {
                gameView.showMessage(" Cor inválida ");
                pc = null;
            }
        }

        return pc;
    }

    private int getNumberOfPlayers() {
        //início do jogo deve obter a quantidade de jogadores
        int numberOfPlayers = 0;
        while (numberOfPlayers == 0) {
            try {
                gameView.showMessage("Informe o número de jogadores [2 - 8]");
                numberOfPlayers = gameView.getNumberOfPlayers();
                if (numberOfPlayers < 1 || numberOfPlayers > 8) {
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

    private String getPlayerName(int currentPlayerIndex) {
        String pn = null;
        while (pn == null || pn.equals("")) {
            gameView.showMessage(" Informe o nome do jogador nº" + currentPlayerIndex);
            pn = gameView.getPlayerName();
        }

        return pn;
    }

    private void updatePlayersIndex() {
        if (currentPlayerIndex + 1 > gameModel.getNumberOfPlayers()) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex++;
        }
    }

    public void finishGame() {
        gameView.showMessage("O jogo acabou. ");
    }
}
