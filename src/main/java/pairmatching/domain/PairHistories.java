package pairmatching.domain;

import java.util.Set;

public class PairHistories {
    private final Set<Pair> pairHistory;

    public PairHistories(Set<Pair> pairHistory) {
        this.pairHistory = pairHistory;
    }

    public boolean contains(Pair pair) {
        return pairHistory.contains(pair);
    }
}
