/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: 22/05/2022
* Nome.............: Controller do transito
* Funcao...........: Iniciar as threads do programa
*************************************************************** */

package View;

import java.net.URL;
import java.util.ResourceBundle;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class TransitoController implements Initializable {
    // Variaveis para controle da velocidade dos carros
    private int velocidadeCarroAmarelo;
    private int velocidadeCarroAzul;
    private int velocidadeCarroLaranja;
    private int velocidadeCarroPreto;
    private int velocidadeCarroRoxo;
    private int velocidadeCarroVerde;
    private int velocidadeCarroVermelho;

    @FXML private Button ButtonStart;

    // Image view dos carros
    @FXML private ImageView ImageViewCarroAmarelo;
    @FXML private ImageView ImageViewCarroAzul;
    @FXML private ImageView ImageViewCarroLaranja;
    @FXML private ImageView ImageViewCarroPreto;
    @FXML private ImageView ImageViewCarroRoxo;
    @FXML private ImageView ImageViewCarroVerde;
    @FXML private ImageView ImageViewCarroVermelho;

    // Sliders para controle dessas velocidade
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

        // Chamada e inicializacao das threads
        CarroAmarelo carroA = new CarroAmarelo(velocidadeCarroAmarelo, ImageViewCarroAmarelo, SliderCarroAmarelo);
        CarroAzul carroB = new CarroAzul(velocidadeCarroAzul, ImageViewCarroAzul, SliderCarroAzul);
        CarroLaranja carroC = new CarroLaranja(velocidadeCarroLaranja, ImageViewCarroLaranja, SliderCarroLaranja);
        CarroPreto carroD = new CarroPreto(velocidadeCarroPreto, ImageViewCarroPreto, SliderCarroPreto);
        CarroRoxo carroE = new CarroRoxo(velocidadeCarroRoxo, ImageViewCarroRoxo, SliderCarroRoxo);
        CarroVerde carroF = new CarroVerde(velocidadeCarroVerde, ImageViewCarroVerde, SliderCarroVerde);
        CarroVermelho carroG = new CarroVermelho(velocidadeCarroVermelho, ImageViewCarroVermelho, SliderCarroVermelho);

        carroA.start();
        carroB.start();
        carroC.start();
        carroD.start();
        carroE.start();
        carroF.start();
        carroG.start();
    } // Fim do metodo start

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
    } // Fim do metodo initialize
}
