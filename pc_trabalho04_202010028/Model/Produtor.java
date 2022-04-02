

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
            Buffer.changeProduziuImage(1);
            try { sleep(1000); } 
            catch (InterruptedException e) { e.printStackTrace(); }
            Buffer.changeProduziuImage(2);
            try { sleep(velocidade); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
