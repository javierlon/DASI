/*
 * Descripción: Implementa un contador que permite saber
 * el número de veces que saluda un usuario.
 */
package icaro.aplicaciones.informacion.Dasi;

/**
 *
 * @author Javier Longo
 */
public class Saludo {
    
    private boolean bol;
    private int i;
     
    public void setCont(int i){
        this.i=i;
    }
    
    public int getCont(){
        return i;
    }
    
    public void setSald(){
        this.bol = true;
    }
    
    public boolean getSald(){
        return bol;
    }
    
}
