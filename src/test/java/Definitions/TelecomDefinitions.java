package Definitions;

import PageObjetcs.CustomerPage;
import PageObjetcs.FormularioPage;
import PageObjetcs.MenuDemoGuruPage;
import PageObjetcs.MenuTelecomPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class TelecomDefinitions {
    MenuDemoGuruPage menu;
    MenuTelecomPage telecom;
    FormularioPage formulario;
    CustomerPage customer;
    String CSV_File_Path = "src/test/resources/data/test.csv";
    public TelecomDefinitions() {
        menu= new MenuDemoGuruPage(Hooks.driver);
        telecom = new MenuTelecomPage(Hooks.driver);
        formulario = new FormularioPage(Hooks.driver);
        customer = new CustomerPage(Hooks.driver);
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

    @And("ingreso los datos del cliente desde un csv")
    public void ingresoLosDatosDelClienteDesdeUnCsv() throws IOException {
        Reader reader= Files.newBufferedReader(Paths.get(CSV_File_Path));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("Check", "Nombre", "Apellido", "Email", "Direccion", "Telefono")
                .withSkipHeaderRecord()
                .withTrim());

        for (CSVRecord csvRecord:csvParser) {
            formulario.ClickDone(csvRecord.get(0));
            formulario.IngresarNombre(csvRecord.get(1));
            formulario.IngresarApellido(csvRecord.get("Apellido"));
            formulario.IngresarEmail(csvRecord.get("Email"));
            formulario.IngresarDireccion(csvRecord.get("Direccion"));
            formulario.IngresarTelefono(csvRecord.get("Telefono"));
        }
    }

    @And("click enviar un formulario")
    public void clickEnviarUnFormulario() {
        formulario.ClickEnviar();
    }

    @And("capturo el customer del cliente")
    public void capturoElCustomerDelCliente() {
        customer.CapturarCustomer();
        customer.ClickEnviar();
    }

    @And("doy click en agregar tarija de customer")
    public void doyClickEnAgregarTarijaDeCustomer() {
        telecom.ClickAddCustomer();
    }

    @Then("obtengo el mensaje de Alerta")
    public void obtengoElMensajeDeAlerta() {
        formulario.ObtenerMensajeAlerta();
    }
}
