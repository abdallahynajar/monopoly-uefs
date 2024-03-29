/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
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
//
              files.add("easyTests/us1.txt");
              files.add("easyTests/us2.txt");
              files.add("easyTests/us3.txt");
              files.add("easyTests/us4.txt");
              files.add("easyTests/us5.txt");
              files.add("easyTests/us6.txt");
              files.add("easyTests/us7.txt");
              files.add("easyTests/us8.txt");
              files.add("easyTests/us9.txt");

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
