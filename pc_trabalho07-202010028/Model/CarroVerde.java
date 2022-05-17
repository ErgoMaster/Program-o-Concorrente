/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Verde
* Funcao...........: Controla o carro verde da simulacao
*************************************************************** */

package Model;

public class CarroVerde extends Thread {
    private int velocidade;

    public CarroVerde(int velocidade) {
        this.velocidade = velocidade;
    }
}
