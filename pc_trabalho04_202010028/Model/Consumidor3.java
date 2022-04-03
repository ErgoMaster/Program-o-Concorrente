/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 03/04/2022
* Nome.............: Consumidor 2
* Funcao...........: Thread do consumidor 2 que modifica os elementos graficos no programa
*************************************************************** */

package Model;

public class Consumidor3 extends Thread {
    private int velocidade; // Indica a velocidade da thread

    // Construtor
    public Consumidor3(int velocidade) {
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

            Buffer.changeConsumiuImage(3, 1); // Modifica o image view da exclacao para opacidade 100%
            try { sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.changeConsumiuImage(3, 2); // Modifica o image view da exclacao para opacidade 20%

            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
