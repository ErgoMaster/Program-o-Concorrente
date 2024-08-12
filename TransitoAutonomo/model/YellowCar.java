/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: 12/08/2024
* Nome.............: YellowCar
* Funcao...........: Controls the yellow car in simulation
*************************************************************** */
package model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class YellowCar extends Thread {
    private double x; // X coordinate
    private double y; // Y coordinate
    private int speed; 
    private ImageView car; 

    // Constructor
    public YellowCar(int speed, ImageView car) {
        this.speed = speed;
        this.car = car;

        x = car.getX();
        y = car.getY();
    } // End constructor

    /* ***************************************************************
    * Metodo: run
    * Funcao: Thread start
    * Parametros: void
    * Retorno: void
    *************************************************************** */
    @Override
    public void run() {
        boolean firstLap = true;

        try {
            while(true) {
                driveStreet1();
                Semaphores.getSemaphoreYellowPurple(1).acquire();
                driveCrossroad2();
                driveStreet2();
                driveCrossroad3();
                Semaphores.getSemaphoreYellowPurple(1).release();

                if(!firstLap) {
                    Semaphores.getSemaphoreBlueYellow(1).release();
                    Semaphores.getSemaphoreYellowBlack().release();
                } // End if

                driveStreet11B();
                driveCrossroad9();
                driveStreet12B();
                driveCrossroad15();
                driveStreet13B();
                Semaphores.getSemaphoreOrangeYellow().acquire();
                driveCrossroad21();
                driveStreet18();
                Semaphores.getSemaphoreBlueYellow(3).acquire();
                driveCrossroad22();
                driveStreet19();
                driveCrossroad23();
                Semaphores.getSemaphoreBlueYellow(3).release();
                driveStreet20();
                driveCrossroad24();
                driveStreet29B();
                Semaphores.getSemaphoreBlueYellow(2).acquire();
                driveCrossroad30();
                driveStreet30B();
                driveCrossroad36();
                driveStreet30();
                driveCrossroad35();
                driveStreet29();
                Semaphores.getSemaphoreYellowPurple(2).acquire();
                driveCrossroad34();
                Semaphores.getSemaphoreBlueYellow(2).release();
                driveStreet28();
                Semaphores.getSemaphoreBlueYellow(1).acquire();
                driveCrossroad33();
                driveStreet27();
                driveCrossroad32();
                Semaphores.getSemaphoreYellowPurple(2).release();
                driveStreet26();
                driveCrossroad31();
                driveStreet5B();
                driveCrossroad25();
                driveStreet4B();
                driveCrossroad19();
                Semaphores.getSemaphoreOrangeYellow().release();
                driveStreet3B();
                Semaphores.getSemaphoreYellowBlack().acquire();
                driveCrossroad13();
                driveStreet2B();
                driveCrossroad7();
                driveStreet1B();
                driveCrossroad1();

                firstLap = false;
            } // End while
        } catch(InterruptedException e) {
            e.printStackTrace();
        } // End try/catch
    } // End run
    
    /* ***************************************************************
    * Metodo: driveStreet1
    * Funcao: Drive the car through street 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet1() throws InterruptedException {
        while(x != 66) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater(() -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet1 

    /* ***************************************************************
    * Metodo: driveCrossroad2
    * Funcao: Drive the car through crossroad 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad2() throws InterruptedException {
        while(x != 90) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad2

    /* ***************************************************************
    * Metodo: driveStreet2
    * Funcao: Drive the car through street 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet2() throws InterruptedException {
        while(x != 156) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet2

    /* ***************************************************************
    * Metodo: driveCrossroad3
    * Funcao: Drive the car through crossroad 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad3() throws InterruptedException {
        while(x != 168) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != 16) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad3

    /* ***************************************************************
    * Metodo: driveStreet11B
    * Funcao: Drive the car through street 11B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet11B() throws InterruptedException {
        while(y != 80) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet11B

    /* ***************************************************************
    * Metodo: driveCrossroad9
    * Funcao: Drive the car through crossroad 9
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad9() throws InterruptedException {
        while(y != 106) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad9

    /* ***************************************************************
    * Metodo: driveStreet12B
    * Funcao: Drive the car through street 12B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet12B() throws InterruptedException {
        while(y != 170) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet12B

    /* ***************************************************************
    * Metodo: driveCrossroad15
    * Funcao: Drive the car through crossroad 15
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad15() throws InterruptedException {
        while(y != 196) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad15

    /* ***************************************************************
    * Metodo: driveStreet13B
    * Funcao: Drive the car through street 13B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet13B() throws InterruptedException {
        while(y != 260) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet13B

    /* ***************************************************************
    * Metodo: driveCrossroad21
    * Funcao: Drive the car through crossroad 21
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad21() throws InterruptedException {
        while(y != 274) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != 182) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad21

    /* ***************************************************************
    * Metodo: driveStreet18
    * Funcao: Drive the car through street 18
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet18() throws InterruptedException {
        while(x != 246) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet18

    /* ***************************************************************
    * Metodo: driveCrossroad22
    * Funcao: Drive the car through crossroad 22
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad22() throws InterruptedException {
        while(x != 272) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad22

    /* ***************************************************************
    * Metodo: driveStreet19
    * Funcao: Drive the car through street 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet19() throws InterruptedException {
        while(x != 336) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet19

    /* ***************************************************************
    * Metodo: driveCrossroad23
    * Funcao: Drive the car through crossroad 
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad23() throws InterruptedException {
        while(x != 362) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad23

    /* ***************************************************************
    * Metodo: driveStreet20
    * Funcao: Drive the car through street 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet20() throws InterruptedException {
        while(x != 426) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet20

    /* ***************************************************************
    * Metodo: driveCrossroad24
    * Funcao: Drive the car through crossroad 24
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad24() throws InterruptedException {
        while(x != 440) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != 288) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad24

    /* ***************************************************************
    * Metodo: driveStreet29B
    * Funcao: Drive the car through street 29B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet29B() throws InterruptedException {
        while(y != 352) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet29B

    /* ***************************************************************
    * Metodo: driveCrossroad30
    * Funcao: Drive the car through crossroad 30
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad30() throws InterruptedException {
        while(y != 378) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad30

    /* ***************************************************************
    * Metodo: driveStreet30B
    * Funcao: Drive the car through street 30B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet30B() throws InterruptedException {
        while(y != 442) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet30B

    /* ***************************************************************
    * Metodo: driveCrossroad36
    * Funcao: Drive the car through crossroad 36
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad36() throws InterruptedException {
        while(y != 456) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != 426) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad36

    /* ***************************************************************
    * Metodo: driveStreet30
    * Funcao: Drive the car through street 30
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet30() throws InterruptedException {
        while(x != 362) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet30

    /* ***************************************************************
    * Metodo: driveCrossroad35
    * Funcao: Drive the car through crossroad 35
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad35() throws InterruptedException {
        while(x != 336) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad35

    /* ***************************************************************
    * Metodo: driveStreet29
    * Funcao: Drive the car through street 29
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet29() throws InterruptedException {
        while(x != 272) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet29

    /* ***************************************************************
    * Metodo: driveCrossroad34
    * Funcao: Drive the car through crossroad 34
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad34() throws InterruptedException {
        while(x != 246) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad34

    /* ***************************************************************
    * Metodo: driveStreet28
    * Funcao: Drive the car through street 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet28() throws InterruptedException {
        while(x != 182) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet28

    /* ***************************************************************
    * Metodo: driveCrossroad33
    * Funcao: Drive the car through crossroad 33
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad33() throws InterruptedException {
        while(x != 156) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad33

    /* ***************************************************************
    * Metodo: driveStreet27
    * Funcao: Drive the car through street 27
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet27() throws InterruptedException {
        while(x != 90) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet27

    /* ***************************************************************
    * Metodo: driveCrossroad32
    * Funcao: Drive the car through crossroad 32
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad32() throws InterruptedException {
        while(x != 64) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad32

    /* ***************************************************************
    * Metodo: driveStreet26
    * Funcao:Drive the car through street 26
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet26() throws InterruptedException {
        while(x != 0) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet26

    /* ***************************************************************
    * Metodo: driveCrossroad31
    * Funcao: Drive the car through crossroad 31
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad31() throws InterruptedException {
        while(x != -16) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != 442) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad31

    /* ***************************************************************
    * Metodo: driveStreet5B
    * Funcao: Drive the car through street 5B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet5B() throws InterruptedException {
        while(y != 378) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet5B

    /* ***************************************************************
    * Metodo: driveCrossroad25
    * Funcao: Drive the car through crossroad 25
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad25() throws InterruptedException {
        while(y != 352) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad25

    /* ***************************************************************
    * Metodo: driveStreet4B
    * Funcao: Drive the car through street 4B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet4B() throws InterruptedException {
        while(y != 288) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet4B

    /* ***************************************************************
    * Metodo: driveCrossroad19
    * Funcao: Drive the car through crossroad 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad19() throws InterruptedException {
        while(y != 258) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad19

    /* ***************************************************************
    * Metodo: driveStreet3B
    * Funcao: Drive the car through street 3B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet3B() throws InterruptedException {
        while(y != 194) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet3B

    /* ***************************************************************
    * Metodo: driveCrossroad13
    * Funcao: Drive the car through crossroad 13
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad13() throws InterruptedException {
        while(y != 168) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad13

    /* ***************************************************************
    * Metodo: driveStreet2B
    * Funcao: Drive the car through street 2B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet2B() throws InterruptedException {
        while(y != 104) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet2B

    /* ***************************************************************
    * Metodo: driveCrossroad7
    * Funcao: Drive the car through crossroad 7
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad7() throws InterruptedException {
        while(y != 78) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad7

    /* ***************************************************************
    * Metodo: driveStreet1B
    * Funcao: Drive the car through street 1B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet1B() throws InterruptedException {
        while(y != 14) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet1B

    /* ***************************************************************
    * Metodo: driveCrossroad1
    * Funcao: Drive the car through crossroad 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad1() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != 0) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad1
} // End class YellowCar
