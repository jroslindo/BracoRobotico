/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacotePrincipal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author João
 */
public class AdicionarNovaAvaliacaoController extends InterfaceUsuario {

    public AdicionarNovaAvaliacaoController() {
        super("Adicionar nova avaliacao.fxml");
    }
    ObservableList<String> ListaDeDisciplinas = FXCollections.observableArrayList("ÉTICA EM INFORMÁTICA", "MATEMÁTICA COMPUTACIONAL",
            "ALGORITMOS E PROGRAMAÇÃO", "ÁLGEBRA", "INTRODUÇÃO AO CÁLCULO", "INICIAÇÃO TÉCNICO-CIENTÍFICA",
            "INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO", "INTRODUÇÃO À FÍSICA", "CÁLCULO", "ALGORITMOS E PROGRAMAÇÃO II",
            "CIRCUITOS DIGITAIS", "DESENHO TÉCNICO", "FÍSICA GERAL", "ÁLGEBRA", "CÁLCULO II", "ESTRUTURAS DE DADOS",
            "PROGRAMAÇÃO ORIENTADA A OBJETOS", "ARQUITETURA DE COMPUTADORES", "FÍSICA III", "QUÍMICA",
            "ARQUITETURA DE COMPUTADORES II", "PROGRAMAÇÃO ORIENTADA A OBJETOS II", "CÁLCULO III", "ANÁLISE DE CIRCUITOS ELÉTRICOS",
            "QUÍMICA II", "ÓTICA E FÍSICA PARA SEMICONDUTORES", "RESISTÊNCIA DOS MATERIAIS", "BANCO DE DADOS",
            "SISTEMAS OPERACIONAIS", "MATEMÁTICA APLICADA À ENGENHARIA", "ENGENHARIA DE SOFTWARE", "PROBABILIDADE E ESTATÍSTICA",
            "ELETRÔNICA BÁSICA", "INTERFACE HUMANO - COMPUTADOR", "ENGENHARIA DE SOFTWARE II", "REDES DE COMPUTADORES",
            "CÁLCULO NUMERICO", "LINGUAGENS FORMAIS", "ELETRÔNICA APLICADA", "ANÁLISE E CONTROLE DE PROCESSOS",
            "ENGENHARIA ECONÔMICA", "REDES DE COMPUTADORES II", "GRAFOS", "CONTROLE LÓGICO DE SISTEMAS", "MICROCONTROLADORES",
            "PROJETO DE SISTEMAS DIGITAIS", "INTELIGÊNCIA ARTIFICIAL", "TRABALHO TÉC.-CIENTÍF.DE CONCLUSÃO DE CURSO",
            "PROJETO DE SISTEMAS EMBARCADOS", "SISTEMAS EM TEMPO REAL", "COMUNICAÇÃO DIGITAL", "PROCESSADOR DIGITAL DE SINAIS",
            "SISTEMAS ROBÓTICOS", "SIMULAÇÃO DISCRETA", "GERÊNCIA DE PROJETOS", "TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO",
            "TÓPICOS ESPECIAIS EM HARDWARE", "TRABALHO TÉC-CIENTÍF. DE CONCLUSÃO DE CURSO II",
            "ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA", "TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE",
            "TRABALHO TÉC-CIENTÍFICO DE CONCLUSÃO DE CURSO III", "SISTEMAS DISTRIBUÍDOS");
    ObservableList<String> ListaMs = FXCollections.observableArrayList("M1", "M2", "M3");
    /**
     * Initializes the controller class.
     */

    @FXML
    private ComboBox ComboDisciplina;
    @FXML
    private ComboBox ComboMs;
    @FXML
    private TextField textNome;
    @FXML
    private TextField textPeso;

    public MinhasAvaliacoesController referencia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboDisciplina.setItems(ListaDeDisciplinas);
        ComboMs.setItems(ListaMs);
    }

    @FXML
    public void voltar(ActionEvent evento) {
        GerenciadorJanela.obterInstancia().voltar();
    }

    @FXML
    public void salvar(ActionEvent evento) {

        if (textNome.getText().equals("") || textPeso.getText().equals("") || ComboDisciplina.getValue() == null || ComboMs.getValue() == null) {
            JOptionPane.showMessageDialog(null,"Porfavor preencha todos os campos");
        } else {
            Avaliacao salvada = new Avaliacao();

            salvada.setNome(textNome.getText());
            salvada.setPeso(Double.parseDouble(textPeso.getText()));
            salvada.setDisciplina((String) ComboDisciplina.getValue());
            salvada.setMedia(((String) ComboMs.getValue()));
            salvada.salvar();
            salvada.atualizar();
        }

    }
}
