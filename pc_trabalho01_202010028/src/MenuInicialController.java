package src;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MenuInicialController {
    @FXML
    private TextField AlturaTextField;

    @FXML
    private Button CalcularButton;

    @FXML
    private TextField ErroTextField;

    @FXML
    private TextField PesoTextField;

    @FXML
    private AnchorPane TelaPrincipal;

    @FXML
    public void calcular(ActionEvent event) throws IOException {
        try {
            int altura = Integer.parseInt(AlturaTextField.getText());
            double peso = Double.parseDouble(PesoTextField.getText());

            verificarValidade(altura, peso);

            AnchorPane tela = (AnchorPane) FXMLLoader.load(getClass().getResource("xx.fxml"));
            TelaPrincipal.getChildren().setAll(tela);
        } catch(NumberFormatException e) {
            ErroTextField.setText("Informações digitadas estão incorretas");
        } catch(ValorInvalidoException e) {
            ErroTextField.setText("Valores informados são inválidos");
        }
    }

    public void verificarValidade(int altura, double peso) throws ValorInvalidoException {
        if(altura < 0 || altura > 300 || peso < 0 || peso > 200) {
            throw new ValorInvalidoException();
        }
    }
}