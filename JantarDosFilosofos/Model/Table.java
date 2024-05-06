/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 06/05/2024
* Nome.............: Table
* Funcao...........: Control animations
*************************************************************** */

package Model;

import java.util.concurrent.Semaphore;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Table {
    // Constants the represent possible philosophers states
    private final static int THINKING = 0;
    private final static int EATING = 1;
    private final static int STARVING = 2;

    private static int[] philosophersStates = { THINKING, THINKING, THINKING, THINKING, THINKING }; // The 5 philosophers state

    // Semaphores
    private static Semaphore mutex = new Semaphore(1); 
    private static Semaphore philosopherSemaphores[] = { new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1) };

    private static ImageView fork0, fork1, fork2, fork3, fork4; 
    private static ImageView philosopherState0, philosopherState1, philosopherState2, philosopherState3, philosopherState4; 

    // Constructor
    public Table(ImageView newFork0, ImageView newFork1, ImageView newFork2, ImageView newFork3, ImageView newFork4, 
    ImageView newPhilosopherState0, ImageView newPhilosopherState1, ImageView newPhilosopherState2, 
    ImageView newPhilosopherState3, ImageView newPhilosopherState4) {
        fork0 = newFork0;
        fork1 = newFork1;
        fork2 = newFork2;
        fork3 = newFork3;
        fork4 = newFork4;

        philosopherState0 = newPhilosopherState0;
        philosopherState1 = newPhilosopherState1;
        philosopherState2 = newPhilosopherState2;
        philosopherState3 = newPhilosopherState3;
        philosopherState4 = newPhilosopherState4;

        // Down all philosophers semaphore
        for(int i = 0; i < 5; i++) {
            try { philosopherSemaphores[i].acquire(); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        } // End for
    } // End constructor

    /* ***************************************************************
    * Metodo: think
    * Funcao: Change the philosopher image view
    * Parametros: id= Philosopher id
    * Retorno: Void
    *************************************************************** */
    public static void think(int id) throws InterruptedException {
        mutex.acquire(); // Close critical region

        switch(id) {
            case 0: {
                philosopherState0.setImage(Gallery.thinkingState); // Change the image view
                break;
            }
            case 1: {
                philosopherState1.setImage(Gallery.thinkingState); // Change the image view
                break;
            }
            case 2: {
                philosopherState2.setImage(Gallery.thinkingState); // Change the image view
                break;
            }
            case 3: {
                philosopherState3.setImage(Gallery.thinkingState); // Change the image view
                break;
            }
            case 4: {
                philosopherState4.setImage(Gallery.thinkingState); // Change the image view
                break;
            }
        } // End switch

        mutex.release(); // Release critical region
    } // End think

    /* ***************************************************************
    * Metodo: takeForks
    * Funcao: Take adjacent forks
    * Parametros: Current, left and right philosophers ids
    * Retorno: Void
    *************************************************************** */
    public static void takeForks(int id, int leftPhilosopherId, int rightPhilosopherId) throws InterruptedException {
        mutex.acquire(); // Close critical region

        philosophersStates[id] = STARVING; // Set current philosopher state to starving
        verifyForks(id, leftPhilosopherId, rightPhilosopherId); // Verify if the adjacent forks are free

        mutex.release(); // release critical region
        philosopherSemaphores[id].acquire(); // Down current philosopher semaphore
    } // End takeForks

    /* ***************************************************************
    * Metodo: tentarObterGarfos 
    * Funcao: Dado um filosofo, verifica se os filosofos adjacentes estao comendo ou nao
    * Parametros: 3 ids, 1 que representa o filosofo que chama o metodo e outros 2 que representam os filosofos adjacentes
    * Retorno: Void
    *************************************************************** */
    private static void verifyForks(int id, int idFiloEsquerda, int idFiloDireita) {
        /* Aqui se verifica se os filosofos da esqueda e da direita estao comendo ou nao, caso pelo menos um deles esteja, o filosofo que chamou
        devera eseperar. Faz tambem uma verificacao se esse filosofo esta ou nao com fome (nesse caso, servira para quando um filosofo liberar os
        seus garfos e assim, liberar os seus vizinhos para comer) */
        if(estadosDosFilosofos[id] == FOME && estadosDosFilosofos[idFiloEsquerda] != COMENDO && estadosDosFilosofos[idFiloDireita] != COMENDO) {
            estadosDosFilosofos[id] = COMENDO; // Seta o estado do filosofo para comendo
            semaforosParaFilosofos[id].release(); // Da um up no semaforo do filosofo que chama o metodo
        }
    }

    /* ***************************************************************
    * Metodo: comer
    * Funcao: Modifica os elementos graficos do programa para indicar que os filosofos estao comendo
    * Parametros: O id do filosofo que chama o metodo
    * Retorno: Void
    *************************************************************** */
    public static void comer(int id) throws InterruptedException {
        mutex.acquire(); // Trava a regiao critica
        
        // Verifica o valor do id e modifica o elemento grafico do filosofo correspondente
        switch(id) {
            case 0: {
                garfo0.setImage(garfoOcupado); // Modifica o image view do garfo a esquerda para indicar que esta ocupado
                garfo1.setImage(garfoOcupado); // Modifica o image view do garfo a direita para indicar que esta ocupado
                estadoFilosofo0.setImage(estadoComendo); // Modifica o image view do filosofo de id 0 para o ponto de exclamacao

                break;
            }
            case 1: {
                garfo1.setImage(garfoOcupado); // Modifica o image view do garfo a esquerda para indicar que esta ocupado
                garfo2.setImage(garfoOcupado); // Modifica o image view do garfo a direita para indicar que esta ocupado
                estadoFilosofo1.setImage(estadoComendo); // Modifica o image view do filosofo de id 1 para o ponto de exclamacao

                break;
            }
            case 2: {
                garfo2.setImage(garfoOcupado); // Modifica o image view do garfo a esquerda para indicar que esta ocupado
                garfo3.setImage(garfoOcupado); // Modifica o image view do garfo a direita para indicar que esta ocupado
                estadoFilosofo2.setImage(estadoComendo); // Modifica o image view do filosofo de id 2 para o ponto de exclamacao

                break;
            }
            case 3: {
                garfo3.setImage(garfoOcupado); // Modifica o image view do garfo a esquerda para indicar que esta ocupado
                garfo4.setImage(garfoOcupado); // Modifica o image view do garfo a direita para indicar que esta ocupado
                estadoFilosofo3.setImage(estadoComendo); // Modifica o image view do filosofo de id 3 para o ponto de exclamacao

                break;
            }
            case 4: {
                garfo4.setImage(garfoOcupado); // Modifica o image view do garfo a esquerda para indicar que esta ocupado
                garfo0.setImage(garfoOcupado); // Modifica o image view do garfo a direita para indicar que esta ocupado
                estadoFilosofo4.setImage(estadoComendo); // Modifica o image view do filosofo de id 4 para o ponto de exclamacao
                
                break;
            }
        } // Fim do switch

        mutex.release(); // Destrava a regiao critica
    }    

    /* ***************************************************************
    * Metodo: devolverGarfos
    * Funcao: Modifica os elementos graficos do programa quando um dado filosofo para de comer
    * Parametros: O id do filosofo que chama o metodo
    * Retorno: Void
    *************************************************************** */
    public static void devolverGarfos(int id, int idFiloEsquerda, int idFiloDireita) throws InterruptedException {
        mutex.acquire(); // Trava a regiao critica

        estadosDosFilosofos[id] = PENSANDO; // Devolve o estado do filosofo para pensando

        // Verifica o valor do id e modifica o elemento grafico do filosofo correspondente
        switch(id) {
            case 0: {
                garfo0.setImage(garfoLivre); // Modifica o image view do garfo a esquerda para indicar que esta livre
                garfo1.setImage(garfoLivre); // Modifica o image view do garfo a direita para indicar que esta livre

                break;
            }
            case 1: {
                garfo1.setImage(garfoLivre); // Modifica o image view do garfo a esquerda para indicar que esta livre
                garfo2.setImage(garfoLivre); // Modifica o image view do garfo a direita para indicar que esta livre

                break;
            }
            case 2: {
                garfo2.setImage(garfoLivre); // Modifica o image view do garfo a esquerda para indicar que esta livre
                garfo3.setImage(garfoLivre); // Modifica o image view do garfo a direita para indicar que esta livre

                break;
            }
            case 3: {
                garfo3.setImage(garfoLivre); // Modifica o image view do garfo a esquerda para indicar que esta livre
                garfo4.setImage(garfoLivre); // Modifica o image view do garfo a direita para indicar que esta livre

                break;
            }
            case 4: {
                garfo4.setImage(garfoLivre); // Modifica o image view do garfo a esquerda para indicar que esta livre
                garfo0.setImage(garfoLivre); // Modifica o image view do garfo a direita para indicar que esta livre
                
                break;
            }
        } // Fim do switch

        tentarObterGarfos(idFiloEsquerda, ((id + 3) % 5), id); // Libera o filosofo da esquerda para que ele possa comer
        tentarObterGarfos(idFiloDireita, id, ((id + 2) % 5)); // Libera o filosofo da direita para que ele possa comer
        
        mutex.release(); // Destrava a regiao critica
    }
} // End class Table
