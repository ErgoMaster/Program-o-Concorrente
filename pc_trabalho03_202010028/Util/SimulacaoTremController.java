/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: xx
* Nome.............: Controller da simulacao
* Funcao...........: Controla o programa de forma a criar as threads
*************************************************************** */

package Util;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SimulacaoTremController {
    //Declaracao dos botoes e linhas do programa
    @FXML
    private Button SimularButton;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Inicializa as threads e inicia a simulacao
    * Parametros: event
    * Retorno: Void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) { // Inicio do botao de simulacao
        // Criacao das threads a serem utilizadas
        Trem1 TremA = new Trem1();
        Trem2 TremB = new Trem2();

        // Inicializacao das threads
        TremA.start();
        TremB.start();
        
    } // Fim do botao de simulacao 
}
