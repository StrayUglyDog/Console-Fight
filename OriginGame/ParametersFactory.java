package OriginGame;

import OriginGame.Items.Equip;
import OriginGame.Items.Plate;
import OriginGame.Items.Sword;

import java.util.Scanner;

import static OriginGame.Visual.PlateNames;
import static OriginGame.Visual.SwordNames;

public class ParametersFactory {

    public static int validateInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        try {
            int scanInt = scanner.nextInt();
            return scanInt;
        } catch (Exception e) {
            System.out.println("Wrong value");
        }
        return validateInt(message);
    }

    public static int randomInt(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    public static int midInt(int mod) {
        int min = (int) (mod - (mod * 0.3));
        int max = (int) (mod + (mod * 0.3));
        return (int) (min + Math.random() * (max - min));
    }

    public static Equip randomEquip(int mod) {
        if (randomInt(0, 100) <= 25) {
            mod = randomInt(mod + 1, mod + 4);
            System.out.println("      ╫ Враг с мощной экипировкой ╫");
        }
        String RandomSwordName = String.valueOf(SwordNames());
        String RandomPlateName = String.valueOf(PlateNames());
        Sword sword = new Sword(RandomSwordName, midInt(mod), midInt(mod), midInt(mod), midInt(mod));
        Plate plate = new Plate(RandomPlateName, midInt(mod), midInt(mod), midInt(mod), midInt(mod));
        return new Equip(sword, plate);
    }
}
