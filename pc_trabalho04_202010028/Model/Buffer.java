package Model;

import java.util.concurrent.Semaphore;

public class Buffer {
    private static Semaphore mutex, cheio, vazio;
    private static int numero;

    public Buffer(Semaphore mutexNovo, Semaphore cheioNovo, Semaphore vazioNovo) {
        mutex = mutexNovo;
        cheio = cheioNovo;
        vazio = vazioNovo;
    }

    public static void produzir(String idThread, int valor) {
        try { 
            vazio.acquire(); 
            mutex.acquire();

            numero = valor;
            System.out.println("Produtor " + idThread + " produziu o valor: " + valor);
        }  
        catch (InterruptedException e) { e.printStackTrace(); }
        finally {
            cheio.release();
            mutex.release();
        }        
    }

    public static void consumir(String idThread) {
        try { 
            cheio.acquire(); 
            mutex.acquire();

            System.out.println("Consumidor " + idThread + " consumiu o valor: " + numero);
        }   
        catch (InterruptedException e) { e.printStackTrace(); }
        finally {
            vazio.release();
            mutex.release();
        }   
    }
}
