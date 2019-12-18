package Examples;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import test.BaseTest;

import static org.hamcrest.core.Is.is;

public class MyFirstTestSuiteTest extends BaseTest {

    @BeforeClass
    public static void suiteSetUp() {
        System.out.println("Suite pre-condition");
    }

    @AfterClass
    public static void suiteTearDown() {
        System.out.println("Suite post-condition");
    }
    @Before
    public void beforeEach() {
        System.out.println("Precondition for each test");
    }

    @After
    public void afterEach() {
        System.out.println("Post-condition for each test");
    }


    @Test
    public void firstTest() {
        //arrange
        //act
        //assert
        Assert.assertTrue("Some page wasn't open",false);
    }
    @Test
    public void secondTest() {
        //arrange
        String expected = "Hello";
        String actual = "Hello";
        String expected2 = "lorem";
        String actual2 = "loremipsum";
        //act
        //assert
        Assert.assertEquals(
                String.format(" Actual string %s wasn't equal to expected '%s'",expected, actual),
                expected,
                actual
        );
        Assert.assertEquals(
                String.format(" Actual string %s wasn't equal to expected '%s'",expected2, actual2),
                expected,
                actual
        );

    }


    @Test
    @Ignore
    public void fourthTest() {
        //arrange
        String expectedPart = "Hello";
        String actual = "Hello1";
        //act
        //assert
        Assert.assertTrue(actual.contains(expectedPart));
    }

    @Test
    public void fifthTest() {
        //arrange
        String expectedPart = "Hello1";
        String actual = "Hello";
        //act
        //assert
        Assert.assertThat(actual, CoreMatchers.containsString(expectedPart));
    }

    @Test(timeout = 1000L)
    public void timeoutTest() throws InterruptedException {
        //arrange
        //act
        Thread.sleep(1500);
        //assert

    }

    @Test(expected = ArithmeticException.class)
    public void exceptionTest() {
        //arrange
        //act
         int a = 5/0;
        //assert
    }



    @Rule
    public ErrorCollector collector = new ErrorCollector() {
    };

    @Test
    public void collectorTest() {
        //arrange
        String expectedPart = "Hello";
        String actual = "Hello1";
        String expectedPart2 = "lorem";
        String actual2 = "loremipsum";
        //act
        //assert
        collector.checkThat("should match", actual, is(expectedPart));
        collector.checkThat("should match", actual2, is(expectedPart2));
    }
}

