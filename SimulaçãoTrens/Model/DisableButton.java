/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Disable button
* Funcao...........: Desativa o botão da simulacao enquanto ela estiver acontecendo
*************************************************************** */

package Model;

import javafx.scene.control.Button;

public class DisableButton extends Thread {
    Button button; // Botao da simulacao

    // Construtor
    public DisableButton(Button button) {
        this.button = button;
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    @Override
    public void run() {
        button.setDisable(true); // Desabilita o botão

        /* Tenta acessar o semaforo que recebera um "down" quando a simulacao iniciar. Dessa forma, essa thread so ira habilitar o botao quando
        a simulacao liberar esse semaforo, ou seja, apenas no fim da simulacao. */
        try { Semaforo.getDisableButton().acquire(); } 
        catch (InterruptedException e) { e.printStackTrace(); }

        button.setDisable(false); // Habilita o botao

        Semaforo.getDisableButton().release(); // Libera o semaforo para a simulacao o travar novamente se necessario
    }
}
