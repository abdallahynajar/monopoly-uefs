/**
    Universidade Estadual de Feira de Santana
    Padrões e Frameworks 2009.1
    Lidiany Cerqueira Santos   
    João de Matos
*/
package game.model.entity.player;

import game.model.exceptions.GameException;
import game.util.Command;
import java.util.List;

/**
 *
 * @author Lidiany
 */
public abstract  class PlayerState {
    
    Player player;

      /**
     * Comandos que o jogador pode executar
     */
    List<Command> playerCommands = null;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public abstract void play();

    public abstract String getPlayerStatus();


}
