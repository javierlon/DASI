/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author root
 */
public class Entender extends TareaSincrona{

    private Objetivo contextoEjecucionTarea = null;
    public static Boolean fraseComponente = false; // La frase pertenece a la anotación Componente.
    public static Boolean fraseDuda = false; // La frase pertenece a la anotación Duda.// La frase pertenece a la anotación Duda.
  
   
        
  @Override
	public void ejecutar(Object... params) {
  /**
   * Produce un saludo inicial y una presentacion de funcionalidad inicial al entrar en el sistema
   */
        String identDeEstaTarea=this.getIdentTarea();
        String identAgenteOrdenante = this.getIdentAgente();
        String identInterlocutor = (String)params[0];
       
        // if (fraseDuda == true) {
           // Entender objeto = new Entender();
            // objeto.setTipoAnotacion(Anotacion.DUDA);
        // }    
        
                    try {
//         // Se busca la interfaz del recurso en el repositorio de interfaces 
		ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
						VocabularioGestionCitas.IdentRecursoComunicacionChat);          
                if ((recComunicacionChat!=null) && (fraseComponente = true) && (fraseDuda = true)) {
                    recComunicacionChat.comenzar(identAgenteOrdenante);
                    String mensajeAenviar = VocabularioDasi.RESPUESTA_FINAL;
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


