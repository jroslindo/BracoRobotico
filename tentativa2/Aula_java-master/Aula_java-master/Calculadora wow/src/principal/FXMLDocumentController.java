/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author João
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label Resultado;

    @FXML
    private Button Calcular;

    @FXML
    private TextField Valor;

    @FXML
    private CheckBox Check1;
    @FXML
    private CheckBox Check2;
    @FXML
    private CheckBox Check3;
    @FXML
    private CheckBox Check4;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        Boolean C1 = Check1.isSelected();
        Boolean C2 = Check2.isSelected();
        Boolean C3 = Check3.isSelected();
        Boolean C4 = Check4.isSelected();

        int i = Integer.parseInt(Valor.getText());
        int resultado = 0;
        if (C1) {
            if (i >= 98) {
                resultado++;
            }
            if (i >= 100) {
                resultado++;
            }
            if (i >= 102) {
                resultado++;
            }
            if (i >= 104) {
                resultado++;
            }
            if (i >= 106) {
                resultado++;
            }
            if (i >= 108) {
                resultado++;
            }
            if (i >= 110) {
                resultado++;
            }

            Resultado.setText("" + resultado);
        } else {
            if ((C2 && C3) || (C2 && C4) || (C3 && C4)) {
                Resultado.setText("X");
            } else {
                if (i >= 15) {
                    resultado++;
                }
                if (i >= 30) {
                    resultado++;
                }
                if (i >= 45) {
                    resultado++;
                }
                if (i >= 60) {
                    resultado++;
                }
                if (i >= 75) {
                    resultado++;
                }
                if (i >= 90) {
                    resultado++;
                }
                if (i >= 100) {
                    resultado++;
                }

                Resultado.setText("" + resultado);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
