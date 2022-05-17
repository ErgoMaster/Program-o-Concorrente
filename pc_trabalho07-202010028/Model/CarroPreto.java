/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Preto
* Funcao...........: Controla o carro preto da simulacao
*************************************************************** */

package Model;

public class CarroPreto extends Thread {
    private int velocidade;

    public CarroPreto(int velocidade) {
        this.velocidade = velocidade;
    }
}
