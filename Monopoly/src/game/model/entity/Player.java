/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity;

import game.util.Commands;
import game.model.entity.board.Place;
import game.model.entity.board.Board;
import game.model.entity.board.Railroad;
import game.model.entity.board.PurchasablePlace;
import game.model.entity.board.Utility;
import game.model.configuration.GameConfiguration;
import game.model.entity.card.Card;
import game.model.exceptions.GamePlaceException;
import game.model.exceptions.GamePlayerException;
import game.model.exceptions.InvalidPlayerPositionException;
import game.model.exceptions.NonExistentPlaceException;
import game.model.exceptions.NotEnoughMoneyException;
import game.model.exceptions.NotInSaleException;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a entidade jogador
 * @author UEFS\jmatos
 */
public class Player {

    /** 
     * Id do jogador no jogo
     */
    private int id;
    /**
     * Nome do jogador
     */
    private String name;
    /** 
     * Cor do peão do jogador
     */
    private String color;
    /** 
     * Quantia em dinheiro que o jogador recebe
     */
    private float amountOfMoney;
    
    /**
     * Lugar onde o jogador se encontra
     */
    private Place atualPlace;

    /** Cartas do jogador */
    private ArrayList<Card> playerCards;

    /**
     * Posição do jogador no tabuleiro
     */
    private int atualPosition;
    /**
     * Lista de proprieades que o jodador possui.
     */
    private ArrayList<PurchasablePlace> itsPropertys;

    /**
     * Comandos que o jogador pode executar
     */
    private List<Commands> playerCommands;

    /**
     * <b>true</b> se o jogador está no jogo ou <b>false</b> se já perdeu
     */
    private boolean playing;

    private ArrayList<String> monopoly;



    /** Cria uma nova instância de um jogador
     * @param color cor do peão
     * @param name nome do jogador
     */
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.itsPropertys = new ArrayList<PurchasablePlace>();
        playing = true;
        playerCommands = new ArrayList<Commands>();
        playerCommands.add(Commands.ROLL);
        playerCommands.add(Commands.STATUS);
        playerCommands.add(Commands.QUIT);
        playerCards = new ArrayList<Card>();
    }

    public boolean isPlaying() {
        return playing;
    }
    /**
     * Tira o jogador do jogo e devolve todas as suas propriedades ao banco.
     */
    public void fail() {
        playing = false;
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            purchasablePlace.returnToBank();
        }
    }

    public void updateMonopoly(){
        
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void add(PurchasablePlace place) {
        itsPropertys.add(place);
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Place getAtualPlace() {
        return atualPlace;
    }

    public void setAtualPosition(int atualPosition) {
        this.atualPosition = atualPosition;
    }

    public int getAtualPosition() {
        return atualPlace.getPosition();
    }

    public void setAtualPlace(Place atualPlace) {
        this.atualPlace = atualPlace;
        this.atualPosition = atualPlace.getPosition();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void credit(float money) {
        this.amountOfMoney += money;
    }
    /**
     * Faz o jogador pagar alguma coisa, caso tenha dinheiro.
     * @param money
     * @throws NotEnoughMoneyException caso não tenha dinheiro
     */
    public void debit(float money) throws NotEnoughMoneyException {
        if (this.amountOfMoney >= money) {
            this.amountOfMoney -= money;
        } else {
            throw new NotEnoughMoneyException("Not enough money");
        }
    }

    /**
     * Faz o jogador comprar a propriedade em que se encontra, caso tenha dinheiro
     * e aquela esteja a venda.
     * @throws game.model.exceptions.NotEnoughMoneyException
     * @throws game.model.exceptions.NotInSaleException
     * @throws game.model.exceptions.ItAlreadyHasAnOnwerException
     */
    public void buyProperty() throws NotEnoughMoneyException, NotInSaleException, GamePlaceException {
        if (!(atualPlace instanceof PurchasablePlace)) {
            throw new NotInSaleException("Place doesn't have a deed to be bought");
        } else if ((atualPlace instanceof Utility)) {
            throw new NotInSaleException("Deed for this place is not for sale");
        } else {
            PurchasablePlace p = (PurchasablePlace) atualPlace;
            if (p.getOwner().getName().equals("bank")) {
                debit(p.getPrice());
                p.setOwner(this);
                this.itsPropertys.add(p);
                if (p instanceof Railroad) {
                    updateRailroadsRunning();
                }
            } else {
                throw new GamePlaceException("Deed for this place is not for sale");
            }
        }
    }

    public ArrayList<PurchasablePlace> getItsPropertys() {
        return itsPropertys;
    }

    public void setItsPropertys(ArrayList<PurchasablePlace> itsPropertys) {
        this.itsPropertys = itsPropertys;
    }

    public List<Commands> getPlayerCommands() {
        return playerCommands;
    }

    public void setPlayerCommands(List<Commands> playerCommands) {
        this.playerCommands = playerCommands;
    }

    public String getStatus() {
        return "";
    }

    @Override
    public String toString() {
        return this.name + " " + this.color + " " + this.amountOfMoney;
    }

    /**
     * Método para pagamentos de aluguéis. Considera a possibilidade do player
     * nao ter dinheiro suficiente para pagar
     * @param otherPlayer - o jogador pra quem o aluguel será pago
     * @param rent - o valor do aluguel
     * @throws NotEnoughMoneyException - caso o jogador não tenha diheiro pra pagar o aluguel
     */
    public void payRent(Player otherPlayer, float rent) throws NotEnoughMoneyException {
        try {
            this.debit(rent);
            otherPlayer.credit(rent);
        } catch (NotEnoughMoneyException ex) {
            otherPlayer.credit(amountOfMoney);
            throw ex;
        }
    }

    /**
     * Faz o usuário andar pelo tabuleiro. Deposita $200 caso passe pelo ponto
     * de partida.
     * @param nPositions
     * @param board
     */
    public void walk(int nPositions) throws NonExistentPlaceException, Exception {

        int goTo = atualPosition + nPositions;

        /*
         * Adoraria poder refatorar esse método pra pegar o board do getBoard()
         * mas, por mais ilogico q isso seja, não esta dando  certo!!
         */
        goTo(goTo, true);

    }

    public void walk(int positionToGo, boolean salaryBonus) throws NonExistentPlaceException, Exception{

        //caso precise arrudeiar o tabuleiro
        if(positionToGo < atualPosition){
            positionToGo = 40 + positionToGo;
        }

        //System.out.println("                    positionToGo: " + positionToGo);

        goTo(positionToGo, salaryBonus);
    }

    public void goTo(int goTo, boolean salaryBonus) throws NonExistentPlaceException, Exception{
        Board board = Board.getBoard();

        if (goTo < 40) {
            setAtualPlace(board.getPlaceByPosition(goTo));
        } else {
            //usado nas cartas, para credito ou nao do salaryBonus
            if(salaryBonus){
                GameConfiguration gc = GameConfiguration.getConfiguration();
                this.credit(gc.getSalaryBonus());
            }

            if (goTo == 40) {
                setAtualPlace(board.getPlaceByPosition(goTo));
                setAtualPosition(0); //não ganha os 200 na proxima
            } else {
                setAtualPlace(board.getPlaceByPosition(goTo - 40));
            }
        }
        //System.out.println("                        GoTo: "+this.getName()+" está indo p place.action() place: " + atualPlace.getPosition());
        //System.out.println("                        GoTo: "+this.getName()+" player.getPlace() place: " + this.getAtualPlace().getPosition());
        atualPlace.action(this);

    }

    /**
     * Retorna o número de ferrovias do jogador
     * @return o número de ferrovias do jogador     *
     */
    private int getNumberOfRailRoads() {
        int n = 0;
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            if (purchasablePlace instanceof Railroad) {
                n++;
            }
        }
        return n;
    }
    /**
     * Atualiza o valor da corrida para as ferrovias do jogador
     */
    private void updateRailroadsRunning() {
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            if (purchasablePlace instanceof Railroad) {
                ((Railroad) purchasablePlace).setnRailroad(getNumberOfRailRoads());
            }
        }
    }

    /**
     * Adiciona uma carta à lista de cartas do jogador
     * @param card a carta que o jogador pegou
     */
    public void addCard(Card card){
        this.playerCards.add(card);
        this.playerCommands.add(Commands.USECARD);
    }

    /**
     * Usa uma carta caso o jogador a possua, ou esteja na cadeia, senão lança exceção
     * @param cardType o tipo de carta a ser usada
     * @throws InvalidPlayerPositionException caso o jogador não esteja na cadeia
     * @throws
     */
    public void useCard(String cardType)throws InvalidPlayerPositionException{
        
    }
}
