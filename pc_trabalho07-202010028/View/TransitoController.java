/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Controller do transito
* Funcao...........: Iniciar as threads do programa
*************************************************************** */

package View;

import java.net.URL;
import java.util.ResourceBundle;
import Model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class TransitoController implements Initializable {
    private int velocidadeCarroAmarelo;
    private int velocidadeCarroAzul;
    private int velocidadeCarroLaranja;
    private int velocidadeCarroPreto;
    private int velocidadeCarroRoxo;
    private int velocidadeCarroVerde;
    private int velocidadeCarroVermelho;

    @FXML private Button ButtonStart;

    @FXML private ImageView ImageViewCarroAmarelo;
    @FXML private ImageView ImageViewCarroAzul;
    @FXML private ImageView ImageViewCarroLaranja;
    @FXML private ImageView ImageViewCarroPreto;
    @FXML private ImageView ImageViewCarroRoxo;
    @FXML private ImageView ImageViewCarroVerde;
    @FXML private ImageView ImageViewCarroVermelho;

    @FXML private Slider SliderCarroAmarelo;
    @FXML private Slider SliderCarroAzul;
    @FXML private Slider SliderCarroLaranja;
    @FXML private Slider SliderCarroPreto;
    @FXML private Slider SliderCarroRoxo;
    @FXML private Slider SliderCarroVerde;
    @FXML private Slider SliderCarroVermelho;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Iniciar a simulacao do jantar dos filosofos
    * Parametros: Recebe um ActionEvent relacionado ao apertar de um botao
    * Retorno: Void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) {
        ButtonStart.setDisable(true);

        Semaforos semaforos = new Semaforos(); // Inicizalizacao da classe estatica semaforos

        CarroAmarelo carroA = new CarroAmarelo(velocidadeCarroAmarelo, ImageViewCarroAmarelo);
        CarroAzul carroB = new CarroAzul(velocidadeCarroAzul, ImageViewCarroAzul);
        CarroLaranja carroC = new CarroLaranja(velocidadeCarroLaranja, ImageViewCarroLaranja);
        //CarroPreto carroD = new CarroPreto(velocidadeCarroPreto, ImageViewCarroPreto);
        //CarroRoxo carroE = new CarroRoxo(velocidadeCarroRoxo, ImageViewCarroRoxo);
        //CarroVerde carroF = new CarroVerde(velocidadeCarroVerde, ImageViewCarroVerde);
        //CarroVermelho carroG = new CarroVermelho(velocidadeCarroVermelho, ImageViewCarroVermelho);

        carroA.start();
        carroB.start();
        carroC.start();
        //carroD.start();
        //.start();
        //carroF.start();
        //carroG.start();
    }

    /* ***************************************************************
    * Metodo: initialize
    * Funcao: Observar os valores dos sliders de velocidade
    * Parametros: Valores do javafx
    * Retorno: Void
    *************************************************************** */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Valores padrão para a velocidade das threads
        velocidadeCarroAmarelo = 5;
        velocidadeCarroAzul = 5;
        velocidadeCarroLaranja = 5;
        velocidadeCarroPreto = 5;
        velocidadeCarroRoxo = 5;
        velocidadeCarroVerde = 5;
        velocidadeCarroVermelho = 5;
    
        // Listeners para pegar o valor dos sliders de cada carro dentro da simulacao
        SliderCarroAmarelo.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeCarroAmarelo = (int) SliderCarroAmarelo.getValue();
            }
        });        

        SliderCarroAzul.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeCarroAzul = (int) SliderCarroAzul.getValue();
            }
        });

        SliderCarroLaranja.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeCarroLaranja = (int) SliderCarroLaranja.getValue();
            }
        });

        SliderCarroPreto.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeCarroPreto = (int) SliderCarroPreto.getValue();
            }
        });

        SliderCarroRoxo.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeCarroRoxo = (int) SliderCarroRoxo.getValue();
            }
        });

        SliderCarroVerde.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeCarroVerde = (int) SliderCarroVerde.getValue();
            }
        });

        SliderCarroVermelho.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeCarroVermelho = (int) SliderCarroVermelho.getValue();
            }
        });
    }
}
