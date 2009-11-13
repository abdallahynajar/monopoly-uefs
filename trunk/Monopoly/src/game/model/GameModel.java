/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

import game.model.entity.Bank;
import game.model.entity.Board;
import game.model.entity.Player;
import java.util.ArrayList;

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
     * Tabuleiro do jogo
     */
    private Board board;
    /**
     * Banco
     */
    private Bank bank;

    public GameModel(){

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
     * @param name o nome do jogador
     * @param color a cor do peão do jogador
     */
    public void addPlayer(String name, String color) {
        Player p = new Player(name, color);
        p.setAmountOfMoney(1500);
        players.add(p);
    }

    /**
     * Inicializa o tabuleiro do monopólio
     */
    public void initializeBoardGame() {
    }

    public void init() {
        players = new ArrayList<Player>(numberOfPlayers);
        board = new Board();
        bank = new Bank();

        initializeBoardGame();
    }
}
