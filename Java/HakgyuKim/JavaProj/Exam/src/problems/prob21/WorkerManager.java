package problems.prob21;

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class WorkerManager {
    final private int RAISE_MIN = 1;
    final private int RAISE_MAX = 50;
    final List<Worker> workerList;


    public WorkerManager() {
        workerList = new ArrayList<>();
        workerList.add(new Worker("범수"));
        workerList.add(new Worker("나얼"));
        workerList.add(new Worker("효신"));
        workerList.add(new Worker("이수"));
    }

    private void raiseIncome() {
        for (int i = 0; i < workerList.size(); i++) {
            int raiseRate = CustomRandom.generateNumber(RAISE_MIN, RAISE_MAX);
            workerList.get(i).setIncome(calculateRaise(workerList.get(i).getIncome(), raiseRate));
        }
    }

    private int calculateRaise (int income, int raiseRate) {
        int newIncome;
        float rateCalculator = raiseRate * 0.01f;
        newIncome = income + (int)(rateCalculator * income);

        return newIncome;
    }

    public void getWorkerIncomeByYear (int yearsLater) {
        for (int i = 0; i <= yearsLater; i++) {
            raiseIncome();
        }
        for (int i = 0; i < workerList.size(); i++) {
            System.out.println(workerList.get(i).getName() + "의 연봉이 " + yearsLater +
                     "년 후 " + workerList.get(i).getIncome() + "원 이 됩니다.");
        }
    }
}
