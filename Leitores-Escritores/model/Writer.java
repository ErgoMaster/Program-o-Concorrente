/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: 07/08/2024
* Nome.............: Writer
* Funcao...........: Update database
*************************************************************** */
package model;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Writer extends Thread {
    private Label label;
    
    // Constructor
    public Writer(Label label) {
        this.label = label;
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
                updateLabel("Escritor está escrevendo");
                sleep(4000);

                Buffer.getDataSemaphore().acquire(); // Lock database
                Buffer.updateDatabase(); // Write in it
                Buffer.getDataSemaphore().release(); // Realease database

                updateLabel("Banco de dados atualizado");
                sleep(2000);
                updateLabel("Stand by");
                sleep(2000);
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } // End try/catch
        }  // End while
    } // End run

    /* ***************************************************************
    * Metodo: updateLabel
    * Funcao: Update a correspodent reader lebel
    * Parametros: text= The string the label will receive
    * Retorno: void
    *************************************************************** */
    public void updateLabel(String text) {
        Platform.runLater(() -> {
            label.setText(text);
        });
    } // End updateLabel
} // End class Writer
