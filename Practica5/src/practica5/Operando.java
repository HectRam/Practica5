/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Hector
 */
public class Operando extends Practica5{
    
    
    
    String[] Direccion(String Operando,String dir, int lin,String moddir,String codop,int BanOrg,String ContLoc,String FCC){
        String[] Resultado = new String[] {"null","null","null","0000"};
        String  b=".err",Mdir="null", Res="null";
        String Byte="null";
        int BanContLoc=0;
        int x=0,y=0,z=0; 
        boolean banRel=false;
        try{
        File f =new File(dir+b);
        FileWriter fw=new FileWriter(f,true);
        BufferedWriter error=new BufferedWriter(fw);
        
           // System.out.println("Codop antes: "+codop);
         //  System.out.println("Operando mod antes: "+Operando);
         
      if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7].*")||Operando.matches("^\\%.*")||Operando.matches("^\\#.*")||Operando.matches("^[0-9].*")||Operando.matches("^[a-zA-Z].*")||Operando.matches("^\\[.*\\]$")||Operando.matches("^\\-.*")||Operando.matches("^\\,.*")||codop.equals("FCC")){
          /*   
          
        */  
         codop=codop.toUpperCase();
          //System.out.println("Codop mod: "+codop);
         // System.out.println("A2: "+z);
        // System.out.println("Operando mod Despues: "+Operando);
         
         ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               /////////////////////////////////////////////////////ContLoc
              //////////////////////////////////////////////////////////ORG
               
              if(codop.equals("ORG")){
                  int ORG=0; 
                  if(BanOrg!=1){
                   System.out.println("ORG: "+ORG+"ContLoc"+ContLoc);
                  if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$")){
                      //Entra Hexadecimal
                      if(Operando.matches("^\\$.*")){
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           ORG=Integer.parseInt(Hexa,16);
                          if(ORG<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              ContLoc=Integer.toHexString(ORG).toUpperCase(); 
                              BanOrg=1;
                              Mdir="DTV";
                              }
                             }//termina Hexadecimal
                            //Empieza Octal
                      if(Operando.matches("^\\@.*")){
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           ORG=Integer.parseInt(Hexa,8);
                          if(ORG<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              ContLoc=Integer.toHexString(ORG).toUpperCase(); 
                              BanOrg=1;
                              Mdir="DTV";
                              }
                             }//termina Octal
                            //Empieza Binario
                       if(Operando.matches("^\\%.*")){
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           ORG=Integer.parseInt(Hexa,2);
                          if(ORG<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              ContLoc=Integer.toHexString(ORG).toUpperCase(); 
                              BanOrg=1;
                              }
                             }//termina Binario
                               }else{//sin base
                                  if(Operando.matches("^[0-9]*")){
                                   ORG=Integer.parseInt(Operando);
                                   if(ORG<=65535){
                                   ContLoc=Integer.toHexString(ORG).toUpperCase();
                                  Mdir="DTV";
                                     BanOrg=1; 
                                   }
                                  }
                              else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+ORG+")");
                               error.newLine();
                                  }
                          }
              }
                  BanContLoc=1;
              }//Termina ORG
              /////////////////////EQU
              if(codop.equals("EQU")){
                  int EQU=0;
                  
                  if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$")){
                      
                  //Entra Hexa
                  if(Operando.matches("^\\$.*")){
                      
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           EQU=Integer.parseInt(Hexa,16);
                          if(EQU<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              ContLoc=Integer.toHexString(EQU).toUpperCase(); 
                              Mdir="DTV";
                              }
                             }//termina hexadecimal
                  
                  //Inicia Octal
                  if(Operando.matches("^\\@.*")){
                      
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           EQU=Integer.parseInt(Hexa,8);
                          if(EQU<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              ContLoc=Integer.toHexString(EQU).toUpperCase(); 
                              Mdir="DTV";
                              }
                             }//Termina Octal
                  //Inicia Binario
                   if(Operando.matches("^\\%.*")){
                      
                      int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           EQU=Integer.parseInt(Hexa,2);
                          if(EQU<=65535){
                               //inserta el valor en Hexadecimal al Contador Logico
                              ContLoc=Integer.toHexString(EQU).toUpperCase(); 
                              Mdir="DTV";
                              }
                             }//Termina Binario
                             }else{//sin base
                                  if(Operando.matches("^[0-9]?[0-9]*")){
                                   EQU=Integer.parseInt(Operando);
                                   if(EQU<=65535){
                                   ContLoc=Integer.toHexString(EQU).toUpperCase();
                                    Mdir="DTV"; 
                                   }
                                  }
                              else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+EQU+")");
                               error.newLine();
                                  }
                          }
                  
                  BanContLoc=1;
              }//Termina EQU
              ////////////////////////Directivas de constantes
              ////////////////////////DW, DB, DC.W, DC.B, FCB, FDB, FCC
              if(codop.equals("DW")||codop.equals("DB")||codop.equals("DC.W")||codop.equals("DC.B")||codop.equals("FCB")||codop.equals("FDB")||codop.equals("FCC"))
              {
                  int DiCons=0;
                  //De un Byte
                  //System.out.println("sin base db fuera"+Operando+"codop: "+codop);
                  if(codop.equals("DB")||codop.equals("DC.B")||codop.equals("FCB"))
                  {
                     // System.out.println("sin base db dentro"+Operando);
                      if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$"))
                      {
                          //entra Hexadecimal
                      if(Operando.matches("^\\$.*"))
                       {
                         int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           DiCons=Integer.parseInt(Hexa,16);
                           if(DiCons<=255&&DiCons>=0){
                               //suma 1 l contloc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+1;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiCons+")");
                               error.newLine();
                           }
                       }//termina Hexadecimal
                      //entra octal
                      if(Operando.matches("^\\@.*"))
                       {
                         int siz=Operando.length();
                        String Oct=Operando.substring(1,siz);
                           DiCons=Integer.parseInt(Oct,8);
                           if(DiCons<=255&&DiCons>=0){
                               //suma 1 l contloc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+1;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiCons+")");
                               error.newLine();
                           }
                       }//termina octal
                      //entra Binario
                      if(Operando.matches("^\\%.*"))
                       {
                         int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           DiCons=Integer.parseInt(Hexa,2);
                           if(DiCons<=255&&DiCons>=0){
                               //suma 1 al contloc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+1;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiCons+")");
                               error.newLine();
                           }
                       }//termina Binario
                      }else{//sin base
                         // System.out.println("sin base db2 "+Operando);
                          if(Operando.matches("^[0-9]?[0-9]*")){
                              
                          DiCons=Integer.parseInt(Operando,10);
                           if(DiCons<=255&&DiCons>=0){
                               //suma 1 al contloc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+1;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiCons+")");
                               error.newLine();
                           }
                          }else{
                               error.write("Linea: "+lin+" Error: "+codop+" no se encontro un valor: "+DiCons);
                               error.newLine();
                                  }
                      }
                  }//termina de un byte
                  //empieza de dos bytes
                  if(codop.equals("DW")||codop.equals("DC.W")||codop.equals("FDB"))
                  {
                      
                      if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$"))
                      {
                          //entra Hexadecimal
                      if(Operando.matches("^\\$.*"))
                       {
                         int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           DiCons=Integer.parseInt(Hexa,16);
                           if(DiCons<=65535&&DiCons>=0){
                               //suma 2 a contloc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+2;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiCons+")");
                               error.newLine();
                           }
                       }//termina Hexadecimal
                      //entra octal
                      if(Operando.matches("^\\@.*"))
                       {
                         int siz=Operando.length();
                        String Oct=Operando.substring(1,siz);
                           DiCons=Integer.parseInt(Oct,8);
                           if(DiCons<=65535&&DiCons>=0){
                               //suma 2 a contloc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+2;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiCons+")");
                               error.newLine();
                           }
                       }//termina octal
                      //entra Binario
                      if(Operando.matches("^\\%.*"))
                       {
                         int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           DiCons=Integer.parseInt(Hexa,2);
                           if(DiCons<=65535&&DiCons>=0){
                               //suma 2 a contloc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+2;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiCons+")");
                               error.newLine();
                           }
                       }//termina Binario
                      }else{//sin base
                          if(Operando.matches("^[0-9]?[0-9]*")){
                          DiCons=Integer.parseInt(Operando,10);
                           if(DiCons<=65535&&DiCons>=0){
                               //suma 2 al contloc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+2;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiCons+")");
                               error.newLine();
                           }
                          }else{
                               error.write("Linea: "+lin+" Error: "+codop+" no se encontro un valor: "+DiCons);
                               error.newLine();
                                  }
                      }
                  }//termina de dos bytes
                  //Entra FCC
                  if(codop.equals("FCC")){
                      int siz=FCC.length();
                      if(siz>0){
                          
                         //int siz=Operando.length();
                        String FCC2=FCC.substring(0,siz-1);
                        //System.out.println("FCC2"+FCC2);
                       // StringTokenizer FCCx = new StringTokenizer(FCC2,"\\\"");
                           //  String FCC3=FCCx.nextToken();
                             Res=FCC2;
                            DiCons =FCC2.length();
                         //   System.out.println("FCC2"+FCC2+"Tam "+DiCons);
                            int cont=Integer.parseInt(ContLoc,16);
                            cont=cont+DiCons;//suma la longitud del operando
                           ContLoc=Integer.toHexString(cont).toUpperCase();
                           Mdir="DTV";
                      }else{
                      error.write("Linea: "+lin+" Error:"+codop+" no cumple con el las especificaciones: "+DiCons);
                      error.newLine();
                      }
  
                  }//Termina FCC
                  
                  BanContLoc=1;
              }//////Terminan directivas constantes
              ////////////////////////////Directivas de reserva de espacio en memoria
              /////////////////////////////DS, DS.B, DS.W, RMB, RMW
              if(codop.equals("DS")||codop.equals("DS.B")||codop.equals("DS.W")||codop.equals("RMB")||codop.equals("RMW")){
                  int DiMem=0;
                  //De un byte
                  if(codop.equals("DS")||codop.equals("DS.B")||codop.equals("RMB")){
                      
                      if(Operando.matches("\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$"))
                      {
                          //entra Hexadecimal
                      if(Operando.matches("^\\$.*"))
                       {
                         int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Hexa,16);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando con ContLoc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+DiMem;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiMem+")");
                               error.newLine();
                           }
                       }//termina Hexadecimal
                      //entra Octal
                      if(Operando.matches("^\\@.*"))
                       {
                         int siz=Operando.length();
                        String Oct=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Oct,8);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando con ContLoc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+DiMem;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiMem+")");
                               error.newLine();
                           }
                       }//entra Binario
                      if(Operando.matches("^\\%.*"))
                       {
                         int siz=Operando.length();
                        String Bin=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Bin,2);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando con ContLoc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+DiMem;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiMem+")");
                               error.newLine();
                           }
                       }
                      }else{//sin base 
                          if(Operando.matches("^[0-9]?[0-9]*")){
                          DiMem=Integer.parseInt(Operando,10);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando con ContLoc
                               int cont=Integer.parseInt(ContLoc,16);
                               cont=cont+DiMem;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiMem+")");
                               error.newLine();
                           }
                          }else{
                               error.write("Linea: "+lin+" Error: "+codop+" no se encontro um valor");
                               error.newLine();
                                  }
                      }
                      
                      
                  }//termina de un Byte
                  //entra de dos Bytes
                  if(codop.equals("DS.W")||codop.equals("RMW")){
                      
                      if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$"))
                      {
                          //entra Hexadecimal
                      if(Operando.matches("^\\$.*"))
                       {
                         int siz=Operando.length();
                        String Hexa=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Hexa,16);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando*2 con ContLoc
                               int cont=Integer.parseInt(ContLoc,16);
                               DiMem=DiMem*2;
                               cont=cont+DiMem;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiMem+")");
                               error.newLine();
                           }
                       }//termina Hexadecimal
                      //entra Octal
                      if(Operando.matches("^\\@.*"))
                       {
                         int siz=Operando.length();
                        String Oct=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Oct,8);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando*2 con ContLoc
                               int cont=Integer.parseInt(ContLoc,16);
                               DiMem=DiMem*2;
                               cont=cont+DiMem;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiMem+")");
                               error.newLine();
                           }
                       }//entra Binario
                      if(Operando.matches("^\\%.*"))
                       {
                         int siz=Operando.length();
                        String Bin=Operando.substring(1,siz);
                           DiMem=Integer.parseInt(Bin,2);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando*2 con ContLoc
                               int cont=Integer.parseInt(ContLoc,16);
                               DiMem=DiMem*2;
                               cont=cont+DiMem;
                               ContLoc=Integer.toHexString(cont).toUpperCase(); 
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiMem+")");
                               error.newLine();
                           }
                       }
                      }else{//sin base 
                          if(Operando.matches("^[0-9]?[0-9]*")){
                          DiMem=Integer.parseInt(Operando,10);
                           if(DiMem<=65535&&DiMem>=0){
                               //suma resultado de operando con ContLoc
                               int cont=Integer.parseInt(ContLoc,16);
                               DiMem=DiMem*2;
                               cont=cont+DiMem;
                               ContLoc=Integer.toHexString(cont).toUpperCase();
                               Mdir="DTV";
                           }else{
                               error.write("Linea: "+lin+" Error:"+codop+" no cumple con el valor requerido (valor actual:"+DiMem+")");
                               error.newLine();
                           }
                          }else{
                               error.write("Linea: "+lin+" Error: "+codop+" no se encontro um valor");
                               error.newLine();
                                  }
                      }
                      
                      
                  }//Termina de dos Bytes
                  BanContLoc=1;
                  
              }//Termina Directivas  de Reserva de espacio de Memoria 
              
              
                                                                   //ContLoc/////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
         
         
         
          //Directo y Extendido
          if(Operando.matches("^\\%[10]*$")&&BanContLoc!=1&&!codop.equals("ORG")||Operando.matches("^\\@[0-7]+")&&BanContLoc!=1&&!codop.equals("ORG")||Operando.matches("^\\$[0-9A-Fa-f]*")&&BanContLoc!=1&&!codop.equals("ORG")||Operando.matches("^[0-9]+")&&BanContLoc!=1&&!codop.equals("ORG"))
          {
          //DIR
              boolean banDir=false;
             int DIR=0;
              ///////////////////////////////////////////////Directo
              if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[-]*[0-7]*")||Operando.matches("^\\%[10]*")){
                  
                  //Hexadecimal
                  if(Operando.matches("^\\$[0-9A-Fa-f]*")){
                      int tam=Operando.length();
                  String dircad=Operando.substring(1,tam);
                  DIR=Integer.parseInt(dircad,16);  
                  if(DIR>=0&&DIR<=255){
                     banDir=true; 
                  Mdir="DIR";
                  
                  }
                  }//termina Hexadecimal
                  //Octal
                  if(Operando.matches("^\\@[-]*[0-7]*")){
                      int tam=Operando.length();
                  String dircad=Operando.substring(1,tam);
                  DIR=Integer.parseInt(dircad,8);  
                  if(DIR>=0&&DIR<=255){ 
                  Mdir="DIR";
                  
                  }
                  banDir=true;
                  }//termina Octal
                  //entra Binario
                  if(Operando.matches("^\\%[10]*")){
                      int tam=Operando.length();
                  String dircad=Operando.substring(1,tam);
                  DIR=Integer.parseInt(dircad,2);  
                  if(DIR>=0&&DIR<=255){
                      banDir=true;
                  Mdir="DIR";
                  }
                  }//termina binario
              }else{
              
                  if(Operando.matches("^[0-9]*$")){
                  int tam=Operando.length();
                  String dircad=Operando.substring(0,tam);
                  DIR=Integer.parseInt(dircad,10);  
                  if(DIR>=0&&DIR<=255){
                   banDir=true;   
                  Mdir="DIR";
                  
                  }
                  }
                  
              }
              
              ///////////////////////////////////////////Extendido
              int EXT=0;
              if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[-]*[0-7]*")||Operando.matches("^\\%[10]*")){
                  
                  //Hexadecimal
                  if(Operando.matches("^\\$[0-9A-Fa-f]*")){
                      int tam=Operando.length();
                  String dircad=Operando.substring(1,tam);
                  EXT=Integer.parseInt(dircad,16);  
                  if(EXT>=-32768&&EXT<=65535&&!banDir==true){
                      
                  Mdir="EXT";
                  }
                  }//termina Hexadecimal
                  //Octal
                  if(Operando.matches("^\\@[-]*[0-7]*")){
                      int tam=Operando.length();
                  String dircad=Operando.substring(1,tam);
                  EXT=Integer.parseInt(dircad,8);  
                  if(EXT>=-32768&&EXT<=65535&&!banDir==true){ 
                  Mdir="EXT";
                  }
                  
                  }//termina Octal
                  //entra Binario
                  if(Operando.matches("^\\%[10]*")){
                      int tam=Operando.length();
                  String dircad=Operando.substring(1,tam);
                  EXT=Integer.parseInt(dircad,2);  
                  if(EXT>=-32768&&EXT<=65535&&!banDir==true){
                     
                  Mdir="EXT";
                  }
                  }//termina binario
              }else{
              
                  if(Operando.matches("^[0-9]*$")){
                  int tam=Operando.length();
                  String dircad=Operando.substring(0,tam);
                  EXT=Integer.parseInt(dircad,10);  
                  if(EXT>=-32768&&EXT<=65535&&!banDir==true){
                     
                  Mdir="EXT";
                  
                  }
                  }
                  
              }
              
              
              
          
          
          }//termina Directo y Extendido
           
          ///////////////////////////////////////////////////Indexados   IDX'S
                              
          if(Operando.matches("^[-]*([0-9a-dA-D])*,[+|-]*([X|x|Y|y|sp|SP|pc|PC])*$")&&BanContLoc!=1||Operando.matches("^[-]*([0-9a-dA-D])*,([X|x|Y|y|sp|SP|pc|PC])*([+|-])*$")&&BanContLoc!=1||Operando.matches("^\\$[0-9A-Fa-f]*,([X|x|Y|y|sp|SP|pc|PC])*[+|-]*$")&&BanContLoc!=1||Operando.matches("^\\$[0-9A-Fa-f]*,([+|-])*([X|x|Y|y|sp|SP|pc|PC])*$")&&BanContLoc!=1||Operando.matches("^\\@[-]*[0-7]*,([+|-])*([X|x|Y|y|sp|SP|pc|PC])*$")&&BanContLoc!=1||Operando.matches("^\\@[-]*[0-7]*,([X|x|Y|y|sp|SP|pc|PC])*[+|-]*$")&&BanContLoc!=1||Operando.matches("^\\%[10]*,([+|-])*([X|x|Y|y|sp|SP|pc|PC])*$")&&BanContLoc!=1||Operando.matches("^\\%[10]*,([X|x|Y|y|sp|SP|pc|PC])*[+|-]*$")&&BanContLoc!=1)
          {
              banRel=true;
              String IDXcad=null;
              
              StringTokenizer IDX=new StringTokenizer(Operando,",");
              
               System.out.println("Operando IDX: "+Operando);
              if(Operando.matches("^\\$[0-9A-Fa-f]*.*")||Operando.matches("^\\@[-]*[0-7]*.*")||Operando.matches("^\\%.*")){
                
                  //Entra Hexadecimal
                  if(Operando.matches("^\\$[0-9A-Fa-f]*.*")){
                      IDXcad =IDX.nextToken();
                      int Hex=IDXcad.length();
                  String IDXcade=IDXcad.substring(1,Hex);
                  // IDXcad =IDX.nextToken();
              boolean IDXB=false;    
             // IDXfirst=IDX.nextToken();
              
              if(Operando.matches("^[aAbBdD],[XxYyspSPpcPC]*")){
                  Mdir="IDXA";//Acumulador
                  IDXB=true;
                  
              }
             
              if(IDXcade.matches("^[-]?[0-9].*")&&IDXB==false){
                  
                  int  IDXint=Integer.parseInt(IDXcade,16);
                  //contienen Decimales
                  
                   // IDX 5Bits
                 if(IDXint>=-16&&IDXint<=15&&IDXB==false||Operando.matches(" ^,([+|-])*([X|x|Y|y|sp|SP|pc|PC])*[+|-]*$")&&IDXB==false){
                     IDXB=true;
                     Mdir="IDX5Bits";
                 }
                 //IDX 9 Bits
                 if(IDXint>=-256&&IDXint<=-17&&IDXB==false||IDXint>=16&&IDXint<=255&&IDXB==false){
                     Mdir="IDX1";
                     IDXB=true;
                 }
                 //IDX 16Bits
                 if(IDXint<=-257&&IDXint>=-32768&&IDXB==false||IDXint>=256&&IDXint<=65535&&IDXB==false){
                     Mdir="IDX2";
                     IDXB=true;
                 }
                 if(Operando.matches("[0-9]*,([+|-])*([X|x|Y|y|sp|SP])*[+|-]*$")&&IDXB==false){
                     
                     Mdir="IDX Pre/Post";
                     //System.out.println("Mdir Pre/Post: "+Mdir);
                 }
                 
                }
                  }//termina Hexadecimal
                  //Entra Octal
                   if(Operando.matches("^\\@[-]*[0-7]*.*")){
                       IDXcad =IDX.nextToken();
                       int val=IDXcad.length();
                   String IDXcade=IDXcad.substring(1,val);
                  // IDXcad =IDX.nextToken();
                
              boolean IDXB=false;    
             // IDXfirst=IDX.nextToken();
              
              if(Operando.matches("^[aAbBdD],[XxYyspSPpcPC]*")){
                  Mdir="IDXA";//Acumulador
                  IDXB=true;
                  
              }
             
              if(IDXcade.matches("^[-]?[0-9].*")&&IDXB==false){
                  banRel=true;
                  int  IDXint=Integer.parseInt(IDXcade,8);
                  //contienen Decimales
                  
                   // IDX 5Bits
                 if(IDXint>=-16&&IDXint<=15&&IDXB==false||Operando.matches(" ^,([+|-])*([X|x|Y|y|sp|SP|pc|PC])*[+|-]*$")&&IDXB==false){
                     IDXB=true;
                     Mdir="IDX5Bits";
                 }
                 //IDX 9 Bits
                 if(IDXint>=-256&&IDXint<=-17&&IDXB==false||IDXint>=16&&IDXint<=255&&IDXB==false){
                     Mdir="IDX1";
                     IDXB=true;
                 }
                 //IDX 16Bits
                 if(IDXint<=-257&&IDXint>=-32768&&IDXB==false||IDXint>=256&&IDXint<=65535&&IDXB==false){
                     Mdir="IDX2";
                     IDXB=true;
                 }
                 if(Operando.matches("[0-9]*,([+|-])*([X|x|Y|y|sp|SP])*[+|-]*$")&&IDXB==false){
                     
                     Mdir="IDX Pre/Post";
                     //System.out.println("Mdir Pre/Post: "+Mdir);
                 }
                 
                }
              }//termina octal
                   //Entra Binario
                if(Operando.matches("^\\%.*")){
                   
                    IDXcad =IDX.nextToken();
                     
                       int val=IDXcad.length();
                       System.out.println("Operando: "+Operando+"Cadena IDX "+IDXcad+"Val: "+val);
                 String  IDXcade=IDXcad.substring(1,val);
                 System.out.println("Operando2: "+IDXcade);
                  // IDXcad =IDX.nextToken();
                  
            boolean IDXB=false;    
             // IDXfirst=IDX.nextToken();
              
              if(Operando.matches("^[aAbBdD],[XxYyspSPpcPC]*")){
                  Mdir="IDXA";//Acumulador
                  IDXB=true;
              }
             
              if(Operando.matches("^\\%.*")&&IDXB==false){
                  banRel=true;
                  System.out.println("Operando: "+Operando+"Cadena IDX "+IDXcade);
                  int  IDXint=Integer.parseInt(IDXcade,2);
                 
                  
                   // IDX 5Bits
                 if(IDXint>=-16&&IDXint<=15&&IDXB==false||Operando.matches(" ^,([+|-])*([X|x|Y|y|sp|SP|pc|PC])*[+|-]*$")&&IDXB==false){
                     IDXB=true;
                     Mdir="IDX5Bits";
                 }
                 //IDX 9 Bits
                 if(IDXint>=-256&&IDXint<=-17&&IDXB==false||IDXint>=16&&IDXint<=255&&IDXB==false){
                     Mdir="IDX1";
                     IDXB=true;
                 }
                 //IDX 16Bits
                 if(IDXint<=-257&&IDXint>=-32768&&IDXB==false||IDXint>=256&&IDXint<=65535&&IDXB==false){
                     Mdir="IDX2";
                     IDXB=true;
                 }
                 if(Operando.matches("[0-9]*,([+|-])*([X|x|Y|y|sp|SP])*[+|-]*$")&&IDXB==false){
                     
                     Mdir="IDX Pre/Post";
                     //System.out.println("Mdir Pre/Post: "+Mdir);
                 }
                 
                }
              }//termina Binario   
              }if(Operando.matches("^[-]*([0-9a-dA-D])*,.*")){//Sin base
                  
                String   IDXcade=IDX.nextToken();
                   System.out.println("Operando: "+Operando+"Cadena IDX "+IDXcade);
            boolean IDXB=false;    
             // IDXfirst=IDX.nextToken();
              
              if(Operando.matches("^[aAbBdD],[XxYyspSPpcPC]*")){
                  Mdir="IDXA";//Acumulador
                  IDXB=true;
                  
              }
             
              if(IDXcade.matches("^[-]?[0-9].*")&&IDXB==false){
                  banRel=true;
                  int  IDXint=Integer.parseInt(IDXcade);
                  //contienen Decimales
                  
                   // IDX 5Bits
                 if(IDXint>=-16&&IDXint<=15&&IDXB==false||Operando.matches(" ^,([+|-])*([X|x|Y|y|sp|SP|pc|PC])*[+|-]*$")&&IDXB==false){
                     IDXB=true;
                     Mdir="IDX5Bits";
                 }
                 //IDX 9 Bits
                 if(IDXint>=-256&&IDXint<=-17&&IDXB==false||IDXint>=16&&IDXint<=255&&IDXB==false){
                     Mdir="IDX1";
                     IDXB=true;
                 }
                 //IDX 16Bits
                 if(IDXint<=-257&&IDXint>=-32768&&IDXB==false||IDXint>=256&&IDXint<=65535&&IDXB==false){
                     Mdir="IDX2";
                     IDXB=true;
                 }
                 if(Operando.matches("[0-9]*,([+|-])*([X|x|Y|y|sp|SP])*[+|-]*$")&&IDXB==false){
                     
                     Mdir="IDX Pre/Post";
                     //System.out.println("Mdir Pre/Post: "+Mdir);
                 }
                 
                }else{
                 
                  if(Operando.matches(",([+|-])*([X|x|Y|y|sp|SP|pc|PC])*[+|-]*$")){
                      Mdir="IDX";
                      
                  }else{
                  error.write("Linea: "+lin+" Error el Operando no cumple los requerimientos para Indexados contiene: "+Operando);
                  error.newLine();
              }
              }
             }//termina sin base
          }//termina IDX
          
          /////////////////////////////////////////////////////////////16 Bits Indirecto [IDX2]
          if(Operando.matches("^\\[[\\%\\$\\@]{0,1}[-0-9]+,[XxYyspSPpcPC]*\\]$")){
              //int Idx2=0;
              int tam=Operando.length();
              String IDX2=Operando.substring(1,tam-1);//-1 quita el corchete final
              StringTokenizer  IDX= new StringTokenizer(IDX2,",");
              //System.out.println("Operando[]: "+Operando);
             // System.out.println("[IDX2] "+IDX2);
              if(IDX2.matches("^\\$[0-9A-Fa-f]*.*")||IDX2.matches("^\\@[-]*[0-7]*.*")||IDX2.matches("^\\%.*")){
                  
                  //Entra Hexadecimal
                  if(IDX2.matches("^\\$[0-9A-Fa-f]*.*")){
                      String Aux=IDX.nextToken();
                    int tam2=Aux.length();
                    String hexIdx=Aux.substring(1,tam2);
                    int hex=Integer.parseInt(hexIdx,16);
                    if(hex<=65535&&-32768<=hex){
                        Mdir="[IDX2]";
                        if(hex>=-32768&&hex<=-1){
                       x = hex;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectohex(z);
                       
                      }
                        
                    }
                    
                  }//Termina Hexadecimal
                    //entra Octal
                  if(IDX2.matches("^\\@[-]*[0-7]*.*")){
                      String Aux=IDX.nextToken();
                      int tam2=Aux.length();
                    String octIdx=Aux.substring(1,tam2);
                    int oct=Integer.parseInt(octIdx,8);
                    if(oct<=65535&&-32768<=oct){
                        Mdir="[IDX2]";
                        if(oct>=-32768&&oct<=-1){
                       x = oct;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectooct(z);
                       
                      }
                        
                    }
                  }//Termina Octal
                  //Inicia Binario
                  if(IDX2.matches("^\\%.*")){
                      String Aux=IDX.nextToken();
                       int tam2=Aux.length();
                    String binIdx=Aux.substring(1,tam2);
                    int bin=Integer.parseInt(binIdx,2);
                    if(bin<=65535&&-32768<=bin){
                        Mdir="[IDX2]";
                        if(bin>=-32768&&bin<=-1){
                       x = bin;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectooct(z);
                       
                      }
                        
                    }
                  }//Termina Binario
              }else{//sin base
          if(Operando.matches("^\\[[-0-9]+,[XxYyspSPpcPC]*\\]$")){
                   String Aux=IDX.nextToken();
                       int tam2=Aux.length();
                       //System.out.println("binIdx "+Aux+" "+tam);
                    String binIdx=Aux.substring(0,tam2);
                    int bin=Integer.parseInt(binIdx);
                    if(bin<=65535&&-32768<=bin){
                        Mdir="[IDX2]";
                        
                    }
          }else{
              error.write("Linea: "+lin+" Error el Operando no cumple los requerimientos para [IDX2] contiene: "+Operando);
              error.newLine();
          }
              
          }
          }
          ////////////////////////////////////////////////////////////Indexado Indirecto de Acumulador
          if(Operando.matches("^\\[([D|d]){1,1},")){
              
              
          if(Operando.matches("\\[([D|d])*,([X|x|Y|y|sp|SP|pc|PC])*\\]")){
              Mdir="[D,IDX]";
              
          }else{
              error.write("Linea: "+lin+" Error el Operando no cumple los requerimientos para [D,IDX] contiene: "+Operando);
              error.newLine();
          }
          }
          
          ////////////////////////////////////////////////////////////Inmediato IMM8, IMM16
          if(Operando.matches("^[#]{1,}.*")&&BanContLoc!=1){
              
              int IMM=0;
              int tam=Operando.length();
              String immcad=Operando.substring(1,tam);
              //con base
             // System.out.println("Entro A imm"+Operando);
              if(immcad.matches("^\\@[-]*[0-7]+")||immcad.matches("^\\%[10]*")||immcad.matches("^\\$[0-9A-Fa-f]*"))
                {
               //empieza octal
               if(immcad.matches("^\\@.*")){     
               immcad=Operando.substring(2,tam);
               IMM =Integer.parseInt(immcad, 8);
              
              if(IMM<=255&&-256<=IMM){
                  //System.out.println("Entro A imm8");
                  if(moddir.equals("INM")){
                  Mdir="IMM8";
                  //return Mdir;
                  if(IMM>=-256&&IMM<=-1){
                       x = IMM;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectooct(z);
                      }
                  }
              }
              else if(IMM<=65535&&-32768<=IMM){
                  //System.out.println("Entro A imm16");
                  if(moddir.equals("INM")){
                  Mdir="IMM16";
                  //return Mdir;
                  if(IMM>=-32768&&IMM<=-1){
                       x = IMM;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectooct(z);
                      }
                  }
              }
                }//termina octal
               //entra binario
              if(immcad.matches("^\\%.*")){     
               immcad=Operando.substring(2,tam);
               IMM =Integer.parseInt(immcad, 2);
              
              if(IMM<=255&&-256<=IMM){
                  //System.out.println("Entro A imm8");
                  if(moddir.equals("INM")){
                  Mdir="IMM8";
                  //return Mdir;
                  if(IMM>=-256&&IMM<=-1){
                       x = IMM;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectobin(z);
                      }
                  }
              }
              else if(IMM<=65535&&-32768<=IMM){
                  //System.out.println("Entro A imm16");
                  if(moddir.equals("INM")){
                  Mdir="IMM16";
                  //return Mdir;
                  if(IMM>=-32768&&IMM<=-1){
                       x = IMM;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectobin(z);
                      }
                  }
              }
                }//termina binario
              //entra hexadecimal 
              if(immcad.matches("^\\$.*")){     
               immcad=Operando.substring(2,tam);
               IMM =Integer.parseInt(immcad, 16);//transforma de hexa a decimal para evaluar 
              //System.out.println("Hexadecimal"+IMM);
              if(IMM<=255&&-256<=IMM){
                  //System.out.println("Entro A imm8");
                  if(moddir.equals("INM")){
                  Mdir="IMM8";
                  //return Mdir;
                  if(IMM>=-256&&IMM<=-1||immcad.matches("^0.*")){
                       x = IMM;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectohex(z);
                      }
                  }
              }
              else if(IMM<=65535&&-32768<=IMM){
                  //System.out.println("Entro A imm16");
                  if(moddir.equals("INM")){
                  Mdir="IMM16";
                  //return Mdir;
                  if(IMM>=-32768&&IMM<=-1||immcad.matches("^0.*")){
                       x = IMM;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectohex(z);
                      }
                  }
              }
                }//termina hexadecimal
          }else{//sin base 
                  
                  
                  if(immcad.matches("^[0-9].*")){
                  IMM =Integer.parseInt(immcad);
                  System.out.println("Entro A imm"+IMM);
                  if(IMM<=255&&-256<=IMM){
                  //System.out.println("Entro A imm8");
                      if(moddir.equals("INM")){
                  Mdir="IMM8";
                  //return Mdir;
                  
                      }
                  }
                  else if(IMM<=65535&&-32768<=IMM){
                   System.out.println("Entro A imm16"+IMM+"moddir "+moddir);
                      if(moddir.equals("INM")){
                  Mdir="IMM16";
                  //return Mdir;
                  
                      }
                  }
              }else{
                      error.write("Linea: "+lin+" Error "+codop+" no cumple los requerimientos contiene: "+Operando);
                                 error.newLine();
                  }
              }
          }//termina Inmediato
          
          /////////////////////////////////////////////////////////////////////Relativo REL8 & REL16
          if(Operando.matches("^[0-9a-zA-Z].*")&&banRel==false&&BanContLoc!=1&&!codop.equals("ORG")||Operando.matches("^\\@[0-7]+")&&banRel==false&&BanContLoc!=1&&!codop.equals("ORG")||Operando.matches("^\\%[10]*$")&&banRel==false&&BanContLoc!=1&&!codop.equals("ORG")||Operando.matches("^\\$[0-9A-Fa-f]*")&&banRel==false&&BanContLoc!=1&&!codop.equals("ORG")){
              int REL=0;
              int tam=Operando.length();
           //  System.out.println("moddir: "+moddir);
              if(Operando.matches("^\\$[0-9A-Fa-f]*")||Operando.matches("^\\@[0-7]+")||Operando.matches("^\\%[10]*$"))
                {
                    //Entra Octal
                    if(Operando.matches("^\\@.*")){
              String relcad=Operando.substring(1,tam);
              REL =Integer.parseInt(relcad, 8);
              if(REL<=255&&REL>=-256){
                  if(codop.matches("^[lL].*")){
                  if(moddir.equals("REL")){
                      Mdir="REL16";
                      
                      if(REL>=-256&&REL<=-1){
                       x = REL;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectooct(z);
                      }
                  }
                  }else{
                    if(moddir.equals("REL")){
                      Mdir="REL8";
                      if(REL>=-256&&REL<=-1){
                       x = REL;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectooct(z);
                      }
                   }
                  }
              }
              else if(codop.matches("^[lL].*")&&REL<=65535&&REL>=-32768){
                   if(moddir.equals("REL")){
                      Mdir="REL16";
                     ;
                      if(REL>=-32768&&REL<=-1){
                       x = REL;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectooct(z);
                      }
                  }
              }
                }//Termina Octal
                    
                  //Empieza Binario
                 if(Operando.matches("^\\%.*")){
              String relcad=Operando.substring(1,tam);
              REL =Integer.parseInt(relcad, 2);
              if(REL<=255&&REL>=-256){
                  if(codop.matches("^[lL].*")){
                  if(moddir.equals("REL")){
                      Mdir="REL16";
                      if(REL>=-256&&REL<=-1){
                       x = REL;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectobin(z);
                      }
                  }
                  }else{
                    if(moddir.equals("REL")){
                      Mdir="REL8";
                      if(REL>=-256&&REL<=-1){
                       x = REL;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectobin(z);
                      }
                   }
                  }
              }
              else if(codop.matches("^[lL].*")&&REL<=65535&&REL>=-32768){
                   if(moddir.equals("REL")){
                      Mdir="REL16";
                      if(REL>=-32768&&REL<=-1){
                       x = REL;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectobin(z);
                      }
                  }
              }
                }//Termina Binario
                 //Empieza Hexadecimal
                 if(Operando.matches("^\\$.*")){
              String relcad=Operando.substring(1,tam);
              REL =Integer.parseInt(relcad, 16);
              if(REL<=255&&REL>=-256){
                  if(codop.matches("^[lL].*")){
                  if(moddir.equals("REL")){
                      Mdir="REL16";
                      if(REL>=-256&&REL<=-1||relcad.matches("^0.*")){
                       x = REL;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectohex(z);
                      }
                  }
                  }else{
                    if(moddir.equals("REL")){
                      Mdir="REL8";
                      if(REL>=-256&&REL<=-1||relcad.matches("^0.*")){
                       x = REL;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectohex(z);
                      }
                   }
                  }
              }
              else if(codop.matches("^[lL].*")&&REL<=65535&&REL>=-32768){
                   if(moddir.equals("REL")){
                      Mdir="REL16";
                      if(REL>=-32768&&REL<=-1||relcad.matches("^0.*")){
                       x = REL;  
                       y = ~x;   
                       z = y + 1;
                       Res=dectohex(z);
                       
                      }
                  }
              }
                }//Termina Hexadecimal
                }else{//sin base
                  if(Operando.matches("^[0-9].*")){
                  REL =Integer.parseInt(Operando, 10);
                  if(REL<=255&&REL>=-256){
                    if(codop.matches("^[lL].*")){
                  if(moddir.equals("REL")){
                      Mdir="REL16";
                      
                  }
                  }else{
                        if(moddir.equals("REL")){
                      Mdir="REL8";
                       
                        }
                  }
              }
              else if(codop.matches("^[lL].*")&&REL<=65535&&REL>=-32768){
                   if(moddir.equals("REL")){
                      Mdir="REL16";
                      
                  }
              }
                  
              }else{
                     if(Operando.matches("^[a-zA-Z][a-zA-Z]*$")&&codop.matches("^[lL].*")){
                         if(moddir.equals("REL")){
                      Mdir="REL16";
                      
                          }
                         }
                     else{
                         if(moddir.equals("REL")){
                      Mdir="REL8";
                          }
                     }
                  }
              }
          }//Termina REL
                        
          if(Mdir=="null"&&BanContLoc!=1&&!codop.equals("ORG")){
          error.write("Linea: "+lin+" Error no se encontro ningun modo de direccionamiento");
          error.newLine();
          }
         /*
          if(Mdir!="null"){
              Byte=Bytes(codop,Mdir);
              }*/
      } /////////////////////Termina validacion de Operando
       else{
          
          error.write("Linea: "+lin+" Error el modo de Direccionamiento no es valido");
          error.newLine();
          
      }
       
          error.close();
          if(Mdir!="null"&&BanContLoc==0){
        ///Calcular bytes
                  String cadby=Bytes(codop,Mdir);
                  int byt=Integer.parseInt(cadby);
                  int cont=Integer.parseInt(ContLoc,16);
                  cont=cont+byt;
                  ContLoc=Integer.toHexString(cont).toUpperCase();
                  ///////////////////////////////////////////////
          }
        }catch(Exception e){
            System.out.println("Hubo un problema en los modos de direccionamiento: "+e);
            
        }
        ContLoc=fillContLoc(ContLoc);
        //System.out.println("Mdir: "+Mdir+"Res op: "+Res);
        Resultado[0]=Mdir;
        Resultado[1]=Res;
        Resultado[2]=Integer.toString(BanOrg);
        Resultado[3]=ContLoc;
       
       System.out.println(" Mdir: "+Resultado[0]+" Res op: "+Resultado[1]+" Ban ORG: "+Resultado[2]+" ContLoc: "+Resultado[3]);
      return Resultado;
    }
    
    public static int hextodec(String hexdecnum)
    {
             int decimal = Integer.parseInt(hexdecnum, 16);
             return decimal;
    }
    
    public static String dectohex(int dec)
    {
        String hex = Integer.toHexString(dec);
        return hex;
    }
    public String dectobin(int dec){
        
        
        String bin = Integer.toBinaryString(dec);
        
        return bin;
    }
    public String dectooct(int dec){
        
        String oct = Integer.toOctalString(dec);
        return oct;
    }
    public String Bytes(String codop, String dir){
                   String Bytes="null";
        
                       String TABOP="TABOP";
                         String mayus,exCod;
                          dir.toUpperCase();
                         try{
                             FileInputStream fsaux = new FileInputStream(TABOP+".asm");
                             DataInputStream dsaux = new DataInputStream(fsaux);
                             BufferedReader  braux = new BufferedReader(new InputStreamReader(dsaux));
                             
                             String linaux;
                             //System.out.println("Tab lin "+linToken);
                             
                             while((linaux = braux.readLine())!= null){
                                 
                                 StringTokenizer aucod = new StringTokenizer(linaux,"|");
                                        mayus=codop;
                                   exCod=aucod.nextToken();
                                 //  System.out.println("Tabop: "+exCod);
                                   
                                   if(exCod.compareTo(mayus.toUpperCase())==0&&mayus!="null"&&mayus!=null&&mayus!=" "){
                                      
                                       
                                       if(codop!="null"&&codop!=null&&codop!=" "){
                                           
                                       
                                   //     System.out.println("Codop comparado "+codop);
                                       
                                       
                                     //  System.out.println("Auxiliar "+linaux);
                                       
                                      String   sioperS=aucod.nextToken("|");    //Vrifica si lleva operando
                                      int  sioperI=Integer.parseInt(sioperS); //convierte de String a Cadena
                                     String  moddir=aucod.nextToken("|");   //Modo de direccionamiento  
                                     String  codcal=aucod.nextToken("|");  //Codigo calculado
                                    String   bytescal=aucod.nextToken("|"); //Bytes calculados
                                     String  bytesxcal=aucod.nextToken("|");  //Bytes por calcular
                                     String  totbytes=aucod.nextToken("|");  //Total de bytes
                            /*           System.out.print("Codop: "+codop);
                                       System.out.print(" Modo de direccionamiento: "+moddir);
                                       System.out.print(" Codigo calculado: "+codcal);
                                       System.out.print(" Bytes calculados: "+bytescal);
                                       System.out.print(" Bytes por calcular: "+bytesxcal);
                                       System.out.println(" Total de bytes: "+totbytes);
                              */       
                                       if(dir.equals(moddir)){
                                           Bytes=bytesxcal;
                                       }
                           
                                       }
                                   }
                                   
                                   }
                             dsaux.close(); 
                          }catch(Exception r){
                             System.out.println("Hubo un error en la busqueda de Bytes "+r);
                         }
        
        
        return Bytes;
    }
    public int TabsimCheck(String dir, String Etq){
        
        
                         int compara=0;
                         String mayus,exEtq;
                          
                         try{
                             FileInputStream fsaux = new FileInputStream(dir+".tds");
                             DataInputStream dsaux = new DataInputStream(fsaux);
                             BufferedReader  braux = new BufferedReader(new InputStreamReader(dsaux));
                             
                             String linaux;
                            
                             
                             while((linaux = braux.readLine())!= null){
                                 
                                 StringTokenizer aucod = new StringTokenizer(linaux,"|");
                                        mayus=Etq;
                                   exEtq=aucod.nextToken();
                                 
                                   
                                   if(exEtq.toUpperCase().compareTo(mayus.toUpperCase())==0&&mayus!="null"&&mayus!=null&&mayus!=" "){
              
                                       compara=1;
                                   }
                                   
                                   }
                             dsaux.close(); 
                          }catch(Exception r){
                             System.out.println("Hubo un error en la busqueda de Tabsim "+r);
                         }
        
        
        return compara;
    }
    
    public String fillContLoc(String ContLoc){
        
        int size =ContLoc.length();
        switch(size){
            
            case 1: 
                ContLoc="000"+ContLoc;
                break;
            case 2:
                ContLoc="00"+ContLoc;
                break;
            case 3:
                ContLoc="0"+ContLoc;
            case 4:
                break;
        }
          return ContLoc;      
        }
        
    }

