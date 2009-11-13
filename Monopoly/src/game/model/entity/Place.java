/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 *
 * @author UEFS\jmatos
 * Representa um lugar no tabuleiro
 */
public class Place {
    
    private String name;
    private float price;
    private float rentWithoutHouse;
    private float oneHouse;
    private float twoHouse;
    private float treeHouse;
    private float fourHouse;
    private float hotel;
    private float hipoteca;
    private float housePrice;
    private String colour;
    private Player owner; 
    private int nHouses;

    public Place(String name, float price, float rentWithoutHouse, float oneHouse, float twoHouse, float treeHouse, float fourHouse, float hotel, float hipoteca, float housePrice, String colour) {
        this.name = name;
        this.price = price;
        this.rentWithoutHouse = rentWithoutHouse;
        this.oneHouse = oneHouse;
        this.twoHouse = twoHouse;
        this.treeHouse = treeHouse;
        this.fourHouse = fourHouse;
        this.hotel = hotel;
        this.hipoteca = hipoteca;
        this.housePrice = housePrice;
        this.colour = colour;
    }


    

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public float getFourHouse() {
        return fourHouse;
    }

    public void setFourHouse(float fourHouse) {
        this.fourHouse = fourHouse;
    }

    public float getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(float hipoteca) {
        this.hipoteca = hipoteca;
    }

    public float getHotel() {
        return hotel;
    }

    public void setHotel(float hotel) {
        this.hotel = hotel;
    }

    public float getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(float housePrice) {
        this.housePrice = housePrice;
    }

    public int getNHouses() {
        return nHouses;
    }

    public void setNHouses(int nHouses) {
        this.nHouses = nHouses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getOneHouse() {
        return oneHouse;
    }

    public void setOneHouse(float oneHouse) {
        this.oneHouse = oneHouse;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRentWithoutHouse() {
        return rentWithoutHouse;
    }

    public void setRentWithoutHouse(float rentWithoutHouse) {
        this.rentWithoutHouse = rentWithoutHouse;
    }

    public float getTreeHouse() {
        return treeHouse;
    }

    public void setTreeHouse(float treeHouse) {
        this.treeHouse = treeHouse;
    }

    public float getTwoHouse() {
        return twoHouse;
    }

    public void setTwoHouse(float twoHouse) {
        this.twoHouse = twoHouse;
    }

}
