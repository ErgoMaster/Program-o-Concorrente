package Model;

public class FilosofoThread3 extends Thread {
    private final static int FILOSOFO_ESQUERDA = 2;
    private final static int FILOSOFO_DIREITA = 4;

    private int id = 3;
    private int duracaoPensamento, duracaoRefeicao;
    
    public FilosofoThread3(int duracaoPensamento, int duracaoRefeicao) {
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
