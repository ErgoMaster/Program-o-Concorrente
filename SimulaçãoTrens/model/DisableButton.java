/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 30/07/2024
* Nome.............: DisableButton
* Funcao...........: Disable the start button while the simulation is running
*************************************************************** */
package model;

import javafx.scene.control.Button;

public class DisableButton extends Thread {
    Button button; 

    // Constructor
    public DisableButton(Button button) {
        this.button = button;
    } // End constructor

    /* ***************************************************************
    * Metodo: run
    * Funcao: Thread start
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    @Override
    public void run() {
        button.setDisable(true); // Disable the button

        // Try to access the semaphore, this semapohore will be released when the animation ends
        try { 
            Semaphores.getDisableButton().acquire(); 
        } 
        catch (InterruptedException e) { 
            e.printStackTrace(); 
        } // End try/catch

        button.setDisable(false); // Able the button

        Semaphores.getDisableButton().release(); // Release the sempahore so the animation can occours again
    } // End run
} // End class DisableButton
