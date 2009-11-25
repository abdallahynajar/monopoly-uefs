/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import game.model.configuration.GameConfiguration;
import game.model.entity.Bank;
import game.model.entity.Board;
import game.model.entity.Colors;
import game.model.entity.Commands;
import game.model.entity.Player;
import game.model.exceptions.InvalidCommandException;
import game.model.exceptions.InvalidDiceResultException;
import game.model.exceptions.InvalidGameParametersException;
import game.model.exceptions.InvalidPlayerNameException;
import game.model.exceptions.InvalidTokenColorException;
import game.model.exceptions.NonExistentPlaceException;
import game.model.exceptions.NonExistentPlayerException;
import game.model.exceptions.NotEnoughMoneyException;
import game.model.exceptions.PlayerNoLongerInTheGameException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lidiany
 * Cria e gerencia as entidades relacionadas ao jogo
 */
public class GameModel {

    /**
     * Quantidade de jogadores
     */
    private int numberOfPlayers;
    /**
     * Pariticipantes do jogo
     */
    private ArrayList<Player> players;
    /**
     * Jogador atual
     */
    private Player currentPlayer;
    /**
     * Tabuleiro do jogo
     */
    private Board board;
    private boolean gameStarted = false;
    /**
     * Banco
     */
    private Bank bank;
    /**
     * Para configurar os parâmetros de inicialização do jogo
     */
    private GameConfiguration configuration;
    private int currentPlayerIndex = 0;

    public GameConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(GameConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * Cria uma nova instância de GameModel
     * @author Lidiany
     */
    public GameModel() {
        configuration = GameConfiguration.getConfiguration();
        board = new Board();
        bank = new Bank();
    }

    /**
     * Cria uma nova partida de Monopoly
     *@see Colors
     * @author Lidiany
     * @param numberOfPlayers o número de participantes do jogo
     * deve ser maior que <b>2</b> e menor que <b>8</b>
     * @param playerNames a lista de nomes dos jogadores
     * @param tokenColors as cores do peeões dos jogadores
     * @throws InvalidGameParametersException - se o número de jogadores, ou cores e nomes estiver errado
     * @throws InvalidPlayerNameException - se for passado um nome inválido como banco ou nomes repetidos
     * @throws InvalidTokenColorException - se for passada uma cor inválida ou cores repetidas
     */
    public void createGame(int numberOfPlayers, List<String> playerNames, List<String> tokenColors) throws InvalidGameParametersException, InvalidPlayerNameException, InvalidTokenColorException {

        if (numberOfPlayers < 2 || numberOfPlayers > 8) {
            throw new InvalidGameParametersException("Invalid number of players");
        } else if (playerNames.size() > numberOfPlayers) {
            throw new InvalidGameParametersException("Too many player names");
        } else if (playerNames.size() < numberOfPlayers) {
            throw new InvalidGameParametersException("Too few player names");
        } else if (tokenColors.size() > numberOfPlayers) {
            throw new InvalidGameParametersException("Too many token colors");
        } else if (tokenColors.size() < numberOfPlayers) {
            throw new InvalidGameParametersException("Too few token colors");
        } else {

            validatePlayerNames(playerNames);
            validateTokenColors(tokenColors);

            if ( isAnyRepeatedValue(playerNames) ) {
               throw new InvalidPlayerNameException("There mustn't be repeated player names");
            }

            if ( isAnyRepeatedValue( tokenColors ) ) {
                throw new InvalidTokenColorException("There mustn't be repeated token colors");
            }
            //inicia o jogo
            players = new ArrayList<Player>(numberOfPlayers);
            this.numberOfPlayers = numberOfPlayers;
            currentPlayerIndex = 1;
            while (currentPlayerIndex <= numberOfPlayers) {
                addPlayer(currentPlayerIndex, playerNames.get(currentPlayerIndex - 1), tokenColors.get(currentPlayerIndex - 1));
                currentPlayerIndex++;
            }
            gameStarted = true;
            currentPlayerIndex = 0;
            currentPlayer = players.get(currentPlayerIndex);
        }
    }

    /**
     * Valida os nomes de jogadores
     * @author Lidiany
     * @param playerNames a lista de nomes dos jogadores
     * @throws InvalidPlayerNameException - se for passado um nome inválido como banco ou nomes repetidos
     */
    private void validatePlayerNames(List<String> playerNames) throws InvalidPlayerNameException {
        for (int i = 0; i < playerNames.size(); i++) {
            String pa = playerNames.get(i);
            if (pa.equals("bank")) {
                throw new InvalidPlayerNameException("Invalid player name");
            }
            //era p verificar os repetidos aki, mas não funciona!
        }
    }

    private boolean isAnyRepeatedValue(List<String> names) {
        ArrayList<String> lista = new ArrayList<String>(names);
        for (int i = 0; i < lista.size(); i++)  {
            //System.out.println("names" + lista.get(i));
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).equals(lista.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Valida as cores dos jogadores
     *@see Colors
     * @author Lidiany
     * @param tokenColors as cores do peeões dos jogadores
     * @throws InvalidTokenColorException - se for passada uma cor inválida ou cores repetidas
     */
    private void validateTokenColors(List<String> tokenColors) throws InvalidTokenColorException {
        for (int i = 0; i < tokenColors.size(); i++) {
            try {
                Colors c = Colors.valueOf(tokenColors.get(i).toUpperCase());
                tokenColors.set(i, c.toString());
            } catch (IllegalArgumentException ex) {
                throw new InvalidTokenColorException("Invalid token color");
            }
        }
        //era p verificar os repetidos aki, mas não funciona!
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    /**
     * Adiciona um jogador à lista de participantes do jogo
     *
     * @author Lidiany
     * @param id o identificador do jogador
     * @param name o nome do jogador
     * @param color a cor do peão do jogador
     */
    public void addPlayer(int id, String name, String color) {
        Player p = new Player(name, color);
        p.setAmountOfMoney(1500);
        p.setId(id);
        p.setAtualPlace(board.getPlaceByName("go"));
        players.add(p);
    }

    /**
     * Remove um jogador da lista de participantes do jogo
     *
     * @author Lidiany
     * @param id o indice do jogador na lista
     */
    public void removePlayer(int id) {
        players.remove(id);
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Busca um jogador pelo nome
     * @author Lidiany
     * @param name o nome do jogador a ser pesquisado
     * @throws NonExistentPlayerException - se o jogadr não for encontrado
     */
    public Player getPlayerByName(String name) throws NonExistentPlayerException, PlayerNoLongerInTheGameException {
        Player p = null;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                p = player;
            }
        }
        if (p == null) {
            throw new NonExistentPlayerException("Player doesn't exist");
        }else if(!p.isPlaying()){
            throw new PlayerNoLongerInTheGameException("Player no longer in the game");
        }
        return p;
    }

    /**
     * Executa um comando de um jogador
     * @author Lidiany
     * @param command o comando a ser executado
     * @throws InvalidCommandException - se não for possível executar o comando
     */
    public void executePlayerCommand(String command) throws InvalidCommandException {
        Commands c = Commands.valueOf(command.toUpperCase());
        if (c.equals(Commands.QUIT)) {
            if (gameStarted) {
                exitGame();
            } else {
                throw new InvalidCommandException("There's no game to quit");
            }
        }
    }

    /**
     * Executa um comando de um jogador
     * @author Lidiany
     * @param firstDieResult -  valor do primeiro dado
     * @param secondDieResult -  valor do segundo dado
     * @throws InvalidDiceResultException - se não os valores dos dados estiverem incorretos
     *  @throws NonExistentPlaceException - se o Place não for encontrado
     */
    public void rollDices(int firstDieResult, int secondDieResult) throws InvalidDiceResultException, NonExistentPlaceException, Exception {
        if (!validateRollDices(firstDieResult, secondDieResult)) {
            throw new InvalidDiceResultException("Invalid die result");
        } else {
            try {
                currentPlayer.walk(firstDieResult + secondDieResult, board);
                if (!isGameOver()) {
                    updateCurrentPlayer();
                }
            } catch (NotEnoughMoneyException ex) {
               this.currentPlayer.setPlaying(false);
            }
        }
    }

    /**
     * Valida os valores dos Dados
     * @author Lidiany
     * @param firstDieResult -  valor do primeiro dado
     * @param secondDieResult -  valor do segundo dado
     * @return <b>true </b> se os valores forem corretos, senão <b>false </b>
     */
    private boolean validateRollDices(int firstDieResult, int secondDieResult) {
        if (firstDieResult <= 0 || secondDieResult <= 0) {
            return false;
        } else if (firstDieResult > 6 || secondDieResult > 6) {
            return false;
        }
        return true;
    }

    private boolean isGameOver() {
        return gameStarted ? false : true;
    }

    private void exitGame() {
        gameStarted = false;
    }

    private void updateCurrentPlayer() {
        int index = currentPlayerIndex;
        if (index + 1 >= numberOfPlayers) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex++;
        }
        currentPlayer = players.get(currentPlayerIndex);
    }
}
