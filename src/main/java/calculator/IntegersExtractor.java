package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class IntegersExtractor {

    public static final String NORMAL_DELIMITER = "[,:]";

    public List<Integer> extractIntegers(String inputValue) {
        String delimiter = getDelimiter(inputValue);
        String numberString = removeDelimiterDeclaration(inputValue);
        List<Integer> numbers = splitNumberString(numberString, delimiter);
        return Collections.emptyList();
    }

    private String getDelimiter(String inputValue) {
        int firstCustomDelimiterIndex = inputValue.indexOf("//");
        int secondCustomDelimiterIndex = inputValue.indexOf("\\n");

        if (isNotCustomDelimiter(firstCustomDelimiterIndex)) {
            return NORMAL_DELIMITER;
        }

        if (firstCustomDelimiterIndex >= secondCustomDelimiterIndex) {
            throw new IllegalArgumentException("잘못된 입력입니다. 커스텀 구분자는 //와 \\n 사이에 위치해야 합니다.");
        }

        return getCustomDelimiter(inputValue, firstCustomDelimiterIndex, secondCustomDelimiterIndex);
    }

    private boolean isNotCustomDelimiter(int firstCustomDelimiterIndex) {
        return firstCustomDelimiterIndex == -1;
    }

    private String getCustomDelimiter(String inputValue, int firstCustomDelimiter, int secondCustomDelimiter) {
        return Pattern.quote(inputValue.substring(firstCustomDelimiter + 2, secondCustomDelimiter));
    }

    private String removeDelimiterDeclaration(String inputValue) {
        int newLineIndex = inputValue.indexOf("\\n");
        return newLineIndex != -1 ? inputValue.substring(newLineIndex + 2) : inputValue;
    }

    private List<Integer> splitNumberString(String inputValue, String delimiter) {
        try {
            return Arrays.stream(inputValue.split(delimiter))
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 구분자 사이에는 숫자만 입력되어야 합니다.");
        }
    }
}
