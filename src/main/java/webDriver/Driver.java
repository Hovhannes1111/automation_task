package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

@UtilityClass
@Log4j
public class Driver {

    private WebDriver webDriver;

    public void createDriver(final String browserType) {
        switch (browserType) {
            case "firefox":
                createFirefoxDriver();
                break;
            case "opera":
                createOperaDriver();
                break;
            case "edge":
                createEdgeDriver();
                break;
            case "chrome":
            default:
                createChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    private void createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        log.trace("Firefox diver created successfully.");
    }

    private void createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        log.trace("Chrome diver created successfully.");
    }

    private void createOperaDriver() {
        WebDriverManager.operadriver().setup();
        webDriver = new OperaDriver();
        log.trace("Opera diver created successfully.");
    }

    private void createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        webDriver = new EdgeDriver();
        log.trace("Edge diver created successfully.");
    }
}