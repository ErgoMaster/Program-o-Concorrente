/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: xx
* Nome.............: Thread do neto 2
* Funcao...........: Atualiza o programa com as informacoes do neto 2
*************************************************************** */

package Model;

public class ThreadNeto2 extends Thread {
    public void run() { // Inicio da thread
        try { sleep(45000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(33000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do neto 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        System.out.println("Nasce o neto 2 (filho 2) - o pai tem 45 anos");
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do neto 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        System.out.println("Morre o neto 2 (filho 2) - o pai tem 78 anos");
    } // Fim do metodo morre
}
