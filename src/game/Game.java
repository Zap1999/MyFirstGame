package game;

import currency.DollarCurrency;
import items.BodyItem;
import items.WeaponItem;

import java.io.Serializable;

public class Game implements Serializable {

    private int port = -1;
    private String name = "admin";
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

    public void setWeapon(WeaponItem item) { hero.setWeapon(item); }

    public void setBody(BodyItem item) { hero.setBody(item); }

    public WeaponItem getWeapon() { return hero.getWeapon(); }

    public BodyItem getBody() { return hero.getBody(); }

    public String getViewPath() { return hero.getViewPath(); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
