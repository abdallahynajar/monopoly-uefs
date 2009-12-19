/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.util;

import com.csvreader.CsvReader;
import game.model.entity.board.Place;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Classe utilizada para carregar lugares de um arquivo .csv
 * @author Lidiany
 */
public class CSVPlacesReader {

    private static CsvReader reader;

    /**
     * @exception IOEXception  caso o arquivo não possa ser lido ou encontrado
     * @param csvFile o nome do arquivo com oslugares a serem lidos
     * @return a lista de lugares carregada do arquivo .csv
     */
    public static ArrayList<Place> loadPlaces(String csvFile) throws IOException {

        InputStream in = ClassLoader.class.getResourceAsStream("/game/resources/cards/" + csvFile);
        reader = new CsvReader(in, ';', Charset.forName("ISO-8859-1"));
        reader.readHeaders();
        ArrayList<Place> gamePlaces = new ArrayList<Place>();
        reader.readHeaders();
        int placeNumber = 0;
        while (reader.readRecord()) {
            String placeType = reader.get("TYPE");


            placeNumber++;
        }
        return gamePlaces;
    }

  /*  public static void main(String[] args) {
        try {
            CSVCardReader.loadCards("chances.csv");
            CSVCardReader.loadCards("communityChests.csv");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

}
