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

        chanceCards.add( new FinancialCard(1, "", 200) );
        chanceCards.add( new FinancialCard(2, "Bank Pays You Dividend Of", 200) );
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
        //Advance To - Illinois Avenue
        //Advance To Go - Collect $200
                //Advance To St. Charles Place
        //Advance Token To Nearest Utility
        //Advance Token To The Nearest Railroad - Pay Owner Twice The Rental To Which He Is Otherwise entitled. If Railroad Is Unowned, You May Buy It From The Bank.
        //Bank Pays You Dividend Of - $50
        //Go Back 3 Spaces
        //Go Directly To Jail - Do Not Pass Go, Do Not Collect $200
        //Make General Repairs On All Your Property - For Each House Pay $25, For Each Hotel $100
        //Pay Poor Tax Of - $15
        //This Card May Be Kept Until Needed Or Sold - Get Out Of Jail Free
        //Take A Ride On The Reading - If You Pass Go Collect $200
        //Take A Walk On The Board Walk - Advance Token To Board Walk
        //You Have Been Elected Chairman Of The Board - Pay Each Player $50
        //Your Building And Loan Matures - Collect $150
        //Advance Token To The Nearest Railroad - Pay Owner Twice The Rental To Which He Is Otherwise entitled. If Railroad Is Unowned, You May Buy It From The Bank.
        //Bank Error In Your Favor - Collect $200
        //Doctor's Fee - Pay $50
        //Grand Opera Opening - Collect $50 from every player for opening night seats
        //From Sale Out Of Stock - You Get $45
        //Go To Jail - Go directly to jail - Do not pass go - Do not collect $200
        //Life Insurance Matures - Collect $100
        //Pay Hospital - $100
        //Pay School Tax - $150
        //Receive For Your Services - $25
        //XMAS Fund Matures - Collect $100
        //You Have Won Second Prize In A Beauty Contest - Collect $10
        //You Inherit - $100
        //You Are Assessed For Street Repairs - $40 Per House, $115 Per Hotel


    }

    private void initCommunityChestCards(){

    }
}
