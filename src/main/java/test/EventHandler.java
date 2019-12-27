package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Arrays;


public class EventHandler extends AbstractWebDriverEventListener {

    private static final Logger LOG = LogManager.getLogger(EventHandler.class);


    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        super.beforeNavigateTo(url, driver);
      //  System.out.println("WebDriver navigated to " + url);
        LOG.info("WebDriver navigated to {}" , url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        if(element == null) {
            LOG.debug("Finding element {}", by);
        }
        else {
            LOG.debug("Finding element {} within root {}", by, getElementLocator(element));
        }

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
        LOG.debug("Going to click on the element {}", getElementLocator(element));
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.beforeChangeValueOf(element, driver, keysToSend);
        LOG.debug("Going to set value" + Arrays.toString(keysToSend) + "for element" + getElementLocator(element));
    }

    private String getElementLocator(WebElement element) {
        String elDescription = element.toString();
        int descriptionLength = elDescription.length();
        int startIndex = elDescription.indexOf("-> ") + 3;
        return "by " + elDescription.substring(startIndex, descriptionLength-1);
    }

}
