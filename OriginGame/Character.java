package OriginGame;

import OriginGame.Items.Equip;
import OriginGame.Items.Plate;
import OriginGame.Items.Sword;

import static OriginGame.Colors.*;
import static OriginGame.Visual.PlateNames;
import static OriginGame.Visual.SwordNames;

public class Character {
    private String name;
    private int maxHP = 100;
    private int currentHP;

    private int maxMana = 100;
    private int currentMana;
    private int attackPower = 5;
    private int defence = 5;
    private int lvl;

    private Equip equip;

    public Character(String name) {
        String RandomSwordName = String.valueOf(SwordNames());
        String RandomPlateName = String.valueOf(PlateNames());
        this.name = name;
        this.lvl = 1;
        this.equip = new Equip(
                new Sword(RandomSwordName, 0, 1, 0, 0),
                new Plate(RandomPlateName, 0, 0, 0, 1));
        getCorrectStats();
    }

    public Character(String name, int lvl, Equip equip) {
        this.name = name;
        this.lvl = lvl;
        this.equip = equip;
        getCorrectStats();
    }


    public void hit(Character target) {
        System.out.println(this.getName() + " пытается ударить ▷ " + target.getName());
        target.getDamage(attackPower + equip.getSumAttackPower());
    }

    public void getDamage(int damage) {
        int sumDef = defence + equip.getSumDefence();
        if (ParametersFactory.randomInt(0, 100) <= 20) {
            if (damage <= sumDef) {
                System.out.println(this.getName() + " ◁ удалось блокировать атаку!");
                return;
            } else {
                damage = damage - sumDef;
                System.out.println(this.getName() + " ◁ Смог частично блокировать атаку!");
            }
        }
        System.out.println(this.getName() + " получает урон: " + damage + "\n");
        currentHP -= damage;
    }

    public void healing() {
        int sumHP = maxHP + equip.getSumHP();
        if (currentMana >= sumHP * 0.1) {
            currentHP = (int) (currentHP + (sumHP * 0.2));
            currentMana = (int) (currentMana - sumHP * 0.1);
            if (currentHP > sumHP) {
                currentHP = sumHP;
                System.out.println("       FULL HP!\n");
            }
        } else {
            System.out.println("      NO MANA!\n");
        }
    }

    @Override
    public String toString() {
        return name + " -" + "\u001b[32m" +
                " ❤ - " + currentHP + "\u001b[34m" +
                " | ☮ - " + currentMana  + "\u001b[31m" +
                " | ⚡ - " + (attackPower + equip.getSumAttackPower()) + "\u001B[37m" +
                " | ✠ - " + (defence + +equip.getSumDefence())+ "\u001b[0m" +
                " | ★ - " + lvl +
                " | EQUIP = " + equip;
    }

    public int myHP() {
        return currentHP;
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    private void getCorrectStats() {
        maxHP += 10;
        currentHP = maxHP + equip.getSumHP();
        maxMana += 1;
        currentMana = maxMana + equip.getSumMana();
        attackPower += 1;
        defence += 1;
    }

    public int dropExp() {
        int exp = maxHP + maxMana + attackPower + defence;
        return exp;
    }

    public void loot(Character enemy) {
        if (enemy.dropExp() / 100 >= 1) {
            lvl++;
            getCorrectStats();
            System.out.println(purple()+"     NEW LVL: " + lvl + reset());
        }
        System.out.println("DROPPED A NEW SWORD: " + enemy.equip.getSword());
        int choice = ParametersFactory.validateInt(" TAKE?\n 1 - Y\n 2 - N");
        if (choice == 1) {
            equip.setSword(enemy.equip.getSword());
        }
        System.out.println("DROPPED A NEW PLATE:" + enemy.equip.getPlate());
        choice = ParametersFactory.validateInt(" TAKE?\n 1 - Y\n 2 - N");
        if (choice == 1) {
            equip.setPlate(enemy.equip.getPlate());
        }
    }
}
