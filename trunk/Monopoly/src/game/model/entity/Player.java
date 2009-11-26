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
        first = true;
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

    public void setAtualPosition(int atualPosition) {
        this.atualPosition = atualPosition;
    }

    public int getAtualPosition(){
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

        debit( place.getPrice() );
        place.setOwner(this);
        this.itsPropertys.add(place);
        if(place instanceof Railroad){
            updateRailroadsRunning();
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
    public void walk(int nPositions, Board board) throws NonExistentPlaceException, Exception{

        int goTo = atualPosition + nPositions;
        System.out.println("-----------------");
        System.out.println(" WALK "+ name +" : "+playing);
        System.out.println(" Atual Money " + amountOfMoney);
        //System.out.println(" Dados " + nPositions);
        if(goTo < 40){
            setAtualPlace(board.getPlaceByPosition(goTo));
        }else{
             this.credit(200);
             if(goTo == 40){
                 setAtualPlace(board.getPlaceByPosition(goTo));
                 setAtualPosition(0);
             }else
                 setAtualPlace(board.getPlaceByPosition(goTo - 40));
        }

        System.out.println("Atual Place " + atualPlace.getName() + " numero: " + atualPlace.getPosition());
        atualPlace.action(this);
        System.out.println(" Atual Money " + amountOfMoney);
    }

    private int getNumberOfRailRoads(){
        int n = 0;
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            if(purchasablePlace instanceof Railroad){
                n++;
            }
        }
        System.out.println("NRail"+n);
        return n;
    }
    private void updateRailroadsRunning(){
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            if(purchasablePlace instanceof Railroad){
                ((Railroad)purchasablePlace).setnRailroad( getNumberOfRailRoads() );
            }
        }
    }
}
