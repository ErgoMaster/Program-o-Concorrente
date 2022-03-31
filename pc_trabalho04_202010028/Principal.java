/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: xx
* Nome.............: Problema Produtor/Consumidor
* Funcao...........: 
*************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
    private static Stage stage;
    private static Scene sceneSimulacao;
    private static Scene sceneInicial;
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
        ProdutorConsumidorController controller0 = new ProdutorConsumidorController();
        TelaInicialController controller = new TelaInicialController();
        stage = primaryStage;

        Parent telaSimulacao = FXMLLoader.load(getClass().getResource("ProdutorConsumidor.fxml"));
        sceneSimulacao = new Scene(telaSimulacao);

        Parent telaInicial = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        sceneInicial = new Scene(telaInicial);

        stage.setResizable(false); // Trava o tamanho da tela
        stage.setScene(sceneInicial);
        stage.show(); // Mostra a tela
    }

    public static void trocarTela(String arg) {
        switch(arg) {
            case "Inicial": {
                stage.setScene(sceneInicial);

                break;
            }
            case "Simulacao": {
                stage.setScene(sceneSimulacao);

                break;
            }
        }
    }
}