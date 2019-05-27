/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tentativa3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Razagorus
 */
public class Janela1Controller implements Initializable {

    @FXML
    private Line linha1;
    @FXML
    private Line linha2;
    @FXML
    private Circle cotovelo;
    @FXML
    private Circle mao;
    @FXML
    private Label cotoveloT;
    @FXML
    private Label maoT;
    @FXML
    private ComboBox grau_move;

    private int andou_cotovelo = 0;
    private int andou_mao = 75;

    @FXML
    private void MaoEsquerda(ActionEvent Evento) {
        System.out.println("You clicked me!");
        int valor = 1;
        if (grau_move.getValue().toString() == "1.8") {
            valor = 1;
        }
        if (grau_move.getValue().toString() == "3.6") {
            valor = 5;
        }
        if (grau_move.getValue().toString() == "7.2") {
            valor = 10;
        }
        for (int j = 0; j < valor; j++) {
            if (andou_mao > 0) {
                andou_mao--;
                //ARRUMANDO LINHA 2
                linha2.setEndX(linha2.getEndX() - 0.5);
                linha2.setEndY(linha2.getEndY() - 1.00);
                //arrumando a MAO
                mao.setCenterX(mao.getCenterX() - 0.5);
                mao.setCenterY(mao.getCenterY() - 1.00);
                //ARRUMANDO MAO T
                maoT.setLayoutX(maoT.getLayoutX() - 0.5);
                maoT.setLayoutY(maoT.getLayoutY() - 1.00);
            }
        }
    }
    
   @FXML
    private void MaoDireita(ActionEvent Evento) {
        System.out.println("You clicked me!");
        int valor = 1;
        if (grau_move.getValue().toString() == "1.8") {
            valor = 1;
        }
        if (grau_move.getValue().toString() == "3.6") {
            valor = 5;
        }
        if (grau_move.getValue().toString() == "7.2") {
            valor = 10;
        }
        for (int j = 0; j < valor; j++) {
            if (andou_mao < 75) {
                andou_mao++;
                //ARRUMANDO LINHA 2
                linha2.setEndX(linha2.getEndX() + 0.5);
                linha2.setEndY(linha2.getEndY() + 1.00);
                //arrumando a MAO
                mao.setCenterX(mao.getCenterX() + 0.5);
                mao.setCenterY(mao.getCenterY() + 1.00);
                //ARRUMANDO MAO T
                maoT.setLayoutX(maoT.getLayoutX() + 0.5);
                maoT.setLayoutY(maoT.getLayoutY() + 1.00);
            }
        }
    }

    @FXML
    private void CotoveloEsquerda(ActionEvent Evento) {
        System.out.println("You clicked me!");
        int valor = 1;
        if (grau_move.getValue().toString() == "1.8") {
            valor = 1;
        }
        if (grau_move.getValue().toString() == "3.6") {
            valor = 5;
        }
        if (grau_move.getValue().toString() == "7.2") {
            valor = 10;
        }
        for (int j = 0; j < valor; j++) {
            if (andou_cotovelo <= 10 && andou_cotovelo > -75) {
                andou_cotovelo--;
                //ARRUMANDO LINHA 1
                linha1.setEndX(linha1.getEndX() - 0.75);
                linha1.setEndY(linha1.getEndY() + 0.30);
                //arrumando O COTOVELO
                cotovelo.setCenterX(cotovelo.getCenterX() - 0.75);
                cotovelo.setCenterY(cotovelo.getCenterY() + 0.30);
                //ARRUMANDO COTOVELO T
                cotoveloT.setLayoutX(cotoveloT.getLayoutX() - 0.75);
                cotoveloT.setLayoutY(cotoveloT.getLayoutY() + 0.30);
                
                //MAO
                //ARRUMANDO LINHA 2
                linha2.setEndX(linha2.getEndX() - 0.75);
                linha2.setEndY(linha2.getEndY() + 0.30);
                linha2.setStartX(linha2.getStartX() - 0.75);
                linha2.setStartY(linha2.getStartY() + 0.30);
                //arrumando a Mao
                mao.setCenterX(mao.getCenterX() - 0.75);
                mao.setCenterY(mao.getCenterY() + 0.30);
                //ARRUMANDO MAO T
                maoT.setLayoutX(maoT.getLayoutX() - 0.75);
                maoT.setLayoutY(maoT.getLayoutY() + 0.30);
            }
        }
    }
    
    @FXML
    private void CotoveloDireita(ActionEvent Evento) {
        
        int valor = 1;
        if (grau_move.getValue().toString() == "1.8") {
            valor = 1;
        }
        if (grau_move.getValue().toString() == "3.6") {
            valor = 5;
        }
        if (grau_move.getValue().toString() == "7.2") {
            valor = 10;
        }
        for (int j = 0; j < valor; j++) {
            if (andou_cotovelo <= 0 && andou_cotovelo > -85) {
                System.out.println("Ombro Direita!");
                andou_cotovelo++;
                
                //ARRUMANDO LINHA 1
                linha1.setEndX(linha1.getEndX() + 0.75);
                linha1.setEndY(linha1.getEndY() - 0.30);
                //arrumando O COTOVELO
                cotovelo.setCenterX(cotovelo.getCenterX() + 0.75);
                cotovelo.setCenterY(cotovelo.getCenterY() - 0.30);
                //ARRUMANDO COTOVELO T
                cotoveloT.setLayoutX(cotoveloT.getLayoutX() + 0.75);
                cotoveloT.setLayoutY(cotoveloT.getLayoutY() - 0.30);
                
                //MAO
                //ARRUMANDO LINHA 2
                linha2.setEndX(linha2.getEndX() + 0.75);
                linha2.setEndY(linha2.getEndY() - 0.30);
                linha2.setStartX(linha2.getStartX() + 0.75);
                linha2.setStartY(linha2.getStartY() - 0.30);
                //arrumando a Mao
                mao.setCenterX(mao.getCenterX() + 0.75);
                mao.setCenterY(mao.getCenterY() - 0.30);
                //ARRUMANDO MAO T
                maoT.setLayoutX(maoT.getLayoutX() + 0.75);
                maoT.setLayoutY(maoT.getLayoutY() - 0.30);
            }
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ARRUMANDO LINHA 1
        linha2.setEndX(linha2.getEndX() + 150);
        linha2.setEndY(linha2.getEndY() + 100);
        //arrumando a MAO
        mao.setCenterX(mao.getCenterX() + 150);
        mao.setCenterY(mao.getCenterY() + 100);
        //ARRUMANDO MAO T
        maoT.setLayoutX(maoT.getLayoutX() + 150);
        maoT.setLayoutY(maoT.getLayoutY() + 100);

        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "1.8",
                        "3.6",
                        "7.2"
                );
        grau_move.setItems(options);

    }

}
