/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 06/08/2024
* Nome.............: Producer
* Funcao...........: Producer Thread
*************************************************************** */
package model;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import view.ProducerConsumerController;

public class Producer extends Thread {
    private int speed; 
    private ImageView producerImageView;

    // Constructor
    public Producer(int speed, ImageView producerImageView) {
        this.speed = (int) Math.ceil(-100.0 / 3.0 * speed + 16000.0 / 3.0);
        this.producerImageView = producerImageView;
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
    public void produce() {
        try {
            Buffer.getEmptySemaphore().acquire(); // Reduce a value from semaphore to block the consumer if necessary
            Buffer.getMutexSemaphore().acquire(); // Block critical region

            Buffer.getStack().push(1);
            animateProduction();
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } finally { 
            Buffer.getFullSemaphore().release(); // Increase a value from semaphore to block itself if necessary
            Buffer.getMutexSemaphore().release(); // Release critical region
        } // End try/catch       
    } // End produce

    /* ***************************************************************
    * Metodo: animateProduction
    * Funcao: Move the package from the productor to the stack
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void animateProduction() {
        Platform.runLater(() -> {
            producerImageView.setVisible(true);

            TranslateTransition animation = new TranslateTransition(Duration.millis(2000));
            animation.setNode(producerImageView); // Set the animation image
            animation.setCycleCount(1); // The animation occours one single time

            animation.setByX(300); 
            animation.setOnFinished(event -> { 
                // Update counter label and return imageview to original position
                producerImageView.setVisible(false);
                producerImageView.setTranslateX(0);
                producerImageView.setTranslateY(0);
                ProducerConsumerController.updatePackagesLabel();
            });
            
            animation.play();
        });
    } // End animateProduction
} // End class producer
