/*
 * File:   comunicacao.c
 * Author: Gustavo Copini Decol
 *
 * Created on 27 de Maio de 2019, 09:02
 */


#include <xc.h>
#include <stdio.h>
#pragma FOSC = HS
#pragma WDTE = OFF 
#pragma PWRTE = OFF
#pragma BOREN = ON
#pragma LVP = OFF
#pragma CPD = OFF
#pragma WRT = OFF 
#pragma CP = OFF 
#define _XTAL_FREQ 16000000
#define PASSO PORTDbits.RD0
#define MS1 PORTDbits.RD1
#define MS2 PORTDbits.RD2
#define MS3 PORTDbits.RD3
#define DIRECAO PORTDbits.RD5

int valorRes[2];
unsigned int x;
int contador=0;
int vai = 0;

char UART_Init(const long int baudrate)
{

  x = (_XTAL_FREQ - baudrate*64)/(baudrate*64);   //SPBRG for Low Baud Rate
  if(x>255)                                       //If High Baud Rage Required
  {
    x = (_XTAL_FREQ - baudrate*16)/(baudrate*16); //SPBRG for High Baud Rate
    BRGH = 1;                                     //Setting High Baud Rate
  }
 if(x<256)
  {
    SPBRG = x;                                    //Writing SPBRG Register
    SYNC = 0;                                     //Setting Asynchronous Mode, ie UART
    SPEN = 1;                                     //Enables Serial Port
    TRISC7 = 1;                                   //As Prescribed in Datasheet
    TRISC6 = 1;                                   //As Prescribed in Datasheet
    CREN = 1;                                     //Enables Continuous Reception
    TXEN = 1;                                     //Enables Transmission
    return 1;                                     //Returns 1 to indicate Successful Completion
  }
  return 0;                                       //Returns 0 to indicate UART initialization failed
}

char UART_Data_Ready()
{
  return RCIF;
}

char UART_Read()
{
    int retorno=9;
  while(!RCIF);
  retorno = RCREG;
  
  if (RCREG == '1'){
      retorno = 1;
  }
  
  if (RCREG == '2'){
      retorno = 2;
  }
  
  if (RCREG == '3'){
      retorno = 3;
  }
  
  if (RCREG == '4'){
      retorno = 4;
  }
  
  if (RCREG == '5'){
      retorno = 5;
  }
  
  if (RCREG == '6'){
      retorno = 6;
  }
  
  if (RCREG == '7'){
      retorno = 7;
  }
  
  if (RCREG == '8'){
      retorno = 8;
  }
  
  if (RCREG == '9'){
      retorno = 9;
  }
  if (RCREG == '0'){
      retorno = 0;
  }
  
  if (RCREG == '-'){
      retorno = 10;
  }
  
  return retorno;
}

void faz_a_coisa (){
    int valor = UART_Read();
    
    if(contador == 0){
        if (valor == 10)
            DIRECAO = 0;
        else
            DIRECAO=1;
        contador ++;
    }else if(contador == 1){
        valorRes[0] = valor*10;
        contador++;       
    }else if(contador == 2){
        valorRes[0] += valor;
        contador=0;   
        vai=1;
    }
    
    /*else if(contador == 3){
        if (DIRECAO == 1){
            valorRes[0] *= -1 ;
            DIRECAO = 0;
        }
        if (valor == 10)
            DIRECAO=1;
        else
            DIRECAO=0;        
        contador++; //2 em 1, finaliza o dado 1 e ja pega o sinal do proximo      
    }else if(contador == 4){
        valorRes[1] = valor*10;
        contador++;       
    }else if(contador == 5){
        valorRes[1] += valor;
        contador=0;       
    }*/
}

void __interrupt() tratamento (void){
    if(RCIF){   
        RCIF=0;
        faz_a_coisa();
        
    }
   
}

void geraPasso(void){
    PASSO = 1;
    __delay_us(250);
    PASSO = 0;
    __delay_us(250);
}

void main(void) {
    //CONFIGURAÇÕES GERAIS DO PIC, portas:
    TRISB = 0x00;//
    TRISCbits.TRISC7 = 1;
    TRISCbits.TRISC6 = 1;
    TRISCbits.TRISC0 = 0;
    PORTCbits.RC0 = 0;
    TRISD = 0x00;
    ADCON1 = 0x0F;
    UART_Init(9600);
    //CONFIGURANDO INTERRUPÇÃO
    INTCONbits.PEIE = 1;        //Habilita interrupção de periféricos
    PIE1bits.RCIE = 1;          //Chave individual do módulo receptor
    INTCONbits.GIE = 1;			//Chave geral de interrupção
    TRISB = 0x00;
    TRISD = 0x00;
    ADCON1 = 0x0F;
    
    //CONFIGURAÇAO VALORRES[2] TEM OS DADOS DA SERIAL, APARTIR DAQUI, FAZER O CONTROLE DO BRACO
    
    MS1 = 0;
    MS2 = 0;
    MS3 = 0;
    //Parametro de direção
    /*
     0-> Anti-Horário
     1-> Horário
    */
    DIRECAO = 0;
    PASSO = 0;
    //Variaveis de Programa
    int steps=valorRes[0];
    /*    for(int i = 0;i<steps;i++){
            geraPasso();
        }*/

        
    
   
    SLEEP();
    
    while(1){
        if(vai == 1){
            steps= 40;
            for(int i = 0;i<steps;i++){
                geraPasso();
            }
            vai =0;
        }
    
    };
    
    
    
    
    /*
    Q1 = 1;
    Q2 = 1;
    Q3 = 1;
    Q4 = 1;    
    while(1){
        
        PORTD = numeros[valorRes[1]%10];
        
        Q4 = 0;
        __delay_ms(5);
        Q4 = 1;
        
        PORTD = numeros[valorRes[1]/10];
        
        Q3 = 0;
        __delay_ms(5);
        Q3 = 1;
    }
    return;*/
}
