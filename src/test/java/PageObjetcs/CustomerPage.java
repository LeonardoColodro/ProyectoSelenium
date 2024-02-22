package PageObjetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage {
    private WebDriver driver;
    private WebDriverWait wait;
    protected static String customer;
    @FindBy(tagName = "h3")
    private WebElement lbl_customer;
    @FindBy(xpath = "//a[@class='button']")
    private WebElement btn_home;

    public CustomerPage(WebDriver d) {
        driver = d;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 segundos de espera usando Duration
        PageFactory.initElements(driver, this);
    }

    public void CapturarCustomer() {
        wait.until(ExpectedConditions.visibilityOf(lbl_customer));
        customer=lbl_customer.getText();
    }

    public void ClickEnviar() {
        btn_home.click();
    }
}
