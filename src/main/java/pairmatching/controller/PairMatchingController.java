package pairmatching.controller;


import pairmatching.view.Menu;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public PairMatchingController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process() {
        Menu menu = iteratorInputHandler.inputMenu();
        if (menu == Menu.MATCHING) {
            iteratorInputHandler.inputMission();
        }
    }
}
