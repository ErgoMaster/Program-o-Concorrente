/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Roxo
* Funcao...........: Controla o carro roxo da simulacao
*************************************************************** */

package Model;

public class CarroRoxo extends Thread {
    private int velocidade;

    public CarroRoxo(int velocidade) {
        this.velocidade = velocidade;
    }
}
