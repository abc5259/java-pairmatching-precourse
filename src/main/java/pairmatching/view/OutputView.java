package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";
    private static final String RESET_PAIR_MESSAGE = "초기화 되었습니다.";

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }

    public void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }

    public void printMatchingPairs(List<Pair> pairs) {
        StringBuilder sb = new StringBuilder();
        pairs.forEach(pair -> {
            List<Crew> crews = pair.getOriginOrderCrews();
            String result = crews.stream()
                    .map(Crew::getName)
                    .collect(Collectors.joining(" : "));
            sb.append(result).append('\n');
        });

        System.out.println(sb);
    }

    public void printResetPairs() {
        System.out.println();
        System.out.println(RESET_PAIR_MESSAGE);
        System.out.println();
    }
}
