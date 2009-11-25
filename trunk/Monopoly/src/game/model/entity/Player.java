/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import game.model.exceptions.NonExistentPlaceException;
import game.model.exceptions.NotEnoughMoneyException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UEFS\jmatos
 * Representa a entidade jogador
 */
public class Player {
    private int id;
    private String name;
    private String color;
    private float amountOfMoney;
    private Place atualPlace; //lugar em que o jogador está
    private ArrayList<PurchasablePlace> itsPropertys;
    private int atualPosition;
    private List<Commands> playerCommands;
    private boolean playing;
    private boolean first = true;

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

    public void fail(){
        playing = false;
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            purchasablePlace.returnToBank();
        }
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }


    public void add(PurchasablePlace place){
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

    public int getAtualPosition(){
        return atualPosition;
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

    public void credit(float money){
        this.amountOfMoney +=money;
    }

    public void debit(float money) throws NotEnoughMoneyException{
        if(this.amountOfMoney >= money){
           this.amountOfMoney -=money;
        }else{
            throw new NotEnoughMoneyException("Not enough money");
        }
    }

    public void buyProperty(PurchasablePlace place)throws NotEnoughMoneyException{
//        System.out.println("buyProperty");
//        System.out.println("Player" + name);
//        System.out.println(place.getName());


        debit( place.getPrice() );
        place.setOwner(this);
        this.itsPropertys.add(place);
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

    public String getStatus(){     
        return "";
    }

    @Override
    public String toString() {
        return this.name + " " + this.color +" "+ this.amountOfMoney;
    }

    /**
     * Método para pagamentos de aluguéis. Considera a possibilidade do player
     * nao ter dinheiro suficiente para pagar
     * @author João
     * @param otherPlayer - o jogador pra quem o aluguel será pago
     * @param rent - o valor do aluguel
     * @throws NotEnoughMoneyException - caso o jogador não tenha diheiro pra pagar o aluguel
     */
    public void payRent(Player otherPlayer, float rent) throws NotEnoughMoneyException{
       try{
            this.debit(rent);
            otherPlayer.credit(rent);
       }catch(NotEnoughMoneyException ex){
            otherPlayer.credit( amountOfMoney );
            throw ex;
        }
    }
    /**
     * Faz o usuário andar pelo tabuleiro
     * @author João
     * @param nPositions
     * @param board
     */
    public Place walk(int nPositions, Board board) throws NonExistentPlaceException, Exception{

        int walk = atualPosition + nPositions;
        if(walk <= 40)
            atualPlace = board.getPlaceByPosition(atualPosition + nPositions);
        else{
            if (!first)
                this.credit(200);
            first = false;
            atualPlace = board.getPlaceByPosition(walk - 40);
            atualPosition = atualPlace.getPosition();
        }
//        System.out.println("atualPlace " + atualPlace.getName()+ " " + atualPlace.getPosition() );
        atualPlace.action(this);
        return atualPlace;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
}
