package portalPrivado.steps;

import net.thucydides.core.annotations.Screenshots;
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
    @Screenshots(afterEachStep = true)
    public void ingresarAPortalPrivadoQA() {
        paginaLogin.setDefaultBaseUrl(navigationPage.getPortalPrivadoQA());
        paginaLogin.open();
    }

    @Step("#actor realiza ingreso de rut: {0}")
    @Screenshots(afterEachStep = true)
    public void ingresaRut(String rut) {
        paginaLogin.ingresarRut(rut);
    }

    @Step("#actor realiza ingreso de password: {0}")
    @Screenshots(afterEachStep = true)
    public void ingresaPass(String pass) {
        paginaLogin.ingresarPassword(pass);
    }

    @Step("#actor da click a boton ingresar")
    @Screenshots(afterEachStep = true)
    public void clickABotonIngresar() {
        paginaLogin.clickOnBtnIngresar();
        paginaLogin.resuelveCaptchaSiEsNecesarion();
    }

    @Step("#actor deberia poder ver resultados que contenga el mensaje de Error")
    @Screenshots(afterEachStep = true)
    public void deberiaVerError(){
        Boolean resultado = paginaPrincipal.validaMensajeError();
        assertThat(resultado, Matchers.equalTo(true));
    }

}
