package GamePackage;

import CurrencyPackage.DollarCurrency;
import ItemsPackage.WeaponItem;

import java.io.Serializable;

public class Game implements Serializable {

    private Hero hero;
    private DollarCurrency money;

    public Game(int hp, int attack, int dollars) {
        hero = new Hero(hp, attack);
        money = new DollarCurrency(dollars);
    }

    public int getHeroAttck() {
        return hero.getAttack();
    }

    public int getHeroHp() {
        return hero.getHp();
    }

    public void setWeapon(WeaponItem weapon) { hero.setWeapon(weapon); }

    public WeaponItem getWeapon() { return hero.getWeapon(); }

}
