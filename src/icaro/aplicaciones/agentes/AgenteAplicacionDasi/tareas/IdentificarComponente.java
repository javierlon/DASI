/*
 * Descripción: La función de esta clase es preguntar al 
 * usuario con que componente está relacionada su duda.
 */
package icaro.aplicaciones.agentes.AgenteAplicacionDasi.tareas;

// import icaro.aplicaciones.agentes.AgenteAplicacionDasi.objetivos.ContestarUsuario;
import icaro.aplicaciones.informacion.Dasi.VocabularioDasi;
// import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Focus;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;

/**
 *
 * @author Javier Longo 
 */
public class IdentificarComponente extends TareaSincrona{

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
                if (recComunicacionChat!=null){
                    recComunicacionChat.comenzar(identAgenteOrdenante);
                    String mensajeAenviar = VocabularioDasi.COMPONENTE;
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


