/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: 06/05/2022
* Nome.............: Super Thread
* Funcao...........: Thread que chama todas as outras
*************************************************************** */

package Model;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SuperThread extends Thread {
    private ImageView[] imagens; // Array dos image views das cadeiras
    private Label[] labels; // Array dos labels dos leitores
    private Label labelEscritor; // Label do escritor

    // Construtor
    public SuperThread(ImageView[] imagens, Label[] labels, Label labelEscritor) {
        this.imagens = imagens;
        this.labels = labels;
        this.labelEscritor = labelEscritor;
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    @Override
    public void run() {
        Variaveis variaveis = new Variaveis(imagens, labels, labelEscritor); // Passa o array dos image view para a classe estatica Variaveis
        
        // Chamada e inicializacao das threads
        Escritor escritor = new Escritor();
        Leitor0 leitor0 = new Leitor0();
        Leitor1 leitor1 = new Leitor1();
        Leitor2 leitor2 = new Leitor2();
        Leitor3 leitor3 = new Leitor3();

        escritor.start();
        leitor0.start(); 
        leitor1.start();
        leitor2.start();
        leitor3.start();
    }
}
