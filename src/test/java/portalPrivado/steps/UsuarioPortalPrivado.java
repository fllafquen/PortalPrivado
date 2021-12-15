package portalPrivado.steps;

import portalPrivado.navigation.DirectorioNavegacion;
import portalPrivado.pageObject.PaginaLogin;
import portalPrivado.pageObject.PaginaPrincipal;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class UsuarioPortalPrivado extends ScenarioActor {

    @Steps(shared = true)
    PaginaLogin paginaLogin;

    @Steps(shared = true)
    PaginaPrincipal paginaPrincipal;

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
        paginaLogin.resuelveCaptchaSiEsNecesarion();
    }

    @Step("#actor deberia poder ver resultados que contenga el container de Captcha")
    public void deberiaVerBienvenida(){
        Boolean resultado = paginaPrincipal.validaBienvenida();
        try{
            Thread.sleep(20000);
        }catch (Exception e){}
        assertThat(resultado, Matchers.equalTo(true));
    }

}
