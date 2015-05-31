/*
 * Descripción: Implementa una respuesta para un mensaje sin semática por 
                segunda vez de manera consecutiva.
 */


/**
 *
 * @author Ignacio Melendrez
 *         Daniel Argüelles
 *         Javier Longo 
 */
package icaro.aplicaciones.agentes.AgenteAplicacionDasi.tareas;
// import icaro.aplicaciones.agentes.AgenteAplicacionDasi.objetivos.ContestarUsuario;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Focus;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;
import icaro.aplicaciones.informacion.Dasi.VocabularioDasi;

public class SeguSinSema extends TareaSincrona{
     private Objetivo contextoEjecucionTarea = null;
  @Override
	public void ejecutar(Object... params) {
  
            String identDeEstaTarea=this.getIdentTarea();
            String identAgenteOrdenante = this.getIdentAgente();
            String identInterlocutor = (String)params[0];
                    try {
 
		ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
		VocabularioGestionCitas.IdentRecursoComunicacionChat);          
                if (recComunicacionChat!=null){
                    recComunicacionChat.comenzar(identAgenteOrdenante);            
                    String mensajeAenviar = VocabularioDasi.RespuestaNoEntiendo2;
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


