/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: 07/08/2024
* Nome.............: Buffer
* Funcao...........: Store the semaphores that will be used in simulation
*************************************************************** */
package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Buffer {
    private static int readersControl; // Controls who many readers are reading the database
    private static Semaphore mutex = new Semaphore(1); // Locks critical region
    private static Semaphore data = new Semaphore(1); // Locks database
    private static ArrayList<Integer> requests = new ArrayList<>(); // Stores readers chairs requests
    private static ArrayList<Chair> chairsObjects = new ArrayList<>(); // Stores all chairs current states
    private static ArrayList<ImageView> chairsImages = new ArrayList<>(); // Stores all chairs image views

    // Constructor
    public Buffer(ArrayList<ImageView> newChairsImages) {
        chairsImages = newChairsImages;

        chairsObjects.add(new Chair(1));
        chairsObjects.add(new Chair(2));
        chairsObjects.add(new Chair(3));
        chairsObjects.add(new Chair(4));
        chairsObjects.add(new Chair(5));
        chairsObjects.add(new Chair(6));
        chairsObjects.add(new Chair(7));
        chairsObjects.add(new Chair(8));
        chairsObjects.add(new Chair(9));
        chairsObjects.add(new Chair(10));
        chairsObjects.add(new Chair(11));
        chairsObjects.add(new Chair(12));
        chairsObjects.add(new Chair(13));
        chairsObjects.add(new Chair(14));
        chairsObjects.add(new Chair(15));
        chairsObjects.add(new Chair(16));
        chairsObjects.add(new Chair(17));
        chairsObjects.add(new Chair(18));
        chairsObjects.add(new Chair(19));
        chairsObjects.add(new Chair(20));
    } // End constructor

    /* ***************************************************************
    * Metodo: increaseReadersControl
    * Funcao: Add 1 to control variable when a reader starts to read
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    public static void increaseReadersControl() {
        readersControl++;
    } // End increaseReadersControl

    /* ***************************************************************
    * Metodo: decreaseReadersControl
    * Funcao: Sub 1 to control variable when a reader finished reading
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    public static void decreaseReadersControl() {
        readersControl--;
    } // End decreaseReadersControl

    /* ***************************************************************
    * Metodo: createRequest
    * Funcao: Generate a random id of a free chair so the reader can make a chair request
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    public static void createRequest() {
        ArrayList<Chair> freeChairs = new ArrayList<>();

        // Iterate of chairs list and get all chairs that are free
        for(Chair chair : chairsObjects) {
            if(chair.getState() == 0) {
                freeChairs.add(chair);
            } // End if
        } // End for

        if(freeChairs.isEmpty()) return; // If there is no free chair, return

        // Generate a new random number to occupie a random chair
        Random rand = new Random();
        int randomIndex = rand.nextInt(freeChairs.size());
        int chairId = freeChairs.get(randomIndex).getId();

        requests.add(chairId);
    } // End createRequest

    /* ***************************************************************
    * Metodo: updateDatabase
    * Funcao: Iterate over requests list so the writer updates the database locking free chairs
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    public static void updateDatabase() {
        Platform.runLater(() -> {
            for(int request : requests) {
                for(Chair chair : chairsObjects) { // Look for the correct chair
                    if(request == chair.getId()) {
                        chair.changeState(); // Change the state for occupied
                        chairsImages.get(request - 1).setImage(Gallery.occupiedChair);
                    } // End if
                } // End for
            } // End for

            requests.clear(); // Clear request array for new requests
        });
    } // End updateDatabase

    /* ***************************************************************
    * Metodo: getReadersControl
    * Funcao: Return the variable that controls how many readers is reading 
    * Parametros: void
    * Retorno: A integer
    *************************************************************** */
    public static int getReadersControl() {
        return readersControl;
    } // End getReadersControl

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
    * Metodo: getDataSemaphore
    * Funcao: Return the data semaphore 
    * Parametros: void
    * Retorno: The semaphore
    *************************************************************** */
    public static Semaphore getDataSemaphore() {
        return data;
    } // End getDataSemaphore
} // End class Buffer
