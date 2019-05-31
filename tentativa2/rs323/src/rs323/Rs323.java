/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs323;

import javax.comm.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Razagorus
 */
public class Rs323 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            //System.out.println(System.getProperty("java.library.path"));
            CommPortIdentifier idPorta = CommPortIdentifier.getPortIdentifier("COM1");
            
            SerialPort portaSerial = (SerialPort) idPorta.open("PORTAPIC", 1000);
            portaSerial.setSerialPortParams(9600, portaSerial.DATABITS_8, portaSerial.STOPBITS_1, portaSerial.PARITY_NONE);
         
            
            
            try {
                OutputStream saida = portaSerial.getOutputStream();
                saida.write(50);
                Thread.sleep(100);
                saida.flush();
                System.out.println("finalizou tudo");

            } catch (IOException ioe) {
                System.out.println("Não foi possivel abrir/enviar_comando na porta serial");
                System.out.println("Erro! STATUS: " + ioe);
            } catch (InterruptedException ie) {
                System.out.println("Problema com as Threads");
                System.out.println("Erro: Status: " + ie);
            }

        } catch (NoSuchPortException ex) {
            Logger.getLogger(Rs323.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO 1");
        } catch (UnsupportedCommOperationException uscoe) {
            System.err.println("Configuração dos parametros da porta não suportada!");
        } catch (PortInUseException ex) {
            Logger.getLogger(Rs323.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRO 2");
        }
        System.out.println("COMPLETOU");

       
    }

}
