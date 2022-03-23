/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: xx
* Nome.............: Trem 2
* Funcao...........: Modifica a posicao do trem 2 na simulacao
*************************************************************** */

package Model;

public class Trem2 extends Thread {
    private int self; // Variavel que indica o index representante do trem para a solucao de Peterson

    public Trem2() {
        self = 1; // Para o trem 2, essa variavel sera 1
    }

    public void run() {
        andarAteParada(); // Regiao nao critica 1

        Variavel.setFlag(self, 1); // Indica intecao de passar pela regiao critica
        Variavel.setVez(1 - self); // Seta a vez para a outra thread 

        /* Para esse while teremos: Caso a outra thread tenha interesse em passar pela regiao critica e seja vez dessa thread passar, 
        a thread atual entrara no loop e eseperara a outra thread terminar de executar a regiao critica, caso seja a sua vez de passar 
        ou a outra thread nao tenha interesse, a thread atual continuara normalmente para a regiao critica */
        while(Variavel.getFlagB() == 0 && Variavel.getVez() == 1 - self) {
            // loop de espera
        }

        andarPeloTunel(); // Regiao critica
        Variavel.setVez(0); // Seta a vez para a outra thread
        Variavel.setFlag(self, 0); // Sinaliza que a thread atual nao possui mais interesse em passar pela regiao critica

        terminarTrajeto(); // Regiao nao critica 2
    }

    /* ***************************************************************
    * Metodo: anadrAteParada
    * Funcao: Atualiza o trem atual ate um certo momento antes do tunel
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void andarAteParada() {
        System.out.println("\tAndou com o trem");
        System.out.println("\tAndou com o trem");
        System.out.println("\tAndou com o trem");

        System.out.println("\tChegou no ponto de parada");
    }

    /* ***************************************************************
    * Metodo: andarPeloTunel
    * Funcao: Atualiza o trem atual atual passando pelo tunel
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void andarPeloTunel() {
        System.out.println("\tAndou pelo tunel");
        System.out.println("\tAndou pelo tunel");
    }

    /* ***************************************************************
    * Metodo: terminarTrajeto
    * Funcao: Atualiza o trem atual terminado o trajeto 
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void terminarTrajeto() {
        System.out.println("\tAndou o resto do trajeto");
        System.out.println("\tAndou o resto do trajeto");
        System.out.println("\tAndou o resto do trajeto");

        System.out.println("\tTerminou trajeto");
    }
}
