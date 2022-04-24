/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Simulacao do trem
* Funcao...........: Simula uma situacao em que 2 trens precisam passar por 1 unico tunel
*************************************************************** */

import Util.SimulacaoTremController;
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
        SimulacaoTremController controller = new SimulacaoTremController(); // Chamada do controller para evitar erro no programa
        
        Parent root = FXMLLoader.load(getClass().getResource("View/SimulacaoTrem.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setResizable(false); 
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }
}