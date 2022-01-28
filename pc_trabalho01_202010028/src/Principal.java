/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/01/2022
* Ultima alteracao.: XX
* Nome.............: Calculadora de IMC
* Funcao...........: Calcula o IMC do usuário e demonstra se ele está ou não em sobrepeso
*************************************************************** */
package src; 

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
        /* Esse é o processo básico para rodar um programa feito em javafx com a adição de uma chamada para
        utilizar css dentro do programa */ 
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("CalculadoraIMC.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
