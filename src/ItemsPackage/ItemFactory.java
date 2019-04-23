package ItemsPackage;

public class ItemFactory {

    // TODO: needs refactoring (test version)
    public static Item getItem (String type, String name) {
        if(type.equalsIgnoreCase("WEAPON")) {
            return new WeaponItem("Exhaust", 100, 100);
        }
        else {
            return new WeaponItem("Exhaust", 100, 100);
        }
    }

}
