/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 13/03/2022
* Ultima alteracao.: 13/03/2022
* Nome.............: Thread simular button disable
* Funcao...........: Desabilita o botao principal no momento de execucao das threads
*************************************************************** */

package Model;

import javafx.scene.control.Button;

public class ThreadSimularButtonDisable extends Thread {
    // Possui um botao que representa o botao principal do programa
    Button simularButton;

    public ThreadSimularButtonDisable(Button simularButton) { // Construtor
        this.simularButton = simularButton; 
        simularButton.setDisable(true); // Desabilita o botao logo apos ser pressionado
    }
    
    public void run() { // Inicio da Thread
        try { sleep(90000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        simularButton.setDisable(false); // Habilita o botao apos o fim da simulacao
    } // Fim da Thread
}
