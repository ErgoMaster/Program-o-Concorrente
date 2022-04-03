/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 03/04/2022
* Nome.............: Consumidor 1
* Funcao...........: Thread do consumidor 1 que modifica os elementos graficos no programa
*************************************************************** */

package Model;

public class Consumidor1 extends Thread {
    private int velocidade; // Indica a velocidade da thread

    // Construtor
    public Consumidor1(int velocidade) {
        this.velocidade = velocidade;
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    @Override
    public void run() {
        while(true) {
            try { sleep(velocidade + 100); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.consumir(); // Consome item

            Buffer.changeConsumiuImage(1, 1); // Modifica o image view da exclacao para opacidade 100%
            try { sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.changeConsumiuImage(1, 2); // Modifica o image view da exclacao para opacidade 20%

            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
