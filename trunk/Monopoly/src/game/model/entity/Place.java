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

    //TODO refatorar essa classe p jogar umas coisas em Property
    private Property property;

    private String name;
    private int position;
    private long price;
    private long rentWithoutHouse;
    private long oneHouse;
    private long twoHouse;
    private long treeHouse;
    private long fourHouse;
    private long hotel;
    private long hipoteca;
    private long housePrice;
    private String colour;
    private Player owner; 
    private long nHouses;

    public Place(int position, String name, long price, long rentWithoutHouse, long oneHouse, long twoHouse, long treeHouse, long fourHouse, long hotel, long hipoteca, long housePrice, String colour) {
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

        //temporário TODO RETIRAR isso
        property = new Property();
        property.setPurchasable(true);
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }


    public long getnHouses() {
        return nHouses;
    }

    public void setnHouses(long nHouses) {
        this.nHouses = nHouses;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public long getFourHouse() {
        return fourHouse;
    }

    public void setFourHouse(long fourHouse) {
        this.fourHouse = fourHouse;
    }

    public long getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(long hipoteca) {
        this.hipoteca = hipoteca;
    }

    public long getHotel() {
        return hotel;
    }

    public void setHotel(long hotel) {
        this.hotel = hotel;
    }

    public long getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(long housePrice) {
        this.housePrice = housePrice;
    }

    public long getNHouses() {
        return nHouses;
    }

    public void setNHouses(long nHouses) {
        this.nHouses = nHouses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOneHouse() {
        return oneHouse;
    }

    public void setOneHouse(long oneHouse) {
        this.oneHouse = oneHouse;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getRentWithoutHouse() {
        return rentWithoutHouse;
    }

    public void setRentWithoutHouse(long rentWithoutHouse) {
        this.rentWithoutHouse = rentWithoutHouse;
    }

    public long getTreeHouse() {
        return treeHouse;
    }

    public void setTreeHouse(long treeHouse) {
        this.treeHouse = treeHouse;
    }

    public long getTwoHouse() {
        return twoHouse;
    }

    public void setTwoHouse(long twoHouse) {
        this.twoHouse = twoHouse;
    }

    //TODO
    public long rentValue(){
        return 0; //atualizar o valor do aluguel de acordo com o número de casas
    }

}
