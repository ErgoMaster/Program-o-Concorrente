/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 17/04/2022
* Nome.............: Controller do jantar dos filosofos
* Funcao...........: Iniciar as threads do programa
*************************************************************** */

package View;

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

public class JantarDosFilosofosController implements Initializable {
    private int duracaoPensamento; // Variavel para controlar a velocidade do pensar dos filosofos
    private int duracaoRefeicao; // Variavel para controlar a velocidade do comer dos filosofos

    // Delaracao dos image view e sliders do programa
    @FXML private ImageView Garfo0Image;
    @FXML private ImageView Garfo1Image;
    @FXML private ImageView Garfo2Image;
    @FXML private ImageView Garfo3Image;
    @FXML private ImageView Garfo4Image;

    @FXML private ImageView EstadoFilosofo0;
    @FXML private ImageView EstadoFilosofo1;
    @FXML private ImageView EstadoFilosofo2;
    @FXML private ImageView EstadoFilosofo3;
    @FXML private ImageView EstadoFilosofo4;

    @FXML private Slider SliderVelocidadePensamento;
    @FXML private Slider SliderVelocidadeRefeicao;
    
    @FXML private Button StartButton;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Iniciar a simulacao do jantar dos filosofos
    * Parametros: Recebe um ActionEvent relacionado ao apertar de um botao
    * Retorno: Void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) {
        // Iniciaizacao da mesa, passando no construtor os image view que sofrerao modificacoes no decorrer do programa
        Mesa mesa = new Mesa(Garfo0Image, Garfo1Image, Garfo2Image, Garfo3Image, Garfo4Image,
        EstadoFilosofo0, EstadoFilosofo1, EstadoFilosofo2, EstadoFilosofo3, EstadoFilosofo4);

        // Chamada e inicializacao das threads
        FilosofoThread0 filosofo0 = new FilosofoThread0(duracaoPensamento, duracaoRefeicao);
        FilosofoThread1 filosofo1 = new FilosofoThread1(duracaoPensamento, duracaoRefeicao);
        FilosofoThread2 filosofo2 = new FilosofoThread2(duracaoPensamento, duracaoRefeicao);
        FilosofoThread3 filosofo3 = new FilosofoThread3(duracaoPensamento, duracaoRefeicao);
        FilosofoThread4 filosofo4 = new FilosofoThread4(duracaoPensamento, duracaoRefeicao); 

        filosofo0.start();
        filosofo1.start();
        filosofo2.start();
        filosofo3.start();
        filosofo4.start();
    }

    /* ***************************************************************
    * Metodo: initialize
    * Funcao: Observar os valores dos sliders de velocidade
    * Parametros: Valores do jabafx
    * Retorno: Void
    *************************************************************** */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Valores padrão para a velocidade das threads
        duracaoPensamento = 2000;
        duracaoRefeicao = 2000;
        
        // Listener que ira pegar o valor do slider da velocidade de pensamento e ira atribuir a variavel de controle
        SliderVelocidadePensamento.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                duracaoPensamento = (int) SliderVelocidadePensamento.getValue();
            }
        });        

        // Listener que ira pegar o valor do slider da velocidade dq refeicao e ira atribuir a variavel de controle
        SliderVelocidadeRefeicao.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                duracaoRefeicao = (int) SliderVelocidadeRefeicao.getValue();
            }
        });
    }
}