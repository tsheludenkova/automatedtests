package testcategories;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.BaseTest;

public class VerifySumCalculation extends BaseTest {
    @Test
    @Category(ObjectDataTest.class)
    public void checkObjectData() {
        final String text = "Lorem" + " ipsum";
        Assert.assertThat(text, CoreMatchers.containsString("Lorem ipsum"));
    }

    @Test
    @Category(PrimitiveDataTest.class)
    public void checkPrimitiveData() {
        int a = 1;
        int b = 2;
        int c = a + b;
        Assert.assertThat("Indefine", 3, CoreMatchers.is(c));
    }

}
