

package Model;

public class Consumidor1 extends Thread {
    private int velocidade;

    public Consumidor1(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void run() {
        while(true) {
            try { sleep(velocidade + 100); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.consumir(1);
            Buffer.changeConsumiuImage(1, 1);
            try { sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.changeConsumiuImage(1, 2);
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
