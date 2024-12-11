package pairmatching.domain;

import java.util.HashSet;
import java.util.List;

public class Mission {
    private final String name;
    private final PairHistories pairHistories;
    private List<Pair> currentPairs;

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

    public boolean hasPairs() {
        return this.currentPairs != null;
    }

    public void matchingPairs(PairMatching pairMatching) {
        List<Pair> pairs = pairMatching.matching(pairHistories);
        pairHistories.addAll(pairs);
        currentPairs = pairs;
    }

    public List<Pair> getCurrentPairs() {
        return currentPairs;
    }

    public void resetPairs() {
        this.currentPairs = null;
    }
}
