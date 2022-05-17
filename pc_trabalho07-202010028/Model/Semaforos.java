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
    private static Semaphore[] semaforosCruzamentos = new Semaphore[36];

    public Semaforos() {
        for(int i = 0; i < 36; i++) {
            semaforosCruzamentos[i] = new Semaphore(1);
        }
    }

    public static Semaphore getSemaforo(int index) { return semaforosCruzamentos[index - 1]; }
}
