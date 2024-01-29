package PageObjetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;  // Importa la clase Duration

public class MenuPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Generate Card Number") private WebElement lnk_generarTarjeta;
    @FindBy(linkText = "Check Credit Card Limit") private WebElement lnk_checkCredit;
    public MenuPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 segundos de espera usando Duration
        PageFactory.initElements(driver, this);
    }

    public void ClickGenerarTarjeta() {
        // Espera que cargue la pagina con el wait
        wait.until(ExpectedConditions.elementToBeClickable(lnk_generarTarjeta));
        lnk_generarTarjeta.click();
    }

    public void clickCheckCredit() {
        lnk_checkCredit.click();
    }
}

/* package PageObjetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Generate Card Number") private WebElement lnk_generarTarjeta;

    public MenuPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver, 30); //30 segundos de espera
        PageFactory.initElements(driver, this);
    }

    public  void ClickGenerarTarjeta (){
        //Espera que cargue la pagina con el wait
        wait.until(ExpectedConditions.elementToBeClickable(lnk_generarTarjeta));
        lnk_generarTarjeta.click();
    }
} */