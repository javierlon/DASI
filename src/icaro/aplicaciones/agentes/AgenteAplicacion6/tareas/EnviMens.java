/*
 * Descripción: Implementa el envío entre agentes.
 */
package icaro.aplicaciones.agentes.AgenteAplicacion6.tareas;


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
         Notificacion infoAenviar = new Notificacion("AgenteAplicacion6");
         infoAenviar.setTipoNotificacion("si");
         MensajeSimple mens = new MensajeSimple((Object)infoAenviar,"AgenteAplicacion6","AgenteAplicacionDialogoCitas1");
         
         itfUsoAgenteaReportar.aceptaMensaje(mens);
            } catch (Exception e) {
               System.out.println("Ha habido un error al enviar el mensaje. ");
               e.printStackTrace();
            }   
           
         }
}
 // MensajeSimple mens = new MensajeSimple();
         ///mens.setEmisor("AgenteAplicacionX");
         // mens.setReceptor("AgenteAplicacionDialogoCitas1");
         // mens.setContenido("a");           
           
       
        // getAgente() método de la clase Tarea
            // que devuelve agente congnitivo.
            // aceptaMensaje() es un método de la
            // clase AgenteCognitivo.
            // Ver ProcesadorItems.
            //AgenteCognitivotImp2 cognitivo = (AgenteCognitivotImp2) itfUsoRepositorioInterfaces.obtenerInterfaz(NombresPredefinidos.ITF_USO+agen);
            // ItfUsoAgenteCognitivo cognitivo = (ItfUsoAgenteCognitivo) itfUsoRepositorioInterfaces.obtenerInterfaz(NombresPredefinidos.ITF_USO+agen);
            // this.getAgente().aceptaMensaje(mens);
            //AgenteCognitivotImp2.aceptaMensaje(mens);
              //AgenteCognitivotImp2 cong = new AgenteCognitivotImp2("AgenteAplicacionDialogoCitas1xx");
            //cong.aceptaMensaje(mens);




    

