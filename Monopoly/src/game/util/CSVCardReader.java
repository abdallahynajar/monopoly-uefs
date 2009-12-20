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
    public static ArrayList<Card> loadCards(String csvFile) throws IOException {

        InputStream in = ClassLoader.class.getResourceAsStream("/game/resources/cards/" + csvFile);      
        reader = new CsvReader(in, ';', Charset.forName("ISO-8859-1"));
        reader.readHeaders();
        ArrayList<Card> gameCards = new ArrayList<Card>();
        reader.readHeaders();
        int cardNumber = 0;
        while (reader.readRecord()) {
            String cardType = reader.get("TYPE");
            if (cardType.equalsIgnoreCase("MOVE")) {
                String description = reader.get("DESCRIPTION");
                Board board = Board.getBoard();
                Place place = board.getPlaceByName(reader.get("PLACE"));
                boolean paysBonus = Boolean.parseBoolean(reader.get("PAYSBONUS"));

                Movement mv = new Movement(cardNumber, description,
                        place, paysBonus);
                gameCards.add(mv);               

            } else if (cardType.equalsIgnoreCase("ASS")) {
                String description = reader.get("DESCRIPTION");
                int cardValue = Integer.parseInt(reader.get("VALUE"));
                int feePerHouse = Integer.parseInt(reader.get("FEEPERHOUSE"));
                int feePerHotel = Integer.parseInt(reader.get("FEEPERHOTEL"));
                int feePerPlayer = Integer.parseInt(reader.get("FEEPERPLAYER"));

                Assessment ass = new Assessment(cardNumber, description,
                        cardValue, feePerHotel,
                        feePerHouse, feePerPlayer);
                gameCards.add(ass);
            }

            cardNumber++;
        }
        return gameCards;
    }

   public static void main(String[] args) {
        try {
            CSVCardReader.loadCards("chances.csv");
            CSVCardReader.loadCards("communityChests.csv");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
    

