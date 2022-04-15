/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: 13/03/2022
* Nome.............: Thread do pai
* Funcao...........: Atualiza o programa com as informacoes do pai
*************************************************************** */

package Model;

import javafx.scene.control.Button;

public class ThreadPai extends Thread {
    // A classe possui um botao que representa a pessoa que ira nascer e morrer ao passar do tempo 
    Button paiButton; 

    public ThreadPai(Button paiButton) { // Construtor 
        this.paiButton = paiButton;
        paiButton.setVisible(false); // Inicia a simulacao com o botao invisivel
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void run() { // Inicio da thread
        nasce();
        try { sleep(90000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do pai
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        paiButton.setVisible(true); // Mostra o botao na tela
        paiButton.setStyle("-fx-background-color: linear-gradient(#2AFF00, #0EAF13);"); // Muda a cor do botao para verde
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do pai
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        paiButton.setStyle("-fx-background-color: #ff0000; "); // Muda a cor do botao para vermelho
    } // Fim do metodo morre
}
