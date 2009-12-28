/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model;

import game.model.configuration.GameConfiguration;
import game.model.entity.board.Board;
import game.model.entity.board.Jail;
import game.util.Colors;
import game.util.CommandType;
import game.model.entity.player.Player;
import game.model.entity.card.CardStack;
import game.model.entity.player.Bank;
import game.model.exceptions.*;
import game.util.Command;
import game.util.Dice;
import java.util.ArrayList;
import java.util.List;

/**
 * Cria e gerencia as entidades relacionadas ao jogo
 * @author Lidiany
 */
public class GameModel {

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
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
     * <b> true </b> se o jogo começou ou <b> false </b> se não começou ainda
     */
    private boolean gameStarted = false;
    /**
     * Para configurar os parâmetros de inicialização do jogo
     */
    private GameConfiguration configuration;
    /** 
     * Índice do jogador atual
     */
    private int currentPlayerIndex = 0;
    /**
     * Player anteror ao atual
     */
    private Player previous = null;
    /**
     * Pilha de cartas
     */
    private CardStack cardStack;
    private Dice dice;
    private static GameModel gameModel;

    public static GameModel getGameModel() {

        if (gameModel == null) {
            gameModel = new GameModel();
        }

        return gameModel;
    }

    public GameConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(GameConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * Cria uma nova instância de GameModel
     */
    public GameModel() {
        configuration = GameConfiguration.getConfiguration();
        configuration.setAutoBuy(false);
        board = Board.getBoard();
        this.cardStack = CardStack.getCardStack();
        this.dice = Dice.getDice();
        gameModel = this;
    }

    /**
     * limpar todos os singletons
     */
    private static void clean() {
        Board.cleanUpBoard();
        Bank.cleanUp();
        GameConfiguration.cleanUp();
    }

    public static void cleanUp() {
        clean();
        GameModel.gameModel = null;
    }

    /**
     * Cria uma nova partida de Monopoly
     *@see Colors
     * @param numberOfPlayers o número de participantes do jogo
     * deve ser maior que <b>2</b> e menor que <b>8</b>
     * @param playerNames a lista de nomes dos jogadores
     * @param tokenColors as cores do peões dos jogadores
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

            if (isAnyRepeatedValue(playerNames)) {
                throw new InvalidPlayerNameException("There mustn't be repeated player names");
            }

            if (isAnyRepeatedValue(tokenColors)) {
                throw new InvalidTokenColorException("There mustn't be repeated token colors");
            }
            //inicia o jogo
            //clean();
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
            previous = currentPlayer;
            //currentPlayerIndex = -1;
            // loadCardBoard();
        }
    }

    /**
     * Valida os nomes de jogadores
     * @param playerNames a lista de nomes dos jogadores
     * @throws InvalidPlayerNameException - se for passado um nome inválido como banco ou nomes repetidos
     */
    private void validatePlayerNames(List<String> playerNames) throws InvalidPlayerNameException {
        for (int i = 0; i < playerNames.size(); i++) {
            String pa = playerNames.get(i);
            if (pa.equals("bank")) {
                throw new InvalidPlayerNameException("Invalid player name");
            }
        }
    }

    private boolean isAnyRepeatedValue(List<String> names) {
        ArrayList<String> lista = new ArrayList<String>(names);
        for (int i = 0; i < lista.size(); i++) {
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
     * @param id o identificador do jogador
     * @param name o nome do jogador
     * @param color a cor do peão do jogador
     */
    public void addPlayer(int id, String name, String color) {
        Player p = new Player(name, color);
        p.setAmountOfMoney(configuration.getInitialMoney());
        p.setId(id);
        p.setAtualPlace(board.getPlaceByName("go"));
        p.setAtualPosition(0); //o player começa em go, mas a posiçao é 0, para
        //evitar o credito dos 200 no início
        //p.setBoard(board);
        players.add(p);
    }

    /**
     * Remove um jogador da lista de participantes do jogo
     *
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
    /* //gancho
    public Player getCurrentPlayerFacade(){
    if(!this.configuration.isAutoBuy())
    return previous;
    else{
    return currentPlayer;
    }
    }*/

    public List<Command> getPlayerCommands() {
        return currentPlayer.getPlayerCommands();
    }

    /**
     * Busca um jogador pelo nome
     * @param name o nome do jogador a ser pesquisado
     * @throws NonExistentPlayerException - se o jogadr não for encontrado
     */
    public Player getPlayerByName(String name) throws NonExistentPlayerException, GamePlayerException {
        Player p = null;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                p = player;
            }
        }
        if (p == null) {
            throw new NonExistentPlayerException("Player doesn't exist");
        } else if (!p.isPlaying()) {
            throw new GamePlayerException("Player no longer in the game");
        }
        return p;
    }

    /**
     * Executa um comando de um jogador
     * @param command o comando a ser executado
     * @throws InvalidCommandException - se não for possível executar o comando
     */
    public void executePlayerCommand(String command) throws InvalidCommandException {
        CommandType c = CommandType.valueOf(command.toUpperCase());
        if (c.equals(CommandType.QUIT)) {
            if (gameStarted) {
                exitGame();
            } else {
                throw new InvalidCommandException("There's no game to quit");
            }
        }

    }

    /**
     * Executa um comando de um jogador
     * @param firstDieResult -  valor do primeiro dado
     * @param secondDieResult -  valor do segundo dado
     * @throws InvalidDiceResultException - se não os valores dos dados estiverem incorretos
     *  @throws NonExistentPlaceException - se o lugar não for encontrado
     */
    public void rollDices(int firstDieResult, int secondDieResult) throws InvalidDiceResultException, NonExistentPlaceException, Exception {
        dice.setRolledDices(firstDieResult, secondDieResult);
        dice.validateDicesResult();
        boolean playerHasAnotherTurn = false;
        boolean doubleTurnActive = getConfiguration().isActivateDoublesRule();

        try {
            if (dice.isDoubleResult()) {
                if (currentPlayer.isInJail()) {
                    currentPlayer.leavesJail();
                }
                if (doubleTurnActive) {
                    if (dice.getnDoublesDices() == 3) {
                        arrestsPlayer();
                    } else {
                        playerHasAnotherTurn = true;
                    }
                }
            }
            currentPlayer.walk(firstDieResult + secondDieResult);
        } catch (NotEnoughMoneyException ex) {
            currentPlayer.leavesGame();
        } finally {
            if (!playerHasAnotherTurn) {
                 dice.setnDoublesDices(0);
                updateCurrentPlayer();
            }
        }

    }

    public boolean isGameOver() {
        if (!gameStarted) {
            return true;
        } else {
            int nPlaying = getNumberOfRealPlayers();
            return (nPlaying > 1) ? false : true;
        }
    }

    private void exitGame() {
        currentPlayer.setPlaying(false);
    }

    /**
     * Passa a jogada para o proximo jogador. Deve ser usado imediatamente antes
     * de "rolarem os dados"
     */
    private void updateCurrentPlayer() {
        previous = currentPlayer;
        updateCurrentPlayerIndex();
        while (!players.get(currentPlayerIndex).isPlaying()) {
            updateCurrentPlayerIndex();
        }
        currentPlayer = players.get(currentPlayerIndex);
        //System.out.println("Agora é a vez de " + currentPlayer.getName());
    }

    private void updateCurrentPlayerIndex() {
        int index = currentPlayerIndex;
        if (index + 1 >= numberOfPlayers) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex++;
        }
    }

    /**
     * @return Retorna o número de jogadores que ainda estão jogando
     */
    public int getNumberOfRealPlayers() {
        int n = 0;
        for (Player p : players) {
            if (p.isPlaying()) {
                n++;
            }
        }
        return n;
    }

    /**
     * Faz o atual jogador tentar comprar a propriedade em que se encontra.
     * @throws game.model.exceptions.NotEnoughMoneyException
     * @throws game.model.exceptions.NotInSaleException
     * @throws game.model.exceptions.ItAlreadyHasAnOnwerException
     * @throws java.lang.Exception
     */
    public void buy() throws NotEnoughMoneyException, NotInSaleException, GamePlaceException, Exception {
        previous.buyProperty();
    }

    public CardStack getCardStack() {
        return cardStack;
    }

    public void setCardStack(CardStack cardStack) {
        this.cardStack = cardStack;
    }

    public void build(int propertyID) throws NonExistentPlaceException, NotEnoughMoneyException, BuildException {
        currentPlayer.build(propertyID);

    }

    public void sell(int propertyID) throws NonExistentPlaceException, NotEnoughMoneyException, SellException {

        currentPlayer.sell(propertyID);
    }

    private void arrestsPlayer() throws NonExistentPlaceException, Exception {
         boolean isJailActive =
                GameConfiguration.getConfiguration().isActivateJail();
        if (isJailActive) {
            Jail jail = Board.getBoard().findJail();
            jail.setJustVisiting(false);
            currentPlayer.goTo(jail.getPosition(), false);
        }
    }
}
