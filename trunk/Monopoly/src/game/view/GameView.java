/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view;

import game.model.entity.Colors;
import java.util.List;

/**
 * Responsável pela exibição das informações
 * para o jogador e também pela captura das informações fornecidas pelo mesmo. * 
 * @author Lidiany
 */
public interface GameView {

    /***
     * Captura o número de jogadores em um a partida
     * @author Lidiany
     * @return  o comando escolhido pelo jogador atual
     */
    public int getNumberOfPlayers();

    /***
     * Captura o nome de um jogador
     * @author Lidiany
     * @return  o nome forncecido pelo jogador
     */
    public String getPlayerName();

    /***
     * Captura uma cor escolhida pelo jogador
     * @author Lidiany
     * @return a cor escolhida pelo jogador
     */
    public String getPlayerColor();

    /***
     * Captura uma opção escolhida pelo jogador, entre <b> SIM</b> ou <b>NÃO</b>
     * @author Lidiany
     * @return a opção escolhida pelo jogador
     */
    public String getYesOrNoOption();

    /***
     * Captura um comando escolhido pelo jogador
     * @author Lidiany
     * @return o comando escolhido pelo jogador
     */
    public String getPlayerCommand();

    /***
     * Exibe uma mensagem para o jogador
     * @param message -  a mensagem a ser exibida
     * @author Lidiany
     */
    public void showMessage(String message);

    /***
     * Exibe as opções de cores disponíveis para o peão do jogador
     * @author Lidiany
     */
    public void showOptionalColors(List<Colors> availableColors);

    /***
     * Exibe os comandos disponíveis para o jogador
     * @author Lidiany
     */
    public void showOptionalCommands();
}
