package monopoly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Contem as informacoes do Jogador
 * @author Marcus
 */
public class Jogador {

    /**
     * id do jogador
     */
    private int id = 0;
    /**
     * Nome do jogador
     */
    private String Nome = "";
    /**
     * cor do peao do jogador
     */
    private String CorPeao = "";
    /**
     * dinheiro inicial do jogador
     */
    private int dinheiro = 1500;
    /**
     * Lista das posses do jogador
     */
    private ArrayList<String> propriedades = new ArrayList<String>();
    /**
     * Lista de comandos do jogador
     */
    private Comandos comandos = new Comandos();
    /**
     * Flag de Cartao Chance para saida de prisao
     */
    private boolean CardChanceSaidaDaPrisao = false;
    /**
     * Flag de Cartao Chest para saida de prisao
     */
    private boolean CardChestSaidaDaPrisao = false;
    /**
     * Indice de tentaticas de saida de prisao
     */
    private int tentativasSairDaPrisao = 0;
    /**
     * Indice de quantidade de Companhias do Jogador
     */
    private int quantidadeCompanhias = 0;
    /**
     * Indice de quantidade de casas do jogador
     */
    private int quantidadeDeCasas = 0;
    /**
     * Indice de quantidade de Hoteis do Jogador
     */
    private int quantidadeDeHoteis = 0;

    private boolean bankruptcy;

    public boolean isBankruptcy() {
        return bankruptcy;
    }

    public void setBankruptcy(boolean bankruptcy) {
        this.bankruptcy = bankruptcy;
    }
    /**
     * Retorna a quantidade de casas do jogador
     * @return a quantidade de casas
     */
    public int getQuantidadeDeCasas() {
        return quantidadeDeCasas;
    }
    /**
     * Retorna a quantidade de Hoteis
     * @return a quantidade de Hoteis
     */

    public int getQuantidadeDeHoteis() {
        return quantidadeDeHoteis;
    }
    /**
     * Adiciona em uma unidade o numero de casas
     */
    public void addQuantidadeDeCasas() {
        this.quantidadeDeCasas++;
    }
    /**
     * Diminui em uma unidade o numero de casas
     */
    public void diminuirQuantidadeDeCasas() {
        this.quantidadeDeCasas--;
    }
    /**
     * Aumenta em uma unidade o numero de Hoteis
     */
    public void addQuantidadeDeHoteis() {
        this.quantidadeDeHoteis++;
    }
    /**
     * Diminui em Uma unidade o numero de Hoteis
     */
    public void diminuirQuantidadeDeHoteis() {
        this.quantidadeDeHoteis--;
    }
    /**
     * Retorna a quantidade de companhias
     * @return a quantidade de companhias
     */
    public int getQuantidadeCompanhias() {
        return quantidadeCompanhias;
    }
    /**
     * Seta a quantidade de companhias
     * @param quantidadeCompanhias
     */
    public void setQuantidadeCompanhias(int quantidadeCompanhias) {
        this.quantidadeCompanhias = quantidadeCompanhias;
    }
    /**
     * Adiciona em uma unidade a quantidade de companhias
     */
    public void addQuantidadeCompanhias() {
        this.quantidadeCompanhias++;
    }
    /**
     * Retorna a quantidade de tentativas de sair da prisao
     * @return numero de tentativas de sair da prisao
     */
    public int getTentativasSairDaPrisao() {
        return tentativasSairDaPrisao;
    }
    /**
     * Seta a quantidade de tentativas de sair da prisao
     * @param tentativasSairDaPrisao
     */
    public void setTentativasSairDaPrisao(int tentativasSairDaPrisao) {
        this.tentativasSairDaPrisao = tentativasSairDaPrisao;
    }
    /**
     * Adiciona em uma unidade a quantidade de tentativas de sair da prisao
     */
    public void addTentativasSairDaPrisao() {
        this.tentativasSairDaPrisao++;
    }

    /**
     * Retorna o id do jogador
     * @return o id
     */
    public int getId() {
        return id;
    }

    public void removerComandoMortgage(){
        comandos.removerComandoMortgage();
    }

    /**
     * Adiciona dinheiro aa conta do jogador
     * @param dinheiro a ser adicionado
     */
    public void addDinheiro(int dinheiro) {
        this.dinheiro += dinheiro;
    }

    /**
     * Retira dinheiro da conta do jogador
     * @param dinheiro dinheiro a ser retirado
     */
    public void retirarDinheiro(int dinheiro) {
        this.addDinheiro(-dinheiro);
    }

    /**
     * Define um id para o jogador
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Instancia um novo jogador
     * @param Nome nome do jogador
     * @param CorPeao cor do peao
     * @param id id
     */
    public Jogador(String Nome, String CorPeao, int id) {
        this(Nome);
        this.setCorPeao(CorPeao);
        this.id = id;
    }

    /**
     * Instancia um novo jogador
     * @param Nome nome do jogador
     */
    public Jogador(String Nome) {
        this.Nome = Nome;
    }

    /**
     * Obtem a cor do peao do jogador
     * @return a cor do peao
     */
    public String getCorPeao() {
        return CorPeao;
    }

    /**
     * Obtem o dinheiro atual do jogador
     * @return dinheiro
     */
    public int getDinheiro() {
        return dinheiro;
    }

    /**
     * Seta um determinado valor em dinheiro para o jogador
     * @param dinheiro nova quantidade de dinheiro a ser definida
     */
    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    /**
     * Define a cor do peao do jogador
     * @param CorPeao a nova cor do peao
     */
    public void setCorPeao(String CorPeao) {
        this.CorPeao = CorPeao;
    }

    /**
     * Obtem o nome do jogador
     * @return o nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * Define um nome para o jogador
     * @param Nome o nome
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * Adiciona uma propriedade à lista de posses do jogador
     * @param nome o nome da propriedade
     */
    public void addPropriedade(String nome) {
        propriedades.add(nome);

    }

    /**
     * Obtem a lista de posses do Jogador
     * @return a lista de propriedades
     */
    public ArrayList getPropriedades() {
        return propriedades;
    }
    /**
     * Adiciona comando Pay na lista de comandos do jogador
     */
    public void adicionarComandoPay() {
        this.comandos.addComandoPay();
    }
    /**
     * Remove Comando Pay da lista de comandos do jogador
     */
    public void removerComandoPay() {
        this.comandos.removerComandoPay();
    }
    /**
     * Adiciona comando Build na lista de comandos do jogador
     */
    public void adicionarComandoBuild() {
        this.comandos.addComandoBuild();
    }

     /**
     * Adiciona comando Hipotecar na lista de comandos do jogador
     */
    public void adicionarComandoHipotecar() {
        this.comandos.addComandoMortgage();
    }


    public void removerComandoHipotecar() {
        this.comandos.removerComandoMortgage();
    }

     public void removerComandoDesipotecar() {
        this.comandos.removerComandoUnMortgage();
    }

     /**
     * Adiciona comando Hipotecar na lista de comandos do jogador
     */
    public void adicionarComandoDesipotecar() {
        this.comandos.addComandoUnMortgage();
    }

    /**
     * Adiciona comando Sell na lista de comandos do jogador
     */
    public void adicionarComandoSell() {
        this.comandos.addComandoSell();
    }
    /**
     * Remove comando Sell da lista de comandos do jogador
     */
    public void removerComandoSell() {
        this.comandos.removerComandoSell();
    }
    /**
     * Remove lista comando Build da lista de comandos do jogador
     */
    public void removerComandoBuild() {
        this.comandos.removerComandoBuild();
    }

    public void addComandoGiveUp(){
        comandos.addComandoGiveUp();
    }

    public void removeComandoGiveUp(){
        comandos.removerComandoGiveUp();
    }

    public void removeComandoRoll(){
        comandos.removerComandoRoll();
    }
    /**
     * Retorna Comandos do jogador
     * @return Lista de comandos
     */
    public List getComandos() {
        return this.comandos.getCmds();
    }

    public List retornaComandosNaOrdem(){
        return comandos.retornaComandosNaOrdem();
    }

    

    /**
     * Adquirir cartao de saida de prisao
     * @param tipoCartao
     */
    public void ganharCartaoSaidaDePrisao(String tipoCartao) {


        if (tipoCartao.equals("chest")) {
            this.CardChestSaidaDaPrisao = true;
        } else if (tipoCartao.equals("chance")) {
            this.CardChanceSaidaDaPrisao = true;

        }

    }
    /**
     * Gastar cartao de saida de prisao
     * @param tipoCartao
     * @throws Exception
     */
    public void gastarCartaoSaidaDePrisao(String tipoCartao) throws Exception {
        if (tipoCartao.equals("chance") && this.CardChanceSaidaDaPrisao == true) {

            this.CardChanceSaidaDaPrisao = false;
        } else if (tipoCartao.equals("chest") && this.CardChestSaidaDaPrisao == true) {

            this.CardChestSaidaDaPrisao = false;
        } else {
            throw new Exception("Player doesn't have this card to use");

        }
    }
    /**
     * Verifica se jogador tem cartao chance de saida de prisao
     * @return booleano
     */
    public boolean verificaSeTemCartaoChancePrisao() {
        if (this.CardChanceSaidaDaPrisao == true) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Verifica se jogador tem cartao chest de saida de prisao
     * @return
     */
    public boolean verificaSeTemCartaoChestPrisao() {
        if (this.CardChestSaidaDaPrisao == true) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Verifica se o jogador possui o grupo de propriedades referente ao parametro passado
     * @param idPropriedade
     * @return booleano
     */
    public boolean verificaSeTemGrupo(int idPropriedade) {
        if ((idPropriedade == 1 || idPropriedade == 3) && this.propriedades.contains("Mediterranean Avenue") && this.propriedades.contains("Baltic Avenue")) {
            return true;
        } else if ((idPropriedade == 6 || idPropriedade == 8 || idPropriedade == 9) && this.propriedades.contains("Oriental Avenue") && this.propriedades.contains("Vermont Avenue") && this.propriedades.contains("Connecticut Avenue")) {
            return true;
        } else if ((idPropriedade == 11 || idPropriedade == 13 || idPropriedade == 14) && this.propriedades.contains("St. Charles Place") && this.propriedades.contains("States Avenue") && this.propriedades.contains("Virginia Avenue")) {
            return true;
        } else if ((idPropriedade == 16 || idPropriedade == 18 || idPropriedade == 19) && this.propriedades.contains("St. James Place") && this.propriedades.contains("Tennessee Avenue") && this.propriedades.contains("New York Avenue")) {
            return true;
        } else if ((idPropriedade == 21 || idPropriedade == 23 || idPropriedade == 24) && this.propriedades.contains("Kentucky Avenue") && this.propriedades.contains("Indiana Avenue") && this.propriedades.contains("Illinois Avenue")) {
            return true;
        } else if ((idPropriedade == 26 || idPropriedade == 27 || idPropriedade == 29) && this.propriedades.contains("Atlantic Avenue") && this.propriedades.contains("Ventnor Avenue") && this.propriedades.contains("Marvin Gardens")) {
            return true;
        } else if ((idPropriedade == 31 || idPropriedade == 32 || idPropriedade == 34) && this.propriedades.contains("Pacific Avenue") && this.propriedades.contains("North Carolina Avenue") && this.propriedades.contains("Pennsylvania Avenue")) {
            return true;
        } else if ((idPropriedade == 37 || idPropriedade == 39) && this.propriedades.contains("Park Place") && this.propriedades.contains("Boardwalk")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean temPropriedades(){
        return this.getPropriedades().isEmpty() ? false : true;
    }

    public ArrayList<String> getPropriedadesDoJogador() {
        return propriedades;
    }

    public boolean ifRollAvaliable(){
        return comandos.isComandoRollIncluido();
    }

    public boolean isAvoidAvaliable(){
        return comandos.isComandoAvoidIncluido();
    }

    public void adicionarComandoAvoid(){
        comandos.addComandoAvoid();
    }

    public void removercomandoAvoid(){
        comandos.removerComandoAvoid();
    }
 
}
