package mystore;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import pages.AccountPage;
import pages.MainPage;
import test.BaseGUITest;

import static pages.AccountPage.Buttons.*;

public class DashboardsTests extends BaseGUITest {

    MainPage mainPage;
    AccountPage accountPage;

    @Before
    public void logInToAccount() {
        mainPage = new MainPage(driver);
        accountPage = new AccountPage(driver);
        final String emailAddress = "autopractice.com@gmail.com";
        final String password = "AUTOpractice";
        mainPage.signIn(emailAddress, password);
    }

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void dashboardCheckOrderHistoryAndDetailsTest() {
        final String expectedOrderPageTitle = "Order history";

        accountPage.navigateTo(ORDER_HISTORY_AND_DETAILS);
        String actualTitle1 = accountPage.getPageTitle();
        System.out.println(actualTitle1);
        collector.checkThat("should match", actualTitle1, CoreMatchers.containsString(expectedOrderPageTitle));
    }

    @Test
    public void dashboardCheckMyCreditSlipsTest() {
        final String expectedCreditSlipsPageTitle = "Order slip";
        accountPage.navigateTo(MY_CREDIT_SLIPS);
        String actualTitle2 = driver.getTitle();
        System.out.println(actualTitle2);
        collector.checkThat("should match", actualTitle2, CoreMatchers.containsString(expectedCreditSlipsPageTitle));
    }

    @Test
    public void dashboardCheckMyAddressesTest() {
        final String expectedMyAddressesPageTitle = "Addresses";
        accountPage.navigateTo(MY_HOME_ADDRESSES);
        String actualTitle3 = driver.getTitle();
        System.out.println(actualTitle3);
        collector.checkThat("should match", actualTitle3, CoreMatchers.containsString(expectedMyAddressesPageTitle));
    }

    @Test
    public void dashboardCheckMyPersonalInformationTest() {
        final String expectedYourPersonalInformationTitle = "Identity";
        accountPage.navigateTo(MY_PERSONAL_INFORMATION);
        String actualTitle4 = driver.getTitle();
        System.out.println(actualTitle4);
        collector.checkThat("should match", actualTitle4, CoreMatchers.containsString(expectedYourPersonalInformationTitle));
    }

    @Test
    public void dashboardCheckMyWishlistsTest() {
        final String expectedMyWishlistsTitle = "My Store";
        accountPage.navigateTo(MY_WISHLISTS);
        String actualTitle5 = driver.getTitle();
        System.out.println(actualTitle5);
        collector.checkThat("should match", actualTitle5, CoreMatchers.containsString(expectedMyWishlistsTitle));
    }
}
