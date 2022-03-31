package Model;

public class Consumidor extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 11; i++) {
            Buffer.consumir(this.getName());
            try { sleep(0); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
