/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/01/2022
* Ultima alteracao.: 31/01/2022
* Nome.............: Calculadora de IMC
* Funcao...........: Calcula o IMC do usuário e demonstra se ele está ou não em sobrepeso
*************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Principal extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /* Esse eh o processo basico para rodar um programa feito em javafx */ 
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("src/CalculadoraIMC.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
