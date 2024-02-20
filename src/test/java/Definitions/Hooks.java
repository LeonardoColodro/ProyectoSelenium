package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Objetos partes independientes de la automatizacion
public class Hooks {
    public static WebDriver driver;

    @Before //Inicializar el proceso y conectar el driver
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //El trabajo del robot automatizado
    //Limpiar las cookies y cerrar
    @After
    public static void tearDown(){
        driver.manage().deleteAllCookies();
        //driver.close();
    }
}
