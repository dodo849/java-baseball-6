package baseball.domain;

import baseball.policy.ValidationPolicy;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballUser implements User {

    private ValidationPolicy validationPolicy;
    private List<Integer> numbers;

    public BaseballUser(ValidationPolicy validationPolicy) {
        this.validationPolicy = validationPolicy;
    }

    public void setNumbers(String userInput) {

        // TODO: validation 로직 추가
        if (!validationPolicy.hasNoDuplicateNumber(userInput)
                || !validationPolicy.isCorrectLength(userInput, 3)
                || !validationPolicy.isNumericString(userInput)
        ) {
            throw new IllegalArgumentException();
        }

        this.numbers = Stream.
                of(String.valueOf(userInput).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
