/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Laranja
* Funcao...........: Controla o carro laranja da simulacao
*************************************************************** */

package Model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class CarroLaranja extends Thread {
    private double x;
    private double y;
    private int velocidade;
    private ImageView carro;

    public CarroLaranja(int velocidade, ImageView carro) {
        this.velocidade = velocidade;
        this.carro = carro;

        x = carro.getX();
        y = carro.getY();
    }

    @Override
    public void run() {
        boolean primeraVez = true;

        try {
            while(true) {
                andarRua30B();
                passarCruzamento30();

                if(!primeraVez) { Semaforos.getSemaforoAL(3).release(); }

                andarRua29B();
                passarCruzamento24();
                andarRua20();

                Semaforos.getSemaforoAL(1).acquire();

                passarCruzamento23();

                andarRua19();
                passarCruzamento22();

                Semaforos.getSemaforoAL(1).release();

                andarRua18();
                passarCruzamento21();

                Semaforos.getSemaforoAML().release(); 
                
                andarRua17();
                passarCruzamento20();
                andarRua16();

                Semaforos.getSemaforoAL(2).acquire();
                Semaforos.getSemaforoAML().acquire();

                passarCruzamento19();
                andarRua4B();
                passarCruzamento25();
                andarRua5B();
                passarCruzamento31();
                andarRua26();
                passarCruzamento32();
                andarRua27();
                passarCruzamento33();

                Semaforos.getSemaforoAL(2).release();

                andarRua28();

                Semaforos.getSemaforoAL(3).acquire();
                passarCruzamento34();
                andarRua29();
                passarCruzamento35();
                andarRua30();
                passarCruzamento36();

                primeraVez = false;
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void andarRua30B() throws InterruptedException {
        while(y != -64) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    private void passarCruzamento30() throws InterruptedException {
        while(y != -90) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    private void andarRua29B() throws InterruptedException {
        while(y != -154) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    private void passarCruzamento24() throws InterruptedException {
        while(y != -170) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        carro.setRotate(0);

        while(x != -14) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void andarRua20() throws InterruptedException {
        while(x != -78) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    } 

    private void passarCruzamento23() throws InterruptedException {
        while(x != -104) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void andarRua19() throws InterruptedException {
        while(x != -170) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento22() throws InterruptedException {
        while(x != -196) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void andarRua18() throws InterruptedException {
        while(x != -260) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento21() throws InterruptedException {
        while(x != -288) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void andarRua17() throws InterruptedException {
        while(x != -350) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento20() throws InterruptedException {
        while(x != -378) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void andarRua16() throws InterruptedException {
        while(x != -442) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento19() throws InterruptedException {
        while(x != -454) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        carro.setRotate(90);

        while(y != -156) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void andarRua4B() throws InterruptedException {
        while(y != -88) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento25() throws InterruptedException {
        while(y != -62) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void andarRua5B() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento31() throws InterruptedException {
        while(y != 14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        carro.setRotate(0);

        while(x != -438) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }   

    private void andarRua26() throws InterruptedException {
        while(x != -374) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento32() throws InterruptedException {
        while(x != -348) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void andarRua27() throws InterruptedException {
        while(x != -284) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento33() throws InterruptedException {
        while(x != -258) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void andarRua28() throws InterruptedException {
        while(x != -194) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }
 
    private void passarCruzamento34() throws InterruptedException {
        while(x != -168) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void andarRua29() throws InterruptedException {
        while(x != -104) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento35() throws InterruptedException {
        while(x != -78) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void andarRua30() throws InterruptedException {
        while(x != -14) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento36() throws InterruptedException {
        while(x != -0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        carro.setRotate(90);

        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }
}
