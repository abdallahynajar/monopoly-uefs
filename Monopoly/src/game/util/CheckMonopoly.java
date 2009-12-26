/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.util;

import game.model.entity.board.PurchasablePlace;
import java.util.ArrayList;

/**
 *
 * @author shaka
 */
public class CheckMonopoly {

    private String monopoly;
    private boolean inMonopoly;
    private int count;
    
    /**
     * Poderia ser qualquer um, é o primerio 
     */
    ArrayList<PurchasablePlace> neighbors;

    public CheckMonopoly(PurchasablePlace pp) {
        this.monopoly = pp.getPlaceGroup();
        count = 1;
        inMonopoly = false;
        this.neighbors = new ArrayList<PurchasablePlace>();
        this.neighbors.add(pp);
        pp.setNeighbor(this.neighbors);

    }

    public boolean isInMonopoly() {
       // if(this.inMonopoly)
            //System.out.println(monopoly + " já é um monopoly");
        return inMonopoly;
    }

    public String getMonopoly() {
        return monopoly;
    }

    public void oneMore(PurchasablePlace pp){
        count++;
        neighbors.add(pp);
        pp.setNeighbor(this.neighbors);
        inMonopoly = updateInMonopoly();
    }

    public void oneLess(){
        count--;
        inMonopoly = updateInMonopoly();

    }

    private boolean updateInMonopoly(){
        if (count == 3)
            return true;
        if (count == 2){
            //não é a melhor solução, mas funciona assim =P
            if(monopoly.equalsIgnoreCase("purple") || monopoly.equalsIgnoreCase("Indigo"))
                return true;
        }
        return false;

    }
}
