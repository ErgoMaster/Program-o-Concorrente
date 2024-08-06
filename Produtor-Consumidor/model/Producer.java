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
        for(int i = 0; i < numeroDeLivros; i++) {
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.produzir(); // Produz item
            
            Buffer.changeProduziuImage(1); // Modifica o image view da exclacao para opacidade 100%
            try { sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.changeProduziuImage(2); // Modifica o image view da exclacao para opacidade 20%
            
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    } // End run
} // End class producer
