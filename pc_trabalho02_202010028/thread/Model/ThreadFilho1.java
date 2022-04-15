/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: 13/03/2022
* Nome.............: Thread do filho 1
* Funcao...........: Atualiza o programa com as informacoes do filho 1
*************************************************************** */

package Model;

import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class ThreadFilho1 extends Thread {
    /* A classe possui um botao que representa a pessoa que ira nascer e morrer ao passar do tempo 
    e possui tambem uma linha que indicara o parentesco da pessoa com o resto da familia */
    Button filho1Button;
    Line lineFilho1;

    public ThreadFilho1(Button  filho1Button, Line lineFilho1) { // Construtor
        this.filho1Button = filho1Button;
        this.lineFilho1 = lineFilho1;
        filho1Button.setVisible(false); // Inicia a simulacao com o botao invisivel
        lineFilho1.setVisible(false); // Inicia a simulacao com a linha invisivel
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void run() { // Inicio da thread
        try { sleep(22000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(61000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da Thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do filho 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        filho1Button.setVisible(true); // Mostra o botao na tela
        filho1Button.setStyle("-fx-background-color: linear-gradient(#2AFF00, #0EAF13);"); // Muda a cor do botao para verde
        lineFilho1.setVisible(true); // Mostra a linha na tela
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do filho 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        filho1Button.setStyle("-fx-background-color: #ff0000; "); // Muda a cor do botao para vermelho
    } // Fim do metodo morre
}
