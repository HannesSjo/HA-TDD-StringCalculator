import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StringCalculatorCLI {

    private final InputStream inputStream;
    private final OutputStream outputStream;

    public StringCalculatorCLI(){
        inputStream = System.in;
        outputStream = System.out;
    }

    public StringCalculatorCLI(InputStream inputStream, OutputStream outputStream){
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    public void run() {
        Scanner scanner = new Scanner(inputStream);
        PrintStream out = new PrintStream(outputStream);
        printWelcome(out);

        StringCalculator calculator = new StringCalculator();
        // Loop until the user inputs "exit"
        String input = "";
        while (true) {
            String newInput = scanner.nextLine();
            if ("exit".equalsIgnoreCase(newInput)) {
                break;
            }
            if (!newInput.isBlank()){
                input += newInput;
                continue;
            }

            input = formatInput(input);
            var result = calculator.add(input);
            out.println("The result is "+result);
            input = "";
        }

        scanner.close();
        out.println("Exiting...");

    }

    private void printWelcome(PrintStream out) {
        try {
            String welcomeMessage = "Welcome to this calculator this program shall take an input like scalc ´1,2,3 and return the result is 6";
            out.println(welcomeMessage);
        } catch (Exception e) {
            System.out.println("FAILED!");
        }
    }

    private String formatInput(String input) {
        return input.replaceAll(".*?‘(.*?)’.*", "$1").replace("\\n", "\n");
    }
}