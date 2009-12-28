/**
    Universidade Estadual de Feira de Santana
    Padrões e Frameworks 2009.1
    Lidiany Cerqueira Santos   
    João de Matos
*/
package game.model.entity.board;

import game.model.configuration.GameConfiguration;
import game.model.entity.player.Player;

/**
 * Representa um lugar do tipo cadeia no tabuleiro
 * @author Lidiany
 */
public class Jail extends Place{

    private boolean justVisiting;

    public Jail(int position , String name, String placeGroup, boolean justVisiting) {
        this.justVisiting = justVisiting;
        super.name = name;
        super.placeGroup = placeGroup;
        super.position = position;
    }

    public boolean isJustVisiting() {
        return justVisiting;
    }

    public void setJustVisiting(boolean justVisiting) {
        this.justVisiting = justVisiting;
    }

    @Override
    public void action(Player p) throws Exception {
        boolean isJailActive =
        GameConfiguration.getConfiguration().isActivateJail();
        if(isJailActive && !justVisiting){            
            p.goesToJail();
            justVisiting = true;
        } 
    }

}
