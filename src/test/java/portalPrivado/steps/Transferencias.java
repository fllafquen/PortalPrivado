package portalPrivado.steps;

import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import portalPrivado.pageObject.PaginaTransferencias;

import static org.hamcrest.MatcherAssert.assertThat;

public class Transferencias extends ScenarioActor {

    @Steps(shared = true)
    PaginaTransferencias paginaTransferencias;


    @Step("#selccionando destinatario pa transferencia a tercer")
    public void seleccionarDestinatarioTerceros() {
        paginaTransferencias.validaSiEstamosEnTef();
        paginaTransferencias.seleccionarPrimerDestinatario();
    }

    @Step("#presiona boton continuar")
    public void presionaBtnContinuar() {
        paginaTransferencias.clickBtnContinuar();
    }

    @Step("#ingresa monto")
    public void ingresaMonto(String monto) {
        paginaTransferencias.ingresaMonto(monto);
    }

    @Step("#ingresa mensaje")
    public void ingresaMensaje(String mensaje) {
        paginaTransferencias.ingresaMensaje(mensaje);
    }

    @Step("#Click a Paso Dos")
    public void clickBtnPaso2() {
        paginaTransferencias.clickAPasoDos();
    }

    @Step("#Obtener numero de tarjeta de Coordenadas")
    public String obtenerNtarjCoor() {
        String idTarjeta = paginaTransferencias.traerIdTarjeta();
        System.out.println("id Tarjeta"+idTarjeta);
        return idTarjeta;
    }

    @Step("#Click en boton autorizar")
    public void clickEnBtnAutorizar() {
        paginaTransferencias.autorizarConCoor();
    }

    @Step("#Buscar e insertar coordenadas")
    public void buscarEInsertarCoor(String codTarjeta, String rut) {
        paginaTransferencias.buscarEIngresarCoordenadas(codTarjeta, rut);
    }

    @Step("#Confirmar autorización")
    public void confirmarAutorizacion() {
        paginaTransferencias.autorizaTranzaccion();
    }

    @Step("#Validar transferencia a tercero")
    public void validaTefTercero() {
        Boolean resultado = paginaTransferencias.validaTefTercero();
        assertThat(resultado, Matchers.equalTo(true));
    }
}
