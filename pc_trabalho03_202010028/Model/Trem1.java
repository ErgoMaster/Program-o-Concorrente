/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 20/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Trem 1
* Funcao...........: Modifica a posicao do trem 1 na simulacao
*************************************************************** */

package Model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Trem1 extends Thread {
    private ImageView trem; // Image view que sera movido
    private int velocidade; // Velocidade da animacao
    private double x; // Posicao x do image view
    private double y; // Posicao y do image view

    // Construtor 
    public Trem1(ImageView tremNovo, int velocidade) {
        this.trem = tremNovo;
        this.velocidade = velocidade;

        x = tremNovo.getX();
        y = tremNovo.getY();
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    @Override
    public void run() {
        try {
            // Região nao critica 1
            moveTremPonto1();
            moveTremParada();

            // Região crítica
            try { Semaforo.getMutex().acquire(); } // Trava regiao critica
            catch (InterruptedException e) { e.printStackTrace(); }
            moveTremTunel();
            Semaforo.getMutex().release(); // Libera regiao critica

            // Região nao critica 2
            moveTremPonto2();
            moveTremPonto3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* ***************************************************************
    * Metodo: moveTremPonto1
    * Funcao: Move o image view do trem para a direita
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void moveTremPonto1() throws InterruptedException {
        while(x != 150) {
            Thread.sleep(velocidade); // Controle da velocidade do trem

            final double CONST = x;
            Platform.runLater( () -> trem.setX(CONST)); // Seta a nova coordenada x do image view

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: moveTremParada
    * Funcao: Move o image view do trem em diagonal para o ponto antecessor a regiao critica
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void moveTremParada() throws InterruptedException {
        while(x != 200 && y != 100) {
            Thread.sleep(velocidade); // Controle da velocidade do trem

            final double CONST = x;
            final double CONST2 = y;
            Platform.runLater( () -> trem.setX(CONST)); // Seta a nova coordenada x do image view
            Platform.runLater( () -> trem.setY(CONST2)); // Seta a nova coordenada y do image view

            x++;
            y++;
        }
    }

    /* ***************************************************************
    * Metodo: moveTremTunel
    * Funcao: Move o image view do trem para a direita pela regiao critica
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void moveTremTunel() throws InterruptedException {
        while(x != 400) {
            Thread.sleep(velocidade); // Controle da velocidade do trem

            final double CONST = x;
            Platform.runLater( () -> trem.setX(CONST)); // Seta a nova coordenada x do image view

            x++;
        }
    }

    /* ***************************************************************
    * Metodo: moveTremPonto2
    * Funcao: Move o image view do trem em diagonal para finalizar o percurso
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void moveTremPonto2() throws InterruptedException {
        while(x != 450 && y != 0) {
            Thread.sleep(velocidade); // Controle da velocidade do trem

            final double CONST = x;
            final double CONST2 = y;
            Platform.runLater( () -> trem.setX(CONST)); // Seta a nova coordenada x do image view
            Platform.runLater( () -> trem.setY(CONST2)); // Seta a nova coordenada y do image view

            x++;
            y++;
        }
    }

    /* ***************************************************************
    * Metodo: moveTremPonto3
    * Funcao: Move o image view do trem para a direita afim de terminar o persurso
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void moveTremPonto3() throws InterruptedException {
        while(x != 620) {
            Thread.sleep(velocidade); // Controle da velocidade do trem

            final double CONST = x;
            Platform.runLater( () -> trem.setX(CONST)); // Seta a nova coordenada x do image view

            x++;
        }
    }
}
