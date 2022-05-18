/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Azul
* Funcao...........: Controla o carro azul da simulacao
*************************************************************** */

package Model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class CarroAzul extends Thread {
    private double x;
    private double y;
    private int velocidade;
    private ImageView carro;

    public CarroAzul(int velocidade, ImageView carro) {
        this.velocidade = velocidade;
        this.carro = carro;

        x = carro.getX();
        y = carro.getY();
    }

    @Override
    public void run() {
        try {
            while(true) {
                andarRua26();
                passarCruzamento32();
                andarRua27();
                passarCruzamento33();
                andarRua15B();
                passarCruzamento27();
                andarRua23();
                passarCruzamento28();
                andarRua20B();
                passarCruzamento34();
                andarRua29();
                passarCruzamento35();
                andarRua30();
                passarCruzamento36();
                andarRua30B();
                passarCruzamento30();
                andarRua25();
                passarCruzamento29();
                andarRua24B();
                passarCruzamento23();
                andarRua19();
                passarCruzamento22();
                andarRua18B();
                passarCruzamento16();
                andarRua14();
                passarCruzamento17();
                andarRua15();
                passarCruzamento18();
                andarRua27B();
                passarCruzamento12();
                andarRua26B();
                passarCruzamento6();
                andarRua5();
                passarCruzamento5();
                andarRua4();
                passarCruzamento4();
                andarRua3();
                passarCruzamento3();
                andarRua2();
                passarCruzamento2();
                andarRua1();
                passarCruzamento1();
                andarRua1B();
                passarCruzamento7();
                andarRua2B();
                passarCruzamento13();
                andarRua3B();
                passarCruzamento19();
                andarRua4B();
                passarCruzamento25();
                andarRua5B();
                passarCruzamento31();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void andarRua26() throws InterruptedException {
        while(x != 66) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    } 

    private void passarCruzamento32() throws InterruptedException {
        Semaforos.getSemaforo(32).acquire();

        while(x != 92) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(32).release();
    }

    private void andarRua27() throws InterruptedException {
        while(x != 156) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento33() throws InterruptedException {
        Semaforos.getSemaforo(33).acquire();

        while(x != 170) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        carro.setRotate(90);

        while(y != -14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforo(33).release();
    }

    private void andarRua15B() throws InterruptedException {
        while(y != -78) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    private void passarCruzamento27() throws InterruptedException {
        Semaforos.getSemaforo(27).acquire();

        while(y != -92) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        carro.setRotate(0);

        while(x != 182) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(27).release();
    }

    private void andarRua23() throws InterruptedException {
        while(x != 246) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento28() throws InterruptedException {
        Semaforos.getSemaforo(28).acquire();

        while(x != 260) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        carro.setRotate(90);

        while(y != -76) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(28).release();
    }

    private void andarRua20B() throws InterruptedException {
        while(y != -12) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento34() throws InterruptedException {
        Semaforos.getSemaforo(34).acquire();

        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        carro.setRotate(0);

        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(34).release();
    }

    private void andarRua29() throws InterruptedException {
        while(x != 336) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento35() throws InterruptedException {
        Semaforos.getSemaforo(35).acquire();

        while(x != 364) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(35).release();
    }

    private void andarRua30() throws InterruptedException {
        while(x != 428) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento36() throws InterruptedException {
        Semaforos.getSemaforo(36).acquire();

        while(x != 442) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        carro.setRotate(90);

        while(y != -14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforo(36).release();
    }

    private void andarRua30B() throws InterruptedException {
        while(y != -78) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    private void passarCruzamento30() throws InterruptedException {
        Semaforos.getSemaforo(30).acquire();

        while(y != -90) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        carro.setRotate(0);

        while(x != 428) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(30).release();
    }

    private void andarRua25() throws InterruptedException {
        while(x != 362) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento29() throws InterruptedException {
        Semaforos.getSemaforo(29).acquire();

        while(x != 350) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        carro.setRotate(90);

        while(y != -106) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforo(29).release();
    }

    private void andarRua24B() throws InterruptedException {
        while(y != -170) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    private void passarCruzamento23() throws InterruptedException {
        Semaforos.getSemaforo(23).acquire();

        while(y != -182) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        carro.setRotate(0);

        while(x != 336) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(23).release();
    }

    private void andarRua19() throws InterruptedException {
        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento22() throws InterruptedException {
        Semaforos.getSemaforo(22).acquire();

        while(x != 258) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        carro.setRotate(90);

        while(y != -196) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforo(22).release();
    }

    private void andarRua18B() throws InterruptedException {
        while(y != -260) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    private void passarCruzamento16() throws InterruptedException {
        Semaforos.getSemaforo(16).acquire();

        while(y != -274) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        carro.setRotate(0);

        while(x != 274) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(16).release();
    }

    private void andarRua14() throws InterruptedException {
        while(x != 338) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento17() throws InterruptedException {
        Semaforos.getSemaforo(17).acquire();

        while(x != 364) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(17).release();
    }

    private void andarRua15() throws InterruptedException {
        while(x != 428) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento18() throws InterruptedException {
        Semaforos.getSemaforo(18).acquire();

        while(x != 442) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        carro.setRotate(90);

        while(y != -286) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforo(18).release();
    }

    private void andarRua27B() throws InterruptedException {
        while(y != -350) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    private void passarCruzamento12() throws InterruptedException {
        Semaforos.getSemaforo(12).acquire();

        while(y != -376) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforo(12).release();
    }

    private void andarRua26B() throws InterruptedException {
        while(y != -440) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    private void passarCruzamento6() throws InterruptedException {
        Semaforos.getSemaforo(6).acquire();

        while(y != -454) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        carro.setRotate(0);

        while(x != 428) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(6).release();
    }

    private void andarRua5() throws InterruptedException {
        while(x != 362) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento5() throws InterruptedException {
        Semaforos.getSemaforo(5).acquire();

        while(x != 336) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(5).release();
    }

    private void andarRua4() throws InterruptedException {
        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento4() throws InterruptedException {
        Semaforos.getSemaforo(4).acquire();

        while(x != 246) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(4).release();
    }

    private void andarRua3() throws InterruptedException {
        while(x != 182) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 
                                                                                                                                                                                                                                             
            x--;    
        }
    }

    private void passarCruzamento3() throws InterruptedException {
        Semaforos.getSemaforo(3).acquire();

        while(x != 156) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(3).release();
    }

    private void andarRua2() throws InterruptedException {
        while(x != 92) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento2() throws InterruptedException {
        Semaforos.getSemaforo(2).acquire();

        while(x != 66) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(2).release();
    }

    private void andarRua1() throws InterruptedException {
        while(x != 0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento1() throws InterruptedException {
        Semaforos.getSemaforo(1).acquire();

        while(x != -14) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        carro.setRotate(90);

        while(y != -438) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(1).release();
    }

    private void andarRua1B() throws InterruptedException {
        while(y != -374) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento7() throws InterruptedException {
        Semaforos.getSemaforo(7).acquire();

        while(y != -348) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(7).release();
    }

    private void andarRua2B() throws InterruptedException {
        while(y != -284) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento13() throws InterruptedException {
        Semaforos.getSemaforo(13).acquire();

        while(y != -258) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(13).release();
    }

    private void andarRua3B() throws InterruptedException {
        while(y != -194) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento19() throws InterruptedException {
        Semaforos.getSemaforo(19).acquire();

        while(y != -168) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(19).release();
    }

    private void andarRua4B() throws InterruptedException {
        while(y != -104) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento25() throws InterruptedException {
        Semaforos.getSemaforo(25).acquire();

        while(y != -78) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(25).release();
    }

    private void andarRua5B() throws InterruptedException {
        while(y != -14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento31() throws InterruptedException {
        Semaforos.getSemaforo(31).acquire();

        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        carro.setRotate(0);

        while(x != 0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(31).release();
    }
}
