/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: 12/08/2024
* Nome.............: PurpleCar
* Funcao...........: Controls the purple car in simulation
*************************************************************** */
package model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class PurpleCar extends Thread {
    private double x; // X coordinate
    private double y; // Y coordinate
    private int speed; 
    private ImageView car; 

    // Constructor
    public PurpleCar(int speed, ImageView car) {
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
        try {
            while(true) {
                driveStreet19B();
                Semaphores.getSemaphoreBluePurple().acquire();
                driveCrossroad22();
                driveStreet18B();
                driveCrossroad16();
                Semaphores.getSemaphoreBluePurple().release();
                driveStreet17B();
                driveCrossroad10();
                driveStreet16B();
                Semaphores.getSemaphoreBluePurpleBlack().acquire();
                driveCrossroad4();
                driveStreet3();
                Semaphores.getSemaphoreYellowPurple(1).acquire();
                driveCrossroad3();
                driveStreet2();
                driveCrossroad2();
                Semaphores.getSemaphoreYellowPurple(1).release();
                Semaphores.getSemaphoreBluePurpleBlack().release();
                driveStreet6B();
                driveCrossroad8();
                driveStreet7B();
                driveCrossroad14();
                driveStreet8B();
                driveCrossroad20();
                driveStreet9B();
                driveCrossroad26();
                driveStreet10B();
                Semaphores.getSemaphoreYellowPurple(2).acquire();
                driveCrossroad32();
                driveStreet27();
                driveCrossroad33();
                driveStreet28();
                driveCrossroad34();
                Semaphores.getSemaphoreYellowPurple(2).release();
                driveStreet20B();
                driveCrossroad28();
            } // End while
        } catch(InterruptedException e) {
            e.printStackTrace();
        } // End try/catch
    } // End run

    /* ***************************************************************
    * Metodo: driveStreet19B
    * Funcao: Faz o car drive a Street 19B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet19B() throws InterruptedException {
        while(y != -66) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet19B

    /* ***************************************************************
    * Metodo: driveCrossroad22
    * Funcao: Faz o car drive o Crossroad 22
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad22() throws InterruptedException {
        while(y != -92) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad22

    /* ***************************************************************
    * Metodo: driveStreet18B
    * Funcao: Faz o car drive a Street 18B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet18B() throws InterruptedException {
        while(y != -156) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet11B

    /* ***************************************************************
    * Metodo: driveCrossroad16
    * Funcao: Faz o car drive o Crossroad 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad16() throws InterruptedException {
        while(y != -182) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad16

    /* ***************************************************************
    * Metodo: driveStreet17B
    * Funcao: Faz o car drive a Street 17B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet17B() throws InterruptedException {
        while(y != -246) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet17B

    /* ***************************************************************
    * Metodo: driveCrossroad10
    * Funcao: Faz o car drive o Crossroad 10
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad10() throws InterruptedException {
        while(y != -272) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad10

    /* ***************************************************************
    * Metodo: driveStreet16B
    * Funcao: Faz o car drive a Street 16B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet16B() throws InterruptedException {
        while(y != -336) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet16B

    /* ***************************************************************
    * Metodo: driveCrossroad4
    * Funcao: Faz o car drive o Crossroad 4
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad4() throws InterruptedException {
        while(y != -350) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != -16) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad4

    /* ***************************************************************
    * Metodo: driveStreet3
    * Funcao: Faz o car drive a Street 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet3() throws InterruptedException {
        while(x != -80) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet3

    /* ***************************************************************
    * Metodo: driveCrossroad3
    * Funcao: Faz o car drive o Crossroad 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad3() throws InterruptedException {
        while(x != -106) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad3

    /* ***************************************************************
    * Metodo: driveStreet2
    * Funcao: Faz o car drive a Street 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet2() throws InterruptedException {
        while(x != -170) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet2

    /* ***************************************************************
    * Metodo: driveCrossroad2
    * Funcao: Faz o car drive o Crossroad 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad2() throws InterruptedException {
        while(x != -182) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != -334) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad2

    /* ***************************************************************
    * Metodo: driveStreet6B
    * Funcao: Faz o car drive a Street 6B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet6B() throws InterruptedException {
        while(y != -270) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet6B

    /* ***************************************************************
    * Metodo: driveCrossroad8
    * Funcao: Faz o car drive o Crossroad 8
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad8() throws InterruptedException {
        while(y != -244) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad8

    /* ***************************************************************
    * Metodo: driveStreet7B
    * Funcao: Faz o car drive a Street 7B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet7B() throws InterruptedException {
        while(y != -180) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet7B

    /* ***************************************************************
    * Metodo: driveCrossroad14
    * Funcao: Faz o car drive o Crossroad 
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad14() throws InterruptedException {
        while(y != -154) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad14

    /* ***************************************************************
    * Metodo: driveStreet8B
    * Funcao: Faz o car drive a Street 8B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet8B() throws InterruptedException {
        while(y != -90) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet8B

    /* ***************************************************************
    * Metodo: driveCrossroad20
    * Funcao: Faz o car drive o Crossroad 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad20() throws InterruptedException {
        while(y != -64) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        }  // End while
    } // End driveCrossroad20

    /* ***************************************************************
    * Metodo: driveStreet9B
    * Funcao: Faz o car drive a Street 9B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet9B() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet9B

    /* ***************************************************************
    * Metodo: driveCrossroad26
    * Funcao: Faz o car drive o Crossroad 26
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad26() throws InterruptedException {
        while(y != 26) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad26

    /* ***************************************************************
    * Metodo: driveStreet10B
    * Funcao: Faz o car drive a Street 10B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet10B() throws InterruptedException {
        while(y != 92) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet10B

    /* ***************************************************************
    * Metodo: driveCrossroad32
    * Funcao: Faz o car drive o Crossroad 32
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad32() throws InterruptedException {
        while(y != 104) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != -166) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad32

    /* ***************************************************************
    * Metodo: driveStreet27
    * Funcao: Faz o car drive a Street 27
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet27() throws InterruptedException {
        while(x != -102) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet27

    /* ***************************************************************
    * Metodo: driveCrossroad33
    * Funcao: Faz o car drive o Crossroad 33
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad33() throws InterruptedException {
        while(x != -76) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad33

    /* ***************************************************************
    * Metodo: driveStreet28
    * Funcao: Faz o car drive a Street 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet28() throws InterruptedException {
        while(x != -12) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet28

    /* ***************************************************************
    * Metodo: driveCrossroad34
    * Funcao: Faz o car drive o Crossroad 34
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad34() throws InterruptedException {
        while(x != 0) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != 90) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad34

    /* ***************************************************************
    * Metodo: driveStreet20B
    * Funcao: Faz o car drive a Street 20B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet20B() throws InterruptedException {
        while(y != 26) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet20B

    /* ***************************************************************
    * Metodo: driveCrossroad28
    * Funcao: Faz o car drive o Crossroad 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad28() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad28
} // End class PurpleCar
