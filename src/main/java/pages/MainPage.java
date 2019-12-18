package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @CacheLookup
    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='index']/div[@class='ac_results']/ul/li[1]")
    public WebElement firstTip;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailAddressInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    public WebElement signInButtonOnForm;

    private By searchButton = By.name("submit_search");
    private By productPrice = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div/div[3]/div/div[1]/span[1]");
    private By firstProductOnThePage = By.xpath("//*[@id=\"list\"]/a/i");
    private By discountOfFirstProduct = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div/div[3]/div/div[1]/span[3]");
    private By oldProductPrice = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div/div[3]/div/div[1]/span[2]");



    public void signIn(String email, String password){
        signInButton.click();
        emailAddressInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButtonOnForm.click();


    }
    public void searchFor (String query) {
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(query);
    }

    public void clickOnSearchBtn() {
        op(searchButton, CLICKABLE).click();
    }

    public void clickOnFirstProductOnThePage() {
        op(firstProductOnThePage, CLICKABLE).click();
    }

    public String getProductPrice() {
        return op(productPrice, VISIBLE).getText();
    }

    public String getDiscount() {
        return op(discountOfFirstProduct, VISIBLE).getText();
    }
    public String getOldProductPrice() {
        return op(oldProductPrice, VISIBLE).getText();
    }

    public boolean mainPageIsLoaded() {
        return verifyIsPageIsLoaded("My Store", "http://automationpractice.com/index.php");
    }


}
