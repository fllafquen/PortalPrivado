package portalPrivado.steps;

import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import portalPrivado.pageObject.PaginaDAP;

import static org.hamcrest.MatcherAssert.assertThat;

public class Dap extends ScenarioActor {

    @Steps(shared = true)
    PaginaDAP paginaDAP;

    @Step("#actor está en vista DAP")
    @Screenshots(afterEachStep = true)
    public void estamosEnVistaDap(){
        Boolean resultado = paginaDAP.estamosEnVistaDap();
        try{
            Thread.sleep(5000);
        }catch (Exception e){}
        assertThat(resultado, Matchers.equalTo(true));
    }

    @Step("#actor simula un DAP")
    public void simulaDap(String monto, String plazo) {
        paginaDAP.simulaDap(monto, plazo);
        paginaDAP.clickEnSimular();
    }

    @Step("#actor confirma resultado y continua paso dos")
    public void continuarAPasoTres() {
        try{
            Thread.sleep(5000);
        }catch (Exception e){}
        paginaDAP.confirmaSimulacionyClickEnContinuar();
    }

    @Step("#actor valida simulador e invierte")
    public void validaSimuladorEInvierte() {
        try{
            Thread.sleep(5000);
        }catch (Exception e){}
        paginaDAP.validaSimulacionEInvierte();
    }

    @Step("#actor confirma toma de DAP ingresando clave")
    public void confirmaTomaDeDap(String pass) {
        paginaDAP.confirmaTomaDeDap(pass);
    }

    @Step("#actor valida si existe un DAP ya tomado")
    public void validaSiExisteDap() {
        paginaDAP.validaSiExisteDap();
    }

    @Step("#actor valida que se haya tomado el DAP")
    public void validaComprobante() {
        paginaDAP.validaComprobanteDap();
    }

    @Step("#actor valida que se haya tomado el DAP")
    public void volverDesdePaginaUno() {
        paginaDAP.volverDePasoUno();
    }

    public void validaHomeDAP() {
        Boolean resultado = paginaDAP.validaHomeDAP();
        assertThat(resultado, Matchers.equalTo(true));
    }
}
