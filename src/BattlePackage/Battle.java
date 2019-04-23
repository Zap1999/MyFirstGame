package BattlePackage;

public interface Battle {

    boolean isHeroDead();
    boolean isEnemyDead();
    int getHeroHp();
    int getHeroAttack();
    int getEnemyHp();
    int getEnemyAttack();
    int getEnemyAgility();
    int getAgilCounter();
    int getEnemyCount();
    String getIcon();
    String getName();
    void performAttack();
    void setDifficulty(char difficulty);
    void setBoss(boolean boss);
    void setEnemyCount(int count);
    void setEnemy(Enemy enemy);
    void init();
    void setEnemy();

}
