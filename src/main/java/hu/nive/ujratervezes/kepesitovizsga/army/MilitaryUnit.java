package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {
protected int hitPoints;
protected int damage;
protected boolean armour;

    public MilitaryUnit(int hitPoints, int damage, boolean armour) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.armour = armour;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int doDamage() {
        return damage;
    }

    public boolean isArmour() {
        return armour;
    }


    public void sufferDamage(int damage) {
        if (armour) {
            hitPoints -= damage/2;
        } else hitPoints -= damage;
    }
}
