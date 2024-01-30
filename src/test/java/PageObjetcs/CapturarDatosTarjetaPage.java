package PageObjetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CapturarDatosTarjetaPage {
    private WebDriver driver;
    private WebDriverWait wait;
    protected static String tarjeta;
    protected static String cvv;
    protected static String mes;
    protected static String anio;
    protected static String monto;

    @FindBy(xpath = "//h4[1]") private WebElement lbl_tarjeta;
    @FindBy(xpath = "//h4[2]") private WebElement lbl_cvv;
    @FindBy(xpath = "//h4[3]") private WebElement lbl_fecha;
    @FindBy(xpath = "//h4[4]") private WebElement lbl_montoDisponible;

    public CapturarDatosTarjetaPage(WebDriver d){
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 segundos de espera
        PageFactory.initElements(driver, this);
    }

    public void CambiarVentana(){
        int ventana= 0;
        Set<String> identificadores = driver.getWindowHandles();
        for (String identificador: identificadores){
            ventana++;
            driver.switchTo().window(identificador);
            System.out.println(ventana + " : " +identificador);
           // wait.until(ExpectedConditions.visibilityOf(lbl_tarjeta));
        }
    }

    public void CapturarTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(lbl_tarjeta));
        tarjeta=lbl_tarjeta.getText().replace("Card Number:- ", "");
        System.out.println(tarjeta);
    }

    public void CapturarCVV(){
        cvv=lbl_cvv.getText().replace("CVV:- ", "");
        System.out.println(cvv);
    }

    public void CapturarFecha(){
        String dato []=lbl_fecha.getText().replace("Exp:- ","").split("/");
        mes=dato[0];
        anio=dato[1];
        System.out.println(mes);
        System.out.println(anio);
    }

    public void CapturarMontoDisponible(){
        monto=lbl_montoDisponible.getText().replace("Credit Limit $", "");
        System.out.println(monto);
    }

    public void CerrarVentana(){
        driver.close();
        driver.switchTo().window((  ""));
    }

}
