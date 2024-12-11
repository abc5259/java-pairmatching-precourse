package pairmatching.controller;


import java.util.List;
import pairmatching.domain.Answer;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatching;
import pairmatching.view.Menu;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public PairMatchingController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process(List<Crew> backendCrews, List<Crew> frontendCrews) {
        Menu menu;
        while ((menu = iteratorInputHandler.inputMenu()) != Menu.QUIT) {
            if (menu == Menu.MATCHING) {
                PairMatchingRequest pairMatchingRequest = iteratorInputHandler.inputPairMatchMission();
                Course course = pairMatchingRequest.course();
                Mission mission = pairMatchingRequest.mission();
                matchingPairs(backendCrews, frontendCrews, course, mission);
                outputView.printMatchingPairs(mission.getCurrentPairs());
            }
        }
    }

    private void matchingPairs(List<Crew> backendCrews, List<Crew> frontendCrews, Course course, Mission mission) {
        try {
            if (course == Course.BACKEND) {
                matchingPairs(backendCrews, mission);
            }
            if (course == Course.FRONTEND) {
                matchingPairs(frontendCrews, mission);
            }
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
        }
    }

    private void matchingPairs(List<Crew> crews, Mission mission) {
        if (mission.hasPairs()) {
            Answer answer = iteratorInputHandler.inputRetryPairMatchingAnswer();
            if (answer == Answer.YES) {
                mission.matchingPairs(new PairMatching(crews));
            }
            return;
        }
        mission.matchingPairs(new PairMatching(crews));
    }
}
