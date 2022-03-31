package Model;

public class Produtor extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 11; i++) {
            Buffer.produzir(this.getName(), i);
            try { sleep(0); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
