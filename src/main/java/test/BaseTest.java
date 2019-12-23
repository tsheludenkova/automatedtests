package test;


import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public abstract class BaseTest {



    @Rule
    public TestWatcher watchman= new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            super.succeeded(description);
            System.out.println(description.getDisplayName() + " successful");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
            System.out.println(description.getDisplayName() + " failed сaused by " + e.getMessage());
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            super.skipped(e, description);
            System.out.println(description.getDisplayName() + " skipped");
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
            System.out.println(description.getDisplayName() + " started");
        }
    };


    protected void assertAll(Consumer<Boolean>... assertions) {
        List<AssertionError> errors = new ArrayList<>();

        for (Consumer<Boolean> assertion : assertions) {
            try
            {
                assertion.accept( true);
            }
        catch (AssertionError ae){
                errors.add(ae);
            }
        }
        assert errors.isEmpty() :
                 errors.stream()
                .map(assertionError -> assertionError.getMessage().replace("java.lang.AssertionError:", "\n"))
                .collect(Collectors.toList())
                .toString();
    }





}
