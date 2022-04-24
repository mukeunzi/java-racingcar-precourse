package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputCarNames() {
        Print.printCarNameMessage();
        return Console.readLine();
    }
}
