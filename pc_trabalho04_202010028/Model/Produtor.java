

package Model;

public class Produtor extends Thread {
    private int velocidade;
    private int numeroDeLivros;

    public Produtor(int velocidade, int numeroDeLivros) {
        this.velocidade = velocidade;
        this.numeroDeLivros = numeroDeLivros;
    }

    @Override
    public void run() {
        for(int i = 0; i < numeroDeLivros; i++) {
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.produzir();
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
