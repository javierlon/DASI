/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionX.tareas;
// import icaro.aplicaciones.agentes.AgenteAplicacionDialogoCitasCognitivo.tareas.*;
import icaro.aplicaciones.agentes.AgenteAplicacionDasi.tareas.*;
import icaro.aplicaciones.agentes.AgenteAplicacionX.tareas.*;  
// import icaro.aplicaciones.agentes.AgenteAplicacionDialogoCitasCognitivo.objetivos.ObtenerInfoInterlocutor;
/*---La clase con el objetivo ContestarUsuario--- 8 de mayo de 2015 */
import icaro.aplicaciones.agentes.AgenteAplicacionX.objetivos.ContestarUsuario; // La clase con el objetivo 
/*---La clase con el objetivo EntenderUsuario--- 8 de mayo de 2015 */
import icaro.aplicaciones.agentes.AgenteAplicacionX.objetivos.EntenderUsuario;
import icaro.aplicaciones.agentes.AgenteAplicacionX.objetivos.*;
/*---La clase con el objetivo PreguntarUsuario--- 11 de mayo de 2015 */
import icaro.aplicaciones.agentes.AgenteAplicacionX.objetivos.PreguntarUsuario;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Focus;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
//import icaro.aplicaciones.informacion.Dasi.Duda; // Mod. 21
import icaro.aplicaciones.informacion.X.*;

/**
 *
 * @author Francisco J Garijo
 */
public class InicializarInfoWorkMem extends TareaSincrona{

   @Override
   public void ejecutar(Object... params) {
	   try {
        //     Objetivo objetivoEjecutantedeTarea = (Objetivo)params[0];
             String identTarea = this.getIdentTarea();
             String nombreAgenteEmisor = this.getIdentAgente();
             this.getItfConfigMotorDeReglas().setDepuracionActivationRulesDebugging(true);
             this.getItfConfigMotorDeReglas().setfactHandlesMonitoring_afterActivationFired_DEBUGGING(true);
             this.getEnvioHechos().insertarHechoWithoutFireRules(new Focus());
             //this.getEnvioHechos().insertarHechoWithoutFireRules(new Duda()); // Mod 21.
             //this.getEnvioHechos().insertarHechoWithoutFireRules(new Saludo()); // Mod 21.
             //this.getEnvioHechos().insertarHechoWithoutFireRules(new MensNoVali()); // Mod 22.
             //this.getEnvioHechos().insertarHecho(new ObtenerInfoInterlocutor());
             this.getEnvioHechos().insertarHecho(new ContestarUsuario()); // El objetivo es ContestarUsuario.
             /* ---Nuevo Objetivo--- 8 de mayo de 2015 */
              this.getEnvioHechos().insertarHecho(new IdenComp());
       } catch (Exception e) {
			 e.printStackTrace();
                         trazas.aceptaNuevaTraza(new InfoTraza(this.getIdentAgente(), "Error al ejecutar la tarea : "+this.getIdentTarea() + e, InfoTraza.NivelTraza.error));
       }
   }

}
