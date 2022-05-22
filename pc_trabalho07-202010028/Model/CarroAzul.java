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
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class CarroAzul extends Thread {
    private double x; // Posicao x do carro
    private double y; // Posicao y do carro
    private int velocidade; // Velocidade do carro
    private ImageView carro; // Image view correspondente
    private Slider sliderVelocidade; // Slider correspondente

    // Construtor
    public CarroAzul(int velocidade, ImageView carro, Slider sliderVelocidade) {
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
                andarRua26();
                passarCruzamento32();
                andarRua27();
                passarCruzamento33();

                if(!primeraVez) {
                    Semaforos.getSemaforosAmareloAzul(1).release();
                }
                
                andarRua15B();
                passarCruzamento27();
                andarRua23();

                Semaforos.getSemaforoAzulRoxo().acquire();

                passarCruzamento28();
                andarRua20B();

                Semaforos.getSemaforosAmareloAzul(2).acquire();

                passarCruzamento34();

                Semaforos.getSemaforoAzulRoxo().release();

                andarRua29();
                passarCruzamento35();
                andarRua30();
                passarCruzamento36();
                andarRua30B();
                passarCruzamento30();

                Semaforos.getSemaforosAmareloAzul(2).release();

                andarRua25();
                passarCruzamento29();
                andarRua24B();

                Semaforos.getSemaforoAzulVerde().acquire();
                Semaforos.getSemaforosAmareloAzul(3).acquire();

                passarCruzamento23();
                andarRua19();
                passarCruzamento22();

                Semaforos.getSemaforosAmareloAzul(3).release();
                Semaforos.getSemaforoAzulVerde().release();
                
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

                Semaforos.getSemaforosAmareloAzul(1).acquire();

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

                primeraVez = false;
            } // Fim do while
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    } // Fim do metodo run

    /* ***************************************************************
    * Metodo: andarRua26
    * Funcao: Faz o carro andar a rua 26
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua26() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(26).acquire();

        while(x != 66) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(26).release();
    } 

    /* ***************************************************************
    * Metodo: passarCruzamento32
    * Funcao: Faz o carro passar o cruzamento 32
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento32() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(32).acquire();

        while(x != 92) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(32).release();
    }

    /* ***************************************************************
    * Metodo: andarRua27
    * Funcao: Faz o carro andar a rua 27
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua27() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(27).acquire();

        while(x != 156) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(27).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento33
    * Funcao: Faz o carro passar o cruzamento 33
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento33() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(33).acquire();

        while(x != 170) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(33).release();
    }

    /* ***************************************************************
    * Metodo: andarRua15B
    * Funcao: Faz o carro andar a rua 15B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua15B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(15).acquire();

        while(y != -78) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(15).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento27
    * Funcao: Faz o carro passar o cruzamento 27
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento27() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(27).acquire();

        while(y != -92) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != 182) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(27).release();
    }

    /* ***************************************************************
    * Metodo: andarRua23
    * Funcao: Faz o carro andar a rua 23
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua23() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(23).acquire();

        while(x != 246) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(23).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento28
    * Funcao: Faz o carro passar o cruzamento 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento28() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(28).acquire();

        while(x != 260) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -76) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(28).release();
    }

    /* ***************************************************************
    * Metodo: andarRua20B
    * Funcao: Faz o carro andar a rua 20B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua20B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(20).acquire();

        while(y != -12) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(20).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento34
    * Funcao: Faz o carro passar o cruzamento 34
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento34() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(34).acquire();

        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(34).release();
    }

    /* ***************************************************************
    * Metodo: andarRua29
    * Funcao: Faz o carro andar a rua 29
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua29() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(29).acquire();

        while(x != 336) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(29).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento35
    * Funcao: Faz o carro passar o cruzamento 35
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento35() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(35).acquire();

        while(x != 364) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(35).release();
    }

    /* ***************************************************************
    * Metodo: andarRua30
    * Funcao: Faz o carro andar a rua 30
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua30() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(30).acquire();

        while(x != 428) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(30).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento36
    * Funcao: Faz o carro passar o cruzamento 36
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento36() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(36).acquire();

        while(x != 442) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(36).release();
    }

    /* ***************************************************************
    * Metodo: andarRua30B
    * Funcao: Faz o carro andar a rua 30B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua30B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(30).acquire();

        while(y != -78) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(30).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento30
    * Funcao: Faz o carro passar o cruzamento 30
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento30() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(30).acquire();

        while(y != -90) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != 428) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(30).release();
    }

    /* ***************************************************************
    * Metodo: andarRua25
    * Funcao: Faz o carro andar a rua 25
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua25() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(25).acquire();

        while(x != 362) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(25).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento29
    * Funcao: Faz o carro passar o cruzamento 29
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento29() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(29).acquire();

        while(x != 350) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -106) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(29).release();
    }

    /* ***************************************************************
    * Metodo: andarRua24B
    * Funcao: Faz o carro andar a rua 24B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua24B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(24).acquire();

        while(y != -170) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(24).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento23
    * Funcao: Faz o carro passar o cruzamento 23
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento23() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(23).acquire();

        while(y != -182) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != 336) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(23).release();
    }

    /* ***************************************************************
    * Metodo: andarRua19
    * Funcao: Faz o carro andar a rua 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua19() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(19).acquire();

        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(19).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento22
    * Funcao: Faz o carro passar o cruzamento 22
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento22() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(22).acquire();

        while(x != 258) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -196) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(22).release();
    }

    /* ***************************************************************
    * Metodo: andarRua18B
    * Funcao: Faz o carro andar a rua 18B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua18B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(18).acquire();

        while(y != -260) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(18).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento16
    * Funcao: Faz o carro passar o cruzamento 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento16() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(16).acquire();

        while(y != -274) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != 274) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(16).release();
    }

    /* ***************************************************************
    * Metodo: andarRua14
    * Funcao: Faz o carro andar a rua 14
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua14() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(14).acquire();

        while(x != 338) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(14).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento17
    * Funcao: Faz o carro passar o cruzamento 17
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento17() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(17).acquire();

        while(x != 364) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(17).release();
    }

    /* ***************************************************************
    * Metodo: andarRua15
    * Funcao: Faz o carro andar a rua 15
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua15() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(15).acquire();

        while(x != 428) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(15).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento18
    * Funcao: Faz o carro passar o cruzamento 18
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento18() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(18).acquire();

        while(x != 442) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -286) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(18).release();
    }

    /* ***************************************************************
    * Metodo: andarRua27B
    * Funcao: Faz o carro andar a rua 27B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua27B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(27).acquire();

        while(y != -350) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(27).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento12
    * Funcao: Faz o carro passar o cruzamento 12
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento12() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(12).acquire();

        while(y != -376) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(12).release();
    }

    /* ***************************************************************
    * Metodo: andarRua26B
    * Funcao: Faz o carro andar a rua 26B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua26B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(26).acquire();

        while(y != -440) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(26).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento6
    * Funcao: Faz o carro passar o cruzamento 6
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento6() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(6).acquire();

        while(y != -454) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != 428) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(6).release();
    }

    /* ***************************************************************
    * Metodo: andarRua5
    * Funcao: Faz o carro andar a rua 5
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua5() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(5).acquire();

        while(x != 362) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(5).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento5
    * Funcao: Faz o carro passar o cruzamento 5
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento5() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(5).acquire();

        while(x != 336) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(5).release();
    }

    /* ***************************************************************
    * Metodo: andarRua4
    * Funcao: Faz o carro andar a rua 4
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua4() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(4).acquire();

        while(x != 272) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(4).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento4
    * Funcao: Faz o carro passar o cruzamento 4
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento4() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(4).acquire();

        while(x != 246) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(4).release();
    }

    /* ***************************************************************
    * Metodo: andarRua3
    * Funcao: Faz o carro andar a rua 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua3() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(3).acquire();

        while(x != 182) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 
                                                                                                                                                                                                                                             
            x--;    
        }

        Semaforos.getSemaforoRuasHorizontais(3).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento3
    * Funcao: Faz o carro passar o cruzamento 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento3() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(3).acquire();
        
        while(x != 156) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(3).release();
    }

    /* ***************************************************************
    * Metodo: andarRua2
    * Funcao: Faz o carro andar a rua 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua2() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(2).acquire();

        while(x != 92) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(2).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento2
    * Funcao: Faz o carro passar o cruzamento 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento2() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(2).acquire();

        while(x != 66) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(2).release();
    }

    /* ***************************************************************
    * Metodo: andarRua1
    * Funcao: Faz o carro andar a rua 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua1() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(1).acquire();

        while(x != 0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(1).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento1
    * Funcao: Faz o carro passar o cruzamento 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento1() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(1).acquire();

        while(x != -14) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -438) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(1).release();
    }

    /* ***************************************************************
    * Metodo: andarRua1B
    * Funcao: Faz o carro andar a rua 1B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua1B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(1).acquire();

        while(y != -374) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(1).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento7
    * Funcao: Faz o carro passar o cruzamento 7
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento7() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(7).acquire();

        while(y != -348) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(7).release();
    }

    /* ***************************************************************
    * Metodo: andarRua2B
    * Funcao: Faz o carro andar a rua 2B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua2B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(2).acquire();

        while(y != -284) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(2).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento13
    * Funcao: Faz o carro passar o cruzamento 13
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento13() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(13).acquire();

        while(y != -258) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(13).release();
    }

    /* ***************************************************************
    * Metodo: andarRua3B
    * Funcao: Faz o carro andar a rua 3B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua3B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(3).acquire();

        while(y != -194) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(3).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento19
    * Funcao: Faz o carro passar o cruzamento 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento19() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(19).acquire();

        while(y != -168) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(19).release();
    }

    /* ***************************************************************
    * Metodo: andarRua4B
    * Funcao: Faz o carro andar a rua 4B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua4B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(4).acquire();

        while(y != -104) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(4).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento25
    * Funcao: Faz o carro passar o cruzamento 25
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento25() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(25).acquire();

        while(y != -78) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(25).release();
    }

    /* ***************************************************************
    * Metodo: andarRua5B
    * Funcao: Faz o carro andar a rua 5B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua5B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(5).acquire();

        while(y != -14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(5).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento31
    * Funcao: Faz o carro passar o cruzamento 31
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento31() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(31).acquire();

        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != 0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(31).release();
    }
}
