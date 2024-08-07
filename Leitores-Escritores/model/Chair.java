/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 06/08/2024
* Ultima alteracao.: 07/08/2024
* Nome.............: Chair
* Funcao...........: Store the state of each chair
*************************************************************** */
package model;

public class Chair {
    private int id;
    private int state = 0; // 0 => free - 1 => occupied

    // Constructor
    public Chair(int id) {
        this.id = id;
    } // End constructor

    /* ***************************************************************
    * Metodo: changeState
    * Funcao: Modify the state value to 1 (occupied) 
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    public void changeState() {
        this.state = 1;
    } // End changeState

    /* ***************************************************************
    * Metodo: getId
    * Funcao: Return the chair id 
    * Parametros: void
    * Retorno: A integer
    *************************************************************** */
    public int getId() {
        return this.id;
    } // End getId

    /* ***************************************************************
    * Metodo: getState
    * Funcao: Return the chair state 
    * Parametros: void
    * Retorno: A integer
    *************************************************************** */
    public int getState() {
        return this.state;
    } // End getState
} // End class Chair
