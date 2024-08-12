/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: 12/08/2024
* Nome.............: BlueCar
* Funcao...........: Controls the blue car in simulation
*************************************************************** */
package model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class BlueCar extends Thread {
    private double x; // X coordinate
    private double y; // Y coordinate
    private int speed; 
    private ImageView car; 

    // Constructor
    public BlueCar(int speed, ImageView car) {
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
                driveStreet26();
                driveCrossroad32();
                driveStreet27();
                driveCrossroad33();

                if(!firstLap) {
                    Semaphores.getSemaphoreBlueYellow(1).release();
                } // End if

                driveStreet15B();
                driveCrossroad27();
                driveStreet23();
                driveCrossroad28();
                driveStreet20B();
                Semaphores.getSemaphoreBlueYellow(2).acquire();
                driveCrossroad34();
                driveStreet29();
                driveCrossroad35();
                driveStreet30();
                driveCrossroad36();
                driveStreet30B();
                driveCrossroad30();
                Semaphores.getSemaphoreBlueYellow(2).release();
                driveStreet25();
                driveCrossroad29();
                driveStreet24B();
                Semaphores.getSemaphoreBlueYellow(3).acquire();
                driveCrossroad23();
                driveStreet19();
                Semaphores.getSemaphoreBluePurple().acquire();
                driveCrossroad22();
                Semaphores.getSemaphoreBlueYellow(3).release();
                driveStreet18B();
                Semaphores.getSemaphoreBlueBlack().acquire();
                driveCrossroad16();
                Semaphores.getSemaphoreBluePurple().release();
                driveStreet14();
                driveCrossroad17();
                driveStreet15();
                driveCrossroad18();
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
                Semaphores.getSemaphoreBlueYellow(1).acquire();
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
                Semaphores.getSemaphoreBlueBlack().release();
                driveStreet3B();
                driveCrossroad19();
                driveStreet4B();
                driveCrossroad25();
                driveStreet5B();
                driveCrossroad31();

                firstLap = false;
            } // End while
        } catch(InterruptedException e) {
            e.printStackTrace();
        } // End try/catch
    } // Fim do metodo run

    /* ***************************************************************
    * Metodo: driveStreet26
    * Funcao: Drive the car through street 26
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet26() throws InterruptedException {
        while(x != 66) {
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
        while(x != 92) {
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
        while(x != 156) {
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
        while(x != 170) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != -14) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad33

    /* ***************************************************************
    * Metodo: driveStreet15B
    * Funcao: Drive the car through street 15B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet15B() throws InterruptedException {
        while(y != -78) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet15B

    /* ***************************************************************
    * Metodo: driveCrossroad27
    * Funcao: Drive the car through crossroad 27
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad27() throws InterruptedException {
        while(y != -92) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != 182) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad27

    /* ***************************************************************
    * Metodo: driveStreet23
    * Funcao: Drive the car through street 23
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet23() throws InterruptedException {
        while(x != 246) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveStreet23

    /* ***************************************************************
    * Metodo: driveCrossroad28
    * Funcao: Drive the car through crossroad 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad28() throws InterruptedException {
        while(x != 260) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != -76) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad28

    /* ***************************************************************
    * Metodo: driveStreet20B
    * Funcao: Drive the car through street 20B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet20B() throws InterruptedException {
        while(y != -12) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet20B

    /* ***************************************************************
    * Metodo: driveCrossroad34
    * Funcao: Drive the car through crossroad 34
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad34() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != 272) {
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
        while(x != 336) {
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
        while(x != 364) {
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
        while(x != 428) {
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
        while(x != 442) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != -14) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad36

    /* ***************************************************************
    * Metodo: driveStreet30B
    * Funcao: Drive the car through street 30B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet30B() throws InterruptedException {
        while(y != -78) {
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

        Platform.runLater( () -> car.setRotate(0));

        while(x != 428) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveCrossroad30

    /* ***************************************************************
    * Metodo: driveStreet25
    * Funcao: Drive the car through street 25
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet25() throws InterruptedException {
        while(x != 362) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while
    } // End driveStreet25

    /* ***************************************************************
    * Metodo: driveCrossroad29
    * Funcao: Drive the car through crossroad 29
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad29() throws InterruptedException {
        while(x != 350) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != -106) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad29

    /* ***************************************************************
    * Metodo: driveStreet24B
    * Funcao: Drive the car through street 24B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet24B() throws InterruptedException {
        while(y != -170) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveStreet24B

    /* ***************************************************************
    * Metodo: driveCrossroad23
    * Funcao: Drive the car through crossroad 23
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad23() throws InterruptedException {
        while(y != -182) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != 336) {
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
        while(x != 272) {
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
        while(x != 258) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != -196) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad22

    /* ***************************************************************
    * Metodo: driveStreet18B
    * Funcao: Drive the car through street 18B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet18B() throws InterruptedException {
        while(y != -260) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while

    } // End driveStreet18B

    /* ***************************************************************
    * Metodo: driveCrossroad16
    * Funcao: Drive the car through crossroad 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad16() throws InterruptedException {
        while(y != -274) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != 274) {
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
        while(x != 338) {
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
        while(x != 364) {
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
        while(x != 428) {
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
        while(x != 442) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != -286) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while
    } // End driveCrossroad18

    /* ***************************************************************
    * Metodo: driveStreet27B
    * Funcao: Drive the car through street 27B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet27B() throws InterruptedException {
        while(y != -350) {
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
        while(y != -376) {
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
        while(y != -440) {
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
        while(y != -454) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y--; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != 428) {
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
        while(x != 362) {
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
        while(x != 336) {
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
        while(x != 272) {
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
        while(x != 246) {
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
        while(x != 182) {
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
        while(x != 156) {
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
        while(x != 92) {
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
        while(x != 66) {
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
        while(x != 0) {
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
        while(x != -14) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x--; 
        } // End while

        Platform.runLater( () -> car.setRotate(90));

        while(y != -438) {
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
        while(y != -374) {
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
        while(y != -348) {
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
        while(y != -284) {
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
        while(y != -258) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveCrossroad13

    /* ***************************************************************
    * Metodo: driveStreet3B
    * Funcao: Drive the car through street 3B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveStreet3B() throws InterruptedException {
        while(y != -194) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while
    } // End driveStreet3B

    /* ***************************************************************
    * Metodo: driveCrossroad19
    * Funcao: Drive the car through crossroad 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void driveCrossroad19() throws InterruptedException {
        while(y != -168) {
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
        while(y != -104) {
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
        while(y != -78) {
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
        while(y != -14) {
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
        while(y != 0) {
            Thread.sleep(speed); 

            final double CONST = y;
            Platform.runLater( () -> car.setY(CONST)); 

            y++; 
        } // End while

        Platform.runLater( () -> car.setRotate(0));

        while(x != 0) {
            Thread.sleep(speed); 

            final double CONST = x;
            Platform.runLater( () -> car.setX(CONST)); 

            x++; 
        } // End while
    } // End driveCrossroad31
} // End class BlueCar
