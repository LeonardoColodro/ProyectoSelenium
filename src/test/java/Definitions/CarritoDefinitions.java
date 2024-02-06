package Definitions;

import PageObjetcs.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDefinitions {
    MenuPage menu;
    CapturarDatosTarjetaPage captura;
    CheckCreditPage credit;
    BalanceTarjetaPage balance;
    ComprarPage comprar;
    ValidarTarjetaPage validar;
    CapturarRegistroCompraPage orden;
    public CarritoDefinitions() {
        menu= new MenuPage(Hooks.driver);
        captura=new CapturarDatosTarjetaPage(Hooks.driver);
        credit= new CheckCreditPage(Hooks.driver);
        balance= new BalanceTarjetaPage(Hooks.driver);
        comprar = new ComprarPage(Hooks.driver);
        validar = new ValidarTarjetaPage(Hooks.driver);
        orden = new CapturarRegistroCompraPage(Hooks.driver);
    }

    @Given("la pagina esta estable")
    public void laPaginaEstaEstable() {

        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");
    }

    @When("doy click en generar tarjeta")
    public void doyClickEnGenerarTarjeta() {
        menu.ClickGenerarTarjeta();
    }

    @And("capturamos datos de la tarjeta")
    public void capturamosDatosDeLaTarjeta() {
        captura.CambiarVentana();
        captura.CapturarTarjeta();
    }


    @And("capturamos el cvv de la tarjeta")
    public void capturamosElCvvDeLaTarjeta() {
        captura.CapturarCVV();
    }

    @And("capturamos la fecha de la tarjeta")
    public void capturamosLaFechaDeLaTarjeta() {
        captura.CapturarFecha();
    }

    @And("capturamos el monto disponible de la tarjeta")
    public void capturamosElMontoDisponibleDeLaTarjeta() {
        captura.CapturarMontoDisponible();
        captura.CerrarVentana();
    }

    @When("doy click en Check Credit")
    public void doyClickEnCheckCredit() {
        menu.clickCheckCredit(); //No da clik en el boton Check Credit Card
        try {
            Thread.sleep(3000);

        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @And("ingreso el dato de la tarjeta y doy click")
    public void ingresoElDatoDeLaTarjetaYDoyClick() {
        credit.IngresarDatoTarjeta();
        credit.ClickBtn();
    }


    @Then("Puedo capturar los mensajes del balance de tarjeta {string}")
    public void puedoCapturarLosMensajesDelBalanceDeTarjeta(String mensajeBalance) {
        balance.CapturarMensajeBalance(mensajeBalance);

    }

    @And("capturo el mensaje de {string}")
    public void capturoElMensajeDe(String MensajeTransaccion) {
        balance.CapturarAnyTransactions(MensajeTransaccion);
        balance.ClickBtnCart();
    }

    @And("capturo datos de tarjeta")
    public void capturoDatosDeTarjeta() {
        captura.CambiarVentana();
        captura.CapturarTarjeta();
        captura.CapturarFecha();
        captura.CapturarCVV();
        captura.CapturarMontoDisponible();
        captura.CerrarVentana();
    }

    @And("capturo el monto del producto")
    public void capturoElMontoDelProducto() {
        comprar.montoProducto();
    }

    @And("ingreso la cantidad {string}")
    public void ingresoLaCantidad(String cant) {
        comprar.IngresoCantidad(cant);

    }

    @And("doy click en agregar")
    public void doyClickEnAgregar() {
        comprar.ClickAgregarCarrito();
    }

    @And("valido datos de Tarjeta")
    public void validoDatosDeTarjeta() {
        validar.IngresarDatosTarjeta();
    }

    @Then("Valido el pago exitoso {string}")
    public void validoElPagoExitoso(String mensaje) {
        orden.ValidarMensajePayment(mensaje);
    }

    @And("Capturo el numero de orden")
    public void capturoElNumeroDeOrden() {
        orden.capturarOrden();
    }

    @And("doy click")
    public void doyClick() {
        orden.ClickHome();
    }

    @And("valido Mensaje Home {string}")
    public void validoMensajeHome(String ValidarHome) {
        comprar.ValidarMensajeHome(ValidarHome);
    }

    @And("doy click y voy a check credit")
    public void doyClickYVoyACheckCredit() {
        orden.ClickHome();
        menu.clickCheckCredit();
    }

    @And("valido que la tarjeta sea correcta")
    public void validoQueLaTarjetaSeaCorrecta() {
        balance.validarDatos();
    }
}
