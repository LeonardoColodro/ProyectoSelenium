package PageObjetcs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormularioPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Alert MensajeAlerta;

    @FindBy(xpath = "//*[@id='done']//following-sibling::label") private WebElement rdn_done;
    @FindBy(xpath = "//div[2]/label") private WebElement rdn_pending;
    @FindBy(name = "fname") private WebElement txt_name;
    @FindBy(name = "lname") private WebElement txt_apellido;
    @FindBy(name = "emailid") private WebElement txt_email;
    @FindBy(name = "addr") private WebElement txt_direccion;
    @FindBy(name = "telephoneno") private WebElement txt_telephoneno;
    @FindBy(name = "submit") private WebElement btn_enviar;

    public FormularioPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 segundos de espera usando Duration
        PageFactory.initElements(driver, this);
    }

    public void ClickDone(String check){

        if (check.toLowerCase().equals("done")){
            wait.until(ExpectedConditions.elementToBeClickable(rdn_done));
            rdn_done.click();
        } else if (check.toLowerCase().equals("pending")) {
            wait.until(ExpectedConditions.elementToBeClickable(rdn_done));
            rdn_pending.click();
        }
    }
    public  void IngresarNombre(String nombre){
        txt_name.sendKeys(nombre);
    }

    public  void IngresarApellido(String apellido){
        txt_apellido.sendKeys(apellido);
    }
    public  void IngresarEmail(String email){
        txt_email.sendKeys(email);
    }
    public  void IngresarDireccion(String direccion){
        txt_direccion.sendKeys(direccion);
    }
    public  void IngresarTelefono(String telefono){
        txt_telephoneno.sendKeys(telefono);
    }

    public void ClickEnviar(){
        btn_enviar.click();
    }

    public void ObtenerMensajeAlerta(){
        MensajeAlerta= driver.switchTo().alert();
        System.out.println("El mensaje de la alerta es: "+ MensajeAlerta.getText());
        MensajeAlerta.accept();
    }
}
