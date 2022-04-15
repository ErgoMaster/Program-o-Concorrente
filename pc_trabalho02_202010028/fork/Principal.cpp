/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 03/03/2022
* Ultima alteracao.: 10/03/2022
* Nome.............: Processos em C
* Funcao...........: Simulacao de uma arvore genealogica utilizando processos
*************************************************************** */

#include <iostream>
#include <sys/types.h> 
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>

using namespace std;

int main() {
    // Inicio do processo
    pid_t idProcesso;
    cout << "Nasce o pai" << endl;

    idProcesso = fork();

    if(idProcesso == 0) { // Parte do filho 1
        sleep(22);
        cout << "Nasce o filho 1 - o pai tem 22 anos" << endl;
        idProcesso = fork();

        if(idProcesso == 0) { // Parte do neto 1 - Nascer
            sleep(16);
            cout << "Nasce o neto 1 (filho 1) - o pai tem 38 anos" << endl;
            idProcesso = fork();

            if(idProcesso == 0) { // Parte do bisneto - Nascer e morrer
                sleep(30);
                cout << "Nasce o bisneto 1 (filho 1) - o pai tem 68 anos" << endl;

                sleep(12);
                cout << "Morre o bisneto 1 (filho 1) - o pai tem 80 anos" << endl;
                // Fim do processo do bisneto
            } else { // Parte do neto 1 - Morrer
                sleep(35);
                cout << "Morre o neto 1 (filho 1) - o pai tem 73 anos" << endl;
                // Fim do processo do neto 1
            }
        } else { // Parte do filho 1 - Morrer
            sleep(61);
            cout << "Morre o filho 1 - o pai tem 83 anos" << endl;
            // Fim do processo do filho 1
        }
    } else { // Parte do pai + filho 2 e 3
        idProcesso = fork();

        if(idProcesso == 0) { // Parte do filho 2 - Nascer
            sleep(25);
            cout << "Nasce o filho 2 - o pai tem 25 anos" << endl;
            idProcesso = fork();

            if(idProcesso == 0) { // Parte do neto 2 - Nascer e morrer
                sleep(20);
                cout << "Nasce o neto 2 (filho 2) - o pai tem 45 anos" << endl;

                sleep(33);
                cout << "Morre o neto 2 (filho 2) - o pai tem 78 anos" << endl;
                // Fim do processo do neto 2
            } else { // Parte do filho 2 - Morrer
                sleep(55);
                cout << "Morre o filho 2 - o pai tem 80 anos" << endl;
                // Fim do processo do filho 2
            } 
        } else { // Parte do Pai + filho 3
            idProcesso = fork();

            if(idProcesso == 0) { // Parte do filho 3 - Nascer e morrer
                sleep(32);
                cout << "Nasce o filho 3 - o pai tem 32 anos" << endl; 

                sleep(55);
                cout << "Morre o filho 3 - o pai tem 87 anos" << endl;
                // Fim do processo do filho 3
            } else { // Parte do pai - Morrer
                sleep(90);
                cout << "Morre o pai aos 90 anos" << endl;
                // Fim do processo do pai
            } 
        } 
    } 
} // Fim da main