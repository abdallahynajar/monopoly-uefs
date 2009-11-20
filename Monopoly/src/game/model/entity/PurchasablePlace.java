/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

/**
 *
 * @author UEFS\jmatos
 */
public abstract class PurchasablePlace extends Place{

    protected float price;
    protected float hipoteca;
    protected Player owner;

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
    
    public abstract void action(Player p);
    /**
     * Oferece a propriedade para compra. Deve ser usado quando a propriedade não
     * tiver dono
     * @param p
     */
    public void buyProperty(Player p){
        if(p.getAmountOfMoney() >= getPrice()){
             //corrigir isso aqui pela aquela viadagem de showmessage.
            System.out.println("A título da propriedade "+super.getName()+" está disponível por $"+getPrice()+".");
            System.out.println(p.getName()+", você possui $"+p.getAmountOfMoney()+".");
            System.out.println("Você deseja comprar "+super.getName()+" (Sim/Não)?");

            //falta capturar a resposta, e atribuir, ou não, a proprieade a um dono
            //e debitar  o dinheiro
        }
        
    }

}
