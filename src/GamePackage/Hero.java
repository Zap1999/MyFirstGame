package GamePackage;

import ItemsPackage.WeaponItem;

import java.io.Serializable;

public class Hero implements Serializable {

    private int hp;
    private int attack;
    private WeaponItem weapon = null;

    public Hero(int hp, int attack) {
        this.attack = attack;
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public void setWeapon(WeaponItem item) {
        if (weapon != null) {
            hp -= weapon.getHpBonus();
            attack -= weapon.getAttackBonus();
        }
        weapon = item;
        hp += weapon.getHpBonus();
        attack += weapon.getAttackBonus();
    }

    public WeaponItem getWeapon() { return weapon; }

}
