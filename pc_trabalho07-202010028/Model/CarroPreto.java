/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 16/05/2022
* Ultima alteracao.: xx
* Nome.............: Carro Preto
* Funcao...........: Controla o carro preto da simulacao
*************************************************************** */

package Model;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class CarroPreto extends Thread {
    private double x; // Posicao x do carro
    private double y; // Posicao y do carro
    private int velocidade; // Velocidade do carro
    private ImageView carro; // Image view correspondente
    private Slider sliderVelocidade; // Slider correspondente

    // Construtor
    public CarroPreto(int velocidade, ImageView carro, Slider sliderVelocidade) {
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
                andarRua11();
                passarCruzamento14();
                andarRua12();
                passarCruzamento15();
                andarRua13();
                passarCruzamento16();
                andarRua14();
                passarCruzamento17();
                andarRua15();
                passarCruzamento18();

                primeraVez = false; // Seta a variavel como falsa a todo momento do circuito
            } // Fim do while
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    } // Fim do metodo run

    /* ***************************************************************
    * Metodo: andarRua27B
    * Funcao: Faz o carro andar a rua 27B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua27B() throws InterruptedException {
        while(y != -66) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento12
    * Funcao: Faz o carro passar o cruzamento 12
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento12() throws InterruptedException {
        while(y != -92) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua26B
    * Funcao: Faz o carro andar a rua 26B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua26B() throws InterruptedException {
        while(y != -156) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento6
    * Funcao: Faz o carro passar o cruzamento 6
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento6() throws InterruptedException {
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

    /* ***************************************************************
    * Metodo: andarRua5
    * Funcao: Faz o carro andar a rua 5
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua5() throws InterruptedException {
        while(x != -78) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento5
    * Funcao: Faz o carro passar o cruzamento 5
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento5() throws InterruptedException {
        while(x != -104) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua4
    * Funcao: Faz o carro andar a rua 4
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua4() throws InterruptedException {
        while(x != -168) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento4
    * Funcao: Faz o carro passar o cruzamento 4
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento4() throws InterruptedException {
        while(x != -196) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua3
    * Funcao: Faz o carro andar a rua 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua3() throws InterruptedException {
        while(x != -260) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento3
    * Funcao: Faz o carro passar o cruzamento 3
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento3() throws InterruptedException {
        while(x != -286) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua2
    * Funcao: Faz o carro andar a rua 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua2() throws InterruptedException {
        while(x != -350) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento2
    * Funcao: Faz o carro passar o cruzamento 2
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento2() throws InterruptedException {
        while(x != -376) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua1
    * Funcao: Faz o carro andar a rua 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua1() throws InterruptedException {
        while(x != -440) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento1
    * Funcao: Faz o carro passar o cruzamento 1
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento1() throws InterruptedException {
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

    /* ***************************************************************
    * Metodo: andarRua1B
    * Funcao: Faz o carro andar a rua 1B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua1B() throws InterruptedException {
        while(y != -92) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento7
    * Funcao: Faz o carro passar o cruzamento 7
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento7() throws InterruptedException {
        while(y != -66) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua2B
    * Funcao: Faz o carro andar a rua 2B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua2B() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento13
    * Funcao: Faz o carro passar o cruzamento 13
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento13() throws InterruptedException {
        while(y != 12) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        carro.setRotate(0);

        while(x != -440) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua11
    * Funcao: Faz o carro andar a rua 11
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua11() throws InterruptedException {
        while(x != -376) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento14
    * Funcao: Faz o carro passar o cruzamento 14
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento14() throws InterruptedException {
        while(x != -350) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua12
    * Funcao: Faz o carro andar a rua 12
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua12() throws InterruptedException {
        while(x != -286) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento15
    * Funcao: Faz o carro passar o cruzamento 15
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento15() throws InterruptedException {
        while(x != -260) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua13
    * Funcao: Faz o carro andar a rua 13
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua13() throws InterruptedException {
        while(x != -196) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento16
    * Funcao: Faz o carro passar o cruzamento 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento16() throws InterruptedException {
        while(x != -170) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua14
    * Funcao: Faz o carro andar a rua 14
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua14() throws InterruptedException {
        while(x != -106) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento17
    * Funcao: Faz o carro passar o cruzamento 17
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento17() throws InterruptedException {
        while(x != -80) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua15
    * Funcao: Faz o carro andar a rua 15
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua15() throws InterruptedException {
        while(x != -16) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento18
    * Funcao: Faz o carro passar o cruzamento 18
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento18() throws InterruptedException {
        while(x != 0) {
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
