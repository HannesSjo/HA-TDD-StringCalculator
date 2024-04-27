import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
        if (input.isBlank()) return 0;

        List<String> delimiters = new ArrayList<>();
        delimiters.add("\n");
        delimiters.add(",");
        delimiters.add(" ");

        if (input.startsWith("//")){
            int startIndex = input.indexOf("//") + 2;
            int endIndex = input.indexOf("\n");
            String delimiter = input.substring(startIndex, endIndex);
            delimiters.add(delimiter);
            input = input.substring(endIndex + 1);
        }

        StringBuilder regexBuilder = new StringBuilder("[");
        for (String delimiter : delimiters) {
            regexBuilder.append(delimiter);
        }
        regexBuilder.append("]");

        String[] numbersArray = input.split(regexBuilder.toString());
        int sum = 0;
        for (String num : numbersArray) {
            int intNum = Integer.parseInt(num);
            if (intNum < 0) throw new IllegalArgumentException("Negatives not allowed " + intNum);
            sum += intNum;
        }
        return sum;
    }
}
