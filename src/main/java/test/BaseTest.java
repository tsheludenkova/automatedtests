package test;


import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
}
