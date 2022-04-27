/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: xx
* Nome.............: Leitores/Escritores
* Funcao...........: Solucao do problema do Leitores/Escritores usando semaforos
*************************************************************** */

import View.EscritoresLeitoresController;
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
        // Esse eh o processo basico para rodar um programa feito em javafx 
        EscritoresLeitoresController controller = new EscritoresLeitoresController(); // Chamada do controller para evitar erro no programa

        Parent root = FXMLLoader.load(getClass().getResource("View/EscritoresLeitores.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();        
    }
}
