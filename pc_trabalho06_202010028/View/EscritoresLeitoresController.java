/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: xx
* Nome.............: Controller do Leitores/Escritores
* Funcao...........: Iniciar as threads do programa
*************************************************************** */

package View;

import Model.SuperThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class EscritoresLeitoresController {
    // Declaracao dos image views e botoes do programa
    @FXML private Button ButtonIniciar;

    @FXML private ImageView cadeira0;
    @FXML private ImageView cadeira1;
    @FXML private ImageView cadeira2;
    @FXML private ImageView cadeira3;
    @FXML private ImageView cadeira4;
    @FXML private ImageView cadeira5;
    @FXML private ImageView cadeira6;
    @FXML private ImageView cadeira7;
    @FXML private ImageView cadeira8;
    @FXML private ImageView cadeira9;
    @FXML private ImageView cadeira10;
    @FXML private ImageView cadeira11;
    @FXML private ImageView cadeira12;
    @FXML private ImageView cadeira13;
    @FXML private ImageView cadeira14;
    @FXML private ImageView cadeira15;
    @FXML private ImageView cadeira16;
    @FXML private ImageView cadeira17;
    @FXML private ImageView cadeira18;
    @FXML private ImageView cadeira19;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Iniciar a simulacao do problema Leitores/Escritores
    * Parametros: Recebe um ActionEvent relacionado ao apertar de um botao
    * Retorno: Void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) {
        // Chamada e inicializacao das threads
        SuperThread thread = new SuperThread(criarArray());

        thread.start();
    }

    /* ***************************************************************
    * Metodo: criarArray
    * Funcao: Cria um array com os image view correspondente a cada cadeira na simulacao
    * Parametros: Void
    * Retorno: Um array de image views
    *************************************************************** */
    private ImageView[] criarArray() {
        ImageView[] arrayImageView = { cadeira0, cadeira1, cadeira2, cadeira3, cadeira4, cadeira5, cadeira6, cadeira7, cadeira8, cadeira9,
            cadeira10, cadeira11, cadeira12, cadeira13, cadeira14, cadeira15, cadeira16, cadeira17, cadeira18, cadeira19 };

        return arrayImageView;
    }
}
