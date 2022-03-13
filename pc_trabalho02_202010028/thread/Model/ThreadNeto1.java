/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: 13/03/2022
* Nome.............: Thread do neto 1
* Funcao...........: Atualiza o programa com as informacoes do neto 1
*************************************************************** */

package Model;

import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class ThreadNeto1 extends Thread {
    /* A classe possui um botao que representa a pessoa que ira nascer e morrer ao passar do tempo 
    e possui tambem uma linha que indicara o parentesco da pessoa com o resto da familia*/
    Button neto1Button;
    Line lineNeto1;

    public ThreadNeto1(Button  neto1Button, Line lineNeto1) { // Construtor
        this.neto1Button = neto1Button;
        this.lineNeto1 = lineNeto1;
        neto1Button.setVisible(false); // Inicia a simulacao com o botao invisivel
        lineNeto1.setVisible(false); // Inicia a simulacao com a linha invisivel
    }

    public void run() { // Inicio da thread
        try { sleep(38000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(35000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do neto 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() { 
        neto1Button.setVisible(true); // Mostra o botao na tela
        neto1Button.setStyle("-fx-background-color: linear-gradient(#2AFF00, #0EAF13);"); // Muda a cor do botao para verde
        lineNeto1.setVisible(true); // Mostra a linha na tela
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do neto 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() { 
        neto1Button.setStyle("-fx-background-color: #ff0000; "); // Muda a cor do botao para vermelho
    } // Fim do metodo morre
}
