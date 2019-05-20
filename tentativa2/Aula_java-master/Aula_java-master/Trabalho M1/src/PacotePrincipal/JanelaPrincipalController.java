/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacotePrincipal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author João
 */
public class JanelaPrincipalController extends InterfaceUsuario {
    
    @FXML
    private Label label;

    public JanelaPrincipalController() {
        super("JanelaPrincipal.fxml");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void VaiParaMinhasAvaliacoes (ActionEvent evento){
        MinhasAvaliacoesController proximaTela = new MinhasAvaliacoesController();
        GerenciadorJanela.obterInstancia().abreJanela(proximaTela);
    }
    
    public void vaiParaRelatorio (ActionEvent evento){
        RelatorioController proximaTela = new RelatorioController();
        GerenciadorJanela.obterInstancia().abreJanela(proximaTela);
    }
    
}
