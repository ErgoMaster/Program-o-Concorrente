/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Semaforo
* Funcao...........: Detem as variaveis estaticas que serao usadas em comum pelas threads do programa
*************************************************************** */

package Model;

import java.util.concurrent.Semaphore;

public class Semaforo {
    private static Semaphore mutex = new Semaphore(1); // Semaforo para que os trens nao passem ao mesmo tempo na regiao critica
    private static Semaphore disableButton = new Semaphore(1); // Semaforo para controlar quando o botao sera habilitado ou desabilitado

    // Metodos get
    public static Semaphore getMutex() { return mutex; }
    public static Semaphore getDisableButton() { return disableButton; }
}
