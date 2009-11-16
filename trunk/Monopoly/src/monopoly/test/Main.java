/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoly.test;

import game.controller.GameController;
import game.view.LineComandView;

/**
 *
 * @author Lidiany
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GameController gc = new GameController();
       gc.setGameView( new LineComandView() );
       gc.initializeGame();
       gc.startGame();
       gc.finishGame();
    }

}
