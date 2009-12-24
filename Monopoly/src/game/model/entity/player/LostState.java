/**
    Universidade Estadual de Feira de Santana
    Padrões e Frameworks 2009.1
    Lidiany Cerqueira Santos   
    João de Matos
*/
package game.model.entity.player;

import game.model.entity.board.PurchasablePlace;

/**
 *
 * @author Lidiany
 */
public class LostState extends PlayerState{

    public LostState(Player aThis) {
        this.player = aThis;
    }

    @Override
    public void play() {
        //throw new Exception("Player no longer in the game");
    }

    public void releasePlayerProperties(){
        for (PurchasablePlace purchasablePlace : this.player.getItsPropertys()) {
            purchasablePlace.returnToBank();
        }
    }

    @Override
    public String getPlayerStatus() {
        return "lost";
    }

}
