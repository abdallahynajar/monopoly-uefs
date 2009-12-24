/**
    Universidade Estadual de Feira de Santana
    Padrões e Frameworks 2009.1
    Lidiany Cerqueira Santos   
    João de Matos
*/
package game.model.entity.player;

import game.model.configuration.GameConfiguration;
import game.model.entity.board.Board;
import game.model.exceptions.NonExistentPlaceException;
import game.model.exceptions.NotEnoughMoneyException;
import game.util.Dice;

/**
 *
 * @author Lidiany
 */
public class PlayingState extends PlayerState{

    

    public PlayingState(Player aThis) {
        this.player = aThis;
    }


    @Override
    public void play()  {
        //walk( Dice.FIRSTDICERESULT + Dice.SECONDDICERESULT );
    }


    /**
     * Faz o jogador andar pelo tabuleiro. Deposita $200 caso passe pelo ponto
     * de partida.
     * @param nPositions
     * @param board
     */
    public void walk(int nPositions) throws NonExistentPlaceException, Exception {

        int goTo = player.getAtualPosition() + nPositions;       
             goTo(goTo, true); //se o jgador perder, mandar ele para o status Lost
        

    }


    public void goTo(int goTo, boolean salaryBonus) throws NonExistentPlaceException, Exception{
        Board board = Board.getBoard();

        if (goTo < 40) {
            player.setAtualPlace(board.getPlaceByPosition(goTo));
        } else {
            //usado nas cartas, para credito ou nao do salaryBonus
            if(salaryBonus){
                GameConfiguration gc = GameConfiguration.getConfiguration();
                player.credit(gc.getSalaryBonus());
            }

            if (goTo == 40) {
                player.setAtualPlace(board.getPlaceByPosition(goTo));
                player.setAtualPosition(0); //não ganha os 200 na proxima
            } else {
                player.setAtualPlace(board.getPlaceByPosition(goTo - 40));
            }
        }      
            player.getAtualPlace().action(player);
        
       // player.updateCommands();
    }

    @Override
    public String getPlayerStatus() {
        return "playing";
    }




}
