/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 06/08/2024
* Nome.............: Consumer
* Funcao...........: Consumer Thread 
*************************************************************** */
package model;

public class Consumer extends Thread {
    private int speed;

    // Constructor
    public Consumer(int speed) {
        this.speed = speed;
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Thread start
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    @Override
    public void run() {
        while(true) {
            try {
                sleep(speed);
                consume();
                sleep(speed);
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } // End try/catch
        } // End while
    } // End run

    /* ***************************************************************
    * Metodo: consume
    * Funcao: Update UI and remove a package from stack
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void consume() {
        try { 
            Buffer.getFullSemaphore().acquire(); // Reduce a value from semaphore to block the producer if necessary
            Buffer.getMutexSemaphore().acquire(); // Block critical region

            Buffer.getStack().pop();
            Buffer.animateConsumption();
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } finally {
            Buffer.getEmptySemaphore().release(); // Increase a value from semaphore to block itself if necessary
            Buffer.getMutexSemaphore().release(); // Release critical region
        } // End try/catch  
    } // End consume
} // End class Consumer
