package pairmatching.view;

import java.util.Arrays;

public enum Menu {
    MATCHING("1"), LOOK("2"), RESET("3"), QUIT("Q");

    private final String Symbol;

    Menu(String symbol) {
        Symbol = symbol;
    }

    public static Menu findMenu(String symbol) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.isEqualSymbol(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기능입니다."));
    }

    private boolean isEqualSymbol(String symbol) {
        return Symbol.equals(symbol);
    }
}
