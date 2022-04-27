/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Controller da simulacao
* Funcao...........: Controla o programa de forma a criar as threads
*************************************************************** */

package View;

import java.net.URL;
import java.util.ResourceBundle;
import Model.Trem1;
import Model.Trem2;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class SimulacaoTremController implements Initializable {
    private int velocidadeTrem1;
    private int velocidadeTrem2;
    
    @FXML private Button iniciarButton;

    @FXML private ImageView trem1ImageView;
    @FXML private ImageView trem2ImageView;

    @FXML private Slider slidertrem1;
    @FXML private Slider slidertrem2;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Iniciar a simulacao do trem
    * Parametros: Recebe um ActionEvent relacionado ao apertar de um botao
    * Retorno: Void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) {
       Trem1 trem1 = new Trem1(trem1ImageView, velocidadeTrem1);
       Trem2 trem2 = new Trem2(trem2ImageView, velocidadeTrem2);

       trem1.start();
       trem2.start();
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
        velocidadeTrem1 = 8;
        velocidadeTrem2 = 8;
        
        // Listener que ira pegar o valor do slider da velocidade do trem 1 e ira atribuir a variavel de controle
        slidertrem1.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeTrem1 = (int) slidertrem1.getValue();
            }
        });        

        // Listener que ira pegar o valor do slider da velocidade do trem 2 e ira atribuir a variavel de controle
        slidertrem2.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeTrem2 = (int) slidertrem2.getValue();
            }
        });
    }
}
