/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 06/08/2024     
* Nome.............: ProducerConsumerController
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
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import model.*;

public class ProducerConsumerController implements Initializable {
    // Speed control variables
    private int speedProducer, speedConsumer;

    // Fxml variables
    @FXML private Button starButton;
    @FXML private Slider sliderConsumer;
    @FXML private Slider sliderProducer;
    @FXML private ImageView producerImageView;
    @FXML private ImageView consumerImageView;
    @FXML private Label packagesCounter;
    private static Label packagesCounter_;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Start the prducer-consumer simulation
    * Parametros: event= Click event
    * Retorno: Void
    *************************************************************** */
    @FXML
    public void start(ActionEvent event) {
        // Set each entity speed
        speedProducer =  (int) sliderProducer.getValue();
        speedConsumer =  (int) sliderConsumer.getValue();

        // Initialize threads
        Producer producer = new Producer(speedProducer, producerImageView);
        Consumer consumer = new Consumer(speedConsumer, consumerImageView);

        producer.start();
        consumer.start();
    } // End start

    /* ***************************************************************
    * Metodo: initialize
    * Funcao: Define methods that executes when the current window opens
    * Parametros: location&resources= Fxml arguments
    * Retorno: void
    *************************************************************** */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        producerImageView.setVisible(false);
        consumerImageView.setVisible(false);

        packagesCounter_ = packagesCounter;
    } // End initialize

    /* ***************************************************************
    * Metodo: updatePackagesLabel
    * Funcao: Update counter label with correct size
    * Parametros: event= Click event
    * Retorno: Void
    *************************************************************** */
    public static void updatePackagesLabel() {
        packagesCounter_.setText("Pacotes no buffer: " + Buffer.getStack().size());
    } // End updatePackagesLabel
} // End class ProducerConsumerController
