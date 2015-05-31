/*
 * Descripción: Clase para detectar número de mensajes
 *  sin semantica.
 */
package icaro.aplicaciones.informacion.Dasi;

/**
 *
 * @author Ignacio Melendrez
 *         Daniel Argüelles
 *         Javier Longo
 */
public class MensNoVali {
  private int cont = 0;
  
  public void suma() {
      cont += 1;
  }
  
  public int getCont() {
      return cont;
  }
  
  public void setCont(){
      this.cont = 0;
  }
}
