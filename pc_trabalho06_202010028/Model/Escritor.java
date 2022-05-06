/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: xx
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

                Variaveis.getDados().acquire();  // Trava a regiao critica da base de dados 
                
                Variaveis.travarVariasCadeiras(); // Altera base de dados
                sleep(5000);

                Variaveis.getDados().release(); // Libera a regiao critica da base de dados
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            }
        } 
    } 
}
