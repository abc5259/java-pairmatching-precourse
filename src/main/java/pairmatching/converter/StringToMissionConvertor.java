package pairmatching.converter;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class StringToMissionConvertor implements Converter<String, Mission> {
    @Override
    public Mission convert(String source) {
        String[] sources = source.split(",");
        if (sources.length != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        Course course = Course.findCourseByName(sources[0].trim());
        Level level = Level.findByName(sources[1].trim());
        return course.findMission(level, sources[2].trim());
    }
}
