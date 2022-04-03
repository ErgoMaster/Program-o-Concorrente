/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: xx
* Nome.............: Problema Produtor/Consumidor
* Funcao...........: Simula uma biblioteca em que o produtor fornece livros e o consumidor os aluga
*************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
    private static Stage stage;
    private static Scene sceneSimulacao; // Cena da tela da simulacao
    private static Scene sceneInicial; // Cena da tela inicial 

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
        ProdutorConsumidorController controller0 = new ProdutorConsumidorController(); // Chamada do controller para evitar excecao
        TelaInicialController controller = new TelaInicialController(); // Chamada do controller para evitar excecao
        stage = primaryStage;

        Parent telaSimulacao = FXMLLoader.load(getClass().getResource("FXMLProdutorConsumidor.fxml"));
        sceneSimulacao = new Scene(telaSimulacao);

        Parent telaInicial = FXMLLoader.load(getClass().getResource("FXMLTelaInicial.fxml"));
        sceneInicial = new Scene(telaInicial);

        stage.setResizable(false); // Trava o tamanho da tela
        stage.setScene(sceneInicial);
        stage.show(); // Mostra a tela
    }

    /* ***************************************************************
    * Metodo: trocarTela
    * Funcao: Trocar a tela do menu inicial para a tela da simulacao (e vice-versa)
    * Parametros: String arg que indicara qual tela sera inicializada
    * Retorno: Void
    *************************************************************** */
    public static void trocarTela(String arg) {
        switch(arg) {
            case "Inicial": {
                stage.setScene(sceneInicial); // Seta a tela do menu inicial

                break;
            }
            case "Simulacao": {
                stage.setScene(sceneSimulacao); // Seta a tela da simulacao

                break;
            }
        } // Fim do metodo switch
    }
}