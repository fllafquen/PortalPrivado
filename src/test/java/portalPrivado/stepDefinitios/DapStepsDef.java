package portalPrivado.stepDefinitios;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import portalPrivado.steps.Dap;

public class DapStepsDef {

    @Steps(shared = true)
    Dap actorDap;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Y("^(.*) simula DAP con monto: (.*) en un plazo de: (.*)$")
    public void ir_a_simular_deposito_a_plazo(String nombreUsuario, String monto, String plazo){
        actorDap.isCalled(nombreUsuario);
        actorDap.validaSiExisteDap();
        actorDap.estamosEnVistaDap();
        actorDap.simulaDap(monto, plazo);
    }

    @Y("^(.*) valida el resultado y continua con el proceso$")
    public void confirmar_resultado_de_simulacion(String nombreUsuario){
        actorDap.isCalled(nombreUsuario);
        actorDap.continuarAPasoTres();
    }

    @Y("^(.*) valida detalle y presiona boton invertir$")
    public void valida_detalle_y_continua_a_invertir(String nombreUsuario){
        actorDap.isCalled(nombreUsuario);
        actorDap.validaSimuladorEInvierte();
    }

    @Y("^(.*) confirma la toma de DAP ingresando la pass: (.*)$")
    public void confirma_toma_de_DAP(String nombreUsuario, String pass){
        actorDap.isCalled(nombreUsuario);
        actorDap.confirmaTomaDeDap(pass);
    }

    @Entonces("^(.*) deberia ver el mensaje de Exito$")
    public void validar_comprobante_de_toma_de_DAP(String nombreUsuario){
        actorDap.isCalled(nombreUsuario);
        actorDap.validaComprobante();
    }


}
