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
    private static Semaphore[] semaforosAAM = new Semaphore[2];
    private static Semaphore[] semaforosAL = new Semaphore[3];
    private static Semaphore semaforoAML = new Semaphore(0);
    
    public Semaforos() {
        for(int i = 0; i < 2; i++) {
            semaforosAAM[i] = new Semaphore(1);
        }

        for(int i = 0; i < 3; i++) {
            semaforosAL[i] = new Semaphore(1);
        }
    }

    public static Semaphore getSemaforoAAM(int index) { return semaforosAAM[index - 1]; }
    public static Semaphore getSemaforoAL(int index) { return semaforosAL[index - 1]; }
    public static Semaphore getSemaforoAML() { return semaforoAML; }
}
