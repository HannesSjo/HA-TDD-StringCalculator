import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorCLITests {
    @Test
    public void testEmptyNumberString() {

        String input = "scalc ‘’\n\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        assertEquals("Welcome to this calculator this program shall take an input like scalc ´1,2,3 and return the result is 6\r\nThe result is 0\r\nExiting...\r\n", outputStream.toString());
    }

    @Test
    public void testEmptyNumberString2() {
        String input = "scalc ‘’\n\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertEquals("Welcome to this calculator this program shall take an input like scalc ´1,2,3 and return the result is 6\r\nThe result is 0\r\nExiting...\r\n", outputStream.toString());

    }


}