/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.util;

import com.csvreader.CsvReader;
import game.model.entity.board.Chance;
import game.model.entity.board.Chest;
import game.model.entity.board.FreeParking;
import game.model.entity.board.GoToJail;
import game.model.entity.board.Jail;
import game.model.entity.board.Place;
import game.model.entity.board.Property;
import game.model.entity.board.Railroad;
import game.model.entity.board.Tax;
import game.model.entity.board.Utility;
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
    public static ArrayList<Place> loadPlaces() throws IOException {
        String csvFile= "places.csv";
        InputStream in = ClassLoader.class.getResourceAsStream("/game/resources/places/" + csvFile);
        reader = new CsvReader(in, ';', Charset.forName("ISO-8859-1"));
        reader.readHeaders();
        ArrayList<Place> gamePlaces = new ArrayList<Place>();

        int position = 1;
        while (reader.readRecord()) {
            loadPlace(position, gamePlaces);
            position++;
        }
        return gamePlaces;
    }


    private static void loadPlace(int position, ArrayList<Place> gamePlaces) throws IOException, NumberFormatException {
        String placeType = reader.get("TYPE");
        String name = reader.get("DESCRIPTION");
        String placeGroup = reader.get("PLACEGROUP");

        long mortgage = loadMortgage();
        long price = loadPrice();

        if (placeType.equals("Property")) {
            float rent1 = Float.parseFloat(reader.get("RENT1"));
            float rent2 = Float.parseFloat(reader.get("RENT2"));
            float rent3 = Float.parseFloat(reader.get("RENT3"));
            float rent4 = Float.parseFloat(reader.get("RENT4"));
            float rent5 = Float.parseFloat(reader.get("RENT5"));
            float rent6 = Float.parseFloat(reader.get("RENT6"));
            float[] rent = new float[]{rent1, rent2, rent3, rent4, rent5, rent6};
            long housePrice = Long.parseLong(reader.get("HOUSEPRICE"));
            Property property = new Property(position, name, price, rent, mortgage, housePrice, placeGroup);
            gamePlaces.add(property);
        } else if (placeType.equalsIgnoreCase("Chest")) {
            Chest chest = new Chest(position, name, placeGroup);
            gamePlaces.add(chest);
        } else if (placeType.equalsIgnoreCase("Tax")) {
            Tax tax = new Tax(position, name, price);
            gamePlaces.add(tax);
        } else if (placeType.equalsIgnoreCase("Railroad")) {
            Railroad railroad = new Railroad(position, name, price, mortgage);
            gamePlaces.add(railroad);
        } else if (placeType.equalsIgnoreCase("Chance")) {
            Chance chance = new Chance(position, name, placeGroup);
            gamePlaces.add(chance);
        } else if (placeType.equalsIgnoreCase("Jail")) {
            Jail jail = new Jail(position, name, placeGroup, true);
            gamePlaces.add(jail);
        } else if (placeType.equalsIgnoreCase("Utility")) {
            Utility utility = new Utility(position, name, price, mortgage);
            gamePlaces.add(utility);
        } else if (placeType.equalsIgnoreCase("FreeParking")) {
            FreeParking freeParking = new FreeParking(position, name, placeGroup);
            gamePlaces.add(freeParking);
        } else if (placeType.equalsIgnoreCase("GoToJail")) {
            GoToJail goToJail = new GoToJail(position, name, placeGroup, true);
            gamePlaces.add(goToJail);
        }
    }

    public static void main(String[] args) {
        try {
            ArrayList<Place> gamePlaces = CSVPlacesReader.loadPlaces();
            for (Place place : gamePlaces) {
                System.out.print( place.getName() + "  ");
                System.out.print( place.getPosition() + "  ");
                System.out.println( place.getPlaceGroup() );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static long loadPrice() throws IOException, NumberFormatException {
        long price = 0;
        try {
            price = Long.parseLong(reader.get("PRICE"));
        } catch (NumberFormatException e) {
        }

        return price;
    }


    private static long loadMortgage() throws NumberFormatException, IOException {
         long mortgage = 0;
        try {
            mortgage = Long.parseLong(reader.get("MORTGAGE"));
        } catch (NumberFormatException e) {
        }

        return mortgage;
    }
}
