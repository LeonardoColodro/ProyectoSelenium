package PageObjetcs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

public class ValidarTarjetaPage {
    protected static String MontoValidar;
    private WebDriver driver;
    private WebDriverWait wait;
    protected static double total;
    @FindBy(xpath = "//font[2]") private WebElement lbl_Monto;
    @FindBy(name = "card_nmuber") private WebElement txt_tarjeta;
    @FindBy(name = "month") private WebElement cbx_mes;
    @FindBy(name = "year") private WebElement cbx_anio;
    @FindBy(name = "cvv_code") private WebElement txt_cvss;
    @FindBy(name = "submit") private WebElement btn_pago;

    public ValidarTarjetaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 segundos de espera usando Duration
        PageFactory.initElements(driver, this);
    }

    public void IngresarDatosTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(lbl_Monto));
        MontoValidar=lbl_Monto.getText().replace("$", "");
       // double montoD=  Double.parseDouble(ComprarPage.montoProducto);
        //int cantD = Integer.parseInt(ComprarPage.cantidad);
        total = Double.parseDouble(ComprarPage.montoProducto) * Double.parseDouble(ComprarPage.cantidad);
        //double totalMonto= montoD*cantD;
        BigDecimal totalMonto = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        BigDecimal montoCompra = new BigDecimal(Double.parseDouble(MontoValidar)).setScale(2,RoundingMode.HALF_UP);
       // System.out.println("Monto de compra Enviado: " + totalMonto);
        Assert.assertEquals(totalMonto, montoCompra);
        txt_tarjeta.sendKeys(CapturarDatosTarjetaPage.tarjeta);
        new Select(cbx_mes).selectByVisibleText(CapturarDatosTarjetaPage.mes);
        new Select(cbx_anio).selectByValue(CapturarDatosTarjetaPage.anio);
        txt_cvss.sendKeys(CapturarDatosTarjetaPage.cvv);
        btn_pago.click();

        //double montoCompra= Double.parseDouble(MontoValidar);
        //if (totalMonto==montoCompra){
          //  txt_tarjeta.sendKeys(CapturarDatosTarjetaPage.tarjeta);
           // new Select(cbx_mes).selectByVisibleText(CapturarDatosTarjetaPage.mes);
            //new Select(cbx_anio).selectByValue(CapturarDatosTarjetaPage.anio);
           // txt_cvss.sendKeys(CapturarDatosTarjetaPage.cvv);
           // btn_pago.click();
        //}
    }
}
