/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 17/04/2022
* Nome.............: Mesa
* Funcao...........: Controlar os aspectos gerais da simulacao
*************************************************************** */

package Model;

import java.util.concurrent.Semaphore;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mesa {
    /* Constantes que representam o estado atual de um filosofo, o qual pode estar com fome (quer entrar na area critica), 
    comendo (esta na area critica) ou pensando (esta fora da area critica) */
    private final static int PENSANDO = 0;
    private final static int COMENDO = 1;
    private final static int FOME = 2;

    private static Semaphore mutex = new Semaphore(1); // Semaforo para travar a area critica
    private static int[] estadosDosFilosofos = {PENSANDO, PENSANDO, PENSANDO, PENSANDO, PENSANDO}; // Vetor que representa os estados dos 5 filosofos 
    private static Semaphore semaforosParaFilosofos[] = {new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)}; // Semaforo para cada filosofo

    private static ImageView garfo0, garfo1, garfo2, garfo3, garfo4; // Image view de cada garfo
    private static ImageView estadoFilosofo0, estadoFilosofo1, estadoFilosofo2, estadoFilosofo3, estadoFilosofo4; // Image view para indicar se o filosofo esta comendo ou pensando

    /* Aqui temos algumas imagens que servirao para indicar o estado de comendo ou de pensando. assim como se um garfos esta livre ou nao.
    Quando um garfo esta livre, estara na cor branca (indicado pelo image "garfoLivre") e quando esta ocupado, ele estara vermelho 
    (indicado pelo image garfoOcupado). Caso um filosofo esteja comendo, seu image view representante sera um ponto de exclamacao 
    (indicado pelo image "estadoComendo") e quando ele esta pensando, seu image view representante sera uma reticencias (]indicado pelo 
    image "estadoPensando") */
    private static Image garfoOcupado = new Image("Img/IMGGarfoOcupado.png");
    private static Image garfoLivre = new Image("Img/IMGGarfoLivre.png");
    private static Image estadoPensando = new Image("Img/IMGFilosofoPensando.png");
    private static Image estadoComendo = new Image("Img/IMGFilosofoComendo.png");

    // Construtor com as atribuicoes dos image view
    public Mesa(ImageView garfo0Novo, ImageView garfo1Novo, ImageView garfo2Novo, ImageView garfo3Novo, ImageView garfo4Novo, 
    ImageView estadoFilosofo0Novo, ImageView estadoFilosofo1Novo, ImageView estadoFilosofo2Novo, ImageView estadoFilosofo3Novo, 
    ImageView estadoFilosofo4Novo) {
        garfo0 = garfo0Novo;
        garfo1 = garfo1Novo;
        garfo2 = garfo2Novo;
        garfo3 = garfo3Novo;
        garfo4 = garfo4Novo;

        estadoFilosofo0 = estadoFilosofo0Novo;
        estadoFilosofo1 = estadoFilosofo1Novo;
        estadoFilosofo2 = estadoFilosofo2Novo;
        estadoFilosofo3 = estadoFilosofo3Novo;
        estadoFilosofo4 = estadoFilosofo4Novo;

        // Da um down nos semaforos de cada filosofo
        for(int i = 0; i < 5; i++) {
            try { semaforosParaFilosofos[i].acquire(); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    /* ***************************************************************
    * Metodo: pensar
    * Funcao: Dado um filosofo, modifica elementos do programa para indicar que o filosofo esta pensando
    * Parametros: O id do filosofo que chama o metodo
    * Retorno: Void
    *************************************************************** */
    public static void pensar(int id) throws InterruptedException {
        mutex.acquire(); // Trava a regiao critica

        // Verifica o valor do id e modifica o elemento grafico do filosofo correspondente
        switch(id) {
            case 0: {
                estadoFilosofo0.setImage(estadoPensando); // Modifica o image view do filosofo de id 0 para as reticencias 

                break;
            }
            case 1: {
                estadoFilosofo1.setImage(estadoPensando); // Modifica o image view do filosofo de id 1 para as reticencias

                break;
            }
            case 2: {
                estadoFilosofo2.setImage(estadoPensando); // Modifica o image view do filosofo de id 2 para as reticencias

                break;
            }
            case 3: {
                estadoFilosofo3.setImage(estadoPensando); // Modifica o image view do filosofo de id 3 para as reticencias

                break;
            }
            case 4: {
                estadoFilosofo4.setImage(estadoPensando); // Modifica o image view do filosofo de id 4 para as reticencias

                break;
            }
        } // Fim do switch

        mutex.release(); // Destrava a regiao critica
    }

    /* ***************************************************************
    * Metodo: pegarGarfos
    * Funcao: Dado um filosofo, verifica se os garfos adjacentes estao livres ou nao
    * Parametros: 3 ids, 1 que representa o filosofo que chama o metodo e outros 2 que representam os filosofos adjacentes
    * Retorno: Void
    *************************************************************** */
    public static void pegarGarfos(int id, int idFiloEsquerda, int idFiloDireita) throws InterruptedException {
        mutex.acquire(); // Trava a regiao critica

        estadosDosFilosofos[id] = FOME; // Seta o estado do filosofo para "com fome"
        tentarObterGarfos(id, idFiloEsquerda, idFiloDireita); // Verifica se os garfos estao livres

        mutex.release(); // Destrava a regiao critica
        semaforosParaFilosofos[id].acquire(); // Da um down no semaforo do filosofo que chama o metodo
    }

    /* ***************************************************************
    * Metodo: tentarObterGarfos 
    * Funcao: Dado um filosofo, verifica se os filosofos adjacentes estao comendo ou nao
    * Parametros: 3 ids, 1 que representa o filosofo que chama o metodo e outros 2 que representam os filosofos adjacentes
    * Retorno: Void
    *************************************************************** */
    private static void tentarObterGarfos(int id, int idFiloEsquerda, int idFiloDireita) {
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
}
