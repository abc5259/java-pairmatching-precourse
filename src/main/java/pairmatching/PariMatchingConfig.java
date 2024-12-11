package pairmatching;

import pairmatching.controller.IteratorInputHandler;
import pairmatching.controller.IteratorInputTemplate;
import pairmatching.controller.PairMatchingController;
import pairmatching.init.BackendCrewInit;
import pairmatching.init.FrontendCrewInit;
import pairmatching.io.FileReader;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PariMatchingConfig {

    private FileReader fileReader;
    private BackendCrewInit backendCrewInit;
    private FrontendCrewInit frontendCrewInit;
    private InputView inputView;
    private OutputView outputView;
    private IteratorInputTemplate iteratorInputTemplate;
    private IteratorInputHandler iteratorInputHandler;
    private PairMatchingController pairMatchingController;

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public IteratorInputTemplate iteratorInputTemplate() {
        if (iteratorInputTemplate == null) {
            iteratorInputTemplate = new IteratorInputTemplate(outputView());
        }
        return iteratorInputTemplate;
    }

    public IteratorInputHandler iteratorInputHandler() {
        if (iteratorInputHandler == null) {
            iteratorInputHandler = new IteratorInputHandler(inputView(), iteratorInputTemplate());
        }
        return iteratorInputHandler;
    }

    public PairMatchingController pairMatchingController() {
        if (pairMatchingController == null) {
            pairMatchingController = new PairMatchingController(iteratorInputHandler(), outputView());
        }
        return pairMatchingController;
    }

    public FileReader fileReader() {
        if (fileReader == null) {
            fileReader = new FileReader();
        }
        return fileReader;
    }

    public BackendCrewInit backendCrewInit() {
        if (backendCrewInit == null) {
            backendCrewInit = new BackendCrewInit(fileReader());
        }
        return backendCrewInit;
    }

    public FrontendCrewInit frontendCrewInit() {
        if (frontendCrewInit == null) {
            frontendCrewInit = new FrontendCrewInit(fileReader());
        }
        return frontendCrewInit;
    }
}
