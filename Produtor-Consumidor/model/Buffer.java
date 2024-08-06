/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 06/08/2024
* Nome.............: Buffer
* Funcao...........: Store the stack that will be used in simulation
*************************************************************** */
package model;

import java.util.Stack;
import java.util.concurrent.Semaphore;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Buffer {
    // Semaphores
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore full = new Semaphore(0);
    private static Semaphore empty = new Semaphore(4);

    // stack that stores the packages that were created by producer
    private static Stack<Integer> stack = new Stack<Integer>() {}; 
    
    // Image views that will be used for animation
    private ImageView producerImageView;
    private ImageView consumerImageView;
    private Label packagesCounter;

    // Constructor
    public Buffer(ImageView producerImageView, ImageView consumerImageView, Label packagesCounter) {
        this.producerImageView = producerImageView;
        this.consumerImageView = consumerImageView;
        this.packagesCounter = packagesCounter;
    }

    /* ***************************************************************
    * Metodo: animateProduction
    * Funcao: Move the package from the productor to the stack
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void animateProduction() {
        Platform.runLater(() -> {

        });
    } // End animateProduction

    /* ***************************************************************
    * Metodo: animateConsumption
    * Funcao: Move the package from the stack to the consumer
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void animateConsumption() {
        Platform.runLater(() -> {

        });
    } // End animateConsumption

    /* ***************************************************************
    * Metodo: getEmptySemaphore
    * Funcao: Return the empty semaphore 
    * Parametros: void
    * Retorno: The semaphore
    *************************************************************** */
    public static Semaphore getEmptySemaphore() {
        return empty;
    } // End getEmptySemaphore

    /* ***************************************************************
    * Metodo: getFullSemaphore
    * Funcao: Return the full semaphore 
    * Parametros: void
    * Retorno: The semaphore
    *************************************************************** */
    public static Semaphore getFullSemaphore() {
        return full;
    } // End getFullSemaphore

    /* ***************************************************************
    * Metodo: getMutexSemaphore
    * Funcao: Return the mutex semaphore 
    * Parametros: void
    * Retorno: The semaphore
    *************************************************************** */
    public static Semaphore getMutexSemaphore() {
        return mutex;
    } // End getMutexSemaphore

    /* ***************************************************************
    * Metodo: getStack
    * Funcao: Return the stack for simulation 
    * Parametros: void
    * Retorno: The stack
    *************************************************************** */
    public static Stack<Integer> getStack() {
        return stack;
    } // End getStack
} // End class Buffer
