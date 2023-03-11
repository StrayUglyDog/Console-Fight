package OriginGame;

import java.util.Random;
import java.util.Scanner;

public class Visual {

    public static StringBuilder SwordNames() {
        String[] firstName = new String[]{"Супер", "Красивый", "Легендарный", "Фанастический", "Невероятный", "Бомбический"};
        String[] secondName = new String[]{"Хуй", "Экскалибур", "TURBO9000", "Топор", "Ножик", "Штырь"};
        Random random = new Random();
        int r = random.nextInt(6);
        StringBuilder Sword = new StringBuilder(firstName[r] + " " + secondName[r]);
        return Sword;
    }

    public static StringBuilder PlateNames() {
        String[] firstName = new String[]{"Старые", "Тканевые", "Крутые", "Огненные", "Железные", "Драные"};
        String[] secondName = new String[]{"штаны", "доспехи", "сапоги", "перчатки", "носки", "трусы"};
        Random random = new Random();
        int r = random.nextInt(6);
        StringBuilder Plate = new StringBuilder(firstName[r] + " " + secondName[r]);
        return Plate;
    }

    public static String EnemyName() {
        String[] Name = new String[]{"Курва", "Оля", "Нинзя", "Кабан", "Лягушка", "Моисей", "Рэпер", "Чёрт"};
        Random random = new Random();
        int r = random.nextInt(8);
        String EnemyName = (Name[r]);
        return EnemyName;
    }

    public static void ControlInfo() {
        System.out.println("      ????\n" +
                "\t ?    ?   " + "\u001b[32m" + "   ❤ - HP\n" + "\u001b[0m" +
                "         ?  \t " + "\u001b[34m" + "☮ - MANA\n" + "\u001b[0m" +
                "        ?     " + "\u001b[31m" + "   ⚡ - POWER\n" + "\u001b[0m" +
                "        ?      " + "\u001B[37m" + "  ✠ - DEFENCE\n" + "\u001b[0m" +
                "         \t\t ★ - LVL\n" +
                "        ? \n");
    }

    public static String NickName(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n     WRITE YOU NICKNAME: ");
        String Nick = sc.nextLine();
        return Nick;
    }
}
