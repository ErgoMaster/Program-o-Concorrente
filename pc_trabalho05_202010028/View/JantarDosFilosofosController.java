package View;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JantarDosFilosofosController {
    @FXML private ImageView Garfo0Image;
    @FXML private ImageView Garfo1Image;
    @FXML private ImageView Garfo2Image;
    @FXML private ImageView Garfo3Image;
    @FXML private ImageView Garfo4Image;
    
    @FXML private Button StartButton;

    @FXML
    void start(ActionEvent event) {
        Image garfoOcupadoImage = new Image(getClass().getResourceAsStream("Img/IMGGarfoOcupado.png"));
        Mesa mesa = new Mesa(Garfo0Image, Garfo1Image, Garfo2Image, Garfo3Image, Garfo4Image, garfoOcupadoImage);

        FilosofoThread0 filosofo1 = new FilosofoThread0(2000, 2000);
        FilosofoThread1 filosofo2 = new FilosofoThread1(2000, 2000);
        FilosofoThread2 filosofo3 = new FilosofoThread2(2000, 2000);
        FilosofoThread3 filosofo4 = new FilosofoThread3(2000, 2000);
        FilosofoThread4 filosofo5 = new FilosofoThread4(2000, 2000);

        filosofo1.start();
        filosofo2.start();
        filosofo3.start();
        filosofo4.start();
        filosofo5.start();
    }
}