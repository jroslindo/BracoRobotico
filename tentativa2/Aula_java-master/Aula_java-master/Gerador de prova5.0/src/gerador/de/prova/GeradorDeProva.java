/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador.de.prova;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author 6182909
 */
public class GeradorDeProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nDiscursiva, nobjetiva;

        Prova p1 = new Prova("Fisica");

        p1.setData("15/08/2017");
        p1.setLocal("Itajai - Lab 4");

        System.out.println("Digite o nome da disciplina");
        p1.setNomeDaDisciplina(s.nextLine());

        System.out.println("Digite o Peso da prova");
        p1.setPeso(s.nextInt());
        s.nextLine();

        System.out.println("Digite o local da prova");
        p1.setLocal(s.nextLine());

        System.out.println("Digite a data da prova");
        p1.setData(s.nextLine());

        while (true) {
            System.out.print("\nQual o tipo de questão que deseja inserir?");
            System.out.print("\n-O para Objetiva \n-D para Discursiva \n-X para sair\n ");
            String decisao = s.nextLine();

            if (decisao.equalsIgnoreCase("X")) {
                break;
            } else if (decisao.equalsIgnoreCase("D")) {
                Discursiva questoesD = new Discursiva();
                System.out.println("Pergunta da questão: ");
                questoesD.setPergunta(s.nextLine());

                System.out.println("Peso: ");
                questoesD.setPeso(Integer.parseInt(s.nextLine()));

                System.out.println("Criterio de avaliação");
                questoesD.setCriteriosCorrecao(s.nextLine());

                p1.getListaQuestoes().add(questoesD);
            } else if (decisao.equalsIgnoreCase("O")) {
                Objetiva questoesO = new Objetiva();
                String[] auxiliar = new String[5];

                System.out.println("Pergunta da questão: ");
                questoesO.setPergunta(s.nextLine());

                System.out.println("Peso: ");
                questoesO.setPeso(Integer.parseInt(s.nextLine()));

                System.out.print("A) ");
                auxiliar[0] = s.nextLine();

                System.out.print("B) ");
                auxiliar[1] = s.nextLine();

                System.out.print("C) ");
                auxiliar[2] = s.nextLine();

                System.out.print("D) ");
                auxiliar[3] = s.nextLine();

                System.out.print("E) ");
                auxiliar[4] = s.nextLine();

                questoesO.setOpcoes(auxiliar);

                System.out.println("Questão correta");
                questoesO.setRespostaCorreta(Integer.parseInt(s.nextLine()));

                p1.getListaQuestoes().add(questoesO);

            }

        }

        System.out.println("\n\n" + p1.obtemProvaImpressao());

        

        try {
            PrintWriter pw = new PrintWriter("Documento.docx");
            pw.println(p1.obtemProvaImpressao());          
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println("Não foi possivel abrir ou criar o arquivo");
        }

    }

}
