/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.util;

import game.model.exceptions.InvalidDiceResultException;

/**
 *  Classe que contém os valores obtidos nos dados
 * @author Lidiany
 */
public  class Dice {

   private int firstDiceResult;
   private int secondDiceResult ;
   private int nDoublesDices;
   

   private static Dice dice;
    private Dice() {
        firstDiceResult = 0;
        secondDiceResult = 0;
        nDoublesDices=0;
    }

    public static Dice getDice(){
        if(dice == null){
            dice = new Dice();
        }
        return dice;
    }

    public boolean isDoubleResult(){
        if(firstDiceResult == secondDiceResult){
            nDoublesDices++;
            return true;
        }
        return false;
    }

    public void setRolledDices(int firstDiceResult, int secondDiceResult) {
        this.firstDiceResult = firstDiceResult;
        this.secondDiceResult = secondDiceResult;
    }

     /**
     * Valida os valores dos Dados     
     * @throws InvalidDiceResultException se os valores forem inválidos
     */
    public void validateDicesResult() throws InvalidDiceResultException {
        if (firstDiceResult <= 0 || secondDiceResult <= 0 ||
                firstDiceResult > 6 || secondDiceResult > 6) {
           throw new InvalidDiceResultException("Invalid die result");
        }       
    }

    public void cleanDice(){
        dice = null;
    }

    public int getFirstDiceResult() {
        return firstDiceResult;
    }

    public void setFirstDiceResult(int firstDiceResult) {
        this.firstDiceResult = firstDiceResult;
    }

    public int getSecondDiceResult() {
        return secondDiceResult;
    }

    public void setSecondDiceResult(int secondDiceResult) {
        this.secondDiceResult = secondDiceResult;
    }

    public int getnDoublesDices() {
        return nDoublesDices;
    }

    public void setnDoublesDices(int nDoublesDices) {
        this.nDoublesDices = nDoublesDices;
    }

}
