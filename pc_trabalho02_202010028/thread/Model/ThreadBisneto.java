/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: 13/03/2022
* Nome.............: Thread do bisneto
* Funcao...........: Atualiza o programa com as informacoes do bisneto
*************************************************************** */

package Model;

import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class ThreadBisneto extends Thread {
    /* A classe possui um botao que representa a pessoa que ira nascer e morrer ao passar do tempo 
    e possui tambem uma linha que indicara o parentesco da pessoa com o resto da familia */
    Button bisnetoButton;
    Line lineBisneto;

    public ThreadBisneto(Button bisnetoButton, Line lineBisneto) { // Construtor
        this.bisnetoButton = bisnetoButton;
        this.lineBisneto = lineBisneto;
        bisnetoButton.setVisible(false); // Inicia a simulacao com o botao invisivel
        lineBisneto.setVisible(false); // Inicia a simulacao com a linha invisivel
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void run() { // Inicio da thread
        try { sleep(68000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(12000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da Thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do bisneto
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        bisnetoButton.setVisible(true); // Mostra o botao na tela
        bisnetoButton.setStyle("-fx-background-color: linear-gradient(#2AFF00, #0EAF13);"); // Muda a cor do botao para verde
        lineBisneto.setVisible(true); // Mostra a linha na tela
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do bisneto
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        bisnetoButton.setStyle("-fx-background-color: #ff0000; "); // Muda a cor do botao para vermelho
    } // Fim do metodo morre
}
