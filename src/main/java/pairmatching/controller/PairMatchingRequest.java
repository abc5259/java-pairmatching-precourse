package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Mission;

public record PairMatchingRequest(
        Mission mission,
        Course course
) {
}
