package ItemsPackage;

import java.io.Serializable;

public class WeaponItem implements Item, Serializable {

    private String name;
    private int hpBonus;
    private int attackBonus;

    public WeaponItem(String n, int h, int a) {
        name = n;
        hpBonus = h;
        attackBonus = a;
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
