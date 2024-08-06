/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: 06/05/2022
* Nome.............: Controller do Leitores/Escritores
* Funcao...........: Iniciar as threads do programa
*************************************************************** */
package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.SuperThread;

public class ReaderWriterController {
    // Fxml variables
    @FXML private Button startButton;

    @FXML private Label reader1Label;
    @FXML private Label reader2Label;
    @FXML private Label reader3Label;
    @FXML private Label reader4Label;
    @FXML private Label reader5Label;

    @FXML private ImageView chair1;
    @FXML private ImageView chair2;
    @FXML private ImageView chair3;
    @FXML private ImageView chair4;
    @FXML private ImageView chair5;
    @FXML private ImageView chair6;
    @FXML private ImageView chair7;
    @FXML private ImageView chair8;
    @FXML private ImageView chair9;
    @FXML private ImageView chair10;
    @FXML private ImageView chair11;
    @FXML private ImageView chair12;
    @FXML private ImageView chair13;
    @FXML private ImageView chair14;
    @FXML private ImageView chair15;
    @FXML private ImageView chair16;
    @FXML private ImageView chair17;
    @FXML private ImageView chair18;
    @FXML private ImageView chair19;
    @FXML private ImageView chair20;

    /* ***************************************************************
    * Metodo: start
    * Funcao: Start the reader-writer simulation
    * Parametros: event= Click event
    * Retorno: Void
    *************************************************************** */
    @FXML
    void start(ActionEvent event) {
        // Chamada e inicializacao das threads
        SuperThread thread = new SuperThread(criarArrayImageViews(), criarArrayLabels(), LabelEscritor);

        thread.start();
    }

    /* ***************************************************************
    * Metodo: criarArrayImageViews
    * Funcao: Cria um array com os image view correspondentes a cada cadeira na simulacao
    * Parametros: Void
    * Retorno: Um array de image views
    *************************************************************** */
    private ImageView[] criarArrayImageViews() {
        ImageView[] arrayImageView = { cadeira0, cadeira1, cadeira2, cadeira3, cadeira4, cadeira5, cadeira6, cadeira7, cadeira8, cadeira9,
            cadeira10, cadeira11, cadeira12, cadeira13, cadeira14, cadeira15, cadeira16, cadeira17, cadeira18, cadeira19 };

        return arrayImageView;
    }

    /* ***************************************************************
    * Metodo: criarArrayLabels
    * Funcao: Cria um array com os labels correspondentes a cada leitor na simulacao
    * Parametros: Void
    * Retorno: Um array de labels
    *************************************************************** */
    private Label[] criarArrayLabels() {
        Label[] arrayLabels = { LabelLeitor0, LabelLeitor1, LabelLeitor2, LabelLeitor3 };

        return arrayLabels;
    } 
}
