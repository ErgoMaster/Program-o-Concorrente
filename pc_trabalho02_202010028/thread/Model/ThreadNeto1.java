/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: xx
* Nome.............: Thread do neto 1
* Funcao...........: Atualiza o programa com as informacoes do neto 1
*************************************************************** */

package Model;

public class ThreadNeto1 extends Thread {
    public void run() { // Inicio da thread
        try { sleep(38000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(35000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do neto 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        System.out.println("Nasce o neto 1 (filho 1) - o pai tem 38 anos");
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do neto 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        System.out.println("Morre o neto 1 (filho 1) - o pai tem 73 anos");
    } // Fim do metodo morre
}
