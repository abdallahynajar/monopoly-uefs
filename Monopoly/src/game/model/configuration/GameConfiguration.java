/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model.configuration;

import java.util.ResourceBundle;

/**
 *  Armazena os parametros de configuração do jogo.
 * @author UEFS\jmatos
 */
public class GameConfiguration {

    //Ativa compra automática de propriedade;
    private boolean autoBuy;
    /** Valor em dinheiro para cada jogador no ínicio do jogo*/
    private float initialMoney;
    /** Bonus ao passar pelo Go*/
    private float salaryBonus;
    /** Ativa construção igualitária*/
    private boolean equalityBuilding;
    /* Ativa dobro de bonus ao passar pelo Go*/
    private boolean doubleBonusMoney;
    /** Ativa regra do freeParking*/
    private boolean freeParkingRule;
    /** Determina a quantidade de casas necessária para construir um hotel*/
    private int housesToHotel;

    private int amountOfHouses;
    private int amountOfHotels;
    /** Valor por estacionamento*/
    private int freeParkingValue;
    /** Valor das taxas*/
    private int taxValue;
    /**Valor das taxas especiais*/
    private int especialTaxValue;
    /** Máximo de turnos que o jogador fica na prisão*/
    private int maxPrisonTurns;

    /** Valor da fiança */
    private int prisonBail;
    private int mortgageTax;
    private int distributedTitles;
    /** Ativa os lugares do tipo Sorte/revés*/
    private boolean activateChancePlaces;
    /**Ativa embaralhamento das cartas*/
    private boolean cardShuffle;
    /**Ativa lugares do tipo cofres comunitários*/
    private boolean activateChestPlaces;

    /**Ativa cadeia**/
    private boolean activateJail;

    /**Ativa cadeia**/
    private boolean activateDoublesRule;

    /**Ativa a construção*/
    private boolean activateBuild;

    /**Ativa a venda*/
    private boolean activateSell;

    /** Ativa os serviçõs públicos*/
    private boolean activateUtilityPlaces;



    private static GameConfiguration gc;
    
    /**Arquivo de configuração do jogo */
    private static ResourceBundle rc = ResourceBundle.getBundle("game.model.configuration.gameConfig");

    public static GameConfiguration getConfiguration() {
        if (gc == null) {
            gc = new GameConfiguration();
        }
        return gc;
    }

    public boolean isActivateBuild() {
        return activateBuild;
    }

    public void setActivateBuild(boolean activateBuild) {
        this.activateBuild = activateBuild;
    }

    public boolean isActivateSell() {
        return activateSell;
    }

    public void setActivateSell(boolean activateSell) {
        this.activateSell = activateSell;
    }

    public GameConfiguration() {
        this.autoBuy = Boolean.parseBoolean( rc.getString("isAutoBuy") );
        this.initialMoney = Integer.parseInt( rc.getString("initialMoney") );
        this.salaryBonus = Integer.parseInt( rc.getString("salaryBonus") );
        this.equalityBuilding = Boolean.parseBoolean( rc.getString("isEqualityBuilding") );
        this.doubleBonusMoney = Boolean.parseBoolean( rc.getString("isDoubleBonusMoney") );
        this.freeParkingRule = Boolean.parseBoolean( rc.getString("isFreeParkingRule") );
        this.housesToHotel = Integer.parseInt( rc.getString("housesToHotel") );
        this.amountOfHouses = Integer.parseInt( rc.getString("amountOfHouses") );
        this.amountOfHotels = Integer.parseInt( rc.getString("amountOfHotels") );
        this.freeParkingValue = Integer.parseInt( rc.getString("freeParkingValue") );
        this.taxValue = Integer.parseInt( rc.getString("taxValue") );
        this.especialTaxValue = Integer.parseInt( rc.getString("especialTaxValue") );
        this.maxPrisonTurns = Integer.parseInt( rc.getString("maxPrisonTurns") );
        this.prisonBail = Integer.parseInt( rc.getString("prisonBail") );
        this.mortgageTax = Integer.parseInt( rc.getString("mortgageTax") );
        this.distributedTitles = Integer.parseInt( rc.getString("distributedTitles") );
        this.activateChancePlaces = Boolean.parseBoolean( rc.getString("activateChancePlaces") );
        this.cardShuffle = Boolean.parseBoolean( rc.getString("cardShuffle") );
        this.activateChestPlaces = Boolean.parseBoolean( rc.getString("activateChestPlaces") );
        this.activateJail = Boolean.parseBoolean( rc.getString("activateJailPlaces") );
        this.activateBuild = Boolean.parseBoolean( rc.getString("activateBuild") );
        this.activateSell = Boolean.parseBoolean( rc.getString("activateSell") );
        this.activateDoublesRule = Boolean.parseBoolean( rc.getString("activateDoublesRule") );
        this.activateUtilityPlaces = Boolean.parseBoolean( rc.getString("activateUtilityPlaces") );
    }

    public static void cleanUp(){
        GameConfiguration.gc = null;
    }

    public boolean isActivateChancePlaces() {
        return activateChancePlaces;
    }

    public void setActivateChancePlaces(boolean activateChancePlaces) {
        this.activateChancePlaces = activateChancePlaces;
    }

    public boolean isCardShuffle() {
        return cardShuffle;
    }

    public void setCardShuffle(boolean cardShuffle) {
        this.cardShuffle = cardShuffle;
    }    

    public float getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(float salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

    public boolean isAutoBuy() {
        return autoBuy;
    }

    public void setAutoBuy(boolean autoBuy) {
        this.autoBuy = autoBuy;
    }

    public float getInitialMoney() {
        return initialMoney;
    }

    public void setInitialMoney(float initialMoney) {
        this.initialMoney = initialMoney;
    }

    public int getAmountOfHotels() {
        return amountOfHotels;
    }

    public void setAmountOfHotels(int amountOfHotels) {
        this.amountOfHotels = amountOfHotels;
    }

    public int getAmountOfHouses() {
        return amountOfHouses;
    }

    public void setAmountOfHouses(int amountOfHouses) {
        this.amountOfHouses = amountOfHouses;
    }

    public int getDistributedTitles() {
        return distributedTitles;
    }

    public void setDistributedTitles(int distributedTitles) {
        this.distributedTitles = distributedTitles;
    }

    public boolean isDoubleBonusMoney() {
        return doubleBonusMoney;
    }

    public void setDoubleBonusMoney(boolean doubleBonusMoney) {
        this.doubleBonusMoney = doubleBonusMoney;
    }

    public boolean isEqualityBuilding() {
        return equalityBuilding;
    }

    public void setEqualityBuilding(boolean equalityBuilding) {
        this.equalityBuilding = equalityBuilding;
    }

    public int getEspecialTaxValue() {
        return especialTaxValue;
    }

    public void setEspecialTaxValue(int especialTaxValue) {
        this.especialTaxValue = especialTaxValue;
    }

    public boolean isFreeParkingRule() {
        return freeParkingRule;
    }

    public void setFreeParkingRule(boolean freeParkingRule) {
        this.freeParkingRule = freeParkingRule;
    }

    public int getFreeParkingValue() {
        return freeParkingValue;
    }

    public void setFreeParkingValue(int freeParkingValue) {
        this.freeParkingValue = freeParkingValue;
    }

    public static GameConfiguration getGc() {
        return gc;
    }

    public static void setGc(GameConfiguration gc) {
        GameConfiguration.gc = gc;
    }

    public int getHousesToHotel() {
        return housesToHotel;
    }

    public void setHousesToHotel(int housesToHotel) {
        this.housesToHotel = housesToHotel;
    }

    public int getMaxPrisonTurns() {
        return maxPrisonTurns;
    }

    public void setMaxPrisonTurns(int maxPrisonTurns) {
        this.maxPrisonTurns = maxPrisonTurns;
    }

    public int getMortgageTax() {
        return mortgageTax;
    }

    public void setMortgageTax(int mortgageTax) {
        this.mortgageTax = mortgageTax;
    }

    public int getPrisonBail() {
        return prisonBail;
    }

    public void setPrisonBail(int prisonBail) {
        this.prisonBail = prisonBail;
    }

    public static ResourceBundle getRc() {
        return rc;
    }

    public static void setRc(ResourceBundle rc) {
        GameConfiguration.rc = rc;
    }

    public int getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(int taxValue) {
        this.taxValue = taxValue;
    }

    public boolean isActivateChestPlaces() {
        return activateChestPlaces;
    }

    public void setActivateChestPlaces(boolean activateChestPlaces) {
        this.activateChestPlaces = activateChestPlaces;
    }

    public boolean isActivateJail() {
        return activateJail;
    }

    public void setActivateJail(boolean activateJail) {
        this.activateJail = activateJail;
    }

    public boolean isActivateDoublesRule() {
        return activateDoublesRule;
    }

    public void setActivateDoublesRule(boolean activateDoublesRule) {
        this.activateDoublesRule = activateDoublesRule;
    }

    public boolean isActivateUtilityPlaces() {
        return activateUtilityPlaces;
    }

    public void setActivateUtilityPlaces(boolean activateUtilityPlaces) {
        this.activateUtilityPlaces = activateUtilityPlaces;
    }



}
