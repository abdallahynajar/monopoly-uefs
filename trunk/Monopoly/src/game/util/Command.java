/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.util;

/**
 *
 * @author shaka
 */
public class Command {
    private CommandType type;
    private boolean active;

    public Command(CommandType type, boolean active) {
        this.type = type;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        
        //if(!this.active && active)
       //     System.out.println("comando: " + type + " foi ativado");
       // if(this.active && !active)
        //    System.out.println("comando: " + type + " foi ativado");

       // this.active = active;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }

    

}
