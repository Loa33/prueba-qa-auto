package org.example.driver;
import org.example.constants.Timeouts;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class DriverFactory {

    private DriverFactory(){
    }

    private static WebDriver webDriver;
    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void setDriver(String browser) throws Exception {
        if (webDriver != null)
            throw new Exception("El WebDriver ya está inicializado");
        webDriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeouts.WAIT_PAGE_LOAD));
    }

    public static void quitDriver() {
        if (webDriver != null ) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
