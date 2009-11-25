/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import game.model.configuration.Configuration;
import game.model.entity.Bank;
import game.model.entity.Board;
import game.model.entity.Colors;
import game.model.entity.Player;
import game.model.exceptions.InvalidGameParametersException;
import game.model.exceptions.InvalidPlayerNameException;
import game.model.exceptions.InvalidTokenColorException;
import game.model.exceptions.NonExistentPlayerException;
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
    /**
     * Banco
     */
    private Bank bank;
    private List<Colors> availableColors;
    private Configuration configuration;

    public List<Colors> getAvailableColors() {
        return availableColors;
    }

    public void setAvailableColors(List<Colors> availableColors) {
        this.availableColors = availableColors;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public GameModel() {
        configuration = new Configuration();
        initColors();
        board = new Board();
        bank = new Bank();
    }

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

//            if ( isAnyRepeatedValue(playerNames) ) {
//                throw new InvalidPlayerNameException("There mustn't be repeated player names");
//            }

//            if ( isAnyRepeatedValue( tokenColors ) ) {
//                throw new InvalidTokenColorException("There mustn't be repeated token colors");
//            }
            //inicia o jogo
            players = new ArrayList<Player>(numberOfPlayers);
            this.numberOfPlayers = numberOfPlayers;
            int currentPlayerIndex = 1;
            while (currentPlayerIndex <= numberOfPlayers) {
                addPlayer(currentPlayerIndex, playerNames.get(currentPlayerIndex - 1), tokenColors.get(currentPlayerIndex - 1));
                currentPlayerIndex++;
            }

        }
    }

    private void validatePlayerNames(List<String> playerNames) throws InvalidPlayerNameException {
        for (int i = 0; i < playerNames.size(); i++) {
            String pa = playerNames.get(i);
            if (pa.equals("bank")) {
                throw new InvalidPlayerNameException("Invalid player name");
            }
        }
    }

    private boolean isAnyRepeatedValue(List<String> names) {
//        ArrayList<String> lista = new ArrayList<String>(names);
//        for (int i = 0; i < lista.size(); i++)  {
//            System.out.println("names" + lista.get(i));
//            for (int j = 1; j < lista.size(); j++) {
//                if (lista.get(i).equals(lista.get(j))) {
//                    return true;
//                }
//            }
//        }
        return false;
    }

    private void validateTokenColors(List<String> tokenColors) throws InvalidTokenColorException {
        for (int i = 0; i < tokenColors.size(); i++) {
            try {
                Colors c = Colors.valueOf(tokenColors.get(i).toUpperCase());
                tokenColors.set(i, c.toString());
            } catch (IllegalArgumentException ex) {
                throw new InvalidTokenColorException("Invalid token color");
            }
        }
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

    /**
     * Inicializa o tabuleiro do monopólio
     * @author Lidiany
     */
    public void initializeBoardGame() {
    }

    public Board getBoard() {
        return board;
    }

    /**
     * Inicializa a lista de cores disponíveis para o usuário
     */
    private void initColors() {
        availableColors = new ArrayList<Colors>();
        for (Colors c : Colors.values()) {
            availableColors.add(c);
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public String getPlayerToken(String name) throws NonExistentPlayerException {
        Player p = getPlayerByName(name);
        if (p == null) {
            throw new NonExistentPlayerException("Player doesn't exist");
        }
        return p.getColor().toLowerCase();

    }

    public int getPlayerPosition(String name) throws NonExistentPlayerException {
        Player p = getPlayerByName(name);
        if (p == null) {
            throw new NonExistentPlayerException("Player doesn't exist");
        }
        return p.getAtualPosition();
    }

    public int getPlayerMoney(String name) throws NonExistentPlayerException {
        Player p = getPlayerByName(name);
        if (p == null) {
            throw new NonExistentPlayerException("Player doesn't exist");
        }
        return (int) p.getAmountOfMoney();

    }
}
