package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army {

    private List<MilitaryUnit> militaryUnits = new ArrayList<>();


    public void addUnit(MilitaryUnit militaryUnit) {
        militaryUnits.add(militaryUnit);
    }

    public void damageAll(int damage) {

        for (MilitaryUnit m : militaryUnits) {

            m.sufferDamage(damage);

        }

        removeMilitaryUnit();

    }

    private void removeMilitaryUnit(){
        Iterator<MilitaryUnit> it = militaryUnits.iterator();
        while (it.hasNext()) {
            MilitaryUnit m = it.next();
            if (m.doDamage() < 25) {
                it.remove();
            }
        }
    }


    public int getArmyDamage() {
        int sum = 0;
        for (MilitaryUnit m : militaryUnits) {

            sum += m.doDamage();
        }
        return sum;
    }

    public int getArmySize() {

        return militaryUnits.size();
    }
}
