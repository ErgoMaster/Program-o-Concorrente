/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: 06/08/2024
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
    private static int readersControl;
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore data = new Semaphore(1);
    private static ArrayList<Integer> requests = new ArrayList<>();
    private static ArrayList<Chair> chairsObjects = new ArrayList<>();
    private static ArrayList<ImageView> chairsImages = new ArrayList<>();

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
    }

    public static void increaseReadersControl() {
        readersControl++;
    } // End increaseReadersControl

    public static void decreaseReadersControl() {
        readersControl--;
    } // End decreaseReadersControl

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
