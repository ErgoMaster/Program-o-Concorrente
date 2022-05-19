/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Preto
* Funcao...........: Controla o carro preto da simulacao
*************************************************************** */

package Model;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class CarroPreto extends Thread {
    private double x;
    private double y;
    private int velocidade;
    private ImageView carro;
    private Slider sliderVelocidade;

    public CarroPreto(int velocidade, ImageView carro, Slider sliderVelocidade) {
        this.velocidade = velocidade;
        this.carro = carro;
        this.sliderVelocidade = sliderVelocidade;

        x = carro.getX();
        y = carro.getY();
    }

    private void atualizarVelocidade() {
        velocidade = (int) sliderVelocidade.getValue();
    }

    @Override
    public void run() {
        boolean primeraVez = true; 

        try {
            //while(true) {
                atualizarVelocidade();
                andarRuaX();

                primeraVez = false;
            //}
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void andarRuaX() throws InterruptedException {
        while(y != -66) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }
}
