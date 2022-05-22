/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Roxo
* Funcao...........: Controla o carro roxo da simulacao
*************************************************************** */

package Model;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class CarroRoxo extends Thread {
    private double x; // Posicao x do carro
    private double y; // Posicao y do carro
    private int velocidade; // Velocidade do carro
    private ImageView carro; // Image view correspondente
    private Slider sliderVelocidade; // Slider correspondente

    // Construtor
    public CarroRoxo(int velocidade, ImageView carro, Slider sliderVelocidade) {
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
        try {
            while(true) {
                // Circuito completo do carro junto com as chamadas dos semaforos necessarios
                atualizarVelocidade();
                andarRua19B();
                passarCruzamento22();
                andarRua18B();
                passarCruzamento16();
                andarRua17B();
                passarCruzamento10();
                andarRua16B();
                passarCruzamento4();
                andarRua3();

                Semaforos.getSemaforoAmareloRoxo(2).acquire();

                passarCruzamento3();
                andarRua2();
                passarCruzamento2();

                Semaforos.getSemaforoAmareloRoxo(2).release();
                
                andarRua6B();
                passarCruzamento8();
                andarRua7B();
                passarCruzamento14();
                andarRua8B();
                passarCruzamento20();
                andarRua9B();
                passarCruzamento26();
                andarRua10B();

                Semaforos.getSemaforoAmareloRoxo(1).acquire();

                passarCruzamento32();
                andarRua27();
                passarCruzamento33();
                andarRua28();

                Semaforos.getSemaforoAzulRoxo().acquire();

                passarCruzamento34();

                Semaforos.getSemaforoAmareloRoxo(1).release();

                andarRua20B();
                passarCruzamento28();

                Semaforos.getSemaforoAzulRoxo().release();
            } // Fim do while
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    } // Fim do metodo run

    /* ***************************************************************
    * Metodo: andarRua19B
    * Funcao: Faz o carro andar a rua 19B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua19B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(19).acquire();

        while(y != -66) {
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

        while(y != -92) {
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

        while(y != -156) {
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

        while(y != -182) {
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

        while(y != -246) {
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

        while(y != -272) {
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

        while(y != -336) {
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

        while(y != -350) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != -16) {
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

        while(x != -80) {
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

        while(x != -106) {
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

        while(x != -170) {
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

        while(x != -182) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -334) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(2).release();
    }

    /* ***************************************************************
    * Metodo: andarRua6B
    * Funcao: Faz o carro andar a rua 6B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua6B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(6).acquire();

        while(y != -270) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(6).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento8
    * Funcao: Faz o carro passar o cruzamento 8
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento8() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(8).acquire();

        while(y != -244) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(8).release();
    }

    /* ***************************************************************
    * Metodo: andarRua7B
    * Funcao: Faz o carro andar a rua 7B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua7B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(7).acquire();

        while(y != -180) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(7).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento14
    * Funcao: Faz o carro passar o cruzamento 
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento14() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(14).acquire();

        while(y != -154) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(14).release();
    }

    /* ***************************************************************
    * Metodo: andarRua8B
    * Funcao: Faz o carro andar a rua 8B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua8B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(8).acquire();

        while(y != -90) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(8).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento20
    * Funcao: Faz o carro passar o cruzamento 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento20() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(20).acquire();

        while(y != -64) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(20).release();
    }

    /* ***************************************************************
    * Metodo: andarRua9B
    * Funcao: Faz o carro andar a rua 9B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua9B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(9).acquire();

        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(9).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento26
    * Funcao: Faz o carro passar o cruzamento 26
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento26() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(26).acquire();

        while(y != 26) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(26).release();
    }

    /* ***************************************************************
    * Metodo: andarRua10B
    * Funcao: Faz o carro andar a rua 10B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua10B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(10).acquire();

        while(y != 92) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoRuasVerticais(10).release();
    }

    /* ***************************************************************
    * Metodo: passarCruzamento32
    * Funcao: Faz o carro passar o cruzamento 32
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento32() throws InterruptedException {
        Semaforos.getSemaforoCruzamentos(32).acquire();

        while(y != 104) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != -166) {
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

        while(x != -102) {
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

        while(x != -76) {
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

        while(x != -12) {
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

        while(x != 0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != 90) {
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

        while(y != 26) {
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

        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        Semaforos.getSemaforoCruzamentos(28).release();
    }
}
