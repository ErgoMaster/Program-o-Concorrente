/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: 12/08/2024
* Nome.............: BlackCar
* Funcao...........: Controls the black car in simulation
*************************************************************** */
package model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class BlackCar extends Thread {
    private double x; // X coordinate
    private double y; // Y coordinate
    private int speed; 
    private ImageView car; 

    // Constructor
    public BlackCar(int speed, ImageView car) {
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
                driveStreet27B();
                driveCrossroad12();
                driveStreet26B();
                driveCrossroad6();
                driveStreet5();
                driveCrossroad5();
                driveStreet4();
                Semaphores.getSemaphoreBluePurpleBlack().acquire();
                driveCrossroad4();
                driveStreet3();
                Semaphores.getSemaphoreYellowBlack().acquire();
                driveCrossroad3();
                driveStreet2();
                driveCrossroad2();
                Semaphores.getSemaphoreBluePurpleBlack().release();
                driveStreet1();
                driveCrossroad1();
                driveStreet1B();
                driveCrossroad7();
                driveStreet2B();
                driveCrossroad13();

                if(!firstLap) {
                    Semaphores.getSemaphoreBlueBlack().release();
                } // End if

                Semaphores.getSemaphoreYellowBlack().release();
                driveStreet11();
                driveCrossroad14();
                driveStreet12();
                driveCrossroad15();
                driveStreet13();
                Semaphores.getSemaphoreBlueBlack().acquire();
                driveCrossroad16();
                driveStreet14();
                driveCrossroad17();
                driveStreet15();
                driveCrossroad18();

                firstLap = false;
            } // End while
        } catch(InterruptedException e) {
            e.printStackTrace();
        } // End try/catch
    } // Fim do metodo run

    /* ***************************************************************
    * Metodo: driveStreet27B
    * Funcao: Drive the car through street 27B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet27B() throws InterruptedException {
        while(y != -66) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet27B

    /* ***************************************************************
    * Metodo: driveCrossroad12
    * Funcao: Drive the car through crossroad 12
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad12() throws InterruptedException {
        while(y != -92) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad12

    /* ***************************************************************
    * Metodo: driveStreet26B
    * Funcao: Drive the car through street 26B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet26B() throws InterruptedException {
        while(y != -156) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet26B

    /* ***************************************************************
    * Metodo: driveCrossroad6
    * Funcao: Drive the car through crossroad 6
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad6() throws InterruptedException {
        while(y != -170) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while

        Platform.runLater( () -> car.setRotate(0)); 

        while(x != -14) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad6

    /* ***************************************************************
    * Metodo: driveStreet5
    * Funcao: Drive the car through street 5
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet5() throws InterruptedException {

        while(x != -78) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet5

    /* ***************************************************************
    * Metodo: driveCrossroad5
    * Funcao: Drive the car through crossroad 5
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad5() throws InterruptedException {
        while(x != -104) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad5

    /* ***************************************************************
    * Metodo: driveStreet4
    * Funcao: Drive the car through street 4
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet4() throws InterruptedException {
        while(x != -168) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet4

    /* ***************************************************************
    * Metodo: driveCrossroad4
    * Funcao: Drive the car through crossroad 4
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad4() throws InterruptedException {
        while(x != -196) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad4

    /* ***************************************************************
    * Metodo: driveStreet3
    * Funcao: Drive the car through street 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet3() throws InterruptedException {
        while(x != -260) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet3

    /* ***************************************************************
    * Metodo: driveCrossroad3
    * Funcao: Drive the car through crossroad 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad3() throws InterruptedException {
        while(x != -286) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad3

    /* ***************************************************************
    * Metodo: driveStreet2
    * Funcao: Drive the car through street 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet2() throws InterruptedException {
        while(x != -350) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet2

    /* ***************************************************************
    * Metodo: driveCrossroad2
    * Funcao: Drive the car through crossroad 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad2() throws InterruptedException {
        while(x != -376) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad2

    /* ***************************************************************
    * Metodo: driveStreet1
    * Funcao: Drive the car through street 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet1() throws InterruptedException {
        while(x != -440) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet1

    /* ***************************************************************
    * Metodo: driveCrossroad1
    * Funcao: Drive the car through crossroad 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad1() throws InterruptedException {
        while(x != -454) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != -156) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad1

    /* ***************************************************************
    * Metodo: driveStreet1B
    * Funcao: Drive the car through street 1B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet1B() throws InterruptedException {
        while(y != -92) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet1B

    /* ***************************************************************
    * Metodo: driveCrossroad7
    * Funcao: Drive the car through crossroad 7
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad7() throws InterruptedException {
        while(y != -66) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad7

    /* ***************************************************************
    * Metodo: driveStreet2B
    * Funcao: Drive the car through street 2B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet2B() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet2B

    /* ***************************************************************
    * Metodo: driveCrossroad13
    * Funcao: Drive the car through crossroad 13
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad13() throws InterruptedException {
        while(y != 12) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != -440) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad13

    /* ***************************************************************
    * Metodo: driveStreet11
    * Funcao: Drive the car through street 11
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet11() throws InterruptedException {
        while(x != -376) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet11

    /* ***************************************************************
    * Metodo: driveCrossroad14
    * Funcao: Drive the car through crossroad 14
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad14() throws InterruptedException {
        while(x != -350) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad14

    /* ***************************************************************
    * Metodo: driveStreet12
    * Funcao: Drive the car through street 12
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet12() throws InterruptedException {
        while(x != -286) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet12

    /* ***************************************************************
    * Metodo: driveCrossroad15
    * Funcao: Drive the car through crossroad 15
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad15() throws InterruptedException {
        while(x != -260) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad15

    /* ***************************************************************
    * Metodo: driveStreet13
    * Funcao: Drive the car through street 13
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet13() throws InterruptedException {
        while(x != -196) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet13

    /* ***************************************************************
    * Metodo: driveCrossroad16
    * Funcao: Drive the car through crossroad 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad16() throws InterruptedException {
        while(x != -170) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad16

    /* ***************************************************************
    * Metodo: driveStreet14
    * Funcao: Drive the car through street 14
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet14() throws InterruptedException {
        while(x != -106) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet14

    /* ***************************************************************
    * Metodo: driveCrossroad17
    * Funcao: Drive the car through crossroad 17
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad17() throws InterruptedException {
        while(x != -80) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad17

    /* ***************************************************************
    * Metodo: driveStreet15
    * Funcao: Drive the car through street 15
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet15() throws InterruptedException {
        while(x != -16) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet15

    /* ***************************************************************
    * Metodo: driveCrossroad18
    * Funcao: Drive the car through crossroad 18
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad18() throws InterruptedException {
        while(x != 0) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
        
        Platform.runLater( () -> car.setRotate(90));

        while(y != 0) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad18
} // End class BlackCar
