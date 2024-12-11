package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.Menu;

public class IteratorInputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }

    public Menu inputMenu() {
        return iteratorInputTemplate.execute(
                inputView::inputMenu,
                Menu::findMenu
        );
    }
}
