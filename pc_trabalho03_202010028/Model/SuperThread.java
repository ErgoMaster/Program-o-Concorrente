/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Super thread
* Funcao...........: Inciar as outras threads da simulacao
*************************************************************** */

package Model;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SuperThread extends Thread {
    // Image view dos trens
    private ImageView trem1ImageView;
    private ImageView trem2ImageView;

    // Velocidade dos trens
    private int velocidadeTrem1;
    private int velocidadeTrem2;

    // Botao principal para iniciar a simulacao
    private Button iniciar;

    // Construtor
    public SuperThread(ImageView trem1ImageView, ImageView trem2ImageView, int velocidadeTrem1, int velocidadeTrem2, Button inciar) {
        this.trem1ImageView = trem1ImageView;
        this.trem2ImageView = trem2ImageView;
        this.velocidadeTrem1 = velocidadeTrem1;
        this.velocidadeTrem2 = velocidadeTrem2;
        this.iniciar = inciar;
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    @Override
    public void run() {
        // Trava o semaforo do botao para que a thread que o desabilita possa habilita-lo apenas ao final do programa
        try { Semaforo.getDisableButton().acquire(); } 
        catch (InterruptedException e) { e.printStackTrace(); }

        // Chamada e inicializacao das threads
        Trem1 trem1 = new Trem1(trem1ImageView, velocidadeTrem1);
        Trem2 trem2 = new Trem2(trem2ImageView, velocidadeTrem2);
        DisableButton disableButton = new DisableButton(iniciar);

        trem1.start();
        trem2.start();
        disableButton.start();

        try {
            /* Espera as threads da simulacao terminar para liberar o semaforo do botao, assim a thread do botao so o habilita
            ao final do programa */
            trem1.join();
            trem2.join();
            Semaforo.getDisableButton().release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
