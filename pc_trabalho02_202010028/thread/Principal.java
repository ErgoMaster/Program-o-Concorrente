/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: 13/03/2022
* Nome.............: Arvore genealogica
* Funcao...........: Simula uma arvore genealogica ao passar do tempo
*************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.ArvoreGenealogicaController;

public class Principal extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Inicializacao da tela fxml
        ArvoreGenealogicaController controller = new ArvoreGenealogicaController();
        Parent root = FXMLLoader.load(getClass().getResource("View/ArvoreGenealogica.fxml"));
        Scene scene = new Scene(root);

        stage.setResizable(false); // Trava o tamanho da tela
        stage.setScene(scene);
        stage.show(); // Mostra a tela
    }
}
