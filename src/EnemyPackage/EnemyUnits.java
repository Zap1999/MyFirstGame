package EnemyPackage;

import java.util.HashMap;

public class EnemyUnits implements Cloneable{

    private static HashMap<Integer, EnemyUnit> unitList = new HashMap<>();

    static {
        for (int i = 1; i <= 4; i++) {
            unitList.put(i, new EnemyUnit(i));
        }
    }

    public static EnemyUnit getUnit(int lvl) {
        return (EnemyUnit) unitList.get(lvl).clone();
    }

}
