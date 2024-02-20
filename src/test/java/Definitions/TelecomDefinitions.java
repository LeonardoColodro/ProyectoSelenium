package Definitions;

import PageObjetcs.FormularioPage;
import PageObjetcs.MenuDemoGuruPage;
import PageObjetcs.MenuTelecomPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;


import java.awt.*;
import java.util.List;
import java.util.Map;

public class TelecomDefinitions {
    MenuDemoGuruPage menu;
    MenuTelecomPage telecom;
    FormularioPage formulario;
    public TelecomDefinitions() {
        menu= new MenuDemoGuruPage(Hooks.driver);
        telecom = new MenuTelecomPage(Hooks.driver);
        formulario = new FormularioPage(Hooks.driver);
    }

    @Given("La web esta disponible")
    public void laWebEstaDisponible() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");
    }

    @When("doy click en telecom proyect")
    public void doyClicEnTelecomProyect() {
        menu.ClickTelecomProyect();
    }

    @And("doy click en agregar cliente")
    public void doyClickEnAgregarCliente() {
        telecom.ClickCliente();
    }

    @And("ingreso datos de cliente")

    public void ingresoDatosDeCliente(DataTable dataTable) {
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);

        if (lista.size() > 0) {
            Map<String, String> datosCliente = lista.get(0);

            formulario.ClickDone(datosCliente.get("check"));
            formulario.IngresarNombre(datosCliente.get("nombre"));
            formulario.IngresarApellido(datosCliente.get("apellido"));
            formulario.IngresarEmail(datosCliente.get("email"));
            formulario.IngresarDireccion(datosCliente.get("direccion"));
            formulario.IngresarTelefono(datosCliente.get("telefono"));
        } else {
            System.out.println("No se encontraron datos de cliente en la tabla");
        }
    }
}
