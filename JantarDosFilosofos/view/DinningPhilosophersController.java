/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 30/07/2024
* Nome.............: DinningPhilosophersController
* Funcao...........: Start program threads
*************************************************************** */

package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.*;

public class DinningPhilosophersController implements Initializable {
    // Fxml variables
    @FXML private ImageView fork0Image;
    @FXML private ImageView fork1Image;
    @FXML private ImageView fork2Image;
    @FXML private ImageView fork3Image;
    @FXML private ImageView fork4Image;

    @FXML private Label philosopherState0;
    @FXML private Label philosopherState1;
    @FXML private Label philosopherState2;
    @FXML private Label philosopherState3;
    @FXML private Label philosopherState4;
    
    @FXML private Button StartButton;

    /* ***************************************************************
    * Metodo: startAlgorithm
    * Funcao: Define and start threads
    * Parametros: event= Click event
    * Retorno: void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) {
        // Initialize the table, parsing the image views that will change in the program
        Table table = new Table(fork0Image, fork1Image, fork2Image, fork3Image, fork4Image,
        philosopherState0, philosopherState1, philosopherState2, philosopherState3, philosopherState4);

        // Chamada e inicializacao das threads
        Philosopher filosofo0 = new Philosopher(0, 4, 1);
        Philosopher filosofo1 = new Philosopher(1, 0, 2);
        Philosopher filosofo2 = new Philosopher(2, 1, 3);
        Philosopher filosofo3 = new Philosopher(3, 2, 4);
        Philosopher filosofo4 = new Philosopher(4, 3, 0); 

        filosofo0.start();
        filosofo1.start();
        filosofo2.start();
        filosofo3.start();
        filosofo4.start();
    } // End start

    /* ***************************************************************
    * Metodo: initialize
    * Funcao: Define methods that executes when the current window opens
    * Parametros: location&resources= Fxml arguments
    * Retorno: void
    *************************************************************** */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    } // End initialize
} // End class DinningPhilosophersController