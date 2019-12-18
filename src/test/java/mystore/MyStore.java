package mystore;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountPage;
import pages.MainPage;
import test.BaseGUITest;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static pages.AccountPage.Buttons.*;


public class MyStore extends BaseGUITest {


    @Test
    public void openMainPageTestWithTitleAndUrlAvailable() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue("MainPage wasn't loaded", mainPage.mainPageIsLoaded());
    }


    @Test
    public void openMainPageTest() {
        //act
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "My Store";
        //assert
        Assert.assertEquals(
                String.format("Actual string %s wasn't equal to expected'%s'", expectedTitle, actualTitle),
                expectedTitle,
                actualTitle);
    }

    @Rule
    public ErrorCollector collector = new ErrorCollector() {
    };

    @Test
    public void searchTest() {
        //act
        WebElement searchField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("search_query_top")));
        searchField.sendKeys("Dress");

        WebElement lookupField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name("submit_search")));
        lookupField.click();

        List<WebElement> elements = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class=\"product-container\"]/div//*[@class=\"product-name\"]")));

        System.out.println("Number of elements:" + elements.size());
        String expectedTitleValue = "Dress";
        for (int i = 0; i < elements.size(); i++) {
            System.out.println("Name of product: " + elements.get(i).getAttribute("title"));
            String actualTitleValue = elements.get(i).getAttribute("title");
            collector.checkThat("should match", actualTitleValue, CoreMatchers.containsString(expectedTitleValue));
        }
    }


    @Test
    public void discountCalculationTest() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        final String queryText = "Dress";
        mainPage.searchFor(queryText);
        mainPage.clickOnSearchBtn();
        mainPage.clickOnFirstProductOnThePage();
        mainPage.getProductPrice();
        System.out.println("product-price: " + mainPage.getProductPrice());
        mainPage.getDiscount();
        System.out.println("product-discount: " + mainPage.getDiscount());
        mainPage.getOldProductPrice();
        System.out.println("old product price: " + mainPage.getOldProductPrice());

        String str1 = mainPage.getOldProductPrice();
        str1 = str1.replaceAll("[^\\d.]", "");
        System.out.println(str1);
        double i = Double.parseDouble(str1);
        System.out.println(i);

        String str2 = mainPage.getDiscount();
        str2 = str2.replaceAll("[^\\d.]", "");
        System.out.println(str2);
        double j = Double.parseDouble(str2);
        System.out.println(j);

        String str3 = mainPage.getProductPrice();
        str3 = str3.replaceAll("[^\\d.]", "");
        System.out.println(str3);
        double k = Double.parseDouble(str3);
        System.out.println(k);


        double actualResult = i-(i/100)*j;


        double expectedResult =k;

        System.out.println(actualResult);
        System.out.println(expectedResult);
        Assert.assertEquals(actualResult,expectedResult,0.005);





        Thread.sleep(5000);

    }

    @Test
    public void createAnAccountTest() throws InterruptedException {
        WebElement signInButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")));
        signInButton.click();
        WebElement emailAddressInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("email_create")));
        emailAddressInput.sendKeys("autopractice.com@gmail.com");
        // password = AUTOpractice
        WebElement createAnAccountButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitCreate")));
        createAnAccountButton.click();
        WebElement genderRadioButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("uniform-id_gender1")));
        genderRadioButton.click();
        WebElement firstNameInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));
        firstNameInput.sendKeys("Brad");
        WebElement lastNameInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_lastname")));
        lastNameInput.sendKeys("Pitt");
        WebElement passwordInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("passwd")));
        passwordInput.sendKeys("AUTOpractice");
        WebElement addressInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("address1")));
        addressInput.sendKeys("Los Angeles, sunset boulevard");
        WebElement cityInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("city")));
        cityInput.sendKeys("Los Angeles");
        WebElement stateInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("id_state")));
        stateInput.click();
        WebElement stateSelect = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id_state\"]/option[6]")));
        stateSelect.click();
        WebElement zipInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postcode")));
        zipInput.sendKeys("90210");

        WebElement countryInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("id_country")));
        countryInput.click();
        WebElement countrySelect = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id_country\"]/option[@value=\"21\"]")));
        countrySelect.click();
        WebElement mobilePhoneSelect = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("phone_mobile")));
        mobilePhoneSelect.sendKeys("+1 213 675 12 39");
        WebElement addressAlias = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("alias")));
        addressAlias.clear();
        addressAlias.sendKeys("autopractice.com");
        WebElement registerButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("submitAccount")));
        registerButton.click();

        Thread.sleep(5000);
    }

    @Test
    public void signInTest() {

    }

    @Test
    public void verifyTipRefreshing_WithPageObject() {
// arrange
        MainPage mainPage = new MainPage(driver);
        final String firstQueryText = "Dress";
        final String secondQueryText = "T-shirt";

        mainPage.searchFor(firstQueryText);
// act
        mainPage.searchFor(secondQueryText);
// assertion
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(mainPage.firstTip, secondQueryText));
        String secondTipText = mainPage.firstTip.getText();
// and not(contains(text(), 'Dress'))
        Assert.assertThat(secondTipText, CoreMatchers.containsString(secondQueryText));
    }


    @Test
    public void dashboardCheckOrderHistoryAndDetailsTest() {
        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        final String emailAddress = "autopractice.com@gmail.com";
        final String password = "AUTOpractice";

        final String expectedOrderPageTitle = "Order history";

        mainPage.signIn(emailAddress, password);

        accountPage.navigateTo(ORDER_HISTORY_AND_DETAILS);
        String actualTitle1 = accountPage.getPageTitle();
        System.out.println(actualTitle1);
        collector.checkThat("should match", actualTitle1, CoreMatchers.containsString(expectedOrderPageTitle));

    }

    @Test
    public void dashboardCheckMyCreditSlipsTest() {
        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        final String emailAddress = "autopractice.com@gmail.com";
        final String password = "AUTOpractice";

        final String expectedCreditSlipsPageTitle = "Order slip";
        mainPage.signIn(emailAddress, password);

        accountPage.navigateTo(MY_CREDIT_SLIPS);
        String actualTitle2 = driver.getTitle();
        System.out.println(actualTitle2);
        collector.checkThat("should match", actualTitle2, CoreMatchers.containsString(expectedCreditSlipsPageTitle));
    }

    @Test
    public void dashboardCheckMyAddressesTest() {
        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        final String emailAddress = "autopractice.com@gmail.com";
        final String password = "AUTOpractice";

        final String expectedMyAddressesPageTitle = "Addresses";


        mainPage.signIn(emailAddress, password);

        accountPage.navigateTo(MY_HOME_ADDRESSES);
        String actualTitle3 = driver.getTitle();
        System.out.println(actualTitle3);
        collector.checkThat("should match", actualTitle3, CoreMatchers.containsString(expectedMyAddressesPageTitle));

    }

    @Test
    public void dashboardCheckMyPersonalInformationTest() {
        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        final String emailAddress = "autopractice.com@gmail.com";
        final String password = "AUTOpractice";


        final String expectedYourPersonalInformationTitle = "Identity";

        mainPage.signIn(emailAddress, password);

        accountPage.navigateTo(MY_PERSONAL_INFORMATION);
        String actualTitle4 = driver.getTitle();
        System.out.println(actualTitle4);
        collector.checkThat("should match", actualTitle4, CoreMatchers.containsString(expectedYourPersonalInformationTitle));
    }

    @Test
    public void dashboardCheckMyWishlistsTest() {
        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        final String emailAddress = "autopractice.com@gmail.com";
        final String password = "AUTOpractice";

        final String expectedMyWishlistsTitle = "My Store";


        mainPage.signIn(emailAddress, password);

        accountPage.navigateTo(MY_WISHLISTS);
        String actualTitle5 = driver.getTitle();
        System.out.println(actualTitle5);
        collector.checkThat("should match", actualTitle5, CoreMatchers.containsString(expectedMyWishlistsTitle));

    }
    @Test
    public void verifyFirstTipBecomesOverAfterClickOnArrowDown() {
        MainPage mainPage = new MainPage(driver);
        final String queryText = "Dress";
        mainPage.searchFor(queryText);
        String firstTipText = mainPage.firstTip.getText();
        //Assert.assertThat(firstTipText, CoreMatchers.containsString())


    }



}
