/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 30/07/2024
* Nome.............: Principal
* Funcao...........: Start the interface
*************************************************************** */

import view.TrainSimulationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        TrainSimulationController controller = new TrainSimulationController(); 
        
        // Open file and set scene
        Parent root = FXMLLoader.load(getClass().getResource("view/TrainSimulation.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setResizable(false); 
        primaryStage.setScene(scene);
        primaryStage.show(); 
    } // End start
} // End class Principal