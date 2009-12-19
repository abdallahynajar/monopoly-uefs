/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.card;

import java.util.Stack;

/**
 *
 * @author Lidiany
 */
public class CardStack  {


    private Stack<Card> chanceCards;
    private Stack<Card> comunityChestCards;
    private static CardStack cardBoard;

    private CardStack() {
        this.chanceCards = new Stack<Card>();
        this.comunityChestCards = new Stack<Card>();
        initChanceCards();
        initCommunityChestCards();
    }

    public static CardStack getCardBoard(){
        return (cardBoard == null ) ? new CardStack(): cardBoard;
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

//        chanceCards.add( new Assessment(1, "", 200) );
//        chanceCards.add( new Assessment(2, "Bank Pays You Dividend Of", 200) );
//        chanceCards.add( new Assessment(3, "Taxa do médico", -50) );
//        chanceCards.add( new Assessment(4, "", 200) );
//        chanceCards.add( new Assessment(5, "Da liquidação fora de estoque", 45) );
//        chanceCards.add( new Assessment(6, "", 200) );
//        chanceCards.add( new Assessment(7, "", 200) );
//        chanceCards.add( new Assessment(8, "Restituição do Imposto de Renda", 20) );
//        chanceCards.add( new Assessment(9, "", 200) );
//        chanceCards.add( new Assessment(10, "", 200) );
//        chanceCards.add( new Assessment(11, "", 200) );
//        chanceCards.add( new Assessment(12, "", 200) );
//        chanceCards.add( new Assessment(13, "", 200) );
//        chanceCards.add( new Assessment(14, "", 200) );
//        chanceCards.add( new Assessment(15, "", 200) );
//        chanceCards.add( new Assessment(16, "", 200) );


    }

    private void initCommunityChestCards(){

    }
}
