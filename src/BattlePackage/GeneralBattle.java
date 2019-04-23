package BattlePackage;

import GamePackage.Game;
import GamePackage.GameSingleton;


public class GeneralBattle implements Battle {

    private char difficulty;
    private int diff;
    private int enemyCount;
    private boolean boss;


    private Enemy enemy;
    private String enemyIcon;
    private String enemyName;

    private int heroHp;
    private int heroAttack;

    private int enemyHp;
    private int enemyAttack;
    private int enemyAgility;

    private int agilCounter;


    public GeneralBattle() {
        Game game = GameSingleton.getInstance();
        heroHp = game.getHeroHp();
        heroAttack = game.getHeroAttck();
    }

    public void init() {

        switch (difficulty) {
            case 'E': diff = 1;
            break;
            case 'M': diff = 2;
            break;
            case 'H': diff = 3;
            break;
            case 'I': diff = 4;
            break;
            default: diff = 0;
        }

        if (diff!=0) enemy = FactoryProducer.getFactory(boss).getEnemy(diff);
        setEnemy();
    }

    public void setEnemy() {
        enemyCount--;
        this.agilCounter = 0;
        this.enemyHp = enemy.getHp();
        this.enemyAttack = enemy.getAttack();
        this.enemyAgility = enemy.getAgility();
        enemy.randomizeIcon();
        enemy.randomizeName();
        this.enemyIcon = enemy.getIcon();
        this.enemyName = enemy.getName();
    }

    public void performAttack() {
        if(agilCounter != enemyAgility) {
            enemyHp -= heroAttack;
            agilCounter++;
        }
        else {
            heroHp -= enemyAttack;
            agilCounter=0;
            enemyHp -= heroAttack;
        }
    }

    public boolean isHeroDead() {
        return !(heroHp>0);
    }

    public boolean isEnemyDead() {
        if(enemyHp <= 0 && enemyCount == 0) {
            return true;
        }
        else if(enemyHp <= 0 && enemyCount > 0) {
            setEnemy();
            return false;
        }
        else {
            return false;
        }
    }

    public int getHeroHp() {
        return heroHp;
    }

    public int getHeroAttack() {
        return heroAttack;
    }

    public int getEnemyHp() {
        return enemyHp;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public int getEnemyAgility() {
        return enemyAgility;
    }

    public int getAgilCounter() {
        return enemyAgility-agilCounter;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public String getIcon() {
        return enemy.getIcon();
    }

    public  String getName() {
        return enemy.getName();
    }

    public void setDifficulty(char difficulty) {
        this.difficulty = difficulty;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public void setEnemyCount(int count) {
        this.enemyCount = count;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
