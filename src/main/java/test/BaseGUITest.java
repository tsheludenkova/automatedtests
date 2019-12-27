package test;

import api.BaseAPI;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import test.BaseTest;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.LogManager.*;

public class BaseGUITest extends BaseTest implements BaseAPI {

    protected WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tetiana.Sheludenkova\\IdeaProjects\\automatedtests\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        EventFiringWebDriver eventDriver =  new EventFiringWebDriver(driver);
        eventDriver.register(new EventHandler());
        driver = eventDriver;
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
