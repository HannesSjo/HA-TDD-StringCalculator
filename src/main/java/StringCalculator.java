import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private final Logger logger;

    public StringCalculator(){
        logger = new LoggerStub();
    }

    public StringCalculator(Logger logger){
        this.logger = logger;
    }

    public int add(String input) {
        if (input.isBlank()) return 0;

        List<String> delimiters = new ArrayList<>();
        delimiters.add("\n");
        delimiters.add(",");
        delimiters.add(" ");

        if (input.startsWith("//")){
            int startIndex = input.indexOf("//") + 2;
            int endIndex = input.indexOf("\n");
            String delimiterSection = input.substring(startIndex, endIndex);
            String[] customDelimiters = delimiterSection.split("\\[|\\]");
            for (String delimiter : customDelimiters) {
                if (!delimiter.isEmpty()) {
                    delimiters.add(delimiter);
                }
            }
            input = input.substring(endIndex + 1);
        }

        StringBuilder regexBuilder = new StringBuilder("[");
        for (String delimiter : delimiters) {
            regexBuilder.append(Pattern.quote(delimiter));
        }
        regexBuilder.append("]");

        String[] numbersArray = input.split(regexBuilder.toString());
        int sum = 0;
        for (String num : numbersArray) {
            if (num.isBlank()) continue;
            int intNum = Integer.parseInt(num);
            if (intNum < 0) throw new IllegalArgumentException("Negatives not allowed " + intNum);
            if (intNum >= 1000) logger.log(intNum);
            sum += intNum;
        }
        return sum;
    }
}
