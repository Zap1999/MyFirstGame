package EnemyPackage;

import java.util.concurrent.ThreadLocalRandom;

public class EnemyBoss implements Enemy {
    private int hp;
    private int attack;
    private String icon;
    private String name;
    private int agility = 0;

    public EnemyBoss(int lvl){

        if(lvl == 1) {
            hp = 100;
            attack = 10;
        }else if(lvl == 2) {
            hp = 1000;
            attack = 100;
        }else if(lvl == 3) {
            hp = 10000;
            attack = 1000;
        }else if(lvl == 4) {
            hp = 100000;
            attack = 10000;
        }

        randomizeIcon();
        randomizeName();
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHp() {
        return hp;
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

    public void randomizeName() {
        name = EnemyNames.randomName().toString();
    }

    public void randomizeIcon() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
        icon = "\\img\\boss" + randomNum + ".png";
    }
}
