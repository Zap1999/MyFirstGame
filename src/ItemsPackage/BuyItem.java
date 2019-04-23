package ItemsPackage;

import GamePackage.Context;
import GamePackage.Game;

public class BuyItem {

    public static boolean buy(String type, String name) {
        Game game = Context.loadGame();
        if (game.getWeapon() == null) {
            game.setWeapon((WeaponItem) ItemFactory.getItem(type, name));
            Context.updateGame(game);
            return true;
        }
        else if (!(game.getWeapon().getName().equalsIgnoreCase(name))) {
            game.setWeapon((WeaponItem) ItemFactory.getItem(type, name));
            Context.updateGame(game);
            return true;
        }
        else {
            return false;
        }
    }

}
