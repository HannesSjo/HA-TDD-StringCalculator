import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class StringCalculatorLoggingTests {

    @Test
    public void testStringCalculatorDoesNotLogNumbersBelow1000(){
        Logger mockLogger = mock(Logger.class);
        StringCalculator calculator = new StringCalculator(mockLogger);

        calculator.add("10,20,50,70,80");
        verify(mockLogger, times(0)).log(anyInt());

        calculator.add("10,1000");
        verify(mockLogger, times(1)).log(anyInt());
    }
}