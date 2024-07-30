/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 30/07/2024
* Nome.............: Table
* Funcao...........: Control animations
*************************************************************** */

package model;

import java.util.concurrent.Semaphore;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Table {
    // Constants the represent possible philosophers states
    private final static int THINKING = 0;
    private final static int EATING = 1;
    private final static int STARVING = 2;

    private static int[] philosophersStates = { THINKING, THINKING, THINKING, THINKING, THINKING }; // The 5 philosophers state

    // Semaphores
    private static Semaphore mutex = new Semaphore(1); 
    private static Semaphore philosopherSemaphores[] = { new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1) };

    private static ImageView fork0, fork1, fork2, fork3, fork4; 
    private static Label philosopherState0, philosopherState1, philosopherState2, philosopherState3, philosopherState4; 

    // Constructor
    public Table(ImageView newFork0, ImageView newFork1, ImageView newFork2, ImageView newFork3, ImageView newFork4, 
    Label newPhilosopherState0, Label newPhilosopherState1, Label newPhilosopherState2, 
    Label newPhilosopherState3, Label newPhilosopherState4) {
        fork0 = newFork0;
        fork1 = newFork1;
        fork2 = newFork2;
        fork3 = newFork3;
        fork4 = newFork4;

        philosopherState0 = newPhilosopherState0;
        philosopherState1 = newPhilosopherState1;
        philosopherState2 = newPhilosopherState2;
        philosopherState3 = newPhilosopherState3;
        philosopherState4 = newPhilosopherState4;

        // Down all philosophers semaphore
        for(int i = 0; i < 5; i++) {
            try { philosopherSemaphores[i].acquire(); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        } // End for
    } // End constructor

    /* ***************************************************************
    * Metodo: think
    * Funcao: Change the philosopher image view
    * Parametros: id= Philosopher id
    * Retorno: Void
    *************************************************************** */
    public static void think(int id) throws InterruptedException {
        mutex.acquire(); // Close critical region

        Platform.runLater(() -> {
            switch(id) {
                case 0: {
                    philosopherState0.setText("Pensando..."); // Change the label
                    break;
                }
                case 1: {
                    philosopherState1.setText("Pensando..."); // Change the label
                    break;
                }
                case 2: {
                    philosopherState2.setText("Pensando..."); // Change the label
                    break;
                }
                case 3: {
                    philosopherState3.setText("Pensando..."); // Change the label
                    break;
                }
                case 4: {
                    philosopherState4.setText("Pensando..."); // Change the label
                    break;
                }
            } // End switch
        });

        mutex.release(); // Release critical region
    } // End think

    /* ***************************************************************
    * Metodo: takeForks
    * Funcao: Take adjacent forks
    * Parametros: Current, left and right philosophers ids
    * Retorno: Void
    *************************************************************** */
    public static void takeForks(int id, int leftPhilosopherId, int rightPhilosopherId) throws InterruptedException {
        mutex.acquire(); // Close critical region

        philosophersStates[id] = STARVING; // Set current philosopher state to starving
        verifyForks(id, leftPhilosopherId, rightPhilosopherId); // Verify if the adjacent forks are free

        mutex.release(); // release critical region
        philosopherSemaphores[id].acquire(); // Down current philosopher semaphore
    } // End takeForks

    /* ***************************************************************
    * Metodo: verifyForks
    * Funcao: Given a philkosopher, verify if the adjacent forks are free
    * Parametros: Current, left and right philosophers ids
    * Retorno: Void
    *************************************************************** */
    private static void verifyForks(int id, int leftPhilosopherId, int rightPhilosopherId) {
        // Verify if right and left philosophers are eating, if not, set the current philosopher state to eating
        if(philosophersStates[id] == STARVING && philosophersStates[leftPhilosopherId] != EATING && 
        philosophersStates[rightPhilosopherId] != EATING) {
            philosophersStates[id] = EATING; // Set current philosopher to eating
            philosopherSemaphores[id].release(); // Up current philosopher semaphore
        } // End if
    } // End verifyForks

    /* ***************************************************************
    * Metodo: eat
    * Funcao: Change the philosopher image view
    * Parametros: id= Philosopher id
    * Retorno: Void
    *************************************************************** */
    public static void eat(int id) throws InterruptedException {
        mutex.acquire(); // Close critical region
        
        Platform.runLater(() -> {
            switch(id) {
                case 0: {
                    fork0.setImage(Gallery.occupiedFork); 
                    fork1.setImage(Gallery.occupiedFork); 
                    philosopherState0.setText("Comendo..."); 
                    break;
                }
                case 1: {
                    fork1.setImage(Gallery.occupiedFork); 
                    fork2.setImage(Gallery.occupiedFork);
                    philosopherState1.setText("Comendo..."); 
                    break;
                }
                case 2: {
                    fork2.setImage(Gallery.occupiedFork); 
                    fork3.setImage(Gallery.occupiedFork);
                    philosopherState2.setText("Comendo..."); 
                    break;
                }
                case 3: {
                    fork3.setImage(Gallery.occupiedFork); 
                    fork4.setImage(Gallery.occupiedFork); 
                    philosopherState3.setText("Comendo..."); 
                    break;
                }
                case 4: {
                    fork4.setImage(Gallery.occupiedFork); 
                    fork0.setImage(Gallery.occupiedFork);
                    philosopherState4.setText("Comendo..."); 
                    break;
                }
            } // End switch
        });

        mutex.release(); // Release critical region
    } // End eat

    /* ***************************************************************
    * Metodo: releaseForks
    * Funcao: Change the forks image views
    * Parametros: id= Philosopher id
    * Retorno: Void
    *************************************************************** */
    public static void releaseForks(int id, int leftPhilosopherId, int rightPhilosopherId) throws InterruptedException {
        mutex.acquire(); // Close critical region

        philosophersStates[id] = THINKING; // Set the current philosopher to thinking

        Platform.runLater(() -> {
            switch(id) {
                case 0: {
                    fork0.setImage(Gallery.freeFork); 
                    fork1.setImage(Gallery.freeFork); 
                    break;
                }
                case 1: {
                    fork1.setImage(Gallery.freeFork); 
                    fork2.setImage(Gallery.freeFork); 
                    break;
                }
                case 2: {
                    fork2.setImage(Gallery.freeFork); 
                    fork3.setImage(Gallery.freeFork); 
                    break;
                }
                case 3: {
                    fork3.setImage(Gallery.freeFork); 
                    fork4.setImage(Gallery.freeFork); 
                    break;
                }
                case 4: {
                    fork4.setImage(Gallery.freeFork); 
                    fork0.setImage(Gallery.freeFork); 
                    break;
                }
            } // End switch
        });
    
        verifyForks(leftPhilosopherId, ((id + 3) % 5), id); // Call left philosopher
        verifyForks(rightPhilosopherId, id, ((id + 2) % 5)); // Call right philosopher
        
        mutex.release(); // Release critical region
    } // End releaseForks
} // End class Table
