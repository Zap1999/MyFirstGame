package ItemsPackage;

import java.io.Serializable;

public class WeaponItem implements Item, Serializable {

    private String name;
    private int hpBonus;
    private int attackBonus;

    public WeaponItem(String n) {
        name = n;
        setBonuses();
    }

    private void setBonuses() {
        switch (name) {
            case "pistol":
                this.hpBonus = 0;
                this.attackBonus = 50;
                break;
            case "pp":
                this.hpBonus = 10;
                this.attackBonus = 75;
                break;
            case "rifle":
                this.hpBonus = 20;
                this.attackBonus = 100;
                break;
            case "minigun":
                this.hpBonus = 30;
                this.attackBonus = 125;
                break;
            case "bazuka":
                this.hpBonus = 40;
                this.attackBonus = 150;
                break;
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
