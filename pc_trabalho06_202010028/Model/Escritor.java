/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: 06/05/2022
* Nome.............: Escritor
* Funcao...........: Modificar os elementos gráficos do programa
*************************************************************** */

package Model;

public class Escritor extends Thread {
    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    @Override
    public void run() { 
        while(true) { 
            try {  
                sleep(5000);
                Variaveis.liberarVariasCadeiras(Variaveis.criaStackDeCadeiras()); // Libera algumas cadeiras
                Variaveis.changeLabelEscritor(1); // Atualiza o label correspondente
                sleep(1000);

                Variaveis.getDados().acquire();  // Trava a regiao critica da base de dados 
                
                Variaveis.travarVariasCadeiras(); // Altera base de dados
                Variaveis.changeLabelEscritor(0); // Atualiza o label correspondente
                sleep(5000);

                Variaveis.getDados().release(); // Libera a regiao critica da base de dados
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            }
        } 
    } 
}
