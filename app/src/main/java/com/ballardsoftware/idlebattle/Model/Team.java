package com.ballardsoftware.idlebattle.Model;

import com.ballardsoftware.idlebattle.Utilities.Stats;
import com.ballardsoftware.idlebattle.ViewModel.IdleViewModel;

public class Team extends AbstractModel {
    //time was income

    int bonus;
    //int level;
    //double upgradeCost;

    public Team(String name, double basePrice, int level,
                   double upgradeCost, int bonus) {
        super(name, basePrice, level, upgradeCost);
        this.bonus = bonus;
        //this.level = level;
        //this.upgradeCost = upgradeCost;
    }

    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void upgrade(int i) {
        Double total = Stats.currentTotal.getValue();
        //int level = getLevel();
        //double upgradeCost = getUpgradeCost();
        if(total >= Double.valueOf(getUpgradeCost())) {
            //Double d = new Double(upgradeCost);

            if(getLevel() < 10) {
                total-=(getUpgradeCost());
                Stats.currentTotal.setValue(total);
                //upgradeCost *= 5;
                setUpgradeCost(getUpgradeCost() * 5);
                setLevel(getLevel()+1);


                //if(level > 1) {
                bonus+=10;
                //IdleViewModel.weaponsArray[i].setIncome(
                  //      IdleViewModel.weaponsArray[i].getIncome() * bonus);
                IdleViewModel.weaponsArray[i].calculateIncrease(1);
                //setIncome(getIncome() * bonus);
                //}
                //IdleViewModel.weaponsArray.level++;
            }
        }
    }
}
