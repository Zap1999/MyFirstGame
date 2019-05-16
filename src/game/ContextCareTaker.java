package game;

import java.io.*;
import java.util.Date;
import java.util.TreeMap;

public class ContextCareTaker {

    private static TreeMap<Date, Context> states = new TreeMap<>();

    private static File file = new File("D:\\PE\\Java\\Game\\src\\hell.machine");

    static {
        if(file.length() == 0) {
            Game game = new Game(100, 10, 100);
            Context context = new Context(game);
            states.put(new Date(System.currentTimeMillis()),context);
            try {
                save();
            }
            catch (Exception e) {
                System.err.println("Initial serialization failed.");
            }
        }else {
            load();
        }
    }

    public static void add(Context context) {
        states.put(new Date(System.currentTimeMillis()), context);
        save();
    }

    public static Context get (int i) {
        return states.get(i);
    }

    public static Context getLast() {
        return states.get(states.lastKey());
    }

    private static void save() {
        try {
            PrintWriter pr = new PrintWriter(file);
            pr.write("");
            FileOutputStream fOut = new FileOutputStream(file);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(states);
        }
        catch (IOException e) {
            System.err.println("Saving failed.");
            e.printStackTrace();
        }
    }

    private static void load() {
        try {
            FileInputStream fIn = new FileInputStream(file);
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            states = (TreeMap<Date, Context>) oIn.readObject();
            oIn.close();
            fIn.close();
        }
        catch (Exception e) {
            System.err.println("Loading serialization failed.");
        }
    }


}
