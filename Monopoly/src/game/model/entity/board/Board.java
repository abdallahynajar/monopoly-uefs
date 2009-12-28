/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.board;

import game.model.exceptions.NonExistentPlaceException;
import game.model.exceptions.NonPurchasablePlaceException;
import game.util.CSVPlacesReader;
import java.io.IOException;
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
        try {
            //  buildBoardPlaces();
            places = CSVPlacesReader.loadPlaces();
        } catch (IOException ex) {
           
        }
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
      * retorna a prisão do tabuleiro
      * @return a prisão
      */
    public Jail findJail(){
        for (Place place : places) {
            if(place instanceof Jail){
                Jail jail = (Jail) place;
                if( jail.isJustVisiting() ){
                    return jail;
                }
            }
        }
        return null;
    }

    public static void cleanUpBoard(){
        board=null;        
    }
}
