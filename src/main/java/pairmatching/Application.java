package pairmatching;

import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.init.BackendCrewInit;
import pairmatching.init.FrontendCrewInit;
import pairmatching.io.FileReader;

public class Application {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        BackendCrewInit backendCrewInit = new BackendCrewInit(fileReader);
        FrontendCrewInit frontendCrewInit = new FrontendCrewInit(fileReader);

        List<Crew> backendCrews = backendCrewInit.init();
        List<Crew> frontendCrews = frontendCrewInit.init();
    }
}
