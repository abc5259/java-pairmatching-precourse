package pairmatching.domain;

import static pairmatching.domain.Course.BACKEND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PairTest {

    @Test
    void 페어가_같은지_확인할_수_있다() {
        //given
        Pair pair1 = new Pair(
                new ArrayList<>(Arrays.asList(new Crew(BACKEND, "A"), new Crew(BACKEND, "B"))));
        Pair pair2 = new Pair(
                new ArrayList<>(Arrays.asList(new Crew(BACKEND, "B"), new Crew(BACKEND, "A"))));

        //when
        boolean result = pair1.equals(pair2);

        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 기존_크루_순서와_정렬된_크루_순서를_저장한다() {
        //given
        Pair pair = new Pair(
                new ArrayList<>(Arrays.asList(new Crew(BACKEND, "B"), new Crew(BACKEND, "A"))));

        //when //then
        Assertions.assertThat(pair.getOriginOrderCrews())
                .isEqualTo(List.of(new Crew(BACKEND, "B"), new Crew(BACKEND, "A")));
        Assertions.assertThat(pair.getCrews())
                .isEqualTo(List.of(new Crew(BACKEND, "A"), new Crew(BACKEND, "B")));
    }
}