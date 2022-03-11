/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: xx
* Nome.............: Thread do filho 2
* Funcao...........: Atualiza o programa com as informacoes do filho 2
*************************************************************** */

package Model;

public class ThreadFilho2 extends Thread {
    public void run() { // Inicio da thread
        try { sleep(25000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(55000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do filho 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        System.out.println("Nasce o filho 2 - o pai tem 25 anos");
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do filho 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        System.out.println("Morre o filho 2 - o pai tem 80 anos");
    } // Fim do metodo morre
} 
