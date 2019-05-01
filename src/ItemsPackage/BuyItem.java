package ItemsPackage;

import GamePackage.Context;
import GamePackage.Game;

public class BuyItem {

    public static boolean buy(String type, String name) {
        Game game = Context.loadGame();
        if (type.equalsIgnoreCase("WEAPON")) {
            if ((game.getWeapon() == null) || (!(game.getWeapon().getName().equalsIgnoreCase(name)))) {
                game.setWeapon((WeaponItem) ItemFactory.getItem(type, name));
                Context.updateGame(game);
                return true;
            }
            else {
                return false;
            }
        }
        else if (type.equalsIgnoreCase("BODY")) {
            if ((game.getBody() == null) || (!(game.getBody().getName().equalsIgnoreCase(name)))) {
                game.setBody((BodyItem) ItemFactory.getItem(type, name));
                Context.updateGame(game);
                return true;
            }
            else {
                return false;
            }
        }
        else return false;
    }

}
