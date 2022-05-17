/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Azul
* Funcao...........: Controla o carro azul da simulacao
*************************************************************** */

package Model;

import javafx.scene.image.ImageView;

public class CarroAzul extends Thread {
    private double x;
    private double y;
    private int velocidade;
    private ImageView carro;

    public CarroAzul(int velocidade, ImageView carro) {
        this.velocidade = velocidade;
        this.carro = carro;

        x = carro.getX();
        y = carro.getY();
    }

    /*
    @Override
    public void run() {
        try {
            //while(true) {
                
            //}
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void andarRuaX() {

    } */
}
