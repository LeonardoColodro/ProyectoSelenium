package PageObjetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuDemoGuruPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Telecom Project") private WebElement lnk_telecom;

    public MenuDemoGuruPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 segundos de espera usando Duration
        PageFactory.initElements(driver, this);
    }

    public void ClickTelecomProyect(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_telecom));
        lnk_telecom.click();
    }
}
