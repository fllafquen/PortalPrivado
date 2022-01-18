package portalPrivado.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import portalPrivado.services.ReadCellExample;


public class PaginaHome extends PageObject {

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]/div[1]/div[2]/div[2]")
    WebElementFacade mensajeBienvenida;

    @FindBy(xpath = "//p[contains(text(),'Los datos ingresados son incorrectos. Favor intent')]")
    WebElementFacade nemsajeError;

    @FindBy(id = "menu-2-6")
    WebElementFacade linkDepositoAPlazo;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[1]/div[1]")
    WebElementFacade transferencias;

    @FindBy(css = "#menu-3-1")
    WebElementFacade transferirFondos;

    public Boolean validaBienvenida() {
        return mensajeBienvenida.isDisplayed();
    }

    public Boolean validaMensajeError(){
        return nemsajeError.isDisplayed();
    }

    public void clickEnDap() {
        linkDepositoAPlazo.isDisplayed();
        linkDepositoAPlazo.click();
    }

    public void clickEnTef() {
        transferencias.isDisplayed();
        transferencias.click();
        transferirFondos.isDisplayed();
        transferirFondos.click();
    }
}
