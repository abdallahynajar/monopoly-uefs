/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.exceptions;

/**
 * Signals that an Game exception of some sort has occurred.
 * @author Lidiany
 */
public class GameException extends Exception{

    public GameException(String message) {
        super(message);
    }

}
