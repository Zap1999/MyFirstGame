package BattlePackage;

public abstract class BattleDecorator implements Battle {

    protected Battle decoratedBattle;

    BattleDecorator(Battle battle) {
        decoratedBattle = battle;
    }

    @Override
    public boolean isHeroDead() {
        return decoratedBattle.isHeroDead();
    }

    @Override
    public boolean isEnemyDead() {
        return decoratedBattle.isEnemyDead();
    }

    @Override
    public int getHeroHp() {
        return decoratedBattle.getHeroHp();
    }

    @Override
    public int getHeroAttack() {
        return decoratedBattle.getHeroAttack();
    }

    @Override
    public int getEnemyHp() {
        return decoratedBattle.getEnemyHp();
    }

    @Override
    public int getEnemyAttack() {
        return decoratedBattle.getEnemyAttack();
    }

    @Override
    public int getEnemyAgility() {
        return decoratedBattle.getEnemyAgility();
    }

    @Override
    public int getAgilCounter() {
        return decoratedBattle.getAgilCounter();
    }

    @Override
    public int getEnemyCount() {
        return decoratedBattle.getEnemyCount();
    }

    @Override
    public String getIcon() {
        return decoratedBattle.getIcon();
    }

    @Override
    public String getName() {
        return decoratedBattle.getName();
    }

    @Override
    public void performAttack() {
        decoratedBattle.performAttack();
    }

    @Override
    public void setDifficulty(char difficulty) {
        decoratedBattle.setDifficulty(difficulty);
    }

    @Override
    public void setBoss(boolean boss) {
        decoratedBattle.setBoss(boss);
    }

    @Override
    public void setEnemyCount(int count) {
        decoratedBattle.setEnemyCount(count);
    }

    @Override
    public void init() {
        decoratedBattle.init();
    }

    @Override
    public void setEnemy(Enemy enemy) {
        decoratedBattle.setEnemy(enemy);
    }

    @Override
    public void setEnemy() {
        decoratedBattle.setEnemy();
    }

}
