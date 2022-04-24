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
        // Inicializacao da tela fxml
        ProdutorConsumidorController controller = new ProdutorConsumidorController(); // Chamada do controller para evitar excecao
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("View/FXMLProdutorConsumidor.fxml"));        
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);

        stage.setResizable(false); // Trava o tamanho da tela
        stage.setScene(sceneInicial);
        stage.show(); // Mostra a tela
    }
}