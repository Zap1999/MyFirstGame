package GamePackage;

import java.io.*;

public class Context {

    private static Game game;
    private static File file = new File("D:\\PE\\Java\\Game\\src\\hell.machine");

    static {
        if(file.length() == 0) {
            game = new Game(100, 10, 100);
            try {
                FileOutputStream fOut = new FileOutputStream(file);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(game);
                oOut.close();
                fOut.close();
            }
            catch (Exception e) {
                System.err.println("Initial serialization failed.");
            }
        }else {
            loadGame();
        }
    }

    public static void saveGame() {
        try {
            PrintWriter pr = new PrintWriter(file);
            pr.write("");
            FileOutputStream fOut = new FileOutputStream(file);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(game);
        }
        catch (IOException e) {
            System.err.println("Saving failed.");
        }
    }

    public static Game loadGame() {
        try {
            FileInputStream fIn = new FileInputStream(file);
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            game = (Game) oIn.readObject();
            oIn.close();
            fIn.close();
        }
        catch (Exception e) {
            System.err.println("Loading serialization failed.");
        }
        return game;
    }

    public static void updateGame(Game gm) {
        game = gm;
        saveGame();
    }



}
