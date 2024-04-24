/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 17/04/2022
* Nome.............: Thread do filosofo 3
* Funcao...........: Chamar os metodos de comer e pensar do filosofo dentro do programa
*************************************************************** */

package Model;

public class FilosofoThread3 extends Thread {
    private final static int FILOSOFO_ESQUERDA = 2; // Id do filosofo que esta a sua esquerda
    private final static int FILOSOFO_DIREITA = 4; // Id do filosofo que esta a sua direita

    private int id = 3; // Id do filosofo
    private int duracaoPensamento, duracaoRefeicao; // Tempo que gasta comendo e tempo que gasta pensando
    
    // Construtor
    public FilosofoThread3(int duracaoPensamento, int duracaoRefeicao) {
        this.duracaoPensamento = duracaoPensamento;
        this.duracaoRefeicao = duracaoRefeicao;
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public void run() {
        while(true) {
            try {
                Mesa.pensar(id); // Filosofo comeca a pensar
                sleep(duracaoPensamento); // Tempo que o filosofo leva ṕra pensar
                Mesa.pegarGarfos(id, FILOSOFO_ESQUERDA, FILOSOFO_DIREITA); // Verifica se os seus garfos estao livres
                Mesa.comer(id); // Filosofo come
                sleep(duracaoPensamento); // Tempo que o filosofo leva pra comer
                Mesa.devolverGarfos(id, FILOSOFO_ESQUERDA, FILOSOFO_DIREITA); // Libera os garfos apos comer
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }
}
