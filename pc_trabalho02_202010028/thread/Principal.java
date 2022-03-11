/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: xx
* Nome.............: Arvore genealogica
* Funcao...........: Simula uma arvore genealogica ao passar do tempo
*************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
import Model.ThreadBisneto;
import Model.ThreadFilho1;
import Model.ThreadFilho2;
import Model.ThreadFilho3;
import Model.ThreadNeto1;
import Model.ThreadNeto2;
import Model.ThreadPai;
*/

public class Principal extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ArvoreGenealogica.fxml"));
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
