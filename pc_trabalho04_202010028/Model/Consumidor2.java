package Model;

public class Consumidor2 extends Thread {
    private int velocidade;

    public Consumidor2(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void run() {
        while(true) {
            Buffer.consumir();
        }
    }
}
