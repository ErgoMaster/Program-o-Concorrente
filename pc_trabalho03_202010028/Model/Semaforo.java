package Model;

import java.util.concurrent.Semaphore;

public class Semaforo {
    private static Semaphore mutex = new Semaphore(1);

    public static Semaphore getMutex() { return mutex; }
}
