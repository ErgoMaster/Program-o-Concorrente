/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 30/07/2024
* Nome.............: TrainSimulationController
* Funcao...........: Control program threads
*************************************************************** */
package view;

import model.SuperThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class TrainSimulationController {
    // Speed control variables
    private int speedTrain1;
    private int speedTrain2;
    
    // FXML variables
    @FXML private Button startButton;
    @FXML private ImageView train1ImageView;
    @FXML private ImageView train2ImageView;
    @FXML private Slider sliderTrain1;
    @FXML private Slider sliderTrain2;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Start the train simulation
    * Parametros: event= Click event
    * Retorno: Void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) {
        // Set each train speed
        speedTrain1 =  (int) sliderTrain1.getValue();
        speedTrain2 =  (int) sliderTrain2.getValue();

        // Set the train position to its initial
        train1ImageView.setLayoutX(94);
        train1ImageView.setLayoutY(54);
        train1ImageView.setTranslateX(0); 
        train1ImageView.setTranslateY(0);

        train2ImageView.setLayoutX(706);
        train2ImageView.setLayoutY(54);
        train2ImageView.setTranslateX(0); 
        train2ImageView.setTranslateY(0);

        SuperThread thread = new SuperThread(train1ImageView, train2ImageView, speedTrain1, speedTrain2, startButton); // Start the simulation
        thread.start();
    } // End start  
} // End class TrainSimulationController
