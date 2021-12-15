package portalPrivado.pageObject;

import com.DeathByCaptcha.Captcha;
import com.DeathByCaptcha.Client;
import com.DeathByCaptcha.HttpClient;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import com.DeathByCaptcha.Client;
import com.DeathByCaptcha.HttpClient;
import com.DeathByCaptcha.Captcha;
import java.io.IOException;

import java.io.IOException;


public class PaginaLogin extends PageObject {

    @FindBy(xpath = "//input[@id='login-input-rut']")
    WebElementFacade ingresoRut;

    @FindBy(xpath = "//input[@id='login-input-password']")
    WebElementFacade ingresoPassword;

    @FindBy(xpath = "//button[@id='login-submit']")
    WebElementFacade btnIngresar;

    @FindBy(id = "rc-imageselect")
    WebElementFacade captchaContainer;

    public void ingresarRut(String rut) {
        ingresoRut.type(rut);
    }

    public void clickOnBtnIngresar() {
        btnIngresar.isClickable();
        btnIngresar.click();
    }

    public void ingresarPassword(String pass) {
        ingresoPassword.type(pass);
    }


    public void resuelveCaptchaSiEsNecesarion(){
        String username = "fllafquen";
        String password = "zbtC8#XusN_*Q*Q";
        //String authtoken = "your_token_here";

        Client client = (Client)(new HttpClient(username, password));

        client.isVerbose = true;

        if (captchaContainer.isClickable()){
            try {
                try {
                    System.out.println("Your balance is " + client.getBalance() + " US cents");
                } catch (IOException e) {
                    System.out.println("Failed fetching balance: " + e.toString());
                }

                Captcha captcha = null;
                try {
                    // Upload a reCAPTCHA and poll for its status with 120 seconds timeout.
                    // Put your proxy, proxy type, page googlekey, page url and solving timeout (in seconds)
                    // 0 or nothing for the default timeout value.
                    captcha = client.decode("http://user:password@127.0.0.1:1234","http","x226Lc0i-oZAAAAAOmsutljPEIJKWfZB1ZyI8IlWd6K","https://www.google.com/recaptcha/api2/", 30);
                } catch (IOException e) {
                    System.out.println("Failed uploading CAPTCHA");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (null != captcha) {
                    System.out.println("CAPTCHA " + captcha.id + " solved: " + captcha.text);

                    // Report incorrectly solved CAPTCHA if necessary.
                    // Make sure you've checked if the CAPTCHA was in fact incorrectly
                    // solved, or else you might get banned as abuser.
                    try {
                        if (client.report(captcha)) {
                            System.out.println("Reported as incorrectly solved");
                        } else {
                            System.out.println("Failed reporting incorrectly solved CAPTCHA");
                        }
                    } catch (IOException e) {
                        System.out.println("Failed reporting incorrectly solved CAPTCHA: " + e.toString());
                    }
                } else {
                    System.out.println("Failed solving CAPTCHA");
                }
            } catch (com.DeathByCaptcha.Exception e) {
                System.out.println(e);
            }
        }
    }
}
