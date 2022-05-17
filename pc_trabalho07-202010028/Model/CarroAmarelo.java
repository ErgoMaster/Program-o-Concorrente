/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Amarelo
* Funcao...........: Controla o carro amarelo da simulacao
*************************************************************** */

package Model;

public class CarroAmarelo extends Thread {
    private int velocidade;

    public CarroAmarelo(int velocidade) {
        this.velocidade = velocidade;
    }
}
