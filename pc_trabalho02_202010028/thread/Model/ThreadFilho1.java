/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: xx
* Nome.............: Thread do filho 1
* Funcao...........: Atualiza o programa com as informacoes do filho 1
*************************************************************** */

package Model;

public class ThreadFilho1 extends Thread {
    public void run() { // Inicio da thread
        try { sleep(22000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(61000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da Thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do filho 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        System.out.println("Nasce o filho 1 - o pai tem 22 anos");
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do filho 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        System.out.println("Morre o filho 1 - o pai tem 83 anos");
    } // Fim do metodo morre
}
