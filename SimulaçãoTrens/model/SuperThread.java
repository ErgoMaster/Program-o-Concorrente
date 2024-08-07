/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 30/07/2024
* Nome.............: SuperThread
* Funcao...........: Start all threads of the simulation
*************************************************************** */
package model;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SuperThread extends Thread {
    // Trains image view
    private ImageView train1ImageView;
    private ImageView train2ImageView;

    // Trains speed
    private int speedTrain1;
    private int speedTrain2;

    // Main button
    private Button startButton;

    // Constructor
    public SuperThread(ImageView train1ImageView, ImageView train2ImageView, int speedTrain1, int speedTrain2, Button startButton) {
        this.train1ImageView= train1ImageView;
        this.train2ImageView= train2ImageView;
        this.speedTrain1 = speedTrain1;
        this.speedTrain2 = speedTrain2;
        this.startButton = startButton;
    } // End constructor

    /* ***************************************************************
    * Metodo: run
    * Funcao: Thread start
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    @Override
    public void run() {
        // Block button semaphore
        try { 
            Semaphores.getDisableButton().acquire(); 
        } 
        catch (InterruptedException e) { 
            e.printStackTrace(); 
        } // End try/catch

        // Threads criation and initilization
        Train train1 = new Train(train1ImageView, speedTrain1);
        Train train2 = new Train(train2ImageView, speedTrain2);
        DisableButton disableButton = new DisableButton(startButton);

        disableButton.start();
        train1.start();
        train2.start();

        try {
            // Wait for train threads to finish so the start button can be released
            train1.join();
            train2.join();
            Semaphores.getDisableButton().release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // End try/catch
    } // End run
} // End class SuperThread
