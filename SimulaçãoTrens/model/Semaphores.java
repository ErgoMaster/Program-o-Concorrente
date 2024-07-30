/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 30/07/2024
* Nome.............: Semaphores
* Funcao...........: Stores the semaphores that will be used in the simulation
*************************************************************** */
package model;

import java.util.concurrent.Semaphore;

public class Semaphores {
    private static Semaphore mutex = new Semaphore(1); // Semaphore to control the train critical region
    private static Semaphore disableButton = new Semaphore(1); // Semaphores to controle the button disable

    /* ***************************************************************
    * Metodo: getMutex
    * Funcao: Get the mutex semaphore
    * Parametros: void
    * Retorno: The semaphore
    *************************************************************** */
    public static Semaphore getMutex() { 
        return mutex; 
    } // End getMutex

    /* ***************************************************************
    * Metodo: getDisableButton
    * Funcao: Get the disableButton semaphore
    * Parametros: void
    * Retorno: The semaphore
    *************************************************************** */
    public static Semaphore getDisableButton() { 
        return disableButton; 
    } // End getDisableButton
} // End class Semaphores
