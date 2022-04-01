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
    Consumidor1 consumidor;
    private int estadoDeExcecucao = 0;
    private int velocidadeProdutor, velocidadeConsumidor;

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
    private Slider SliderConsumidor;

    @FXML
    private Slider SliderProdutor;

    @FXML
    void voltarAoMenu(MouseEvent event) {
        Principal.trocarTela("Inicial");
    }

    @FXML
    public void start(ActionEvent event) {
        switch(estadoDeExcecucao) {
            case 0: {
                produtor = new Produtor(velocidadeProdutor, 15);
                consumidor = new Consumidor1(velocidadeConsumidor);

                Semaphore mutex = new Semaphore(1);
                Semaphore cheio = new Semaphore(0);
                Semaphore vazio = new Semaphore(4);
                Buffer buffer = new Buffer(mutex, cheio, vazio, ImageLivro1, ImageLivro2, ImageLivro3, ImageLivro4);

                produtor.start();
                consumidor.start();

                break;
            }
            case 1: {
                produtor.suspend();
                consumidor.suspend();
                estadoDeExcecucao = 2;

                break;
            }
            case 2: {
                produtor.resume();
                consumidor.resume();

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
