/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: 12/08/2024
* Nome.............: Principal
* Funcao...........: Start the interface
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.TrafficController;

public class Principal extends Application {
    /* ***************************************************************
    * Metodo: main
    * Funcao: Execute the program
    * Parametros: args= Arguments to start the program
    * Retorno: void
    *************************************************************** */
    public static void main(String[] args) {
        launch(args);
    } // End main

    /* ***************************************************************
    * Metodo: start
    * Funcao: Inicializa a tela fxml
    * Parametros: Stage
    * Retorno: Void
    *************************************************************** */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Controller declaration to prevent exception
        TrafficController controller = new TrafficController();

        // Open file and set scene
        Parent root = FXMLLoader.load(getClass().getResource("view/Traffic.fxml"));
        Scene scene = new Scene(root);

        // Show UI
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();        
    } // End start
} // End class Principal