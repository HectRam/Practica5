/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

/**
 *
 * @author Hector
 */
public class espacios extends Practica5{
    
    boolean spacio(String Line){
        String thisLine=Line;
        boolean espacio;
        if(thisLine.charAt(0) == ' ' || thisLine.charAt(0) == '\t'){
                             
                            
                            espacio=true; 
                          
                         }
                  else{
                      espacio=false;
                  }
        return espacio;
    }

    
    
}
