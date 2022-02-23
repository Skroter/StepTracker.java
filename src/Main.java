import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуй");
        System.out.println("Я приложение StepTracker");
        System.out.println("Я могу:");

        boolean test = false;

        while (test == false) {
            printMenu();

            if (scanner.hasNextInt()) {

                int userInput = scanner.nextInt();

                if (userInput == 1) {
                    while (test == false) {
                        System.out.println("Введите дату :");
                        System.out.println("День (1-30)");
                        if (scanner.hasNextInt()) {
                            int day = scanner.nextInt();
                            System.out.println("Месяц (1-12)");
                            if (scanner.hasNextInt()) {
                                int month = scanner.nextInt();
                                if (day > 0 && day < 31 && month > 0 && month < 13) {
                                    System.out.println("Cколько шагов вы прошли ?");
                                    if (scanner.hasNextInt()) {
                                        int stepDay = scanner.nextInt();
                                        if (stepDay == 0 || stepDay > 0) {
                                            stepTracker.enteringTheNumberOfSteps(day, stepDay, month);
                                            break;
                                        } else {
                                            System.out.println("Вы ввели не правильное значение шагов.");

                                            break;
                                        }
                                    } else {
                                        System.out.println("Вы ввели не правильное значение шагов.");
                                        scanner.next();
                                    }
                                }
                            } else {
                                System.out.println("Вы ввели не правильное значение даты.");
                                scanner.next();
                            }
                        } else {
                            System.out.println("Вы ввели не правильное значение даты.");
                            scanner.next();
                        }
                    }
                } else if (userInput == 2) {
                    while (test == false) {
                        System.out.println("За какой месяц вас интерисует информация?");
                        System.out.println("(1-12)");
                        if (scanner.hasNextInt()) {
                            int month = scanner.nextInt();
                            stepTracker.outputStepEverydayFormonth(month); // Количество пройденных шагов по дням в следующем формате
                            stepTracker.outputSumStepFormonth(month); // Общее количество шагов за месяц;
                            stepTracker.outputMaxStepFormonth(month); // Максимальное пройденное количество шагов в месяце;
                            stepTracker.outputMidStepFotmonth(month); // Среднее количество шагов
                            stepTracker.outputDistanceFormonth(month); // Пройденная дистанция
                            stepTracker.outputKallFormonth(month); // Количество сожжённых килокалорий;
                            stepTracker.outputBestSerieceFormonth(month); // Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.
                            break;
                        } else {
                            System.out.println("Вы ввели не правильное значение даты.");
                            scanner.next();
                        }
                    }
                } else if (userInput == 3) { // Изменение колличество шагов за день
                    System.out.println("Введите новую норму шагов в день:");
                    int stepForDay = scanner.nextInt();
                    stepTracker.changeGoalStepsPerDay(stepForDay);
                } else if (userInput == 4) {
                    System.out.println("Выход");
                    scanner.close();
                    break;
                } else if (userInput != 1 || userInput != 2 || userInput != 3 || userInput != 4) {
                    System.out.println("Такого пункта нет!!!");
                }
            } else {
                System.out.println("Введено недопустимое значение. Введите чило из списка.");
                scanner.nextLine();
            }
        }
    }

    private static void printMenu() { // Этот метод печатает варианты взаимодействия с программой.
        System.out.println(" ");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выход.");
    }
}
