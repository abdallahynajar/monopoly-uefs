/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game.model.entity;

import java.util.Stack;

/**
 *
 * @author Lidiany
 */
public class CardBoard  {


    private Stack<Card> chanceCards;
    private Stack<Card> comunityChestCards;
    private static CardBoard cardBoard;

    private CardBoard() {
        this.chanceCards = new Stack<Card>();
        this.comunityChestCards = new Stack<Card>();
        initChanceCards();
        initCommunityChestCards();
    }

    public static CardBoard getCardBoard(){
        return (cardBoard == null ) ? new CardBoard(): cardBoard;
    }



    public Stack<Card> getChanceCards() {
        return chanceCards;
    }

    public void setChanceCards(Stack<Card> chanceCards) {
        this.chanceCards = chanceCards;
    }

    public Stack<Card> getComunityChestCards() {
        return comunityChestCards;
    }

    public void setComunityChestCards(Stack<Card> comunityChestCards) {
        this.comunityChestCards = comunityChestCards;
    }

    private void initChanceCards(){

        chanceCards.add( new FinancialCard(2, "", 200) );
         chanceCards.add( new FinancialCard(3, "", -50) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );
          chanceCards.add( new FinancialCard(2, "", 200) );


    }

    private void initCommunityChestCards(){

    }
}
