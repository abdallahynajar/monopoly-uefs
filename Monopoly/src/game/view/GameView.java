/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.view;

/**
 * Gerencia a interface entre o jogador e a camada de negócios
 * @author Lidiany
 */
public interface GameView {

    public int getNumberOfPlayers();

    public String getPlayerName();

    public String getPlayerColor();

    public String getYesOrNoOption();

    public String getPlayerCommand();

    public void showMessage(String message);
    
    public void showOptionalColors();

    public void showOptionalCommands();
    

}
