package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class MyCustomConditions {

    public static ExpectedCondition<WebElement> attributeContains(By locator, String attr, String value) {
        return new ExpectedCondition<WebElement>() {
            private String currentValue = null;

            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                String currentValue = element.getAttribute(attr);

                if (currentValue != null && !currentValue.isEmpty() && currentValue.contains(value))
                    return element;
                else
                    return null;
            }

            public String toString() {
                return String.format("found by %s attr='%s' to contain \"%s\". Current value: \"%s\"", locator, attr, value, this.currentValue);
            }
        };
    }

    public static ExpectedCondition<String> listNthElementHasText(By locator, int elNo, String expText) {
        return new ExpectedCondition<String>() {
            private WebElement currentNumber = null;
            String currentProductName = null;

            public String apply(WebDriver webDriver) {
                List<WebElement> elements = webDriver.findElements(locator);
                String currentProductName =  elements.get(elNo).getAttribute("title");

                for (int i = 0; i < elements.size(); i++) {
                    System.out.println("№ "+ i + " : " + elements.get(i).getAttribute("title"));
                }

                System.out.println("Number of product № "+ elNo + " Name of product: " + elements.get(elNo).getAttribute("title"));
                if (currentProductName.equals(expText))
                    return currentProductName;
                else
                    return null;
            }

            public String toString() {
                return String
                        .format("Title to be \"%s\". Current title: \"%s\"", expText, currentProductName);
            }
        };
    }


    public static ExpectedCondition<Boolean> pageIsLoaded(String expTitle, String expUrl) {
        return new ExpectedCondition<Boolean>() {
            private String currentTitle = "";
            private String currentUrl = "";

            public Boolean apply(WebDriver driver) {
                this.currentTitle = driver.getTitle();
                this.currentUrl = driver.getCurrentUrl();
                Boolean isTitleCorrect = expTitle.equals(currentTitle);
                Boolean isUrlCorrect = expUrl.equals(currentUrl);

                return isTitleCorrect && isUrlCorrect;
            }

            public String toString() {
                return String.format("title to be \"%s\". Current title: \"%s\". Url to be \"%s\". Current url: \"%s\"." ,  expTitle, this.currentTitle, expUrl, this.currentUrl);
            }
        };

    }




}
