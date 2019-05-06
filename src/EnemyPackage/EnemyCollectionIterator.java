package EnemyPackage;

public class EnemyCollectionIterator implements Iterator {

    Enemy[] enemyList;

    int position = 0;

    public EnemyCollectionIterator(Enemy[] enemies) {
        enemyList = enemies;
    }

    @Override
    public boolean hasNext() {
        if (position >= enemyList.length ||
            enemyList[position] == null)

            return false;

        else return true;
    }

    @Override
    public Object next() {
        Enemy enemy = enemyList[position];
        position++;
        return enemy;
    }

}
