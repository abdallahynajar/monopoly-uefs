/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.entity;

import game.util.Commands;
import game.model.entity.board.Place;
import game.model.entity.board.Board;
import game.model.entity.board.Railroad;
import game.model.entity.board.PurchasablePlace;
import game.model.entity.board.Utility;
import game.model.configuration.GameConfiguration;
import game.model.exceptions.GamePlaceException;
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

    private int id;
    private String name;
    private String color;
    private float amountOfMoney;
    
    /**
     * Lugar onde o jogador se encontra
     */
    private Place atualPlace;

    private int atualPosition;
    /**
     * Lista de proprieades que o jodador possui.
     */
    private ArrayList<PurchasablePlace> itsPropertys;

    /**
     * Comandos que o jogador pode executar
     */
    private List<Commands> playerCommands;

    private boolean playing;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.itsPropertys = new ArrayList<PurchasablePlace>();
        playing = true;
        playerCommands = new ArrayList<Commands>();
        playerCommands.add(Commands.ROLL);
        playerCommands.add(Commands.STATUS);
        playerCommands.add(Commands.QUIT);
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
    public void walk(int nPositions, Board board) throws NonExistentPlaceException, Exception {

        int goTo = atualPosition + nPositions;
        if (goTo < 40) {
            setAtualPlace(board.getPlaceByPosition(goTo));
        } else {
            GameConfiguration gc = GameConfiguration.getConfiguration();
            this.credit( gc.getSalaryBonus() );
            if (goTo == 40) {
                setAtualPlace(board.getPlaceByPosition(goTo));
                setAtualPosition(0); //não ganha os 200 na proxima
            } else {
                setAtualPlace(board.getPlaceByPosition(goTo - 40));
            }
        }
        atualPlace.action(this);
    }
    
    private int getNumberOfRailRoads() {
        int n = 0;
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            if (purchasablePlace instanceof Railroad) {
                n++;
            }
        }
        return n;
    }

    private void updateRailroadsRunning() {
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            if (purchasablePlace instanceof Railroad) {
                ((Railroad) purchasablePlace).setnRailroad(getNumberOfRailRoads());
            }
        }
    }
}
