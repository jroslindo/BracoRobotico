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
#define Q1 PORTBbits.RB4
#define Q2 PORTBbits.RB5
#define Q3 PORTBbits.RB6
#define Q4 PORTBbits.RB7

int valorRes=5;
unsigned int x;

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
    int retorno;
  while(!RCIF);
  retorno = RCREG;
  
  if (RCREG == '1'){
      retorno = 1;
  }
  
  
  return retorno;
}

void __interrupt() tratamento (void){
   
    if (INTCONbits.INT0IF == 1){         //Tratamento interrupção comunicação serial
       PORTCbits.RC0 = 1;
       valorRes = UART_Read();   
       INTCONbits.INT0IF = 0;
   }    
   
}

char numeros[]      = { 0b10111111, // 0 Valores para o display
                        0b10000110, // 1 
                        0b11011011, // 2 
                        0b11001111, // 3 
                        0b11100110, // 4
                        0b11101101, // 5 
                        0b11111101, // 6 
                        0b10000111, // 7
                        0b11111111, // 8
                        0b11100111};// 9

void configuracao ()
{
   //CONFIGURAÇÕES GERAIS DO PIC, portas:
    TRISB = 0x00;//
    TRISCbits.TRISC7 = 1;
    TRISCbits.TRISC6 = 1;
    TRISCbits.TRISC0 = 0;
    PORTCbits.RC0 = 0;
    TRISD = 0x00;
    ADCON1 = 0x0F;
    Q1 = 1;
    Q2 = 1;
    Q3 = 1;
    Q4 = 1;    
    UART_Init(9600);
    //CONFIGURANDO INTERRUPÇÃO
    //INTCONbits.PEIE = 1;        //Habilita interrupção de periféricos
    //PIE1bits.RCIE = 1;          //Chave individual do módulo receptor
    //INTCONbits.GIE = 1;			//Chave geral de interrupção
}

//unsigned char recebeUART(void){
//    TRISCbits.TRISC7 = 1;
//    TRISCbits.TRISC6 = 1;
    
//    SPBRG = 207;
//    TXSTA = 0b00100100;
//    RCSTA = 0b10010000;
//    BAUDCON = 0b00000000;
    
//    while(!PIR1bits.RCIF){
//        if(RCSTAbits.FERR){
//            RCSTAbits.CREN = 0;
//            return -1;
//        }else{
//            PORTCbits.RC0 = 0;
//            return RCREG;
//        }
//    }
//}

void main(void) {
    
    configuracao();
    TRISB = 0x00;
    TRISD = 0x00;
    ADCON1 = 0x0F;
    Q1 = 1;
    Q2 = 1;
    Q3 = 1;
    Q4 = 1;    
    while(1){
        if(UART_Data_Ready())
            PORTD = numeros[UART_Read()];
            //PORTB = UART_Read();
        //valorRes = UART_Read();
        //PORTD = numeros[valorRes];
        Q4 = 0;
        __delay_ms(5);
        Q4 = 1;
	
        //printf("valor lido: %d\r",valorRes);
    }
    return;
}
