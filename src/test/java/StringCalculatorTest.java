import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyStringReturnsZero() {
        Assertions.assertEquals(0, calculator.add(""));
    }

    @Test
    public void testAddition() {
        Assertions.assertEquals(1, calculator.add("1"));
        Assertions.assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testAdditionOfManyNumber() {
        Assertions.assertEquals(2335, calculator.add("1,5,6,7,2,4,56,32,78,12,32,100,2000"));
        Assertions.assertEquals(19, calculator.add("1,5,6,7"));
    }

    @Test
    public void testUseOfLBs() {
        Assertions.assertEquals(6, calculator.add("1\n2,3"));
    }
    @Test
    public void testOfSpecialDelimiter() {
        Assertions.assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testOfNegativeValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add("2.-5"));
    }
}
