package api;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MyCustomConditions;

import java.util.List;
import java.util.function.Function;

public interface BaseAPI {

    WebDriver getWebDriver();

    default WebElement op(By locator, Function<By, ExpectedCondition<WebElement>> condition) {
        return waitFor(condition.apply(locator));
    }

    default WebElement $(By locator) {
        return waitFor(ExpectedConditions.presenceOfElementLocated(locator));
    }

    default WebElement $(String css) {
        return $(By.cssSelector(css));
    }

    default List<WebElement> $$(By locator) {
        return waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    default List<WebElement> $$(By locator, int number) {
        return waitFor(ExpectedConditions.numberOfElementsToBe(locator, number));
    }

    default List<WebElement> $$(By locator, int number, boolean isMoreThan) {
        return waitFor(isMoreThan ? ExpectedConditions.numberOfElementsToBeMoreThan(locator, number) :
                ExpectedConditions.numberOfElementsToBeLessThan(locator, number));
    }

    default List<WebElement> $$(String css) {
        return $$(By.cssSelector(css));
    }

    default <T> T waitFor(ExpectedCondition<T> condition, long timeout) {
        return new WebDriverWait(getWebDriver(), timeout).until(condition);
    }

    default <T> T waitFor(ExpectedCondition<T> condition) {
        return waitFor(condition, 10l);
    }

    default Boolean waitForTitleAvailable(String title, String url) {
        return waitFor(MyCustomConditions.pageIsLoaded(title, url));
    }

    default boolean verifyIsPageIsLoaded(String title, String url) {
        try{
            waitFor(MyCustomConditions.pageIsLoaded(title, url));
            return true;
        }
        catch (TimeoutException te) {
            System.out.println(this.getClass().getSimpleName() + " wasn't loaded: " + te.toString());
            return false;
        }
    }
    default String verifyListNthElementHasText(By locator, int number, String expText) {
        return waitFor(MyCustomConditions.listNthElementHasText(locator, number, expText));
    }

    default JavascriptException getJSExecutor() {
        return (JavascriptException) getWebDriver();
    }



}
