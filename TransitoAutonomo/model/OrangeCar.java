/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: 12/08/2024
* Nome.............: OrangeCar
* Funcao...........: Controls the orange car in simulation
*************************************************************** */
package model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class OrangeCar extends Thread {
    private double x; // X coordinate
    private double y; // Y coordinate
    private int speed; 
    private ImageView car; 

    // Constructor
    public OrangeCar(int speed, ImageView car) {
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
                driveStreet30B();
                driveCrossroad30();
                driveStreet29B();
                driveCrossroad24();
                driveStreet20();
                driveCrossroad23();
                driveStreet19();
                driveCrossroad22();
                driveStreet18();
                driveCrossroad21();

                if(!firstLap) {
                    Semaphores.getSemaphoreOrangeYellow().release();
                } // End if

                driveStreet17();
                driveCrossroad20();
                driveStreet16();
                Semaphores.getSemaphoreOrangeYellow().acquire();
                driveCrossroad19();
                driveStreet4B();
                driveCrossroad25();
                driveStreet5B();
                driveCrossroad31();
                driveStreet26();
                driveCrossroad32();
                driveStreet27();
                driveCrossroad33();
                driveStreet28();
                driveCrossroad34();
                driveStreet29();
                driveCrossroad35();
                driveStreet30();
                driveCrossroad36();

                firstLap = false;
            } // End while
        } catch(InterruptedException e) {
            e.printStackTrace();
        } // End try/catch
    } // End run

    /* ***************************************************************
    * Metodo: driveStreet30B
    * Funcao: Drive the car through street 30B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet30B() throws InterruptedException {
        while(y != -64) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet30B

    /* ***************************************************************
    * Metodo: driveCrossroad30
    * Funcao: Drive the car through crossroad 30
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad30() throws InterruptedException {
        while(y != -90) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad30

    /* ***************************************************************
    * Metodo: driveStreet29B
    * Funcao: Drive the car through street 29B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet29B() throws InterruptedException {
        while(y != -154) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet29B

    /* ***************************************************************
    * Metodo: driveCrossroad24
    * Funcao: Drive the car through crossroad 24
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad24() throws InterruptedException {
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
    } // End driveCrossroad24

    /* ***************************************************************
    * Metodo: driveStreet20
    * Funcao: Drive the car through street 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet20() throws InterruptedException {
        while(x != -78) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet20

    /* ***************************************************************
    * Metodo: driveCrossroad23
    * Funcao: Drive the car through crossroad 23
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad23() throws InterruptedException {
        while(x != -104) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad23

    /* ***************************************************************
    * Metodo: driveStreet19
    * Funcao: Drive the car through street 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet19() throws InterruptedException {
        while(x != -170) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet19

    /* ***************************************************************
    * Metodo: driveCrossroad22
    * Funcao: Drive the car through crossroad 22
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad22() throws InterruptedException {
        while(x != -196) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad22

    /* ***************************************************************
    * Metodo: driveStreet18
    * Funcao: Drive the car through street 18
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet18() throws InterruptedException {
        while(x != -260) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet18

    /* ***************************************************************
    * Metodo: driveCrossroad21
    * Funcao: Drive the car through crossroad 21
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad21() throws InterruptedException {
        while(x != -288) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad21

    /* ***************************************************************
    * Metodo: driveStreet17
    * Funcao: Drive the car through street 17
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet17() throws InterruptedException {
        while(x != -350) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet17

    /* ***************************************************************
    * Metodo: driveCrossroad20
    * Funcao: Drive the car through crossroad 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad20() throws InterruptedException {
        while(x != -378) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad20

    /* ***************************************************************
    * Metodo: driveStreet16
    * Funcao: Drive the car through street 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet16() throws InterruptedException {
        while(x != -442) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet16

    /* ***************************************************************
    * Metodo: driveCrossroad19
    * Funcao: Drive the car through crossroad 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad19() throws InterruptedException {
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
    } // End driveCrossroad19

    /* ***************************************************************
    * Metodo: driveStreet4B
    * Funcao: Drive the car through street 4B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet4B() throws InterruptedException {
        while(y != -88) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet4B

    /* ***************************************************************
    * Metodo: driveCrossroad25
    * Funcao: Drive the car through crossroad 25
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad25() throws InterruptedException {
        while(y != -62) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad25

    /* ***************************************************************
    * Metodo: driveStreet5B
    * Funcao: Drive the car through street 5B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet5B() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet5B

    /* ***************************************************************
    * Metodo: driveCrossroad31
    * Funcao: Drive the car through crossroad 31
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad31() throws InterruptedException {
        while(y != 14) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != -438) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad31

    /* ***************************************************************
    * Metodo: driveStreet26
    * Funcao: Drive the car through street 26
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet26() throws InterruptedException {
        while(x != -374) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet26

    /* ***************************************************************
    * Metodo: driveCrossroad32
    * Funcao: Drive the car through crossroad 32
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad32() throws InterruptedException {
        while(x != -348) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad32

    /* ***************************************************************
    * Metodo: driveStreet27
    * Funcao: Drive the car through street 27
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet27() throws InterruptedException {
        while(x != -284) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet27

    /* ***************************************************************
    * Metodo: driveCrossroad33
    * Funcao: Drive the car through crossroad 33
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad33() throws InterruptedException {
        while(x != -258) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad33

    /* ***************************************************************
    * Metodo: driveStreet28
    * Funcao: Drive the car through street 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet28() throws InterruptedException {
        while(x != -194) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet28
 
    /* ***************************************************************
    * Metodo: driveCrossroad34
    * Funcao: Drive the car through crossroad 34
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad34() throws InterruptedException {
        while(x != -168) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad34

    /* ***************************************************************
    * Metodo: driveStreet29
    * Funcao: Drive the car through street 29
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet29() throws InterruptedException {
        while(x != -104) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet29

    /* ***************************************************************
    * Metodo: driveCrossroad35
    * Funcao: Drive the car through crossroad 35
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad35() throws InterruptedException {
        while(x != -78) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad35

    /* ***************************************************************
    * Metodo: driveStreet30
    * Funcao: Drive the car through street 30
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet30() throws InterruptedException {
        while(x != -14) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet30

    /* ***************************************************************
    * Metodo: driveCrossroad36
    * Funcao: Drive the car through crossroad 36
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad36() throws InterruptedException {
        while(x != -0) {
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
    } // End driveCrossroad36
} // End class OrangeCar
