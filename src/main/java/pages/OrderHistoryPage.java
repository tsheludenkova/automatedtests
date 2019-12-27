package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends BasePage {
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    private By firstItemFromOrdersList = By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a");
    private By productNameFromOrderList = By.xpath("//*[@id=\"order-detail-content\"]/table/tbody/tr/td[2]/label");

    public void clickOnFirstItemOfOrdersList() {
        op(firstItemFromOrdersList, CLICKABLE).click();
    }

    public String getProductNameFromOrdersList() {

            return op(productNameFromOrderList, VISIBLE).getText();

    }





}
