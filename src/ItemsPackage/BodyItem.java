package ItemsPackage;

import java.io.Serializable;

public class BodyItem implements Item, Serializable {

    private String name;
    private int hpBonus;
    private int attackBonus;

    public BodyItem(String n) {
        name = n;
        setBonuses();
    }

    private void setBonuses() {
        switch (name) {
            case "boston":
                this.hpBonus = 50;
                this.attackBonus = 100;
                break;
            case "street":
                this.hpBonus = 70;
                this.attackBonus = 130;
                break;
            case "bonn":
                this.hpBonus = 90;
                this.attackBonus = 160;
                break;
            case "spectr":
                this.hpBonus = 120;
                this.attackBonus = 190;
                break;
            case "predator":
                this.hpBonus = 100000;
                this.attackBonus = 100000;
                break;
                default:
                    this.attackBonus = 0;
                    this.hpBonus = 0;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHpBonus() {
        return hpBonus;
    }

    @Override
    public int getAttackBonus() {
        return attackBonus;
    }
}
