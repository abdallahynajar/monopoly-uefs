/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 * Classe que representa o banco do Monopoly
 * @author Marcus
 */
public class Banco {
    /**
     * indice de numero de casas do banco
     */
    private int casas = 32;
    /**
     * indice de numero de hoteis do banco
     */
    private int hoteis = 12;   
    /**
     * Retorna numero de casas
     * @return o numero de casas
     */
    public int getCasas() {
        return casas;
    }
    /**
     * Retorna o valor de uma casa na propriedade para compra
     * @param idPropriedade
     * @return o valor da casa
     * @throws Exception
     */
    public int comprarCasa(int idPropriedade) throws Exception {
        if (this.casas == 0) {
            throw new Exception("No more houses available for sale");
        } else {
            casas = casas - 1;
            return getPrecoDeUmaCasa(idPropriedade);
        }
    }
    /**
     * Retorna o valor de uma casa na propriedade para venda
     * @param idPropriedade
     * @return o valor da casa
     * @throws Exception
     */
    public int VenderCasa(int idPropriedade) throws Exception {

        //casas++;
        return getPrecoDeUmaCasa(idPropriedade) / 2;

    }

    public int getHoteis() {
        return hoteis;
    }
    

    /**
     * Retorna o valor de um hotel na propriedade para compra
     * @param idPropriedade
     * @return o valor do hotel
     * @throws Exception
     */
    public int comprarHotel(int idPropriedade) throws Exception {
        if (this.hoteis == 0) {
            throw new Exception("No more hotels available for sale");
        } else {
            hoteis--;
            return this.getPrecoDeUmaCasa(idPropriedade);
        }
    }
    /**
     * Retorna o valor de um hotel na propriedade para venda
     * @param idPropriedade
     * @return o valor do hotel
     * @throws Exception
     */
    public int venderHotel(int idPropriedade) throws Exception {

        hoteis++;
        return this.getPrecoDeUmaCasa(idPropriedade) / 2;

    }
    /**
     * Retorna valor de uma casa
     * @param id
     * @return o valor da casa
     */
    private int getPrecoDeUmaCasa(int id) {
        if (id == 1 || id == 3 || id == 6 || id == 8 || id == 9) {
            return 50;
        } else if (id == 11 || id == 13 || id == 14 || id == 16 || id == 18 || id == 19) {
            return 100;
        } else if (id == 21 || id == 23 || id == 24 || id == 26 || id == 27 || id == 29) {
            return 150;
        } else if (id == 31 || id == 34 || id == 37 || id == 39 || id == 32) {
            return 200;
        } else {
            return 0;
        }
    }
    /**
     * Banco recebe 4 casas
     */
    public void BancoReceber4Casas() {
        casas = casas + 4;
    }
    /**
     * Banco perde 4 casas
     */
    public void BancoPerder4Casas() {
        casas = casas - 4;
    }
    /**
     * Banco adiciona o numero de casas em uma unidade
     */
    public void addCasas() {
        this.casas++;
    }
    /**
     * Banco adiciona o numero de hoteis em uma unidade
     */
    public void addHoteis() {
        this.hoteis++;
    }
}
