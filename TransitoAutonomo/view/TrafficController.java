/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: 12/08/2024
* Nome.............: TrafficController
* Funcao...........: Start program threads
*************************************************************** */
package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import model.*;

public class TrafficController {
    // Speed variables
    private int yellowCarSpeed;
    private int blueCarSpeed;
    private int orangeCarSpeed;
    private int blackCarSpeed;
    private int purpleCarSpeed;


    // Fxml variables
    @FXML private Button startButton;

    @FXML private ImageView yellowCarImageView;
    @FXML private ImageView blueCarImageView;
    @FXML private ImageView orangeCarImageView;
    @FXML private ImageView blackCarImageView;
    @FXML private ImageView purpleCarImageView;


    @FXML private Slider yellowCarSlider;
    @FXML private Slider blueCarSlider;
    @FXML private Slider orangeCarSlider;
    @FXML private Slider blackCarSlider;
    @FXML private Slider purpleCarSlider;


    /* ***************************************************************
    * Metodo: start
    * Funcao: Start the traffic simulation
    * Parametros: event= Click event
    * Retorno: Void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) {
        startButton.setDisable(true);

        // Get speed values
        yellowCarSpeed =  (int) yellowCarSlider.getValue();
        blueCarSpeed =  (int) blueCarSlider.getValue();
        orangeCarSpeed =  (int) orangeCarSlider.getValue();
        blackCarSpeed =  (int) blackCarSlider.getValue();
        purpleCarSpeed =  (int) purpleCarSlider.getValue();

        // Initialize semaphores
        Semaphores semaphores = new Semaphores(); 

        // Initialize threads
        YellowCar yellow = new YellowCar(yellowCarSpeed, yellowCarImageView);
        BlueCar blue = new BlueCar(blueCarSpeed, blueCarImageView);
        OrangeCar orange = new OrangeCar(orangeCarSpeed, orangeCarImageView);
        BlackCar black = new BlackCar(blackCarSpeed, blackCarImageView);
        PurpleCar purple = new PurpleCar(purpleCarSpeed, purpleCarImageView);

        yellow.start();
        blue.start();
        orange.start();
        black.start();
        purple.start();
    } // Fim start
} // End class TrafficController
