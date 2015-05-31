/*
 * Descripción: Implementa el envío entre agentes.
 */
package icaro.aplicaciones.agentes.AgenteAplicacion3.tareas;


import icaro.aplicaciones.agentes.AgenteAplicacionX.tareas.*;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazUsoAgente;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;


import icaro.infraestructura.patronAgenteCognitivo.factoriaEInterfacesPatCogn.*;
import icaro.infraestructura.recursosOrganizacion.repositorioInterfaces.ItfUsoRepositorioInterfaces;
import icaro.infraestructura.patronAgenteCognitivo.factoriaEInterfacesPatCogn.imp.*;
import icaro.aplicaciones.informacion.gestionCitas.*;
/**
 *
 * @author Javier Longo
 */
public class EnviMens extends TareaSincrona  {
    
        String agen = "AgenteAplicacionDialogoCitas1";
        protected InterfazUsoAgente itfUsoAgenteaReportar;
    
        
    @Override 
public void ejecutar(Object... params)  {  
   try{                   
      itfUsoAgenteaReportar =  (InterfazUsoAgente) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfaz(NombresPredefinidos.ITF_USO+agen);           
         Notificacion infoAenviar = new Notificacion("AgenteAplicacion3");
         infoAenviar.setTipoNotificacion("a");
         MensajeSimple mens = new MensajeSimple((Object)infoAenviar,"AgenteAplicacion3","AgenteAplicacionDialogoCitas1");
         
         itfUsoAgenteaReportar.aceptaMensaje(mens);
            } catch (Exception e) {
               System.out.println("Ha habido un error al enviar el mensaje. ");
               e.printStackTrace();
            }   
           
         }
}
 