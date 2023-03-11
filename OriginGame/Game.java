package OriginGame;

import java.util.Scanner;

import static OriginGame.Colors.*;
import static OriginGame.Visual.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(red() + "              Console Fight! \n created by 7paranoid with StrayUglyDog\n\n" + reset());
        ControlInfo();
        Character vadim = new Character(NickName(""));
        while (true) {
            vadim = startGame(vadim, new Character(EnemyName(), vadim.getLvl(), ParametersFactory.randomEquip(vadim.getLvl())));
        }
    }

    public static Character startGame(Character player, Character enemy) {
        System.out.println(player + "\n" + enemy + "\n");
        int choice = ParametersFactory.validateInt("      YOUR TURN:" + red() + "\n1 - FIGHT" + blue() + " 2 - HEALING" + reset());
        if (choice == 1) {
            player.hit(enemy);
            if (enemy.myHP() <= 0) {
                System.out.println(green() + "     YOU WON!" + reset());
                player.loot(enemy);
                System.out.println(player);
                return player;
            }
        } else if (choice == 2) {
            player.healing();
        } else if (choice == 3) { // меню опций
            System.out.println("    Settings menu: \n1 - rename your person \n2 - info \n3 - reload game \n4 - close game \n5 - exit");
            int menu = ParametersFactory.validateInt("");
            if (menu == 1) { // поменять никнэйм
                NickName("");
            }
            if (menu == 2) { // вывести инфу о индикации
                ControlInfo();
                startGame(player, enemy);
            }
            if (menu == 3) { // перезагрузка игры
                startGame(player, enemy);
            }
            if (menu == 4) { // выход из игры
                System.exit(0);
            }
            if (menu == 5) { // выход из меню
                startGame(player, enemy);
            }
        }
        enemy.hit(player);
        if (player.myHP() <= 0) {
            System.out.println(red() + "♰ YOU LOSE, YOUR OPPONENT KILLED YOU ♰" + reset());
            System.exit(0);
        }
        return startGame(player, enemy);
    }
}