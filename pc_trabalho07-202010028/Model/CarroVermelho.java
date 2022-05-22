/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Vermelho
* Funcao...........: Controla o carro vermelho da simulacao
*************************************************************** */

package Model;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class CarroVermelho extends Thread {
    private double x; // Posicao x do carro
    private double y; // Posicao y do carro
    private int velocidade; // Velocidade do carro
    private ImageView carro; // Image view correspondente
    private Slider sliderVelocidade; // Slider correspondente

    // Construtor
    public CarroVermelho(int velocidade, ImageView carro, Slider sliderVelocidade) {
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
        /*
        Semaforos.getSemaforoRuasHorizontais().acquire();
        Semaforos.getSemaforoRuasVerticais().acquire();
        Semaforos.getSemaforoCruzamentos().acquire();
        */
        try {
            while(true) {
                // Circuito completo do carro junto com as chamadas dos semaforos necessarios
                atualizarVelocidade();
                andarRua16();
                passarCruzamento20();
                andarRua17();
                passarCruzamento21();
                andarRua14B();
                passarCruzamento27();
                andarRua15B();
                passarCruzamento33();
                andarRua28();
                passarCruzamento34();
                andarRua20B();
                passarCruzamento28();
                andarRua19B();
                passarCruzamento22();
                andarRua19();
                passarCruzamento23();
                andarRua20();
                passarCruzamento24();
                andarRua28B();
                passarCruzamento18();
                andarRua15();
                passarCruzamento17();
                andarRua14();
                passarCruzamento16();
                andarRua17B();
                passarCruzamento10();
                andarRua16B();
                passarCruzamento4();
                andarRua3();
                passarCruzamento3();
                andarRua11B();
                passarCruzamento9();
                andarRua12B();
                passarCruzamento15();
                andarRua12();
                passarCruzamento14();
                andarRua11();
                passarCruzamento13();
                andarRua3B();
                passarCruzamento19();
            } // Fim do while
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    } // Fim do metodo run

    /* ***************************************************************
    * Metodo: andarRua16
    * Funcao: Faz o carro andar a rua 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua16() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(16).acquire();

        while(x != 66) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(16).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento20
    * Funcao: Faz o carro passar o cruzamento 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento20() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(20).acquire();

        while(x != 92) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(20).release();
    }

    /* ***************************************************************
    * Metodo: andarRua17
    * Funcao: Faz o carro andar a rua 17
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua17() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(17).acquire();

        while(x != 156) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(17).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento21
    * Funcao: Faz o carro passar o cruzamento 21
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento21() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(21).acquire();

        while(x != 170) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Platform.runLater( () -> carro.setRotate(90)); 

        while(y != 14) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(21).release();
    }

    /* ***************************************************************
    * Metodo: andarRua14B
    * Funcao: Faz o carro andar a rua 14B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua14B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(14).acquire();

        while(y != 78) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(14).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento27
    * Funcao: Faz o carro passar o cruzamento 27
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento27() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(27).acquire();

        while(y != 104) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(27).release();
    }

    /* ***************************************************************
    * Metodo: andarRua15B
    * Funcao: Faz o carro andar a rua 15B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua15B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(15).acquire();

        while(y != 168) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(15).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento33
    * Funcao: Faz o carro passar o cruzamento 33
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento33() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(33).acquire();

        while(y != 182) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Platform.runLater( () -> carro.setRotate(0)); 

        while(x != 186) {
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

        while(x != 248) {
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

        while(x != 262) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Platform.runLater( () -> carro.setRotate(90)); 

        while(y != 168) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(34).release();
    }

    /* ***************************************************************
    * Metodo: andarRua20B
    * Funcao: Faz o carro andar a rua 20B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua20B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(20).acquire();

        while(y != 104) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(20).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento28
    * Funcao: Faz o carro passar o cruzamento 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento28() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(28).acquire();

        while(y != 78) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(28).release();
    }

    /* ***************************************************************
    * Metodo: andarRua19B
    * Funcao: Faz o carro andar a rua 19B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua19B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(19).acquire();

        while(y != 14) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(19).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento22
    * Funcao: Faz o carro passar o cruzamento 22
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento22() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(22).acquire();

        while(y != 0) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0)); 

        while(x != 276) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(22).release();
    }

    /* ***************************************************************
    * Metodo: andarRua19
    * Funcao: Faz o carro andar a rua 19
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua19() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(19).acquire();

        while(x != 340) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(19).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento23
    * Funcao: Faz o carro passar o cruzamento 23
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento23() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(23).acquire();

        while(x != 366) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(23).release();
    }

    /* ***************************************************************
    * Metodo: andarRua20
    * Funcao: Faz o carro andar a rua 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua20() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(20).acquire();

        while(x != 430) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoRuasHorizontais(20).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento24
    * Funcao: Faz o carro passar o cruzamento 24
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento24() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(24).acquire();

        while(x != 444) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Platform.runLater( () -> carro.setRotate(90)); 

        while(y != -16) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(24).release();
    }

    /* ***************************************************************
    * Metodo: andarRua28B
    * Funcao: Faz o carro andar a rua 28B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua28B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(28).acquire();

        while(y != -80) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(28).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento18
    * Funcao: Faz o carro passar o cruzamento 18
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento18() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(18).acquire();

        while(y != -92) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0)); 

        while(x != 430) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(18).release();
    }

    /* ***************************************************************
    * Metodo: andarRua15
    * Funcao: Faz o carro andar a rua 15
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua15() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(15).acquire();

        while(x != 366) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(15).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento17
    * Funcao: Faz o carro passar o cruzamento 17
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento17() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(17).acquire();

        while(x != 340) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(17).release();
    }

    /* ***************************************************************
    * Metodo: andarRua14
    * Funcao: Faz o carro andar a rua 14
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua14() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(14).acquire();

        while(x != 274) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(14).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento16
    * Funcao: Faz o carro passar o cruzamento 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento16() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(16).acquire();

        while(x != 260) {
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

        Semaforos.getSemaforoCruzamentos(16).release();
    }

    /* ***************************************************************
    * Metodo: andarRua17B
    * Funcao: Faz o carro andar a rua 17B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua17B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(17).acquire();

        while(y != -170) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(17).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento10
    * Funcao: Faz o carro passar o cruzamento 10
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento10() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(10).acquire();

        while(y != -196) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(10).release();
    }

    /* ***************************************************************
    * Metodo: andarRua16B
    * Funcao: Faz o carro andar a rua 16B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua16B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(16).acquire();

        while(y != -260) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoRuasVerticais(16).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento4
    * Funcao: Faz o carro passar o cruzamento 4
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento4() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(4).acquire();

        while(y != -274) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0)); 

        while(x != 244) {
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

        while(x != 168) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Platform.runLater( () -> carro.setRotate(90)); 

        while(y != -260) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(3).release();
    }

    /* ***************************************************************
    * Metodo: andarRua11B
    * Funcao: Faz o carro andar a rua 11B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua11B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(11).acquire();

        while(y != -196) {
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

        while(y != -170) {
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

        while(y != -106) {
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

        while(y != -90) {
            Thread.sleep(velocidade);

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Platform.runLater( () -> carro.setRotate(0)); 

        while(x != 154) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(15).release();
    }

    /* ***************************************************************
    * Metodo: andarRua12
    * Funcao: Faz o carro andar a rua 12
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua12() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(12).acquire();

        while(x != 90) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(12).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento14
    * Funcao: Faz o carro passar o cruzamento 14
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento14() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(14).acquire();

        while(x != 64) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoCruzamentos(14).release();
    }

    /* ***************************************************************
    * Metodo: andarRua11
    * Funcao: Faz o carro andar a rua 11
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua11() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(11).acquire();

        while(x != 0) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Semaforos.getSemaforoRuasHorizontais(11).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento13
    * Funcao: Faz o carro passar o cruzamento 13
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento13() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(13).acquire();

        while(x != -14) {
            Thread.sleep(velocidade);

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Platform.runLater( () -> carro.setRotate(90)); 

        while(y != -76) {
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

        while(y != -14) {
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

        Semaforos.getSemaforoCruzamentos(19).release();
    }
}
