/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: xx
* Nome.............: Controller da simulacao
* Funcao...........: Controla o programa de forma a criar as threads
*************************************************************** */

package Util;

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

public class SimulacaoTremController implements Initializable {
    int duracaoTrem1; // Variavel para guardar a velocidade do trem 1
    int duracaoTrem2; // Variavel para guardar a velocidade do trem 2

    //Declaracao dos botoes e linhas do programa
    @FXML
    private Button SimularButton;

    @FXML
    private ImageView trem1;

    @FXML
    private ImageView trem2;

    @FXML
    private Slider sliderTrem1;

    @FXML
    private Slider sliderTrem2;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Inicializa as threads e inicia a simulacao
    * Parametros: event
    * Retorno: Void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) { // Inicio do botao de simulacao 
        // Setar os trens nas suas posicoes iniciais

        // Criacao das threads a serem utilizadas
        Trem1 TremA = new Trem1(trem1, duracaoTrem1);
        Trem2 TremB = new Trem2(trem2, duracaoTrem2);

        // Inicializacao das threads
        TremA.start();
        TremB.start();
        
    } // Fim do botao de simulacao 

    /* ***************************************************************
    * Metodo: initialize
    * Funcao: Verificar os valores dos sliders
    * Parametros: URL e ResourceBundle
    * Retorno: Void
    *************************************************************** */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Valores padrao para a duracao das animacoes
        duracaoTrem1 = 5000;
        duracaoTrem2 = 5000;

        sliderTrem1.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                duracaoTrem1 = (int) sliderTrem1.getValue();
            }
        });

        sliderTrem2.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                duracaoTrem2 = (int) sliderTrem2.getValue();
            }
        });
    }
}
