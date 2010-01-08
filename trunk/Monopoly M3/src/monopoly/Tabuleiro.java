/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.ArrayList;

/**
 * Armazena informacoes do tabuleiro e informacoes gerais dos lugares
 * @author Marcus
 */
public class Tabuleiro extends ArrayList<Lugar> {

    /**
     * Os nomes dos lugares
     */
    private String[] nomes_lugares = {"Mediterranean Avenue",
        "Community Chest 1",
        "Baltic Avenue",
        "Income Tax",
        "Reading Railroad",
        "Oriental Avenue",
        "Chance 1",
        "Vermont Avenue",
        "Connecticut Avenue",
        "Jail - Just Visiting",
        "St. Charles Place",
        "Electric Company",
        "States Avenue",
        "Virginia Avenue",
        "Pennsylvania Railroad",
        "St. James Place",
        "Community Chest 2",
        "Tennessee Avenue",
        "New York Avenue",
        "Free Parking",
        "Kentucky Avenue",
        "Chance 2",
        "Indiana Avenue",
        "Illinois Avenue",
        "B & O Railroad",
        "Atlantic Avenue",
        "Ventnor Avenue",
        "Water Works",
        "Marvin Gardens",
        "Go To Jail",
        "Pacific Avenue",
        "North Carolina Avenue",
        "Community Chest 3",
        "Pennsylvania Avenue",
        "Short Line Railroad",
        "Chance 3",
        "Park Place",
        "Luxury Tax",
        "Boardwalk",
        "Go"};
    /**
     * Os precos do aluguel
     */
    private int[] precos_lugares_aluguel = {2, 0, 4, 0, 0, 6, 0, 6, 8, 0,
        10, 0, 10, 12, 0, 14, 0, 14, 16, 0,
        18, 0, 18, 20, 0, 22, 22, 0, 24, 0,
        26, 26, 0, 28, 0, 0, 35, 0, 50, 0};
    /**
     * Os precos de compra dos lugares
     */
    private int[] precos_lugares_compra = {60, 0, 60, 0, 200, 100, 0, 100, 120, 0,
        140, 150, 140, 160, 200, 180, 0, 180, 200, 0,
        220, 0, 220, 240, 200, 260, 260, 150, 280, 0,
        300, 300, 0, 320, 200, 0, 350, 0, 400, 0};
    /**
     * Os precos de aluguel para uma única casa
     */
    private int[] precos_lugares_aluguel_1_casa = {10, 0, 20, 0, 0, 30, 0, 30, 40, 0,
        50, 0, 50, 60, 0, 70, 0, 70, 80, 0,
        90, 0, 90, 100, 0, 110, 110, 0, 120, 0,
        130, 130, 0, 150, 0, 0, 175, 0, 200, 0};
    /**
     * Os precos de aluguel para duas casas
     */
    private int[] precos_lugares_aluguel_2_casas = {30, 0, 60, 0, 0, 90, 0, 90, 100, 0,
        150, 0, 150, 180, 0, 200, 0, 200, 220, 0,
        250, 0, 250, 300, 0, 330, 330, 0, 360, 0,
        390, 390, 0, 450, 0, 0, 500, 0, 600, 0};
    /**
     * Os precos de aluguel para tres casas
     */
    private int[] precos_lugares_aluguel_3_casas = {90, 0, 180, 0, 0, 270, 0, 270, 300, 0,
        450, 0, 450, 500, 0, 550, 0, 550, 600, 0,
        700, 0, 700, 750, 0, 800, 800, 0, 850, 0,
        900, 900, 0, 1000, 0, 0, 1100, 0, 1400, 0};
    /**
     * Os precos de aluguel para quatro casas
     */
    private int[] precos_lugares_aluguel_4_casas = {160, 0, 320, 0, 0, 400, 0, 400, 450, 0,
        625, 0, 625, 700, 0, 750, 0, 750, 800, 0,
        875, 0, 875, 925, 0, 975, 975, 0, 1025, 0,
        1100, 1100, 0, 1200, 0, 0, 1300, 0, 1700, 0};
    /**
     * Os precos de aluguel para hotel
     */
    private int[] precos_lugares_aluguel_Hotel = {250, 0, 450, 0, 0, 550, 0, 550, 600, 0,
        750, 0, 750, 900, 0, 950, 0, 950, 1000, 0,
        1050, 0, 1050, 1100, 0, 1150, 1150, 0, 1200, 0,
        1275, 1275, 0, 1400, 0, 0, 1500, 0, 2000, 0};
    /**
     * Os precos de aluguel para uma hipoteca
     */
    private int[] precos_lugares_aluguel_Hipoteca = {
        30, 0, 30, 0, 100, 50, 0, 50, 60, 0,
        70, 75, 70, 80, 100, 90, 0, 90, 100, 0,
        110, 0, 110, 120, 100, 130, 130, 75, 140, 0,
        150, 130, 0, 160, 100, 0, 175, 0, 200, 0};
    /**
     * Os precos das casas
     */
    private int[] precos_da_casa = {
        50, 0, 50, 0, 0, 50, 0, 50, 50, 50, 0,
        100, 0, 100, 100, 0, 100, 0, 100, 100, 0,
        150, 0, 150, 150, 0, 150, 150, 0, 150, 0,
        200, 200, 0, 200, 0, 0, 200, 0, 200, 0};

    /**
     * Instancia um tabuleiro
     */
    public Tabuleiro() {

        for (int i = 0; i < this.nomes_lugares.length; i++) {
            this.add(new Lugar(i + 1, this.nomes_lugares[i], this.precos_lugares_compra[i], this.precos_lugares_aluguel[i]));
        }

    }

    /**
     * Obtem o nome de um lugar
     * @param placeID o id do lugar
     * @return o nome do lugar
     * @throws Exception
     */
    public String getPlaceName(int placeID) throws Exception {
        return this.getLugarById(placeID).getNome();

    }

    /**
     * Obtem um Lugar a partir do id
     * @param placeID o id
     * @return o Lugar
     * @throws Exception
     */
    public Lugar getLugarById(int placeID) throws Exception {


        if ((placeID < 1) || (placeID > this.size())) {
            throw new Exception("Place doesn't exist");
        } else {
            //atenção para o índice!
            return this.get(placeID - 1);
        }
    }

    /**
     * Obtem o grupo de um lugar pelo id
     * @param placeID id do lugar
     * @return o grupo
     * @throws Exception
     */
    public String getLugarGrupo(int placeID) throws Exception {
        return this.getLugarById(placeID).getGrupo(placeID);
    }

    /**
     * Obtem o preco do aluguel de um lugar pelo id
     * @param placeId id do lugar
     * @return o preco de aluguel
     * @throws Exception
     */
    public int getLugarPrecoAluguel(int placeId) throws Exception {
        if (placeId < 1 || placeId > 40) {
            throw new Exception("Place doesn't exist");
        } else {
            int preco = this.getLugarById(placeId).getPrecoAluguel();
            if (preco == 0) {
                throw new Exception("This place doesn't have a rent");
            } else {
                return preco;
            }

        }
    }

    /**
     * Obtem o preco de compra de um lugar pelo seu id
     * @param placeId o id
     * @return o preco de compra
     * @throws Exception
     */
    public int getLugarPrecoCompra(int placeId) throws Exception {
        if (placeId < 1 || placeId > 40) {
            throw new Exception("Place doesn't exist");
        } else {
            int preco = precos_lugares_compra[placeId - 1];
            if (preco == 0) {
                throw new Exception("This place can't be sold");
            } else {
                return preco;
            }

        }
    }
   /**
    * Retorna preco do aluguel sem casa
    * @param id
    * @return o valor
    */
    public int getPrecoAluguelSemCasa(int id) {
        return precos_lugares_aluguel[id - 1];
    }
    /**
     * Retorna preco do aluguel com uma casa
     * @param id
     * @return o valor
     */
    public int getPrecoAluguelUmaCasa(int id) {
        return precos_lugares_aluguel_1_casa[id - 1];
    }
    /**
     * Retorna o preco do aluguel com duas casas
     * @param id
     * @return o valor
     */
    public int getPrecoAluguelDuasCasas(int id) {
        return precos_lugares_aluguel_2_casas[id - 1];
    }
    /**
     * Retorna o preco do aluguel com tres casas
     * @param id
     * @return o valor
     */
    public int getPrecoAluguelTresCasas(int id) {
        return precos_lugares_aluguel_3_casas[id - 1];
    }
    /**
     * Retorna o preco do aluguel com quatro casas
     * @param id
     * @return o valor
     */
    public int getPrecoAluguelQuatroCasas(int id) {
        return precos_lugares_aluguel_4_casas[id - 1];
    }
    /**
     * Retorna o preco do aluguel com Hotel
     * @param id
     * @return o valor
     */
    public int getPrecoAluguelHotel(int id) {
        return precos_lugares_aluguel_Hotel[id - 1];
    }
    /**
     * Duplica o valor do aluguel no grupo
     * @param idPlace
     * @throws Exception
     */
    public void duplicarAluguelGrupo(int idPlace) throws Exception {
        if (idPlace == 1 || idPlace == 3) {
            this.getLugarById(1).setPrecoAluguel(this.getLugarById(1).getPrecoAluguel() * 2);
            this.getLugarById(3).setPrecoAluguel(this.getLugarById(3).getPrecoAluguel() * 2);
        } else if (idPlace == 6 || idPlace == 8 || idPlace == 9) {
            this.getLugarById(6).setPrecoAluguel(this.getLugarById(6).getPrecoAluguel() * 2);
            this.getLugarById(8).setPrecoAluguel(this.getLugarById(8).getPrecoAluguel() * 2);
            this.getLugarById(9).setPrecoAluguel(this.getLugarById(9).getPrecoAluguel() * 2);
        } else if (idPlace == 11 || idPlace == 13 || idPlace == 14) {
            this.getLugarById(11).setPrecoAluguel(this.getLugarById(11).getPrecoAluguel() * 2);
            this.getLugarById(13).setPrecoAluguel(this.getLugarById(13).getPrecoAluguel() * 2);
            this.getLugarById(14).setPrecoAluguel(this.getLugarById(14).getPrecoAluguel() * 2);
        } else if (idPlace == 16 || idPlace == 18 || idPlace == 19) {
            this.getLugarById(16).setPrecoAluguel(this.getLugarById(16).getPrecoAluguel() * 2);
            this.getLugarById(18).setPrecoAluguel(this.getLugarById(18).getPrecoAluguel() * 2);
            this.getLugarById(19).setPrecoAluguel(this.getLugarById(19).getPrecoAluguel() * 2);
        } else if (idPlace == 21 || idPlace == 23 || idPlace == 24) {
            this.getLugarById(21).setPrecoAluguel(this.getLugarById(21).getPrecoAluguel() * 2);
            this.getLugarById(23).setPrecoAluguel(this.getLugarById(23).getPrecoAluguel() * 2);
            this.getLugarById(24).setPrecoAluguel(this.getLugarById(24).getPrecoAluguel() * 2);
        } else if (idPlace == 26 || idPlace == 27 || idPlace == 29) {
            this.getLugarById(26).setPrecoAluguel(this.getLugarById(26).getPrecoAluguel() * 2);
            this.getLugarById(27).setPrecoAluguel(this.getLugarById(27).getPrecoAluguel() * 2);
            this.getLugarById(29).setPrecoAluguel(this.getLugarById(29).getPrecoAluguel() * 2);
        } else if (idPlace == 31 || idPlace == 32 || idPlace == 34) {
            this.getLugarById(31).setPrecoAluguel(this.getLugarById(31).getPrecoAluguel() * 2);
            this.getLugarById(32).setPrecoAluguel(this.getLugarById(32).getPrecoAluguel() * 2);
            this.getLugarById(34).setPrecoAluguel(this.getLugarById(34).getPrecoAluguel() * 2);
        } else if (idPlace == 37 || idPlace == 39) {
            this.getLugarById(37).setPrecoAluguel(this.getLugarById(37).getPrecoAluguel() * 2);
            this.getLugarById(39).setPrecoAluguel(this.getLugarById(39).getPrecoAluguel() * 2);
        }


    }
    /**
     * Verifica se pode vender imovel do terreno
     * @param idPlace
     * @return booleano
     * @throws Exception
     */
    public boolean verificaSePodeVenderImovelDoTerreno(int idPlace) throws Exception {


        //Grupo 1
        if (idPlace == 1 || idPlace == 3) {
            if (this.getLugarById(1).getNivel() == this.getLugarById(3).getNivel() && this.getLugarById(1).getNivel() != 0) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() > this.getLugarById(3).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(1).getNivel()) {
                return true;
            } else {
                return false;
            }

        } //Grupo 2
        else if (idPlace == 6 || idPlace == 8 || idPlace == 9) {
            if (this.getLugarById(6).getNivel() == this.getLugarById(8).getNivel() &&
                    this.getLugarById(6).getNivel() == this.getLugarById(9).getNivel() &&
                    this.getLugarById(6).getNivel() != 0) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() > this.getLugarById(6).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(8).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(9).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 3
        else if (idPlace == 11 || idPlace == 13 || idPlace == 14) {
            if (this.getLugarById(11).getNivel() == this.getLugarById(13).getNivel() &&
                    this.getLugarById(11).getNivel() == this.getLugarById(14).getNivel() &&
                    this.getLugarById(11).getNivel() != 0) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() > this.getLugarById(11).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(13).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(14).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 4
        else if (idPlace == 16 || idPlace == 18 || idPlace == 19) {
            if (this.getLugarById(16).getNivel() == this.getLugarById(18).getNivel() &&
                    this.getLugarById(16).getNivel() == this.getLugarById(19).getNivel() &&
                    this.getLugarById(16).getNivel() != 0) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() > this.getLugarById(16).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(18).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(19).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 5
        else if (idPlace == 21 || idPlace == 23 || idPlace == 24) {
            if (this.getLugarById(21).getNivel() == this.getLugarById(23).getNivel() &&
                    this.getLugarById(21).getNivel() == this.getLugarById(24).getNivel() &&
                    this.getLugarById(21).getNivel() != 0) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() > this.getLugarById(21).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(23).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(24).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 6
        else if (idPlace == 26 || idPlace == 27 || idPlace == 29) {
            if (this.getLugarById(26).getNivel() == this.getLugarById(27).getNivel() &&
                    this.getLugarById(26).getNivel() == this.getLugarById(29).getNivel() &&
                    this.getLugarById(26).getNivel() != 0) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() > this.getLugarById(26).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(27).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(29).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 7
        else if (idPlace == 31 || idPlace == 32 || idPlace == 34) {
            if (this.getLugarById(31).getNivel() == this.getLugarById(32).getNivel() &&
                    this.getLugarById(31).getNivel() == this.getLugarById(34).getNivel() &&
                    this.getLugarById(31).getNivel() != 0) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() > this.getLugarById(31).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(32).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(34).getNivel()) {
                return true;
            } else {
                return false;
            }
        }

        //Grupo 8
        if (idPlace == 37 || idPlace == 39) {
            if (this.getLugarById(37).getNivel() == this.getLugarById(39).getNivel() && this.getLugarById(1).getNivel() != 0) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() > this.getLugarById(37).getNivel() ||
                    this.getLugarById(idPlace).getNivel() > this.getLugarById(39).getNivel()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    /**
     * Verifica se pode construir no terreno
     * @param idPlace
     * @return booleano
     * @throws Exception
     */
    public boolean verificaSePodeConstruirNoTerreno(int idPlace) throws Exception {


        //Grupo 1
        if (idPlace == 1 || idPlace == 3) {
            if (this.getLugarById(1).getNivel() == this.getLugarById(3).getNivel() && this.getLugarById(1).getNivel() != 5) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() == 5) {
                throw new Exception("No further buildings on this property");
            } else if (this.getLugarById(idPlace).getNivel() < this.getLugarById(3).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(1).getNivel()) {
                return true;
            } else {
                return false;
            }

        } //Grupo 2
        else if (idPlace == 6 || idPlace == 8 || idPlace == 9) {
            if (this.getLugarById(6).getNivel() == this.getLugarById(8).getNivel() &&
                    this.getLugarById(6).getNivel() == this.getLugarById(9).getNivel() &&
                    this.getLugarById(6).getNivel() != 5) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() == 5) {
                throw new Exception("No further buildings on this property");
            } else if (this.getLugarById(idPlace).getNivel() < this.getLugarById(6).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(8).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(9).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 3
        else if (idPlace == 11 || idPlace == 13 || idPlace == 14) {
            if (this.getLugarById(11).getNivel() == this.getLugarById(13).getNivel() &&
                    this.getLugarById(11).getNivel() == this.getLugarById(14).getNivel() &&
                    this.getLugarById(11).getNivel() != 5) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() == 5) {
                throw new Exception("No further buildings on this property");
            } else if (this.getLugarById(idPlace).getNivel() < this.getLugarById(11).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(13).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(14).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 4
        else if (idPlace == 16 || idPlace == 18 || idPlace == 19) {
            if (this.getLugarById(16).getNivel() == this.getLugarById(18).getNivel() &&
                    this.getLugarById(16).getNivel() == this.getLugarById(19).getNivel() &&
                    this.getLugarById(16).getNivel() != 5) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() == 5) {
                throw new Exception("No further buildings on this property");
            } else if (this.getLugarById(idPlace).getNivel() < this.getLugarById(16).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(18).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(19).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 5
        else if (idPlace == 21 || idPlace == 23 || idPlace == 24) {
            if (this.getLugarById(21).getNivel() == this.getLugarById(23).getNivel() &&
                    this.getLugarById(21).getNivel() == this.getLugarById(24).getNivel() &&
                    this.getLugarById(21).getNivel() != 5) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() == 5) {
                throw new Exception("No further buildings on this property");
            } else if (this.getLugarById(idPlace).getNivel() < this.getLugarById(21).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(23).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(24).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 6
        else if (idPlace == 26 || idPlace == 27 || idPlace == 29) {
            if (this.getLugarById(26).getNivel() == this.getLugarById(27).getNivel() &&
                    this.getLugarById(26).getNivel() == this.getLugarById(29).getNivel() &&
                    this.getLugarById(26).getNivel() != 5) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() == 5) {
                throw new Exception("No further buildings on this property");
            } else if (this.getLugarById(idPlace).getNivel() < this.getLugarById(26).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(27).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(29).getNivel()) {
                return true;
            } else {
                return false;
            }
        } //Grupo 7
        else if (idPlace == 31 || idPlace == 32 || idPlace == 34) {
            if (this.getLugarById(31).getNivel() == this.getLugarById(32).getNivel() &&
                    this.getLugarById(31).getNivel() == this.getLugarById(34).getNivel() &&
                    this.getLugarById(31).getNivel() != 5) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() == 5) {
                throw new Exception("No further buildings on this property");
            } else if (this.getLugarById(idPlace).getNivel() < this.getLugarById(31).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(32).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(34).getNivel()) {
                return true;
            } else {
                return false;
            }
        }

        //Grupo 8
        if (idPlace == 37 || idPlace == 39) {
            if (this.getLugarById(37).getNivel() == this.getLugarById(39).getNivel() && this.getLugarById(1).getNivel() != 5) {
                return true;
            } else if (this.getLugarById(idPlace).getNivel() == 5) {
                throw new Exception("No further buildings on this property");
            } else if (this.getLugarById(idPlace).getNivel() < this.getLugarById(37).getNivel() ||
                    this.getLugarById(idPlace).getNivel() < this.getLugarById(39).getNivel()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    /**
     * Verifica se grupo ainda pode ter construcoes
     * @param idPlace
     * @return booleano
     * @throws Exception
     */
    public boolean verificaSeGrupoAindaPodeTerConstrucoes(int idPlace) throws Exception {
        if(aindaTemLugarParaConstruir(idPlace)){
            return true;
        }
        return false;
    }

    public boolean lugarExiste(int idPropriedade){
        return (idPropriedade >= 1 && idPropriedade <= 40) ? true : false;
    }

     /**
     * Retorna preco da hipoteca do lugar
     * @param id
     * @return o valor
     */
    public int getPrecoHipoteca(int id) {
        return precos_lugares_aluguel_Hipoteca[id - 1];
    }

    public Lugar getLugarPeloNome(String nome){
        for (Lugar lugar : this) {
            if(lugar.getNome().equalsIgnoreCase(nome)){
                return lugar;
            }
        }
        return null;
    }

     private boolean grupoTemHipoteca(int idPropriedade) throws Exception {
        String grupo = getLugarGrupo(idPropriedade);
        for (Lugar lugar : this) {
            if (lugar.getGrupo(lugar.getPosicao()).equals(grupo)) {
                if (lugar.estaHipotecada()) {
                   return true;
                }
            }
        }
        return false;
    }

    private boolean aindaTemLugarParaConstruir(int idPlace) throws Exception {
        if (idPlace == 1 || idPlace == 3) {
            if (this.getLugarById(1).getNivel() == 5 && this.getLugarById(3).getNivel() == 5) {
                return false;
            } else {
                return true;
            }
        } else if (idPlace == 6 || idPlace == 8 || idPlace == 9) {
            if (this.getLugarById(6).getNivel() == 5 && this.getLugarById(8).getNivel() == 5 && this.getLugarById(9).getNivel() == 5) {
                return false;
            } else {
                return true;
            }
        } else if (idPlace == 11 || idPlace == 13 || idPlace == 14) {
            if (this.getLugarById(11).getNivel() == 5 && this.getLugarById(13).getNivel() == 5 && this.getLugarById(14).getNivel() == 5) {
                return false;
            } else {
                return true;
            }
        } else if (idPlace == 16 || idPlace == 18 || idPlace == 19) {
            if (this.getLugarById(16).getNivel() == 5 && this.getLugarById(18).getNivel() == 5 && this.getLugarById(19).getNivel() == 5) {
                return false;
            } else {
                return true;
            }
        } else if (idPlace == 21 || idPlace == 23 || idPlace == 24) {
            if (this.getLugarById(21).getNivel() == 5 && this.getLugarById(23).getNivel() == 5 && this.getLugarById(24).getNivel() == 5) {
                return false;
            } else {
                return true;
            }
        } else if (idPlace == 26 || idPlace == 27 || idPlace == 29) {
            if (this.getLugarById(26).getNivel() == 5 && this.getLugarById(27).getNivel() == 5 && this.getLugarById(29).getNivel() == 5) {
                return false;
            } else {
                return true;
            }
        } else if (idPlace == 31 || idPlace == 32 || idPlace == 34) {
            if (this.getLugarById(31).getNivel() == 5 && this.getLugarById(32).getNivel() == 5 && this.getLugarById(34).getNivel() == 5) {
                return false;
            } else {
                return true;
            }
        } else if (idPlace == 37 || idPlace == 39) {
            if (this.getLugarById(37).getNivel() == 5 && this.getLugarById(39).getNivel() == 5) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }



}
