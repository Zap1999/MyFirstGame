package enemy;

public class EnemyCollection implements Collection {

    public static final int MAX_ITEMS = 101;

    private int count = 0;

    private Enemy[] enemyList;

    public EnemyCollection() {
        enemyList = new Enemy[MAX_ITEMS];
    }

    public void add(Enemy e) throws RuntimeException {

        if(count >= MAX_ITEMS) {
            System.err.println("Enemy collection overflow.");
            throw new RuntimeException("Collection overflow");
        }
        else {
            enemyList[count] = e;
            count++;
        }

    }

    @Override
    public Iterator createIterator() {
        return new EnemyCollectionIterator(enemyList);
    }

}
