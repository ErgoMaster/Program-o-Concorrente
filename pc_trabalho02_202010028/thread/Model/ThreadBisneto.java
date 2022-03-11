/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/03/2022
* Ultima alteracao.: xx
* Nome.............: Thread do bisneto
* Funcao...........: Atualiza o programa com as informacoes do bisneto
*************************************************************** */

package Model;

public class ThreadBisneto extends Thread {
    public void run() { // Inicio da thread
        try { sleep(68000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        nasce();
        try { sleep(12000); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        morre();
    } // Fim da Thread

    /* ***************************************************************
    * Metodo: nasce
    * Funcao: Atualiza a interface com o nascimento do bisneto
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void nasce() {
        System.out.println("Nasce o bisneto 1 (filho 1) - o pai tem 68 anos");
    } // Fim do metodo nasce

    /* ***************************************************************
    * Metodo: morre
    * Funcao: Atualiza a interface com a morte do bisneto
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void morre() {
        System.out.println("Morre o bisneto 1 (filho 1) - o pai tem 80 anos");
    } // Fim do metodo morre
}
