/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacion6.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacion6.tareas.*;
import icaro.aplicaciones.agentes.AgenteAplicacion6.tareas.*;
import icaro.aplicaciones.agentes.AgenteAplicacion6.objetivos.IdenNull;
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
             this.getEnvioHechos().insertarHecho(new IdenNull());
       } catch (Exception e) {
			 e.printStackTrace();
                         trazas.aceptaNuevaTraza(new InfoTraza(this.getIdentAgente(), "Error al ejecutar la tarea : "+this.getIdentTarea() + e, InfoTraza.NivelTraza.error));
       }
   }

}
