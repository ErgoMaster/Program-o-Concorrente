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
    private static Semaphore[] semaforosAAM = new Semaphore[2]; // Semaforos para controlar as regioes criticas dos carros Azul e Amarelo
    private static Semaphore[] semaforosAL = new Semaphore[3]; // Semaforos para controlar as regioes criticas dos carros Azul e Laranja
    private static Semaphore semaforoAML = new Semaphore(0); // Semaforos para controlar as regioes criticas dos carros Amarelo e Laranja
    private static Semaphore semaforoAP = new Semaphore(1); // Semaforos para controlar as regioes criticas dos carros Azul e Preto
    private static Semaphore[] semaforosAMP = new Semaphore[2]; // Semaforos para controlar as regioes criticas dos carros Amarelo e Preto
    private static Semaphore[] semaforosAR = new Semaphore[3]; // Semaforos para controlar as regioes criticas dos carros Azul e Roxo
    private static Semaphore[] semaforosLR = new Semaphore[3]; // Semaforos para controlar as regioes criticas dos carros Laranja e Roxo
    private static Semaphore[] semaforosAMR = new Semaphore[3]; // Semaforos para controlar as regioes criticas dos carros Amarelo e Roxo
    private static Semaphore[] semaforosPR = new Semaphore[3]; // Semaforos para controlar as regioes criticas dos carros Preto e Roxo
     
    // Contrutor
    public Semaforos() {
        // Inicializacao dos semaforos
        for(int i = 0; i < 2; i++) {
            semaforosAAM[i] = new Semaphore(1);
        } // Fim do for do semaforo Azul e Amarelo

        for(int i = 0; i < 3; i++) {
            semaforosAL[i] = new Semaphore(1);
        } // Fim do for do semaforo Azul e Laranja

        for(int i = 0; i < 2; i++) {
            semaforosAMP[i] = new Semaphore(1);
        } // Fim do for do semaforo Amarelo e Preto

        for(int i = 0; i < 3; i++) {
            semaforosAR[i] = new Semaphore(1);
        } // Fim do for do semaforo Azul e Roxo

        for(int i = 0; i < 3; i++) {
            semaforosLR[i] = new Semaphore(1);
        } // Fim do for do semaforo Laranja e Roxo

        for(int i = 0; i < 3; i++) {
            semaforosAMR[i] = new Semaphore(1);
        } // Fim do for do semaforo Amarelo e Roxo

        for(int i = 0; i < 3; i++) {
            semaforosPR[i] = new Semaphore(1);
        } // Fim do for do semaforo Preto e Roxo
    } // Fim do construtor

    /* ***************************************************************
    * Metodo: getSemaforosAAM
    * Funcao: Retorna o semaforo das regioes criticas dos carros Azul e Amarelo
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforoAAM(int index) { return semaforosAAM[index - 1]; }

    /* ***************************************************************
    * Metodo: getSemaforosAL
    * Funcao: Retorna o semaforo das regioes criticas dos carros Azul e Laranja
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforoAL(int index) { return semaforosAL[index - 1]; }

    /* ***************************************************************
    * Metodo: getSemaforosAML
    * Funcao: Retorna o semaforo das regioes criticas dos carros Amarelo e Laranja
    * Parametros: Void
    * Retorno: O semaforo desejado
    *************************************************************** */
    public static Semaphore getSemaforoAML() { return semaforoAML; }

    /* ***************************************************************
    * Metodo: getSemaforosAP
    * Funcao: Retorna o semaforo das regioes criticas dos carros Azul e Preto
    * Parametros: Void
    * Retorno: O semaforo desejado
    *************************************************************** */
    public static Semaphore getSemaforoAP() { return semaforoAP; }

    /* ***************************************************************
    * Metodo: getSemaforosAMP
    * Funcao: Retorna o semaforo das regioes criticas dos carros Amarelo e Preto
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforoAMP(int index) { return semaforosAMP[index - 1]; }

    /* ***************************************************************
    * Metodo: getSemaforosAR
    * Funcao: Retorna o semaforo das regioes criticas dos carros Azul e Roxo
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforosAR(int index) { return semaforosAR[index - 1]; }

    /* ***************************************************************
    * Metodo: getSemaforosLR
    * Funcao: Retorna o semaforo das regioes criticas dos carros Laranja e Roxo
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforosLR(int index) { return semaforosLR[index - 1]; }

    /* ***************************************************************
    * Metodo: getSemaforosAMR
    * Funcao: Retorna o semaforo das regioes criticas dos carros Amarelo e Roxo
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforosAMR(int index) { return semaforosAMR[index - 1]; }

    /* ***************************************************************
    * Metodo: getSemaforosPR
    * Funcao: Retorna o semaforo das regioes criticas dos carros Preto e Roxo
    * Parametros: O index que indica o semaforo desejado
    * Retorno: Um semaforo dado o index
    *************************************************************** */
    public static Semaphore getSemaforosPR(int index) { return semaforosPR[index - 1]; }
}
