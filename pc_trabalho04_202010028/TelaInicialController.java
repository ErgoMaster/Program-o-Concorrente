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
    }
}
