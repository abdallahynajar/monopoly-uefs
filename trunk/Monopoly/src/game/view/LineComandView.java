/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.view;

import game.model.entity.Colors;
import game.model.entity.Commands;

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

     public String getPlayerCommand() {
        String command = readInputLine();
        return command;
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

    public void showOptionalCommands() {
       StringBuffer commands = new StringBuffer() ;
            for (Enum c : Commands.values()) {
                commands.append("[");
                commands.append(c);
                commands.append("] ");
            }
            showMessage( commands.toString() );
    }

    public String getYesOrNoOption() {
        String option = readInputLine();
        return option;
    }

}
