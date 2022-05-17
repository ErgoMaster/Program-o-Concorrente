/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Vermelho
* Funcao...........: Controla o carro vermelho da simulacao
*************************************************************** */

package Model;

public class CarroVermelho extends Thread {
    private int velocidade;

    public CarroVermelho(int velocidade) {
        this.velocidade = velocidade;
    }
}
