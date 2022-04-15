/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: 13/03/2022
* Nome.............: Thread do neto 2
* Funcao...........: Atualiza o programa com as informacoes do neto 2
*************************************************************** */

package Model;

import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class ThreadNeto2 extends Thread {
    /* A classe possui um botao que representa a pessoa que ira nascer e morrer ao passar do tempo 
    e possui tambem uma linha que indicara o parentesco da pessoa com o resto da familia */
    Button neto2Button;
    Line lineNeto2;

    public ThreadNeto2(Button  neto2Button, Line lineNeto2) { // Construtor
        this.neto2Button = neto2Button;
        this.lineNeto2 = lineNeto2;
        neto2Button.setVisible(false); // Inicia a simulacao com o botao invisivel
        lineNeto2.setVisible(false); // Inicia a simulacao com a linha invisivel
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void run() { // Inicio da thread
        try { sleep(45000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(33000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do neto 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        neto2Button.setVisible(true); // Mostra o botao na tela
        neto2Button.setStyle("-fx-background-color: linear-gradient(#2AFF00, #0EAF13);"); // Muda a cor do botao para verde
        lineNeto2.setVisible(true); // Mostra a linha na tela
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do neto 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        neto2Button.setStyle("-fx-background-color: #ff0000; "); // Muda a cor do botao para vermelho
    } // Fim do metodo morre
}
