package portalPrivado.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class PaginaDAP extends PageObject {

    @FindBy(xpath = "//h2[contains(text(),'Simulador Depósito a Plazo')]")
    WebElementFacade vistaSimulador;

    @FindBy(xpath = "//h2[contains(text(),'Depósito a Plazo')]")
    WebElementFacade vistaMenuDap;

    @FindBy(xpath = "//button[@id='simulacion-next-action']")
    WebElementFacade simular;

    @FindBy(xpath = "//input[@id='dap-simulacion-monto']")
    WebElementFacade ingresoMonto;

    @FindBy(xpath = "//input[@id='dap-simulacion-plazo']")
    WebElementFacade ingresoPlazo;

    @FindBy(xpath = "//button[contains(text(),'Continuar')]")
    WebElementFacade btnContinuar;

    @FindBy(xpath = "//h5[contains(text(),'Resultados de la simulación')]")
    WebElementFacade tituloResultadoSimulacion;

    @FindBy(xpath = "//h5[contains(text(),'Detalles de la simulación')]")
    WebElementFacade tituloDetalleSimulacion;

    @FindBy(xpath = "//button[contains(text(),'Invertir')]")
    WebElement btnInvertir;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]/div[3]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement ingresoDeClave;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]/div[3]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/label[1]/div[1]/div[1]")
    WebElement confirmaTerminosYCondiciones;

    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    WebElementFacade btnConfirmar;

    @FindBy(xpath = "//button[@id='btn-dap']")
    WebElementFacade btnSimular;

    @FindBy(xpath = "//div[contains(text(),'¡Felicidades! Tu contratación de Depósito a Plazo ')]")
    WebElement mensajeConfirmacion;

    @FindBy(xpath = "//button[@id='simulacion-prev-action']")
    WebElement btnVolverPasoUno;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/button[1]")
    WebElement btnVolverPasoDos;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[4]/div[1]/div[1]/button[1]")
    WebElement btnVolverPasoTres;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/button[1]")
    WebElement btnVolverPasoCuatro;






    public Boolean estamosEnVistaDap() {
        return vistaSimulador.isDisplayed();
    }

    public void clickEnSimular() {
        simular.click();
    }

    public void simulaDap(String monto, String plazo) {
        ingresoMonto.type(monto);
        ingresoPlazo.type(plazo);
    }

    public void confirmaSimulacionyClickEnContinuar() {
        tituloResultadoSimulacion.isDisplayed();
        btnContinuar.click();
    }

    public void validaSimulacionEInvierte() {
        tituloDetalleSimulacion.isDisplayed();
        btnInvertir.isDisplayed();
        btnInvertir.click();
    }

    public void confirmaTomaDeDap(String pass) {
        ingresoDeClave.isDisplayed();
        ingresoDeClave.sendKeys(pass);
        confirmaTerminosYCondiciones.click();
        btnConfirmar.isEnabled();
        btnConfirmar.click();
    }

    public void validaSiExisteDap() {
        if(btnSimular.isDisplayed()){
            btnSimular.click();
        }

    }

    public void validaComprobanteDap() {
        mensajeConfirmacion.isDisplayed();
    }

    public void volverDePasoCuatro(){
        btnVolverPasoCuatro.click();
    }

    public void volverDePasoTres(){
        btnVolverPasoTres.click();
    }

    public void volverDePasoDos(){
        btnVolverPasoDos.click();
    }

    public void volverDePasoUno(){
        btnVolverPasoDos.click();
    }

    public Boolean validaHomeDAP() {
        return vistaMenuDap.isDisplayed();
    }
}
