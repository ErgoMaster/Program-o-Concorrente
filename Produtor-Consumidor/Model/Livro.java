/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 03/04/2022
* Nome.............: Livro
* Funcao...........: Indicar o livro que sera produzido e consumido
*************************************************************** */

package Model;

import java.util.Stack;

public class Livro {
    private int id; // Id do livro que servira para indicar qual image view deve ser modificado

    public Livro(Stack<Livro> pilha) {
        /* O id de um novo livro a ser criado vai de 1 a 4, ou seja, sera o tamanho da pilha (que iniciara com 0) + 1,
        dessa forma, o primeiro livro a ser criado ou consumido sera indicado pelo image view 1, o segundo a ser criado, 
        ou consumido, pelo image view 2 e assim por diante. Esse id sera passado como parametro na hora de produzir ou consumir 
        para a modificacao correta do image view */
        id = pilha.size() + 1; 
    }

    /* ***************************************************************
    * Metodo: get id
    * Funcao: Retorna o id do livro
    * Parametros: Stage
    * Retorno: Void
    *************************************************************** */
    public int getID() { return id; }
}
