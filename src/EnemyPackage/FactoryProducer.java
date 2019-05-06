package EnemyPackage;

public class FactoryProducer {

    public static AbstractFactory getFactory(boolean boss) {

        if(boss) {
            return new EnemyBossFactory();
        }else  {
            return new EnemyUnitFactory();
        }

    }

}
