/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import monopoly.cards.Card;
import monopoly.Jogador;
import monopoly.Jogo;
import monopoly.Tabuleiro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Facade das user stories
 * @author Marcus
 */
public class UserStoriesFacade {

    Jogo jogo = null;
    Tabuleiro tabuleiro = null;

    /**
     * Criacao de um jogo
     * @param num total de jogadores
     * @param playerNames nomes dos jogadores
     * @param tokenColors nomes das cores dos peoes dos jogadores
     * @throws Exception
     */
    public void createGame(int num, String playerNames, String tokenColors) throws Exception {

        String nomes_jogadores[] = playerNames.substring(1, playerNames.length() - 1).split(",");
        String cores_jogadores[] = tokenColors.substring(1, tokenColors.length() - 1).split(",");

        this.jogo = new Jogo(num, nomes_jogadores, cores_jogadores);
        this.jogo.StartJogo();
        this.tabuleiro = jogo.getTabuleiro();

    }


    /**
     * Consulta o total de jogadores
     * @return o total de jogadores
     */
    public int getNumberOfPlayers() {
        return jogo.getNumberOfPlayers();
    }

    /**
     * Executa um movimento considerando os valores dos dados
     * @param firstDieResult resultado do primeiro dado
     * @param secondDieResult resultado do segundo dado
     * @throws Exception
     */
    public void rollDice(int firstDieResult, int secondDieResult) throws Exception {
        this.jogo.processarJogada(firstDieResult, secondDieResult, false);

    }

    /**
     * Set a compra automatica
     * @param auto 
     */
    public void setAutomaticBuying(boolean auto) {
        this.jogo.definirCompraAutomatica();
    }

    /**
     * Obtem a cor do peao do jogador
     * @param playerName nome do jogador
     * @return retorna a cor do peao
     * @throws Exception
     */
    public String getPlayerToken(String playerName) throws Exception {

        return this.jogo.getPlayerToken(playerName);
    }

    /**
     * Obtem o dinheiro do jogador
     * @param playerName nome do jogador
     * @return o dinheiro
     * @throws Exception
     */
    public int getPlayerMoney(String playerName) throws Exception {
        return this.jogo.getPlayerMoney(playerName);
    }

    /**
     * Obtem a posicao do jogador
     * @param playerName nome do jogador
     * @return a posicao
     * @throws Exception
     */
    public int getPlayerPosition(String playerName) throws Exception {
        return this.jogo.getPlayerPosition(playerName);
    }

    /**
     * Obtem o nome do jogador atual
     * @return o nome do jogador
     */
    public String getCurrentPlayer() {

        List<Jogador> listaJogador = this.jogo.getListaJogadores();

        Jogador a = listaJogador.get(jogo.jogadorAtual());
        return a.getNome();
    }

    /**
     * Obtem as posses de um jogador
     * @param playerName nome do jogador
     * @return lista de posses do jogador
     * @throws Exception
     */
    public String getPlayerDeeds(String playerName) throws Exception {
        String propriedades = "";
        List<Jogador> listaJogador = this.jogo.getListaJogadores();

        for (int i = 0; i < listaJogador.size(); i++) {
            Jogador jogador = listaJogador.get(i);
            if (jogador.getNome().equals(playerName)) {
                ArrayList prop = jogador.getPropriedades();
                Iterator it = prop.iterator();
                while (it.hasNext()) {
                    propriedades = propriedades + it.next();
                    if (it.hasNext()) {
                        propriedades = propriedades + ",";
                        
                    }
                }
                return "{" + propriedades + "}";
            }
        }

        throw new Exception("Player doesn't exist");
    }

    /**
     * Obtem os comandos possiveis
     * @return lista de comandos
     */
    public String getCommands() {

        List a = this.jogo.getListaJogadores().get(this.jogo.jogadorAtual()).getComandos();
        Iterator<String> it = a.iterator();
        String b = "{";
        while (it.hasNext()) {
            b = b + it.next() + ",";
            if (!it.hasNext()) {
                b = b.substring(0, b.length() - 1);
                b = b + "}";
            }
        }

        return b;


    }

    /**
     * Finaliza um jogo
     * @throws Exception
     */
    public void quitGame() throws Exception {
        if (this.jogo != null) {
            this.jogo.QuitJogo();
        } else {
            throw new Exception("There's no game to quit");
        }

    }

    /**
     * Obtem o nome do lugar
     * @param placeID id do lugar
     * @return o nome do lugar
     * @throws Exception
     */
    public String getPlaceName(int placeID) throws Exception {
        return this.tabuleiro.getPlaceName(placeID);
    }

    /**
     * Obtem o grupo ao qual um lugar pertence
     * @param placeID o id do lugar
     * @return o nome do grupo
     * @throws Exception
     */
    public String getPlaceGroup(int placeID) throws Exception {
        return this.tabuleiro.getLugarGrupo(placeID);
    }

    /**
     * Obtem o dono de um lugar
     * @param placeID id do lugar
     * @return o nome do dono
     * @throws Exception
     */
    public String getPlaceOwner(int placeID) throws Exception {

        return jogo.getOwnerPlace(placeID);
    }

    /**
     * Obtem o preco de um lugar
     * @param placeID id do lugar
     * @return o preco
     * @throws Exception
     */
    public int getPlacePrice(int placeID) throws Exception {
        return this.tabuleiro.getLugarPrecoCompra(placeID);
    }

    /**
     * Obtem o valor de aluguel de uma propriedade
     * @param placeID id do lugar
     * @return o preco
     * @throws Exception
     */
    public int getPropertyRent(int placeID) throws Exception {
        return this.tabuleiro.getLugarPrecoAluguel(placeID);
    }

    /**
     * Verifica se o jogo acabou (apenas um jogador restante)
     * @return true se o jogo acabou, false caso contrario
     */
    public boolean gameIsOver() {
        return this.jogo.isGameFinished();
    }

    /**
     * Realiza uma compra
     * @throws Exception
     */
    public void buy() throws Exception {
        this.jogo.buy();
    }

    /**
     * Altera ponteiro de pilha de cartoes Chance
     * @param cardId
     * @throws Exception
     */
    public void forceNextChanceCard(int cardId) throws Exception {
        // this.jogo.getChance(cardId);
        this.jogo.setIndiceChance(cardId);

    }
    /**
     * Altera ponteiro de pilha de cartoes Chest
     * @param cardId
     * @throws Exception
     */
    public void forceNextChestCard(int cardId) throws Exception {
        //this.jogo.getChest(cardId);
        this.jogo.setIndiceChest(cardId);
    }
    /**
     * Retorna numero do cartao Chance atual
     * @return o id do cartao
     * @throws Exception
     */
    public int getCurrentChanceCardNumber() throws Exception {
        Card cardChance = this.jogo.getCurrentChance();
        return cardChance.getNumberCard();
    }
    /**
     * Retorna a descricao do cartao Chance atual
     * @return a descricao do cartao
     * @throws Exception
     */
    public String getCurrentChanceCardDescription() throws Exception {
        Card cardChance = this.jogo.getCurrentChance();
        return cardChance.getDescricao();
    }
    /**
     * Retorna numero do cartao Chest atual
     * @return o id do cartao
     * @throws Exception
     */
    public int getCurrentChestCardNumber() throws Exception {
        Card cardChest = this.jogo.getCurrentChest();
        return cardChest.getNumberCard();
    }
     /**
     * Retorna a descricao do cartao Chest atual
     * @return a descricao do cartao
     * @throws Exception
     */
    public String getCurrentChestCardDescription() throws Exception {
        Card cardChest = this.jogo.getCurrentChest();
        return cardChest.getDescricao();
    }
    /**
     * Ativa cartoes Chance
     * @param shuffle
     */
    public void activateChancePlaces(boolean status) {
        if (status == true) {
            this.jogo.unsetChanceCardShuffle();
            
        } else {
            this.jogo.setChanceCardShuffle();

            
        }
        this.jogo.activeCards();
    }
    /**
     * Ativa cartoes Chest
     * @param shuffle
     */
    public void activateChestPlaces(boolean status) {
        if (status == true) {
            this.jogo.unsetChestCardShuffle();
            
        } else {
            this.jogo.setChestCardShuffle();

            
        }
        this.jogo.activeCards();
    }
    /**
     * Ativa prisao
     */
    public void activateJail() {
        this.jogo.ativarPrisao();
    }
    /**
     * verifica se jogador esta na prisao
     * @param nome do jogador
     * @return
     */
    public boolean playerIsOnJail(String nome) {
        return this.jogo.JogadorEstaPreso(nome);
    }
    /**
     * Usar cartao
     * @param tipoCartao
     * @throws Exception
     */
    public void useCard(String tipoCartao) throws Exception {
        this.jogo.usarCartao(tipoCartao);


    }
    /**
     * Pagar saida de prisao
     * @throws Exception
     */
    public void pay() throws Exception {
        //WTF?????
        this.jogo.processarJogada(2, 1, true);

    }
    /**
     * Ativar regra jogada dupla
     */
    public void activateDoublesRule() {
        this.jogo.activeRegraJogadaDupla();
    }
    /**
     * Ativar Servicos Publicos
     */
    public void activateUtilityPlaces() {
        this.jogo.ativarServicosPublicos();
    }
    /**
     * Ativar compra de casas e hoteis
     */
    public void activateBuild() {
        this.jogo.ativarBuild();
    }
    /**
     * Comprar casas e hoteis
     * @param propertyID
     * @throws Exception
     */
    public void build(int propertyID) throws Exception {
        this.jogo.comprarCasasEHoteis(propertyID);
    }
    /**
     * Ganhar dinheiro extra
     * @param playerName
     * @param cash
     * @throws Exception
     */
    public void giveCashToPlayer(String playerName, int cash) throws Exception {
        this.jogo.addPlayerMoney(playerName, cash);
    }
    /**
     * Ativar venda de casas e hoteis
     */
    public void activateSell() {
        this.jogo.AtivarVenda();
    }
    /**
     * Vender casas ou hoteis
     * @param propertyID
     * @throws Exception
     */
    public void sell(int propertyID) throws Exception {
        this.jogo.VenderCasasOuHoteis(propertyID);
    }
    public void mortgage (int placeID) throws Exception{
       this.jogo.hipotecarPropriedade(placeID);
    }
    
    public void activateMortgage(){
         this.jogo.ativarHipoteca();
    }

    public boolean isMortgaged(int placeID) throws Exception{
       return this.jogo.propriedadeEstaHipotecada(placeID);
    }

    public void activateUnMortgage(){
        jogo.ativarDesipoteca();
    }

    public void unmortgage (int placeID) throws Exception{
        jogo.desipotecarPropriedade(placeID);
    }


    //expecterror "Place doesn't exist" giveDeedToPlayer playerName="player1" placeID=0

    public void giveDeedToPlayer(String playerName, int placeId) throws Exception{
        jogo.giveDeedToPlayer(playerName, placeId);
    }

    public void activateAvoidingBankruptcy(){

    }

    public void giveUp(){
        
    }


}
