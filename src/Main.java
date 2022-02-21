import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker XXX = new StepTracker();

        System.out.println("Здравствуй");
        System.out.println(" ");
        System.out.println("Я приложение StepTracker");
        System.out.println(" ");
        System.out.println("Я могу:");


        while (true) {
            PrintMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                while (true) {
                    System.out.println("Введите дату :");
                    System.out.println("День (1-30)");
                    System.out.println("Месяц (1-12)");
                    int Day = scanner.nextInt();
                    int Mounth = scanner.nextInt();
                    if (Day > 0 && Day < 31 && Mounth > 0 && Mounth < 13) {
                        System.out.println("Cколько шагов вы прошли ?");
                        int StepDay = scanner.nextInt();
                        XXX.EnteringTheNumberOfSteps(Day, StepDay, Mounth);
                    } else {
                        System.out.println("Вы ввели не правильное значение даты.");
                    }
                    break;
                }
            } else if (userInput == 2) {
                System.out.println("За какой месяц вас интерисует информация?");
                System.out.println("(1-12)");
                int Mounth = scanner.nextInt();
                XXX.StatisticsForTheMonth(Mounth);
            } else if (userInput == 3) { // Изменение колличество шагов за день
                System.out.println("Введите новую норму шагов в день:");
                int stepForDay = scanner.nextInt();
                XXX.GoalStepsPerDay(stepForDay);
            } else if (userInput == 17) {
                XXX.Anecdote();
            } else if (userInput == 4) {
                System.out.println("Выход");
                break;
            }
        }
    }

    private static void PrintMenu() { // Этот метод печатает варианты взаимодействия с программой.
        System.out.println(" ");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выход.");
    }
}
