/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Vermelho
* Funcao...........: Controla o carro vermelho da simulacao
*************************************************************** */

package Model;

import javafx.scene.image.ImageView;

public class CarroVermelho extends Thread {
    private double x;
    private double y;
    private int velocidade;
    private ImageView carro;

    public CarroVermelho(int velocidade, ImageView carro) {
        this.velocidade = velocidade;
        this.carro = carro;

        x = carro.getX();
        y = carro.getY();
    }
}
