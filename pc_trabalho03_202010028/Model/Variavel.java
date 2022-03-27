/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Variavel
* Funcao...........: Guarda as variaveis que serao utilizadas pelas threads
*************************************************************** */

package Model;

public class Variavel {
    private static int vez; // Indica de qual thread eh a vez de executar a regiao critica
    private static int flag[] = {0,0}; // Vetor que indica o interesse ou desinteresse das threads em entrar na regiao critica 
    private static int velocidade[] = {0,0}; // Vetor que indica a velocidade dos trens

    /* ***************************************************************
    * Metodo: getVez
    * Funcao: Retorna o valor da variavel vez para a verificacao de quem eh a vez
    * Parametros: Void
    * Retorno: Um int de valor 1 ou 0 com 0 representando o trem 1 e 1 representando o trem 2
    *************************************************************** */
    public static int getVez() { return vez; }  

    /* ***************************************************************
    * Metodo: getFlagA
    * Funcao: Retorna o valor de interesse em entrar na regiao critica do trem 1
    * Parametros:  Void
    * Retorno: Um int de valor 1 ou 0 com 1 representando interesse e 0 representando desinteresse
    *************************************************************** */
    public static int getFlagA() { return flag[0]; }

    /* ***************************************************************
    * Metodo: getFlagB
    * Funcao: Retorna o valor de interesse em entrar na regiao critica do trem 2
    * Parametros:  Void
    * Retorno: Um int de valor 1 ou 0 com 1 representando interesse e 0 representando desinteresse
    *************************************************************** */
    public static int getFlagB() { return flag[1]; }

    /* ***************************************************************
    * Metodo: setVez
    * Funcao: Modifica o valor da variavel vez
    * Parametros: Um int que representa o novo valor da variavel vez
    * Retorno: Void
    *************************************************************** */
    public static void setVez(int vezParametro) { vez = vezParametro; }

    /* ***************************************************************
    * Metodo: setFlag
    * Funcao: Modifica o valor de interesse dado um determinado trem
    * Parametros: Um int "self" que representa o trem que ira mudar seu interesse e outro int que representa o novo valor
    * Retorno: Void
    *************************************************************** */
    public static void setFlag(int self, int valor) {
        switch(self) { // Verificacao do valor de "self"
            case 0: { // Trem 1
                flag[0] = valor; // Modificacao do valor
                break;
            }
            case 1: { // Trem 2
                flag[1] = valor; // Modificacao do valor
                break;
            }
        } // Fim do Switch
    }

    /* ***************************************************************
    * Metodo: getVelocidadeA
    * Funcao: Retorna a velocidade do trem 1
    * Parametros: Void
    * Retorno: Um int que representa a duracao da animacao do trem 1
    *************************************************************** */
    public static int getVelocidadeA() { return velocidade[0]; }

    /* ***************************************************************
    * Metodo: getVelocidadeB
    * Funcao: Retorna a velocidade do trem 2
    * Parametros: Void
    * Retorno: Um int que representa a duracao da animacao do trem 2
    *************************************************************** */
    public static int getVelocidadeB() { return velocidade[1]; }

    /* ***************************************************************
    * Metodo: setVelocidade
    * Funcao: Modifica o valor de velocidade dado um trem
    * Parametros: Um int self que representa o trem que sofrerar a mudanca e um int valor que sera o novo valor da velocidade
    * Retorno: Void
    *************************************************************** */
    public static void setVelocidade(int self, int valor) {
        switch(self) { // Verificacao do valor de "self"
            case 0: { // Trem 1
                velocidade[0] = valor; // Modificacao do valor
                break;
            }
            case 1: { // Trem 2
                velocidade[1] = valor; // Modificacao do valor
                break;
            }
        } // Fim do Switch
    }
}