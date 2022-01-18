package portalPrivado.pageObject;

import com.DeathByCaptcha.*;
import com.DeathByCaptcha.Exception;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


import java.io.IOException;


public class PaginaLogin extends PageObject {

    @FindBy(xpath = "//input[@id='login-input-rut']")
    WebElementFacade ingresoRut;

    @FindBy(xpath = "//input[@id='login-input-password']")
    WebElementFacade ingresoPassword;

    @FindBy(xpath = "//button[@id='login-submit']")
    WebElementFacade btnIngresar;

    @FindBy(xpath = "//body/div[2]/div[1]")
    WebElementFacade captchaContainer;

    @FindBy(id = "recaptcha-verify-button")
    WebElementFacade confirmarCaptcha;

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

        if(captchaContainer.isClickable()){


        String username = "fllafquen";
        String password = "zbtC8#XusN_*Q*Q";
        /* Put your DeathByCaptcha account username and password here.
       Use HttpClient for HTTP API. */



            Client client = (Client)(new HttpClient(username, password));

            client.isVerbose = true;
            Captcha captcha = null;
            try {
                // Upload a reCAPTCHA and poll for its status with 120 seconds timeout.
                // Put your proxy, proxy type, page googlekey, page url and solving timeout (in seconds)
                // 0 or nothing for the default timeout value.
                captcha = client.decode("","","6Lc0i-oZAAAAAOmsutljPEIJKWfZB1ZyI8IlWd6K","https://www.google.com/recaptcha/api2/bframe", 30);
                if (null != captcha) {
                /* The CAPTCHA was solved; captcha.id property holds its numeric ID,
                   and captcha.text holds its text. */
                    System.out.println("CAPTCHA " + captcha.id + " solved: " + captcha.text);

                    if (captcha.isSolved()) {
                        //client.report(captcha);
                        System.out.println(" vamos a inyectar el Captcha token: " + captcha.text);
                        evaluateJavascript("document.getElementById('g-recaptcha-response').innerHTML='" + captcha.text + "';");
                        System.out.println("Hemos inyectado el Captcha token");



                        System.out.println("cambiando a frame de recaptcha");
                        getDriver().switchTo().frame("starts-with(@name, 'c-') and starts-with(@src");
                        find(By.id("recaptcha-verify-button")).click();
                        getDriver().switchTo().defaultContent();
                        System.out.println("vamos a darle click al boton confirmar");
                        confirmarCaptcha.click();
                        System.out.println("hemos presionado el boton confirmar");
                    /*    Enter.theValue(Keys.TAB);
                        Enter.theValue(Keys.ENTER);*/
                        }
                    }

            } catch (AccessDeniedException e) {
                /* Access to DBC API denied, check your credentials and/or balance */
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
