package Examples;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.BaseTest;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitsTest extends BaseTest {

    WebDriver driver;

    @Before
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tetiana.Sheludenkova\\IdeaProjects\\automatedtests\\src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

    }

    @After
    public void afterEach() {

        driver.quit();
        driver = null;
    }

    @Test
    public void verifyFirstTip() {
        String queryText = "Dress";
        driver.findElement(By.id("search_query_top")).sendKeys(queryText);
        driver.findElement(By.id("search_query_top")).click();
        String firstTipTExt = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"))
                .getText();
                Assert.assertThat(firstTipTExt, CoreMatchers.containsString(queryText));
    }
    @Test
    public void verifyFirstTipRefreshing() {
        String firstQueryText = "Dress";
        String secondQueryText = "T-shirt";
        driver.findElement(By.id("search_query_top")).sendKeys(firstQueryText);
        driver.findElement(By.id("search_query_top")).click();

        String firstTipText = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"))
                .getText();

        driver.findElement(By.id("search_query_top")).sendKeys(firstQueryText);
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).clear();
        String secondTipText = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"))
                .getText();


        Assert.assertThat(secondTipText, CoreMatchers.containsString(secondQueryText));


    }

}
