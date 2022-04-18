/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 30/03/2022
* Ultima alteracao.: 03/04/2022
* Nome.............: Controller Produtor/Consumidor
* Funcao...........: Classe que controla a tela da simulacao
*************************************************************** */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import Model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProdutorConsumidorController implements Initializable {
    // Threads do produtor e consumidores
    Produtor produtor;
    Consumidor1 consumidor1;
    Consumidor2 consumidor2;
    Consumidor3 consumidor3;

    // Variavel que controla o inicio, pause e retomada da simulacao: 0 para a iniciacao do programa, 1 para o pause e 2 para a retomada
    private int estadoDeExcecucao = 0; 

    // Variaveis de controle da velocidade das threads
    private int velocidadeProdutor, velocidadeConsumidor;

    // variavel para controlar quantos consumidores há no programa
    private int numeroDeConsumidores;

    // Declaracao dos controles da tela
    @FXML
    private Button ButtonIniciar;

    @FXML
    private ImageView ImageLivro1;

    @FXML
    private ImageView ImageLivro2;

    @FXML
    private ImageView ImageLivro3;

    @FXML
    private ImageView ImageLivro4;

    @FXML
    private ImageView voltarImage;

    @FXML
    private ImageView ImageLeitor1;

    @FXML
    private ImageView ImageLeitor2;

    @FXML
    private ImageView ImageLeitor3;

    @FXML
    private ImageView ImageConsumidorConsumiu1;

    @FXML
    private ImageView ImageConsumidorConsumiu2;

    @FXML
    private ImageView ImageConsumidorConsumiu3;

    @FXML
    private ImageView ImageProdutorProduziu;

    @FXML
    private Slider SliderConsumidor;

    @FXML
    private Slider SliderProdutor;

    @FXML
    private RadioButton radioButtonNumeroConsumidores1;

    @FXML
    private RadioButton radioButtonNumeroConsumidores2;

    @FXML
    private RadioButton radioButtonNumeroConsumidores3;

    /* ***************************************************************
    * Metodo: voltarAomenu
    * Funcao: Trocar a tela da simulacao para o menu inicial 
    * Parametros: Um event que simboliza o clique do mouse no botao de voltar
    * Retorno: Void
    *************************************************************** */
    @FXML
    void voltarAoMenu(MouseEvent event) {
        Principal.trocarTela("Inicial");
    }

    /* ***************************************************************
    * Metodo: start
    * Funcao: Iniciar a simulacao
    * Parametros: Um event que simboliza o clique do mouse no botao de iniciar
    * Retorno: Void
    *************************************************************** */
    @FXML
    public void start(ActionEvent event) {
        /* Dado um numero de consumidores, sera feito um switch na variavel desse numero, caso seja 1 consumidor, sera chamada apenas a primeira thread,
        caso sejam 2 consumidores, seram chamados 2 threads, por fim, caso sejam 3 consumidores, seram chamadas todas as tres threads. Dito isso, para cada
        situacao sobre o numero de consumidores, se abrirar um switch para a variavel do estado de execucao do programa (iniciado pela primeira vez, 
        pausado ouretomado) para que possa haver a pausa do programa*/
        switch(numeroDeConsumidores) {
            case 1: { // Apenas 1 consumidor
                switch(estadoDeExcecucao) {
                    case 0: { // Simulacao iniciando pela primeira vez
                        // Atribuicao do produtor e do unico consumidor
                        produtor = new Produtor(velocidadeProdutor, 15);
                        consumidor1 = new Consumidor1(velocidadeConsumidor);
        
                        // Inicializacao dos semaforos a serem utilizados
                        Semaphore mutex = new Semaphore(1);
                        Semaphore cheio = new Semaphore(0);
                        Semaphore vazio = new Semaphore(4);

                        // Passagem dos semaforos e elementos graficos do programa para a classe estatica buffer
                        Buffer buffer = new Buffer(mutex, cheio, vazio, ImageLivro1, ImageLivro2, ImageLivro3, ImageLivro4, 
                        ImageProdutorProduziu, ImageConsumidorConsumiu1, ImageConsumidorConsumiu2, ImageConsumidorConsumiu3);
        
                        // Inicilizacao das threads
                        produtor.start();
                        consumidor1.start();
        
                        break;
                    }
                    case 1: { // Simulacao pausada
                        // Suspensao das threads
                        produtor.suspend();
                        consumidor1.suspend();

                        estadoDeExcecucao = 2; // Muda o estado para que a simulacao pode ir para o estado de retomada
        
                        break;
                    }
                    case 2: { // Simulacao retomada
                        // Retomada das threads
                        produtor.resume();
                        consumidor1.resume();
        
                        break;
                    }
                } // Fim do switch do estado de execucao do programa
                
                break;
            }
            case 2: { // 2 consumidores
                switch(estadoDeExcecucao) {
                    case 0: { // Simulacao iniciando pela primeira vez
                        // Atribuicao do produtor e dos dois consumidores
                        produtor = new Produtor(velocidadeProdutor, 15);
                        consumidor1 = new Consumidor1(velocidadeConsumidor);
                        consumidor2 = new Consumidor2(velocidadeConsumidor);
        
                        // Inicializacao dos semaforos a serem utilizados
                        Semaphore mutex = new Semaphore(1);
                        Semaphore cheio = new Semaphore(0);
                        Semaphore vazio = new Semaphore(4);

                        // Passagem dos semaforos e elementos graficos do programa para a classe estatica buffer                        
                        Buffer buffer = new Buffer(mutex, cheio, vazio, ImageLivro1, ImageLivro2, ImageLivro3, ImageLivro4, 
                        ImageProdutorProduziu, ImageConsumidorConsumiu1, ImageConsumidorConsumiu2, ImageConsumidorConsumiu3);
        
                        // Inicilizacao das threads
                        produtor.start();
                        consumidor1.start();
                        consumidor2.start();
        
                        break;
                    }
                    case 1: { // Simulacao pausada
                        // Suspensao das threads
                        produtor.suspend();
                        consumidor1.suspend();
                        consumidor2.suspend();

                        estadoDeExcecucao = 2; // Muda o estado para que a simulacao pode ir para o estado de retomada
        
                        break;
                    }
                    case 2: { // Simulacao retomada
                        // Retomada das threads
                        produtor.resume();
                        consumidor1.resume();
                        consumidor2.resume();
        
                        break;
                    }
                } // Fim do switch do estado de execucao do programa

                break;
            }
            case 3: { // 3 consumidores
                switch(estadoDeExcecucao) {
                    case 0: { // Simulacao iniciando pela primeira vez
                        // Atribuicao do produtor e dos tres consumidores
                        produtor = new Produtor(velocidadeProdutor, 15);
                        consumidor1 = new Consumidor1(velocidadeConsumidor);
                        consumidor2 = new Consumidor2(velocidadeConsumidor);
                        consumidor3 = new Consumidor3(velocidadeConsumidor);
        
                        // Inicializacao dos semaforos a serem utilizados
                        Semaphore mutex = new Semaphore(1);
                        Semaphore cheio = new Semaphore(0);
                        Semaphore vazio = new Semaphore(4);

                        // Passagem dos semaforos e elementos graficos do programa para a classe estatica buffer
                        Buffer buffer = new Buffer(mutex, cheio, vazio, ImageLivro1, ImageLivro2, ImageLivro3, ImageLivro4, 
                        ImageProdutorProduziu, ImageConsumidorConsumiu1, ImageConsumidorConsumiu2, ImageConsumidorConsumiu3);
        
                        // Inicilizacao das threads
                        produtor.start();
                        consumidor1.start();
                        consumidor2.start();
                        consumidor3.start();
        
                        break;
                    }
                    case 1: { // Simulacao pausada
                        // Suspensao das threads
                        produtor.suspend();
                        consumidor1.suspend();
                        consumidor2.suspend();
                        consumidor3.suspend();

                        estadoDeExcecucao = 2; // Muda o estado para que a simulacao pode ir para o estado de retomada
        
                        break;
                    }
                    case 2: { // Simulacao retomada
                        // Retomada das threads
                        produtor.resume();
                        consumidor1.resume();
                        consumidor2.resume();
                        consumidor3.resume();
        
                        break;
                    }
                } // Fim do switch do estado de execucao do programa

                break;
            }
        } // Fim do switch do numero de consumidores
    }

    /* ***************************************************************
    * Metodo: pause
    * Funcao: Pause a simulacao
    * Parametros: Um event que simboliza o clique do mouse no botao de pausar
    * Retorno: Void
    *************************************************************** */
    @FXML
    public void pause(ActionEvent event) {
        estadoDeExcecucao = 1; // Seta o estado de execucao para pausado
        start(event); // Chama o metodo start para que as threads de fato pausem
    }

    /* ***************************************************************
    * Metodo: setNumeroConsumidores
    * Funcao: Modificar o numero de consumidores que tera na simulacao
    * Parametros: Um event que simboliza o clique no radio button indicador do numero de consumidores
    * Retorno: Void
    *************************************************************** */
    @FXML
    void setNumeroConsumidores(ActionEvent event) {
        /* Aqui teremos um if para saber qual radio button chamou a funcao, caso tenha sido o radio button 1, o numero de consumidores
        sera setado para 1 e os elementos graficos do consumidor 2 e 3 irao ficar invisiveis, caso tenha sido o radio button 2, o numero
        de consumidores sera setado para 2 e o elento grafico do consumidor 2 ficara invisivel enquanto que o elemento grafico do 
        consumidor 3 ficara invisivel, por fim, caso tenha sido o radio button 3, os elementos graficos de todos os consumidores ficarao
        visiveis */
        if(radioButtonNumeroConsumidores1.isSelected()) {
            numeroDeConsumidores = 1; // Seta o valor do numero de consumidores

            // Modificacao dos elementos graficos
            ImageConsumidorConsumiu2.setVisible(false);
            ImageConsumidorConsumiu3.setVisible(false);
            ImageLeitor2.setVisible(false);
            ImageLeitor3.setVisible(false);
        } else if(radioButtonNumeroConsumidores2.isSelected()) {
            numeroDeConsumidores = 2; // Seta o valor do numero de consumidores

            // Modificacao dos elementos graficos
            ImageConsumidorConsumiu3.setVisible(false);
            ImageConsumidorConsumiu2.setVisible(true);
            ImageLeitor3.setVisible(false);
            ImageLeitor2.setVisible(true);
        } else if(radioButtonNumeroConsumidores3.isSelected()) {
            numeroDeConsumidores = 3; // Seta o valor do numero de consumidores

            // Modificacao dos elementos graficos
            ImageConsumidorConsumiu3.setVisible(true);
            ImageConsumidorConsumiu2.setVisible(true);
            ImageLeitor3.setVisible(true);
            ImageLeitor2.setVisible(true);
        }
    }

    /* ***************************************************************
    * Metodo: initialize
    * Funcao: observar o valor dos sliders de velocidade e iinicializacao de alguns valores
    * Parametros: Valores do javafx
    * Retorno: Void
    *************************************************************** */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Valores padrao para a velocidade das threads
        velocidadeConsumidor = 2000;
        velocidadeProdutor = 2000;

        // Valor padrao para o numero de consumidores
        numeroDeConsumidores = 1; 

        // Elementos graficos do consumidor 2 e 3, por padrao, vem invisiveis
        ImageConsumidorConsumiu2.setVisible(false);
        ImageConsumidorConsumiu3.setVisible(false);
        ImageLeitor2.setVisible(false);
        ImageLeitor3.setVisible(false); 

        // Listener que ira pegar o valor do slider do produtor e guardar na variavel a ser utilizada no programa
        SliderProdutor.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeProdutor = (int) SliderProdutor.getValue();
            }
        });        

        // Listener que ira pegar o valor do slider do produtor e guardar na variavel a ser utilizada no programa
        SliderConsumidor.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                velocidadeConsumidor = (int) SliderConsumidor.getValue();
            }
        });
    }
}
