/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 06/08/2024
* Ultima alteracao.: 07/08/2024
* Nome.............: Reader
* Funcao...........: Reads a shared database
*************************************************************** */
package model;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Reader extends Thread {
    private int id;
    private ArrayList<Label> labels;
    
    // Constructor
    public Reader(int id, ArrayList<Label> labels) {
        this.id = id;
        this.labels = labels;
    } // End constructor

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
                Buffer.getMutexSemaphore().acquire(); // Lock critical region
                Buffer.increaseReadersControl(); // Add a reader
                if(Buffer.getReadersControl() == 1) { // Verify of it is the first reader
                    Buffer.getDataSemaphore().acquire(); // Lock database
                } // End if
                Buffer.getMutexSemaphore().release(); // Release critical region

                updateLabel("Leitor está mandando uma request");
                sleep(1000);
                
                Buffer.createRequest();

                Buffer.getMutexSemaphore().acquire(); // Lock critical region
                Buffer.decreaseReadersControl(); // Remove a reader
                if(Buffer.getReadersControl() == 0) { // Verify of it is the last reader
                    Buffer.getDataSemaphore().release(); // Release database
                } // End if
                Buffer.getMutexSemaphore().release();

                updateLabel("Stand by");
                sleep(5000);
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } // End try/catch
        } // End while
    } // End run

    /* ***************************************************************
    * Metodo: updateLabel
    * Funcao: Update a correspodent reader lebel
    * Parametros: text= The string the label will receive
    * Retorno: void
    *************************************************************** */
    public void updateLabel(String text) {
        Platform.runLater(() -> {
            labels.get(id - 1).setText(text);
        });
    } // End updateLabel
} // Enc class Reader
