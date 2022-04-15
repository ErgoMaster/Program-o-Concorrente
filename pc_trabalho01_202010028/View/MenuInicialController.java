/* ***************************************************************
* Autor............: Gabriel Uzel Fonseca
* Matricula........: 202010028
* Inicio...........: 27/01/2022
* Ultima alteracao.: 01/02/2022
* Nome.............: Controller da tela principal
* Funcao...........: Adicionar funcionalidades aos elementos gráficos do programa
*************************************************************** */

package View;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.lang.Math;
import java.text.DecimalFormat;

public class MenuInicialController {
    @FXML private TextField AlturaTextField;
    @FXML private TextField PesoTextField;
    @FXML private TextField IMCTextField;
    @FXML private TextField ClassificacaoTextField;
    @FXML private TextField ErroTextField;

    @FXML private Button CalcularButton;

    /* ***************************************************************
    * Metodo: calcular
    * Funcao: Retorna ao usuario as informacoes sobre seu imc e sua classificacao 
    * Parametros: Recebe um ActionEvent relacionado ao apertar de um botao
    * Retorno: Void
    *************************************************************** */
    @FXML
    public void calcular(ActionEvent event) throws IOException {
        try {
            // Limpar a mensagem de erro para que ela so apareca quando de fato o usuario errar
            ErroTextField.clear();

            // Recebe dos textfield as informacoes da altura e peso do usuario
            double altura = Integer.parseInt(AlturaTextField.getText());
            double peso = Double.parseDouble(PesoTextField.getText());

            verificarValidade(altura, peso); // Etapa de verificacao do valor dado, para que o usuario nao informe absurdos

            /* Definicao do imc do paciente (que eh calculado nessa forma: 
            divide-se o peso do usuario pela sua altura elevada ao quadrado) 
            e de sua classificacao (vai de magreza a obesidade grave dependendo 
            do valor do imc)*/
            double imc = peso / Math.pow((altura / 100), 2);
            String classificacao = atribuirClassificacao(imc);      
            
            // Faz a atribuicao dos resultados a outros textfield e os mostra ao usuario
            IMCTextField.setText(String.valueOf(new DecimalFormat(".##").format(imc)));
            ClassificacaoTextField.setText(classificacao);
        } catch(NumberFormatException e) {
            /* Tratamento de excessao para caso o usuario forneca um tipo errado de informacao 
            (por exemplo: na caixa de texto de peso o usuario digitar uma cadeia de caracteres) */
            ErroTextField.setText("Informações digitadas estão incorretas");
        } catch(ValorInvalidoException e) {
            /* Tratamento de excecao para caso o usuario forneca um valor absurdo de informacao
            (por exemplo: na caixa de texto de peso o usuario digitar o valor de uma tonelada) */
            ErroTextField.setText("Valores informados são inválidos");
        }
    }

    /* ***************************************************************
    * Metodo: verificarValidade
    * Funcao: Verificar se o usuario forneceu valores absurdos para o programa
    * Parametros: Recebe um inteiro indicando a altura e um double que indica o peso
    * Retorno: Joga uma excecao caso os parametros sejam absurdos
    *************************************************************** */
    public void verificarValidade(double altura, double peso) throws ValorInvalidoException {
        /* Aqui se faz uma verificacao dos valores que o usuario forneceu: ambos os valores 
        de altura e peso nao podem ser negativos e, a altura nao pode passar de 3 metros 
        (300 cm) e o peso nao pode passar de 200 kg */
        if(altura < 0 || altura > 300 || peso < 0 || peso > 200) {
            throw new ValorInvalidoException(); // Lancamento de uma excecao personalizada 
        }
    }

    /* ***************************************************************
    * Metodo: atribuirClassificacao
    * Funcao: Dado o valor de imc do usuario, atribui a ele uma determinada interprestacao deste imc
    * Parametros: Recebe um double que indica o imc 
    * Retorno: Retorna uma String que representa essa interpretacao do imc do usuario
    *************************************************************** */
    public String atribuirClassificacao(double imc) {
        String resultado; // Variavel para guardar o valor da classificacao

        /* Dado o imc do usuario, o mesmo recebe uma classificacao vinda da seguinte tabela: 
        IMC menor que 18.5: Magreza
        IMC entre 18.5 e 24.9: Peso normal
        IMC entre 25 e 29.9: Sobrepeso
        IMC entre 30 e 39.9: Obesidade
        IMC maior que 40: Obesidade grave */
        if(imc <= 18.5) { resultado = "MAGREZA"; } 
        else if(imc > 18.5 && imc < 25) { resultado = "NORMAL"; } 
        else if(imc >= 25 && imc < 30) { resultado = "SOBREPESO"; } 
        else if(imc >= 30 && imc < 40) { resultado = "OBESIDADE"; } 
        else { resultado = "OBESIDADE GRAVE"; }
   
        return resultado; // Retorna o resultado da classificacao do imc
    }
}