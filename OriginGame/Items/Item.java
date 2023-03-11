package OriginGame.Items;

public abstract class Item {
    public String name;
    public int hp;
    public int attackPower;
    public int mana;
    public int defence;

    public Item(String name, int hp, int attackPower, int mana, int defence) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.mana = mana;
        this.defence = defence;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", attackPower=" + attackPower +
                ", mana=" + mana +
                ", defence=" + defence +
                '}';
    }
}
