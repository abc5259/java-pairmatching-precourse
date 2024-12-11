package pairmatching.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public enum Course {
    BACKEND("백엔드",
            Map.of(
                    Level.LEVEL1, List.of(
                            new Mission("자동차경주"),
                            new Mission("로또"),
                            new Mission("숫자야구게임")),
                    Level.LEVEL2, List.of(
                            new Mission("장바구니"),
                            new Mission("결제"),
                            new Mission("지하철노선도")),
                    Level.LEVEL3, List.of(),
                    Level.LEVEL4, List.of(
                            new Mission("성능개선"),
                            new Mission("배포")
                    ),
                    Level.LEVEL5, List.of()
            )),
    FRONTEND("프론트엔드",
            Map.of(
                    Level.LEVEL1, List.of(
                            new Mission("자동차경주"),
                            new Mission("로또"),
                            new Mission("숫자야구게임")),
                    Level.LEVEL2, List.of(
                            new Mission("장바구니"),
                            new Mission("결제"),
                            new Mission("지하철노선도")),
                    Level.LEVEL3, List.of(),
                    Level.LEVEL4, List.of(
                            new Mission("성능개선"),
                            new Mission("배포")
                    ),
                    Level.LEVEL5, List.of()
            ));

    private final String name;
    private final Map<Level, List<Mission>> missionMap;

    Course(String name, Map<Level, List<Mission>> missionMap) {
        this.name = name;
        this.missionMap = missionMap;
    }

    public static Course findCourseByName(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름에 해당하는 과정이 없습니다."));
    }

    public Mission findMission(Level level, String missionName) {
        return missionMap.get(level).stream()
                .filter(mission -> mission.isEqualName(missionName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));
    }

    public static void resetPairMatching() {
        List<Collection<List<Mission>>> list = Arrays.stream(Course.values())
                .map(course -> course.missionMap.values())
                .toList();

        for (Collection<List<Mission>> lists : list) {
            resetPair(lists);
        }
    }

    private static void resetPair(Collection<List<Mission>> lists) {
        for (List<Mission> missions : lists) {
            for (Mission mission : missions) {
                mission.resetPairs();
            }
        }
    }

    private boolean isEqualName(String name) {
        return this.name.equals(name);
    }
}
