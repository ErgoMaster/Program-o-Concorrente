/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: 13/03/2022
* Nome.............: Thread do filho 3
* Funcao...........: Atualiza o programa com as informacoes do filho 3
*************************************************************** */

package Model;

import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class ThreadFilho3 extends Thread {
    /* A classe possui um botao que representa a pessoa que ira nascer e morrer ao passar do tempo 
    e possui tambem uma linha que indicara o parentesco da pessoa com o resto da familia*/
    Button filho3Button;
    Line lineFilho3;

    public ThreadFilho3(Button  filho3Button, Line lineFilho3) { // Construtor
        this.filho3Button = filho3Button;
        this.lineFilho3 = lineFilho3;
        filho3Button.setVisible(false); // Inicia a simulacao com o botao invisivel
        lineFilho3.setVisible(false); // Inicia a simulacao com a linha invisivel
    }

    public void run() { // Inicio da thread
        try { sleep(32000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(55000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do filho 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        filho3Button.setVisible(true); // Mostra o botao na tela
        filho3Button.setStyle("-fx-background-color: linear-gradient(#2AFF00, #0EAF13);"); // Muda a cor do botao para verde
        lineFilho3.setVisible(true); // Mostra a linha na tela
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do filho 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        filho3Button.setStyle("-fx-background-color: #ff0000; "); // Muda a cor do botao para vermelho
    } // Fim do metodo morre
} 
