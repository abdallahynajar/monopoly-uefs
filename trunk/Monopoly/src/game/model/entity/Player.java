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

    @Override
    public String toString() {
        return this.name + " " + this.color +" "+ this.amountOfMoney;
    }



}
