package GamePackage;

import ItemsPackage.BodyItem;
import ItemsPackage.WeaponItem;

import java.io.Serializable;

public class Hero implements Serializable {

    private int hp;
    private int attack;
    private WeaponItem weapon = null;
    private BodyItem body = null;

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

    public void setBody(BodyItem item) {
        if (body != null) {
            hp -= body.getHpBonus();
            attack -= body.getAttackBonus();
        }
        body = item;
        hp += body.getHpBonus();
        attack += body.getAttackBonus();
    }

    public WeaponItem getWeapon() { return weapon; }

    public BodyItem getBody() {
        return body;
    }

    public String getViewPath() {
        String b = "nude";
        String w = "null";

        if (body != null) b = body.getName();
        if (weapon != null) w = weapon.getName();

        return "\\img\\" + b + "_" + w + ".jpg";
    }

}
