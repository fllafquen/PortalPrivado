package portalPrivado.pageObject;

import lombok.SneakyThrows;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import com.DeathByCaptcha.Client;
import com.DeathByCaptcha.HttpClient;
import com.DeathByCaptcha.Captcha;
import java.io.IOException;

public class PaginaPrincipal extends PageObject {

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]/div[1]/div[2]")
    WebElementFacade mensajeBienvenida;

    public Boolean validaBienvenida() {
        return mensajeBienvenida.isDisplayed();
    }
}
