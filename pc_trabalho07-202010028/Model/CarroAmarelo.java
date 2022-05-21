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
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class CarroAmarelo extends Thread {
    private double x; // Posicao x do carro
    private double y; // Posicao y do carro
    private int velocidade; // Velocidade do carro
    private ImageView carro; // Image view correspondente
    private Slider sliderVelocidade; // Slider correspondente

    // Construtor
    public CarroAmarelo(int velocidade, ImageView carro, Slider sliderVelocidade) {
        this.velocidade = velocidade;
        this.carro = carro;
        this.sliderVelocidade = sliderVelocidade;

        x = carro.getX();
        y = carro.getY();
    } // Fim do contrutor

    /* ***************************************************************
    * Metodo: atualizarVelocidade
    * Funcao: Verificar se houve mudanca no slider de velocidade e atualizar a variavel para a nova velocidade
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void atualizarVelocidade() {
        velocidade = (int) sliderVelocidade.getValue();
    } // Fim do metodo atualizar velocidade

    /* ***************************************************************
    * Metodo: run
    * Funcao: Inicializa a thread
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    @Override
    public void run() {
        /* Variavel para verificar se eh a primeira vez que o carro esta fazendo o circuito. Isso deve ser
        feito porque ha momentos em que o carro da um "up" em um semaforo antes de dar um "down", entao 
        devemos proteger esse semaforo para que ele nao va para valor 2 */
        boolean primeraVez = true; 

        try {
            while(true) {
                // Circuito completo do carro junto com as chamadas dos semaforos necessarios
                atualizarVelocidade();
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

                primeraVez = false; // Seta a variavel como falsa a todo momento do circuito
            } // Fim do while
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    } // Fim do metodo run
    
    /* ***************************************************************
    * Metodo: andarRua 1
    * Funcao: Faz o carro andar a rua 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua1() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(1).acquire();

        while(x != 66) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(1).release();
    } 

    /* ***************************************************************
    * Metodo: passarCruzamento2
    * Funcao: Faz o carro passar o cruzamento 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento2() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(2).acquire();

        while(x != 90) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(2).release();
    }

    /* ***************************************************************
    * Metodo: andarRua 2
    * Funcao: Faz o carro andar a rua 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua2() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(2).acquire();

        while(x != 156) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(2).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento3
    * Funcao: Faz o carro passar o cruzamento 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento3() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(3).acquire();

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

        Semaforos.getSemaforoCruzamentos(3).release();
    }

    /* ***************************************************************
    * Metodo: andarRua 11B
    * Funcao: Faz o carro andar a rua 11B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua11B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(11).acquire();

        while(y != 80) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(11).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento9
    * Funcao: Faz o carro passar o cruzamento 9
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento9() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(9).acquire();

        while(y != 106) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(9).release();
    }

    /* ***************************************************************
    * Metodo: andarRua12B
    * Funcao: Faz o carro andar a rua 12B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua12B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(12).acquire();

        while(y != 170) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(12).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento15
    * Funcao: Faz o carro passar o cruzamento 15
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento15() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(15).acquire();

        while(y != 196) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(15).release();
    }

    /* ***************************************************************
    * Metodo: andarRua 13B
    * Funcao: Faz o carro andar a rua 13B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua13B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(13).acquire();

        while(y != 260) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(13).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento21
    * Funcao: Faz o carro passar o cruzamento 21
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento21() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(21).acquire();

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

        Semaforos.getSemaforoCruzamentos(21).release();
    }

    /* ***************************************************************
    * Metodo: andarRua 18
    * Funcao: Faz o carro andar a rua 18
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua18() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(18).acquire();

        while(x != 246) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(18).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento22
    * Funcao: Faz o carro passar o cruzamento 22
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento22() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(22).acquire();

        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(22).release();
    }

    /* ***************************************************************
    * Metodo: andarRua 19
    * Funcao: Faz o carro andar a rua 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua19() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(19).acquire();

        while(x != 336) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(19).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento23
    * Funcao: Faz o carro passar o cruzamento 
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento23() throws InterruptedException {
        while(x != 362) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua 20
    * Funcao: Faz o carro andar a rua 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua20() throws InterruptedException {
        while(x != 426) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento24
    * Funcao: Faz o carro passar o cruzamento 24
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento24() throws InterruptedException {
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
    }

    /* ***************************************************************
    * Metodo: andarRua29B
    * Funcao: Faz o carro andar a rua 29B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua29B() throws InterruptedException {
        while(y != 352) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento30
    * Funcao: Faz o carro passar o cruzamento 30
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento30() throws InterruptedException {
        while(y != 378) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua30B
    * Funcao: Faz o carro andar a rua 30B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua30B() throws InterruptedException {
        while(y != 442) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento36
    * Funcao: Faz o carro passar o cruzamento 36
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento36() throws InterruptedException {
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
    }

    /* ***************************************************************
    * Metodo: andarRua30
    * Funcao: Faz o carro andar a rua 30
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua30() throws InterruptedException {
        while(x != 362) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento35
    * Funcao: Faz o carro passar o cruzamento 35
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento35() throws InterruptedException {
        while(x != 336) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua29
    * Funcao: Faz o carro andar a rua 29
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua29() throws InterruptedException {
        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua34
    * Funcao: Faz o carro andar a rua 34
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento34() throws InterruptedException {
        while(x != 246) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua28
    * Funcao: Faz o carro andar a rua 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua28() throws InterruptedException {
        while(x != 182) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua33
    * Funcao: Faz o carro andar a rua 33
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento33() throws InterruptedException {
        while(x != 156) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua27
    * Funcao: Faz o carro andar a rua 27
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua27() throws InterruptedException {
        while(x != 90) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua32
    * Funcao: Faz o carro andar a rua 32
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento32() throws InterruptedException {
        while(x != 64) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua26
    * Funcao: Faz o carro andar a rua 26
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua26() throws InterruptedException {
        while(x != 0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua31
    * Funcao: Faz o carro andar a rua 31
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento31() throws InterruptedException {
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
    }

    /* ***************************************************************
    * Metodo: andarRua5B
    * Funcao: Faz o carro andar a rua 5B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua5B() throws InterruptedException {
        while(y != 378) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    /* ***************************************************************
    * Metodo: andarRua25
    * Funcao: Faz o carro andar a rua 25
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento25() throws InterruptedException {
        while(y != 352) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    /* ***************************************************************
    * Metodo: andarRua4B
    * Funcao: Faz o carro andar a rua 4B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua4B() throws InterruptedException {
        while(y != 288) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    /* ***************************************************************
    * Metodo: andarRua19
    * Funcao: Faz o carro andar a rua 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento19() throws InterruptedException {
        while(y != 258) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    /* ***************************************************************
    * Metodo: andarRua3B
    * Funcao: Faz o carro andar a rua 3B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua3B() throws InterruptedException {
        while(y != 194) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    /* ***************************************************************
    * Metodo: andarRua13
    * Funcao: Faz o carro andar a rua 13
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento13() throws InterruptedException {
        while(y != 168) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    /* ***************************************************************
    * Metodo: andarRua2B
    * Funcao: Faz o carro andar a rua 2B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua2B() throws InterruptedException {
        while(y != 104) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    /* ***************************************************************
    * Metodo: andarRua7
    * Funcao: Faz o carro andar a rua 7
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento7() throws InterruptedException {
        while(y != 78) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    /* ***************************************************************
    * Metodo: andarRua1B
    * Funcao: Faz o carro andar a rua 1B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua1B() throws InterruptedException {
        while(y != 14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        } 
    }

    /* ***************************************************************
    * Metodo: andarRua1
    * Funcao: Faz o carro andar a rua 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento1() throws InterruptedException {
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
    }
}
