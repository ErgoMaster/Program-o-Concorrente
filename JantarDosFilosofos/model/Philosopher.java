/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 30/07/2024
* Nome.............: Philosopher thread
* Funcao...........: Eat and think
*************************************************************** */

package model;

public class Philosopher extends Thread {
    private int id;
    private int leftPhilosopherId;
    private int rightPhilosopherId;

    // Constructor
    public Philosopher(int id, int leftPhilosopherId, int rightPhilosopherId) {
        this.id = id;
        this.leftPhilosopherId = leftPhilosopherId;
        this.rightPhilosopherId = rightPhilosopherId;
    } // End constructor

    /* ***************************************************************
    * Metodo: run
    * Funcao: Thread start
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    @Override
    public void run() {
        while(true) {
            try {
                Table.think(id); // Philosopher start thinking (Change image view)
                Thread.sleep(4000); // Philosopher is thinking
                Table.takeForks(id, leftPhilosopherId, rightPhilosopherId); // Verify its forks
                Table.eat(id); // Philosopher start eating (Change image view)
                Thread.sleep(4000); // Philosopher is eating
                Table.releaseForks(id, leftPhilosopherId, rightPhilosopherId); // Release forks
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // End while
    } // End run
} // End class Philosopher
