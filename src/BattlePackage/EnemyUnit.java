package BattlePackage;

import java.util.concurrent.ThreadLocalRandom;

public class EnemyUnit implements Enemy, Cloneable{

    private int hp;
    private int attack;
    private String icon;
    private String name;

    // num of player turns to perform attack
    private int agility;

    public EnemyUnit(int lvl) {
        if(lvl == 1) {
            hp = 50;
            attack = 20;
            agility = 2;
        }else if(lvl == 2) {
            hp = 100;
            attack = 15;
            agility = 2;
        }else if(lvl == 3) {
            hp = 100;
            attack = 30;
            agility = 2;
        }else if(lvl == 4) {
            hp = 100;
            attack = 30;
            agility = 1;
        }

        randomizeIcon();
        randomizeName();
    }

    public void randomizeName() {
        name = EnemyNames.randomName().toString();
    }

    public void randomizeIcon() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
        icon = "\\img\\unit" + randomNum + ".png";
    }

    public int getAgility() {
        return agility;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
