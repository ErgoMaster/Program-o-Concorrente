/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 12/03/2022
* Ultima alteracao.: 12/03/2022
* Nome.............: Arvore genealogica controller
* Funcao...........: Classe controller da tela do javafx, inicializa as threads
*************************************************************** */

package util;

import javax.swing.SwingWorker;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class ArvoreGenealogicaController {
    // Declaracao dos botoes e linhas do programa
    @FXML
    private Button bisnetoButton;

    @FXML
    private Button filho1Button;

    @FXML
    private Button filho2Button;

    @FXML
    private Button filho3Button;

    @FXML
    private Button neto1Button;

    @FXML
    private Button neto2Button;

    @FXML
    private Button paiButton;

    @FXML
    private Button simularButton;

    @FXML
    private Line lineBisneto;

    @FXML
    private Line lineFilho1;

    @FXML
    private Line lineFilho2;

    @FXML
    private Line lineFilho3;

    @FXML
    private Line lineNeto1;

    @FXML
    private Line lineNeto2;


    @FXML
    void start(ActionEvent event) { // Inicio do botao de simulacao
        // Criacao das threads a serem utilizadas
        ThreadSimularButtonDisable button = new ThreadSimularButtonDisable(simularButton);
        ThreadPai pai = new ThreadPai(paiButton);
        ThreadFilho1 filho1 = new ThreadFilho1(filho1Button, lineFilho1);
        ThreadFilho2 filho2 = new ThreadFilho2(filho2Button, lineFilho2);
        ThreadFilho3 filho3 = new ThreadFilho3(filho3Button, lineFilho3);
        ThreadNeto1 neto1 = new ThreadNeto1(neto1Button, lineNeto1);
        ThreadNeto2 neto2 = new ThreadNeto2(neto2Button, lineNeto2);
        ThreadBisneto bisneto = new ThreadBisneto(bisnetoButton, lineBisneto);

        // Inicializacao das threads
        button.start();
        pai.start();
        filho1.start();
        filho2.start();
        filho3.start();
        neto1.start();
        neto2.start();
        bisneto.start();
    } // Fim do botao de simulacao 
}

