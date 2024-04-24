/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 03/04/2022
* Nome.............: Produtor
* Funcao...........: Thread do produtor que modifica os elementos graficos no programa
*************************************************************** */

package Model;

public class Produtor extends Thread {
    private int velocidade; // Indica a velocidade da thread
    private int numeroDeLivros; // Quandtidade total de livros que o produtor ira produzir durante a simulacao

    // Construtor
    public Produtor(int velocidade, int numeroDeLivros) {
        this.velocidade = velocidade;
        this.numeroDeLivros = numeroDeLivros;
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    @Override
    public void run() {
        for(int i = 0; i < numeroDeLivros; i++) {
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Simulacao.produzir(); // Produz item
            
            Simulacao.changeProduziuImage(1); // Modifica o image view da exclacao para opacidade 100%
            try { sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Simulacao.changeProduziuImage(2); // Modifica o image view da exclacao para opacidade 20%
            
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
