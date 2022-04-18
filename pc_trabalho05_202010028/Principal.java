/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 17/04/2022
* Nome.............: Jantar dos filosofos
* Funcao...........: Solucao do problema do jantar dos filosofos usando semaforos
*************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Esse eh o processo basico para rodar um programa feito em javafx 
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("View/JantarDosFilosofos.fxml")); // Chamada do controller para evitar erro no programa
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();        
    }
}