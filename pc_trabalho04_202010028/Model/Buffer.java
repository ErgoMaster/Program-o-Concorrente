/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 03/04/2022
* Nome.............: Buffer
* Funcao...........: Classe estatica que guarda a pilha que sera usada na simulacao
*************************************************************** */

package Model;

import java.util.Stack;
import java.util.concurrent.Semaphore;
import javafx.scene.image.ImageView;

public class Buffer {
    // Semaforos
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore cheio = new Semaphore(0);
    private static Semaphore vazio = new Semaphore(4);

    // Pilha que guarda os livros que foram produzidos pelo produtor
    private static Stack<Livro> pilha = new Stack<Livro>() {}; 

    // Todos os image view que serao usados como elementos graficos no programa
    private static ImageView imagem1, imagem2, imagem3, imagem4; // Image view dos livros
    private static ImageView imagemProduziu; // Image view do produtor que indicara quando que houve uma producao
    private static ImageView imagemConsumiu; // Image view do consumidor que indicara quando que houve um consumo

    // Atribuicao atraves do construtor dos image views
    public Buffer(ImageView imagemNova1, ImageView imagemNova2, ImageView imagemNova3, ImageView imagemNova4, ImageView imagemProduziuNovo, ImageView imagemConsumiu1Novo) {
        imagem1 = imagemNova1;
        imagem2 = imagemNova2;
        imagem3 = imagemNova3;
        imagem4 = imagemNova4;
        imagemProduziu = imagemProduziuNovo;
        imagemConsumiu = imagemConsumiuNovo;
    }

    /* ***************************************************************
    * Metodo: prodzir
    * Funcao: Atualiza os image view no programa e adiciona um livro na pilha de producao
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void produzir() {
        try { 
            Livro livro = new Livro(pilha); // Cria um novo livro

            vazio.acquire(); // Diminui um valor do semaforo vazio para travar um consumidor caso seja necessario
            mutex.acquire(); // Trava o acesso a regiao critica

            produziu(livro, livro.getID()); // Produz item
        }  
        catch (InterruptedException e) { e.printStackTrace(); }
        finally { 
            cheio.release(); // Aumenta um valor do semaforo cheio para travar a si proprio caso seja necessario
            mutex.release(); // Libera o acesso a regiao critica
        }        
    }

    /* ***************************************************************
    * Metodo: consumir
    * Funcao: Atualiza os image view no programa e remove um livro na pilha de producao
    * Parametros: Um int que indica qual thread fez o consumo
    * Retorno: Void
    *************************************************************** */
    public static void consumir() {
        try { 
            cheio.acquire(); // Diminui um valor do semaforo cheio para travar um produtor caso seja necessario
            mutex.acquire(); // Trava o acesso a regiao critica

            consumiu(); // Consome item
        }   
        catch (InterruptedException e) { e.printStackTrace(); }
        finally {
            vazio.release(); // Aumenta um valor do semaforo vazio para travar a si proprio caso seja necessario
            mutex.release(); // Libera o acesso a regiao critica
        }   
    }

    /* ***************************************************************
    * Metodo: produziu
    * Funcao: Eh o metodo que de fato modifica o programa na producao
    * Parametros: O livro que sera consumido e um int do image view que sera modificado
    * Retorno: Void
    *************************************************************** */
    public static void produziu(Livro valor, int idImageView) {
        pilha.push(valor); // Insere o livro da pilha
        setImageViewStyleProduzir(idImageView); // Modifica o image view 
    }

    /* ***************************************************************
    * Metodo: consumiu
    * Funcao: Eh o metodo que de fato modifica o programa no consumo
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    public static void consumiu() {
        setImageViewStyleConsumir(pilha.pop().getID()); // Modifica o image view 
    }

    /* ***************************************************************
    * Metodo: set image view style - produzir
    * Funcao: Modifica os image view dos livros, dado um id do image view
    * Parametros: Um int que indica o id do image view que sera modificado
    * Retorno: Void
    *************************************************************** */
    public static void setImageViewStyleProduzir(int idImageView) {
        switch(idImageView) {
            case 1: { // Image view do livro 1
                imagem1.setStyle("-fx-opacity: 100%"); // Seta a opacidade do image view para 100%

                break;
            }
            case 2: { // Image view do livro 2
                imagem2.setStyle("-fx-opacity: 100%"); // Seta a opacidade do image view para 100%

                break;
            }
            case 3: { // Image view do livro 3
                imagem3.setStyle("-fx-opacity: 100%"); // Seta a opacidade do image view para 100%

                break;
            }
            case 4: { // Image view do livro 4
                imagem4.setStyle("-fx-opacity: 100%"); // Seta a opacidade do image view para 100%

                break;
            }
        } // Fim do switch
    }

    /* ***************************************************************
    * Metodo: set image view style - consumir
    * Funcao: Modifica os image view dos livros, dado um id do image view
    * Parametros: Um int que indica o id do image view que sera modificado
    * Retorno: Void
    *************************************************************** */
    public static void setImageViewStyleConsumir(int idImageView) {
        switch(idImageView) {
            case 1: { // Image view do livro 1
                imagem1.setStyle("-fx-opacity: 20%"); // Seta a opacidade do image view para 20%

                break;
            }
            case 2: { // Image view do livro 2
                imagem2.setStyle("-fx-opacity: 20%"); // Seta a opacidade do image view para 20%

                break;
            }
            case 3: { // Image view do livro 3
                imagem3.setStyle("-fx-opacity: 20%"); // Seta a opacidade do image view para 20%

                break;
            }
            case 4: { // Image view do livro 4
                imagem4.setStyle("-fx-opacity: 20%"); // Seta a opacidade do image view para 20%

                break;
            }
        } // Fim do switch
    }

    /* ***************************************************************
    * Metodo: change produziu image
    * Funcao: Modifica o image view da "exclamacao" do produtor que indica que algo foi produzido
    * Parametros: Um int que representa qual modificacao sera feita
    * Retorno: Void
    *************************************************************** */
    public static void changeProduziuImage(int index) {
        // Esse metodo sera usado para "piscar" o image view, ou seja, sera usado duas vezes
        switch(index) {
            case 1: { // Modifica o image view para opacidade 100%
                imagemProduziu.setStyle("-fx-opacity: 100%");
                break;
            }
            case 2: { // Modifica o image view para opacidade 20%
                imagemProduziu.setStyle("-fx-opacity: 30%");
                break;
            }
        } // Fim do switch
    }

    /* ***************************************************************
    * Metodo: change consumiu image
    * Funcao: Modifica o image view da "exclamacao" dos consumidores que indica que algo foi consumido
    * Parametros: Um int que representa qual modificacao sera feita e um int que represebta qual exclamacao de qual thread sera modificado
    * Retorno: Void
    *************************************************************** */
    public static void changeConsumiuImage(int index) {
        switch(index) {
            case 1: { // Modifica o image view para opacidade 100%
                imagemConsumiu.setStyle("-fx-opacity: 100%");
                break;
            }
            case 2: { // Modifica o image view para opacidade 20%
                imagemConsumiu.setStyle("-fx-opacity: 30%");
                break;
            }
        } // Fim do switch do estado da "piscada" 
    }
}
