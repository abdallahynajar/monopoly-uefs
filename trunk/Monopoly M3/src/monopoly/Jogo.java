package monopoly;

import monopoly.cards.Card;
import monopoly.cards.CardsGame;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * A classe que gerencia todas as operacoes do jogo, alem de saber de quase tudo.
 * @author Marcus
 */
public class Jogo {

    private boolean RegraJogadaDupla = false;
    private int numeroDeJogadores = 0;
    private boolean cards = false;
    private boolean ChanceCardShuffle = false;
    private boolean ChestCardShuffle = false;
    private boolean prisao = false;
    private boolean repete = false;
    private boolean pagouPrisaoRecentemente = false;
    private int duplasAcumuladas = 0;
    private boolean cardChancePrisaoEmPosse = false;
    private boolean cardChestPrisaoEmPosse = false;
    private boolean publicServices = false;
    private boolean EletricCompanyComprada = false;
    private boolean WaterWorksComprada = false;
    private boolean build = false;
    private boolean sell = false;
    private boolean hipotecaAtiva = false;
    private boolean desipotecarAtivo = false;

    public void AtivarVenda() {
        this.sell = true;
    }
    /**
     * Lista dos jogadores participantes do jogo (nao-falidos)
     */
    private List<Jogador> listaJogadores = new ArrayList();
    /**
     * Lista dos jogadores falidos
     */
    private List<String> listaJogadoresFalidos = new ArrayList();
    /**
     * Cores permitidas para os peoes dos jogadores
     */
    static String[] coresPermitidas = {"black", "white", "red", "green", "blue", "orange", "yellow", "pink", "brown"};
    /**
     * O status do jogo (terminado?)
     */
    private boolean status = false;
    /**
     * A vez
     */
    private int vez = 0;
    /**
     * A posicao que cada um dos jogadores ocupa
     */
    private int posicoes[] = {40, 40, 40, 40, 40, 40, 40, 40};
    /**
     * Os donos das propriedades
     */
    private Hashtable Donos = new Hashtable();
    /**
     * O tabuleiro do jogo
     */
    private Tabuleiro tabuleiro = new Tabuleiro();
    /**
     * Lista de comandos
     */
    Comandos cmds = new Comandos();
    /**
     * definicao da compra automatica
     */
    private boolean compra_automatica = false;
    /**
     * Os donos das ferrovias
     */
    int[] DonosFerrovias = {0, 0, 0, 0, 0, 0, 0, 0};
    /**
     * Ponteiro para cartoes Chance
     */
    private int indiceChance = 1;
    /**
     * Ponteiro para cartoes Chest
     */
    private int indiceChest = 1;
    /**
     * Identifica se a vez de um jogador ja terminou ou nao
     */
    private boolean terminouVez = true;
    /**
     * Instancia um jogo
     * @param quantidade quantidade de jogadores
     * @param nomes_jogadores nomes do jogadores
     * @param cores_jogadores cores dos peoes dos jogadores
     * @throws Exception
     */
    private CardsGame cardsGame = new CardsGame();
    /**
     * Lista de jogadores na prisao
     */
    private List<String> listaJogadoresNaPrisao = new ArrayList();
    /**
     * Objeto banco
     */
    private Banco banco = new Banco();

    /**
     * Construtor do Jogo
     * @param quantidade
     * @param nomes_jogadores
     * @param cores_jogadores
     * @throws Exception
     */
    public Jogo(int quantidade, String[] nomes_jogadores, String[] cores_jogadores) throws Exception {


        //só separei o tratamento de erros
        numeroDeJogadores = quantidade;
        cardsGame.initCardsCofresComunitarios();
        cardsGame.initCardsSorteReves();

        Card[] Chance = cardsGame.getSorteReves();
        Card[] Chest = cardsGame.getCofresComunitarios();

        listaJogadoresFalidos.clear();
        listaJogadores.clear();
        this.tratarErrosIniciais(quantidade, nomes_jogadores, cores_jogadores);
        resetInitDonos();

        for (int i = 0; i < nomes_jogadores.length; i++) {
            this.listaJogadores.add(new Jogador(nomes_jogadores[i], cores_jogadores[i], i));
        }

        status = true;
        terminouVez = true;
        compra_automatica = false;
        ChanceCardShuffle = false;
        ChestCardShuffle = false;
        pagouPrisaoRecentemente = false;
        this.RegraJogadaDupla = false;
        this.vez = 0;
        this.publicServices = false;

    }

    /**
     * ativa cartoes chance aleatorios
     */
    public void setChanceCardShuffle() {
        ChanceCardShuffle = true;
    }

    /**
     * Desativa cartoes chance aleatorios
     */
    public void unsetChanceCardShuffle() {
        ChanceCardShuffle = false;
    }

    /**
     * ativa cartoes chest aleatorios
     */
    public void setChestCardShuffle() {
        ChanceCardShuffle = true;
    }

    /**
     * desativa cartoes chest aleatorios
     */
    public void unsetChestCardShuffle() {
        ChanceCardShuffle = false;
    }

    /**
     * ativa regra jogada dupla
     */
    public void activeRegraJogadaDupla() {
        this.RegraJogadaDupla = true;
    }

    /**
     * desativa regra jogada dupla
     */
    public void desactiveRegraJogadaDupla() {
        this.RegraJogadaDupla = true;
    }

    /**
     * ativa cartoes
     */
    public void activeCards() {
        cards = true;
    }

    /**
     * desativa cartoes
     */
    public void desativeCards() {
        cards = false;
    }

    /**
     * Seta ponteiro dos cartoes Chance
     * @param indiceChance
     * @throws Exception
     */
    public void setIndiceChance(int indiceChance) throws Exception {
        if (indiceChance > 16 || indiceChance <= 0) {
            throw new Exception("Card doesn't exist");
        } else if (this.cardChancePrisaoEmPosse == true && indiceChance == 11) {
            throw new Exception("This card is already possessed by a player");
        } else {
            this.indiceChance = indiceChance;
        }
    }

    /**
     * Seta ponteiro dos cartoes Chest
     * @param indiceChest
     * @throws Exception
     */
    public void setIndiceChest(int indiceChest) throws Exception {
        if (indiceChest > 16 || indiceChest <= 0) {
            throw new Exception("Card doesn't exist");
        } else if (this.cardChestPrisaoEmPosse == true && indiceChest == 6) {
            throw new Exception("This card is already possessed by a player");
        } else {
            this.indiceChest = indiceChest;
        }
    }

    /**
     * Ativa prisao
     */
    public void ativarPrisao() {
        this.prisao = true;
    }

    /**
     * Retorna Cartao Chance Atual
     * @return o cartao
     * @throws Exception
     */
    public Card getCurrentChance() throws Exception {
        return cardsGame.getCardSorteReves(indiceChance);
    }

    /**
     * Retorna Cartao Chest Atual
     * @return o cartao
     * @throws Exception
     */
    public Card getCurrentChest() throws Exception {
        return cardsGame.getCardCofresComunitarios(indiceChest);
    }

    /**
     * Debug para mostrar as posicoes no console
     */
    public void showPosicoes() {
        this.print("\n");
        for (int i = 0; i < listaJogadores.size(); i++) {
            System.out.print(posicoes[i] + "\t");
        }
    }

    /**
     * Obtem uma lista dos jogadores 
     * @return
     */
    public List<Jogador> getListaJogadores() {
        terminarAVez();
        return this.listaJogadores;
    }

    /**
     * Define os donos-padrao das propriedades
     */
    public void resetInitDonos() {
        Donos.clear();
        for (int i = 1; i <= 40; i++) {
            Donos.put(i, "bank");
        }
        Donos.put(2, "noOwner");
        Donos.put(4, "Income Tax");
        Donos.put(7, "noOwner");
        Donos.put(10, "noOwner");
        Donos.put(17, "noOwner");
        Donos.put(20, "noOwner");
        Donos.put(22, "noOwner");
        Donos.put(30, "noOwner");
        Donos.put(33, "noOwner");
        Donos.put(36, "noOwner");
        Donos.put(38, "Luxury Tax");
        Donos.put(40, "noOwner");

    }

    /**
     * Checa se uma posicao esta disponivel para compra (o banco e o dono)
     * @param posicao a posicao do lugar
     * @return true se a posicao esta disponivel, falso caso contrario
     */
    public boolean posicaoCompravel(int posicao) {
        // System.out.println("posicao" + posicao);
        String dono = (String) this.Donos.get(posicao);
        // System.out.println("DONO"+ dono);
        if (dono.equals("bank")) {
            if (this.publicServices == false && posicao != 12 && posicao != 28) {
                return true;
            } else if (this.publicServices == true && (posicao == 12 || posicao == 28)) {
                return true;
            } else if (this.publicServices == false && (posicao == 12 || posicao == 28)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Obtem a cor do peao de um jogador
     * @param playerName o nome do jogador
     * @return o peao do jogador de nome playerName
     * @throws Exception
     */
    public String getPlayerToken(String playerName) throws Exception {
        return this.getJogadorByName(playerName).getCorPeao();
    }

    /**
     * Obtem o dinheiro de um jogador
     * @param playerName o nome do jogador
     * @return o dinheiro do jogador de nome playerName
     * @throws Exception
     */
    public int getPlayerMoney(String playerName) throws Exception {
        return this.getJogadorByName(playerName).getDinheiro();
    }

    /**
     * Adiciona dinheiro ao jogador
     * @param playerName
     * @param cash
     * @throws Exception
     */
    public void addPlayerMoney(String playerName, int cash) throws Exception {
        this.getJogadorByName(playerName).addDinheiro(cash);
    }

    /**
     * Obtem a posicao de um jogador
     * @param playerName o nome do jogador
     * @return a posicao do jogador de nome playerName
     * @throws Exception
     */
    public int getPlayerPosition(String playerName) throws Exception {

        if (listaJogadoresFalidos.contains(playerName)) {
            throw new Exception("Player no longer in the game");
        }

        int Id = this.getJogadorByName(playerName).getId();
        return posicoes[Id];
    }

    private void verificaHipotecasDoJogadorAtual() {
        Jogador jogadorAtual =this.listaJogadores.get(jogadorAtual());
        Lugar lugar;
        boolean temHipoteca = false;
        boolean temPropriedadesSemHipoteca =  false;
        for (String s : jogadorAtual.getPropriedadesDoJogador()) {
            lugar  = tabuleiro.getLugarPeloNome(s);
            if(lugar.estaHipotecada()){
                temHipoteca = true;
            }else{
                temPropriedadesSemHipoteca = true;
            }
        }
        if (temHipoteca) {
            jogadorAtual.adicionarComandoDesipotecar();
        }else{
            jogadorAtual.removerComandoDesipotecar();
        }
        if(temPropriedadesSemHipoteca){
            jogadorAtual.adicionarComandoHipotecar();
        }else{
            jogadorAtual.removerComandoHipotecar();
        }
    }


    /**
     * Obtem um jogador atraves de seu nome
     * @param nomeJogador nome do jogador
     * @return Jogador de nome nomeJogador
     * @throws Exception
     */
    private Jogador getJogadorByName(String nomeJogador) throws Exception {
        for (int i = 0; i < this.listaJogadores.size(); i++) {
            Jogador j = this.listaJogadores.get(i);

            if (j.getNome().equals(nomeJogador)) {
                return j;
            }
        }

        throw new Exception("Player doesn't exist");
    }

    /**
     * Inicia uma nova vez (jogada);
     */
    private void iniciarNovaVez() {
        this.terminouVez = false;
    }

    /**
     * Faz uma serie de verificacoes de integridade de inicializacao do jogo
     * @param quantidade quantidade de jogadores
     * @param nomes_jogadores nomes dos jogadores
     * @param cores_jogadores cores dos peoes dos jogadores
     * @throws Exception
     */
    private void tratarErrosIniciais(int quantidade, String[] nomes_jogadores, String[] cores_jogadores) throws Exception {
        if ((quantidade == 1) || (quantidade > 8)) {
            throw new Exception("Invalid number of players");
        }


        if (this.hasNomeInvalido(nomes_jogadores)) {
            throw new Exception("Invalid player name");
        }


        if (nomes_jogadores.length < quantidade) {
            throw new Exception("Too few player names");
        }

        if (nomes_jogadores.length > quantidade) {
            throw new Exception("Too many player names");
        }

        if (cores_jogadores.length < nomes_jogadores.length) {
            throw new Exception("Too few token colors");
        }

        if (cores_jogadores.length > nomes_jogadores.length) {
            throw new Exception("Too many token colors");
        }



        if (this.hasNomeRepetido(nomes_jogadores)) {
            throw new Exception("There mustn't be repeated player names");
        }

        if (this.hasNomeRepetido(cores_jogadores)) {
            throw new Exception("There mustn't be repeated token colors");
        }


        boolean cor_valida = true;
        for (int i = 0; i < cores_jogadores.length && cor_valida; i++) {
            if (!this.isCorPermitida(cores_jogadores[i])) {
                cor_valida = false;
            }
        }

        if (!cor_valida) {
            throw new Exception("Invalid token color");
        }

    }

    /**
     * Verifica se uma cor é permitida
     * @param cor o nome da cor
     * @return a posiçã
     */
    private boolean isCorPermitida(String cor) {

        int pos = -1;
        for (int i = 0; i < Jogo.coresPermitidas.length && pos == -1; i++) {
            if (cor.equals(Jogo.coresPermitidas[i])) {
                pos = i;
            }
        }

        return (pos != -1);
    }

    /**
     * Checa se uma lista de nomes tem algum nome repetido
     * @param listaNomes lista de nomes
     * @return true se ha algum nome repetido, false caso contrario
     */
    private boolean hasNomeRepetido(String[] listaNomes) {
        for (int i = 0; i < listaNomes.length; i++) {
            for (int j = 0; j < listaNomes.length; j++) {
                if ((i != j) && (listaNomes[i].equals(listaNomes[j]))) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checa se a lista tem algum nome de jogador invalido
     * @param n a lista de nomes de jogadores
     * @return true se tem algum nome invalido, false caso contrario
     * @throws Exception
     */
    private boolean hasNomeInvalido(String[] n) throws Exception {
        boolean invalido = false;
        for (int i = 0; i < n.length; i++) {
            if (n[i].equals("bank")) {
                invalido = true;
            }
        }
        return invalido;
    }

    /**
     * Inicia um jogo
     */
    public void StartJogo() {
    }

    /**
     * Finaliza um jogo
     * @throws Exception
     */
    public void QuitJogo() throws Exception {
        if (status == false) {
            throw new Exception("There's no game to quit");
        }


    }

    /**
     * Checa se o jogo acabou (apenas um jogador restante)
     * @return true se o jogo acabou, false caso contrario
     */
    public boolean isGameFinished() {
        if (listaJogadores.size() - listaJogadoresFalidos.size() == 1) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Obtem o numero de jogadores nao-falidos
     * @return o numero de jogadores nao-falidos
     */
    public int getNumberOfPlayers() {
        return listaJogadores.size() - listaJogadoresFalidos.size();
    }

    /**
     * Obtem o dono de um lugar
     * @param idPlace o id do lugar
     * @return o nome do dono
     * @throws Exception
     */
    public String getOwnerPlace(int idPlace) throws Exception {
        if (idPlace > 40 || idPlace < 1) {

            throw new Exception("Place doesn't exist");
        } else {
            String dono = (String) Donos.get(idPlace);
            if (dono.equals("noOwner") || dono.equals("Luxury Tax") || dono.equals("Income Tax")) {
                throw new Exception("This place can't be owned");
            } else {
                return (String) Donos.get(idPlace);
            }
        }
    }

    /**
     * Avanca a vez para a jogada de um jogador nao-falido
     */
    public void PrepareNextJogada() {
        if (vez == listaJogadores.size() - 1) {
            vez = 0;

        } else {
            vez++;
        }
    }

    /**
     * Obtem a vez atual
     * @return a vez
     */
    public int jogadorAtual() {
        return vez;
    }

    /**
     * Liga a compra automatica
     */
    public void setCompraAutomatica() {
        this.compra_automatica = true;
    }

    /**
     * Desliga a compra automatica
     */
    public void unsetCompraAutomatica() {
        this.compra_automatica = false;
    }

    /**
     * Realiza o movimento de um jogador, junto com as devidas consequencias
     * (pagar aluguel, ferrovia etc)
     * @param resultadoDado1 o resultado do dado 1
     * @param resultadoDado2 o resultado do dado 2
     * @throws Exception
     */
    public void processarJogada(int resultadoDado1, int resultadoDado2, boolean PagamentoPrisao) throws Exception {


        if ((isResultadoDadoValido(resultadoDado1)) && (isResultadoDadoValido(resultadoDado2))) {


            if (!this.jogadorTerminouAVez() == true) {
                this.terminarAVez();// Prepara proxima jogada e coloca terminou vez para true

            }
            if (resultadoDado1 == resultadoDado2 && this.RegraJogadaDupla == true) {
                this.repete = true;
                this.duplasAcumuladas++;
                print("Repete foi ativado");
            } else if (resultadoDado1 != resultadoDado2 && this.RegraJogadaDupla == true) {
                this.duplasAcumuladas = 0;
                this.repete = false;
                print("Repete foi desativado");
            }


            if (this.duplasAcumuladas == 3 && this.RegraJogadaDupla == true) {
                adicionaNaPrisao(listaJogadores.get(jogadorAtual()));
                this.DeslocarJogador(jogadorAtual(), 10);
                this.duplasAcumuladas = 0;
                while (listaJogadoresNaPrisao.contains(listaJogadores.get(jogadorAtual()).getNome())) {
                    PrepareNextJogada();
                }
            } else if (PagamentoPrisao == true) {
                this.pagarSaidaDaPrisao();
                pagouPrisaoRecentemente = true;
                this.repete = false;
            } else if (PagamentoPrisao == false) {
                if (this.repete == false) {
                    this.terminarAVez();
                    this.iniciarNovaVez();//coloca terminouVez para false
                }
                this.moverJogadorDaVez(resultadoDado1, resultadoDado2);
                this.repete = false;
            }


            this.print("Jogador " + this.jogadorAtual());
            this.print("\tEstá em " + this.posicoes[this.jogadorAtual()]);
            this.print("\tvai andar " + (resultadoDado1 + resultadoDado2) + " casas.");



        }


    }

    /**
     * Realiza o pagamento pelo uso de uma ferrovia
     * @param credor id do jogador a receber o pagamento
     * @param devedor id do jogador a pagar
     * @param valor valor do pagamento
     * @param NomePopriedade nome da propriedade
     */
    public void pagarFerrovia(int credor, int devedor, int valor, String NomePopriedade) {

        Jogador JogadorDevedor = listaJogadores.get(devedor);
        Jogador JogadorCredor = listaJogadores.get(credor);
        if ((NomePopriedade.equals("Reading Railroad")) ||
                (NomePopriedade.equals("Pennsylvania Railroad")) ||
                (NomePopriedade.equals("B & O Railroad")) ||
                (NomePopriedade.equals("Short Line Railroad"))) {
            int quantidadeFerrovias = DonosFerrovias[credor];
            int divida = quantidadeFerrovias * valor;
            this.print("Credor tem " + quantidadeFerrovias);
            this.print("Divida eh " + divida);

            if (listaJogadores.get(devedor).getDinheiro() >= divida) {
                JogadorDevedor.retirarDinheiro(divida);
                JogadorCredor.addDinheiro(divida);
                this.print("aqui");

            } else {
                int DinheiroRestante = listaJogadores.get(devedor).getDinheiro();
                JogadorDevedor.retirarDinheiro(DinheiroRestante);

                JogadorCredor.addDinheiro(DinheiroRestante);
                this.removePlayer(devedor);

            }

        }
    }

    /**
     * Realiza a cobranca de aluguel
     * @param credor id do jogador a receber o aluguel
     * @param devedor id do jogador a pagar o aluguel
     * @param valor o valor do aluguel
     * @param NomePopriedade o nome da propriedade
     */
    public void pagarAluguel(int credor, int devedor, int valor, String NomePopriedade) {

        Jogador JogadorDevedor = listaJogadores.get(devedor);
        Jogador JogadorCredor = listaJogadores.get(credor);


        if (listaJogadores.get(devedor).getDinheiro() >= valor) {
            JogadorDevedor.retirarDinheiro(valor);
            JogadorCredor.addDinheiro(valor);

        } else {
            int DinheiroRestante = listaJogadores.get(devedor).getDinheiro();
            JogadorDevedor.retirarDinheiro(DinheiroRestante);
            JogadorCredor.addDinheiro(DinheiroRestante);
            this.removePlayer(devedor);

        }


    }

    /**
     * Marca a vez (jogada) do jogador como terminada
     */
    public void terminarAVez() {


        if (!this.jogadorTerminouAVez() && this.repete == false) {
            do {
                this.PrepareNextJogada();
                this.terminouVez = true;

            } while (this.listaJogadoresFalidos.contains(listaJogadores.get(vez).getNome()));

        }


        print("\t AGora vez eh " + this.vez);


    }

    /**
     * Checa se a vez (jogada) do jogador foi concluida (com uma compra, pagamento de imposto etc)
     * @return
     */
    private boolean jogadorTerminouAVez() {
        return this.terminouVez;
    }

    /**
     * Checa se o resultado do dado e valido
     * @param resultadoDado o resultado do dado
     * @return  true se o resultado e valido, falso caso contrario
     * @throws Exception
     */
    private boolean isResultadoDadoValido(int resultadoDado) throws Exception {
        if ((resultadoDado > 6) || (resultadoDado < 1)) {
            throw new Exception("Invalid die result");
        }
        return true;
    }

    /**
     * Seta a compra automatica para true
     */
    public void definirCompraAutomatica() {
        this.compra_automatica = true;
    }

    /**
     * Verifica se o jogador deve receber a bonificacao por passar pela casa 40
     * @param jogador
     * @param valorDados
     * @return
     */
    private boolean completouVolta(int jogador, int valorDados) {

        if ((this.posicoes[jogador] + valorDados) >= 40 && this.posicoes[jogador] != 40) {
            this.listaJogadores.get(jogador).addDinheiro(200);
            this.print("\tGanha $200 por passar pela casa 40.");
            return true;
        }
        return false;

    }

    /**
     * Move um jogador para uma posicao do tabuleiro
     * @param jogador o id do jogador
     * @param valorDados o valor dos dados
     */
    private void moverJogadorAPosicao(int jogador, int valorDados, boolean iguais) {
        int tentativasDeSairDaPrisao = this.listaJogadores.get(jogadorAtual()).getTentativasSairDaPrisao();
        //Analisando se o cara esta preso, se a prisao ta ativada e se o cara tentou um numero de vezes menos que tres
        //ou se a funcao prisao esta falsa
        //ou se o jogador nao esta preso
        if ((JogadorEstaPreso(this.listaJogadores.get(jogadorAtual()).getNome()) && iguais && this.prisao == true && tentativasDeSairDaPrisao <= 2) || this.prisao == false || (!JogadorEstaPreso(this.listaJogadores.get(jogadorAtual()).getNome()) && this.prisao == true)) {
            if (JogadorEstaPreso(this.listaJogadores.get(jogadorAtual()).getNome()) && iguais && this.prisao == true && tentativasDeSairDaPrisao < 2);
            {
                this.sairdaPrisao(this.listaJogadores.get(jogadorAtual()));
                this.listaJogadores.get(jogadorAtual()).setTentativasSairDaPrisao(0);
            }
            this.posicoes[jogador] = (this.posicoes[jogador] + valorDados);
            if (posicoes[jogador] > 40) {
                posicoes[jogador] = posicoes[jogador] - 40;
            }
        }

        //analisando se o jogador esta preso e lanca numeros diferentes nos dados
        if (JogadorEstaPreso(this.listaJogadores.get(jogadorAtual()).getNome()) && !iguais && this.prisao == true) {
            //analisa se estourou as tentativas
            //se estourou
            if (this.listaJogadores.get(jogadorAtual()).getTentativasSairDaPrisao() == 2) {
                this.sairdaPrisao(this.listaJogadores.get(jogadorAtual()));
                this.listaJogadores.get(jogadorAtual()).retirarDinheiro(50);
                this.listaJogadores.get(jogadorAtual()).setTentativasSairDaPrisao(0);
                this.posicoes[jogador] = (this.posicoes[jogador] + valorDados);
                if (posicoes[jogador] > 40) {
                    posicoes[jogador] = posicoes[jogador] - 40;
                }

            } //se nao estourou
            else if (this.listaJogadores.get(jogadorAtual()).getTentativasSairDaPrisao() < 2) {
                this.listaJogadores.get(jogadorAtual()).addTentativasSairDaPrisao();
            }


        }


    }

    /**
     * Desloca o jogador diretamente da posicao corrente a outra
     * @param jogador
     * @param novaPosicao
     */
    private void DeslocarJogador(int jogador, int novaPosicao) {
        this.posicoes[jogador] = novaPosicao;
    }

    /**
     * Tenta compra uma propriedade
     * @param jogador o jogador
     * @param lugar a propriedade a ser comprada
     * @return true se a compra foi feita, false caso contrario
     * @throws Exception
     */
    private boolean realizarCompra(int jogador, Lugar lugar) throws Exception {


        if (this.posicaoCompravel(this.posicoes[jogador])) {
            this.print("\tO lugar " + lugar.getNome() + " está à venda!");
            this.print("\tAtual dinheiro:" + this.listaJogadores.get(jogador).getDinheiro());
            this.print("\tTenta realizar a compra");
            if (this.efetuarCompra(this.posicoes[jogador], this.listaJogadores.get(jogador))) {
                this.print("\tJogador compra " + lugar.getNome());
                return true;

            } else {
                this.print("\tCompra não realizada!");
                return false;
            }

        }

        return false;
    }

    /**
     * Checa se a posicao e uma ferrovia
     * @param posicao a posicao
     * @return
     */
    private boolean isPosicaoFerrovia(int posicao) {
        return (posicao == 5 || posicao == 15 || posicao == 25 || posicao == 35);
    }

    /**
     * Realiza o pagamento de um imposto
     * @param nomeImposto o nome do imposto
     * @param valorImposto o valor do imposto
     * @param jogador o id do jogador
     * @return true se foi necessario pagar o imposto, false caso contrario
     */
    private boolean pagarImposto(String nomeImposto, int valorImposto, int jogador) {
        if (Donos.get(this.posicoes[jogador]).equals(nomeImposto)) {
            this.print("\tPagando imposto " + nomeImposto);
            this.print("\tValor do imposto " + valorImposto);
            if (listaJogadores.get(jogador).getDinheiro() >= valorImposto) {
                listaJogadores.get(jogador).retirarDinheiro(valorImposto);
            } else {
                int DinheiroRestante = listaJogadores.get(jogador).getDinheiro();
                listaJogadores.get(jogador).retirarDinheiro(DinheiroRestante);
                this.removePlayer(jogador);

            }
            return true;
        }
        return false;
    }

    /**
     * Paga impostos do jogador, se for necessario
     * @param jogador o id do jogador
     * @return booleano
     */
    private boolean pagarEventuaisTaxas(int jogador) {
        boolean pagouIncomeTax = this.pagarImposto("Income Tax", 200, jogador);
        boolean pagouLuxuryTax = this.pagarImposto("Luxury Tax", 75, jogador);

        if (pagouIncomeTax || pagouLuxuryTax) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checa se nome informado e de um jogador
     * @param nome o nome
     * @return true se corresponde a um jogador, false caso contrario
     */
    private boolean isUmJogador(String nome) {
        for (int i = 0; i < listaJogadores.size(); i++) {
            Jogador jogador = listaJogadores.get(i);

            if (jogador.getNome().equals(nome)) {
                return true;
            }

        }

        return false;
    }

    /**
     * Realiza o processamento do cartao chance
     * @throws Exception
     */
    public void realizaProcessamentoCartaoChance() throws Exception {
        if (indiceChance == 1) {
            DeslocarJogador(jogadorAtual(), 40);
            this.listaJogadores.get(jogadorAtual()).addDinheiro(200);

        } else if (indiceChance == 2) {
            DeslocarJogador(jogadorAtual(), 24);
        } else if (indiceChance == 3) {
            if (this.posicoes[this.jogadorAtual()] == 40 || this.posicoes[this.jogadorAtual()] > 11) {
                this.listaJogadores.get(jogadorAtual()).addDinheiro(200);
            }
            DeslocarJogador(jogadorAtual(), 11);


        } else if (indiceChance == 4) {
            if (this.posicoes[this.jogadorAtual()] < 12 || this.posicoes[this.jogadorAtual()] > 28) {
                DeslocarJogador(jogadorAtual(), 12);
            } else {
                DeslocarJogador(jogadorAtual(), 28);
            }
        } else if (indiceChance == 5 || indiceChance == 16) {
            if (this.posicoes[jogadorAtual()] < 5 || this.posicoes[jogadorAtual()] > 35) {
                DeslocarJogador(jogadorAtual(), 5);
            } else if (this.posicoes[jogadorAtual()] < 15) {
                DeslocarJogador(jogadorAtual(), 15);
            } else if (this.posicoes[jogadorAtual()] < 25) {
                DeslocarJogador(jogadorAtual(), 25);
            } else if (this.posicoes[jogadorAtual()] < 35) {
                DeslocarJogador(jogadorAtual(), 35);
            }

            int jogador = this.jogadorAtual();
            Lugar lugar = this.tabuleiro.get(this.posicoes[jogador] - 1);
            String nomeDono = (String) Donos.get(this.posicoes[jogador]);
            if (this.isUmJogador(nomeDono)) {
                Jogador possivelDono = this.getJogadorByName(nomeDono);
                if (this.isPosicaoFerrovia(this.posicoes[jogador])) {
                    this.print("\tO dono eh " + possivelDono.getNome());
                }
                this.pagarFerrovia(possivelDono.getId(), jogador, 50, lugar.getNome());
            }

        } else if (indiceChance == 6) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(50);
        } else if (indiceChance == 7) {
            DeslocarJogador(jogadorAtual(), this.posicoes[jogadorAtual()] - 3);
            this.pagarEventuaisTaxas(jogadorAtual());
        } else if (indiceChance == 8) {
            DeslocarJogador(jogadorAtual(), 10);
            adicionaNaPrisao(listaJogadores.get(jogadorAtual()));

        } else if (indiceChance == 9) {
            int GastosRua = this.listaJogadores.get(jogadorAtual()).getQuantidadeDeCasas() * 25;
            GastosRua = GastosRua + this.listaJogadores.get(jogadorAtual()).getQuantidadeDeHoteis() * 10;
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(GastosRua);
        } else if (indiceChance == 10) {
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(15);
        } else if (indiceChance == 11) {

            this.listaJogadores.get(jogadorAtual()).ganharCartaoSaidaDePrisao("chance");
            this.cardChancePrisaoEmPosse = true;
        } else if (indiceChance == 12) {
            if (this.posicoes[this.jogadorAtual()] > 5) {
                this.listaJogadores.get(jogadorAtual()).addDinheiro(200);
            }
            DeslocarJogador(jogadorAtual(), 5);
            if (this.posicoes[this.jogadorAtual()] > 5) {
                this.listaJogadores.get(jogadorAtual()).addDinheiro(200);
            }
        } else if (indiceChance == 13) {
            DeslocarJogador(jogadorAtual(), 39);
        } else if (indiceChance == 14) {
            int debito = numeroDeJogadores * 50 - 50;
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(debito);
            for (int i = 0; i < numeroDeJogadores; i++) {
                if (i != jogadorAtual()) {
                    this.listaJogadores.get(i).addDinheiro(50);
                }
            }
        } else if (indiceChance == 15) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(150);
        }



        if (indiceChance < 16) {
            indiceChance++;
        } else {
            indiceChance = 1;
        }
    }

    /**
     * Realiza o processamento do cartao Chest
     * @throws Exception
     */
    public void realizaProcessamentoCartaoChest() throws Exception {

        if (indiceChest == 1) {
            DeslocarJogador(jogadorAtual(), 40);
            this.listaJogadores.get(jogadorAtual()).addDinheiro(200);
        }
        if (indiceChest == 2) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(200);
        }
        if (indiceChest == 3) {
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(50);
        }
        if (indiceChest == 4) {
            int dinheiroCada = 0;
            for (int i = 0; i < numeroDeJogadores; i++) {
                if (i != jogadorAtual()) {
                    this.listaJogadores.get(i).retirarDinheiro(50);
                    dinheiroCada = dinheiroCada + 50;
                }
            }
            this.listaJogadores.get(jogadorAtual()).addDinheiro(dinheiroCada);
        }

        if (indiceChest == 5) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(45);
        }

        if (indiceChest == 6) {
            this.listaJogadores.get(jogadorAtual()).ganharCartaoSaidaDePrisao("chest");
            this.cardChestPrisaoEmPosse = true;
        }
        if (indiceChest == 7) {
            DeslocarJogador(jogadorAtual(), 10);
            adicionaNaPrisao(listaJogadores.get(jogadorAtual()));
        }
        if (indiceChest == 8) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(20);
        }
        if (indiceChest == 9) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(100);
        }
        if (indiceChest == 10) {
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(100);
        }
        if (indiceChest == 11) {
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(150);
        }
        if (indiceChest == 12) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(25);
        }
        if (indiceChest == 13) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(100);
        }
        if (indiceChest == 14) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(10);
        }
        if (indiceChest == 15) {
            this.listaJogadores.get(jogadorAtual()).addDinheiro(100);
        }
        if (indiceChest == 16) {
            int GastosRua = this.listaJogadores.get(jogadorAtual()).getQuantidadeDeCasas() * 40;
            GastosRua = GastosRua + this.listaJogadores.get(jogadorAtual()).getQuantidadeDeHoteis() * 115;
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(GastosRua);

        }


        if (indiceChest < 16) {
            indiceChest++;
        } else {
            indiceChest = 1;
        }

    }

    /**
     * Move um jogador para uma posicao, procurando pagar tributos, alugueis etc.
     * Tambem compra automaticamente, se esse modo foi definido.
     * @param dado1 valor do dado 1
     * @param dado2 valor do dado 2
     * @throws Exception
     */
    private void moverJogadorDaVez(int dado1, int dado2) throws Exception {
        //    System.out.println("moverJogadorDaVez" +  dado1 + " , " + dado2);

        print("\ttirou nos dados: " + dado1 + " , " + dado2);
        int valorDados = dado1 + dado2;

        int jogador = this.jogadorAtual();

        boolean ValoresIguais = false;


        //preciso saber se o jogador vai passar pela posição 40, o que significa
        //ganhar dinheiro
        this.completouVolta(jogador, valorDados);

        if (dado1 == dado2) {
            ValoresIguais = true;
        } else {
            ValoresIguais = false;
        }

        //movendo à posição
        this.moverJogadorAPosicao(jogador, valorDados, ValoresIguais);
        this.print("\tAtual dinheiro antes de ver a compra:" + this.listaJogadores.get(jogador).getDinheiro());
        this.print("\tVai até a posição " + this.posicoes[jogador]);

        //vendo se caiu na prisao
        if (this.posicoes[this.jogadorAtual()] == 30 && this.prisao == true) {
            adicionaNaPrisao(listaJogadores.get(jogadorAtual()));
            DeslocarJogador(jogador, 10);
            listaJogadores.get(jogadorAtual()).adicionarComandoPay();
        }



        Lugar lugar = this.tabuleiro.get(this.posicoes[jogador] - 1);//busca em -1, pois eh um vetor


        if (this.isCompraAutomatica()) {
            this.realizarCompra(jogador, lugar);
        }

        if (!this.posicaoCompravel(this.posicoes[jogador])) {
            this.print("\t" + lugar.getNome() + " não está à venda!");


            String nomeDono = (String) Donos.get(this.posicoes[jogador]);
            //não cobrar aluguel de si mesmo
            if (!nomeDono.equals(this.listaJogadores.get(this.jogadorAtual()).getNome())) {

                if (this.isUmJogador(nomeDono)) {
                    Jogador possivelDono = this.getJogadorByName(nomeDono);

                    if (this.isPosicaoFerrovia(this.posicoes[jogador])) {
                        this.print("\tO dono eh " + possivelDono.getNome());
                        if (!lugar.estaHipotecada()) {
                            this.pagarFerrovia(possivelDono.getId(), jogador, 25, lugar.getNome());
                        }
                    } else {

                        this.print("\tO dono eh " + possivelDono.getNome());
                        int valorAluguel = 0;
                        if (this.posicoes[this.jogadorAtual()] != 12 && this.posicoes[this.jogadorAtual()] != 28) {
                            valorAluguel = this.tabuleiro.getLugarPrecoAluguel(this.posicoes[jogador]);

                        } else {
                            if (possivelDono.getQuantidadeCompanhias() == 1) {
                                valorAluguel = 4 * valorDados;

                            }
                            if (possivelDono.getQuantidadeCompanhias() == 2) {
                                valorAluguel = 10 * valorDados;

                            }
                        }
                        if (!lugar.estaHipotecada()) {
                            this.pagarAluguel(possivelDono.getId(), jogador, valorAluguel, lugar.getNome());
                        }

                    }

                }
            }

        }


        this.pagarEventuaisTaxas(jogador);

        if ((this.posicoes[this.jogadorAtual()] == 2 || this.posicoes[jogadorAtual()] == 17 || this.posicoes[jogadorAtual()] == 33) && cards == true) {
            realizaProcessamentoCartaoChest();
        }

        if ((this.posicoes[this.jogadorAtual()] == 7 || this.posicoes[jogadorAtual()] == 22 || this.posicoes[jogadorAtual()] == 36) && cards == true) {
            realizaProcessamentoCartaoChance();
        }




        this.print("\tAtual dinheiro depois:" + this.listaJogadores.get(jogador).getDinheiro());



    }

    /**
     * Muda um jogador para a lista de falidos e passa suas posses para o banco
     * @param id o id do jogador
     */
    public void removePlayer(int id) {
        listaJogadoresFalidos.add(listaJogadores.get(id).getNome());
        //liberando os pertences
        String NomeFalido = listaJogadores.get(id).getNome();
        for (int i = 1; i <= Donos.size(); i++) {
            if (Donos.get(i).equals(NomeFalido)) {
                Donos.put(i, "bank");
            }

        }

    }

    /**
     * Checa se a compra automatica foi ligada
     * @return true se a compra e automatica, false caso contrario
     */
    public boolean isCompraAutomatica() {
        return this.compra_automatica;
    }

    /**
     * Realiza a compra de uma posse pelo jogador da vez
     * @return true se a compra foi efetuada, false caso contrario
     * @throws Exception
     */
    public boolean buy() throws Exception {

        int jogador = this.jogadorAtual();

        String lugar = this.tabuleiro.getPlaceName(posicoes[jogador]);
        //    System.out.println("lugar[jogador]" +  lugar);
        boolean posicaoCompravel = this.posicaoCompravel(posicoes[jogador]);
        boolean isEstatal = this.isPosicaoEstatal(this.posicoes[jogador]);

        if (posicaoCompravel || (isEstatal && this.publicServices == true && verificaSeServicoPublicoFoiComprado(this.posicoes[jogador]))) {

            if (posicaoCompravel || (isEstatal && this.publicServices == true)) {
                this.listaJogadores.get(jogadorAtual()).addQuantidadeCompanhias();

            }
            int posicaoTabuleiro = posicoes[jogador];
            int preco = this.tabuleiro.getLugarPrecoCompra(posicaoTabuleiro);
            Jogador j = listaJogadores.get(jogador);
            this.terminarAVez();
            if (preco <= j.getDinheiro()) {
                this.print("\tPossui dinheiro para a compra!");
                j.retirarDinheiro(preco);
                this.Donos.put(posicaoTabuleiro, j.getNome());

                String nomeLugar = this.tabuleiro.getPlaceName(posicaoTabuleiro);
                j.addPropriedade(nomeLugar);
                if (nomeLugar.equals("Reading Railroad") || nomeLugar.equals("Pennsylvania Railroad") ||
                        nomeLugar.equals("B & O Railroad") || nomeLugar.equals("Short Line Railroad")) {
                    DonosFerrovias[jogador]++;
                }
                this.print("\tVocê adquiriu " + nomeLugar + " por " + preco);
                this.print("\tAtual dinheiro: " + j.getDinheiro());
                if (j.temPropriedades() && hipotecaAtiva) {
                    j.adicionarComandoHipotecar();
                }
                if (j.verificaSeTemGrupo(posicaoTabuleiro)) {
                    if (this.build == true) {
                        j.adicionarComandoBuild();
                    }

                    this.tabuleiro.duplicarAluguelGrupo(posicaoTabuleiro);

                }
            } else {
                this.print("\tNão possui dinheiro para realizar a compra!");
                throw new Exception("Not enough money");
            }

        } else {

            if (this.jaTemDono(posicoes[jogador])) {
                throw new Exception("Deed for this place is not for sale");
            }

            if (isEstatal && this.publicServices == false) {
                throw new Exception("Deed for this place is not for sale");
            }
            if (!posicaoCompravel) {
                throw new Exception("Place doesn't have a deed to be bought");
            }
        }



        return false;



    }

    /**
     * Checa se uma posicao eh uma estatal (Electric Comapny ou Water Works)
     * @param posicao
     * @return
     */
    private boolean isPosicaoEstatal(int posicao) {

        boolean estatal = false;
        if (posicao == 12 || posicao == 28) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Efetua a compra de uma propriedade
     * @param posicaoTabuleiro a posicao a ser feita a compra
     * @param jogador o jogador que faz a compra
     * @return true se a compra foi efetuada, false caso contrario
     * @throws Exception
     */
    public boolean efetuarCompra(int posicaoTabuleiro, Jogador jogador) throws Exception {
        if (this.posicaoCompravel(posicaoTabuleiro) && posicaoTabuleiro != 12 && posicaoTabuleiro != 28) {
            int preco = this.tabuleiro.getLugarPrecoCompra(posicaoTabuleiro);
            if (preco <= jogador.getDinheiro()) {
                this.print("\tPossui dinheiro para a compra!");
                jogador.retirarDinheiro(preco);
                this.Donos.put(posicaoTabuleiro, jogador.getNome());

                String nomeLugar = this.tabuleiro.getPlaceName(posicaoTabuleiro);
                jogador.addPropriedade(nomeLugar);
                if (nomeLugar.equals("Reading Railroad") || nomeLugar.equals("Pennsylvania Railroad") ||
                        nomeLugar.equals("B & O Railroad") || nomeLugar.equals("Short Line Railroad")) {
                    DonosFerrovias[jogadorAtual()]++;
                }
                return true;
            } else {
                this.print("\tNão possui dinheiro para realizar a compra!");
                return false;
            }

        }
        return false;

    }

    /**
     * Apenas um encapsulador para o System.out.println(String)
     * @param msg a mensagem a ser impressa no console
     */
    public void print(String msg) {
        this.print(msg, false);
    }

    /**
     * Apenas um encapsulador para o System.out.println(String)
     * @param msg a mensagem a ser impressa no console
     * @param reallyPrint habilitacao da impressao
     */
    public void print(String msg, boolean reallyPrint) {
        if (reallyPrint) {
            System.out.println(msg);
        }

    }

    /**
     * Adiciona jogador na prisao
     * @param jogador
     */
    public void adicionaNaPrisao(Jogador jogador) {
        print("\tA prisao tinha " + listaJogadoresNaPrisao);
        listaJogadoresNaPrisao.add(listaJogadores.get(jogadorAtual()).getNome());

        print("\tmas chegou prisioneiro e prisao agora tem " + listaJogadoresNaPrisao);
    }

    /**
     * Retira jogador da prisao
     * @param jogador
     */
    public void sairdaPrisao(Jogador jogador) {
        print("\tA prisao tinha " + listaJogadoresNaPrisao);
        listaJogadoresNaPrisao.remove(jogador.getNome());

        print("\tmas saiu prisioneiro e prisao agora tem " + listaJogadoresNaPrisao);
    }

    /**
     * Checa se algum jogador ja e dono de uma determinada posicao
     * @param posicao a posicao
     * @return true se ja te dono, falso caso contrario
     */
    private boolean jaTemDono(int posicao) {
        String nomeDono = Donos.get(posicao).toString();
        return (this.isUmJogador(nomeDono));

    }

    /**
     * Verifica se jogador esta preso
     * @param Nome
     * @return
     */
    public boolean JogadorEstaPreso(String Nome) {
        if (listaJogadoresNaPrisao.contains(Nome)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Usar cartao de saida da prisao
     * @param tipoCartao
     * @throws Exception
     */
    public void usarCartao(String tipoCartao) throws Exception {
        terminarAVez();

        if (listaJogadoresNaPrisao.contains(listaJogadores.get(jogadorAtual()).getNome())) {
            this.listaJogadores.get(jogadorAtual()).gastarCartaoSaidaDePrisao(tipoCartao);
            this.processarJogada(2, 1, true);
            this.listaJogadores.get(jogadorAtual()).addDinheiro(50);
            if (tipoCartao.equals("chance")) {
                this.cardChancePrisaoEmPosse = false;
            } else if (tipoCartao.equals("chest")) {
                this.cardChestPrisaoEmPosse = false;
            }
        } else {
            throw new Exception("player is not on jail");
        }
    }

    /**
     * Pagar saida da prisao
     * @throws Exception
     */
    public void pagarSaidaDaPrisao() throws Exception {
        if (listaJogadoresNaPrisao.contains(listaJogadores.get(jogadorAtual()).getNome())) {
            listaJogadoresNaPrisao.remove(listaJogadores.get(jogadorAtual()).getNome());
            listaJogadores.get(jogadorAtual()).setTentativasSairDaPrisao(0);
            listaJogadores.get(jogadorAtual()).retirarDinheiro(50);

        } else {
            print("\tTentou tirar " + listaJogadores.get(jogadorAtual()).getNome());
            throw new Exception("player is not on jail");
        }

        this.pagouPrisaoRecentemente = false;
    }

    /**
     * Ativar servicos publicos
     */
    public void ativarServicosPublicos() {
        this.publicServices = true;
    }

    /**
     * Verifica se servico publico foi comprado
     * @param posicao
     * @return
     */
    public boolean verificaSeServicoPublicoFoiComprado(int posicao) {
        if (posicao == 12 && this.EletricCompanyComprada == true) {
            return true;

        } else if (posicao == 28 && this.WaterWorksComprada == true) {
            return true;

        } else {
            return false;

        }
    }

    /**
     * Ativar compra de casas e hoteis
     */
    public void ativarBuild() {
        this.build = true;
    }

    /**
     * Comprar casas e hoteis
     * @param idPropriedade
     * @throws Exception
     */
    public void comprarCasasEHoteis(int idPropriedade) throws Exception {

        this.terminarAVez();

        if (this.build == true) {

            if (this.hipotecaAtiva && this.tabuleiro.getLugarById(idPropriedade).estaHipotecada()) {
                    throw new Exception("Can't build on mortgaged properties");
            }
            
            if (idPropriedade <= 0 || idPropriedade > 40) {
                throw new Exception("Place doesn't exist");

            }
            if (!this.tabuleiro.getLugarById(idPropriedade).isPropriedade()) {
                throw new Exception("Can only build on properties");

            }
            

            if (!this.tabuleiro.verificaSeGrupoAindaPodeTerConstrucoes(idPropriedade)) {
                this.listaJogadores.get(jogadorAtual()).getComandos().remove("build");
            }
           
            if (this.listaJogadores.get(jogadorAtual()).getComandos().contains("build")) {

                if (!this.listaJogadores.get(jogadorAtual()).getPropriedades().contains(this.tabuleiro.getLugarById(idPropriedade).getNome())) {
                    throw new Exception("Player is not the owner of this property");

                } else if (this.listaJogadores.get(jogadorAtual()).getPropriedades().contains(this.tabuleiro.getLugarById(idPropriedade).getNome()) && !this.listaJogadores.get(jogadorAtual()).verificaSeTemGrupo(idPropriedade)) {
                    throw new Exception("Doesn't hold monopoly for this group");
                }
                //Procedimento para compra de casas e hoteis
                if (this.tabuleiro.verificaSePodeConstruirNoTerreno(idPropriedade) == true) {
                    if (hipotecaAtiva) {
                        verificaSeGrupoTemHipoteca(idPropriedade);
                    }
                    RealizarProtocoloDeCompraDeCasasEHoteis(idPropriedade);

                } else {
                    throw new Exception("Uneven distribution of houses");
                }


            } else {

                throw new Exception("Unavailable command");


            }
        } else {
            throw new Exception("Build nao esta ativo");
        }
    }

    public void verificaSeGrupoTemHipoteca(int idPropriedade) throws Exception {      
                if (grupoTemHipoteca(idPropriedade)) {
                    throw new Exception("Group has mortgaged properties");
                }
    }

    private boolean grupoTemHipoteca(int idPropriedade) throws Exception {
        String grupo = tabuleiro.getLugarGrupo(idPropriedade);
        for (Lugar lugar : tabuleiro) {
            if (lugar.getGrupo(lugar.getPosicao()).equals(grupo)) {
                if (lugar.estaHipotecada()) {
                   return true;
                }
            }
        }
        return false;
    }

    /**
     * Realiza procedimento de compra de casas e hoteis
     * @param idLugar
     * @throws Exception
     */
    private void RealizarProtocoloDeCompraDeCasasEHoteis(int idLugar) throws Exception {
        Lugar lugar = this.tabuleiro.getLugarById(idLugar);

        int nivelDoTerreno = lugar.getNivel();
        if (nivelDoTerreno == 0) {
            int valorCasa = this.banco.comprarCasa(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelUmaCasa(idLugar));
            lugar.addNumeroDeCasas();
            lugar.aumentarNivel();
            this.listaJogadores.get(jogadorAtual()).addQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(valorCasa);
        } else if (nivelDoTerreno == 1) {
            int valorCasa = this.banco.comprarCasa(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelDuasCasas(idLugar));
            lugar.addNumeroDeCasas();
            lugar.aumentarNivel();
            this.listaJogadores.get(jogadorAtual()).addQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(valorCasa);
        } else if (nivelDoTerreno == 2) {
            int valorCasa = this.banco.comprarCasa(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelTresCasas(idLugar));
            lugar.addNumeroDeCasas();
            lugar.aumentarNivel();
            this.listaJogadores.get(jogadorAtual()).addQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(valorCasa);
        } else if (nivelDoTerreno == 3) {
            int valorCasa = this.banco.comprarCasa(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelQuatroCasas(idLugar));
            lugar.addNumeroDeCasas();
            lugar.aumentarNivel();
            this.listaJogadores.get(jogadorAtual()).addQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(valorCasa);
        } else if (nivelDoTerreno == 4) {
            int valorHotel = this.banco.comprarHotel(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelHotel(idLugar));
            lugar.aumentarNivel();
            lugar.addNumeroDeHoteis();
            lugar.diminuirNumeroDeCasas();
            lugar.diminuirNumeroDeCasas();
            lugar.diminuirNumeroDeCasas();
            lugar.diminuirNumeroDeCasas();
            this.banco.BancoReceber4Casas();
            this.listaJogadores.get(jogadorAtual()).addQuantidadeDeHoteis();
            this.listaJogadores.get(jogadorAtual()).diminuirQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).diminuirQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).diminuirQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).diminuirQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).retirarDinheiro(valorHotel);
        } else if (nivelDoTerreno == 5) {
            throw new Exception("No further buildings on this property");
        }

        if ((this.listaJogadores.get(jogadorAtual()).getQuantidadeDeCasas() > 0 ||
                this.listaJogadores.get(jogadorAtual()).getQuantidadeDeHoteis() > 0) &&
                this.sell == true) {
            this.listaJogadores.get(jogadorAtual()).adicionarComandoSell();
        }


    }

    /**
     * Vender casas ou hoteis
     * @param idPropriedade
     * @throws Exception
     */
    public void VenderCasasOuHoteis(int idPropriedade) throws Exception {
        this.terminarAVez();

        if (this.sell == true) {
            if (this.listaJogadores.get(jogadorAtual()).getComandos().contains("sell")) {

                if (idPropriedade <= 0 || idPropriedade > 40) {
                    throw new Exception("Place doesn't exist");
                }

                if (!this.tabuleiro.getLugarById(idPropriedade).isPropriedade()) {
                    throw new Exception("Can only sell houses built on properties");
                }
                boolean OJogadorDavezEhDono = this.listaJogadores.get(jogadorAtual()).getPropriedades().contains(this.tabuleiro.getLugarById(idPropriedade).getNome());
                if (OJogadorDavezEhDono) {
                    if (this.tabuleiro.getLugarById(idPropriedade).getNivel() == 0) {
                        throw new Exception("No house is built on this property");
                    }
                } else {
                    throw new Exception("Player is not the owner of this property");
                }

                //Procedimento De Venda

                if (this.tabuleiro.verificaSePodeVenderImovelDoTerreno(idPropriedade) == true) {
                    RealizarProtocoloDeVendaDeCasasEHoteis(idPropriedade);

                } else {
                    throw new Exception("Uneven distribution of houses");
                }
            } else {
                throw new Exception("Unavailable command");
            }



        }
    }

    /**
     * Realiza procedimento de venda de casas e hoteis
     * @param idLugar
     * @throws Exception
     */
    private void RealizarProtocoloDeVendaDeCasasEHoteis(int idLugar) throws Exception {
        Lugar lugar = this.tabuleiro.getLugarById(idLugar);

        int nivelDoTerreno = lugar.getNivel();
        if (nivelDoTerreno == 0) {
            throw new Exception("Terreno nao possui casa");
        } else if (nivelDoTerreno == 1) {
            int valorCasaVenda = this.banco.VenderCasa(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelSemCasa(idLugar));
            lugar.diminuirNumeroDeCasas();
            lugar.diminuirNivel();
            this.banco.addCasas();
            this.listaJogadores.get(jogadorAtual()).diminuirQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).addDinheiro(valorCasaVenda);
            if (this.listaJogadores.get(jogadorAtual()).getQuantidadeDeCasas() == 0 && this.listaJogadores.get(jogadorAtual()).getQuantidadeDeHoteis() == 0) {
                this.listaJogadores.get(jogadorAtual()).removerComandoSell();
            }
        } else if (nivelDoTerreno == 2) {
            int valorCasaVenda = this.banco.VenderCasa(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelUmaCasa(idLugar));
            lugar.diminuirNumeroDeCasas();
            lugar.diminuirNivel();
            this.banco.addCasas();
            this.listaJogadores.get(jogadorAtual()).diminuirQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).addDinheiro(valorCasaVenda);
        } else if (nivelDoTerreno == 3) {
            int valorCasaVenda = this.banco.VenderCasa(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelDuasCasas(idLugar));
            lugar.diminuirNumeroDeCasas();
            lugar.diminuirNivel();
            this.banco.addCasas();
            this.listaJogadores.get(jogadorAtual()).diminuirQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).addDinheiro(valorCasaVenda);

        } else if (nivelDoTerreno == 4) {
            int valorCasaVenda = this.banco.VenderCasa(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelTresCasas(idLugar));
            lugar.diminuirNumeroDeCasas();
            lugar.diminuirNivel();
            this.banco.addCasas();
            this.listaJogadores.get(jogadorAtual()).diminuirQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).addDinheiro(valorCasaVenda);

        } else if (nivelDoTerreno == 5) {
            if (this.banco.getCasas() < 4) {
                throw new Exception("Not enough houses on the bank");
            }
            int valorCasaVenda = this.banco.VenderCasa(idLugar);
            lugar.setPrecoAluguel(this.tabuleiro.getPrecoAluguelQuatroCasas(idLugar));
            this.banco.BancoPerder4Casas();
            lugar.addNumeroDeCasas();
            lugar.addNumeroDeCasas();
            lugar.addNumeroDeCasas();
            lugar.addNumeroDeCasas();
            lugar.diminuirNivel();
            this.banco.addHoteis();
            this.listaJogadores.get(jogadorAtual()).diminuirQuantidadeDeHoteis();
            this.listaJogadores.get(jogadorAtual()).addQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).addQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).addQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).addQuantidadeDeCasas();
            this.listaJogadores.get(jogadorAtual()).addDinheiro(valorCasaVenda);

        }
    }

    /**
     * retorna o tabuleiro
     * @return o tabuleiro
     */
    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    public void ativarHipoteca() {
        hipotecaAtiva = true;
    }

    /**
     * hipotecar uma Propriedade
     * @param idPropriedade
     * @throws Exception
     */
    public void hipotecarPropriedade(int idPropriedade) throws Exception {
        if (!this.tabuleiro.lugarExiste(idPropriedade)) {
            throw new Exception("Place doesn't exist");
        }
        boolean hipotecaEstaLiberada = hipotecaEstaLiberada(idPropriedade);
        if (hipotecaEstaLiberada) {
            this.terminarAVez();
            if (posicaoHipotecavel(idPropriedade)) {
                Lugar lugar = this.tabuleiro.getLugarById(idPropriedade);
                Jogador jogadorAtual =this.listaJogadores.get(jogadorAtual());
                boolean OJogadorDavezEhDono = jogadorAtual.getPropriedades().contains(lugar.getNome());
                if (OJogadorDavezEhDono) {
                    lugar.hipotecar();
                 //   verificaHipotecasDoJogadorAtual();
                    jogadorAtual.addDinheiro(tabuleiro.getPrecoHipoteca(idPropriedade));

                } else {
                    throw new Exception("Player doesn't hold the deed for this place");
                }

            } else {
                throw new Exception("This place can't be mortgaged");
            }
        } else {
            throw new Exception("Unavailable command");
        }


    }

    private boolean hipotecaEstaLiberada(int idPropriedade) throws Exception {
        boolean hipotecaEstaLiberada = (this.listaJogadores.get(jogadorAtual()).getComandos().contains("mortgage") && hipotecaAtiva && !this.listaJogadores.get(jogadorAtual()).getPropriedades().isEmpty() && !this.tabuleiro.getLugarById(idPropriedade).estaHipotecada()) ? true : false;
        return hipotecaEstaLiberada;
    }

    /**
     * Checa se uma posicao esta disponivel para hipoteca
     * @param posicao a posicao do lugar
     * @return true se a posicao esta disponivel, falso caso contrario
     */
    public boolean posicaoHipotecavel(int posicao) {

        String dono = (String) this.Donos.get(posicao);
        if (dono.equals("noOwner") || dono.equalsIgnoreCase("Income Tax") || dono.equalsIgnoreCase("Luxury Tax")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean propriedadeEstaHipotecada(int idPropriedade) throws Exception {
        if (!posicaoHipotecavel(idPropriedade)) {
            throw new Exception("This place can't be mortgaged");
        } else {
            return this.tabuleiro.getLugarById(idPropriedade).estaHipotecada();
        }
    }
    public void desipotecarPropriedade(int idPropriedade) throws Exception{
        if (!this.tabuleiro.lugarExiste(idPropriedade)) {
            throw new Exception("Place doesn't exist");
        }
        if (hipotecaAtiva) {          
                this.terminarAVez();
                Lugar lugar = this.tabuleiro.getLugarById(idPropriedade);
                boolean OJogadorDavezEhDono = this.listaJogadores.get(jogadorAtual()).getPropriedades().contains(lugar.getNome());
                if (OJogadorDavezEhDono) {

                    lugar.desipotecar();
                    double preco = tabuleiro.getPrecoHipoteca(idPropriedade);
                    int precoTotal = (int)(Math.ceil( (preco + (preco* 0.10))));
                    this.listaJogadores.get(jogadorAtual()).retirarDinheiro(  precoTotal  );

                //    verificaHipotecasDoJogadorAtual();


                } else {
                    throw new Exception("Unavailable command");
                }
        }else{
            throw new Exception("Unavailable command");
        }

    }

    public void ativarDesipoteca(){
        hipotecaAtiva =  true;
    }
}
