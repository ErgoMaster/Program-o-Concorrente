/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Verde
* Funcao...........: Controla o carro verde da simulacao
*************************************************************** */

package Model;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class CarroVerde extends Thread {
    private double x; // Posicao x do carro
    private double y; // Posicao y do carro
    private int velocidade; // Velocidade do carro
    private ImageView carro; // Image view correspondente
    private Slider sliderVelocidade; // Slider correspondente

    // Construtor
    public CarroVerde(int velocidade, ImageView carro, Slider sliderVelocidade) {
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
                andarRua28B();
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
                andarRua11B();
                passarCruzamento9();
                andarRua12B();
                passarCruzamento15();
                andarRua13B();

                Semaforos.getSemaforoLaranjaVerde().acquire();

                passarCruzamento21();
                andarRua18();

                Semaforos.getSemaforoAzulVerde().acquire();

                passarCruzamento22();
                andarRua19();
                passarCruzamento23();

                Semaforos.getSemaforoAzulVerde().release();

                andarRua20();
                passarCruzamento24();

                Semaforos.getSemaforoLaranjaVerde().release();
            } // Fim do while
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } // Fim do metodo run

    /* ***************************************************************
    * Metodo: andarRua28B
    * Funcao: Faz o carro andar a rua 28B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua28B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(28).acquire();

        while(y != -66) {
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

        while(y != -156) {
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

        while(y != -182) {
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

        while(y != -246) {
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

        while(y != -260) {
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

        while(x != -78) {
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

        while(x != -104) {
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

        while(x != -168) {
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

        while(x != -194) {
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

        while(x != -258) {
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

        while(x != -274) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        Platform.runLater( () -> carro.setRotate(90));

        while(y != -246) {
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

        while(y != -182) {
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

        while(y != -156) {
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

        while(y != -92) {
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

        while(y != -66) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Semaforos.getSemaforoCruzamentos(15).release();
    }

    /* ***************************************************************
    * Metodo: andarRua13B
    * Funcao: Faz o carro andar a rua 13B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua13B() throws InterruptedException {
        Semaforos.getSemaforoRuasVerticais(13).acquire();

        while(y != 0) {
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

        while(y != 14) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        Platform.runLater( () -> carro.setRotate(0));

        while(x != -258) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        Semaforos.getSemaforoCruzamentos(21).release();
    }

    /* ***************************************************************
    * Metodo: andarRua18
    * Funcao: Faz o carro andar a rua 18
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua18() throws InterruptedException {
        Semaforos.getSemaforoRuasHorizontais(18).acquire();

        while(x != -194) {
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

        while(x != -168) {
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

        while(x != -104) {
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

        while(x != -78) {
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

        while(x != -14) {
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

        while(x != 0) {
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

        Semaforos.getSemaforoCruzamentos(24).release();
    }
}
