import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.concurrent.Semaphore;

public class ProdutorConsumidorController {
    // Declaracao dos controles da tela

    @FXML
    public void start(ActionEvent event) {
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
