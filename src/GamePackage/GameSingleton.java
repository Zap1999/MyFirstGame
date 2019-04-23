package GamePackage;

public class GameSingleton {
    private static Game single_instance = null;

    synchronized public static Game getInstance() {
        if(single_instance == null) {
            single_instance = ContextSingleton.getInstance().loadGame();
        }
        return single_instance;
    }

}
