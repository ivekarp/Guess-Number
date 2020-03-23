import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void mainGame(){ // Основная логика игры
        int number, choice, chance = 5;
        Scanner input_int = new Scanner(System.in);
        System.out.println("Игра 'Угадай число от 1 до 20 '");
        Random random = new Random();
        number = random.nextInt(20) + 1;
        System.out.println("Число загадано. Угадайте число ");
        do {
            choice = input_int.nextInt();
            if (choice > number) {
                chance--;
                System.out.println("Загаданное число меньше");
                System.out.printf("Количество попыток: %d \n",chance);
            }
            else if (choice < number){
                chance--;
                System.out.println("Загаданное число больше");
                System.out.printf("Количество попыток: %d \n",chance);
            }
            else
                System.out.printf("Вы отгадали! Это число %d \n" ,number);
            if (chance == 0){
                System.out.printf("Вы проиграли! Это число %d \n",number);
            }
        } while (chance > 0 && choice != number);
        RestartGame();
    }

    public static void RestartGame(){ // Новая игра
        char sw;
        Scanner input_char = new Scanner(System.in);
        System.out.println("Хотите сыграть ещё? (y/n) ");
        sw = input_char.next().charAt(0);
        switch (sw){
            case 'y':
                mainGame();
                break;
            case 'n':
                System.exit(0);
                break;
            default:
                System.out.println("Ошибка! Неправильный символ \n");
                RestartGame();
        }
    }

    public static void main(String[] args) {
        mainGame();
    }
}
