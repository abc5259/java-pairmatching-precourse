package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MENU_MESSAGE = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";

    public String inputMenu() {
        System.out.println(INPUT_MENU_MESSAGE);
        return Console.readLine();
    }
}
