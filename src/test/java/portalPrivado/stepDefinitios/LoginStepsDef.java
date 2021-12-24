package portalPrivado.stepDefinitios;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import portalPrivado.steps.Home;
import portalPrivado.steps.Login;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

public class LoginStepsDef {

    @Steps(shared = true)
    Login actorLogin;
    Home actorHome;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^Que (.*) entra a portal privado Coopeuch QA$")
    public void ingresar_a_portal_privado_QA(String nombreUsuario) {
        actorLogin.isCalled(nombreUsuario);
        actorLogin.ingresarAPortalPrivadoQA();
    }

    @Cuando("^(.*) ingresa rut: (.*)$")
    public void ingresa_rut(String nombreUsuario, String rut) {
        actorLogin.isCalled(nombreUsuario);
        actorLogin.ingresaRut(rut);
    }

    @Cuando("^(.*) hace logIn con rut: (.*) y pass: (.*)$")
    public void hacer_logIn(String nombreUsuario, String rut, String pass) {
        actorLogin.isCalled(nombreUsuario);
        actorLogin.ingresaRut(rut);
        actorLogin.ingresaPass(pass);
        actorLogin.clickABotonIngresar();
    }

    @Y("^(.*) ingresa password: (.*)$")
    public void ingresa_pass(String nombreUsuario, String pass) {
        actorLogin.isCalled(nombreUsuario);
        actorLogin.ingresaPass(pass);
    }

    @Y("^(.*) presiona boton Ingresar$")
    public void ingresa_a_portal_privado(String nombreUsuario) {
        actorLogin.isCalled(nombreUsuario);
        actorLogin.clickABotonIngresar();
    }



    @Entonces("^(.*) deberia ver el mensaje de Error")
    public void deberia_ver_mensaje_de_error(String nombreUsuario){
        actorLogin.isCalled(nombreUsuario);
        actorLogin.deberiaVerError();
    }
}
