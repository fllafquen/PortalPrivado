package portalPrivado.steps;

import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import portalPrivado.pageObject.PaginaHome;

import static org.hamcrest.MatcherAssert.assertThat;

public class Home extends ScenarioActor{

    @Steps(shared = true)
    PaginaHome paginaHome;

    @Step("#actor deberia poder ver resultados que contenga el mensaje de Bienvenida")
    public void deberiaVerBienvenida(){
        Boolean resultado = paginaHome.validaBienvenida();
        try{
            Thread.sleep(5000);
        }catch (Exception e){}
        assertThat(resultado, Matchers.equalTo(true));
    }

    @Step("#actor va a modulo de depósito a plazo")
    public void iraDap() {
        paginaHome.clickEnDap();
        try{
            Thread.sleep(5000);
        }catch (Exception e){}
    }

    @Step("#actor va a modulo de depósito a plazo")
    public void iraTef() {
        paginaHome.clickEnTef();
        try{
            Thread.sleep(5000);
        }catch (Exception e){}
    }
}
