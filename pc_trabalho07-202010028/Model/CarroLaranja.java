/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Laranja
* Funcao...........: Controla o carro laranja da simulacao
*************************************************************** */

package Model;

public class CarroLaranja extends Thread {
    private int velocidade;

    public CarroLaranja(int velocidade) {
        this.velocidade = velocidade;
    }
}
