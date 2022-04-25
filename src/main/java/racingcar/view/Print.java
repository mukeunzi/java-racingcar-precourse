package racingcar.view;

import racingcar.domain.Car;
import racingcar.message.GameMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Print {
    private static HashMap<String, Integer> racingGameResult = new HashMap<>();
    private static int winnerDistance = 0;

    public static void printCarNameMessage() {
        System.out.println(GameMessage.inputCarNameMessage);
    }

    public static void printRoundMessage() {
        System.out.println(GameMessage.inputRoundMessage);
    }

    public static void printResultByRound(List<List<Car>> resultByRound) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < resultByRound.size(); i++) {
            printOneRound(resultByRound.get(i));
        }
    }

    public static void printOneRound(List<Car> oneRoundResult) {
        for (int i = 0; i < oneRoundResult.size(); i++) {
            Car currentCar = oneRoundResult.get(i);
            System.out.print(String.format("%s : ", currentCar.getName()));
            printDistance(currentCar.getName(), currentCar.getDistance());
            accDistance(currentCar.getName(), currentCar.getDistance());
            winnerDistance = racingGameResult.get(currentCar.getName()) > winnerDistance ? racingGameResult.get(currentCar.getName()) : winnerDistance;
        }
        System.out.println();
    }

    private static void accDistance(String carName, int distance) {
        if (!racingGameResult.containsKey(carName)) {
            racingGameResult.put(carName, distance);
            return;
        }

        int accDistance = racingGameResult.get(carName);
        racingGameResult.put(carName, accDistance + distance);
    }

    public static void printDistance(String carName, int currentDistance) {
        int accDistance = racingGameResult.getOrDefault(carName, 0);
        for (int i = 0; i < currentDistance + accDistance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner() {
        System.out.println(String.format("최종 우승자: %s", getWinnerNames()));
    }

    public static String getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (String carName : racingGameResult.keySet()) {
            if (isWinner(racingGameResult.get(carName))) {
                winnerNames.add(carName);
            }
        }

        return String.join(",", winnerNames);
    }

    public static boolean isWinner(int distance) {
        return distance >= winnerDistance;
    }
}
