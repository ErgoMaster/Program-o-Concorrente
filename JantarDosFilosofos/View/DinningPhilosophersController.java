/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 06/05/2024
* Nome.............: DinningPhilosophersController
* Funcao...........: Start program threads
*************************************************************** */

package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import Model.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class DinningPhilosophersController implements Initializable {
    private int thinkingSpeed; // Philosopher thinking speed 
    private int eatingSpeed; // Philosopher eating speed

    // Fxml variables
    @FXML private ImageView fork0Image;
    @FXML private ImageView fork1Image;
    @FXML private ImageView fork2Image;
    @FXML private ImageView fork3Image;
    @FXML private ImageView fork4Image;

    @FXML private ImageView philosopherState0;
    @FXML private ImageView philosopherState1;
    @FXML private ImageView philosopherState2;
    @FXML private ImageView philosopherState3;
    @FXML private ImageView philosopherState4;

    @FXML private Slider thinkingSpeedSlider;
    @FXML private Slider eatingSpeedSlider;
    
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
        Philosopher filosofo0 = new Philosopher(0, 4, 1, thinkingSpeed, eatingSpeed);
        Philosopher filosofo1 = new Philosopher(1, 0, 2, thinkingSpeed, eatingSpeed);
        Philosopher filosofo2 = new Philosopher(2, 1, 3, thinkingSpeed, eatingSpeed);
        Philosopher filosofo3 = new Philosopher(3, 2, 4, thinkingSpeed, eatingSpeed);
        Philosopher filosofo4 = new Philosopher(4, 3, 0, thinkingSpeed, eatingSpeed); 

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
        // Listener que ira pegar o valor do slider da velocidade de pensamento e ira atribuir a variavel de controle
        thinkingSpeedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                thinkingSpeed = (int) thinkingSpeedSlider.getValue();
            }
        });        

        // Listener que ira pegar o valor do slider da velocidade dq refeicao e ira atribuir a variavel de controle
        eatingSpeedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                eatingSpeed = (int) eatingSpeedSlider.getValue();
            }
        });
    } // End initialize
} // End class DinningPhilosophersController