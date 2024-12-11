package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static Level findByName(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름에 해당하는 레벨이 없습니다."));
    }

    private boolean isEqualName(String name) {
        return this.name.equals(name);
    }
}
