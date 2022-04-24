/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 03/04/2022
* Nome.............: Controller Produtor/Consumidor
* Funcao...........: Classe que controla a tela da simulacao
*************************************************************** */

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProdutorConsumidorController implements Initializable {
    // Variaveis de controle da velocidade das threads
    private int velocidadeProdutor, velocidadeConsumidor;

    // Declaracao dos controles da tela
    @FXML private Button ButtonIniciar;
    @FXML private Slider SliderConsumidor;
    @FXML private Slider SliderProdutor;

    @FXML private ImageView ImageLivro1;
    @FXML private ImageView ImageLivro2;
    @FXML private ImageView ImageLivro3;
    @FXML private ImageView ImageLivro4;

    @FXML private ImageView ImageConsumidorConsumiu;
    @FXML private ImageView ImageProdutorProduziu;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Iniciar a simulacao
    * Parametros: Um event que simboliza o clique do mouse no botao de iniciar
    * Retorno: Void
    *************************************************************** */
    @FXML
    public void start(ActionEvent event) {
        // Chamada e inicializacao das threads
        Produtor produtor = new Produtor(velocidadeProdutor, 15);
        Consumidor consumidor = new Consumidor(velocidadeConsumidor);

        // Passagem dos semaforos e elementos graficos do programa para a classe estatica buffer
        Buffer buffer = new Buffer(ImageLivro1, ImageLivro2, ImageLivro3, ImageLivro4, ImageProdutorProduziu, ImageConsumidorConsumiu);

        // Inicilizacao das threads
        produtor.start();
        consumidor.start();
    }

    /* ***************************************************************
    * Metodo: initialize
    * Funcao: observar o valor dos sliders de velocidade e iinicializacao de alguns valores
    * Parametros: Valores do javafx
    * Retorno: Void
    *************************************************************** */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Valores padrao para a velocidade das threads
        velocidadeConsumidor = 2000;
        velocidadeProdutor = 2000;

        // Listener que ira pegar o valor do slider do produtor e guardar na variavel a ser utilizada no programa
        SliderProdutor.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeProdutor = (int) SliderProdutor.getValue();
            }
        });        

        // Listener que ira pegar o valor do slider do produtor e guardar na variavel a ser utilizada no programa
        SliderConsumidor.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeConsumidor = (int) SliderConsumidor.getValue();
            }
        });
    }
}
