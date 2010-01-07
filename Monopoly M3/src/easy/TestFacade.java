package easy;

import easyaccept.EasyAcceptFacade;
import java.util.ArrayList;
import java.util.List;

/**
 * Testes das Milestone 1 e 2
 * @author Marcus
 */
public class TestFacade {

    /**
     * Executa os testes da milestone 1
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        List<String> files = new ArrayList<String>();
        //Put the us1.txt file into the "test scripts" list

        addUsers(files);
        
        //Instantiate the Monopoly Game façade
        UserStoriesFacade monopolyGameFacade = new UserStoriesFacade();
        //Instantiate EasyAccept façade
        EasyAcceptFacade eaFacade = new EasyAcceptFacade(monopolyGameFacade, files);
        //Execute the tests
        eaFacade.executeTests();
        //Print the tests execution results
        System.out.println(eaFacade.getCompleteResults());
    }

     /**
     * Adiciona as userStories
     * @param Lista de arquivos
     */
    static void addUsers(List<String> files) {
          files.add("easyTests/us1.txt");
              files.add("easyTests/us2.txt");
              files.add("easyTests/us3.txt");
              files.add("easyTests/us4.txt");
              files.add("easyTests/us5.txt");
              files.add("easyTests/us6.txt");
              files.add("easyTests/us7.txt");
              files.add("easyTests/us8.txt");
              files.add("easyTests/us9.txt");
              files.add("easyTests/us10.txt");
    }
}

