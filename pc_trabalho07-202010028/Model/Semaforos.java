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
    private static Semaphore[] semaforosRuasHorizontais = new Semaphore[30];
    private static Semaphore[] semaforosRuasVerticais = new Semaphore[30];
    private static Semaphore[] semaforosCruzamentos = new Semaphore[36];
     
    // Contrutor
    public Semaforos() {
        // Inicializacao dos semaforos
        for(int i = 0; i < 30; i++) {
            semaforosRuasHorizontais[i] = new Semaphore(1);
        } // Fim do for das ruas horizontais

        for(int i = 0; i < 30; i++) {
            semaforosRuasVerticais[i] = new Semaphore(1);
        } // Fim do for das ruas verticais

        for(int i = 0; i < 30; i++) {
            semaforosCruzamentos[i] = new Semaphore(1);
        } // Fim do for dos cruzamentos
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
}
