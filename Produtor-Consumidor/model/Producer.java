/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 06/08/2024
* Nome.............: Producer
* Funcao...........: Producer Thread
*************************************************************** */
package model;

public class Producer extends Thread {
    private int speed; 

    // Constructor
    public Producer(int speed) {
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
                produce();
                sleep(speed);
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } // End try/catch
        } // End while
    } // End run

    /* ***************************************************************
    * Metodo: produce
    * Funcao: Update UI and add a package to stack
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void produce() {
        try {
            Buffer.getEmptySemaphore().acquire(); // Reduce a value from semaphore to block the consumer if necessary
            Buffer.getMutexSemaphore().acquire(); // Block critical region

            Buffer.getStack().push(1);
            Buffer.animateProduction();
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } finally { 
            Buffer.getFullSemaphore().release(); // Increase a value from semaphore to block itself if necessary
            Buffer.getMutexSemaphore().release(); // Release critical region
        } // End try/catch       
    } // End produce
} // End class producer
