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
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class CarroLaranja extends Thread {
    private double x; // Posicao x do carro
    private double y; // Posicao y do carro
    private int velocidade; // Velocidade do carro
    private ImageView carro; // Image view correspondente
    private Slider sliderVelocidade; // Slider correspondente

    // Construtor
    public CarroLaranja(int velocidade, ImageView carro, Slider sliderVelocidade) {
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
                andarRua30B();
                passarCruzamento30();
                andarRua29B();

                Semaforos.getSemaforoLaranjaVerde().acquire();

                passarCruzamento24();
                andarRua20();
                passarCruzamento23();
                andarRua19();
                passarCruzamento22();
                andarRua18();
                passarCruzamento21();

                if(!primeraVez) {
                    Semaforos.getSemaforoAmareloLaranja().release();
                }
                Semaforos.getSemaforoLaranjaVerde().release();
                
                andarRua17();
                passarCruzamento20();
                andarRua16();

                Semaforos.getSemaforoAmareloLaranja().acquire();

                passarCruzamento19();
                andarRua4B();
                passarCruzamento25();
                andarRua5B();
                passarCruzamento31();
                andarRua26();
                passarCruzamento32();
                andarRua27();
                passarCruzamento33();
                andarRua28();
                passarCruzamento34();
                andarRua29();
                passarCruzamento35();
                andarRua30();
                passarCruzamento36();

                primeraVez = false;
            } // Fim do while
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    } // Fim do metodo run

    /* ***************************************************************
    * Metodo: andarRua30B
    * Funcao: Faz o carro andar a rua 30B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua30B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(30).acquire();

        while(y != -64) {
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

        Semaforos.getSemaforoCruzamentos(30).release();
    }

    /* ***************************************************************
    * Metodo: andarRua29B
    * Funcao: Faz o carro andar a rua 29B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua29B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(29).acquire();

        while(y != -154) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(29).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento24
    * Funcao: Faz o carro passar o cruzamento 24
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento24() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(24).acquire();

        while(y != -170) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != -14) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(24).release();
    }

    /* ***************************************************************
    * Metodo: andarRua20
    * Funcao: Faz o carro andar a rua 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua20() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(20).acquire();

        while(x != -78) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(20).release();
    } 

    /* ***************************************************************
    * Metodo: passarCruzamento23
    * Funcao: Faz o carro passar o cruzamento 23
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento23() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(23).acquire();

        while(x != -104) {
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

        while(x != -170) {
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

        while(x != -196) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(22).release();
    }

    /* ***************************************************************
    * Metodo: andarRua18
    * Funcao: Faz o carro andar a rua 18
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua18() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(18).acquire();

        while(x != -260) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(18).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento21
    * Funcao: Faz o carro passar o cruzamento 21
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento21() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(21).acquire();

        while(x != -288) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(21).release();
    }

    /* ***************************************************************
    * Metodo: andarRua17
    * Funcao: Faz o carro andar a rua 17
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua17() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(17).acquire();

        while(x != -350) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(17).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento20
    * Funcao: Faz o carro passar o cruzamento 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento20() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(20).acquire();

        while(x != -378) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(20).release();
    }

    /* ***************************************************************
    * Metodo: andarRua16
    * Funcao: Faz o carro andar a rua 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua16() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(16).acquire();

        while(x != -442) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(16).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento19
    * Funcao: Faz o carro passar o cruzamento 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento19() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(19).acquire();

        while(x != -454) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -156) {
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

        while(y != -88) {
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

        while(y != -62) {
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

        while(y != 0) {
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

        while(y != 14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != -438) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(31).release();
    }   

    /* ***************************************************************
    * Metodo: andarRua26
    * Funcao: Faz o carro andar a rua 26
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua26() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(26).acquire();

        while(x != -374) {
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

        while(x != -348) {
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

        while(x != -284) {
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
        
        while(x != -258) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(33).release();
    }

    /* ***************************************************************
    * Metodo: andarRua28
    * Funcao: Faz o carro andar a rua 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua28() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(28).acquire();

        while(x != -194) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(28).release();
    }
 
    /* ***************************************************************
    * Metodo: passarCruzamento34
    * Funcao: Faz o carro passar o cruzamento 34
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento34() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(34).acquire();

        while(x != -168) {
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

        while(x != -104) {
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
        
        while(x != -78) {
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

        while(x != -14) {
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

        while(x != -0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(36).release();
    }
}
