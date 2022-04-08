package Model;

import java.util.concurrent.Semaphore;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mesa {
    private final static int PENSANDO = 0;
    private final static int COMENDO = 1;
    private final static int FOME = 2;

    private static Semaphore mutex = new Semaphore(1);
    private static int[] estadosDosFilosofos;
    private static Semaphore[] semaforosParaGarfos;

    private static ImageView garfo0, garfo1, garfo2, garfo3, garfo4;
    private static Image garfoOcupado;

    public Mesa(ImageView garfo0Novo, ImageView garfo1Novo, ImageView garfo2Novo, ImageView garfo3Novo, ImageView garfo4Novo, Image garfoOcupadoNovo) {
        garfo0 = garfo0Novo;
        garfo1 = garfo1Novo;
        garfo2 = garfo2Novo;
        garfo3 = garfo3Novo;
        garfo4 = garfo4Novo;
        garfoOcupado = garfoOcupadoNovo;

        for(int i = 0; i < 5; i++) {
            estadosDosFilosofos[i] = 0;
        }

        for(int i = 0; i < 5; i++) {
            semaforosParaGarfos[i] = new Semaphore(1);
        }
    }

    public static void pegarGarfos(int id, int idFiloEsquerda, int idFiloDireita) throws InterruptedException {
        mutex.acquire();

        estadosDosFilosofos[id] = FOME;
        tentarObterGarfos(id, idFiloEsquerda, idFiloDireita);

        mutex.release();
        semaforosParaGarfos[id].acquire();
    }

    public static void tentarObterGarfos(int id, int idFiloEsquerda, int idFiloDireita) {
        if(estadosDosFilosofos[id] == FOME && estadosDosFilosofos[idFiloEsquerda] != COMENDO && estadosDosFilosofos[idFiloDireita] != COMENDO) {
            estadosDosFilosofos[id] = COMENDO;
            semaforosParaGarfos[id].release();
        }
    }

    public static void devolverGarfos(int id, int idFiloEsquerda, int idFiloDireita) throws InterruptedException {
        mutex.acquire();

        estadosDosFilosofos[id] = PENSANDO;
        switch(id) {
            case 0: {


                break;
            }
            case 1: {


                break;
            }
            case 2: {


                break;
            }
            case 3: {


                break;
            }
            case 4: {


                break;
            }
        }
        
        mutex.release();
    }

    public static void comer(int id, int duracaoRefeicao) throws InterruptedException {
        switch(id) {
            case 0: {
                garfo0.setImage(garfoOcupado);
                garfo1.setImage(garfoOcupado);

                break;
            }
            case 1: {


                break;
            }
            case 2: {


                break;
            }
            case 3: {


                break;
            }
            case 4: {


                break;
            }
        }
        
        Thread.sleep(duracaoRefeicao);
    }

    public static void pensar(int id, int duracaoPensamento) throws InterruptedException {
        switch(id) {
            case 0: {


                break;
            }
            case 1: {


                break;
            }
            case 2: {


                break;
            }
            case 3: {


                break;
            }
            case 4: {


                break;
            }
        }
        Thread.sleep(duracaoPensamento);
    }
}
