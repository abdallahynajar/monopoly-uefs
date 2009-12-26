/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.board;

import game.model.entity.player.Player;
import game.model.entity.*;
import game.model.configuration.GameConfiguration;
import game.model.exceptions.GamePlaceException;
import game.model.exceptions.NotEnoughMoneyException;
import game.model.exceptions.NotInSaleException;
import java.util.ArrayList;

/**
 *  Representa um lugar no tabuleiro que pode ser comprado. Acrescenta alguns métodos
 *  e atributos a Place, para caracterizar um lugar que pode ser comprado.
 * @author UEFS\jmatos
 */
public abstract class PurchasablePlace extends Place{

    /**
     * Preço do lugar
     */
    protected float price;
    /**
     * Hipoeca do lugar
     */
    protected float hipoteca;
    /**
     * Proprietário do lugar, no ínicio do jogo, todas a propriedades pertencem ao banco
     */
    protected Player owner = new Player("bank", null); 

    /**
     * Terá os lugares que pertencem ao mesmo grupo, para poder comparar o número
     * de casas com as outras, para autotizar ou não a construção
     */
    protected ArrayList<PurchasablePlace> neighbors;

    public ArrayList<PurchasablePlace> getNeighbor() {
        return neighbors;
    }

    public void setNeighbor(ArrayList<PurchasablePlace> neighbors) {
        this.neighbors = neighbors;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public float getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(float hipoteca) {
        this.hipoteca = hipoteca;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Usado para comprar automaticamente uma propriedade, caso o jogo seja configurado
     * para isso
     * @param player
     */
    public void buyProperty(Player player) throws NotEnoughMoneyException, NotInSaleException, GamePlaceException{
        GameConfiguration gc = GameConfiguration.getConfiguration();
        if(gc.isAutoBuy()){
            player.buyProperty();
        }
    }

    public void returnToBank(){
        this.owner = new Player("bank", null);
    }
}
