/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.test;

import easyaccept.EasyAcceptFacade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lidiany
 */
public class MonopolyTest {


    public static void main(String[] args) {
          List<String> files = new ArrayList<String>();

              //Put the testScript1 file into the "test scripts" list
              files.add("easyTests/us1.txt");
              //files.add("easyTests/us2.txt");
             //files.add("easyTests/usL.txt");
             // files.add("easyTests/us3.txt");
              //files.add("easyTests/us4.txt");
              //Put the testScript2 file into the "test scripts" list
               //files.add("testScript2.txt");
                //Instantiate your software façade              
              FacadeMonopoly facadeMonopoly = new FacadeMonopoly();
              //Instantiate EasyAccept façade
              EasyAcceptFacade eaFacade = new EasyAcceptFacade(facadeMonopoly, files);
              //Execute the tests
              eaFacade.executeTests();
              //Print the tests execution results
              System.out.println(eaFacade.getCompleteResults()); 
    }

}
