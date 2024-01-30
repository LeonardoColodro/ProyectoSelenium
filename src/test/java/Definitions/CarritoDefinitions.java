package Definitions;

import PageObjetcs.CapturarDatosTarjetaPage;
import PageObjetcs.MenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CarritoDefinitions {
    MenuPage menu;
    CapturarDatosTarjetaPage captura;
    public CarritoDefinitions() {
        menu= new MenuPage(Hooks.driver);
        captura=new CapturarDatosTarjetaPage(Hooks.driver);
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
            Thread.sleep(6000);

        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
