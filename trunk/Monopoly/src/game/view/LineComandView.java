/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.view;

import game.model.entity.Colors;

/**
 *
 * @author Lidiany
 */
public class LineComandView extends IOController implements GameView{   

    public LineComandView() {        
    }

    public int getNumberOfPlayers() {
        int numberOfPlayers = Integer.parseInt( readInputLine() );
        return numberOfPlayers;
    }

    public String getPlayerName() {
        String playerName = readInputLine();
       
        return playerName;
    }

    public String getPlayerColor() {
        String color = readInputLine();
        return color;
    }

    public void showMessage(String message) {
        this.writeMessage(message);
    }

    public void showOptionalColors() {
        StringBuffer colors = new StringBuffer() ;
            for (Enum c : Colors.values()) {
                colors.append("[");
                colors.append(c);
                colors.append("] ");
            }
            showMessage( colors.toString() );
    }

}
