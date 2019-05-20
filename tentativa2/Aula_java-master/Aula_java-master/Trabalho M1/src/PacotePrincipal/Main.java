/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacotePrincipal;

import java.io.PrintWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author João
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage)  {   
        JanelaPrincipalController primeiraTela = new JanelaPrincipalController();
        GerenciadorJanela.obterInstancia().inicializaPalco(primaryStage, primeiraTela);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
