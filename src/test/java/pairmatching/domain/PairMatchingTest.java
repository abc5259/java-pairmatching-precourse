package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.strategy.ShuffleStrategy;

class PairMatchingTest {

    @Test
    void 페어를_메칭한다() {
        //given
        List<String> names = List.of("재훈", "기훈", "도도", "새", "밥", "우리");
        List<Crew> crews = names.stream().map(name -> new Crew(Course.BACKEND, name)).toList();
        ShuffleStrategy fixShuffleStrategy = new ShuffleStrategy() {
            @Override
            public List<String> shuffle(List<String> names) {
                return names;
            }
        };
        PairHistories pairHistories = new PairHistories(new HashSet<>());
        PairMatching pairMatching = new PairMatching(crews);

        //when
        List<Pair> pairs = pairMatching.matching(pairHistories, fixShuffleStrategy);

        //then
        Assertions.assertThat(pairs).hasSize(3)
                .isEqualTo(
                        List.of(
                                new Pair(
                                        new ArrayList<>(
                                                List.of(
                                                        new Crew(Course.BACKEND, "재훈"),
                                                        new Crew(Course.BACKEND, "기훈")))
                                ),
                                new Pair(
                                        new ArrayList<>(
                                                List.of(
                                                        new Crew(Course.BACKEND, "도도"),
                                                        new Crew(Course.BACKEND, "새")))
                                ),
                                new Pair(
                                        new ArrayList<>(
                                                List.of(
                                                        new Crew(Course.BACKEND, "밥"),
                                                        new Crew(Course.BACKEND, "우리")))
                                )
                        )
                );
    }

    @Test
    void 페어매칭이_3번_실패하면_예외가_발생한다() {
        //given
        List<String> names = List.of("재훈", "기훈", "도도", "새", "밥", "우리");
        List<Crew> crews = names.stream().map(name -> new Crew(Course.BACKEND, name)).toList();
        ShuffleStrategy fixShuffleStrategy = new ShuffleStrategy() {
            @Override
            public List<String> shuffle(List<String> names) {
                return names;
            }
        };
        PairHistories pairHistories = new PairHistories(
                Set.of(
                        new Pair(
                                new ArrayList<>(
                                        List.of(
                                                new Crew(Course.BACKEND, "재훈"),
                                                new Crew(Course.BACKEND, "기훈")))
                        ),
                        new Pair(
                                new ArrayList<>(
                                        List.of(
                                                new Crew(Course.BACKEND, "도도"),
                                                new Crew(Course.BACKEND, "새")))
                        ),
                        new Pair(
                                new ArrayList<>(
                                        List.of(
                                                new Crew(Course.BACKEND, "밥"),
                                                new Crew(Course.BACKEND, "우리")))
                        )
                )
        );
        PairMatching pairMatching = new PairMatching(crews);

        //when //then
        Assertions.assertThatThrownBy(() -> pairMatching.matching(pairHistories, fixShuffleStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("페어 매칭에 실패했습니다.");
    }
}