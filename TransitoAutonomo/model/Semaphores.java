/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: 12/08/2024
* Nome.............: Semaphores
* Funcao...........: Stores all semaphores used in programs
*************************************************************** */
package model;

import java.util.concurrent.Semaphore;

public class Semaphores {    
    private static Semaphore[] semaphoreBlueYellow = new Semaphore[3]; 
    private static Semaphore semaphoreBlueBlack = new Semaphore(1); 
    private static Semaphore semaphoreBluePurple = new Semaphore(1); 
    private static Semaphore semaphoreBluePurpleBlack = new Semaphore(1);
    private static Semaphore semaphoreOrangeYellow = new Semaphore(1); 
    private static Semaphore semaphoreYellowBlack = new Semaphore(1); 
    private static Semaphore[] semaphoreYellowPurple = new Semaphore[2]; 

    // Contructor
    public Semaphores() {
        // Initialize semaphores arrays
        for(int i = 0; i < 2; i++) {
            semaphoreYellowPurple[i] = new Semaphore(1);
        }

        for(int i = 0; i < 3; i++) {
            semaphoreBlueYellow[i] = new Semaphore(1);
        }
    } // End constructor 
    
    /* ***************************************************************
    * Metodo: getSemaphoreBluePurple
    * Funcao: Return a specific semaphore
    * Parametros: Void
    * Retorno: A semaphore
    *************************************************************** */
    public static Semaphore getSemaphoreBluePurple() { 
        return semaphoreBluePurple; 
    } // End getSemaphoreBluePurple

    /* ***************************************************************
    * Metodo: getSemaphoreBluePurpleBlack
    * Funcao: Return a specific semaphore
    * Parametros: Void
    * Retorno: A semaphore
    *************************************************************** */
    public static Semaphore getSemaphoreBluePurpleBlack() { 
        return semaphoreBluePurpleBlack; 
    } // End getSemaphoreBluePurpleBlack

    /* ***************************************************************
    * Metodo: getSemaphoreBlueYellow
    * Funcao: Return a specific semaphore
    * Parametros: Index of desired semaphore
    * Retorno: A semaphore
    *************************************************************** */
    public static Semaphore getSemaphoreBlueYellow(int index) { 
        return semaphoreBlueYellow[index - 1]; 
    } // End getSemaphoreBlueYellow

    /* ***************************************************************
    * Metodo: getSemaphoreBlueBlack
    * Funcao: Return a specific semaphore
    * Parametros: Void
    * Retorno: A semaphore
    *************************************************************** */
    public static Semaphore getSemaphoreBlueBlack() { 
        return semaphoreBlueBlack; 
    } // End getSemaphoreBlueBlack

    /* ***************************************************************
    * Metodo: getSemaphoreOrangeYellow
    * Funcao: Return a specific semaphore
    * Parametros: Void
    * Retorno: A semaphore
    *************************************************************** */
    public static Semaphore getSemaphoreOrangeYellow() { 
        return semaphoreOrangeYellow; 
    } // End getSemaphoreOrangeYellow

    /* ***************************************************************
    * Metodo: getSemaphoreYellowBlack
    * Funcao: Return a specific semaphore
    * Parametros: Index of desired semaphore
    * Retorno: A semaphore
    *************************************************************** */
    public static Semaphore getSemaphoreYellowBlack() { 
        return semaphoreYellowBlack; 
    } // End getSemaphoreYellowBlack

    /* ***************************************************************
    * Metodo: getSemaphoreYellowPurple
    * Funcao: Return a specific semaphore
    * Parametros: Index of desired semaphore
    * Retorno: A semaphore
    *************************************************************** */
    public static Semaphore getSemaphoreYellowPurple(int index) { 
        return semaphoreYellowPurple[index - 1]; 
    } // End getSemaphoreYellowPurple
} // End class Semaphoress
