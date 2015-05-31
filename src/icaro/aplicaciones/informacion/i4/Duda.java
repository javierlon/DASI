/*
 * Descripción: Define las partes de una duda realizada por un usuario.
 */
package icaro.aplicaciones.informacion.i4;

import icaro.aplicaciones.informacion.X.*;
import icaro.aplicaciones.informacion.Dasi.*;

/**
 *
 * @author Javier Longo 
 */
public class Duda {
    
    
    private boolean comp = false;
    private boolean apli;
    
   public boolean get_comp() {
        return this.comp;
    }
   
    public boolean get_apli() {
        return this.apli;
    }
   
    public void set_apli(boolean apli){
        this.apli = apli;
    } 
    
     public void set_comp(boolean comp){
        this.comp = comp;
    } 
    
   }
