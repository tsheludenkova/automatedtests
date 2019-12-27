package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    private By proceedToCheckoutButtonStep1 = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
    private By proceedToCheckoutButtonStep3 = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");
    private By proceedToCheckoutButtonStep4 = By.xpath("//*[@id=\"form\"]/p/button/span");
    private By payByBankWireButton = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    private By confirmOrderButton = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
    private By backToOrdersButton = By.xpath("//*[@id=\"center_column\"]/p/a");

     @FindBy(id = "cgv")
     public WebElement checkboxAboutTermsOfService;

    public void clickOnProceedToCheckoutButtonStep1() {
        op(proceedToCheckoutButtonStep1, CLICKABLE).click();
    }

    public void clickOnProceedToCheckoutButtonStep3() {
        op(proceedToCheckoutButtonStep3, CLICKABLE).click();
    }

    public void setCheckboxAboutTermsOfService() {
        checkboxAboutTermsOfService.click();
    }

    public void clickOnProceedToCheckoutButtonStep4() {
        op(proceedToCheckoutButtonStep4, CLICKABLE).click();

    }
    public void clickOnPayByBankWire() {
        op(payByBankWireButton, CLICKABLE).click();

    }
    public void clickOnConfirmOrder() {
        op(confirmOrderButton, CLICKABLE).click();

    }

    public void backToOrders() {
        op(backToOrdersButton, CLICKABLE).click();

    }

    public void scrollDown() {
        js.executeScript("window.scrollBy(0,500)");

    }


}
