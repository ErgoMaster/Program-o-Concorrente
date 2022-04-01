

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
            Buffer.consumir();
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
