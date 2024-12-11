package pairmatching.init;

import java.nio.file.Path;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.io.FileReader;

public class FrontendCrewInit {
    private static final Path PATH = Path.of("src/main/resources/frontend-crew.md");
    private final FileReader fileReader;

    public FrontendCrewInit(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public List<Crew> init() {
        List<String> lines = fileReader.readAllLines(PATH);
        return lines.stream()
                .map(name -> new Crew(Course.FRONTEND, name.trim()))
                .toList();
    }
}
