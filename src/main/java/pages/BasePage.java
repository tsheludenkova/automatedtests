package pages;

import api.BaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.function.Function;

public abstract class BasePage implements BaseAPI {

    protected WebDriver driver;
//    private String title;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    protected final Function<By, ExpectedCondition<WebElement>> VISIBLE = ExpectedConditions::visibilityOfElementLocated;
    protected final Function<By, ExpectedCondition<WebElement>> CLICKABLE = ExpectedConditions::elementToBeClickable;




}
