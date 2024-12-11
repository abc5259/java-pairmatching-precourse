package pairmatching;

import java.util.List;
import pairmatching.controller.PairMatchingController;
import pairmatching.domain.Crew;

public class Application {
    public static void main(String[] args) {
        PariMatchingConfig pariMatchingConfig = new PariMatchingConfig();
        List<Crew> backendCrews = pariMatchingConfig.backendCrewInit().init();
        List<Crew> frontendCrews = pariMatchingConfig.frontendCrewInit().init();
        PairMatchingController pairMatchingController = pariMatchingConfig.pairMatchingController();
        pairMatchingController.process(backendCrews, frontendCrews);
    }
}
