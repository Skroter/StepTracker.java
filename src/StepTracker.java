import java.util.HashMap;

public class StepTracker {
    private HashMap<Integer, int[]> year;
    private int stepForDay = 10_000;
    private int dayForMonth = 30;
    private int sumStep = 0;

    StepTracker() {
        year = new HashMap<>();
    }

    void enteringTheNumberOfSteps(int day, int stepDay, int month) { // if (monthArray[day - 1] == 0)
        if (year.containsKey(month)) {
            int[] monthArray = year.get(month);
            for (int i = 0; i < monthArray.length; i++) {
                if (monthArray[day - 1] == i) {
                    monthArray[day - 1] = stepDay;
                    year.put(month, monthArray);
                    System.out.println("В " + month + " месяце добавлен показатель "
                            + stepDay + " за " + day + " день.");
                    break;
                } else {
                    System.out.println("За этот день показания уже введены!!!");
                    break;
                }
            }
        } else {
            int[] monthArray = new int[dayForMonth];
            monthArray[day - 1] = stepDay;
            year.put(month, monthArray);
            System.out.println("Месяц " + month + " добавлен с показателем " + stepDay + " в " + day + " день.");
        }
    }

    void outputStepEverydayFormonth(int month) {
        while (true) {
            for (Integer monthScanner : year.keySet()) {
                int[] monthArray = year.get(month);
                if (month == monthScanner) {
                    System.out.println("Подробная статистика за месяц " + month);
                    System.out.println("Шаги за каждый день:");
                    for (int i = 0; i < monthArray.length; i++) {
                        if (year.get(month)[i] > 0) {
                            System.out.print((i + 1) + " день: " + year.get(month)[i]);
                            if (year.get(month)[i] != 30) {
                                System.out.print(", ");
                            }
                        } else {
                            System.out.print((i + 1) + " день: " + 0);
                            if (year.get(month)[i] != 30) {
                                System.out.print(", ");
                            }
                        }
                    }
                }
            }
            System.out.println("Такого месяца нет!");
            break;
        }
    }

    int outputSumStepFormonth(int month) {
        for (Integer monthScanner : year.keySet()) {
            int[] monthArray = year.get(month);
            if (month == monthScanner) {
                for (int i = 0; i < monthArray.length; i++) {
                    sumStep += monthArray[i];
                }
                System.out.println("Всего щагов за месяц: " + sumStep);
            }
        }
        return sumStep;
    }
    /*Тебе же передали месяц, зачем в цикле перебирать все месяцы, можно сразу взять нужный месяц их HashMap следующим
    образом: int[] days = year.get(mounth);.
    Далее делаем цикл по дням, чтобы просуммировать количество шагов в каждом дне, вот так:

            for (int steps: days ) {
                sumStep += steps;
            }

        НАДО ИСПРАВИТЬ

    Если сделать так как вы написали, то при отсутствии такого месяца в базе данных (потмоу что мы к примеру не бегали в
    этом месяце) программа выдаст ошибку.*/

    void outputMaxStepFormonth(int month) {
        for (Integer monthScanner : year.keySet()) {
            int[] monthArray = year.get(month);
            if (month == monthScanner) {
                int maxStep = 0;
                for (int i = 0; i < monthArray.length; i++) {
                    if (monthArray[i] > maxStep) {
                        maxStep = monthArray[i];
                    }
                }
                System.out.println("Максимальное пройденное количество шагов в этом месяце: " + maxStep);
                break;
            }
            break;
        }
    }

    void outputMidStepFotmonth(int month) {
        for (Integer monthScanner : year.keySet()) {
            int[] monthArray = year.get(month);
            if (month == monthScanner) {
                System.out.println("Среднее колличество шагов в день за месяц: " + sumStep / monthArray.length);
            }
            break;
        }
    }

    void outputDistanceFormonth(int month) {
        for (Integer monthScanner : year.keySet()) {
            if (monthScanner == month) {
                Converter converter = new Converter();
                System.out.println("Пройденная дистанция в км: " + String.format("%.2f", sumStep
                        * converter.convertedKm()));
            }
            break;
        }
    }

    void outputKallFormonth(int month) {
        for (Integer monthScanner : year.keySet()) {
            if (monthScanner == month) {
                Converter converter = new Converter();
                System.out.println("Подтрачено каллорий за месяц: "
                        + String.format("%.2f", sumStep * converter.convertedkCall()));
            }
            break;
        }
    }

    void outputBestSerieceFormonth(int month) {
        for (Integer monthScanner : year.keySet()) {
            int[] monthArray = year.get(month);
            if (month == monthScanner) {
                int bestSeries = 0;
                int bestSeries1 = 0;
                for (int i = 0; i < monthArray.length; i++) {
                    if (monthArray[i] >= stepForDay) {
                        bestSeries += 1;
                        if (bestSeries > bestSeries1) {
                            bestSeries1 = bestSeries;
                        }
                    } else {
                        bestSeries = 0;
                    }
                }
                System.out.println("Лучшая серия шагов за месяц составила " + bestSeries1 + " дня.");
                break;
            }
            break;
        }
    }

    void changeGoalStepsPerDay(int stepForDay) {
        if (stepForDay >= 0) {
            this.stepForDay = stepForDay;
            System.out.println("Теперь колличество шагов за день = " + stepForDay);
        } else {
            System.out.println("Введено отрицательное число. Это недоупустимо!!!");
        }
    }
}
