package pairmatching.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomShuffleStrategy implements ShuffleStrategy {
    @Override
    public List<String> shuffle(List<String> names) {
        return Randoms.shuffle(names);
    }
}
