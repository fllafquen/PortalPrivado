package portalPrivado.stepDefinitios;

import io.cucumber.java.Before;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import portalPrivado.steps.Transferencias;

public class TefStepDef {
    @Steps(shared = true)
    Transferencias actorTransferencias;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Y("^(.*) selecciona primer destinatario terceros$")
    public void ir_a_transferencias(String nombreUsuario){
        actorTransferencias.isCalled(nombreUsuario);
        actorTransferencias.seleccionarDestinatarioTerceros();
    }

    @Y("^(.*) presiona boton continuar$")
    public void ir_a_continuar(String nombreUsuario){
        actorTransferencias.isCalled(nombreUsuario);
        actorTransferencias.presionaBtnContinuar();
    }

    @Y("^(.*) ingresa monto: (.*) con mensaje: (.*)$")
    public void ingresa_monto_y_mensaje(String nombreUsuario, String monto, String mensaje){
        actorTransferencias.isCalled(nombreUsuario);
        actorTransferencias.ingresaMonto(monto);
        actorTransferencias.ingresaMensaje(mensaje);
        actorTransferencias.clickBtnPaso2();
    }

    @Y("^(.*) autoriza con coordenadas de cliente: (.*)$")
    public void autorizar_con_coordenadas(String nombreUsuario, String rut){
        actorTransferencias.isCalled(nombreUsuario);
        String codTarjeta = actorTransferencias.obtenerNtarjCoor();
        actorTransferencias.clickEnBtnAutorizar();
        actorTransferencias.buscarEInsertarCoor(codTarjeta, rut);
        actorTransferencias.confirmarAutorizacion();
    }

    @Entonces("^(.*) deberia ver el comprobante de la transaccion$")
    public void validar_comprobante_de_tef_a_tercero(String nombreUsuario){
        actorTransferencias.isCalled(nombreUsuario);
        actorTransferencias.validaTefTercero();
    }



}
