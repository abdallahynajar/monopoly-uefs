/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.card;

import game.model.exceptions.NonExistentCardException;
import java.io.IOException;
import java.util.ArrayList;
import game.util.CSVCardReader;

/**
 *
 * @author Lidiany
 */
public class CardStack {

    private ArrayList<Card> chanceCards;
    private ArrayList<Card> chestCards;
    private int currentChanceCard = 1; // range 1 .. 15
    private int currentChestCard = 1; //range 1 .. 16
    private static CardStack cardBoard;

    private CardStack() {
        currentChanceCard = 1;
        currentChestCard = 1;
    }

    public static CardStack getCardStack() {
        return (cardBoard == null) ? new CardStack() : cardBoard;
    }

    public void loadChanceCards() {
        try {
            this.chanceCards = CSVCardReader.loadCards("chances.csv");         
        } catch (IOException ex) {
        }
    }

    public void loadChestCards() {
        try {
            this.chestCards = CSVCardReader.loadCards("communityChests.csv"); 
        } catch (IOException ex) {
        }

    }

    public Card getCurrentChanceCard() throws NonExistentCardException{
        Card card = null;
        try{           
            card = chanceCards.get(currentChanceCard - 1);
        }catch(Exception ex){
            throw new NonExistentCardException("Card doesn't exist");
        }
        return card;
    }

    public Card getCurrentChestCard()throws NonExistentCardException{
           Card card = null;
        try{            
            card = chestCards.get( currentChestCard -1);
        }catch(Exception ex){
            throw new NonExistentCardException("Card doesn't exist");
        }

             return card;
    }

    public Card getChanceCard() throws NonExistentCardException{
        Card card = null;
        try{            
            card = chanceCards.get(currentChanceCard - 1);
        }catch(Exception ex){
            throw new NonExistentCardException("Card doesn't exist");
        }          
        updateCurrentChanceCard();  
        return card;
    }

    public Card getChestCard()throws NonExistentCardException{
           Card card = null;
        try{
           
            card = chestCards.get( currentChestCard -1);
        }catch(Exception ex){
            throw new NonExistentCardException("Card doesn't exist");
        }
      
        updateCurrentChestCard();      
          
             return card;
    }

    public void forceNextChanceCard(int cardID) throws NonExistentCardException{
       
        if(cardID <=0 || cardID >15){
             throw new NonExistentCardException("Card doesn't exist");
        }else{
             currentChanceCard = cardID;
        }
    }

    public void forceNextChestCard(int cardID) throws NonExistentCardException{
       
        if(cardID <=0 || cardID >16){
             throw new NonExistentCardException("Card doesn't exist");
        }else{
             currentChestCard = cardID;
        }
    }

    private void updateCurrentChanceCard() {
        if (currentChanceCard == chanceCards.size()) {
            currentChanceCard = 1;
        } else {
            currentChanceCard++;
        }
    }

    private void updateCurrentChestCard() {
        if (currentChestCard == chestCards.size()) {           
            currentChestCard = 1;
        } else {
            currentChestCard++;
        }
    }
}
