package OriginGame.Items;

public class Equip {
    private Sword sword;
    private Plate plate;

    public Equip(Sword sword, Plate plate) {
        this.sword = sword;
        this.plate = plate;
    }

    public int getSumAttackPower(){
        return sword.attackPower + plate.attackPower;
    }
    public int getSumHP(){
        return sword.hp + plate.hp;
    }
    public int getSumMana(){
        return sword.mana + plate.mana;
    }
    public int getSumDefence(){
        return sword.defence + plate.defence;
    }

    @Override
    public String toString() {
        return "" +
                "SWORD: " + sword +
                " PLATE: " + plate;
    }

    public Sword getSword() {
        return sword;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }
}
