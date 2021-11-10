/**
 * Extends HashTable.java. Finishes abstract methods
 * so that HashTable.java may be used with a double
 * hashing function.
 * @param <T> Generic that determines what data type to use.
 * @author Sawyer Ball
 */
public class DoubleHashing<T> extends HashTable<T>{

    public DoubleHashing(int size) {
        super(size);
    }

    /**
     * Defines the abstract method in HashTable.java for
     * double hashing.
     * @param key Object that is being added to HashTable.
     * @param index Int used to find index in hashFunction.
     * @return
     */
    @Override
    public int hashFunction(T key, int index) {
        int h1 = positiveMod(key.hashCode(), Table.length);
        int h2 = 1 + positiveMod(key.hashCode(), Table.length - 2);
        return positiveMod(h1 + index * h2, Table.length);
    }
}
