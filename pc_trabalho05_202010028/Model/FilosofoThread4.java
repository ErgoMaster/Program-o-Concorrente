package Model;

public class FilosofoThread4 extends Thread {
    private final static int FILOSOFO_ESQUERDA = 3;
    private final static int FILOSOFO_DIREITA = 0;

    private int id = 4;
    private int duracaoPensamento, duracaoRefeicao;
    
    public FilosofoThread4(int duracaoPensamento, int duracaoRefeicao) {
        this.duracaoPensamento = duracaoPensamento;
        this.duracaoRefeicao = duracaoRefeicao;
    }

    public void run() {
        while(true) {
            try {
                Mesa.pensar(id);
                sleep(duracaoPensamento);
                Mesa.pegarGarfos(id, FILOSOFO_ESQUERDA, FILOSOFO_DIREITA);
                Mesa.comer(id);
                sleep(duracaoPensamento);
                Mesa.devolverGarfos(id, FILOSOFO_ESQUERDA, FILOSOFO_DIREITA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
