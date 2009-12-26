/**
 * Universidade Estadual de Feira de Santana
 * Padrões e Frameworks 2009.1
 * João de Matos
 * Lidiany C Santos
 */
package game.model.entity.player;

import game.util.Command;
import game.util.CommandType;
import game.model.entity.board.Place;
import game.model.entity.board.Board;
import game.model.entity.board.Railroad;
import game.model.entity.board.PurchasablePlace;
import game.model.entity.board.Utility;
import game.model.entity.board.Property;
import game.model.configuration.GameConfiguration;
import game.model.entity.card.Card;
import game.model.entity.card.OutOfJail;
import game.model.exceptions.BuildException;
import game.model.exceptions.GameException;
import game.model.exceptions.GamePlaceException;
import game.model.exceptions.IllegalPlayerStateException;
import game.model.exceptions.InvalidCommandException;
import game.model.exceptions.NonExistentCardException;
import game.model.exceptions.NonExistentPlaceException;
import game.model.exceptions.NotEnoughMoneyException;
import game.model.exceptions.NotInSaleException;
import game.util.CheckMonopoly;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a entidade jogador
 * @author UEFS\jmatos
 */
public class Player {

    /** 
     * Id do jogador no jogo
     */
    private int id;
    /**
     * Nome do jogador
     */
    private String name;
    /** 
     * Cor do peão do jogador
     */
    private String color;
    /** 
     * Quantia em dinheiro que o jogador recebe
     */
    private float amountOfMoney;
    
    /**
     * Lugar onde o jogador se encontra
     */
    private Place atualPlace;

    /** Cartas do jogador */
    private ArrayList<OutOfJail> playerCards;

    /**
     * Posição do jogador no tabuleiro
     */
    private int atualPosition;
    /**
     * Lista de proprieades que o jodador possui.
     */
    private ArrayList<PurchasablePlace> itsPropertys;

    /**
     * Comandos que o jogador pode executar
     */
    private List<Command> playerCommands = null;

    /**
     * <b>true</b> se o jogador está no jogo ou <b>false</b> se já perdeu
     */
    private boolean playing;

    private ArrayList<CheckMonopoly> monopolys;

    /**
     * Estado atual do jogador
     */
    private PlayerState atualState;

    /**
     * Jogador está na cadeia
     */
    private ArrestedState arrestedState;


    private PlayerState playingState;

    /** Cria uma nova instância de um jogador
     * @param color cor do peão
     * @param name nome do jogador
     */
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.itsPropertys = new ArrayList<PurchasablePlace>();
        this.monopolys = new ArrayList<CheckMonopoly>();
        this.startCommands();
        playing = true;
        
        playerCards = new ArrayList<OutOfJail>();
        arrestedState = new ArrestedState(this);
        playingState = new PlayingState(this);
        atualState = playingState;
    }

    public boolean isPlaying() {
        return playing;
    }

    private void startCommands(){
        //System.out.println("Se vc ver essa mensagem mais de uma vez vc realmetne tá fudido");
        this.playerCommands = new ArrayList<Command>();
        this.playerCommands.add(new Command(CommandType.ROLL, true));
        this.playerCommands.add(new Command(CommandType.STATUS, true));
        this.playerCommands.add(new Command(CommandType.QUIT, true));
        this.playerCommands.add(new Command(CommandType.BUILD, false));
    }

    private void updateCommands(){
        for (Command c : playerCommands)
            if(c.getType() == CommandType.BUILD){
                c.setActive(this.isBuiltActive());


                /*System.out.println("Comanodo Build");
                if(atualPlace instanceof PurchasablePlace){
                    PurchasablePlace pp = (PurchasablePlace) atualPlace;
                    System.out.println("    " +name + " está em um lugar compável");
                    System.out.println("    Dono do lugar: " + pp.getOwner().getName() + " monopoly: " + pp.getPlaceGroup() );
                    if(this.isMonopoly(pp)){
                        c.setActive(true);
                        System.out.println("        " +name + " Tem o monopolio de: " + pp.getPlaceGroup());
                        return;
                    }else{
                        System.out.println("    " + name + " Não tem o monopolio de: " + atualPlace.getName());
                    }
                }*/
            }
    }

    private boolean isBuiltActive(){
        for(CheckMonopoly c : monopolys){
            if(c.isInMonopoly() && !c.wereAllHousesBuild()){
                return true;
            }
                
        }
        return false;
    }
    /**
     * Tira o jogador do jogo e devolve todas as suas propriedades ao banco.
     */
    public void leavesGame() {
        playing = false;
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            purchasablePlace.returnToBank();
        }
    }

    public void addMonopoly(PurchasablePlace p){
        String monopoly = p.getPlaceGroup();
        for(CheckMonopoly c : monopolys){
            if(c.getMonopoly().equals(monopoly)){
                c.oneMore(p);
                return;
            }
        }
        monopolys.add(new CheckMonopoly(p));
    }


    public boolean isMonopoly(PurchasablePlace p){
         for(CheckMonopoly c : monopolys)
            if(c.getMonopoly().equals(p.getPlaceGroup()) && c.isInMonopoly())
                return true;
        return false;
    }

    private boolean isBuildAvaliable(Place p){
       /* updateCommands();
        for(Command c : playerCommands){
            if(c.getType() == CommandType.BUILD)
                return c.isActive();
        }*/
        if (atualPlace.getPlaceGroup().equalsIgnoreCase(p.getPlaceGroup()))
            return true;



        return false;
    }

    public void build(int propertyID) throws NonExistentPlaceException, NotEnoughMoneyException, BuildException{

        if(this.isBuiltActive()){
            Board board = Board.getBoard();
            Place p = board.getPlaceByPosition(propertyID);

            if(!(p instanceof Property))
                throw new BuildException("Can only build on properties");

            Property property = (Property)p;

            if(!has(property))
                throw new BuildException("Player is not the owner of this property");
            else if(!isMonopoly(property))
                throw new BuildException("Doesn't hold monopoly for this group");
            else{
                property.build();
            }
        }else
            throw new BuildException("Unavailable command");
        
    }

    private boolean has(Place p){

        for(Place pCurrent : itsPropertys){
            if(pCurrent == p)
                return true;
        }

        return false;

    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void add(PurchasablePlace place) {
        itsPropertys.add(place);
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Place getAtualPlace() {
        return atualPlace;
    }

    public void setAtualPosition(int atualPosition) {
        this.atualPosition = atualPosition;
    }

    public int getAtualPosition() {
        return atualPlace.getPosition();
    }

    public void setAtualPlace(Place atualPlace) {
        this.atualPlace = atualPlace;
        this.atualPosition = atualPlace.getPosition();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void credit(float money) {
        this.amountOfMoney += money;
    }
    /**
     * Faz o jogador pagar alguma coisa, caso tenha dinheiro.
     * @param money
     * @throws NotEnoughMoneyException caso não tenha dinheiro
     */
    public void debit(float money) throws NotEnoughMoneyException {
        if (this.amountOfMoney >= money) {
            this.amountOfMoney -= money;
        } else {
            throw new NotEnoughMoneyException("Not enough money");
        }
    }

    private void addPropertys(PurchasablePlace p){
        this.itsPropertys.add(p);
        addMonopoly(p);
        this.updateCommands();
    }

    /**
     * Faz o jogador comprar a propriedade em que se encontra, caso tenha dinheiro
     * e aquela esteja a venda.
     * @throws game.model.exceptions.NotEnoughMoneyException
     * @throws game.model.exceptions.NotInSaleException
     * @throws game.model.exceptions.ItAlreadyHasAnOnwerException
     */
    public void buyProperty() throws NotEnoughMoneyException, NotInSaleException, GamePlaceException {


        if (!(atualPlace instanceof PurchasablePlace)) {
            throw new NotInSaleException("Place doesn't have a deed to be bought");
        } else if ((atualPlace instanceof Utility)) {
            throw new NotInSaleException("Deed for this place is not for sale");
        } else {
            PurchasablePlace p = (PurchasablePlace) atualPlace;
            if (p.getOwner().getName().equals("bank")) {
                debit(p.getPrice());
                p.setOwner(this);
                addPropertys(p);
                if (p instanceof Railroad) {
                    updateRailroadsRunning();
                }
            } else {
                throw new GamePlaceException("Deed for this place is not for sale");
            }
        }
    }

    public ArrayList<PurchasablePlace> getItsPropertys() {
        return itsPropertys;
    }

    public void setItsPropertys(ArrayList<PurchasablePlace> itsPropertys) {
        this.itsPropertys = itsPropertys;
    }

    public List<Command> getPlayerCommands() {
        //System.out.println("getPlayerCommands : Build = " + this.playerCommands.get(3).isActive()+" - "+this.playerCommands.get(3).getType());
        return playerCommands;
    }

    public void setPlayerCommands(List<Command> playerCommands) {
        this.playerCommands = playerCommands;
    }

    public String getStatus() {
        return "";
    }

    @Override
    public String toString() {
        return this.name + " " + this.color + " " + this.amountOfMoney;
    }

    /**
     * Método para pagamentos de aluguéis. Considera a possibilidade do player
     * nao ter dinheiro suficiente para pagar
     * @param otherPlayer - o jogador pra quem o aluguel será pago
     * @param rent - o valor do aluguel
     * @throws NotEnoughMoneyException - caso o jogador não tenha diheiro pra pagar o aluguel
     */
    public void payRent(Player otherPlayer, float rent) throws NotEnoughMoneyException {
        try {
            this.debit(rent);
            otherPlayer.credit(rent);
        } catch (NotEnoughMoneyException ex) {
            otherPlayer.credit(amountOfMoney);
            throw ex;
        }
    }

    /**
     * Faz o usuário andar pelo tabuleiro. Deposita $200 caso passe pelo ponto
     * de partida.
     * @param nPositions
     * @param board
     */
    public void walk(int nPositions) throws NonExistentPlaceException, Exception {

        int goTo = atualPosition + nPositions;

        /*
         * Adoraria poder refatorar esse método pra pegar o board do getBoard()
         * mas, por mais ilogico q isso seja, não esta dando  certo!!
         */
        goTo(goTo, true);

    }

    public void walk(int positionToGo, boolean salaryBonus) throws NonExistentPlaceException, Exception{

        //caso precise arrudeiar o tabuleiro
        if(positionToGo < atualPosition){
            positionToGo = 40 + positionToGo;
        }

        //System.out.println("                    positionToGo: " + positionToGo);

        goTo(positionToGo, salaryBonus);
    }

    public void goTo(int goTo, boolean salaryBonus) throws NonExistentPlaceException, Exception{
        Board board = Board.getBoard();

        if (goTo < 40) {
            setAtualPlace(board.getPlaceByPosition(goTo));
        } else {
            //usado nas cartas, para credito ou nao do salaryBonus
            if(salaryBonus){
                GameConfiguration gc = GameConfiguration.getConfiguration();
                this.credit(gc.getSalaryBonus());
            }

            if (goTo == 40) {
                setAtualPlace(board.getPlaceByPosition(goTo));
                setAtualPosition(0); //não ganha os 200 na proxima
            } else {
                setAtualPlace(board.getPlaceByPosition(goTo - 40));
            }
        }
        //System.out.println("                        GoTo: "+this.getName()+" está indo p place.action() place: " + atualPlace.getPosition());
        //System.out.println("                        GoTo: "+this.getName()+" player.getPlace() place: " + this.getAtualPlace().getPosition());

        atualPlace.action(this);
        updateCommands();

    }

    /**
     * Retorna o número de ferrovias do jogador
     * @return o número de ferrovias do jogador     *
     */
    private int getNumberOfRailRoads() {
        int n = 0;
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            if (purchasablePlace instanceof Railroad) {
                n++;
            }
        }
        return n;
    }
    /**
     * Atualiza o valor da corrida para as ferrovias do jogador
     */
    private void updateRailroadsRunning() {
        for (PurchasablePlace purchasablePlace : itsPropertys) {
            if (purchasablePlace instanceof Railroad) {
                ((Railroad) purchasablePlace).setnRailroad(getNumberOfRailRoads());
            }
        }
    }

    /**
     * Adiciona uma carta à lista de cartas do jogador
     * @param card a carta que o jogador pegou
     */
    public void addCard(OutOfJail card){
        this.playerCards.add(card);
        this.playerCommands.add(new Command(CommandType.USECARD, true));
    }

    public void goesToJail(){
            this.atualState = arrestedState;
            arrestedState.play();
    }

    public void leavesJail(){
        this.atualState = playingState;
    }

    public boolean isInJail(){
        return atualState.getPlayerStatus().equalsIgnoreCase("arrested");
    }

    public void paysBail() throws IllegalPlayerStateException{
        System.out.println("" + isInJail());
        if( isInJail() ){
            arrestedState.paysBail();
        }else{
            throw new IllegalPlayerStateException("player is not on jail");
        }
    }

    public void useCard(String  cardType) throws IllegalPlayerStateException, NonExistentCardException{
        
        if( isInJail() ){
            if(hasCard(cardType)){
                arrestedState.useCard();
            }else{
              throw new NonExistentCardException("Player doesn't have this card to use");
            }
        }else{
            throw new IllegalPlayerStateException("player is not on jail");
        }
    }

    public boolean hasCard(String  cardType){
        for (OutOfJail outOfJail : playerCards) {
            if( outOfJail.getType().equalsIgnoreCase(cardType) ){
                return true;
            }
        }
        return false;
    }


 

}
