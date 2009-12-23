/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.util;

/**
 *
 * @author shaka
 */
public class CheckMonopoly {

    private String monopoly;
    private boolean inMonopoly;
    private int count;

    public CheckMonopoly(String monopoly) {
        this.monopoly = monopoly;
        count = 1;
    }

    public boolean isInMonopoly() {
        return inMonopoly;
    }

    public String getMonopoly() {
        return monopoly;
    }

    public void oneMore(){
        count++;
        updateInMonopoly();

    }

    public void oneLess(){
        count--;
        updateInMonopoly();

    }

    private void updateInMonopoly(){
        if (count == 3)
            inMonopoly = true;
        if (count == 2){
            //não é a melhor solução, mas funciona assim =P
            if(monopoly.equals("purple") || monopoly.equals("Indigo"))
                inMonopoly = true;
        }
        inMonopoly = false;

    }
}
