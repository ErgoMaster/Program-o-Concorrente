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

int main() { // Início da main
    // Para cada ano representado no problema, sera passado um comando sleep(x) que pausara o programa em x segundos
    // Declaracao dos processos que serao utilizados
    pid_t pID1;
    pid_t pID2;
    pid_t pID3;
    pid_t pID4;
    pid_t pID5;

    pID1 = fork(); // Inicio do processo 1

    switch(pID1) { 
        case 0: { // Processo do filho 1
            sleep(22); 
            cout << "Nasce o filho 1 - o pai tem 22 anos" << endl; // Nasce o filho 1

            pID2 = fork(); // Inicio do processo 2

            switch(pID2) {
                case 0: { // Processso do filho 2 e filho 3
                    sleep(3);
                    cout << "Nasce o filho 2 - o pai tem 25 anos" << endl; // Nasce o filho 2 
                    sleep(7);
                    cout << "Nasce o filho 3 - o pai tem 32 anos" << endl; // Nasce o filho 3

                    pID3 = fork(); // Início do processo 3

                    switch(pID3) {
                        case 0: { // Processo do neto 1 e neto 2
                            sleep(6);
                            cout << "Nasce o neto 1 (filho 1) - o pai tem 38 anos" << endl;
                            sleep(7);
                            cout << "Nasce o neto 2 (filho 2) - o pai tem 45 anos" << endl;

                            pID4 = fork(); // Inicio do processo 4

                            switch(pID4) {
                                case 0: { // Processo do bisneto 1, neto 1 e neto 2
                                    pID5 = fork(); // Inicio do processo 5

                                    switch(pID5) {
                                        case 0: { // Processo do bisneto 1
                                            sleep(23);
                                            cout << "Nasce o bisneto 1 (filho 1) - o pai tem 68 anos" << endl; // Nasce o bisneto

                                            break;
                                        }
                                        default: {
                                            waitpid(0, NULL, 0); // Processo 5 esperando pelo fim do processo 6
                                            sleep(5);
                                            cout << "Morre o neto 1 (filho 1) - o pai tem 73 anos" << endl; // Morre o neto 1
                                            sleep(5);
                                            cout << "Morre o neto 2 (filho 2) - o pai tem 78 anos" << endl; // Morre o neto 2

                                            break;
                                        }
                                    } // Fim do processo 5

                                    break;
                                }
                                default: {
                                    waitpid(0, NULL, 0); // Processo 4 esperando pelo fim do processo 5
                                    sleep(2);
                                    cout << "Morre o bisneto 1 (filho 1) - o pai tem 80 anos" << endl; // Morre o bisneto

                                    break;
                                } 
                            } // Fim do processo 4

                            break;
                        }
                        default: {
                            waitpid(0, NULL, 0); // Processo 3 esperando pelo fim do processo 4
                            cout << "Morre o filho 2 - o pai tem 80 anos" << endl; // Morre o filho 2

                            break;
                        }
                    } // Fim do processo 3

                    break;
                }
                default: {
                    waitpid(0, NULL, 0); // Processo 2 esperando pelo fim do processo 3
                    sleep(3);
                    cout << "Morre o filho 1 - o pai tem 83 anos" << endl; // Morre o filho 1
                    sleep(4);
                    cout << "Morre o filho 3 - o pai tem 87 anos" << endl; // Morre o filho 3

                    break;
                }
            } // Fim do processo 2

            break;
        }
        default: {
            cout << "Nasce o pai" << endl; // Nascimento do pai e inicio do programa
            waitpid(0, NULL, 0); // Processo 1 esprando pelo fim do processo 2
            sleep(3);
            cout << "Morre o pai aos 90 anos" << endl; // Morte do pai e fim do programa

            break;
        }
    } // Fim do processo 1
} // Fim da main
