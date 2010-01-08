package monopoly;

/**
 * Contem as informacoes de um lugar do tabuleiro
 * @author Marcus
 */
public class Lugar {

    /**
     * Nome do lugar
     */
    private String Nome = "";
    /**
     * Preco de compra do lugar
     */
    private int PrecoCompra = 0;
    /**
     * Preco de aluguel do lugar
     */
    private int PrecoAluguel = 0;
    /**
     * Numero de casas do lugar
     */
    public int numeroDeCasas = 0;
    /**
     * Numero de Hoteis do lugar
     */
    public int numeroDeHoteis = 0;
    /**
     * Nivel do lugar
     */
    private int nivel = 0;
    /**
     * Nome do dono do lugar
     */
    private String dono = "bank";
    /**
     * Posicao do lugar no tabuleiro
     */
    private int Posicao = 0;

    private boolean estaHipotecada = false;

    /**
     * Instancia um novo lugar
     * @param Posicao a posicao
     * @param Nome o nome
     * @param Preco o preco de compra
     */
    public Lugar(int Posicao, String Nome, int PrecoCompra, int PrecoAluguel) {
        this.Nome = Nome;
        this.PrecoCompra = PrecoCompra;
        this.Posicao = Posicao;
        this.PrecoAluguel = PrecoAluguel;
    }
    /**
     * Retorna a posicao do lugar no tabuleiro
     * @return a posicao
     */
    public int getPosicao() {
        return Posicao;
    }

    /**
     * Obtem o nome do lugar
     * @return o nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * Define um nome para o lugar
     * @param Nome o nome do lugar
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * Obtem o preco de compra do lugar
     * @return o preco
     */
    public int getPrecoCompra() {
        return PrecoCompra;
    }

    /**
     * Define um preco para o lugar
     * @param Preco o preco
     */
    public void setPrecoCompra(int Preco) {
        this.PrecoCompra = Preco;
    }

    /**
     * Consulta o grupo de algum lugar
     * @param placeID o id do lugar
     * @return o nome do grupo
     */
    public String getGrupo(int placeID) {
        if (placeID == 1 || placeID == 3) {
            return "purple";
        } else if (placeID == 6 || placeID == 8 || placeID == 9) {
            return "light blue";
        } else if (placeID == 4 || placeID == 38) {
            return "tax";
        } else if (placeID == 5 || placeID == 15 || placeID == 25 || placeID == 35) {
            return "railroad";
        } else if (placeID == 7 || placeID == 22 || placeID == 36) {
            return "chance";
        } else if (placeID == 10 || placeID == 20 || placeID == 30 || placeID == 40) {
            return "corner";
        } else if (placeID == 11 || placeID == 13 || placeID == 14) {
            return "pink";
        } else if (placeID == 12 || placeID == 28) {
            return "utility";
        } else if (placeID == 16 || placeID == 18 || placeID == 19) {
            return "orange";
        } else if (placeID == 21 || placeID == 23 || placeID == 24) {
            return "red";
        } else if (placeID == 26 || placeID == 27 || placeID == 29) {
            return "yellow";
        } else if (placeID == 31 || placeID == 32 || placeID == 34) {
            return "green";
        } else if (placeID == 37 || placeID == 39) {
            return "indigo";
        } else {
            return "chest";
        }
    }

  
    /**
     * Obtem o nome do dono do lugar
     * @return nome do dono
     */
    public String getDono() {
        return dono;
    }
    /**
     * Verifica se lugar eh uma propriedade
     * @return booleano
     */
    public boolean isPropriedade() {
        if (this.getGrupo(this.Posicao).equals("purple") || this.getGrupo(this.Posicao).equals("light blue") || this.getGrupo(this.Posicao).equals("pink") || this.getGrupo(this.Posicao).equals("indigo") || this.getGrupo(this.Posicao).equals("orange") || this.getGrupo(this.Posicao).equals("red") || this.getGrupo(this.Posicao).equals("yellow") || this.getGrupo(this.Posicao).equals("green")) {
            return true;
        } else {
            return false;
        }

    }
    /**
     * Retorna numero de casas do lugar
     * @return numero de casas
     */
    public int getNumeroDeCasas() {
        return this.numeroDeCasas;
    }
    /**
     * Seta numero de casas do lugar
     * @param numeroDeCasas
     */
    public void setNumeroDeCasas(int numeroDeCasas) {
        this.numeroDeCasas = numeroDeCasas;
    }
    /**
     * Adiciona em uma unidadeo numero de casas do lugar
     * @throws Exception
     */
    public void addNumeroDeCasas() throws Exception {
        if (this.numeroDeCasas == 4) {
            throw new Exception("não cabe mais casa");
        } else {
            this.numeroDeCasas++;
        }

    }
    /**
     * Diminui em uma unidade o numero de casas do lugar
     * @throws Exception
     */
    public void diminuirNumeroDeCasas() throws Exception {
        if (this.numeroDeCasas == 0) {
            throw new Exception("Numero De Casas jah eh zero");
        } else {
            this.numeroDeCasas--;
        }

    }
    /**
     * Retorna numero de hoteis do lugar
     * @return o numero de hoteis
     */
    public int getNumeroDeHoteis() {
        return this.numeroDeHoteis;
    }
    /**
     * Seta numero de hoteis do lugar
     * @param numeroDeHoteis
     */
    public void setNumeroDeHoteis(int numeroDeHoteis) {
        this.numeroDeHoteis = numeroDeHoteis;
    }
    /**
     * Adiciona em uma unidade o numero de hoteis do lugar
     * @throws Exception
     */
    public void addNumeroDeHoteis() throws Exception {
        if (this.numeroDeHoteis == 1) {
            throw new Exception("não cabe mais Hotel");
        } else {
            this.numeroDeHoteis++;
        }

    }
    /**
     * Retorna o valor do aluguel do lugar
     * @return o preco
     */
    public int getPrecoAluguel() {
        return this.PrecoAluguel;
    }
    /**
     * Seta o preco do aluguel do lugar
     * @param PrecoAluguel
     */
    public void setPrecoAluguel(int PrecoAluguel) {
        this.PrecoAluguel = PrecoAluguel;
    }
    /**
     * Aumenta nivel do lugar em uma unidade
     */
    public void aumentarNivel() {
        this.nivel++;
    }
    /**
     * Diminui nivel do lugar em uma unidade
     */
    public void diminuirNivel() {
        this.nivel--;
    }
    /**
     * Retorna nivel do lugar
     * @return o nivel
     */
    public int getNivel() {
        return this.nivel;
    }

    public void hipotecar() throws Exception{
       if(this.getNumeroDeCasas() >0){
           throw  new Exception("Can't mortgage a property with houses built");
       }else if( this.getNumeroDeHoteis() >0){
            throw  new Exception("Can't mortgage a property with hotels built");
       }else{
          this.estaHipotecada = true;
       }
    }

    public boolean estaHipotecada() {
        return estaHipotecada;
    }



}
