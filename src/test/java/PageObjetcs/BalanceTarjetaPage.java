package PageObjetcs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BalanceTarjetaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[1]") private WebElement lbl_CreditBalance;
    @FindBy(xpath = "//font[2]") private WebElement lbl_AnyTransactions;
    @FindBy(linkText = "Cart") private WebElement btn_Cart;
    @FindBy(xpath = "//td[1]/b/font") private WebElement lbl_tarjeta;
    @FindBy(xpath = "//td[2]/b/font") private WebElement lbl_monto;
    @FindBy(xpath = "//td[3]/b/font") private WebElement lbl_mes;
    @FindBy(xpath = "//td[4]/b/font") private WebElement lbl_anio;
    @FindBy(xpath = "//td[5]/b/font") private WebElement lbl_cvv;
    @FindBy(xpath = "//td[6]/b/font") private WebElement lbl_orden;

    public BalanceTarjetaPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 segundos de espera usando Duration
        PageFactory.initElements(driver, this);
    }

    public void CapturarMensajeBalance(String MensajeBalance){
        wait.until(ExpectedConditions.visibilityOf(lbl_CreditBalance));
        Assert.assertEquals(MensajeBalance, lbl_CreditBalance.getText());
        System.out.println(MensajeBalance + " " + lbl_CreditBalance.getText());
    }

    public void CapturarAnyTransactions(String MensajeTransaccion){
        Assert.assertEquals(MensajeTransaccion, lbl_AnyTransactions.getText()); //Los Asserts Equals sirven para comparar Texto de Envio contra Texto Capturado
        System.out.println(MensajeTransaccion + " " + lbl_AnyTransactions.getText());
    }

    public void ClickBtnCart(){
        btn_Cart.click();
    }

    public void validarDatos(){
        wait.until(ExpectedConditions.visibilityOf(lbl_tarjeta));
        Assert.assertEquals(CapturarDatosTarjetaPage.tarjeta,lbl_tarjeta.getText());
        String monto=lbl_monto.getText().replace("$", "");
        String montototal= String.valueOf(ValidarTarjetaPage.total).replace(".0", "");
        Assert.assertEquals(montototal, monto);
        String mes = CapturarDatosTarjetaPage.mes.replaceFirst("^0+(?!$)", "");
        //Reemplazar los ceros que estan a la izquierda
        System.out.println("el mes es: " + mes);
        Assert.assertEquals(mes, lbl_mes.getText());
        Assert.assertEquals(CapturarDatosTarjetaPage.anio,lbl_anio.getText());
        Assert.assertEquals(CapturarDatosTarjetaPage.cvv,lbl_cvv.getText());
        Assert.assertEquals(CapturarRegistroCompraPage.orden,lbl_orden.getText());
    }
}
