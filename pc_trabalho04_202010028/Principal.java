/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 03/04/2022
* Nome.............: Problema Produtor/Consumidor
* Funcao...........: Simula uma biblioteca em que o produtor fornece livros e o consumidor os aluga
*************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import View.ProdutorConsumidorController;

public class Principal extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /* ***************************************************************
    * Metodo: start
    * Funcao: Inicializa a tela fxml
    * Parametros: Stage
    * Retorno: Void
    *************************************************************** */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Esse eh o processo basico para rodar um programa feito em javafx 
        ProdutorConsumidorController controller = new ProdutorConsumidorController(); // Chamada do controller para evitar erro no programa

        Parent root = FXMLLoader.load(getClass().getResource("View/FXMLProdutorConsumidor.fxml")); 
        Scene scene = new Scene(root);

        primaryStage.setResizable(false); 
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }
}