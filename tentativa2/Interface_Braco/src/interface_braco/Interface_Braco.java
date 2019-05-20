/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_braco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Razagorus
 */
public class Interface_Braco extends Application {
    
    @Override
    public void start(Stage primaryStage)  {   
        Janela_PrincipalController primeiraTela = new Janela_PrincipalController();
        GerenciadorJanela.obterInstancia().inicializaPalco(primaryStage, primeiraTela);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
