package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import pairmatching.domain.strategy.ShuffleStrategy;

class MissionTest {

    @Test
    void 페어가_현재_있는지_확인할_수_있다() {
        //given
        Mission mission = new Mission("mission", new PairHistories(new HashSet<>()), null);

        //when
        boolean result = mission.hasPairs();

        //then
        assertThat(result).isFalse();
    }

    @Test
    void 페어를_매칭한다() {
        //given
        Mission mission = new Mission("mission",
                new PairHistories(new HashSet<>()),
                null);
        List<String> names = List.of("재훈", "기훈", "도도", "새", "밥", "우리");
        List<Crew> crews = names.stream().map(name -> new Crew(Course.BACKEND, name)).toList();
        ShuffleStrategy fixShuffleStrategy = new ShuffleStrategy() {
            @Override
            public List<String> shuffle(List<String> names) {
                return names;
            }
        };
        PairMatching pairMatching = new PairMatching(crews);

        //when
        mission.matchingPairs(pairMatching, fixShuffleStrategy);

        //then
        assertThat(mission.getCurrentPairs())
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
        assertThat(mission.getPairHistories()).extracting("pairHistory")
                .isEqualTo(
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
    }

    @Test
    void 현재_페어를_초기화한다() {
        //given
        Mission mission = new Mission("mission",
                new PairHistories(Set.of(new Pair(
                        new ArrayList<>(
                                List.of(
                                        new Crew(Course.BACKEND, "재훈"),
                                        new Crew(Course.BACKEND, "기훈")))
                ))),
                List.of(new Pair(
                        new ArrayList<>(
                                List.of(
                                        new Crew(Course.BACKEND, "재훈"),
                                        new Crew(Course.BACKEND, "기훈")))
                )));

        //when
        mission.resetPairs();

        //then
        assertThat(mission.getCurrentPairs()).isNull();

    }
}