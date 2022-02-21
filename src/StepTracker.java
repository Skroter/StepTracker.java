import java.util.HashMap;

public class StepTracker {
    HashMap <Integer, int[]> year;
    int StepForDay = 10000;
    int dayForMounth = 30;

    StepTracker (){
        year = new HashMap<>();
    }

    void EnteringTheNumberOfSteps(int day, int stepDay, int mounth) {
        if (year.containsKey(mounth)){
            int[] MounthTest = year.get(mounth);
            for (int i = 0; i < MounthTest.length; i++){
                if (i+1 != day){
                    MounthTest[day - 1] = stepDay;
                    year.put(mounth, MounthTest);
                    System.out.println("В " + mounth + " месяце добавлен показатель " + stepDay + " за " + day + " день.");
                } else {
                    System.out.println("За этот день показания уже введены!!!");
                    break;
                }   break;
            }
        } else {
            int[] MounthTest = new int[dayForMounth];
            MounthTest[day - 1] = stepDay;
            year.put(mounth, MounthTest);
            System.out.println("Месяц " + mounth + " добавлен с показателем " + stepDay + " в " + day + " день.");
        }
    }

    void StatisticsForTheMonth(int mounth) {
        Converter converter = new Converter();
        System.out.println("Подробная статистика за месяц " + mounth);
        System.out.println("Шаги за каждый день:");
        for (Integer mounthScanner : year.keySet()) {
            int[] MounthTest = year.get(mounth);
            if (mounth == mounthScanner) { // шаги за каждый день
                for (int i = 0; i < MounthTest.length; i++) {
                    if (year.get(mounth)[i] > 0) {
                        System.out.println((i + 1) + " день: " + year.get(mounth)[i] + " ");
                    } else {
                        System.out.print((i + 1) + " день: " + 0 + " ");
                    }
                }
            } else {
                System.out.println("Такого месяца не сохранено!");
            }
            int sumStep = 0; // общее колличество шагов за месяц
            for (int i = 0; i < MounthTest.length; i++) {
                sumStep += MounthTest[i];
            }
            System.out.println("Всего щагов за месяц: " + sumStep);
            int maxStep = 0; // максимально чило шагов в день
            for (int i = 0; i < MounthTest.length; i++) {
                if (MounthTest[i] > maxStep) {
                    maxStep = MounthTest[i];
                }
            }
            System.out.println("Максимальное чисто шагов за день в месяце " + maxStep);
            System.out.println("Среднее колличество шагов в день за месяц:" + sumStep/MounthTest.length); // среднее колличество шагов
            System.out.println("Пройденная дистанция в км: " + sumStep*converter.km); // пройденная дистанция в км за месяц
            System.out.println("Подтрачено каллорий за месяц: " + sumStep*converter.kall); // потрачено калорий за месяц
            int bestSeries = 0;
            int bestSeries1 = 0;
            for (int i = 0; i < MounthTest.length; i++) {
                if (MounthTest[i] >= StepForDay){
                    bestSeries += 1;
                    if(bestSeries>bestSeries1){
                        bestSeries1 = bestSeries;
                    }
                } else {
                    bestSeries = 0;
                }
            }
            System.out.println("Лучшая серия шагов за месяц составила " + bestSeries1 + " дня.");
            break;
        }
    }

    void GoalStepsPerDay (int stepForDay){ // Номер для вызова в главном меня 3. Этот метод ставит цель в виде колличества шагов пройденных за день
        if (stepForDay >= 0){
            StepForDay = stepForDay;
            System.out.println("Теперь колличество шагов за день = " + stepForDay);
        } else {
            System.out.println("Введено отрицательное число. Это недоупустимо!!!");
        }
    }

    void Anecdote () { // Номер для вызова в главном меня 17. Рассказывает анекдот
        System.out.println("Лежат Василий Иванович и Петька ночью в чистом поле. Василий Иванович спрашивает:");
        System.out.println(" - Вот что ты видишь Петька?");
        System.out.println(" - Звезды Васили Иванович");
        System.out.println(" - Дурак ты Петька, у нас полатку с***дили!!!");
    }
}
