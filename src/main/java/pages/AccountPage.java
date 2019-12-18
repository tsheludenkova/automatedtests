package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/a[2]")
    public WebElement myAccountButton;

    public void clickOnMyAccountButton(){
        myAccountButton.click();

    }

    public void navigateTo(Buttons button) {
        driver.findElement(button.getXpath()).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public enum Buttons {
        ORDER_HISTORY_AND_DETAILS("Order history and details"),
        MY_CREDIT_SLIPS("My credit slips"),
        MY_HOME_ADDRESSES("My addresses"),
        MY_PERSONAL_INFORMATION("My personal information"),
        MY_WISHLISTS("My wishlists");

        Buttons(String visibleText) {
            this.visibleText = visibleText;
        }

        private final String visibleText;

        protected By getXpath() {
            return By.xpath(String.format("//span[text()='%s']", visibleText));
        }
    }

}