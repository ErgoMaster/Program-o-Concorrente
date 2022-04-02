package Model;

import java.util.Stack;
import java.util.concurrent.Semaphore;
import javafx.scene.image.ImageView;

public class Buffer {
    private static Semaphore mutex, cheio, vazio;
    private static Stack<Livro> pilha = new Stack<Livro>() {};
    private static ImageView imagem1, imagem2, imagem3, imagem4;
    private static ImageView imagemProduziu, imagemConsumiu1, imagemConsumiu2, imagemConsumiu3;

    public Buffer(Semaphore mutexNovo, Semaphore cheioNovo, Semaphore vazioNovo, 
    ImageView imagemNova1, ImageView imagemNova2, ImageView imagemNova3, ImageView imagemNova4, 
    ImageView imagemProduziuNovo, ImageView imagemConsumiu1Novo, ImageView imagemConsumiu2Novo, ImageView imagemConsumiu3Novo) {
        mutex = mutexNovo;
        cheio = cheioNovo;
        vazio = vazioNovo;
        imagem1 = imagemNova1;
        imagem2 = imagemNova2;
        imagem3 = imagemNova3;
        imagem4 = imagemNova4;
        imagemProduziu = imagemProduziuNovo;
        imagemConsumiu1 = imagemConsumiu1Novo;
        imagemConsumiu2 = imagemConsumiu2Novo;
        imagemConsumiu3 = imagemConsumiu3Novo; 
    }

    public static void produzir() {
        try { 
            Livro livro = new Livro(pilha);

            vazio.acquire(); 
            mutex.acquire();

            produziu(livro, livro.getID());
        }  
        catch (InterruptedException e) { e.printStackTrace(); }
        finally {
            cheio.release();
            mutex.release();
        }        
    }

    public static void consumir(int idThread) {
        try { 
            cheio.acquire(); 
            mutex.acquire();

            consumiu(idThread);
        }   
        catch (InterruptedException e) { e.printStackTrace(); }
        finally {
            vazio.release();
            mutex.release();
        }   
    }

    public static void produziu(Livro valor, int idImageView) {
        pilha.push(valor);
        setImageViewStyleProduzir(idImageView);
        System.out.println("Produtor produziu um livro");
    }

    public static void consumiu(int idThread) {
        setImageViewStyleConsumir(pilha.pop().getID());
        System.out.println("\tConsumidor " + idThread + " consumiu um livro");
    }

    public static void setImageViewStyleProduzir(int idImageView) {
        switch(idImageView) {
            case 1: {
                imagem1.setStyle("-fx-opacity: 100%");

                break;
            }
            case 2: {
                imagem2.setStyle("-fx-opacity: 100%");

                break;
            }
            case 3: {
                imagem3.setStyle("-fx-opacity: 100%");

                break;
            }
            case 4: {
                imagem4.setStyle("-fx-opacity: 100%");

                break;
            }
        }
    }

    public static void setImageViewStyleConsumir(int idImageView) {
        switch(idImageView) {
            case 1: {
                imagem1.setStyle("-fx-opacity: 20%");

                break;
            }
            case 2: {
                imagem2.setStyle("-fx-opacity: 20%");

                break;
            }
            case 3: {
                imagem3.setStyle("-fx-opacity: 20%");

                break;
            }
            case 4: {
                imagem4.setStyle("-fx-opacity: 20%");

                break;
            }
        }
    }

    public static void changeProduziuImage(int index) {
        switch(index) {
            case 1: {
                imagemProduziu.setStyle("-fx-opacity: 100%");
                break;
            }
            case 2: {
                imagemProduziu.setStyle("-fx-opacity: 30%");
                break;
            }
        }
    }

    public static void changeConsumiuImage(int idThread, int index) {
        switch(idThread) {
            case 1: {
                switch(index) {
                    case 1: {
                        imagemConsumiu1.setStyle("-fx-opacity: 100%");
                        break;
                    }
                    case 2: {
                        imagemConsumiu1.setStyle("-fx-opacity: 30%");
                        break;
                    }
                }
            }
            case 2: {
                switch(index) {
                    case 1: {
                        imagemConsumiu2.setStyle("-fx-opacity: 100%");
                        break;
                    }
                    case 2: {
                        imagemConsumiu2.setStyle("-fx-opacity: 30%");
                        break;
                    }
                }

                break;
            }
            case 3: {
                switch(index) {
                    case 1: {
                        imagemConsumiu3.setStyle("-fx-opacity: 100%");
                        break;
                    }
                    case 2: {
                        imagemConsumiu3.setStyle("-fx-opacity: 30%");
                        break;
                    }
                }

                break;
            }
        }
    }
}
