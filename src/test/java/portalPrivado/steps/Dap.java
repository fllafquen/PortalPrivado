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
    @Screenshots(afterEachStep = true)
    public void simulaDap(String monto, String plazo) {
        paginaDAP.simulaDap(monto, plazo);
        paginaDAP.clickEnSimular();
    }

    @Step("#actor confirma resultado y continua paso dos")
    @Screenshots(afterEachStep = true)
    public void continuarAPasoTres() {
        try{
            Thread.sleep(5000);
        }catch (Exception e){}
        paginaDAP.confirmaSimulacionyClickEnContinuar();
    }

    @Step("#actor valida simulador e invierte")
    @Screenshots(afterEachStep = true)
    public void validaSimuladorEInvierte() {
        try{
            Thread.sleep(5000);
        }catch (Exception e){}
        paginaDAP.validaSimulacionEInvierte();
    }

    @Step("#actor confirma toma de DAP ingresando clave")
    @Screenshots(afterEachStep = true)
    public void confirmaTomaDeDap(String pass) {
        paginaDAP.confirmaTomaDeDap(pass);
    }

    @Step("#actor valida si existe un DAP ya tomado")
    @Screenshots(afterEachStep = true)
    public void validaSiExisteDap() {
        paginaDAP.validaSiExisteDap();
    }

    @Step("#actor valida que se haya tomado el DAP")
    @Screenshots(afterEachStep = true)
    public void validaComprobante() {
        paginaDAP.validaComprobanteDap();
    }
}
