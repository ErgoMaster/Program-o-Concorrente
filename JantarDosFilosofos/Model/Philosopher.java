/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 10/04/2022
* Ultima alteracao.: 06/05/2024
* Nome.............: Philosopher thread
* Funcao...........: Eat and think
*************************************************************** */

package Model;

public class Philosopher extends Thread {
    private int id;
    private int leftPhilosopherId;
    private int rightPhilosopherId;
    private int thinkingSpeed;
    private int eatingSpeed;

    // Constructor
    public Philosopher(int id, int leftPhilosopherId, int rightPhilosopherId, int thinkingSpeed, int eatingSpeed) {
        this.id = id;
        this.leftPhilosopherId = leftPhilosopherId;
        this.rightPhilosopherId = rightPhilosopherId;
        this.thinkingSpeed = thinkingSpeed;
        this.eatingSpeed = eatingSpeed;
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
                Thread.sleep(thinkingSpeed); // Philosopher is thinking
                Table.takeForks(id, leftPhilosopherId, rightPhilosopherId); // Verify its forks
                Table.eat(id); // Philosopher start eating (Change image view)
                Thread.sleep(eatingSpeed); // Philosopher is eating
                Table.releaseForks(id, leftPhilosopherId, rightPhilosopherId); // Release forks
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // End while
    } // End run
} // End class Philosopher
