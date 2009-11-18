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
public class Property extends PurchasablePlace {

    private long housePrice;
    private String colour;
    private int nHouses;
    private float rent[];

    public Property(int position, String name, long price, float rent[], long hipoteca, long housePrice, String colour) {
        super.name = name;
        this.price = price;
        this.rent = rent;
        this.hipoteca = hipoteca;
        this.housePrice = housePrice;
        this.colour = colour;
    }
    
    public long getnHouses() {
        return nHouses;
    }

    public void setnHouses(int nHouses) {
        this.nHouses = nHouses;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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

    public void setNHouses(int nHouses) {
        this.nHouses = nHouses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float rentValue(){
        return rent[nHouses];
    }

    public void action(Player p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
