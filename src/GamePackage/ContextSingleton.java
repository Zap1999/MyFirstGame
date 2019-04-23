package GamePackage;

public class ContextSingleton {

    private static Context single_instance = null;

    public static Context getInstance() {
        if(single_instance == null) {
            single_instance = new Context();
        }
        return single_instance;
    }

}
