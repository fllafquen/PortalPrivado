package portalPrivado.stepDefinitios;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import portalPrivado.steps.UsuarioPortalPrivado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

public class UsuarioDefineSteps {

    @Steps(shared = true)
    UsuarioPortalPrivado actor;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^Que (.*) entra a portal privado Coopeuch QA$")
    public void ingresar_a_portal_privado_QA(String nombreUsuario) {
        actor.isCalled(nombreUsuario);
        actor.ingresarAPortalPrivadoQA();
    }

    @Cuando("^(.*) ingresa rut: (.*)$")
    public void ingresa_rut(String nombreUsuario, String rut) {
        actor.isCalled(nombreUsuario);
        actor.ingresaRut(rut);
    }

    @Y("^(.*) ingresa password: (.*)$")
    public void ingresa_pass(String nombreUsuario, String pass) {
        actor.isCalled(nombreUsuario);
        actor.ingresaPass(pass);
    }

    @Y("^(.*) presiona boton Ingresar$")
    public void ingresa_a_portal_privado(String nombreUsuario) {
        actor.isCalled(nombreUsuario);
        actor.clickABotonIngresar();
    }

    @Entonces("^(.*) deberia ver el mensaje de Bienvenida$")
    public void deberia_ver_mensaje_de_bienvenida(String nombreUsuario){
        actor.isCalled(nombreUsuario);
        actor.deberiaVerBienvenida();
    }
}
