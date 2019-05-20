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
public class Objetiva extends Questao {
    private String[] opcoes = new String[5];
    private int respostaCorreta;

    /**
     * @return the opcoes
     */
    public String[] getOpcoes() {
        return opcoes;
    }

    /**
     * @param opcoes the opcoes to set
     */
    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    /**
     * @return the respostaCorreta
     */
    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    /**
     * @param respostaCorreta the respostaCorreta to set
     */
    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    @Override
    public String retornaQuestao() {
        //for (i=0; i<nobjetiva; i++){
            //i+= ndiscursiva;
            //auxiliar+= i+ ") "; 
            //i-= ndiscursiva;
        String auxiliar = new String ();
            auxiliar+= this.getPergunta() + "  Peso: " + this.getPeso() + "\n\nA) " + this.getOpcoes()[0]
                    +"\nB) " + this.getOpcoes()[1] + "\nC) " + this.getOpcoes()[2] + "\nD) " + this.getOpcoes()[3]+
                    "\nE) " + this.getOpcoes()[4] + "\n\nResposta Correta " +this.getRespostaCorreta() + "\n\n\n";
        return auxiliar;
    }
    
}
