/**
    Universidade Estadual de Feira de Santana
    Padrões e Frameworks 2009.1
    Lidiany Cerqueira Santos   
    João de Matos
*/
package game.model.entity.player;

import game.model.configuration.GameConfiguration;
import game.model.exceptions.InvalidPlayerPositionException;
import game.model.exceptions.NotEnoughMoneyException;
import game.util.Command;
import game.util.CommandType;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lidiany
 */
public class ArrestedState extends PlayerState{

    public ArrestedState(Player aThis) {
        this.player = aThis;
    }

    @Override
    public void play() {
        //se estiver na cadeia, faz as ações da cadeia
        updateCommands();
        player.setPlayerCommands(playerCommands);

    }

    public void paysBail(){
        int bail = GameConfiguration.getConfiguration().getPrisonBail();
        try {
            player.debit( bail );
           //
        } catch (NotEnoughMoneyException ex) {
            player.leavesGame();
        }
    }

    @Override
    public String getPlayerStatus() {
        return "arrested";
    }

      private void updateCommands(){
        if(playerCommands == null){
            playerCommands = new ArrayList<Command>();
            playerCommands.add(new Command(CommandType.ROLL, true));
            playerCommands.add(new Command(CommandType.STATUS, true));
            playerCommands.add(new Command(CommandType.QUIT, true));
            playerCommands.add(new Command(CommandType.PAY, true));
            return;
        }
      }


    /**
     * Usa uma carta caso o jogador a possua, ou esteja na cadeia, senão lança exceção
     * @param cardType o tipo de carta a ser usada
     * @throws InvalidPlayerPositionException caso o jogador não esteja na cadeia
     * @throws
     */
    public void useCard(String cardType)throws InvalidPlayerPositionException{

    }

    public void useCard() {
        
    }

}
