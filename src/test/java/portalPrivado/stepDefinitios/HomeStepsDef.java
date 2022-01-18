package portalPrivado.stepDefinitios;

import io.cucumber.java.Before;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import portalPrivado.steps.Dap;
import portalPrivado.steps.Home;

public class HomeStepsDef {
    @Steps(shared = true)
    Home actorHome;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Entonces("^(.*) deberia ver el mensaje de Bienvenida$")
    public void deberia_ver_mensaje_de_bienvenida(String nombreUsuario){
        actorHome.isCalled(nombreUsuario);
        actorHome.deberiaVerBienvenida();
    }

    @Y("^(.*) ingresa al modulo DAP$")
    public void ir_a_deposito_a_plazo(String nombreUsuario){
        actorHome.isCalled(nombreUsuario);
        actorHome.deberiaVerBienvenida();
        actorHome.iraDap();
    }

    @Y("^(.*) ingresa al modulo TEF$")
    public void ir_a_transfererir_fondos(String nombreUsuario){
        actorHome.isCalled(nombreUsuario);
        actorHome.deberiaVerBienvenida();
        actorHome.iraTef();
    }
}
