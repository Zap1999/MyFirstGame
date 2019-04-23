package BattlePackage;

public interface Enemy {

    int getAttack();
    int getHp();
    int getAgility();
    String getIcon();
    String getName();
    void randomizeIcon();
    void randomizeName();

}
