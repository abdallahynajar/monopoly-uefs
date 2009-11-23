/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import java.util.ArrayList;

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

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.itsPropertys = new ArrayList<PurchasablePlace>();
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

    public void debit(float money){
        this.amountOfMoney -=money;
        //acho q poderiamos colcocar uma verificação aqui
        //se o montante ainda é positivo, pois se não for
        //GAME OVER - util para o pagamento de impostos
    }

    public void buyProperty(PurchasablePlace place){
        debit( place.getPrice() );
        place.setOwner(this);
    }

    public String getStatus(){
        StringBuilder status = new StringBuilder();
        status.append( "Status de ");
        status.append(name);
        status.append(" - ");
        status.append(color);
        status.append("\n");
        status.append( "Situado na posição \n");
        status.append( ((Property)atualPlace).getPosition() ); //vou tirar esse kbrunco desse position
        status.append(" - ");
        status.append( atualPlace.getName() );
        status.append("\nPossui: ");
        status.append(amountOfMoney);
        if(!itsPropertys.isEmpty())
            listTitles(status);
        return status.toString();
    }

    @Override
    public String toString() {
        return this.name + " " + this.color +" "+ this.amountOfMoney;
    }

    private void listTitles( StringBuilder status){
        status.append("\nTítulos \n");
        for(Place p: itsPropertys){
            status.append("["+p.getName()+"] - " );
            if(p instanceof Property){
                Property property = (Property) p;
                status.append("propriedade " + property.getColour() + ", aluguel " + property.rentValue() + "\n");
            }else if(p instanceof Railroad){
                Railroad railroad = (Railroad) p;
                status.append("ferrovia, corrida " + railroad.getRunning() + "\n");
            }
        }

    }
    /**
     * Método para pagamentos de aluguéis. Considera a possibilidade do player
     * nao ter dinheiro suficiente para pagar
     * @author João
     * @param otherPlayer
     * @param rent
     */
    public void payRent(Player otherPlayer, float rent){
        if(this.amountOfMoney > rent){
            this.debit(rent);
            otherPlayer.credit(rent);
        }else{
            otherPlayer.credit(this.amountOfMoney);
            //quitar
        }
    }
    /**
     * Faz o usuário andar pelo tabuleiro
     * @author João
     * @param nPositions
     * @param board
     */
    public Place walk(int nPositions, Board board){
        int walk = atualPosition + nPositions;
        if(walk <= 40)
            atualPlace = board.getPlaceByPosition(atualPosition + nPositions);
        else{
            this.credit(200);
            atualPlace = board.getPlaceByPosition(walk - 40);
            atualPosition = atualPlace.getPosition();
        }
        return atualPlace;
    }
}
