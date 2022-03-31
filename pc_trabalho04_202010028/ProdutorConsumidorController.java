import java.util.concurrent.Semaphore;
import Model.Buffer;
import Model.Consumidor;
import Model.Produtor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
