/*
 * Descripción: Envía un mensaje indicando que ya se conoce 
                la aplicación.
 */
package icaro.aplicaciones.agentes.AgenteAplicacionDasi.tareas;

// import icaro.aplicaciones.agentes.AgenteAplicacionDasi.objetivos.ContestarUsuario;
// import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;
import icaro.aplicaciones.agentes.AgenteAplicacionDasi.tareas.*;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Focus;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;
import icaro.aplicaciones.informacion.Dasi.VocabularioDasi;
/**
 *
 * @author Javier Longo
 */
public class NombreAplicacion2 extends TareaSincrona{
    
    public static Boolean fraseComponente = false; // La frase pertenece a la anotación Componente.
    public static Boolean fraseDuda = false; // La frase pertenece a la anotación Duda.
    private Objetivo contextoEjecucionTarea = null;
    
         
  @Override
	public void ejecutar(Object... params) {
  /**
   * Produce un saludo inicial y una presentacion de funcionalidad inicial al entrar en el sistema
   */
   String identDeEstaTarea=this.getIdentTarea();
            String identAgenteOrdenante = this.getIdentAgente();
          String identInterlocutor = (String)params[0];
                    try {
//         // Se busca la interfaz del recurso en el repositorio de interfaces 
		ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
						VocabularioGestionCitas.IdentRecursoComunicacionChat);          
                if ((recComunicacionChat!=null)) { 
                        // && (fraseComponente = true) && (fraseDuda = true)) {
                    recComunicacionChat.comenzar(identAgenteOrdenante);
                    String mensajeAenviar = VocabularioDasi.RESPUESTA_APLICACION2;
                    recComunicacionChat.enviarMensagePrivado(mensajeAenviar);
                  
                }   
                
                
                
                
                else {
                    identAgenteOrdenante = this.getAgente().getIdentAgente();
                     this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-AlObtener:Interfaz:"+
                             VocabularioGestionCitas.IdentRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
                        }
                    } catch(Exception e) {
                        this.generarInformeConCausaTerminacion(identDeEstaTarea, contextoEjecucionTarea, identAgenteOrdenante, "Error-Acceso:Interfaz:"+
                                VocabularioGestionCitas.IdentRecursoComunicacionChat, CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}
  

}


