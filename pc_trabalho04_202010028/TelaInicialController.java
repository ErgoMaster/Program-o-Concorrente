import Model.Buffer;
import java.util.concurrent.Semaphore;
import Model.Consumidor;
import Model.Produtor;

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

    @FXML
    void trocarTela(ActionEvent event) {
        Principal.trocarTela("Simulacao");

        Semaphore mutex = new Semaphore(1);
        Semaphore cheio = new Semaphore(0);
        Semaphore vazio = new Semaphore(1);

        Buffer buffer = new Buffer(mutex, cheio, vazio);
        Produtor produtor = new Produtor();
        Consumidor consumidor = new Consumidor();

        produtor.start();
        consumidor.start();
    }
}
