package portalPrivado.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class PaginaHome extends PageObject {

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]/div[1]/div[2]/div[2]")
    WebElementFacade mensajeBienvenida;

    @FindBy(xpath = "//p[contains(text(),'Los datos ingresados son incorrectos. Favor intent')]")
    WebElementFacade nemsajeError;

    @FindBy(id = "menu-2-6")
    WebElementFacade linkDepositoAPlazo;

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
}
