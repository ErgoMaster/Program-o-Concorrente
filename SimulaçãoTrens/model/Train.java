/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 30/07/2024
* Nome.............: Train
* Funcao...........: Modify the trains position in the simulation
*************************************************************** */
package model;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Train extends Thread {
    private ImageView model; // Image view que sera movido
    private int speed; // Velocidade da animacao
    private double x; // Posicao x do image view

    // Construtor 
    public Train(ImageView model, int speed) {
        this.model = model;
        this.speed = speed;

        x = model.getLayoutX();
    } // End constructor

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    @Override
    public void run() {
        double animationDuration = Math.ceil(-100.0 / 3.0 * speed + 16000.0 / 3.0);

        try {
            // All sleep function wait the animation to finish so the next one starts
            moveTrainHorizontally(animationDuration);
            Thread.sleep((long) animationDuration + 100);

            // Critical region
            Semaphores.getMutex().acquire(); 
            moveTrainIntoCriticalRegion(animationDuration);
            Thread.sleep((long) animationDuration + 100);
            moveTrainHorizontally(animationDuration);
            Thread.sleep((long) animationDuration + 100);
            Semaphores.getMutex().release(); 

            moveTrainOutCriticalRegion(animationDuration);
            Thread.sleep((long) animationDuration + 100);
            moveTrainHorizontally(animationDuration);
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } // End try/catch
    } // End run

    /* ***************************************************************
    * Metodo: moveTrainHorizontally
    * Funcao: Moce the train in x coordinates
    * Parametros: animationDuration= The duration of the current animation
    * Retorno: Void
    *************************************************************** */
    public void moveTrainHorizontally(double animationDuration) {
        Platform.runLater(() -> {
            TranslateTransition animation = new TranslateTransition(Duration.millis(animationDuration));
            animation.setNode(model); // Set the animation image
            animation.setCycleCount(1); // The animation occours one single time

            animation.setByX(getHorizontalAnimationValue(x)); 
            animation.play();
        });
    } // End moveTrainHorizontally

    /* ***************************************************************
    * Metodo: moveIntoCriticalRegion
    * Funcao: Moce the train in x and y coordinates
    * Parametros: animationDuration= The duration of the current animation
    * Retorno: Void
    *************************************************************** */
    public void moveTrainIntoCriticalRegion(double animationDuration) {
        Platform.runLater(() -> {
            TranslateTransition animation = new TranslateTransition(Duration.millis(animationDuration));
            animation.setNode(model); // Set the animation image
            animation.setCycleCount(1); // The animation occours one single time

            animation.setByX(getDiagonalAnimationValue(x)); 
            animation.setByY(60);
            animation.play();
        });
    } // End moveTrainIntoCriticalRegion

    /* ***************************************************************
    * Metodo: moveOutCriticalRegion
    * Funcao: Moce the train in x and y coordinates
    * Parametros: animationDuration= The duration of the current animation
    * Retorno: Void
    *************************************************************** */
    public void moveTrainOutCriticalRegion(double animationDuration) {
        Platform.runLater(() -> {
            TranslateTransition animation = new TranslateTransition(Duration.millis(animationDuration));
            animation.setNode(model); // Set the animation image
            animation.setCycleCount(1); // The animation occours one single time

            animation.setByX(getDiagonalAnimationValue(x));
            animation.setByY(50); 
            animation.play();
        });
    } // End moveTrainOoutCriticalRegion

    /* ***************************************************************
    * Metodo: getHorizontalAnimationValue
    * Funcao: Give the correct value for the animation given the train position
    * Parametros: x= the train x value
    * Retorno: Void
    *************************************************************** */
    public double getHorizontalAnimationValue(double x) {
        // if its the train1, return 130, if its the train2, return -130
        return x == 94 ? 130 : -130;
    } // End getHorizontalAnimationValue

    /* ***************************************************************
    * Metodo: getDiagonalAnimationValue
    * Funcao: Give the correct value for the animation given the train position
    * Parametros: x= the train x value
    * Retorno: Void
    *************************************************************** */
    public double getDiagonalAnimationValue(double x) {
        // if its the train1, return 120, if its the train2, return -120
        return x == 94 ? 120 : -120;
    } // End getDiagonalAnimationValue
} // End class train
