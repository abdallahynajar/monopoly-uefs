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
 *
 * @author Lidiany
 */
public class GoToJail extends Place {

    public GoToJail(int position, String name, String placeGroup, boolean justVisiting) {
        super.name = name;
        super.placeGroup = placeGroup;
        super.position = position;
    }

    @Override
    public void action(Player p) throws Exception {
        boolean isJailActive =
                GameConfiguration.getConfiguration().isActivateJail();
        if (isJailActive) {
            Jail jail = Board.getBoard().findJail();
            jail.setJustVisiting(false);
            p.goTo(jail.getPosition(), false);
            
        }
    }
}
