package GamePackage;

public class ContextOriginator {

    private static Game game;

    public static void setState(Game state) {
        game = state;
    }

    public static Game getCurrentState() {
        return game;
    }

    public static Context saveState() {
        return new Context(game);
    }

    public static void loadState(Context state) {
        game = state.getState();
    }

}
