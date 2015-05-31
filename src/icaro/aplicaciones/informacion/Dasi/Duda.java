/*
 * Descripción: Define las partes de una duda realizada por un usuario.
 */
package icaro.aplicaciones.informacion.Dasi;

/**
 *
 * @author Javier Longo 
 */
public class Duda {
    
    
    private boolean comp = false;
    private boolean apli = false;
    private boolean salu = false;
    private boolean desp = false;
    private boolean nulo = false;
    private boolean resp = false;
    
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
    
public boolean get_salu() {
        return this.salu;
    }
   
    public boolean get_desp() {
        return this.desp;
    }
   
    public void set_salu(boolean salu){
        this.salu = salu;
    } 
    
     public void set_desp(boolean desp){
        this.desp = desp;
    } 
       
   public boolean get_nulo() {
        return this.nulo;
    }

   public void set_nulo(boolean nulo){
        this.nulo = nulo;
    } 
 
   public boolean get_resp() {
        return this.resp;
    }

   public void set_resp(boolean resp){
        this.resp = resp;
    } 


}
