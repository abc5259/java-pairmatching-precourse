package pairmatching.domain;

import java.util.Arrays;

public enum Answer {
    YES("네"), NO("아니요");

    private final String symbol;

    Answer(String symbol) {
        this.symbol = symbol;
    }

    public static Answer findBySymbol(String symbol) {
        return Arrays.stream(Answer.values())
                .filter(answer -> answer.isEqualSymbol(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
    }

    private boolean isEqualSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }
}
