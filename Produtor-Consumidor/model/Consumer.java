/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 06/08/2024
* Nome.............: Consumer
* Funcao...........: Consumer Thread 
*************************************************************** */
package model;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import view.ProducerConsumerController;

public class Consumer extends Thread {
    private int speed;
    private ImageView consumerImageView;

    // Constructor
    public Consumer(int speed,  ImageView consumerImageView) {
        this.speed = (int) Math.ceil(-100.0 / 3.0 * speed + 16000.0 / 3.0);
        this.consumerImageView = consumerImageView;
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
                sleep(speed);
                consume();
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
    public void consume() {
        try { 
            Buffer.getFullSemaphore().acquire(); // Reduce a value from semaphore to block the producer if necessary
            Buffer.getMutexSemaphore().acquire(); // Block critical region

            Buffer.getStack().pop();
            animateConsumption();
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } finally {
            Buffer.getEmptySemaphore().release(); // Increase a value from semaphore to block itself if necessary
            Buffer.getMutexSemaphore().release(); // Release critical region
        } // End try/catch  
    } // End consume

    /* ***************************************************************
    * Metodo: animateConsumption
    * Funcao: Move the package from the stack to the consumer
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void animateConsumption() {
        Platform.runLater(() -> {
            consumerImageView.setVisible(true);

            TranslateTransition animation = new TranslateTransition(Duration.millis(2000));
            animation.setNode(consumerImageView); // Set the animation image
            animation.setCycleCount(1); // The animation occours one single time

            animation.setByX(300); 
            animation.setOnFinished(event -> { 
                // Update counter label and return imageview to original position
                consumerImageView.setVisible(false);
                consumerImageView.setTranslateX(0);
                consumerImageView.setTranslateY(0);
                ProducerConsumerController.updatePackagesLabel();
            });
            
            animation.play();
        });
    } // End animateConsumption
} // End class Consumer
