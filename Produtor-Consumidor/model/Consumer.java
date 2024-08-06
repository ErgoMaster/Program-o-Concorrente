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
            try { sleep(velocidade + 100); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.consumir(); // Consome item

            Buffer.changeConsumiuImage(1); // Modifica o image view da exclacao para opacidade 100%
            try { sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.changeConsumiuImage(2); // Modifica o image view da exclacao para opacidade 20%

            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    } // End run
} // End class Consumer
