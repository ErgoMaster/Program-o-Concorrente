package Model;

public class Thread2 extends Thread {
    public void run() {
        Variavel.setX(Variavel.getX() - 1);
    }
}
