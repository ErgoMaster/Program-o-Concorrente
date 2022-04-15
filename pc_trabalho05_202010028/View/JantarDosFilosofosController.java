package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import Model.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class JantarDosFilosofosController implements Initializable {
    private int duracaoPensamento;
    private int duracaoRefeicao; 

    @FXML private ImageView Garfo0Image;
    @FXML private ImageView Garfo1Image;
    @FXML private ImageView Garfo2Image;
    @FXML private ImageView Garfo3Image;
    @FXML private ImageView Garfo4Image;

    @FXML private ImageView EstadoFilosofo0;
    @FXML private ImageView EstadoFilosofo1;
    @FXML private ImageView EstadoFilosofo2;
    @FXML private ImageView EstadoFilosofo3;
    @FXML private ImageView EstadoFilosofo4;

    @FXML private Slider SliderVelocidadePensamento;
    @FXML private Slider SliderVelocidadeRefeicao;
    
    @FXML private Button StartButton;

    @FXML
    void start(ActionEvent event) {
        Mesa mesa = new Mesa(Garfo0Image, Garfo1Image, Garfo2Image, Garfo3Image, Garfo4Image,
        EstadoFilosofo0, EstadoFilosofo1, EstadoFilosofo2, EstadoFilosofo3, EstadoFilosofo4);

        FilosofoThread0 filosofo0 = new FilosofoThread0(duracaoPensamento, duracaoRefeicao);
        FilosofoThread1 filosofo1 = new FilosofoThread1(duracaoPensamento, duracaoRefeicao);
        FilosofoThread2 filosofo2 = new FilosofoThread2(duracaoPensamento, duracaoRefeicao);
        FilosofoThread3 filosofo3 = new FilosofoThread3(duracaoPensamento, duracaoRefeicao);
        FilosofoThread4 filosofo4 = new FilosofoThread4(duracaoPensamento, duracaoRefeicao); 

        filosofo0.start();
        filosofo1.start();
        filosofo2.start();
        filosofo3.start();
        filosofo4.start();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        duracaoPensamento = 2000;
        duracaoRefeicao = 2000;
        
        SliderVelocidadePensamento.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                duracaoPensamento = (int) SliderVelocidadePensamento.getValue();
            }
        });        

        SliderVelocidadeRefeicao.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                duracaoRefeicao = (int) SliderVelocidadeRefeicao.getValue();
            }
        });
    }
}