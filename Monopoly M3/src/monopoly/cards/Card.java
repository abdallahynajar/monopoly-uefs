/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoly.cards;

/**
 * Classe de modelagem de cartoes
 * @author Marcus
 */
public class Card {
    /**
     * id do cartao
     */
    protected  int numberCard;
    /**
     * Nome do cartao
     */
    protected  String NameCard;
    /**
     * Descricao do Cartao
     */
    protected  String Descricao;
    /**
     * Construtor do cartao
     * @param numberCard
     * @param Descricao
     * @param NameCard
     */
    public Card(int numberCard, String Descricao, String NameCard) {
        this.numberCard = numberCard;
        this.NameCard = NameCard;
        this.Descricao = Descricao;
    }
    /**
     * Retorna a descricao do cartao
     * @return a descricao
     */
    public String getDescricao() {
        return Descricao;
    }
    /**
     * Retorna o numero do cartao
     * @return o numero
     */
    public int getNumberCard() {
        return numberCard;
    }
 
   
}
