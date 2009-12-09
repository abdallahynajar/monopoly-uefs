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

        chanceCards.add( new FinancialCard(1, "", 200) );
        chanceCards.add( new FinancialCard(2, "Erro do banco em seu favor", 200) );
        chanceCards.add( new FinancialCard(3, "Taxa do médico", -50) );
        chanceCards.add( new FinancialCard(4, "", 200) );
        chanceCards.add( new FinancialCard(5, "Da liquidação fora de estoque", 45) );
        chanceCards.add( new FinancialCard(6, "", 200) );
        chanceCards.add( new FinancialCard(7, "", 200) );
        chanceCards.add( new FinancialCard(8, "Restituição do Imposto de Renda", 20) );
        chanceCards.add( new FinancialCard(9, "", 200) );
        chanceCards.add( new FinancialCard(10, "", 200) );
        chanceCards.add( new FinancialCard(11, "", 200) );
        chanceCards.add( new FinancialCard(12, "", 200) );
        chanceCards.add( new FinancialCard(13, "", 200) );
        chanceCards.add( new FinancialCard(14, "", 200) );
        chanceCards.add( new FinancialCard(15, "", 200) );
        chanceCards.add( new FinancialCard(16, "", 200) );


    }

    private void initCommunityChestCards(){

    }
}
