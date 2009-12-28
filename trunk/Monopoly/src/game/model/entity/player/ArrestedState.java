/**
    Universidade Estadual de Feira de Santana
    Padrões e Frameworks 2009.1
    Lidiany Cerqueira Santos   
    João de Matos
*/
package game.model.entity.player;

import game.model.configuration.GameConfiguration;
import game.model.entity.board.Board;
import game.model.entity.board.Jail;
import game.model.exceptions.NotEnoughMoneyException;
import game.util.Command;
import game.util.CommandType;
import java.util.ArrayList;

/**
 *
 * @author Lidiany
 */
public class ArrestedState extends PlayerState{
    private int attemptsToLeaveJail = 0;

    public ArrestedState(Player aThis) {
        this.player = aThis;
    }

    @Override
    public void play() {
        //se estiver na cadeia, faz as ações da cadeia
        updateCommands();
        player.setPlayerCommands(playerCommands);
       // System.out.println("Atual place" + player.getAtualPlace().getPosition() );
    }

    public void paysBail(){
        int bail = GameConfiguration.getConfiguration().getPrisonBail();
        try {
            player.debit( bail );
            player.leavesJail();
            attemptsToLeaveJail =0;
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
    public void useCard(String cardType){
        player.releaseCard( player.getCard(cardType) );
        player.leavesJail();
    }

   public void addAtempt() {
          attemptsToLeaveJail ++;          
    }

    public int getAttemptsToLeaveJail() {
        return attemptsToLeaveJail;
    }

}
