package enemy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EnemyNames {

    Mark, Larry, John,
    James, Andrew, Matthew,
    Carl, Mike, Peep,
    Simon, Rob, Jeffery;

    private static final List<EnemyNames> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static EnemyNames randomName()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
