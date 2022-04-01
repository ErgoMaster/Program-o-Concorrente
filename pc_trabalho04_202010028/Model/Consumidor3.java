package Model;

public class Consumidor3 extends Thread {
    private int velocidade;

    public Consumidor3(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void run() {
        while(true) {
            Buffer.consumir();
        }
    }
}
