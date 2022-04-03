/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 03/04/2022
* Nome.............: TelaInicialController
* Funcao...........: Controla a tela inicial e leva o programa a proxima tela para comecar a simulacao
*************************************************************** */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TelaInicialController {
    // Declaracao dos controles da tela
    @FXML
    private Button ButtonTrocarTela;

    @FXML
    private Label LabelTitulo;

    /* ***************************************************************
    * Metodo: trocarTela
    * Funcao: Trocar a tela do menu inicial para a tela da animacao
    * Parametros: Event que representara o clique no botao
    * Retorno: Void
    *************************************************************** */
    @FXML
    void trocarTela(ActionEvent event) {
        Principal.trocarTela("Simulacao");
    }
}
