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
    private ImageView trem;
    private int velocidade;
    private double x;
    private double y;

    public Trem1(ImageView tremNovo, int velocidade) {
        this.trem = tremNovo;
        this.velocidade = velocidade;

        x = tremNovo.getX();
        y = tremNovo.getY();
    }

    @Override
    public void run() {
        try {
            // Região não crítica 1
            moveTremPonto1();
            moveTremParada();

            // Região crítica
            try { Semaforo.getMutex().acquire(); } // Trava região crítica
            catch (InterruptedException e) { e.printStackTrace(); }
            moveTremTunel();
            Semaforo.getMutex().release();

            // Região não crítica 2
            moveTremPonto2();
            moveTremPonto3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void moveTremPonto1() throws InterruptedException {
        while(x != 150) {
            Thread.sleep(velocidade);
            final double CONST = x;
            Platform.runLater( () -> trem.setX(CONST));
            x++;
        }
    }

    private void moveTremParada() throws InterruptedException {
        while(x != 200 && y != 100) {
            Thread.sleep(velocidade);
            final double CONST = x;
            final double CONST2 = y;
            Platform.runLater( () -> trem.setX(CONST));
            Platform.runLater( () -> trem.setY(CONST2));
            x++;
            y++;
        }
    }

    private void moveTremTunel() throws InterruptedException {
        while(x != 400) {
            Thread.sleep(velocidade);
            final double CONST = x;
            Platform.runLater( () -> trem.setX(CONST));
            x++;
        }
    }

    private void moveTremPonto2() throws InterruptedException {
        while(x != 450 && y != 200) {
            Thread.sleep(velocidade);
            final double CONST = x;
            final double CONST2 = y;
            Platform.runLater( () -> trem.setX(CONST));
            Platform.runLater( () -> trem.setY(CONST2));
            x++;
            y++;
        }
    }

    private void moveTremPonto3() throws InterruptedException {
        while(x != 600) {
            Thread.sleep(velocidade);
            final double CONST = x;
            Platform.runLater( () -> trem.setX(CONST));
            x++;
        }
    }
}
