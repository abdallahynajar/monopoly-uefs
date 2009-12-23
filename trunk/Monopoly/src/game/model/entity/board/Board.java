/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.board;

import game.model.exceptions.NonExistentPlaceException;
import game.model.exceptions.NonPurchasablePlaceException;
import java.util.ArrayList;

/**
 * Representa o tabuleiro do monopoly
 * Utiliza o padrão singleton, pois utiliza-se somente um
 * tabuleiro por partida de Monopoly
 * @author UEFS\jmatos 
 */
public class Board {

    /**
     * Lugares do tabuleiro
     */
    private ArrayList<Place> places;
    /**
     * Instância estática do tabuleiro
     */
    private static Board board = null;

    /**
     * Construtor privado, só pode ser acessado dentro da classe
     */
    private Board() {
        buildBoardPlaces();
    }

    /**
     * Cria uma única instância do tabuleiro, caso esta ainda não tenha sido criada
     * Retorna o tabuleiro, caso este já tenha sido criado.
     */
    public static Board getBoard(){
        if(board == null){          
            board = new Board();
        }
        return board;        
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    /***
     * Busca um lugar no tabuleiro pelo nome
     * @param name  O nome do lugar a ser pesquisado
     * @return  a entidade Possession encontrada pela busca
     */
    public Place getPlaceByName(String name) {
        for (Place place : places) {
            if (place.getName().equalsIgnoreCase(name)) {
                return place;
            }
        }
        return null;
    }

    /**
     * Busca um lugar pela posição
     * @param position
     * @return lugar determinado pela posição no tabuleiro
     */
    public Place getPlaceByPosition(int position) throws NonExistentPlaceException {
        Place p = null;
        for (Place place : places) {
            if (place.getPosition() == position) {
                p = place;
            }
        }
        if (p == null) {
            throw new NonExistentPlaceException("Place doesn't exist");
        }
        return p;
    }

    public Place findNextUtility(Place place) throws NonExistentPlaceException{
        int atualposition = place.getPosition();

        for(int i = atualposition;;i++){
            Place p = getPlaceByPosition(i);
            if(p instanceof Utility)
                return p;

            i %= 40;
        }
    }

    public Place findNextRailroad(Place place) throws NonExistentPlaceException{
        int atualposition = place.getPosition();

        for(int i = atualposition;;i++){
            Place p = getPlaceByPosition(i);
            if(p instanceof Railroad)
                return p;

            i %= 40;
        }
    }

    /**
     * Busca o nome de um lugar pela posição
     * @param position
     * @return nome do lugar determinado pela posição
     */
    public String getPlaceName(int position) throws NonExistentPlaceException {
        Place p = getPlaceByPosition(position);   
        return p.getName();        
    }
    /**
     * Retorna o preço de uma propriedade, caso esta seja compravel
     * @param position
     * @return lugar determiado pela posição
     * @throws game.model.exceptions.NonExistentPlaceException
     * @throws game.model.exceptions.NonPurchasablePlaceException
     */
    public int getPlacePrice(int position) throws NonExistentPlaceException, NonPurchasablePlaceException {
        try {
            PurchasablePlace p = (PurchasablePlace) getPlaceByPosition(position);
            return (int) p.getPrice();
        } catch (ClassCastException ex) {
            throw new NonPurchasablePlaceException("This place can't be sold");
        }
    }

    /**
     * Retorna o atual preço do aluguel de uma proprieade, quando este existe.
     * @param position
     * @return rent - aluguel da posicao
     * @throws game.model.exceptions.NonExistentPlaceException
     * @throws game.model.exceptions.NonPurchasablePlaceException
     */
    public int getPropertyRent(int position) throws NonExistentPlaceException, NonPurchasablePlaceException{
        try {
            Property p = (Property) getPlaceByPosition(position);           
            return (int) p.getRent();

        } catch (ClassCastException ex) {
            throw new NonPurchasablePlaceException("This place doesn't have a rent");
        }

    }
    /**
     * Retorna o dono de um determinado lugar, caso este possa ser comprado
     * @param position
     * @return owner
     * @throws game.model.exceptions.NonExistentPlaceException
     * @throws game.model.exceptions.NonPurchasablePlaceException
     */
     public String getPlaceOwner (int position) throws NonExistentPlaceException, NonPurchasablePlaceException{
        try {
            PurchasablePlace p = (PurchasablePlace) getPlaceByPosition(position);
            if (p.getOwner() != null) {
                return p.getOwner().getName();
            }
            return null;

        } catch (ClassCastException ex) {
            throw new NonPurchasablePlaceException("This place can't be owned");
        }catch(NullPointerException nex){
            throw new NonExistentPlaceException("Place doesn't exist");
        }
    }

     /**
      * retorna o grupo de um lugar.
      * @param position
      * @return placeGroup
      * @throws game.model.exceptions.NonExistentPlaceException
      */
      public String getPlaceGroup (int position) throws NonExistentPlaceException{
            Place p =  getPlaceByPosition(position);
            if (p == null) {
                throw new NonExistentPlaceException("Place doesn't exist");
            }
            return p.getPlaceGroup().toLowerCase();

    }

      /**
       * Constrói o tabuleiro com seus lugares
       */
    private void buildBoardPlaces() {      
        places = new ArrayList<Place>();
        places.add(new Property(1, "Mediterranean Avenue", 60, new float[]{2, 10, 30, 90, 160, 250}, 30, 50, "purple"));
        places.add(new Chest(2, "Community Chest 1", "chest"));
        places.add(new Property(3, "Baltic Avenue", 60, new float[]{4, 20, 60, 180, 320, 450}, 30, 50, "purple"));
        places.add(new Tax(4, "Income Tax", 200));
        places.add(new Railroad(5, "Reading Railroad", 200, 100));
        places.add(new Property(6, "Oriental Avenue", 100, new float[]{6, 30, 90, 270, 400, 550}, 50, 50, "Light Blue"));
        places.add(new Chance(7, "Chance 1", "chance"));
        places.add(new Property(8, "Vermont Avenue", 100, new float[]{6, 30, 90, 270, 400, 550}, 50, 50, "Light Blue"));
        places.add(new Property(9, "Connecticut Avenue", 120, new float[]{8, 40, 100, 300, 450, 600}, 60, 50, "Light Blue"));
        places.add(new Jail(10, "Jail - Just Visiting", "corner", true));
        places.add(new Property(11, "St. Charles Place", 140, new float[]{10, 50, 150, 450, 625, 750}, 70, 100, "pink"));
        places.add(new Utility(12, "Electric Company", 150, 75));
        places.add(new Property(13, "States Avenue", 140, new float[]{10, 50, 150, 450, 625, 750}, 70, 100, "pink"));
        places.add(new Property(14, "Virginia Avenue", 160, new float[]{12, 60, 180, 500, 700, 900}, 80, 100, "pink"));
        places.add(new Railroad(15, "Pennsylvania Railroad", 200, 100));
        places.add(new Property(16, "St. James Place", 180, new float[]{14, 70, 200, 550, 750, 950}, 90, 100, "Orange"));
        places.add(new Chest(17, "Community Chest 2", "chest"));
        places.add(new Property(18, "Tennessee Avenue", 180, new float[]{14, 70, 200, 550, 750, 950}, 90, 100, "Orange"));
        places.add(new Property(19, "New York Avenue", 200, new float[]{16, 80, 220, 600, 800, 1000}, 100, 100, "Orange"));
        places.add(new FreeParking(20, "Free Parking", "corner"));
        places.add(new Property(21, "Kentucky Avenue", 220, new float[]{18, 90, 250, 700, 875, 1050}, 110, 150, "Red"));
        places.add(new Chance(22, "Chance 2", "chance"));
        places.add(new Property(23, "Indiana Avenue", 220, new float[]{18, 90, 250, 700, 875, 1050}, 110, 150, "Red"));
        places.add(new Property(24, "Illinois Avenue", 240, new float[]{20, 100, 300, 750, 925, 1100}, 110, 150, "Red"));
        places.add(new Railroad(25, "B & O Railroad", 200, 100));
        places.add(new Property(26, "Atlantic Avenue", 260, new float[]{22, 110, 330, 800, 975, 1150}, 130, 150, "Yellow"));
        places.add(new Property(27, "Ventnor Avenue", 260, new float[]{22, 110, 330, 800, 975, 1150}, 130, 150, "Yellow"));
        places.add(new Utility(28, "Water Works", 150, 75));
        places.add(new Property(29, "Marvin Gardens", 280, new float[]{24, 120, 360, 850, 1025, 1200}, 140, 150, "Yellow"));
        places.add(new Jail(30, "Go To Jail", "corner", true));
        places.add(new Property(31, "Pacific Avenue", 300, new float[]{26, 130, 390, 900, 1100, 1275}, 150, 200, "Green"));
        places.add(new Property(32, "North Carolina Avenue", 300, new float[]{26, 130, 390, 900, 1100, 1275}, 150, 200, "Green"));
        places.add(new Chest(33, "Community Chest 3", "chest"));
        places.add(new Property(34, "Pennsylvania Avenue", 320, new float[]{28, 150, 450, 1000, 1200, 1400}, 160, 200, "Green"));
        places.add(new Railroad(35, "Short Line Railroad", 200, 100));
        places.add(new Chance(36, "Chance 3", "chance"));
        places.add(new Property(37, "Park Place", 350, new float[]{35, 175, 500, 1100, 1300, 1500}, 175, 200, "Indigo"));
        places.add(new Tax(38, "Luxury Tax", 75));
        places.add(new Property(39, "Boardwalk", 400, new float[]{50, 200, 600, 1400, 1700, 2000}, 200, 200, "Indigo"));
        places.add(new FreeParking(40, "Go", "corner")); // o go é a posição 40!
    }

    public static void cleanUpBoard(){
        board=null;        
    }
}
