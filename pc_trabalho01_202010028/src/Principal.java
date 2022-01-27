/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/01
* Ultima alteracao.: XX
* Nome.............: Calculadora de IMC
* Funcao...........: Calcula o IMC do usuário e demonstra se ele está ou não em sobrepeso
*************************************************************** */
package src; 

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class Principal extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("CalculadoraIMC.fxml"));
        Parent root = fxmlloader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
