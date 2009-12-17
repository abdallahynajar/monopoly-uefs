/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.util;

import game.model.entity.card.*;
import com.csvreader.CsvReader;
import game.model.entity.board.Board;
import game.model.entity.board.Place;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Lidiany
 */
public class CSVCardReader {

    private static CsvReader reader;

    public static ArrayList<Card> loadCards(String csvFile) throws IOException{
        reader = new CsvReader(csvFile);
        reader.readHeaders();
        
        ArrayList<Card> gameCards = new ArrayList<Card>();

                reader.readHeaders();
         int cardNumber = 0;
        while (reader.readRecord())
        {
            String cardType = reader.get("TYPE");
            if( cardType.equalsIgnoreCase("MOVE") ){
                 String description = reader.get("DESCRIPTION");
                 Board board = Board.getBoard();
                 Place place =  board.getPlaceByName( reader.get("PLACE") );
                 boolean paysBonus = Boolean.parseBoolean (reader.get("PAYSBONUS") );
                 
                Movement mv = new Movement(cardNumber, description, 
                                            place, paysBonus);
                gameCards.add(mv);

            }else if(cardType.equalsIgnoreCase("ASS") ){
                 String description = reader.get("DESCRIPTION");
                 int cardValue = Integer.parseInt( reader.get("VALUE") );
                 int feePerHouse = Integer.parseInt( reader.get("FEEPERHOUSE") );
                 int feePerHotel = Integer.parseInt( reader.get("FEEPERHOTEL") );
                 int feePerPlayer = Integer.parseInt( reader.get("FEEPERPLAYER") );

                Assessment ass = new Assessment(cardNumber, description,
                                                cardValue, feePerHotel,
                                                feePerHouse, feePerPlayer);
                 gameCards.add(ass);
            }
            System.out.println("CARD" + gameCards.get(cardNumber).getDescription());
            cardNumber++;
        }
                return gameCards;
    }

    
}
