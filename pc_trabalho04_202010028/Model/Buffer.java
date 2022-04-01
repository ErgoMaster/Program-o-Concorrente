package Model;

import java.util.Stack;
import java.util.concurrent.Semaphore;
import javafx.scene.image.ImageView;

public class Buffer {
    private static Semaphore mutex, cheio, vazio;
    private static Stack<Livro> pilha = new Stack<Livro>() {};
    private static ImageView imagem1, imagem2, imagem3, imagem4;

    public Buffer(Semaphore mutexNovo, Semaphore cheioNovo, Semaphore vazioNovo, ImageView imagemNova1, ImageView imagemNova2, ImageView imagemNova3, ImageView imagemNova4) {
        mutex = mutexNovo;
        cheio = cheioNovo;
        vazio = vazioNovo;
        imagem1 = imagemNova1;
        imagem2 = imagemNova2;
        imagem3 = imagemNova3;
        imagem4 = imagemNova4;
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

    public static void consumir() {
        try { 
            cheio.acquire(); 
            mutex.acquire();

            consumiu();
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

    public static void consumiu() {
        setImageViewStyleConsumir(pilha.pop().getID());
        System.out.println("\tConsumidor consumiu um livro");
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
}
