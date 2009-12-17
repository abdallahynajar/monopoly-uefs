/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.util;

import game.model.entity.card.*;
import com.csvreader.CsvReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Lidiany
 */
public class CSVCardReader {

    private CsvReader reader;


    public void readFile( String csvFile) throws IOException{
        reader = new CsvReader(csvFile);
        reader.readHeaders();
    }

    public ArrayList<Card> loadCard() throws IOException{

        ArrayList<Card> cardGames = new ArrayList<Card>();

                reader.readHeaders();

        while (reader.readRecord())
        {
            String cardType = reader.get("TYPE");
            if( cardType.equalsIgnoreCase("MOVE") ){

                Movement mv = new Movement(0, null, null, true);
                cardGames.add(mv);

            }else if(cardType.equalsIgnoreCase("ASS") ){

                Assessment ass = new Assessment(0, null, 0);
                 cardGames.add(ass);
            }

//                        String productID = reader.get("ProductID");
//                        String productName = reader.get("ProductName");
//                        String supplierID = reader.get("SupplierID");
//                        String categoryID = reader.get("CategoryID");
//                        String quantityPerUnit = reader.get("QuantityPerUnit");
//                        String unitPrice = reader.get("UnitPrice");
//                        String unitsInStock = reader.get("UnitsInStock");
//                        String unitsOnOrder = reader.get("UnitsOnOrder");
//                        String reorderLevel = reader.get("ReorderLevel");
//                        String discontinued = reader.get("Discontinued");

            //carrega a lista de cartas do arquivo
            //deve ser chamado pelo board card pra pegar as cartas do chance ou do cchest :P

                // perform program logic here

        }
                return cardGames;

    }


}
