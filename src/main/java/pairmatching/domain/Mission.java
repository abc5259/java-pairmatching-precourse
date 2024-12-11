package pairmatching.domain;

import java.util.HashSet;
import java.util.List;

public class Mission {
    private final String name;
    private final PairHistories pairHistories;
    private final List<Pair> currentPairs;

    public Mission(String name, PairHistories pairHistories, List<Pair> currentPairs) {
        this.name = name;
        this.pairHistories = pairHistories;
        this.currentPairs = currentPairs;
    }

    public Mission(String name) {
        this(name, new PairHistories(new HashSet<>()), null);
    }

    public boolean isEqualName(String missionName) {
        return this.name.equals(missionName);
    }
}
