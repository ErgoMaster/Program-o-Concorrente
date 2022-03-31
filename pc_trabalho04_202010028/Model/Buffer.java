package Model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Buffer {
    private static Semaphore mutex, cheio, vazio;
    private static Queue<Integer> fila = new LinkedList<>() {};

    public Buffer(Semaphore mutexNovo, Semaphore cheioNovo, Semaphore vazioNovo) {
        mutex = mutexNovo;
        cheio = cheioNovo;
        vazio = vazioNovo;
    }

    public static void produzir(String idThread, int valor) {
        try { 
            vazio.acquire(); 
            mutex.acquire();

            fila.add(valor);
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

            System.out.println("\tConsumidor " + idThread + " consumiu o valor: " + fila.poll());
        }   
        catch (InterruptedException e) { e.printStackTrace(); }
        finally {
            vazio.release();
            mutex.release();
        }   
    }
}
