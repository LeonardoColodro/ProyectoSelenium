package PageObjetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuTelecomPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy (linkText = "Add Customer") private WebElement lnk_agregarCliente;
    @FindBy (linkText = "Add Tariff Plan to Customer") private WebElement lnk_agregarCustomer;

    public MenuTelecomPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 segundos de espera usando Duration
        PageFactory.initElements(driver, this);
    }

    public void ClickCliente(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_agregarCliente));
        lnk_agregarCliente.click();
    }

    public void ClickAddCustomer(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_agregarCustomer));
        lnk_agregarCustomer.click();
    }
}
