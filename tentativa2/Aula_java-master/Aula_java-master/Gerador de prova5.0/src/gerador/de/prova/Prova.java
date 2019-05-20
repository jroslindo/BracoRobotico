/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador.de.prova;

import java.util.ArrayList;

/**
 *
 * @author 6182909
 */
public class Prova {
    
    private String nomeDaDisciplina;
    private int peso;
    private String local;
    private String data;
    private ArrayList<Questao> listaQuestoes;
   
    
    public Prova(String nome){
        this.listaQuestoes = new ArrayList();
    }
         
    public String obtemDetalhes(){
        
        String retorno = "\t\t\t"+this.getNomeDaDisciplina()+"\n\n"+"Nome: _________________________________ "+
                         "\tData: "+ this.getData() +"\nLocal: " + this.getLocal() + "\t\t\t\tPeso: " + this.getPeso();
                         
        return retorno;
       
    }

    //public String obtemProvaImpressao(Discursiva qdiscursiva[], Objetiva qobjetiva[], int ndiscursiva, int nobjetiva){
    public String obtemProvaImpressao(){
        String auxiliar=obtemDetalhes()+"\n\n";
        
        for(int i = 0; i<this.getListaQuestoes().size(); i++){
            auxiliar += "\n" + (i+1) + ")" + this.listaQuestoes.get(i).retornaQuestao();
        }
        
        
        
        return auxiliar;        
    }
    public String getNomeDaDisciplina() {
        return nomeDaDisciplina;
    }

    public void setNomeDaDisciplina(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    } 

    /**
     * @return the listaQuestoes
     */
    public ArrayList<Questao> getListaQuestoes() {
        return listaQuestoes;
    }

    /**
     * @param listaQuestoes the listaQuestoes to set
     */
    public void setListaQuestoes(ArrayList<Questao> listaQuestoes) {
        this.listaQuestoes = listaQuestoes;
    }

   
}
