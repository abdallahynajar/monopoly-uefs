/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Lidiany
 */
public abstract class IOController {
     private BufferedReader br;

    public IOController() {
        this.br = new BufferedReader(new InputStreamReader(System.in)); 
    }

    public void writeMessage(String message){
        System.out.println(" -- " + message +" -- ");

    }

    public String readInputLine(){
        String input =  null;
         try {
            input = br.readLine().toLowerCase();
        } catch (IOException ex) {
          input = null;
          ex.printStackTrace();
        }
        return input;
    }



}
