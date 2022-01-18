package portalPrivado.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import portalPrivado.services.CardService;
import portalPrivado.services.ReadCellExample;

public class PaginaTransferencias  extends PageObject {

    @FindBy(xpath = "//h2[contains(text(),'Transferencia de fondos')]")
    WebElementFacade tituloTransferenciaDeFondos;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/img[1]")
    WebElementFacade primerDestinatario;

    @FindBy(xpath = "//button[@id='cuentas-btn']")
    WebElementFacade btnContinuar;

    @FindBy(xpath = "//input[@id='montoATransferir']")
    WebElementFacade montoATransferir;

    @FindBy(xpath = "//input[@id='comentario']")
    WebElementFacade mensajeTransferencia;

    @FindBy(xpath = "//button[contains(text(),'Continuar')]")
    WebElementFacade btnContinuarAPaso2;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/section[1]/header[1]/div[1]/h5[1]")
    WebElementFacade tituloCoordenadas;

    @FindBy(xpath = "//button[contains(text(),'Autorizar')]")
    WebElementFacade btnAutorizar;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/label[1]")
    WebElementFacade valorBox1;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/label[1]")
    WebElementFacade valorBox2;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/label[1]")
    WebElementFacade valorBox3;

    @FindBy(xpath = "//input[@id='cor1']")
    WebElementFacade box1;

    @FindBy(xpath = "//input[@id='cor2']")
    WebElementFacade box2;

    @FindBy(xpath = "//input[@id='cor3']")
    WebElementFacade box3;

    @FindBy(xpath = "//label[contains(text(),'Transferencia a terceros fue realizada con éxito')]")
    WebElementFacade comprobanteTransferencia;





    public void validaSiEstamosEnTef() {
        tituloTransferenciaDeFondos.isDisplayed();
    }

    public void seleccionarPrimerDestinatario() {
        primerDestinatario.isDisplayed();
        primerDestinatario.click();
    }

    public void clickBtnContinuar() {
        btnContinuar.isClickable();
        btnContinuar.click();
    }

    public void ingresaMonto(String monto) {
        montoATransferir.isDisplayed();
        montoATransferir.type(monto);
    }

    public void ingresaMensaje(String mensaje) {
        montoATransferir.isDisplayed();
        mensajeTransferencia.type(mensaje);
    }

    public void clickAPasoDos() {
        btnContinuarAPaso2.isDisplayed();
        btnContinuarAPaso2.click();
    }

    public String traerIdTarjeta() {
        tituloCoordenadas.isVisible();
        String tarjCoor = tituloCoordenadas.getText().substring(23, 27);
        return tarjCoor;
    }

    public void autorizarConCoor() {
        btnAutorizar.isClickable();
        btnAutorizar.click();
    }

    public void buscarEIngresarCoordenadas(String codTarjeta, String rut) {
        String valorColBox1 = valorBox1.getText().substring(0,1);
        String valorFIlaBox1 = valorBox1.getText().substring(1);
        String valorColBox2 = valorBox2.getText().substring(0,1);
        String valorFIlaBox2 = valorBox2.getText().substring(1);
        String valorColBox3 = valorBox3.getText().substring(0,1);
        String valorFIlaBox3 = valorBox3.getText().substring(1);

        System.out.println("Tarjeta de Coordenadas");
        System.out.println(valorColBox1);
        System.out.println(valorFIlaBox1);
        System.out.println(valorColBox2);
        System.out.println(valorFIlaBox2);
        System.out.println(valorColBox3);
        System.out.println(valorFIlaBox3);

        CardService cardService = new CardService();

        String col1 = cardService.getValueCardCol(valorColBox1);
        String fila1 = cardService.getValueCardFila(valorFIlaBox1);
        String col2 = cardService.getValueCardCol(valorColBox2);
        String fila2 = cardService.getValueCardFila(valorFIlaBox2);
        String col3 = cardService.getValueCardCol(valorColBox3);
        String fila3 = cardService.getValueCardFila(valorFIlaBox3);

        System.out.println("Valores de tarjetas");
        System.out.println(Integer.valueOf(col1)+" , "+Integer.valueOf(fila1));
        System.out.println(Integer.valueOf(col2)+" , "+Integer.valueOf(fila2));
        System.out.println(Integer.valueOf(col3)+" , "+Integer.valueOf(fila3));

        ReadCellExample rc = new ReadCellExample();
        String result1 =  rc.ReadCellData(Integer.valueOf(fila1),Integer.valueOf(col1), rut+"-"+codTarjeta);
        String result2 =  rc.ReadCellData(Integer.valueOf(fila2),Integer.valueOf(col2),rut+"-"+codTarjeta);
        String result3 =  rc.ReadCellData(Integer.valueOf(fila3),Integer.valueOf(col3), rut+"-"+codTarjeta);

        box1.type(result1);
        box2.type(result2);
        box3.type(result3);

        try{
            Thread.sleep(50000);
        }catch (Exception e){}

    }

    public void autorizaTranzaccion() {
        btnAutorizar.isClickable();
        btnAutorizar.click();
    }


    public Boolean validaTefTercero() {
        return comprobanteTransferencia.isDisplayed();
    }
}
