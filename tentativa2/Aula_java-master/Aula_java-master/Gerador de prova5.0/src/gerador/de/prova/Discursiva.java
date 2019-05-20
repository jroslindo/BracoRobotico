/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador.de.prova;

/**
 *
 * @author joao note
 */
public class Discursiva extends Questao{
    private String criteriosCorrecao;

    /**
     * @return the criteriosCorrecao
     */
    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }

    /**
     * @param criteriosCorrecao the criteriosCorrecao to set
     */
    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }

    public String retornaQuestao() {
     int i;
     String auxiliar = new String ();
     
        //for (i=0; i<; i++){
            //i++;
            //auxiliar+= i+ ") "; 
            //i--;
            auxiliar+= this.getPergunta() + "  Peso: " + this.getPeso() + "\n\nCritério de avaliação: " + this.getCriteriosCorrecao() + "\n\n";
        //}
        auxiliar +=("\n");   
        return auxiliar;
    }
    
    
}
