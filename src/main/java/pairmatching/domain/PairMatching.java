package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PairMatching {
    private static final int MAX_TRY_COUNT = 3;

    private final List<Crew> crews;

    public PairMatching(List<Crew> crews) {
        this.crews = crews;
    }

    public List<Pair> matching(PairHistories pairHistories) {
        List<Crew> shuffleCrews = Randoms.shuffle(crews);

        List<Pair> pairs = null;
        boolean isOk = false;
        int count = 0;
        while (!isOk && count < MAX_TRY_COUNT) {
            pairs = new ArrayList<>();
            if (shuffleCrews.size() % 2 == 0) {
                isOk = createEvenPairs(pairHistories, shuffleCrews, pairs);
            }
            if (shuffleCrews.size() % 2 != 0) {
                isOk = createOddPairs(pairHistories, shuffleCrews, pairs);
            }
            count++;
        }

        if (!isOk) {
            throw new IllegalArgumentException("페어 매칭에 실패했습니다.");
        }

        return pairs;
    }

    private boolean createEvenPairs(PairHistories pairHistories, List<Crew> shuffleCrews, List<Pair> pairs) {
        for (int i = 0; i < shuffleCrews.size(); i += 2) {
            Pair pair = new Pair(new ArrayList<>(List.of(shuffleCrews.get(i), shuffleCrews.get(i + 1))));
            if (pairHistories.contains(pair)) {
                return false;
            }
            pairs.add(pair);
        }
        return true;
    }

    private boolean createOddPairs(PairHistories pairHistories, List<Crew> shuffleCrews, List<Pair> pairs) {
        for (int i = 0; i < shuffleCrews.size() - 3; i += 2) {
            Pair pair = new Pair(new ArrayList<>(List.of(shuffleCrews.get(i), shuffleCrews.get(i + 1))));
            if (pairHistories.contains(pair)) {
                return false;
            }
            pairs.add(pair);
        }

        Pair pair = new Pair(
                new ArrayList<>(
                        List.of(
                                shuffleCrews.get(shuffleCrews.size() - 3),
                                shuffleCrews.get(shuffleCrews.size() - 2),
                                shuffleCrews.get(shuffleCrews.size() - 1)
                        )
                )
        );
        if (pairHistories.contains(pair)) {
            return false;
        }
        pairs.add(pair);

        return true;
    }
}
