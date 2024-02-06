package PageObjetcs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComprarPage {
    private WebDriver driver;
    private WebDriverWait wait;
    protected static String montoProducto;
    protected static String cantidad;

    @FindBy(tagName = "h3") private WebElement lbl_monto;
    @FindBy(name =  "quantity") private WebElement cbx_cantidad;
    @FindBy(xpath = "//input") private WebElement btn_comprar;
    @FindBy(tagName = "h2") private WebElement validarMensaje;


    public ComprarPage(WebDriver d) {
            driver = d;
            wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 segundos de espera usando Duration
            PageFactory.initElements(driver, this);

    }
    public void montoProducto(){
        wait.until(ExpectedConditions.visibilityOf(lbl_monto));
        montoProducto=lbl_monto.getText().replace("Price: $", "");
        System.out.println(montoProducto);
        System.out.println("El monto del producto es: " + montoProducto);
    }

    public void IngresoCantidad(String cant){
        int cantid = Integer.parseInt(cant);
        if ((cantid<1) || (cantid>9)){
            System.out.println("el monto no es correcto");
        }
        else {
            new Select(cbx_cantidad).selectByValue(cant);// Toma el valor del value en el Select
            // new Select(cbx_cantidad).selectByIndex(1); Encuentra el valor por la posicion de ubicacion indiciando desde el 0
            // new Select(cbx_cantidad).selectByVisibleText("2"); Toma el texto que es visible en comobobox
        }
            cantidad=cant;
    }

    public void ClickAgregarCarrito(){
        btn_comprar.click();
    }

    public void ValidarMensajeHome(String Validar){
        wait.until(ExpectedConditions.visibilityOf(validarMensaje));
        Assert.assertEquals(Validar, validarMensaje.getText());

    }
}
