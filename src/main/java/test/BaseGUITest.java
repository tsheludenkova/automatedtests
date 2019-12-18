package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.BaseTest;

import java.util.concurrent.TimeUnit;

public class BaseGUITest extends BaseTest {

    protected WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tetiana.Sheludenkova\\IdeaProjects\\automatedtests\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com");

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
