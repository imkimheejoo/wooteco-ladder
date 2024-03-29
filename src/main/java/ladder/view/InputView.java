package ladder.view;

import ladder.domain.GameResult;
import ladder.domain.Height;
import ladder.domain.Person;
import ladder.domain.Result;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String FIND_RESULT_NAME_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Person inputNames() {
        try {
            System.out.println(INPUT_NAME_MESSAGE);
            String inputName = SCANNER.nextLine();
            return new Person(inputName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputNames();
        }
    }

    public static Height inputHeight() {
        try {
            System.out.println(INPUT_HEIGHT_MESSAGE);
            return new Height(Integer.parseInt(SCANNER.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputHeight();
        }

    }

    public static Result inputResultAll(Person person) {
        try {
            System.out.println(INPUT_RESULT_MESSAGE);
            String results = SCANNER.nextLine();
            return new Result(results, person);
        } catch (IllegalArgumentException e) {
            return inputResultAll(person);
        }
    }

    public static String findResultName(GameResult gameResult, Person person) {
        try {
            System.out.println(FIND_RESULT_NAME_MESSAGE);
            String requestedName = SCANNER.nextLine();
            return gameResult.getGameResult(requestedName, person);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return findResultName(gameResult, person);
        }
    }
}
