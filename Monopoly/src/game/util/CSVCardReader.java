/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.util;

import game.model.entity.card.*;
import com.csvreader.CsvReader;
import game.model.entity.board.Board;
import game.model.entity.board.Place;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 *
 * Classe utilizada para carregar cartas de um arquivo .csv
 * @author Lidiany
 * 
 */
public class CSVCardReader {

    private static CsvReader reader;

    /**
     * @exception IOEXception  caso o arquivo não possa ser lido ou encontrado
     * @param csvFile o nome do arquivo com as cartas a serem lidas
     * @return a lista de cartas carregada do arquivo .csv
     */
    public static ArrayList<Card> loadCards(String cardsFile, String cardsType) throws IOException {

        InputStream in = ClassLoader.class.getResourceAsStream("/game/resources/cards/" + cardsFile);
        reader = new CsvReader(in, ';', Charset.forName("ISO-8859-1"));        
        ArrayList<Card> gameCards = new ArrayList<Card>();
        reader.readHeaders();
        int cardNumber = 0;        
        while (reader.readRecord()) {            
            loadCard(cardNumber, gameCards, cardsType);
            cardNumber++;
        }         
        reader.close();
        return gameCards;
    }


    private static void loadCard(int cardNumber, ArrayList<Card> gameCards, String type) throws IOException, NumberFormatException {
           
            String cardType = reader.get("TYPE");
            String description = reader.get("DESCRIPTION");

            if (cardType.equalsIgnoreCase("MOVE")) {
                
                Board board = Board.getBoard();
                Place place = board.getPlaceByName(reader.get("PLACE"));
                boolean paysBonus = Boolean.parseBoolean(reader.get("PAYSBONUS"));
                int walk = Integer.parseInt(reader.get("WALK"));
                MovementCard mv = new MovementCard(cardNumber, description, place, paysBonus, walk, type);
                gameCards.add(mv);
            } else if (cardType.equalsIgnoreCase("ASS")) {
                //String description = reader.get("DESCRIPTION");
                int cardValue = Integer.parseInt(reader.get("VALUE"));
                int feePerHouse = Integer.parseInt(reader.get("FEEPERHOUSE"));
                int feePerHotel = Integer.parseInt(reader.get("FEEPERHOTEL"));
                int feePerPlayer = Integer.parseInt(reader.get("FEEPERPLAYER"));
                AssessmentCard ass = new AssessmentCard(cardNumber, description, cardValue, feePerHotel, feePerHouse, feePerPlayer, type);
                gameCards.add(ass);
            } else if (cardType.equalsIgnoreCase("JAIL")) {
                //String description = reader.get("DESCRIPTION");
                OutOfJailCard ofJail = new OutOfJailCard(cardNumber, description, type);
                gameCards.add(ofJail);
            } else if (cardType.equalsIgnoreCase("MOVEUTILITY")){
                boolean collectSalary = Boolean.parseBoolean(reader.get("PAYSBONUS"));
                UtilityCard uc = new UtilityCard(cardNumber, description, collectSalary, type);
                gameCards.add(uc);

            } else if (cardType.equalsIgnoreCase("MOVERAILROAD")){
                boolean collectSalary = Boolean.parseBoolean(reader.get("PAYSBONUS"));
                RailroadCard rc = new RailroadCard(cardNumber, description, collectSalary, type);
                gameCards.add(rc);
            }   else if (cardType.equalsIgnoreCase("PAYPLAYERS")){
                int cardValue = Integer.parseInt(reader.get("VALUE"));
                PayPlayersCard ppc = new PayPlayersCard(cardNumber, description, cardValue, type);
                gameCards.add(ppc);
            } else if (cardType.equalsIgnoreCase("COLLECT")){
                int cardValue = Integer.parseInt(reader.get("VALUE"));
                CollectPlayersCard cpc = new CollectPlayersCard(cardNumber, description, cardValue, type);
                gameCards.add(cpc);
            }else if (cardType.equalsIgnoreCase( "MOVEJAIL")){
               Board board = Board.getBoard();
                Place place = board.getPlaceByName(reader.get("PLACE"));
                GoToJailCard gtj = new GoToJailCard(cardNumber, description, place, false, 0, type);
                gameCards.add(gtj);

            } else if (cardType.equalsIgnoreCase("REPAIR")){
                int feePerHouse = Integer.parseInt(reader.get("FEEPERHOUSE"));
                int feePerHotel = Integer.parseInt(reader.get("FEEPERHOTEL"));
                RepairCard r = new RepairCard(cardNumber, description, type, feePerHouse,feePerHotel);
                gameCards.add(r);
            }

    }
}

    

