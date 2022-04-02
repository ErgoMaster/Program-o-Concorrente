package Model;

public class Consumidor2 extends Thread {
    private int velocidade;

    public Consumidor2(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void run() {
        while(true) {
            try { sleep(velocidade + 100); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.consumir(2);
            Buffer.changeConsumiuImage(2, 1);
            try { sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.changeConsumiuImage(2, 2);
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
