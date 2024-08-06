/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 06/08/2024     
* Nome.............: Principal
* Funcao...........: Start the interface
*************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ProducerConsumerController;

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
    * Funcao: Open the UI
    * Parametros: currentStage= Stage to open the fxml file
    * Retorno: void
    *************************************************************** */
    @Override
    public void start(Stage primaryStage) throws Exception {
       // Controller declaration to prevent exception
        ProducerConsumerController controller = new ProducerConsumerController();

        // Open file and set scene
        Parent root = FXMLLoader.load(getClass().getResource("view/ProducerConsumer.fxml")); 
        Scene scene = new Scene(root);

        // Show UI
        primaryStage.setResizable(false); 
        primaryStage.setScene(scene);
        primaryStage.show(); 
    } // End start
} // End class Principal