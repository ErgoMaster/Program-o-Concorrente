/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: 07/08/2024
* Nome.............: ReaderWriterController
* Funcao...........: Start program threads
*************************************************************** */
package view;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Buffer;
import model.Reader;
import model.Writer;

public class ReaderWriterController implements Initializable {
    // Fxml variables
    @FXML private Button startButton;

    @FXML private Label writerLabel;
    @FXML private Label readerLabel1;
    @FXML private Label readerLabel2;
    @FXML private Label readerLabel3;
    @FXML private Label readerLabel4;

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
        ArrayList<Label> labelsArray = createArrayLabels();

        // Initialize threads
        Writer writer = new Writer(writerLabel);
        Reader reader1 = new Reader(1, labelsArray);
        Reader reader2 = new Reader(2, labelsArray);
        Reader reader3 = new Reader(3, labelsArray);
        Reader reader4 = new Reader(4, labelsArray);

        writer.start();
        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
    } // End start

    /* ***************************************************************
    * Metodo: initialize
    * Funcao: Define methods that executes when the current window opens
    * Parametros: location&resources= Fxml arguments
    * Retorno: void
    *************************************************************** */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Buffer buffer = new Buffer(createArrayImageViews());
    } // End initialize

    /* ***************************************************************
    * Metodo: createArrayImageViews
    * Funcao: Create a array with all chairs
    * Parametros: Void
    * Retorno: A ArrayList
    *************************************************************** */
    private ArrayList<ImageView> createArrayImageViews() {
        ArrayList<ImageView> array = new ArrayList<>();

        array.add(chair1);
        array.add(chair2);
        array.add(chair3);
        array.add(chair4);
        array.add(chair5);
        array.add(chair6);
        array.add(chair7);
        array.add(chair8);
        array.add(chair9);
        array.add(chair10);
        array.add(chair11);
        array.add(chair12);
        array.add(chair13);
        array.add(chair14);
        array.add(chair15);
        array.add(chair16);
        array.add(chair17);
        array.add(chair18);
        array.add(chair19);
        array.add(chair20);

        return array;
    } // End createArrayImageViews

    /* ***************************************************************
    * Metodo: createArrayLabels
    * Funcao: Create a array with all labels
    * Parametros: Void
    * Retorno: A ArrayList
    *************************************************************** */
    private ArrayList<Label> createArrayLabels() {
        ArrayList<Label> array = new ArrayList<>();

        array.add(readerLabel1);
        array.add(readerLabel2);
        array.add(readerLabel3);
        array.add(readerLabel4);

        return array;
    } // End createArrayLabels
} // End class ReaderWriterController
