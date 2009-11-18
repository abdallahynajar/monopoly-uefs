/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 *
 * @author UEFS\jmatos
 * Representa a entidade jogador
 */
public class Player {
    private int id;
    private String name;
    private String color;
    private long amountOfMoney;
    private Place atualPlace; //lugar em que o jogador está

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Place getAtualPlace() {
        return atualPlace;
    }

    public void setAtualPlace(Place atualPlace) {
        this.atualPlace = atualPlace;
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

    public void credit(long money){
        this.amountOfMoney +=money;
    }

    public void debit(long money){
        this.amountOfMoney -=money;
        //acho q poderiamos colcocar uma verificação aqui
        //se o montante ainda é positivo, pois se não for
        //GAME OVER - util para o pagamento de impostos
    }

    public void buyProperty(Property place){
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
        status.append("\n Títulos: \n");
        status.append("... falta listar os títulos");
        //falta listar os títulos
        return status.toString();
    }

    @Override
    public String toString() {
        return this.name + " " + this.color +" "+ this.amountOfMoney;
    }



}
