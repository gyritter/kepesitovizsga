package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit{

    private boolean shield=true;
    public Swordsman(boolean armour) {
        super(100, 10, armour);
    }

    @Override
    public void sufferDamage(int damage) {
        System.out.println(hitPoints);
        if (shield){
            shield=false;
            return;
        }
        this.hitPoints-=damage;
        System.out.println(hitPoints);
    }
}
