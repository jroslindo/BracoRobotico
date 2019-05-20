/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacotePrincipal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class RelatorioController extends InterfaceUsuario {

    @FXML
    private ComboBox Comboid;
    /**
     * Initializes the controller class.
     */
    @FXML
    private BarChart<?, ?> graficoid;
    @FXML
    private CategoryAxis xid;
    @FXML
    private NumberAxis yid;

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

    public RelatorioController() {
        super("Relatorio.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Comboid.setItems(ListaDeDisciplinas);  // definindo as opções
    }

    public void voltar(ActionEvent evento) {
        GerenciadorJanela.obterInstancia().voltar();
    }

    @FXML
    public void Mostrar() {
        if (Comboid.getValue() == null) { // verificação
               JOptionPane.showMessageDialog(null,"Porfavor preencha a escolha");
        } else { // lê arquivo e bota no grafico
            ArrayList<String> salva = new ArrayList();
            try {
                FileReader arq = new FileReader("Relatorio.csv");
                BufferedReader lerArq = new BufferedReader(arq);

                String linha = lerArq.readLine();
                while (linha != null) {
                    salva.add(linha);
                    linha = lerArq.readLine();
                }
                arq.close();
            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                        e.getMessage());
            }

            String dado = new String();
            Double m1 = 0.0;
            Double m2 = 0.0;
            Double m3 = 0.0;
            Double pesoTotalM1 = 0.0;
            Double pesoTotalM2 = 0.0;
            Double pesoTotalM3 = 0.0;
            int i = 0;
            while (i < salva.size()) { //motivos para ter feito aki ao invez da função, se eu fizer aki ao ler o arquivo uma vez ele ja tem todos os dados prontos
                String[] separa = salva.get(i).split(",");// se eu chamasse a função ele teria q ler o arquivo 3 vzs para completar os dados, por questao de otimização eu preferi fazer assim

                if (separa[0].equals(Comboid.getValue()) && separa[1].equals("M1")) {
                    m1 += Double.parseDouble(separa[4]) * Double.parseDouble(separa[3]);
                    pesoTotalM1 += Double.parseDouble(separa[3]);
                }

                if (separa[0].equals(Comboid.getValue()) && separa[1].equals("M2")) {
                    m2 += Double.parseDouble(separa[4]) * Double.parseDouble(separa[3]);
                    pesoTotalM2 += Double.parseDouble(separa[3]);
                }

                if (separa[0].equals(Comboid.getValue()) && separa[1].equals("M3")) {
                    m3 += Double.parseDouble(separa[4]) * Double.parseDouble(separa[3]);
                    pesoTotalM3 += Double.parseDouble(separa[3]);
                }
                i++;
            }
            if (pesoTotalM1 != 0) {
                m1 = m1 / pesoTotalM1;
            }
            if (pesoTotalM2 != 0) {
                m2 = m2 / pesoTotalM2;
            }
            if (pesoTotalM3 != 0) {
                m3 = m3 / pesoTotalM3;
            }

            Double mf = Avaliacao.calculaMediaDaDisciplina(m1, m2, m3);
            XYChart.Series setTira = new XYChart.Series();
            setTira.getData().add(new XYChart.Data("M1", m1)); // funções do grafico
            setTira.getData().add(new XYChart.Data("M2", m2));
            setTira.getData().add(new XYChart.Data("M3", m3));
            setTira.getData().add(new XYChart.Data("MF", mf));
            graficoid.getData().addAll(setTira);

        }
    }

}
