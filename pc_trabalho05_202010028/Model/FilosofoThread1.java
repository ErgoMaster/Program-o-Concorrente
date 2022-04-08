package Model;

public class FilosofoThread1 extends Thread {
    private final static int FILOSOFO_ESQUERDA = 0;
    private final static int FILOSOFO_DIREITA = 2;

    private int id = 1;
    private int duracaoPensamento, duracaoRefeicao;

    public FilosofoThread1(int duracaoPensamento, int duracaoRefeicao) {
        this.duracaoPensamento = duracaoPensamento;
        this.duracaoRefeicao = duracaoRefeicao;
    }

    public void run() {
        while(true) {
            try {
                Mesa.pensar(id, duracaoPensamento);
                Mesa.pegarGarfos(id, FILOSOFO_ESQUERDA, FILOSOFO_DIREITA);
                Mesa.comer(id, duracaoRefeicao);
                Mesa.devolverGarfos(id, FILOSOFO_ESQUERDA, FILOSOFO_DIREITA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }
}
