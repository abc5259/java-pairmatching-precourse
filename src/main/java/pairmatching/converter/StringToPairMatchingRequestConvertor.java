package pairmatching.converter;

import pairmatching.controller.PairMatchingRequest;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class StringToPairMatchingRequestConvertor implements Converter<String, PairMatchingRequest> {
    @Override
    public PairMatchingRequest convert(String source) {
        String[] sources = source.split(",");
        if (sources.length != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        Course course = Course.findCourseByName(sources[0].trim());
        Level level = Level.findByName(sources[1].trim());
        return new PairMatchingRequest(
                course.findMission(level, sources[2].trim()),
                course
        );
    }
}
