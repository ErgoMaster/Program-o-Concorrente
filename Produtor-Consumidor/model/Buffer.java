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

    // Constructor
    public Buffer(ImageView producerImageView, ImageView consumerImageView) {
        this.producerImageView = producerImageView;
        this.consumerImageView = consumerImageView;
    }

    /* ***************************************************************
    * Metodo: produce
    * Funcao: Update UI and add a package to stack
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void produce() {
        try {
            empty.acquire(); // Diminui um valor do semaforo vazio para travar um consumidor caso seja necessario
            mutex.acquire(); // Trava o acesso a regiao critica

            stack.push(1);
            animateProduction();
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } finally { 
            full.release(); // Aumenta um valor do semaforo cheio para travar a si proprio caso seja necessario
            mutex.release(); // Libera o acesso a regiao critica
        } // End try/catch       
    } // End produce

    /* ***************************************************************
    * Metodo: animateProduction
    * Funcao: Move the package from the productor to the stack
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void animateProduction() {

    } // End animateProduction

    /* ***************************************************************
    * Metodo: consume
    * Funcao: Update UI and remove a package from stack
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void consume() {
        try { 
            full.acquire(); // Diminui um valor do semaforo cheio para travar um produtor caso seja necessario
            mutex.acquire(); // Trava o acesso a regiao critica

            stack.pop();
            animateConsumption();
            // consumiu(); // Consome item
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } finally {
            empty.release(); // Aumenta um valor do semaforo vazio para travar a si proprio caso seja necessario
            mutex.release(); // Libera o acesso a regiao critica
        } // End try/catch  
    } // End consume

    /* ***************************************************************
    * Metodo: animateConsumption
    * Funcao: Move the package from the stack to the consumer
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void animateConsumption() {

    } // End animateConsumption
} // End class Buffer
