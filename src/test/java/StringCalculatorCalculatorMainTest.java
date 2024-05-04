import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

public class StringCalculatorCalculatorMainTest {

    @Test
    public void testWelcomeMessage(){
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        String testCommands = "exit";

        ByteArrayInputStream mockInput = new ByteArrayInputStream(testCommands.getBytes());
        StringCalculatorCLI cli = new StringCalculatorCLI(mockInput, mockOutput);
        cli.run();


        String expected = "Welcome to this calculator this program shall take an input like scalc ´1,2,3 and return the result is 6";
        assert mockOutput.toString().contains(expected);
    }

    @Test
    public void testScalcString() {
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        String testCommands = "scalc ‘1,2,3’\n";
        testCommands += "exit";

        ByteArrayInputStream mockInput = new ByteArrayInputStream(testCommands.getBytes());
        StringCalculatorCLI cli = new StringCalculatorCLI(mockInput, mockOutput);
        cli.run();

        String expected = "The result is 6";
        assert mockOutput.toString().contains(expected);
    }

    @Test
    public void testMultiLineInputs() {
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        String testCommands = "scalc ‘1,\n";
        testCommands += "2,\n";
        testCommands += "3’\n";
        testCommands += "\n";
        testCommands += "exit\n";

        ByteArrayInputStream mockInput = new ByteArrayInputStream(testCommands.getBytes());
        StringCalculatorCLI cli = new StringCalculatorCLI(mockInput, mockOutput);
        cli.run();

        String expected = "The result is 6";
        assert mockOutput.toString().contains(expected);
    }

    @Test
    public void testComplexInputs() {
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        String testCommands = "scalc ‘//[***][%%%]\n" + "\\n1***2%%%4’\n";
        testCommands += "\n";
        testCommands += "exit\n";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(testCommands.getBytes());
        StringCalculatorCLI cli = new StringCalculatorCLI(mockInput, mockOutput);
        cli.run();

        String expected = "The result is 7";
        assert mockOutput.toString().contains(expected);
    }
}
