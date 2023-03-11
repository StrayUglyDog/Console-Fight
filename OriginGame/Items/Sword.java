package OriginGame.Items;

import static OriginGame.Colors.*;

public class Sword extends Item{
    public Sword(String name, int hp, int attackPower, int mana, int defence) {
        super(name, hp, attackPower, mana, defence);
    }

    @Override
    public String toString() {
        return "❝" + name + "❞" +
                " | "+green()+"❤" + hp +
                " "+red()+"⚡" + attackPower +
                " "+blue()+"☮" + mana +
                " "+gray()+"✠" + defence + reset() + " |";
    }
}
