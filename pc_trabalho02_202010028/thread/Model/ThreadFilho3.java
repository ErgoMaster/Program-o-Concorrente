/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: xx
* Nome.............: Thread do filho 3
* Funcao...........: Atualiza o programa com as informacoes do filho 3
*************************************************************** */

package Model;

public class ThreadFilho3 extends Thread {
    public void run() { // Inicio da thread
        try { sleep(32000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(55000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do filho 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        System.out.println("Nasce o filho 3 - o pai tem 32 anos");
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do filho 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        System.out.println("Morre o filho 3 - o pai tem 87 anos");
    } // Fim do metodo morre
} 
