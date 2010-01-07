/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoly.cards;

/**
 * Classe que guarda as cartas do jogo e mantem informacoes sobre elas
 * @author Marcus
 */
public class CardsGame {
    /**
     * vetor de cartoes cofres comunitarios
     */
    Card[] CardsCofresComunitarios = new Card[16];
    /**
     * vetor de cartoes sorte reves
     */
    Card[] CardsSorteReves = new Card[16];
    
    /**
     * Construtor da classe
     */
    public CardsGame(){        
        initCardsCofresComunitarios();
        initCardsSorteReves();
    }
    /**
     * Metodo de inicializacao dos cartoes cofres comunitarios
     */
    public void initCardsCofresComunitarios(){
        CardsCofresComunitarios[0] = new Card(1, "Advance To Go - Collect $200", "Receba $200") ;
        CardsCofresComunitarios[1] = new Card(2, "Bank Error In Your Favor - Collect $200", "Receba $200") ;
        CardsCofresComunitarios[2] = new Card(3, "Doctor's Fee - Pay $50", "Pague $50") ;
        CardsCofresComunitarios[3] = new Card(4, "Grand Opera Opening - Collect $50 from every player for opening night seats", "Receba $50 de cada jogador pelas entradas") ;
        CardsCofresComunitarios[4] = new Card(5, "From Sale Out Of Stock - You Get $45", "Receba $45") ;
        CardsCofresComunitarios[5] = new Card(6, "Get Out Of Jail, Free - This card may be kept until needed or sold", "Esta carta pode ser mantida até o uso ou venda.") ;
        CardsCofresComunitarios[6] = new Card(7, "Go To Jail - Go directly to jail - Do not pass go - Do not collect $200", "Vá direto para a prisão – Não passe pelo ponto de partida – Não receba $200") ;
        CardsCofresComunitarios[7] = new Card(8, "Income Tax Refund - Collect $20", "Receba $20") ;
        CardsCofresComunitarios[8] = new Card(9, "Life Insurance Matures - Collect $100", "Receba $100") ;
        CardsCofresComunitarios[9] = new Card(10, "Pay Hospital - $100", "Pague $100") ;
        CardsCofresComunitarios[10] = new Card(11, "Pay School Tax - $150", "Pague $150") ;
        CardsCofresComunitarios[11] = new Card(12, "Receive For Your Services - $25", "Receba $25") ;
        CardsCofresComunitarios[12] = new Card(13, "XMAS Fund Matures - Collect $100", "Receba $100") ;
        CardsCofresComunitarios[13] = new Card(14, "You Have Won Second Prize In A Beauty Contest - Collect $10", "Receba $10") ;
        CardsCofresComunitarios[14] = new Card(15, "You Inherit - $100", "Receba $100") ;
        CardsCofresComunitarios[15] = new Card(16, "You Are Assessed For Street Repairs - $40 Per House, $115 Per Hotel", "Pague $40 por cada casa, $115 por hotel") ;
       
    }

    /**
     * Metodo de inicializacao dos cartoes sorte reves
     */
    public void initCardsSorteReves(){

        CardsSorteReves[0] = new Card(1, "Advance To Go - Collect $200", "Receba $200");
        CardsSorteReves[1] = new Card(2, "Advance To - Illinois Avenue", "Illinois Avenue");
        CardsSorteReves[2] = new Card(3, "Advance To St. Charles Place - If you pass Go, Collect $200", "Se passer pelo ponto de partida, receba $200");
        CardsSorteReves[3] = new Card(4, "Advance Token To Nearest Utility - If unowned you may buy it from the bank. If owned, throw dice and pay owner a total ten times the amount thrown.", "Se não tiver dono você pode comprá-lo do banco. Se tiver, lance os dados e pague ao dono 10 vezes o resultado do lançamento.");
        CardsSorteReves[4] = new Card(5, "Advance Token To The Nearest Railroad - Pay Owner Twice The Rental To Which He Is Otherwise entitled. If Railroad Is Unowned, You May Buy It From The Bank.", "Pague ao dono duas vezes o valor que ele deveria receber normalmente. Se a ferrovia não tiver dono, você pode comprá-la do banco.");
        CardsSorteReves[5] = new Card(6, "Bank Pays You Dividend Of - $50", "$50");
        CardsSorteReves[6] = new Card(7, "Go Back 3 Spaces", "");
        CardsSorteReves[7] = new Card(8, "Go Directly To Jail - Do Not Pass Go, Do Not Collect $200", "Não passe pelo ponto de partida, não receba $200.");
        CardsSorteReves[8] = new Card(9, "Make General Repairs On All Your Property - For Each House Pay $25, For Each Hotel $100", "Para cada casa pague $25, para cada hotel $10.");
        CardsSorteReves[9] = new Card(10, "Pay Poor Tax Of - $15", "$15");
        CardsSorteReves[10] = new Card(11, "This Card May Be Kept Until Needed Or Sold - Get Out Of Jail Free", "Get Out Of Jail Free");
        CardsSorteReves[11] = new Card(12, "Take A Ride On The Reading - If You Pass Go Collect $200", "Se você passer pelo Ponto de Partida receba $200");
        CardsSorteReves[12] = new Card(13, "Take A Walk On The Board Walk - Advance Token To Board Walk", "Avance o peão para Board Walk");
        CardsSorteReves[13] = new Card(14, "You Have Been Elected Chairman Of The Board - Pay Each Player $50", "Pague $50 para cada jogador");
        CardsSorteReves[14] = new Card(15, "Your Building And Loan Matures - Collect $150", "Receba $150");
        CardsSorteReves[15] = new Card(16, "Advance Token To The Nearest Railroad - Pay Owner Twice The Rental To Which He Is Otherwise entitled. If Railroad Is Unowned, You May Buy It From The Bank.", "Receba $150");

        
    }
    

    /**
     * Retorna cartoes Sorte Reves
     * @return os cartoes
     */
    public Card[] getSorteReves(){
        return CardsSorteReves;
    }
    /**
     * Retorna cartoes cofres comunitarios
     * @return os cartoes
     */
    public Card[] getCofresComunitarios(){
        return CardsCofresComunitarios;
    }
    /**
     * Retorna cartao sorte reves
     * @param index
     * @return o cartao
     * @throws Exception
     */
    public Card getCardSorteReves(int index) throws Exception{
        if(index>0 && index<=16){
            return CardsSorteReves[index-1];
        }
        else
            throw new Exception("Card doesn't exist");
        
    }
    /**
     * Retorna cartao cofres comunitarios
     * @param index
     * @return o cartao
     * @throws Exception
     */
    public Card getCardCofresComunitarios(int index) throws Exception{
        if(index>0 && index<=16){
            return CardsCofresComunitarios[index-1];
        }
        else
            throw new Exception("Card doesn't exist");

    }
}
