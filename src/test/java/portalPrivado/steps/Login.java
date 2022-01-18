package portalPrivado.steps;

import portalPrivado.navigation.DirectorioNavegacion;
import portalPrivado.pageObject.PaginaLogin;
import portalPrivado.pageObject.PaginaHome;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class Login extends ScenarioActor {

    @Steps(shared = true)
    PaginaLogin paginaLogin;

    @Steps(shared = true)
    PaginaHome paginaPrincipal;

    DirectorioNavegacion navigationPage = new DirectorioNavegacion();

    @Step("#actor ingresa a la pagina principal de portal privado Coopeuch")
    public void ingresarAPortalPrivadoQA() {
        paginaLogin.setDefaultBaseUrl(navigationPage.getPortalPrivadoQA());
        paginaLogin.open();
    }

    @Step("#actor realiza ingreso de rut: {0}")
    public void ingresaRut(String rut) {
        paginaLogin.ingresarRut(rut);
    }

    @Step("#actor realiza ingreso de password: {0}")
    public void ingresaPass(String pass) {
        paginaLogin.ingresarPassword(pass);
    }

    @Step("#actor da click a boton ingresar")
    public void clickABotonIngresar() {
        paginaLogin.clickOnBtnIngresar();
    }

    @Step("#actor valida el Captcha si es visible")
    public void validaCaptcha() {
        paginaLogin.resuelveCaptchaSiEsNecesarion();
    }

    @Step("#actor deberia poder ver resultados que contenga el mensaje de Error")
    public void deberiaVerError(){
        Boolean resultado = paginaPrincipal.validaMensajeError();
        assertThat(resultado, Matchers.equalTo(true));
    }

}
