

package Model;

public class Consumidor3 extends Thread {
    private int velocidade;

    public Consumidor3(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void run() {
        while(true) {
            try { sleep(velocidade + 100); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.consumir(3);
            Buffer.changeConsumiuImage(3, 1);
            try { sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.changeConsumiuImage(3, 2);
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
