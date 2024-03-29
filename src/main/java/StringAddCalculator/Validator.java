package StringAddCalculator;

import java.util.List;

public class Validator {
    static String checkEmpty(String input) {
        if (input == null || input.length() == 0) {
            input = "0";
        }
        return input;
    }

    static boolean checkLastIndex(char lastValue, List<String> splitters) {
        return splitters.contains(Character.toString(lastValue));
    }

    static boolean matchCustomSplitter(String input) {
        return input.matches("//.*\\n.*");
    }

    static int checkNegativeValue(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
