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
        inMonopoly = false;
    }

    public boolean isInMonopoly() {
        return inMonopoly;
    }

    public String getMonopoly() {
        return monopoly;
    }

    public void oneMore(){
        count++;
        inMonopoly = updateInMonopoly();
        if(inMonopoly)
            System.out.println("  Monopoly:" + monopoly);

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
            if(monopoly.equals("purple") || monopoly.equals("Indigo"))
                return true;
        }
        return false;

    }
}
