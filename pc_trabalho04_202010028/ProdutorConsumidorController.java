

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import Model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProdutorConsumidorController implements Initializable {
    Produtor produtor;
    Consumidor1 consumidor1;
    Consumidor2 consumidor2;
    Consumidor3 consumidor3;
    private int estadoDeExcecucao = 0;
    private int velocidadeProdutor, velocidadeConsumidor;
    private int numeroDeConsumidores;

    // Declaracao dos controles da tela
    @FXML
    private Button ButtonIniciar;

    @FXML
    private ImageView ImageLivro1;

    @FXML
    private ImageView ImageLivro2;

    @FXML
    private ImageView ImageLivro3;

    @FXML
    private ImageView ImageLivro4;

    @FXML
    private ImageView voltarImage;

    @FXML
    private ImageView ImageLeitor1;

    @FXML
    private ImageView ImageLeitor2;

    @FXML
    private ImageView ImageLeitor3;

    @FXML
    private ImageView ImageConsumidorConsumiu1;

    @FXML
    private ImageView ImageConsumidorConsumiu2;

    @FXML
    private ImageView ImageConsumidorConsumiu3;

    @FXML
    private ImageView ImageProdutorProduziu;

    @FXML
    private Slider SliderConsumidor;

    @FXML
    private Slider SliderProdutor;

    @FXML
    void voltarAoMenu(MouseEvent event) {
        Principal.trocarTela("Inicial");
    }

    @FXML
    public void start(ActionEvent event) {
        switch(numeroDeConsumidores) {
            case 1: {
                switch(estadoDeExcecucao) {
                    case 0: {
                        produtor = new Produtor(velocidadeProdutor, 15);
                        consumidor1 = new Consumidor1(velocidadeConsumidor);
        
                        Semaphore mutex = new Semaphore(1);
                        Semaphore cheio = new Semaphore(0);
                        Semaphore vazio = new Semaphore(4);
                        Buffer buffer = new Buffer(mutex, cheio, vazio, ImageLivro1, ImageLivro2, ImageLivro3, ImageLivro4, 
                        ImageProdutorProduziu, ImageConsumidorConsumiu1, ImageConsumidorConsumiu2, ImageConsumidorConsumiu3);
        
                        produtor.start();
                        consumidor1.start();
        
                        break;
                    }
                    case 1: {
                        produtor.suspend();
                        consumidor1.suspend();
                        estadoDeExcecucao = 2;
        
                        break;
                    }
                    case 2: {
                        produtor.resume();
                        consumidor1.resume();
        
                        break;
                    }
                }
                
                break;
            }
            case 2: {
                switch(estadoDeExcecucao) {
                    case 0: {
                        produtor = new Produtor(velocidadeProdutor, 15);
                        consumidor1 = new Consumidor1(velocidadeConsumidor);
                        consumidor2 = new Consumidor2(velocidadeConsumidor);
        
                        Semaphore mutex = new Semaphore(1);
                        Semaphore cheio = new Semaphore(0);
                        Semaphore vazio = new Semaphore(4);
                        Buffer buffer = new Buffer(mutex, cheio, vazio, ImageLivro1, ImageLivro2, ImageLivro3, ImageLivro4, 
                        ImageProdutorProduziu, ImageConsumidorConsumiu1, ImageConsumidorConsumiu2, ImageConsumidorConsumiu3);
        
                        produtor.start();
                        consumidor1.start();
                        consumidor2.start();
        
                        break;
                    }
                    case 1: {
                        produtor.suspend();
                        consumidor1.suspend();
                        consumidor2.suspend();
                        estadoDeExcecucao = 2;
        
                        break;
                    }
                    case 2: {
                        produtor.resume();
                        consumidor1.resume();
                        consumidor2.resume();
        
                        break;
                    }
                }

                break;
            }
            case 3: {
                switch(estadoDeExcecucao) {
                    case 0: {
                        produtor = new Produtor(velocidadeProdutor, 15);
                        consumidor1 = new Consumidor1(velocidadeConsumidor);
                        consumidor2 = new Consumidor2(velocidadeConsumidor);
                        consumidor3 = new Consumidor3(velocidadeConsumidor);
        
                        Semaphore mutex = new Semaphore(1);
                        Semaphore cheio = new Semaphore(0);
                        Semaphore vazio = new Semaphore(4);
                        Buffer buffer = new Buffer(mutex, cheio, vazio, ImageLivro1, ImageLivro2, ImageLivro3, ImageLivro4, 
                        ImageProdutorProduziu, ImageConsumidorConsumiu1, ImageConsumidorConsumiu2, ImageConsumidorConsumiu3);
        
                        produtor.start();
                        consumidor1.start();
                        consumidor2.start();
                        consumidor3.start();
        
                        break;
                    }
                    case 1: {
                        produtor.suspend();
                        consumidor1.suspend();
                        consumidor2.suspend();
                        consumidor3.suspend();
                        estadoDeExcecucao = 2;
        
                        break;
                    }
                    case 2: {
                        produtor.resume();
                        consumidor1.resume();
                        consumidor2.resume();
                        consumidor3.resume();
        
                        break;
                    }
                }

                break;
            }
        }
    }

    @FXML
    public void pause(ActionEvent event) {
        estadoDeExcecucao = 1;
        start(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        velocidadeConsumidor = 2000;
        velocidadeProdutor = 2000;
        numeroDeConsumidores = 3;

        /*ImageConsumidorConsumiu2.setVisible(false);
        ImageConsumidorConsumiu3.setVisible(false);
        ImageLeitor2.setVisible(false);
        ImageLeitor3.setVisible(false); */

        SliderProdutor.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeProdutor = (int) SliderProdutor.getValue();
            }
        });        

        SliderConsumidor.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeConsumidor = (int) SliderConsumidor.getValue();
            }
        });
    }
}
