package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {
    private int count = 0;

    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        if (count == 0) {
            count++;
            return super.doDamage() * 3;
        } else {
            count++;
            return super.doDamage();
        }
    }
}
