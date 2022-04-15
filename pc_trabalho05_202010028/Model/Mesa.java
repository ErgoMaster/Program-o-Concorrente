package Model;

import java.util.concurrent.Semaphore;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mesa {
    private final static int PENSANDO = 0;
    private final static int COMENDO = 1;
    private final static int FOME = 2;

    private static Semaphore mutex = new Semaphore(1);
    private static int[] estadosDosFilosofos = {0, 0, 0, 0, 0};
    private static Semaphore semaforosParaGarfos[] = {new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)};

    private static ImageView garfo0, garfo1, garfo2, garfo3, garfo4;
    private static ImageView estadoFilosofo0, estadoFilosofo1, estadoFilosofo2, estadoFilosofo3, estadoFilosofo4;

    private static Image garfoOcupado = new Image("Img/IMGGarfoOcupado.png");
    private static Image garfoLivre = new Image("Img/IMGGarfoLivre.png");
    private static Image estadoPensando = new Image("Img/IMGFilosofoPensando.png");
    private static Image estadoComendo = new Image("Img/IMGFilosofoComendo.png");

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

        for(int i = 0; i < 5; i++) {
            try { semaforosParaGarfos[i].acquire(); } 
            catch (InterruptedException e) { e.printStackTrace(); }
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
                garfo0.setImage(garfoLivre);
                garfo1.setImage(garfoLivre);

                break;
            }
            case 1: {
                garfo1.setImage(garfoLivre);
                garfo2.setImage(garfoLivre);

                break;
            }
            case 2: {
                garfo2.setImage(garfoLivre);
                garfo3.setImage(garfoLivre);

                break;
            }
            case 3: {
                garfo3.setImage(garfoLivre);
                garfo4.setImage(garfoLivre);

                break;
            }
            case 4: {
                garfo4.setImage(garfoLivre);
                garfo0.setImage(garfoLivre);
                
                break;
            }
        }

        tentarObterGarfos(idFiloEsquerda, ((id + 3) % 5), id);
        tentarObterGarfos(idFiloDireita, id, ((id + 2) % 5));
        
        mutex.release();
    }

    public static void comer(int id) throws InterruptedException {
        mutex.acquire();
        
        switch(id) {
            case 0: {
                garfo0.setImage(garfoOcupado);
                garfo1.setImage(garfoOcupado);
                estadoFilosofo0.setImage(estadoComendo);

                break;
            }
            case 1: {
                garfo1.setImage(garfoOcupado);
                garfo2.setImage(garfoOcupado);
                estadoFilosofo1.setImage(estadoComendo);

                break;
            }
            case 2: {
                garfo2.setImage(garfoOcupado);
                garfo3.setImage(garfoOcupado);
                estadoFilosofo2.setImage(estadoComendo);

                break;
            }
            case 3: {
                garfo3.setImage(garfoOcupado);
                garfo4.setImage(garfoOcupado);
                estadoFilosofo3.setImage(estadoComendo);

                break;
            }
            case 4: {
                garfo4.setImage(garfoOcupado);
                garfo0.setImage(garfoOcupado);
                estadoFilosofo4.setImage(estadoComendo);
                
                break;
            }
        }

        mutex.release();
    }

    public static void pensar(int id) throws InterruptedException {
        mutex.acquire();

        switch(id) {
            case 0: {
                estadoFilosofo0.setImage(estadoPensando);

                break;
            }
            case 1: {
                estadoFilosofo1.setImage(estadoPensando);

                break;
            }
            case 2: {
                estadoFilosofo2.setImage(estadoPensando);

                break;
            }
            case 3: {
                estadoFilosofo3.setImage(estadoPensando);

                break;
            }
            case 4: {
                estadoFilosofo4.setImage(estadoPensando);

                break;
            }
        }

        mutex.release();
    }
}
