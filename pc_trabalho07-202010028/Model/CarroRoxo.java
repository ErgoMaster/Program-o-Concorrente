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
                passarCruzamento3();
                andarRua2();
                passarCruzamento2();
                andarRua6B();
                passarCruzamento8();
                andarRua7B();
                passarCruzamento14();
                andarRua8B();
                passarCruzamento20();
                andarRua9B();
                passarCruzamento26();
                andarRua10B();
                passarCruzamento32();
                andarRua27();
                passarCruzamento33();
                andarRua28();
                passarCruzamento34();
                andarRua20B();
                passarCruzamento28();
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
        while(y != -66) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento22
    * Funcao: Faz o carro passar o cruzamento 22
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento22() throws InterruptedException {
        while(y != -92) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua18B
    * Funcao: Faz o carro andar a rua 18B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua18B() throws InterruptedException {
        while(y != -156) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento16
    * Funcao: Faz o carro passar o cruzamento 16
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento16() throws InterruptedException {
        while(y != -182) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua17B
    * Funcao: Faz o carro andar a rua 17B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua17B() throws InterruptedException {
        while(y != -246) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento10
    * Funcao: Faz o carro passar o cruzamento 10
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento10() throws InterruptedException {
        while(y != -272) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua16B
    * Funcao: Faz o carro andar a rua 16B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua16B() throws InterruptedException {
        while(y != -336) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento4
    * Funcao: Faz o carro passar o cruzamento 4
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento4() throws InterruptedException {
        while(y != -350) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }

        carro.setRotate(0);

        while(x != -16) {
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
        while(x != -80) {
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
        while(x != -106) {
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
        while(x != -170) {
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
        while(x != -182) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x--; 
        }

        carro.setRotate(90);

        while(y != -334) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua6B
    * Funcao: Faz o carro andar a rua 6B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua6B() throws InterruptedException {
        while(y != -270) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento8
    * Funcao: Faz o carro passar o cruzamento 8
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento8() throws InterruptedException {
        while(y != -244) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua7B
    * Funcao: Faz o carro andar a rua 7B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua7B() throws InterruptedException {
        while(y != -180) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento14
    * Funcao: Faz o carro passar o cruzamento 
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento14() throws InterruptedException {
        while(y != -154) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua8B
    * Funcao: Faz o carro andar a rua 8B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua8B() throws InterruptedException {
        while(y != -90) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento20
    * Funcao: Faz o carro passar o cruzamento 20
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento20() throws InterruptedException {
        while(y != -64) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua9B
    * Funcao: Faz o carro andar a rua 9B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua9B() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento26
    * Funcao: Faz o carro passar o cruzamento 26
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento26() throws InterruptedException {
        while(y != 26) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua10B
    * Funcao: Faz o carro andar a rua 10B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua10B() throws InterruptedException {
        while(y != 92) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento32
    * Funcao: Faz o carro passar o cruzamento 32
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento32() throws InterruptedException {
        while(y != 104) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y++; 
        }

        carro.setRotate(0);

        while(x != -166) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua27
    * Funcao: Faz o carro andar a rua 27
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua27() throws InterruptedException {
        while(x != -102) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento33
    * Funcao: Faz o carro passar o cruzamento 33
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento33() throws InterruptedException {
        while(x != -76) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua28
    * Funcao: Faz o carro andar a rua 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua28() throws InterruptedException {
        while(x != -12) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento34
    * Funcao: Faz o carro passar o cruzamento 34
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento34() throws InterruptedException {
        while(x != 0) {
            Thread.sleep(velocidade); 

            final double CONST = x;
            Platform.runLater( () -> carro.setX(CONST)); 

            x++; 
        }

        carro.setRotate(90);

        while(y != 90) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: andarRua20B
    * Funcao: Faz o carro andar a rua 20B
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void andarRua20B() throws InterruptedException {
        while(y != 26) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }

    /* ***************************************************************
    * Metodo: passarCruzamento28
    * Funcao: Faz o carro passar o cruzamento 28
    * Parametros: Void
    * Retorno: Void
    *************************************************************** */
    private void passarCruzamento28() throws InterruptedException {
        while(y != 0) {
            Thread.sleep(velocidade); 

            final double CONST = y;
            Platform.runLater( () -> carro.setY(CONST)); 

            y--; 
        }
    }
}
