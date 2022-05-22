/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Semaforos
* Funcao...........: Detem os semaforos que serao utilizados no programa
*************************************************************** */

package Model;

import java.util.concurrent.Semaphore;

public class Semaforos {
    private static Semaphore[] semaforosRuasHorizontais = new Semaphore[30]; // Semaforos para controle das ruas horizontais
    private static Semaphore[] semaforosRuasVerticais = new Semaphore[30]; // Semaforos para controle das ruas verticais
    private static Semaphore[] semaforosCruzamentos = new Semaphore[36]; // Semaforos para controle dos cruzamentos
    
    private static Semaphore semaforoAzulRoxo = new Semaphore(1); // Semaforo que controla a regiao critica entre os carros Azul e Roxo
    private static Semaphore semaforoAzulVerde = new Semaphore(1); // Semaforo que controla a regiao critica entre os carros Azul e Verde
    private static Semaphore semaforoLaranjaVerde = new Semaphore(1); // Semaforo que controla a regiao critica entre os carros Laranja e Verde
    private static Semaphore[] semaforosAmareloAzul = new Semaphore[3]; // Semaforos que controlam as regioes criticas entre os carros Amarelo e Azul
    private static Semaphore semaforoAmareloLaranja = new Semaphore(1); // Semaforo que controla a regiao critica entre os carros Amarelo e Laranja
    private static Semaphore semaforoAmareloPreto = new Semaphore(1); // Semaforo que controla a regiao critica entre os carros Amarelo e Preto
    private static Semaphore[] semaforosAmareloRoxo = new Semaphore[2]; // Semaforos que controlam as regioes criticas entre os carros Amarelo e Roxo
     
    // Contrutor
    public Semaforos() {
        // Inicializacao dos semaforos
        for(int i = 0; i < 30; i++) {
            semaforosRuasHorizontais[i] = new Semaphore(1);
        } // Fim do for das ruas horizontais

        for(int i = 0; i < 30; i++) {
            semaforosRuasVerticais[i] = new Semaphore(1);
        } // Fim do for das ruas verticais

        for(int i = 0; i < 36; i++) {
            semaforosCruzamentos[i] = new Semaphore(1);
        } // Fim do for dos cruzamentos

        for(int i = 0; i < 3; i++) {
            semaforosAmareloAzul[i] = new Semaphore(1);
        } // Fim do for dos semaforos Amarelo com Azul

        for(int i = 0; i < 2; i++) {
            semaforosAmareloRoxo[i] = new Semaphore(1);
        } // Fim do for dos semaforos Amarelo com Roxo
    } // Fim do construtor

    /* ***************************************************************
    * Metodo: getSemaforosRuasHorizontais
    * Funcao: Retorna os semaforos correspondentes as ruas horizontais
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforoRuasHorizontais(int index) { return semaforosRuasHorizontais[index - 1]; } 

    /* ***************************************************************
    * Metodo: getSemaforosRuasVerticais
    * Funcao: Retorna os semaforos correspondentes as ruas verticais
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforoRuasVerticais(int index) { return semaforosRuasVerticais[index - 1]; } 

    /* ***************************************************************
    * Metodo: getSemaforosRuasCruzamentos
    * Funcao: Retorna os semaforos correspondentes aos cruzamentos
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforoCruzamentos(int index) { return semaforosCruzamentos[index - 1]; } 

    /* ***************************************************************
    * Metodo: getSemaforoAzulRoxo
    * Funcao: Retorna o semaforo que controla a regiao critica dos carros Azul e Roxo
    * Parametros: Void
    * Retorno: O semaforo desejado
    *************************************************************** */
    public static Semaphore getSemaforoAzulRoxo() { return semaforoAzulRoxo; }

    /* ***************************************************************
    * Metodo: getSemaforoAzulVerde
    * Funcao: Retorna o semaforo que controla a regiao critica dos carros Azul e Verde
    * Parametros: Void
    * Retorno: O semaforo desejado
    *************************************************************** */
    public static Semaphore getSemaforoAzulVerde() { return semaforoAzulVerde; }

    /* ***************************************************************
    * Metodo: getSemaforoLaranjaVerde
    * Funcao: Retorna o semaforo que controla a regiao critica dos carros Laranja e Verde
    * Parametros: Void
    * Retorno: O semaforo desejado
    *************************************************************** */
    public static Semaphore getSemaforoLaranjaVerde() { return semaforoLaranjaVerde; }

    /* ***************************************************************
    * Metodo: getSemaforosAmareloAzul
    * Funcao: Retorna os semaforos que controlam as regioes criticas dos carros Amarelo e Azul
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforosAmareloAzul(int index) { return semaforosAmareloAzul[index - 1]; } 

    /* ***************************************************************
    * Metodo: getSemaforoAmareloLaranja
    * Funcao: Retorna o semaforo que controla a regiao critica dos carros Amarelo e Laranja
    * Parametros: Void
    * Retorno: O semaforo desejado
    *************************************************************** */
    public static Semaphore getSemaforoAmareloLaranja() { return semaforoAmareloLaranja; }

    /* ***************************************************************
    * Metodo: getSemaforoAmareloPreto
    * Funcao: Retorna o semaforo que controla a regiao critica dos carros Amarelo e Preto
    * Parametros: Void
    * Retorno: O semaforo desejado
    *************************************************************** */
    public static Semaphore getSemaforoAmareloPreto() { return semaforoAmareloPreto; }

    /* ***************************************************************
    * Metodo: getSemaforosAmareloRoxo
    * Funcao: Retorna os semaforos que controlam as regioes criticas dos carros Amarelo e Roxo
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforoAmareloRoxo(int index) { return semaforosAmareloRoxo[index - 1]; } 
}
