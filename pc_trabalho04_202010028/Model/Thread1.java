package Model;

public class Thread1 extends Thread {
    public void run() {
        Variavel.setX(Variavel.getX() + 1);
    }
}
