package monopoly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Armazena os comandos possíveis do jogo
 * @author Marcus
 */
public class Comandos {

    /**
     * Lista dos comandos
     */
    private List<String> cmds = new ArrayList<String>();
    /**
     * Flag de comando Pay incluido
     */
    private boolean comandoPayIncluido = false;
    /**
     * Flag de comando Build incluido
     */
    private boolean comandoBuildIncluido = false;
    /**
     * Flag de comando Sell incluido
     */
    private boolean comandoSellIncluido = false;

     /**
     * Flag de comando Mortgage incluido
     */
    private boolean comandoMortgageIncluido = false;
    /**
     * construtor de comandos
     */
    public Comandos() {
        cmds.clear();
        initComandos();
    }

    /**
     * Inicializa a colecao de comandos
     */
    public void initComandos() {
        cmds.add("roll");
        cmds.add("status");
        cmds.add("quit");
    }

    /**
     * Obtem a lista de comandos
     * @return a lista de comandos
     */
    public List getCmds() {
        return cmds;

    }
    /**
     * Adiciona comando Pay
     */
    public void addComandoPay() {
        if (!comandoPayIncluido) {
            cmds.add("pay");
            this.comandoPayIncluido = true;
        }
    }
    /**
     * Remove comando Pay
     */
    public void removerComandoPay() {
        if (comandoPayIncluido) {
            cmds.remove("pay");
            this.comandoPayIncluido = false;
        }
    }
    /**
     * Adiciona comando Build
     */
    public void addComandoBuild() {
        if (!comandoBuildIncluido) {
            cmds.add("build");
            this.comandoBuildIncluido = true;
        }
    }
    /**
     * Adiciona comando Sell
     */
    public void addComandoSell() {
        if (!comandoSellIncluido) {
            cmds.add("sell");
            this.comandoSellIncluido = true;
        }
    }
    /**
     * Remove comando Build
     */
    public void removerComandoBuild() {
        if (comandoBuildIncluido) {
            cmds.remove("build");
            this.comandoBuildIncluido = false;
        }
    }

        /**
     * Adiciona comando Hypothecate
     */
    public void addComandoMortgage() {
        if (!comandoMortgageIncluido) {
            cmds.add("mortgage");
            this.comandoMortgageIncluido = true;
        }
    }
    /**
     * Remove comando Hypothecate
     */
    public void removerComandoMortgage() {
        if (comandoMortgageIncluido) {
            cmds.remove("mortgage");
            this.comandoMortgageIncluido = false;
        }
    }
    /**
     * Remover comando Sell
     */
    public void removerComandoSell() {
        if (comandoSellIncluido) {
            cmds.remove("sell");
            this.comandoSellIncluido = false;
        }
    }

    /**
     * Exibe os comandos
     */
    public void showComandos() {
        Iterator<String> a = cmds.iterator();
        while (a.hasNext()) {
            System.out.print("[" + a.next() + "]");
        }

        System.out.println("\n");
    }
}
