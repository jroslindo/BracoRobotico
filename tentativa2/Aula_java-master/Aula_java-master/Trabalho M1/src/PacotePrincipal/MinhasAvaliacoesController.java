/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacotePrincipal;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author João
 */
public class MinhasAvaliacoesController extends InterfaceUsuario {

    public MinhasAvaliacoesController() {
        super("Minhas Avaliacoes.fxml");
    }
    
    
    @FXML 
    TableView<Avaliacao> tabelaid;
    @FXML
    TableColumn<Avaliacao,String> nomeid;
    @FXML
    TableColumn<Avaliacao,String> disciplinaid;
    @FXML
    TableColumn<Avaliacao,String> mediaid;
    @FXML
    TableColumn<Avaliacao,String> pesoid;
    @FXML
    TableColumn<Avaliacao,String> minhaNotaid;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { //func atualizarcriada la embaixo
        MinhasAvaliacoesController.this.atualizar();
    }    
    
    @FXML
    public void vaiParaNovaAvaliação (ActionEvent evento){        
        AdicionarNovaAvaliacaoController proximaTela = new AdicionarNovaAvaliacaoController();     // troca de tela simples    
        GerenciadorJanela.obterInstancia().abreJanela(proximaTela);
    }
    
    @FXML
    public void vaiParaInformarNota (ActionEvent evento){ // passa os parametros de auto preenchimento
        int posi = tabelaid.getSelectionModel().getSelectedItem().getIdentificadorNoArquivo();           
        InformarNotaController proximaTela = new InformarNotaController();
        proximaTela.nome=tabelaid.getSelectionModel().getSelectedItem().getNome();
        proximaTela.Disciplina=tabelaid.getSelectionModel().getSelectedItem().getDisciplina();
        proximaTela.media=tabelaid.getSelectionModel().getSelectedItem().getMedia();
        proximaTela.index=posi;
        proximaTela.nota=tabelaid.getSelectionModel().getSelectedItem().getNota();
        GerenciadorJanela.obterInstancia().abreJanela(proximaTela);
    }
    
    @FXML
    public void voltar (ActionEvent evento){  // voltar
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    public void atualizar (){ // o atualizador da tabela
        ArrayList <Avaliacao> arrayDeAvaliacoes = Avaliacao.obterListaAvaliacoes();        
        ObservableList<Avaliacao> Colecao = FXCollections.observableArrayList(); // recebe por parametros
        
        int i=0;
        while (i<arrayDeAvaliacoes.size()){
            Colecao.add(arrayDeAvaliacoes.get(i));//da add na collection
            i++;
        }
        
        
        nomeid.setCellValueFactory(new PropertyValueFactory<Avaliacao,String> ("nome"));
        disciplinaid.setCellValueFactory(new PropertyValueFactory<Avaliacao,String> ("disciplina"));
        pesoid.setCellValueFactory(new PropertyValueFactory<Avaliacao,String> ("peso"));
        mediaid.setCellValueFactory(new PropertyValueFactory<Avaliacao,String> ("media"));
        minhaNotaid.setCellValueFactory(new PropertyValueFactory<Avaliacao,String> ("nota"));
        
        
        tabelaid.setItems(Colecao);
    }
    
}
