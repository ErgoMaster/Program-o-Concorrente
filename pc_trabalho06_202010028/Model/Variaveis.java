/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/04/2022
* Ultima alteracao.: xx
* Nome.............: Variaveis
* Funcao...........: Guarda as variaveis e semaforos que irao ser usados no programa
*************************************************************** */

package Model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.Semaphore;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Variaveis {
    private static int leitoresRC; // Variável que controla quantos leitores estão lendo no momento
    private static Semaphore mutex = new Semaphore(1); // Semáforo que controla a entrada dos leitores
    private static Semaphore dados = new Semaphore(1); // Controla a entrada na base de dados
    private static ImageView[] imagens; // Array com os image view das cadeiras

    private static Image cadeiraLivre = new Image("Img/IMGCadeiraLivre.png");
    private static Image cadeiraOcupada = new Image("Img/IMGCadeiraOcupada.png");

    private static int[] cadeiras = new int[20]; // Array que monitora a situacao de uma cadeira, 0 para livre e 1 para ocupada
    private static Queue<Integer> requisicoes = new LinkedList<>(); // Fila com as requiscoes de numero de cadeira feitas pelos leitores

    // Construtor
    public Variaveis(ImageView[] arrayImageViews) {
        imagens = arrayImageViews;

        for(int i = 0; i < 20; i++) {
            cadeiras[i] = 0;
        }
    }

    /* ***************************************************************
    * Metodo: getLeitoresRC
    * Funcao: Retorna a variavel de controle dos leitores
    * Parametros: Void
    * Retorno: int
    *************************************************************** */
    public static int getLeitoresRc() { return leitoresRC; }

    /* ***************************************************************
    * Metodo: getMutex
    * Funcao: Retorna o semaforo que trava o acesso a variavel leitoresRC
    * Parametros: Void
    * Retorno: Semaforo
    *************************************************************** */
    public static Semaphore getMutex() { return mutex; }

    /* ***************************************************************
    * Metodo: getDados
    * Funcao: Retorna o semaforo que trava o acesso a base de dados
    * Parametros: Void
    * Retorno: Semaforo
    *************************************************************** */
    public static Semaphore getDados() { return dados; }

    /* ***************************************************************
    * Metodo: incrementaLeitoresRC
    * Funcao: Aumenta o valor da variavel quando um leitor chega pra ler
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void incrementaLeitoresRC() { leitoresRC++; }

    /* ***************************************************************
    * Metodo: decrementaLeitoresRC
    * Funcao: Aumenta o valor da variavel quando um leitor termina de ler
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void decrementaLeitoresRC() { leitoresRC--; }

    /* ***************************************************************
    * Metodo: geraIndexCadeira
    * Funcao: Retorna o index de uma cadeira que estiver livre
    * Parametros: Void
    * Retorno: int
    *************************************************************** */
    public static int geraIndexCadeira() {
        Random rand = new Random();
        LinkedList<Integer> lista = getListaCadeirasVazias(); // Pega a lista de cadeiras vazias
        int cadeira = 0; // Index da cadeira que será requisitada

        if(!lista.isEmpty()) { // Verifica se a lista nao esta vazia, para evitar excessao
            int number = rand.nextInt(lista.size()); // Gera um numero randomico entre 0 e o tamanho da fila
            cadeira = lista.get(number); // A cadeira sera igual a uma posicao random dentro da lista
        }

        return cadeira;
    }

    /* ***************************************************************
    * Metodo: solicitarcadeira
    * Funcao: Adiciona um valor a fila com o index da posicao da cadeira requerida
    * Parametros: int index
    * Retorno: Void
    *************************************************************** */
    public static void solicitaCadeira(int index) {
        requisicoes.add(index); // Adiciona essa requisicao a fila, para que o escritor leia e modifique a interface
    }

    /* ***************************************************************
    * Metodo: criaStackDeCadeiras
    * Funcao: Cria uma pilha de tamanho entre 0 e 12 com valores das cadeiras que serao liberadas toda vez que o escritor iniciar
    * Parametros: Void
    * Retorno: A pilha de index
    *************************************************************** */
    public static Stack<Integer> criaStackDeCadeiras() {
        Stack<Integer> pilha = new Stack<Integer>(); // Cria a pilha
        LinkedList<Integer> lista = getListaCadeirasOcupadas();  // Pega a lista de cadeiras ocupadas

        Random rand = new Random();
        int len = rand.nextInt(12); // Tamanho da pilha sera um numero entre 0 e 12

        if(!lista.isEmpty()) {
            for(int i = 0; i <= len; i++) { // Adiciona os valores randoms na pilha
                int number = rand.nextInt(lista.size()); // Gera um numero randomico entre 0 e o tamanho da lista
                pilha.push(lista.get(number)); // Adiciona na pilha o index de alguma cadeira que esteja ocupada
            }
        }
        
        lista.clear(); // Limpa a lista para atualiza-la
        return pilha;
    }

    /* ***************************************************************
    * Metodo: liberarVariasCadeiras
    * Funcao: Pega a pilha com os valores das posicoes das cadeiras e modifica o image view correspondente
    * Parametros: int index
    * Retorno: Void
    *************************************************************** */
    public static void liberarVariasCadeiras(Stack<Integer> pilha) {
        while(!pilha.isEmpty()) { // Esvazia a pilha e modifica os image view passando os valores que estavam na pilha como parametro
            liberaCadeira(pilha.pop());
        }
    }

    /* ***************************************************************
    * Metodo: travarVariasCadeiras
    * Funcao: Pega a pilha com os valores das posicoes das cadeiras e modifica o image view correspondente
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void travarVariasCadeiras() {
        while(!requisicoes.isEmpty()) { // Esvazia a fila das requisicoes dos leitores passando os valores que estavam na fila como parametro
            travaCadeira(requisicoes.poll());
        }
    }

    /* ***************************************************************
    * Metodo: liberaCadeira
    * Funcao: Dado um determinado id, muda o image view da cadeira para uma cadeira livre
    * Parametros: Um index que representa a posicao da cadeira requerida dentro do array de image views
    * Retorno: Void
    *************************************************************** */
    public static void liberaCadeira(int index) {
        imagens[index].setImage(cadeiraLivre); // Muda o image view da cadeira para "livre"
        cadeiras[index] = 0; // Atualiza seu estado no array
    }

    /* ***************************************************************
    * Metodo: travaCadeira
    * Funcao: Dado um determinado id, muda o image view da cadeira para uma cadeira ocupada
    * Parametros: Um index que representa a posicao da cadeira requerida dentro do array de image views
    * Retorno: Void
    *************************************************************** */
    public static void travaCadeira(int index) {
        imagens[index].setImage(cadeiraOcupada); // Muda o image view da cadeira para "ocupada"
        cadeiras[index] = 1; // Atualiza seu estado no array
    }

    /* ***************************************************************
    * Metodo: getListaCadeirasOcupadas
    * Funcao: Do array dos estados das cadeiras, gera uma lista que possui os index das cadeiras ocupadas
    * Parametros: Void
    * Retorno: List
    *************************************************************** */
    private static LinkedList<Integer> getListaCadeirasOcupadas() {
        LinkedList<Integer> lista = new LinkedList<>(); // Cria a lista

        for(int i = 0; i < 20; i++) { // Itera sobre o array
            if(cadeiras[i] == 1) { // Adiciona o index na lista quando o estado dessa cadeira esta ocupado (valor = 1)
                lista.add(i);
            }
        }

        return lista; // Retorna a lista
    }

    /* ***************************************************************
    * Metodo: getListaCadeirasVazias
    * Funcao: Do array dos estados das cadeiras, gera uma lista que possui os index das cadeiras livres
    * Parametros: Void
    * Retorno: List
    *************************************************************** */
    private static LinkedList<Integer> getListaCadeirasVazias() {
        LinkedList<Integer> lista = new LinkedList<>(); // Cria a lista

        for(int i = 0; i < 20; i++) { // Itera sobre o array
            if(cadeiras[i] == 0) { // Adiciona o index na lista quando o estado dessa cadeira esta livre (valor = 0)
                lista.add(i);
            }
        }

        return lista; // Retorna a lista
    }
}
