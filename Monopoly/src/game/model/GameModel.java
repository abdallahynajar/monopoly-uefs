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

    

    public GameModel(){
        configuration = new Configuration();
        initColors();
        board = new Board();
        bank = new Bank();
    }

    public void createGame(int numberOfPlayers, List<String> playerNames, List<String> playerColors) throws Exception{
        if ( numberOfPlayers < 2 || numberOfPlayers > 8 ) {
            throw new Exception("Invalid number of players");
        }else if( playerNames.size() > numberOfPlayers ){
            throw new Exception("Too many player names");
        }else if( playerNames.size() < numberOfPlayers ){
             throw new Exception("Too few player names");
        }else if( playerColors.size() > numberOfPlayers ){
            throw new Exception("Too many token colors");
        }else if( playerColors.size() < numberOfPlayers ){
            throw new Exception("Too few token colors");
        }else{
        //inicia o jogo
            players = new ArrayList<Player>(numberOfPlayers);
        }        

    }

    private void validatePlayerNames(List<String> playerNames) throws Exception{
        for (int i = 0; i < playerNames.size(); i++) {
            String pa = playerNames.get(i);
            if(pa.equals("bank")){
                throw new Exception("Invalid player name");
            }
            for (int j = 1; j < playerNames.size()-1; j++) {
                String pb = playerNames.get(j);
                if(pa.equals(pb)){
                    throw new Exception("There mustn't be repeated player names");
                }

             }

        }
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Player getPlayer(int index){
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
        p.setAmountOfMoney(5);
        p.setAtualPlace( board.getPlaceByName("go") );
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
    private void initColors(){
        availableColors = new ArrayList<Colors>();
            for (Colors c : Colors.values()) {
                availableColors.add(c);
            }
    }

}
