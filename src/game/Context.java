package game;

import java.io.Serializable;

// Memento
public class Context implements Serializable {

    private final Game game;

    public Context (Game game) {
        this.game = game;
    }

    public Game getState() {
        return game;
    }

}
