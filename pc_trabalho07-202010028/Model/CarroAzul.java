/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Azul
* Funcao...........: Controla o carro azul da simulacao
*************************************************************** */

package Model;

public class CarroAzul extends Thread {
    private int velocidade;

    public CarroAzul(int velocidade) {
        this.velocidade = velocidade;
    }
}
