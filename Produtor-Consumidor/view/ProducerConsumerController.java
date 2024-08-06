/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 06/08/2024     
* Nome.............: ProducerConsumerController
* Funcao...........: Start program threads
*************************************************************** */
package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import model.*;

public class ProducerConsumerController {
    // Speed control variables
    private int speedProducer, speedConsumer;

    // Fxml variables
    @FXML private Button starButton;
    @FXML private Slider sliderConsumer;
    @FXML private Slider sliderProducer;
    @FXML private ImageView producerImageView;
    @FXML private ImageView consumerImageView;
    @FXML private Label packagesCounter;

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
        Producer producer = new Producer(speedProducer);
        Consumer consumer = new Consumer(speedConsumer);
        sjfjsfn

        // Passagem dos semaforos e elementos graficos do programa para a classe estatica buffer
        Buffer simulation = new Buffer(producerImageView, consumerImageView, packagesCounter);
        // Buffer simulacao = new Buffer(ImageLivro1, ImageLivro2, ImageLivro3, ImageLivro4, ImageProdutorProduziu, ImageConsumidorConsumiu);

        producer.start();
        consumer.start();
    } // End start
} // End class ProducerConsumerController
