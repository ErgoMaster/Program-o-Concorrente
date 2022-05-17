/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Amarelo
* Funcao...........: Controla o carro amarelo da simulacao
*************************************************************** */

package Model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class CarroAmarelo extends Thread {
    private double x;
    private double y;
    private int velocidade;
    private ImageView carro;

    public CarroAmarelo(int velocidade, ImageView carro) {
        this.velocidade = velocidade;
        this.carro = carro;

        x = carro.getX();
        y = carro.getY();
    }

    @Override
    public void run() {
        try {
            while(true) {
                andarRua1();
                passarCruzamento2();
                andarRua2();
                passarCruzamento3();
                andarRua11B();
                passarCruzamento9();
                andarRua12B();
                passarCruzamento15();
                andarRua13B();
                passarCruzamento21();
                andarRua18();
                passarCruzamento22();
                andarRua19();
                passarCruzamento23();
                andarRua20();
                passarCruzamento24();
                andarRua29B();
                passarCruzamento30();
                andarRua30B();
                passarCruzamento36();
                andarRua30();
                passarCruzamento35();
                andarRua29();
                passarCruzamento34();
                andarRua28();
                passarCruzamento33();
                andarRua27();
                passarCruzamento32();
                andarRua26();
                passarCruzamento31();
                andarRua5B();
                passarCruzamento25();
                andarRua4B();
                passarCruzamento19();
                andarRua3B();
                passarCruzamento13();
                andarRua2B();
                passarCruzamento7();
                andarRua1B();
                passarCruzamento1();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    private void andarRua1() throws InterruptedException {
        while(x != 66) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento2() throws InterruptedException {
        Semaforos.getSemaforo(2).acquire();

        while(x != 90) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(2).release();
    }

    private void andarRua2() throws InterruptedException {
        while(x != 156) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento3() throws InterruptedException {
        Semaforos.getSemaforo(3).acquire();

        while(x != 168) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        carro.setRotate(90);

        while(y != 16) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(3).release();
    }

    private void andarRua11B() throws InterruptedException {
        while(y != 80) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento9() throws InterruptedException {
        Semaforos.getSemaforo(9).acquire();

        while(y != 106) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(9).release();
    }

    private void andarRua12B() throws InterruptedException {
        while(y != 170) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento15() throws InterruptedException {
        Semaforos.getSemaforo(15).acquire();

        while(y != 196) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(15).release();
    }

    private void andarRua13B() throws InterruptedException {
        while(y != 260) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento21() throws InterruptedException {
        Semaforos.getSemaforo(21).acquire();

        while(y != 274) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        carro.setRotate(0);

        while(x != 182) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(21).release();
    }

    private void andarRua18() throws InterruptedException {
        while(x != 246) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento22() throws InterruptedException {
        Semaforos.getSemaforo(22).acquire();

        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(22).release();
    }

    private void andarRua19() throws InterruptedException {
        while(x != 336) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento23() throws InterruptedException {
        Semaforos.getSemaforo(23).acquire();

        while(x != 362) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforo(23).release();
    }

    private void andarRua20() throws InterruptedException {
        while(x != 426) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    private void passarCruzamento24() throws InterruptedException {
        Semaforos.getSemaforo(24).acquire();

        while(x != 440) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        carro.setRotate(90);

        while(y != 288) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(24).release();
    }

    private void andarRua29B() throws InterruptedException {
        while(y != 352) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento30() throws InterruptedException {
        Semaforos.getSemaforo(30).acquire();

        while(y != 378) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforo(30).release();
    }

    private void andarRua30B() throws InterruptedException {
        while(y != 442) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    private void passarCruzamento36() throws InterruptedException {
        Semaforos.getSemaforo(36).acquire();

        while(y != 456) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        carro.setRotate(0);

        while(x != 426) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        } 

        Semaforos.getSemaforo(36).release();
    }

    private void andarRua30() throws InterruptedException {
        while(x != 362) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento35() throws InterruptedException {
        Semaforos.getSemaforo(35).acquire();

        while(x != 336) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(35).release();
    }

    private void andarRua29() throws InterruptedException {
        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento34() throws InterruptedException {
        Semaforos.getSemaforo(34).acquire();

        while(x != 246) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(34).release();
    }

    private void andarRua28() throws InterruptedException {
        while(x != 182) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento33() throws InterruptedException {
        Semaforos.getSemaforo(33).acquire();

        while(x != 156) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(33).release();
    }

    private void andarRua27() throws InterruptedException {
        while(x != 90) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento32() throws InterruptedException {
        Semaforos.getSemaforo(32).acquire();

        while(x != 64) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforo(32).release();
    }

    private void andarRua26() throws InterruptedException {
        while(x != 0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    private void passarCruzamento31() throws InterruptedException {
        Semaforos.getSemaforo(31).acquire();

        while(x != -16) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        } 

        carro.setRotate(90);

        while(y != 442) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 

        Semaforos.getSemaforo(31).release();
    }

    private void andarRua5B() throws InterruptedException {
        while(y != 378) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    private void passarCruzamento25() throws InterruptedException {
        Semaforos.getSemaforo(25).acquire();

        while(y != 352) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 

        Semaforos.getSemaforo(25).release();
    }

    private void andarRua4B() throws InterruptedException {
        while(y != 288) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    private void passarCruzamento19() throws InterruptedException {
        Semaforos.getSemaforo(19).acquire();

        while(y != 258) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 

        Semaforos.getSemaforo(19).release();
    }

    private void andarRua3B() throws InterruptedException {
        while(y != 194) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    private void passarCruzamento13() throws InterruptedException {
        Semaforos.getSemaforo(13).acquire();

        while(y != 168) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 

        Semaforos.getSemaforo(13).release();
    }

    private void andarRua2B() throws InterruptedException {
        while(y != 104) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    private void passarCruzamento7() throws InterruptedException {
        Semaforos.getSemaforo(7).acquire();

        while(y != 78) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 

        Semaforos.getSemaforo(7).release();
    }

    private void andarRua1B() throws InterruptedException {
        while(y != 14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    private void passarCruzamento1() throws InterruptedException {
        Semaforos.getSemaforo(1).acquire();

        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 

        carro.setRotate(0);

        while(x != 0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        } 

        Semaforos.getSemaforo(1).release();
    }
}
