/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: xx
* Nome.............: Thread do pai
* Funcao...........: Atualiza o programa com as informacoes do pai
*************************************************************** */

package Model;

public class ThreadPai extends Thread {
    public void run() { // Inicio da thread
        nasce();
        try { sleep(90000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do pai
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        System.out.println("Nasce o pai");
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do pai
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        System.out.println("Morre o pai aos 90 anos");
    } // Fim do metodo morre
}
